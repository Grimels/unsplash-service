package com.grimels.image.service;

import com.grimels.image.api.dto.ImageDto;
import com.grimels.image.model.UnsplashSearchResult;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;

@RequiredArgsConstructor
public class UnsplashServiceImpl implements UnsplashService {

    private final WebClient unsplashClient;
    private final FavoriteImageService favoriteImageService;

    @Override
    public ImageDto getRandomImage() {
        return unsplashClient.get().uri("/photos/random")
                .retrieve()
                .bodyToMono(ImageDto.class)
                .block();
    }

    @Override
    public ImageDto getImage(String imageId) {
        ImageDto result = unsplashClient.get().uri("/photos/{imageId}", imageId)
                .retrieve()
                .bodyToMono(ImageDto.class)
                .block();

        assert result != null;
        populateFavoriteFlag(List.of(result));

        return result;
    }

    @Override
    @Transactional
    public UnsplashSearchResult searchImages(String query, int page, int pageSize) {
        UnsplashSearchResult result = unsplashClient.get()
                .uri("/search/photos?query={query}&page={page}&per_page={pageSize}", query, page, pageSize)
                .retrieve()
                .bodyToMono(UnsplashSearchResult.class)
                .block();

        assert result != null;
        populateFavoriteFlag(result.getImages());

        return result;
    }

    private void populateFavoriteFlag(List<ImageDto> images) {
        List<String> favoriteImages = favoriteImageService.getFavoriteImages(images);
        images.forEach(image -> image.setIsFavorite(favoriteImages.contains(image.getId())));
    }
}
