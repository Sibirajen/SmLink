package com.sibirajen.SmLink.shortUrl.repo;

import com.sibirajen.SmLink.shortUrl.model.ShortUrl;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShortUrlRepo extends JpaRepository<ShortUrl, Long> {
}
