package com.sagar.lotse.pojo.common.request;

import com.sagar.lotse.common.constant.DocumentsType.DocumentsType;
import com.sagar.lotse.common.constant.Gender;
import com.sagar.lotse.common.constant.RegistrationCountry;
import com.sagar.lotse.common.constant.RegistrationType;
import com.sagar.lotse.common.constant.UserCategory;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UsersInfoRequestPojo {
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
    private MultipartFile userImage;
    @Enumerated(EnumType.STRING)
    private DocumentsType documentsType;
    private MultipartFile citizenshipImage;
    private MultipartFile drivingLicenseImage;
    private MultipartFile passportImage;
    private MultipartFile panCardImage;
    private MultipartFile voterIdImage;
    private MultipartFile nationalIdImage;
    private MultipartFile medicalLicenseImage;
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
