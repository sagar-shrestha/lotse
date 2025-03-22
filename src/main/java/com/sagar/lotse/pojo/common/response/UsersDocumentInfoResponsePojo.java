package com.sagar.lotse.pojo.common.response;

import com.sagar.lotse.common.constant.DocumentsType.DocumentsType;
import com.sagar.lotse.common.constant.RegistrationCountry;
import com.sagar.lotse.common.constant.RegistrationType;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.*;

import java.time.LocalDate;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UsersDocumentInfoResponsePojo {

    private Long id;
    @Enumerated(EnumType.STRING)
    private RegistrationCountry registrationCountry;
    @Enumerated(EnumType.STRING)
    private RegistrationType registrationType;
    private String registrationNumber;
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
