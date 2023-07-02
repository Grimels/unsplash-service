package com.grimels.image.config;

import com.grimels.image.ImageServiceImpl;
import com.grimels.image.UserServiceImpl;
import com.grimels.image.api.ImageService;
import com.grimels.image.api.UserService;
import com.grimels.image.persistence.repository.FavoriteImageRepository;
import com.grimels.image.service.FavoriteImageService;
import com.grimels.image.service.FavoriteImageServiceImpl;
import com.grimels.image.service.UnsplashService;
import com.grimels.image.service.UnsplashServiceImpl;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
@EnableConfigurationProperties
@EnableJpaRepositories(basePackages = {"com.grimels.image.persistence.repository"})
@EntityScan(basePackages = {"com.grimels.image.persistence.entity"})
public class ImageServiceConfig {

    @Bean
    @ConfigurationProperties(prefix = "unsplash.api")
    public UnsplashCredentials unsplashCredentials() {
        return new UnsplashCredentials();
    }

    @Bean
    public WebClient unsplashClient(UnsplashCredentials credentials) {
        return WebClient.builder()
                .baseUrl(credentials.getUrl())
                .defaultHeader("Accept-Version", "v1")
                .defaultHeader("Authorization", String.format("Client-ID %s", credentials.getAccessKey()))
                .build();
    }

    @Bean
    public UnsplashService unsplashService(WebClient unsplashClient, FavoriteImageService favoriteImageService) {
        return new UnsplashServiceImpl(unsplashClient, favoriteImageService);
    }

    @Bean
    public FavoriteImageService favoriteImageService(FavoriteImageRepository favoriteImageRepository) {
        return new FavoriteImageServiceImpl(favoriteImageRepository);
    }

    @Bean
    public ImageService imageService(UnsplashService unsplashService, FavoriteImageService favoriteImageService) {
        return new ImageServiceImpl(unsplashService, favoriteImageService);
    }

    @Bean
    public UserService userService(UnsplashService unsplashService, FavoriteImageService favoriteImageService) {
        return new UserServiceImpl(unsplashService, favoriteImageService);
    }

}
