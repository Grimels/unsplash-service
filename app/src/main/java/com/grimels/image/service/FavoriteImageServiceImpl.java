package com.grimels.image.service;

import com.grimels.image.api.dto.ImageDto;
import com.grimels.image.persistence.entity.FavoriteImage;
import com.grimels.image.persistence.repository.FavoriteImageRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class FavoriteImageServiceImpl implements FavoriteImageService {

    private final FavoriteImageRepository favoriteImageRepository;

    @Override
    @Transactional
    public void addImage(String imageId) {
        FavoriteImage image = new FavoriteImage();
        image.setExternalId(imageId);
        image.setIsFavorite(true);

        favoriteImageRepository.save(image);
    }

    @Override
    @Transactional
    public void removeImage(String imageId) {
        favoriteImageRepository.findByExternalId(imageId)
                .ifPresent(image -> {
                    image.setIsFavorite(false);
                    favoriteImageRepository.save(image);
                });
    }

    @Override
    public List<String> getFavoriteImages(List<ImageDto> images) {
        return favoriteImageRepository.getAllFavoriteImagesFromList(images.stream().map(ImageDto::getId).toList());
    }

    @Override
    public List<String> getFavoriteImages() {
        return favoriteImageRepository.getAllFavoriteImages();
    }
}
