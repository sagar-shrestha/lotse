package com.sagar.lotse.service;

import com.sagar.lotse.common.constant.CommonMessages;
import com.sagar.lotse.entity.OrganizationInfo;
import com.sagar.lotse.helper.OrganizationHelper;
import com.sagar.lotse.pojo.common.request.OrganizationRequestPojo;
import com.sagar.lotse.pojo.common.response.OrganizationResponsePojo;
import com.sagar.lotse.repository.OrganizationRepository;
import com.sagar.lotse.util.GenericFileUtil;
import com.sagar.lotse.util.NullAwareBeanUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OrganizationServiceImpl implements OrganizationService, CommonMessages {

    private final OrganizationRepository organizationRepository;
    private final OrganizationHelper organizationHelper;
    private final GenericFileUtil genericFileUtil;
    private final NullAwareBeanUtil nullAwareBeanUtil = new NullAwareBeanUtil();


    @Override
    public void saveAndUpdateOrganization(OrganizationRequestPojo organizationRequestPojo) {
        OrganizationInfo organizationInfo = new OrganizationInfo();
        OrganizationInfo existingOrganizationInfo = new OrganizationInfo();
        String logo;
        try {
            if (organizationRequestPojo.getId() == null) {
                nullAwareBeanUtil.copyProperties(organizationInfo, organizationRequestPojo);
                logo = genericFileUtil.saveFileToTemp(organizationRequestPojo.getLogo());
            } else {
                existingOrganizationInfo = organizationRepository.findById(organizationRequestPojo.getId())
                        .orElseThrow(() -> new RuntimeException(ORGANIZATION + DATA_NOT_FOUND));
                nullAwareBeanUtil.copyProperties(organizationInfo, existingOrganizationInfo);
                nullAwareBeanUtil.copyProperties(organizationInfo, organizationRequestPojo);
                logo = genericFileUtil.updateFile(organizationRequestPojo.getLogo(), existingOrganizationInfo.getImageLogo());
            }
            logo = genericFileUtil.saveFile(logo);
            organizationInfo.setImageLogo(logo);
            organizationRepository.save(organizationInfo);
        } catch (Exception e) {
            handleFileOnFailure(organizationRequestPojo, existingOrganizationInfo, organizationInfo);
            throw new RuntimeException(ORGANIZATION + FAILED_TO_SAVE, e);
        }
    }

    private void handleFileOnFailure(OrganizationRequestPojo organizationRequestPojo, OrganizationInfo existingOrganizationInfo,
                                     OrganizationInfo organizationInfo) {
        try {
            if (organizationRequestPojo.getId() == null) {
                // New organization: remove uploaded logo
                genericFileUtil.deleteFile(organizationInfo.getImageLogo());
            } else if (existingOrganizationInfo != null) {
                // Update failed: try restoring old logo
                genericFileUtil.reSaveFile(existingOrganizationInfo.getImageLogo());
            }
        } catch (IOException ex) {
            throw new RuntimeException(FILE_HANDLING_FAILED_ON_ROLLBACK, ex);
        }
    }

    @Override
    public List<OrganizationResponsePojo> getOrganization(Integer id) {
        if (id != null) {
            return organizationHelper.getOrganizationById(id);
        } else {
            return organizationHelper.getAllOrganizations();
        }
    }
}
