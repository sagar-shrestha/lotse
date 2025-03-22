package com.sagar.lotse.service;

import com.sagar.lotse.common.constant.CommonMessages;
import com.sagar.lotse.entity.UsersInfo;
import com.sagar.lotse.pojo.common.request.UsersInfoRequestPojo;
import com.sagar.lotse.repository.UsersInfoReposititory;
import com.sagar.lotse.util.GenericFileUtil;
import com.sagar.lotse.util.NullAwareBeanUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UsersInfoServiceImpl implements UsersInfoService, CommonMessages {

    private final UsersInfoReposititory usersInfoReposititory;
    private final GenericFileUtil genericFileUtil;
    private final NullAwareBeanUtil nullAwareBeanUtil = new NullAwareBeanUtil();

    @Override
    public String saveAndUpdateUsersInfo(UsersInfoRequestPojo usersInfoRequestPojo) {
        UsersInfo usersInfo = new UsersInfo();
        UsersInfo existingUserInfo = new UsersInfo();
        String userImage;
        String citizenshipImage;
        String drivingLicenseImage;
        String passportImage;
        String panCardImage;
        String voterIdImage;
        String nationalIdImage;
        String medicalLicenseImage;

        try {
            if (usersInfoRequestPojo.getId() == null) {
                nullAwareBeanUtil.copyProperties(usersInfo, usersInfoRequestPojo);
                userImage = genericFileUtil.saveFileToTemp(usersInfoRequestPojo.getUserImage());
                citizenshipImage = genericFileUtil.saveFileToTemp(usersInfoRequestPojo.getCitizenshipImage());
                drivingLicenseImage = genericFileUtil.saveFileToTemp(usersInfoRequestPojo.getDrivingLicenseImage());
                passportImage = genericFileUtil.saveFileToTemp(usersInfoRequestPojo.getPassportImage());
                panCardImage = genericFileUtil.saveFileToTemp(usersInfoRequestPojo.getPanCardImage());
                voterIdImage = genericFileUtil.saveFileToTemp(usersInfoRequestPojo.getVoterIdImage());
                nationalIdImage = genericFileUtil.saveFileToTemp(usersInfoRequestPojo.getNationalIdImage());
                medicalLicenseImage = genericFileUtil.saveFileToTemp(usersInfoRequestPojo.getMedicalLicenseImage());
            } else {
                existingUserInfo = usersInfoReposititory.findById(usersInfoRequestPojo.getId()).
                        orElseThrow(() -> new RuntimeException("User not found"));
                nullAwareBeanUtil.copyProperties(usersInfo, existingUserInfo);
                nullAwareBeanUtil.copyProperties(usersInfo, usersInfoRequestPojo);
                userImage = genericFileUtil.updateFile(usersInfoRequestPojo.getUserImage(),
                        existingUserInfo.getUserImage());
                citizenshipImage = genericFileUtil.updateFile(usersInfoRequestPojo.getCitizenshipImage(),
                        existingUserInfo.getCitizenshipImage());
                drivingLicenseImage = genericFileUtil.updateFile(usersInfoRequestPojo.getUserImage(),
                        existingUserInfo.getDrivingLicenseImage());
                passportImage = genericFileUtil.updateFile(usersInfoRequestPojo.getPassportImage(),
                        existingUserInfo.getPassportImage());
                panCardImage = genericFileUtil.updateFile(usersInfoRequestPojo.getPanCardImage(),
                        existingUserInfo.getPanCardImage());
                voterIdImage = genericFileUtil.updateFile(usersInfoRequestPojo.getVoterIdImage(),
                        existingUserInfo.getVoterIdImage());
                nationalIdImage = genericFileUtil.updateFile(usersInfoRequestPojo.getNationalIdImage(),
                        existingUserInfo.getNationalIdImage());
                medicalLicenseImage = genericFileUtil.updateFile(usersInfoRequestPojo.getMedicalLicenseImage(),
                        existingUserInfo.getMedicalLicenseImage());
            }

            userImage = genericFileUtil.saveFile(userImage);
            citizenshipImage = genericFileUtil.saveFile(citizenshipImage);
            drivingLicenseImage = genericFileUtil.saveFile(drivingLicenseImage);
            passportImage = genericFileUtil.saveFile(passportImage);
            panCardImage = genericFileUtil.saveFile(panCardImage);
            voterIdImage = genericFileUtil.saveFile(voterIdImage);
            nationalIdImage = genericFileUtil.saveFile(nationalIdImage);
            medicalLicenseImage = genericFileUtil.saveFile(medicalLicenseImage);
            usersInfo.setUserImage(userImage);
            usersInfo.setCitizenshipImage(citizenshipImage);
            usersInfo.setDrivingLicenseImage(drivingLicenseImage);
            usersInfo.setPassportImage(passportImage);
            usersInfo.setPanCardImage(panCardImage);
            usersInfo.setVoterIdImage(voterIdImage);
            usersInfo.setNationalIdImage(nationalIdImage);
            usersInfo.setMedicalLicenseImage(medicalLicenseImage);
            usersInfoReposititory.save(usersInfo);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "";
    }
}
