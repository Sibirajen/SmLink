package com.sibirajen.SmLink.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.URL;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ShortenRequest {
    @NotBlank(message = "URL must not be empty")
    @URL(message = "Invalid URL format")
    private String url;
}
