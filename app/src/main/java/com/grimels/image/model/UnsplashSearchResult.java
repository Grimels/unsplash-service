package com.grimels.image.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.grimels.image.api.dto.ImageDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UnsplashSearchResult {

    @JsonProperty("total")
    private Integer total;

    @JsonProperty("total_pages")
    private Integer totalPages;

    @JsonProperty("results")
    private List<ImageDto> images;

}
