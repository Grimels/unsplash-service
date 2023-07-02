package com.grimels.image.config;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class UnsplashCredentials {

    private String accessKey;
    private String secretKey;
    private String url;

}
