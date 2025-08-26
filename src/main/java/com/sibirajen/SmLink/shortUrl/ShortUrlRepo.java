package com.sibirajen.SmLink.shortUrl;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ShortUrlRepo extends JpaRepository<ShortUrl, Long> {
    Optional<ShortUrl> findByShortCode(String shortCode);

    Optional<ShortUrl> findByOriginalUrl(String originalUrl);

    boolean existsByShortCode(String shortCode);

    boolean existsByOriginalUrl(String originalUrl);

    @Query("SELECT s.originalUrl FROM ShortUrl s WHERE s.shortCode = :shortCode")
    Optional<String> findOriginalUrl(@Param("shortCode") String shortCode);

    @Modifying
    @Query("UPDATE ShortUrl s SET s.accessCount = s.accessCount + 1 WHERE s.shortCode = :shortCode")
    void incrementAccessCount(@Param("shortCode") String shortCode);
}
