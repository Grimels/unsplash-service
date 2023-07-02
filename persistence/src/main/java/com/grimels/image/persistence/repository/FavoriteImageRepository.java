package com.grimels.image.persistence.repository;

import com.grimels.image.persistence.entity.FavoriteImage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface FavoriteImageRepository extends JpaRepository<FavoriteImage, String> {

    @Query("""
        select fi.externalId
        from FavoriteImage fi
        where fi.isFavorite = true and fi.externalId in (:requestedIds)
    """)
    List<String> getAllFavoriteImagesFromList(@Param("requestedIds") List<String> requestedIds);

    Optional<FavoriteImage> findByExternalId(String externalId);

    @Query("""
        select fi.externalId
        from FavoriteImage fi
        where fi.isFavorite = true
    """)
    List<String> getAllFavoriteImages();

}
