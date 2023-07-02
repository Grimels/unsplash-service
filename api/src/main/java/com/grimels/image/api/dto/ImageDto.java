package com.grimels.image.api.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public final class ImageDto {

    @JsonProperty("id")
    private String id;

    @JsonProperty("width")
    private String width;

    @JsonProperty("height")
    private String height;

    @JsonProperty("description")
    private String description;

    @JsonProperty("color")
    private String color;

    @JsonProperty("downloads")
    private Integer downloads;

    @JsonProperty("likes")
    private Integer likes;

    @JsonProperty("liked_by_user")
    private String liked_by_user;

    @JsonProperty("user")
    private AuthorDto author;

    @JsonProperty("urls")
    private ImageUrlsDto urls;

    @JsonProperty("isFavorite")
    private Boolean isFavorite;

    public ImageDto(@JsonProperty("id") String id,
                    @JsonProperty("width") String width,
                    @JsonProperty("height") String height,
                    @JsonProperty("description") String description,
                    @JsonProperty("color") String color,
                    @JsonProperty("downloads") Integer downloads,
                    @JsonProperty("likes") Integer likes,
                    @JsonProperty("liked_by_user") String liked_by_user,
                    @JsonProperty("user") AuthorDto author,
                    @JsonProperty("urls") ImageUrlsDto urls) {
        this.id = id;
        this.width = width;
        this.height = height;
        this.description = description;
        this.color = color;
        this.downloads = downloads;
        this.likes = likes;
        this.liked_by_user = liked_by_user;
        this.author = author;
        this.urls = urls;
        this.isFavorite = false;
    }

}
