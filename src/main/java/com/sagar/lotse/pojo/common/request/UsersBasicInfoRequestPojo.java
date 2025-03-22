package com.sagar.lotse.pojo.common.request;

import com.sagar.lotse.common.constant.Gender;
import com.sagar.lotse.common.constant.UserCategory;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UsersBasicInfoRequestPojo {
    private Long id;
    private String firstName;
    private String middleName;
    private String lastName;
    @Enumerated(EnumType.STRING)
    private Gender gender;
    @Enumerated(EnumType.STRING)
    private UserCategory userCategory;
    private MultipartFile userImage;
}
