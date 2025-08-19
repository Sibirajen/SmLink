package com.sibirajen.SmLink.model;

import com.sibirajen.SmLink.model.listeners.DateEntityListener;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@MappedSuperclass
@Access(AccessType.FIELD)
@EntityListeners(DateEntityListener.class)
public class DateEntity extends BaseEntity{
    @Column(name = "created_at", updatable = false, nullable = false)
    private LocalDateTime createdAt;

    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updatedAt;
}
