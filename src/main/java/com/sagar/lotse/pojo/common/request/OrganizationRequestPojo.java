package com.sagar.lotse.pojo.common.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrganizationRequestPojo {

    private Integer id;
    private String organizationName;
    private String address;
    private String panOrVat;
    private MultipartFile logo;
}