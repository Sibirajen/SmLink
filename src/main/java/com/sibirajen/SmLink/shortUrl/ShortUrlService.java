package com.sibirajen.SmLink.shortUrl;

import com.sibirajen.SmLink.shortUrl.dto.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShortUrlService {
    private final ShortUrlRepo shortUrlRepo;

    @Autowired
    public ShortUrlService(ShortUrlRepo shortUrlRepo) {
        this.shortUrlRepo = shortUrlRepo;
    }

    public Response getShortUrl(String shortCode) {
        return null;
    }
}
