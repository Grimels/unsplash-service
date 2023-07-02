package com.grimels.image;

import com.grimels.image.api.ImageService;
import com.grimels.image.api.dto.ImageDto;
import com.grimels.image.api.dto.PageableData;
import com.grimels.image.model.UnsplashSearchResult;
import com.grimels.image.service.FavoriteImageService;
import com.grimels.image.service.UnsplashService;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class ImageServiceImpl implements ImageService {

    private final UnsplashService unsplashService;
    private final FavoriteImageService favoriteImageService;

    @Override
    public ImageDto getRandomImage() {
        return unsplashService.getRandomImage();
    }

    @Override
    public ImageDto getImage(String imageId) {
        return unsplashService.getImage(imageId);
    }

    @Override
    public PageableData<ImageDto> getImages(String query, Integer page, Integer pageSize) {
        UnsplashSearchResult result = unsplashService.searchImages(query, page, pageSize);
        return PageableData.<ImageDto>builder()
                .query(query)
                .page(page)
                .pageSize(pageSize)
                .totalElements(result.getTotal())
                .totalPages(result.getTotalPages())
                .elements(result.getImages())
                .build();
    }

    @Override
    public List<ImageDto> getFavoriteImages() {
        List<String> imageIds = favoriteImageService.getFavoriteImages();
        return imageIds.parallelStream()
                .map(unsplashService::getImage)
                .toList();
    }

}
