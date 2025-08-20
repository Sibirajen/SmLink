package com.sibirajen.SmLink.repo;

import com.sibirajen.SmLink.model.ShortUrls;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShortUrlsRepo extends JpaRepository<ShortUrls, Long> {
}
