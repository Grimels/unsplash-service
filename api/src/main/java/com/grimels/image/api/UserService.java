package com.grimels.image.api;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public interface UserService {

    @PostMapping("/images/{imageId}/favorites")
    void addToFavorites(@PathVariable("imageId") String imageId);

    @DeleteMapping("/images/{imageId}/favorites")
    void removeFromFavorites(@PathVariable("imageId") String imageId);

}
