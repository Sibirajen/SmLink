package com.sibirajen.SmLink.shortUrl;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShortUrlRepo extends JpaRepository<ShortUrl, Long> {
}
