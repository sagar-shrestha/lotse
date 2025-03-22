package com.sagar.lotse.pojo.common.response;

import com.sagar.lotse.common.constant.Gender;
import com.sagar.lotse.common.constant.UserCategory;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.*;
import org.springframework.web.multipart.MultipartFile;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UsersBasicInfoResponsePojo {
    private Long id;
    private String firstName;
    private String middleName;
    private String lastName;
    @Enumerated(EnumType.STRING)
    private Gender gender;
    @Enumerated(EnumType.STRING)
    private UserCategory userCategory;
    private String userImage;
}
