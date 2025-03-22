package com.sagar.lotse.pojo.common.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UsersAddressInfoRequestPojo {
    private Long id;
    private String temporaryAddress;
    private String personalAddress;
    private String currentAddress;
    private String email;
    private String alternateEmail;
    private String mobileNumber;
    private String alternateMobileNumber;
    private String phoneNumber;
    private Long usersBasicInfoId;
}
