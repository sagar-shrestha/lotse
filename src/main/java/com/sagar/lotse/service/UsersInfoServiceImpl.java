package com.sagar.lotse.service;

import com.sagar.lotse.common.constant.*;
import com.sagar.lotse.common.constant.DocumentsType.DocumentsType;
import com.sagar.lotse.entity.UsersAddressInfo;
import com.sagar.lotse.entity.UsersBasicInfo;
import com.sagar.lotse.entity.UsersDocumentInfo;
import com.sagar.lotse.exception.DataNotFoundException;
import com.sagar.lotse.helper.UsersInfoHelper;
import com.sagar.lotse.pojo.common.request.UsersAddressInfoRequestPojo;
import com.sagar.lotse.pojo.common.request.UsersBasicInfoRequestPojo;
import com.sagar.lotse.pojo.common.request.UsersDocumentInfoRequestPojo;
import com.sagar.lotse.pojo.common.response.UsersAddressInfoResponsePojo;
import com.sagar.lotse.pojo.common.response.UsersBasicInfoResponsePojo;
import com.sagar.lotse.pojo.common.response.UsersDocumentInfoResponsePojo;
import com.sagar.lotse.repository.UsersAddressInfoRepository;
import com.sagar.lotse.repository.UsersBasicInfoRepository;
import com.sagar.lotse.repository.UsersDocumentInfoRepository;
import com.sagar.lotse.util.GenericFileUtil;
import com.sagar.lotse.util.NullAwareBeanUtil;
import lombok.RequiredArgsConstructor;
import org.apache.commons.beanutils.BeanUtilsBean;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UsersInfoServiceImpl implements UsersInfoService, CommonMessages {

    private final GenericFileUtil genericFileUtil;
    private final UsersInfoHelper usersInfoHelper;
    private final UsersBasicInfoRepository usersBasicInfoRepository;
    private final UsersAddressInfoRepository usersAddressInfoRepository;
    private final UsersDocumentInfoRepository usersDocumentInfoRepository;
    private final BeanUtilsBean nullAwareBeanUtil = new NullAwareBeanUtil();

    @Override
    public void saveAndUpdateUsersBasicInfo(UsersBasicInfoRequestPojo usersBasicInfoRequestPojo) {
        UsersBasicInfo usersBasicInfo = new UsersBasicInfo();
        UsersBasicInfo existingUsersBasicInfo = new UsersBasicInfo();
        String userImage;

        try {
            if (usersBasicInfoRequestPojo.getId() == null) {
                nullAwareBeanUtil.copyProperties(usersBasicInfo, usersBasicInfoRequestPojo);
                userImage = genericFileUtil.saveFileToTemp(usersBasicInfoRequestPojo.getUserImage());

            } else {
                existingUsersBasicInfo = usersBasicInfoRepository.findById(usersBasicInfoRequestPojo.getId()).
                        orElseThrow(() -> new RuntimeException(USER + DATA_NOT_FOUND));
                nullAwareBeanUtil.copyProperties(usersBasicInfo, existingUsersBasicInfo);
                nullAwareBeanUtil.copyProperties(usersBasicInfo, usersBasicInfoRequestPojo);
                userImage = genericFileUtil.updateFile(usersBasicInfoRequestPojo.getUserImage(),
                        existingUsersBasicInfo.getUserImage());
            }

            userImage = genericFileUtil.saveFile(userImage);
            usersBasicInfo.setUserImage(userImage);
            usersBasicInfoRepository.save(usersBasicInfo);
        } catch (Exception e) {
            handleFileOnUsersBasicInfoFailure(usersBasicInfoRequestPojo, existingUsersBasicInfo, usersBasicInfo);
            throw new RuntimeException(USER + FAILED_TO_SAVE, e);
        }
    }

    @Override
    public void saveAndUpdateUsersAddressInfo(UsersAddressInfoRequestPojo usersAddressInfoRequestPojo) {
        try {
            UsersAddressInfo usersAddressInfo = new UsersAddressInfo();
            if (usersAddressInfoRequestPojo.getId() == null) {
                nullAwareBeanUtil.copyProperties(usersAddressInfo, usersAddressInfoRequestPojo);
                UsersBasicInfoResponsePojo usersBasicInfoPojo = this.getUsersBasicInfo(usersAddressInfoRequestPojo.getUsersBasicInfoId());
                UsersBasicInfo usersBasicInfo = new UsersBasicInfo();
                nullAwareBeanUtil.copyProperties(usersBasicInfo, usersBasicInfoPojo);
                usersAddressInfo.setUsersBasicInfo(usersBasicInfo);
            } else {
                UsersAddressInfo existingUsersAddressInfo;
                existingUsersAddressInfo = usersAddressInfoRepository.findById(usersAddressInfoRequestPojo.getId()).
                        orElseThrow(() -> new RuntimeException(USER + DATA_NOT_FOUND));
                nullAwareBeanUtil.copyProperties(usersAddressInfo, existingUsersAddressInfo);
                nullAwareBeanUtil.copyProperties(usersAddressInfo, usersAddressInfoRequestPojo);
            }
            usersAddressInfoRepository.save(usersAddressInfo);
        } catch (Exception e) {
            throw new RuntimeException(USER + FAILED_TO_SAVE, e);
        }
    }

    @Override
    public void saveAndUpdateUsersDocumentInfo(UsersDocumentInfoRequestPojo usersDocumentInfoRequestPojo) {
        UsersDocumentInfo usersDocumentInfo = new UsersDocumentInfo();
        UsersDocumentInfo existingUsersDocumentInfo = new UsersDocumentInfo();
        String citizenshipImage;
        String drivingLicenseImage;
        String passportImage;
        String panCardImage;
        String voterIdImage;
        String nationalIdImage;
        String medicalLicenseImage;
        try {
            if (usersDocumentInfoRequestPojo.getId() == null) {
                nullAwareBeanUtil.copyProperties(usersDocumentInfo, usersDocumentInfoRequestPojo);
                citizenshipImage = genericFileUtil.saveFileToTemp(usersDocumentInfoRequestPojo.getCitizenshipImage());
                drivingLicenseImage = genericFileUtil.saveFileToTemp(usersDocumentInfoRequestPojo.getDrivingLicenseImage());
                passportImage = genericFileUtil.saveFileToTemp(usersDocumentInfoRequestPojo.getPassportImage());
                panCardImage = genericFileUtil.saveFileToTemp(usersDocumentInfoRequestPojo.getPanCardImage());
                voterIdImage = genericFileUtil.saveFileToTemp(usersDocumentInfoRequestPojo.getVoterIdImage());
                nationalIdImage = genericFileUtil.saveFileToTemp(usersDocumentInfoRequestPojo.getNationalIdImage());
                medicalLicenseImage = genericFileUtil.saveFileToTemp(usersDocumentInfoRequestPojo.getMedicalLicenseImage());
            } else {
                existingUsersDocumentInfo = usersDocumentInfoRepository.findById(usersDocumentInfoRequestPojo.getId())
                        .orElseThrow(() -> new RuntimeException(USER + DATA_NOT_FOUND));
                nullAwareBeanUtil.copyProperties(usersDocumentInfo, existingUsersDocumentInfo);
                nullAwareBeanUtil.copyProperties(usersDocumentInfo, usersDocumentInfoRequestPojo);
                citizenshipImage = genericFileUtil.updateFile(usersDocumentInfoRequestPojo.getCitizenshipImage(),
                        existingUsersDocumentInfo.getCitizenshipImage());
                drivingLicenseImage = genericFileUtil.updateFile(usersDocumentInfoRequestPojo.getDrivingLicenseImage(),
                        existingUsersDocumentInfo.getDrivingLicenseImage());
                passportImage = genericFileUtil.updateFile(usersDocumentInfoRequestPojo.getPassportImage(),
                        existingUsersDocumentInfo.getPassportImage());
                panCardImage = genericFileUtil.updateFile(usersDocumentInfoRequestPojo.getPanCardImage(),
                        existingUsersDocumentInfo.getPanCardImage());
                voterIdImage = genericFileUtil.updateFile(usersDocumentInfoRequestPojo.getVoterIdImage(),
                        existingUsersDocumentInfo.getVoterIdImage());
                nationalIdImage = genericFileUtil.updateFile(usersDocumentInfoRequestPojo.getNationalIdImage(),
                        existingUsersDocumentInfo.getNationalIdImage());
                medicalLicenseImage = genericFileUtil.updateFile(usersDocumentInfoRequestPojo.getMedicalLicenseImage(),
                        existingUsersDocumentInfo.getMedicalLicenseImage());
            }
            citizenshipImage = genericFileUtil.saveFile(citizenshipImage);
            drivingLicenseImage = genericFileUtil.saveFile(drivingLicenseImage);
            passportImage = genericFileUtil.saveFile(passportImage);
            panCardImage = genericFileUtil.saveFile(panCardImage);
            voterIdImage = genericFileUtil.saveFile(voterIdImage);
            nationalIdImage = genericFileUtil.saveFile(nationalIdImage);
            medicalLicenseImage = genericFileUtil.saveFile(medicalLicenseImage);
            usersDocumentInfo.setCitizenshipImage(citizenshipImage);
            usersDocumentInfo.setDrivingLicenseImage(drivingLicenseImage);
            usersDocumentInfo.setPassportImage(passportImage);
            usersDocumentInfo.setPanCardImage(panCardImage);
            usersDocumentInfo.setVoterIdImage(voterIdImage);
            usersDocumentInfo.setNationalIdImage(nationalIdImage);
            usersDocumentInfo.setMedicalLicenseImage(medicalLicenseImage);
            usersDocumentInfoRepository.save(usersDocumentInfo);
        } catch (Exception e) {
            handleFileOnUsersDocumentInfoFailure(usersDocumentInfoRequestPojo, existingUsersDocumentInfo, usersDocumentInfo);
            throw new RuntimeException(USER + FAILED_TO_SAVE, e);

        }

    }

    @Override
    public UsersBasicInfoResponsePojo getUsersBasicInfo(Long id) {
        try {
            return usersInfoHelper.usersBasicInfo(id);
        } catch (InvocationTargetException | IllegalAccessException | DataNotFoundException e) {
            throw new RuntimeException(USER + FAILED_TO_SAVE, e);
        }
    }

    @Override
    public UsersAddressInfoResponsePojo getUsersAddressInfo(Long id) {
        try {
            return usersInfoHelper.getUsersAddressInfo(id);
        } catch (InvocationTargetException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public UsersDocumentInfoResponsePojo getUsersDocumentInfo(Long id) {
        try {
            return usersInfoHelper.getUsersDocumentInfo(id);
        } catch (InvocationTargetException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }


    @Override
    public List<String> getGender() {
        return Arrays.stream(Gender.values()).map(Enum::name).collect(Collectors.toList());
    }

    @Override
    public List<String> getUserCategory() {
        return Arrays.stream(UserCategory.values()).map(Enum::name).collect(Collectors.toList());
    }

    @Override
    public List<String> getUsersRegistrationCountry() {
        return Arrays.stream(RegistrationCountry.values()).map(Enum::name).collect(Collectors.toList());
    }

    @Override
    public List<String> getUsersRegistrationType() {
        return Arrays.stream(RegistrationType.values()).map(Enum::name).collect(Collectors.toList());
    }

    @Override
    public List<String> getUsersDocumentsType() {
        return Arrays.stream(DocumentsType.values()).map(Enum::name).collect(Collectors.toList());
    }

    private void handleFileOnUsersBasicInfoFailure(UsersBasicInfoRequestPojo usersBasicInfoRequestPojo,
                                                   UsersBasicInfo existingUserInfo,
                                                   UsersBasicInfo usersBasicInfo) {
        try {
            if (usersBasicInfoRequestPojo.getId() == null) {
                // remove uploaded image
                genericFileUtil.deleteFile(usersBasicInfo.getUserImage());
            } else if (existingUserInfo != null) {
                // try restoring old image
                genericFileUtil.reSaveFile(existingUserInfo.getUserImage());
            }
        } catch (IOException ex) {
            throw new RuntimeException(FILE_HANDLING_FAILED_ON_ROLLBACK, ex);
        }
    }

    private void handleFileOnUsersDocumentInfoFailure(UsersDocumentInfoRequestPojo usersDocumentInfoRequestPojo,
                                                      UsersDocumentInfo existingUsersDocumentInfo,
                                                      UsersDocumentInfo usersDocumentInfo) {
        try {
            if (usersDocumentInfoRequestPojo.getId() == null) {
                // remove uploaded image
                genericFileUtil.deleteFile(usersDocumentInfo.getCitizenshipImage());
                genericFileUtil.deleteFile(usersDocumentInfo.getDrivingLicenseImage());
                genericFileUtil.deleteFile(usersDocumentInfo.getPassportImage());
                genericFileUtil.deleteFile(usersDocumentInfo.getPanCardImage());
                genericFileUtil.deleteFile(usersDocumentInfo.getVoterIdImage());
                genericFileUtil.deleteFile(usersDocumentInfo.getNationalIdImage());
                genericFileUtil.deleteFile(usersDocumentInfo.getMedicalLicenseImage());
            } else if (existingUsersDocumentInfo != null) {
                // try restoring old image
                genericFileUtil.reSaveFile(existingUsersDocumentInfo.getCitizenshipImage());
                genericFileUtil.reSaveFile(existingUsersDocumentInfo.getDrivingLicenseImage());
                genericFileUtil.reSaveFile(existingUsersDocumentInfo.getPassportImage());
                genericFileUtil.reSaveFile(existingUsersDocumentInfo.getPanCardImage());
                genericFileUtil.reSaveFile(existingUsersDocumentInfo.getVoterIdImage());
                genericFileUtil.reSaveFile(existingUsersDocumentInfo.getNationalIdImage());
                genericFileUtil.reSaveFile(existingUsersDocumentInfo.getMedicalLicenseImage());
            }
        } catch (IOException ex) {
            throw new RuntimeException(FILE_HANDLING_FAILED_ON_ROLLBACK, ex);
        }
    }
}
