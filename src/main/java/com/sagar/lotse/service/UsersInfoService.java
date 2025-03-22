package com.sagar.lotse.service;

import com.sagar.lotse.pojo.common.request.UsersAddressInfoRequestPojo;
import com.sagar.lotse.pojo.common.request.UsersBasicInfoRequestPojo;
import com.sagar.lotse.pojo.common.request.UsersDocumentInfoRequestPojo;
import com.sagar.lotse.pojo.common.response.UsersAddressInfoResponsePojo;
import com.sagar.lotse.pojo.common.response.UsersBasicInfoResponsePojo;
import com.sagar.lotse.pojo.common.response.UsersDocumentInfoResponsePojo;

import java.util.List;

public interface UsersInfoService {

    void saveAndUpdateUsersBasicInfo(UsersBasicInfoRequestPojo usersBasicInfoRequestPojo);

    void saveAndUpdateUsersAddressInfo(UsersAddressInfoRequestPojo usersAddressInfoRequestPojo);

    void saveAndUpdateUsersDocumentInfo(UsersDocumentInfoRequestPojo usersDocumentInfoRequestPojo);

    UsersBasicInfoResponsePojo getUsersBasicInfo(Long id);

    UsersAddressInfoResponsePojo getUsersAddressInfo(Long id);

    UsersDocumentInfoResponsePojo getUsersDocumentInfo(Long id);

    List<String> getGender();

    List<String> getUserCategory();

    List<String> getUsersRegistrationCountry();

    List<String> getUsersRegistrationType();

    List<String> getUsersDocumentsType();

}
