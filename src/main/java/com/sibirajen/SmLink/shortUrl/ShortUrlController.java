package com.sibirajen.SmLink.shortUrl;

import com.sibirajen.SmLink.shortUrl.dto.Request;
import com.sibirajen.SmLink.shortUrl.dto.Response;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/shorten")
public class ShortUrlController {
    private final ShortUrlService shortUrlService;

    @Autowired
    public ShortUrlController(ShortUrlService shortUrlService) {
        this.shortUrlService = shortUrlService;
    }

    @GetMapping("/{shortCode}")
    public ResponseEntity<Response> getShortUrl(@PathVariable("shortCode") String shortCode){
        Optional<Response> optionalResponse = shortUrlService.getShortUrl(shortCode);
        return optionalResponse.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @PutMapping("/{shortCode}")
    public  ResponseEntity<Response> updateShortUrl(
            @PathVariable("shortCode") String shortCode,
            @Valid @RequestBody Request request
    ){
        Optional<Response> optionalResponse = shortUrlService.updateShortUrl(shortCode, request);
        return optionalResponse.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @PostMapping
    public ResponseEntity<Response> createShortUrl(@Valid @RequestBody Request request){
        Optional<Response> optionalResponse = shortUrlService.createShortUrl(request);
        return optionalResponse.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(HttpStatus.BAD_REQUEST).build());
    }
}
