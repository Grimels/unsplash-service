package com.grimels.image.api;

import com.grimels.image.api.dto.ImageDto;
import com.grimels.image.api.dto.PageableData;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public interface ImageService {

    @GetMapping(path = "/images/random")
    ImageDto getRandomImage();

    @GetMapping(path = "/images/{imageId}")
    ImageDto getImage(@PathVariable("imageId") String imageId);

    @GetMapping(path = "/images")
    PageableData<ImageDto> getImages(@RequestParam(name = "query") String query,
                                     @RequestParam(name = "page", defaultValue = "1") Integer page,
                                     @RequestParam(name = "pageSize", defaultValue = "5") Integer pageSize);

    @GetMapping(path = "/images/favorites")
    List<ImageDto> getFavoriteImages();

}
