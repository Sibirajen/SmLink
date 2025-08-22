package com.sibirajen.SmLink.shortUrl;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ShortUrlRepo extends JpaRepository<ShortUrl, Long> {
    Optional<ShortUrl> findByShortCode(String shortCode);

    Optional<ShortUrl> findByOriginalUrl(String originalUrl);

    boolean existsByShortCode(String shortCode);

    boolean existsByOriginalUrl(String originalUrl);
}
