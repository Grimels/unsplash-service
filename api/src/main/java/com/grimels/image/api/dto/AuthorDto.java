package com.grimels.image.api.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public record AuthorDto(@JsonProperty("id") String id,
                        @JsonProperty("username") String username,
                        @JsonProperty("name") String name,
                        @JsonProperty("portfolio_url") String portfolio_url,
                        @JsonProperty("bio") String bio,
                        @JsonProperty("total_likes") String total_likes,
                        @JsonProperty("total_photos") String total_photos,
                        @JsonProperty("total_collections") String total_collections,
                        @JsonProperty("location") String location) {
}
