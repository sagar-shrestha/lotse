package com.sagar.lotse.entity;

import com.sagar.lotse.common.constant.DocumentsType.DocumentsType;
import com.sagar.lotse.common.constant.Gender;
import com.sagar.lotse.common.constant.RegistrationCountry;
import com.sagar.lotse.common.constant.RegistrationType;
import com.sagar.lotse.common.constant.UserCategory;
import com.sagar.lotse.common.entity.Details;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name = "user_info")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UsersInfo extends Details implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_info_gen")
    @SequenceGenerator(name = "user_info_gen", sequenceName = "user_info_seq", allocationSize = 1)
    private Long id;
    private String firstName;
    private String middleName;
    private String lastName;
    @Enumerated(EnumType.STRING)
    private Gender gender;
    private String temporaryAddress;
    private String personalAddress;
    private String currentAddress;
    private String email;
    private String alternateEmail;
    private String mobileNumber;
    private String alternateMobileNumber;
    private String phoneNumber;
    @Enumerated(EnumType.STRING)
    private UserCategory userCategory;
    @Enumerated(EnumType.STRING)
    private RegistrationCountry registrationCountry;
    @Enumerated(EnumType.STRING)
    private RegistrationType registrationType;
    private String registrationNumber;
    private String userImage;
    @Enumerated(EnumType.STRING)
    private DocumentsType documentsType;
    private String citizenshipImage;
    private String drivingLicenseImage;
    private String passportImage;
    private String panCardImage;
    private String voterIdImage;
    private String nationalIdImage;
    private String medicalLicenseImage;
    private String citizenshipNo;
    private LocalDate citizenshipIssuedDateInBs;
    private LocalDate citizenshipIssuedDateInAd;
    private String citizenshipIssuePlace;
    private String passportNo;
    private LocalDate passportIssuedDate;
    private LocalDate passportExpiryDate;
    private String passportIssuePlace;
    private String drivingLicenseNo;
    private LocalDate drivingLicenseIssuedDate;
    private LocalDate drivingLicenseExpiryDate;
    private String drivingLicensePlace;
    private String panNo;
    private LocalDate panCardIssuedDate;
    private String panCardIssuedPlace;
    private String voterNo;
    private LocalDate voterCardIssueDate;
    private String voterCardIssuedPlace;
    private String nationalIdNo;
    private LocalDate nationalIdIssueDateInBs;
    private LocalDate nationalIdIssueDateInAd;
    private String nationalIdIssuePlace;
    private String medicalLicenseNo;
    private LocalDate medicalLicenseIssuedDateInBs;
    private LocalDate medicalLicenseIssuedDateInAd;
    private String medicalLicenseIssuedOrganization;
}
