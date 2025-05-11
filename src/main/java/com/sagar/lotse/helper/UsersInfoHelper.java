package com.sagar.lotse.helper;

import com.sagar.lotse.common.constant.CommonMessages;
import com.sagar.lotse.entity.UsersAddressInfo;
import com.sagar.lotse.entity.UsersBasicInfo;
import com.sagar.lotse.entity.UsersDocumentInfo;
import com.sagar.lotse.exception.DataNotFoundException;
import com.sagar.lotse.pojo.common.response.UsersAddressInfoResponsePojo;
import com.sagar.lotse.pojo.common.response.UsersBasicInfoResponsePojo;
import com.sagar.lotse.pojo.common.response.UsersDocumentInfoResponsePojo;
import com.sagar.lotse.repository.UsersAddressInfoRepository;
import com.sagar.lotse.repository.UsersBasicInfoRepository;
import com.sagar.lotse.repository.UsersDocumentInfoRepository;
import com.sagar.lotse.util.NullAwareBeanUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.lang.reflect.InvocationTargetException;

@Component
@RequiredArgsConstructor
public class UsersInfoHelper implements CommonMessages {

    private final UsersBasicInfoRepository usersBasicInfoRepository;
    private final UsersAddressInfoRepository usersAddressInfoRepository;
    private final UsersDocumentInfoRepository usersDocumentInfoRepository;
    private final NullAwareBeanUtil nullAwareBeanUtil = new NullAwareBeanUtil();

    public UsersBasicInfoResponsePojo usersBasicInfo(Long id) throws InvocationTargetException, IllegalAccessException {
        UsersBasicInfoResponsePojo usersBasicInfoResponsePojo = new UsersBasicInfoResponsePojo();
        UsersBasicInfo existingUsersBasicInfo = usersBasicInfoRepository.findById(id)
                .orElseThrow(() -> new DataNotFoundException(USER + BASIC_INFO + DATA_NOT_FOUND));
        nullAwareBeanUtil.copyProperties(usersBasicInfoResponsePojo, existingUsersBasicInfo);
        return usersBasicInfoResponsePojo;
    }

    public UsersAddressInfoResponsePojo getUsersAddressInfo(Long id) throws InvocationTargetException, IllegalAccessException {
        UsersAddressInfoResponsePojo usersAddressInfoResponsePojo = new UsersAddressInfoResponsePojo();
        UsersAddressInfo existingUsersAddressInfo = usersAddressInfoRepository.findById(id)
                .orElseThrow(() -> new DataNotFoundException(USER +  ADDRESS_INFO + DATA_NOT_FOUND));
        nullAwareBeanUtil.copyProperties(usersAddressInfoResponsePojo, existingUsersAddressInfo);
        return usersAddressInfoResponsePojo;
    }

    public UsersDocumentInfoResponsePojo getUsersDocumentInfo(Long id) throws InvocationTargetException, IllegalAccessException {
        UsersDocumentInfoResponsePojo usersDocumentInfoResponsePojo = new UsersDocumentInfoResponsePojo();
        UsersDocumentInfo existingUsersDocumentInfo = usersDocumentInfoRepository.findById(id)
                .orElseThrow(() -> new DataNotFoundException(USER + DOCUMENT_INFO + DATA_NOT_FOUND));
        nullAwareBeanUtil.copyProperties(usersDocumentInfoResponsePojo, existingUsersDocumentInfo);
        return usersDocumentInfoResponsePojo;
    }
}
