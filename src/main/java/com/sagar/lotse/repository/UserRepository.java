package com.sagar.lotse.repository;

import com.sagar.lotse.entity.UsersBasicInfo;
import com.sagar.lotse.projection.UserProjection;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends Repository<UsersBasicInfo, Long> {

    @Query(value = "select ubi.id,\n" +
            "       ubi.first_name,\n" +
            "       ubi.middle_name,\n" +
            "       ubi.last_name,\n" +
            "       ubi.gender,\n" +
            "       ubi.user_category,\n" +
            "       ubi.user_image,\n" +
            "       uai.temporary_address,\n" +
            "       uai.personal_address,\n" +
            "       uai.email,\n" +
            "       uai.alternate_email,\n" +
            "       uai.mobile_number,\n" +
            "       uai.alternate_mobile_number,\n" +
            "       uai.phone_number,\n" +
            "       udi.registration_country,\n" +
            "       udi.registration_type,\n" +
            "       udi.registration_number,\n" +
            "       udi.documents_type,\n" +
            "       udi.citizenship_image,\n" +
            "       udi.driving_license_image,\n" +
            "       udi.passport_image,\n" +
            "       udi.pan_card_image,\n" +
            "       udi.voter_id_image,\n" +
            "       udi.national_id_image,\n" +
            "       udi.medical_license_image,\n" +
            "       udi.citizenship_no,\n" +
            "       udi.citizenship_issued_date_in_bs,\n" +
            "       udi.citizenship_issued_date_in_ad,\n" +
            "       udi.citizenship_issue_place,\n" +
            "       udi.passport_no,\n" +
            "       udi.passport_issued_date,\n" +
            "       udi.passport_expiry_date,\n" +
            "       udi.passport_issue_place,\n" +
            "       udi.driving_license_no,\n" +
            "       udi.driving_license_issued_date,\n" +
            "       udi.driving_license_expiry_date,\n" +
            "       udi.driving_license_place,\n" +
            "       udi.pan_no,\n" +
            "       udi.pan_card_issued_date,\n" +
            "       udi.pan_card_issued_place,\n" +
            "       udi.voter_no,\n" +
            "       udi.voter_card_issue_date,\n" +
            "       udi.voter_card_issued_place,\n" +
            "       udi.pan_card_issued_place,\n" +
            "       udi.national_id_no,\n" +
            "       udi.national_id_issue_date_in_bs,\n" +
            "       udi.national_id_issue_date_in_ad,\n" +
            "       udi.national_id_issue_place,\n" +
            "       udi.medical_license_no,\n" +
            "       udi.medical_license_issued_date_in_bs,\n" +
            "       udi.medical_license_issued_date_in_ad,\n" +
            "       udi.medical_license_issued_organization\n" +
            "from users_basic_info as ubi\n" +
            "         inner join users_address_info as uai on uai.users_basic_info = ubi.id\n" +
            "         inner join users_document_info as udi on udi.users_basic_info = ubi.id\n" +
            "where ubi.id = :id", nativeQuery = true)
    UserProjection getUsersBasicInfoById(@Param("id") Long id);
}
