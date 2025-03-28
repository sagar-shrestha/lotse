package com.sagar.lotse.common.entity;

import jakarta.persistence.MappedSuperclass;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@MappedSuperclass
public class Details implements Serializable {
    private LocalDateTime createdIn;
    private String createdBy;
    private LocalDateTime modifiedIn;
    private String modifiedBy;
}
