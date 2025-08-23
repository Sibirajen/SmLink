package com.sibirajen.SmLink.shortUrl;

import com.sibirajen.SmLink.common.dto.StatResponse;
import com.sibirajen.SmLink.common.utility.Base62Utility;
import com.sibirajen.SmLink.shortUrl.dto.Request;
import com.sibirajen.SmLink.shortUrl.dto.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class ShortUrlService {
    private final ShortUrlRepo shortUrlRepo;
    private final Base62Utility base62Utility;

    @Autowired
    public ShortUrlService(ShortUrlRepo shortUrlRepo, Base62Utility base62Utility) {
        this.shortUrlRepo = shortUrlRepo;
        this.base62Utility = base62Utility;
    }

    public Optional<Response> getShortUrl(String shortCode) {
        return shortUrlRepo.findByShortCode(shortCode)
                .map(this::mapToResponse);
    }

    @Transactional
    public Optional<Response> updateShortUrl(String shortCode, Request request) {
        return shortUrlRepo.findByShortCode(shortCode)
                .map(shortUrl -> {
                    shortUrl.setOriginalUrl(request.getUrl());
                    return mapToResponse(shortUrl);
                });
    }

    @Transactional
    public Optional<Response> createShortUrl(Request request) {
        final String originalUrl = request.getUrl();

        return shortUrlRepo.findByOriginalUrl(originalUrl)
                .map(this::mapToResponse)
                .or(() -> {
                   ShortUrl shortUrl = ShortUrl.builder()
                           .originalUrl(originalUrl).build();
                   shortUrl = shortUrlRepo.save(shortUrl);
                   shortUrl.setShortCode(base62Utility.encode(shortUrl.getId()));
                   return Optional.of(mapToResponse(shortUrl));
                });
    }

    public Optional<StatResponse> getStats(String shortCode) {
        return shortUrlRepo.findByShortCode(shortCode)
                .map(this::mapToStatResponse);
    }

    private Response mapToResponse(ShortUrl shortUrl) {
        return Response.builder()
                .id(shortUrl.getId())
                .url(shortUrl.getOriginalUrl())
                .shortCode(shortUrl.getShortCode())
                .createdAt(shortUrl.getCreatedAt())
                .updatedAt(shortUrl.getUpdatedAt())
                .build();
    }

    private StatResponse mapToStatResponse(ShortUrl shortUrl){
        return StatResponse.builder()
                .id(shortUrl.getId())
                .url(shortUrl.getOriginalUrl())
                .shortCode(shortUrl.getShortCode())
                .createdAt(shortUrl.getCreatedAt())
                .updatedAt(shortUrl.getUpdatedAt())
                .accessCount(shortUrl.getAccessCount())
                .build();
    }
}
