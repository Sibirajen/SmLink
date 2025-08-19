package com.sibirajen.SmLink.model.listeners;

import com.sibirajen.SmLink.model.DateEntity;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;

import java.time.LocalDateTime;

public class DateEntityListener {
    @PrePersist
    public void prePersist(DateEntity entity){
        LocalDateTime now = LocalDateTime.now();
        entity.setCreatedAt(now);
        entity.setUpdatedAt(now);
    }

    @PreUpdate
    public void preUpdate(DateEntity entity){
        LocalDateTime now = LocalDateTime.now();
        entity.setUpdatedAt(now);
    }
}
