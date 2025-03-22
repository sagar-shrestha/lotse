package com.sagar.lotse.service;

import com.sagar.lotse.pojo.common.request.UsersAddressInfoRequestPojo;
import com.sagar.lotse.pojo.common.request.UsersBasicInfoRequestPojo;
import com.sagar.lotse.pojo.common.request.UsersDocumentInfoRequestPojo;

import java.util.List;

public interface UsersInfoService {

     void saveAndUpdateUsersBasicInfo(UsersBasicInfoRequestPojo usersBasicInfoRequestPojo);

     void saveAndUpdateUsersAddressInfo(UsersAddressInfoRequestPojo usersAddressInfoRequestPojo);

     void saveAndUpdateUsersDocumentInfo(UsersDocumentInfoRequestPojo usersDocumentInfoRequestPojo);

     List<String> getGender();

     List<String> getUserCategory();

     List<String> getUsersRegistrationCountry();

     List<String> getUsersRegistrationType();

     List<String> getUsersDocumentsType();

}
