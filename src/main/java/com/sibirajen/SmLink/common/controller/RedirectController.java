package com.sibirajen.SmLink.common.controller;

import com.sibirajen.SmLink.shortUrl.ShortUrlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class RedirectController {
    private final ShortUrlService shortUrlService;

    @Autowired
    public RedirectController(ShortUrlService shortUrlService) {
        this.shortUrlService = shortUrlService;
    }

    @GetMapping("/{shortCode}")
    public ResponseEntity<Void> reDirect(@PathVariable String shortCode){
        return ResponseEntity.ok().build();
    }
}

//        if (optionalOriginalUrl.isEmpty()){
//            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
//        }
//
//        return ResponseEntity
//                .status(HttpStatus.PERMANENT_REDIRECT)
//                .header(HttpHeaders.LOCATION, optionalOriginalUrl.get())
//                .build();


//Optional<String> optionalOriginalUrl = shortUrlService.getLongUrl(shortCode);
//
//        return optionalOriginalUrl.map(url -> ResponseEntity
//        .status(HttpStatus.FOUND)
//                    .header(HttpHeaders.LOCATION, url)
//                    .<Void>build())
//        .orElseGet(() -> ResponseEntity
//        .status(HttpStatus.NOT_FOUND)
//                        .build());