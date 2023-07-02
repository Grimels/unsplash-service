package com.grimels.image.service;

import com.grimels.image.api.dto.ImageDto;

import java.util.List;

public interface FavoriteImageService {

    void addImage(String imageId);

    void removeImage(String imageId);

     List<String> getFavoriteImages(List<ImageDto> images);

     List<String> getFavoriteImages();

}
