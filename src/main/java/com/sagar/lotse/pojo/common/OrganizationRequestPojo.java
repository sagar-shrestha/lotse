package com.sagar.lotse.pojo.common;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrganizationRequestPojo {

    private Integer id;
    @NotBlank
    private String organizationName;
    @NotBlank
    private String address;
    private String panOrVat;
    @NotNull
    private MultipartFile logo;
}
