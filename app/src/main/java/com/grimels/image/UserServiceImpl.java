package com.grimels.image;

import com.grimels.image.api.UserService;
import com.grimels.image.service.FavoriteImageService;
import com.grimels.image.service.UnsplashService;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UnsplashService unsplashService;
    private final FavoriteImageService favoriteImageService;

    @Override
    public void addToFavorites(String imageId) {
        favoriteImageService.addImage(imageId);
    }

    @Override
    public void removeFromFavorites(String imageId) {
        favoriteImageService.removeImage(imageId);
    }
}
