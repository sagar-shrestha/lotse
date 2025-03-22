package com.sagar.lotse.entity;

import com.sagar.lotse.common.constant.Gender;
import com.sagar.lotse.common.constant.UserCategory;
import com.sagar.lotse.common.entity.Details;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Entity
@Table(name = "users_basic_info")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UsersBasicInfo extends Details {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_info_gen")
    @SequenceGenerator(name = "user_info_gen", sequenceName = "user_info_seq", allocationSize = 1)
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
