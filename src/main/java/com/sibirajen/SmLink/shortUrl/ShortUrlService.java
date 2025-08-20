package com.sibirajen.SmLink.shortUrl;

import com.sibirajen.SmLink.shortUrl.dto.Request;
import com.sibirajen.SmLink.shortUrl.dto.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class ShortUrlService {
    private final ShortUrlRepo shortUrlRepo;

    @Autowired
    public ShortUrlService(ShortUrlRepo shortUrlRepo) {
        this.shortUrlRepo = shortUrlRepo;
    }

    public Optional<Response> getShortUrl(String shortCode) {
        return shortUrlRepo.findByShortCode(shortCode)
                .map(shortUrl -> Response.builder()
                        .id(shortUrl.getId())
                        .url(shortUrl.getOriginalUrl())
                        .shortCode(shortUrl.getShortCode())
                        .createdAt(shortUrl.getCreatedAt())
                        .updatedAt(shortUrl.getUpdatedAt())
                        .build()
                );
    }

    @Transactional
    public Optional<Response> updateShortUrl(String shortCode, Request request) {
        return shortUrlRepo.findByShortCode(shortCode)
                .map(shortUrl -> {
                    shortUrl.setOriginalUrl(request.getUrl());
                    shortUrl = shortUrlRepo.save(shortUrl);
                    return Response.builder()
                            .id(shortUrl.getId())
                            .url(shortUrl.getOriginalUrl())
                            .shortCode(shortUrl.getShortCode())
                            .createdAt(shortUrl.getCreatedAt())
                            .updatedAt(shortUrl.getUpdatedAt())
                            .build();
                });
    }
}
