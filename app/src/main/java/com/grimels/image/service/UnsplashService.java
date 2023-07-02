package com.grimels.image.service;

import com.grimels.image.api.dto.ImageDto;
import com.grimels.image.model.UnsplashSearchResult;

public interface UnsplashService {

    ImageDto getRandomImage();

    ImageDto getImage(String imageId);

    UnsplashSearchResult searchImages(String query, int page, int pageSize);

}
