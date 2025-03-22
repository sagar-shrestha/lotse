package com.sagar.lotse.entity;

import com.sagar.lotse.common.constant.DocumentsType.DocumentsType;
import com.sagar.lotse.common.constant.RegistrationCountry;
import com.sagar.lotse.common.constant.RegistrationType;
import com.sagar.lotse.common.entity.Details;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@Builder
@Entity
@Table(name = "users_document_info")
@AllArgsConstructor
@NoArgsConstructor
public class UsersDocumentInfo extends Details {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "users_document_info_gen")
    @SequenceGenerator(name = "users_document_info_gen", sequenceName = "users_document_info_seq", allocationSize = 1)
    private Long id;
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "users_basic_info", foreignKey = @ForeignKey(name = "fk_users_basic_info_id"), referencedColumnName = "id")
    private UsersBasicInfo usersBasicInfo;
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
