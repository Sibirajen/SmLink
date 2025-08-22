package com.sibirajen.SmLink.shortUrl;

import com.sibirajen.SmLink.common.model.DateEntity;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Builder
@ToString(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "short_urls")
@Access(AccessType.FIELD)
public class ShortUrl extends DateEntity {
    @Column(name = "short_code", unique = true, length = 20)
    private String shortCode;

    @Column(name = "original_url", nullable = false, columnDefinition = "TEXT")
    private String originalUrl;

    @Column(name = "access_count", nullable = false)
    private int accessCount = 0;
}
