package com.sagar.lotse.common.entity;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.PrePersist;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;
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
    @Column(nullable = false, columnDefinition = "DATE DEFAULT CURRENT_DATE")
    private LocalDateTime createdIn;
    @Column(nullable = false, columnDefinition = "VARCHAR DEFAULT '1")
    private String createdBy = "1";
    private LocalDateTime modifiedIn;
    private String modifiedBy;
    @Column(nullable = false, columnDefinition = "boolean default 'true'")
    private boolean status = true;

    @PrePersist
    protected void onCreate() {
        if (this.createdIn == null) {
            this.createdIn = LocalDateTime.now();
        }

        if (this.modifiedIn == null) {
            this.modifiedIn = LocalDateTime.now();
        }
    }
}
