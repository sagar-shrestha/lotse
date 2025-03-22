package com.sagar.lotse.pojo.common.response;

import lombok.*;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrganizationResponsePojo {
    private Integer id;
    private String organizationName;
    private String address;
    private String panOrVat;
    private String logo;
}

