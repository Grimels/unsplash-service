# STEP 1: build JAR files
FROM maven:3.8.4-openjdk-17 as build
ENV HOME=/usr/app
RUN mkdir -p $HOME
WORKDIR $HOME
ADD pom.xml $HOME
RUN mvn verify --fail-never
ADD . $HOME
RUN mvn package -DskipTests=true

# STEP 2: start JARs
FROM azul/zulu-openjdk:17
RUN addgroup -S image_admin && adduser -S image_admin -G image_admin
USER image_admin:image_admin
COPY --from=build /usr/app/api/target/image-service-*.jar /app/image-service-api.jar
COPY --from=build /usr/app/persistence/target/image-service-*.jar /app/image-service-persistence.jar
COPY --from=build /usr/app/app/target/image-service-*.jar /app/image-service-app.jar
CMD ["echo", "$JAVA_HOME"]
ENTRYPOINT ["java","-jar","/app/image-service-app.jar"]