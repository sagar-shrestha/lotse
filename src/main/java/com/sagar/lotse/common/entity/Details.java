package com.sagar.lotse.common.entity;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;
import org.springframework.boot.actuate.endpoint.SecurityContext;
import org.springframework.boot.context.properties.bind.DefaultValue;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@MappedSuperclass
public class Details implements Serializable {
    @Column(nullable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime createdIn = LocalDateTime.now();
    @Column()
    private Integer createdBy;
    private LocalDateTime modifiedIn;
    private Integer modifiedBy;
    @Column(nullable = false, columnDefinition = "BOOLEAN DEFAULT true")
    private boolean status = true;

    @PrePersist
    protected void onCreate() {
        if (this.createdIn == null) {
            this.createdIn = LocalDateTime.now();
        }
    }

    @PreUpdate
    protected void onUpdate() {
        this.modifiedIn = LocalDateTime.now();
    }
}
