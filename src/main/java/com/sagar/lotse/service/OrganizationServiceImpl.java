package com.sagar.lotse.service;

import com.sagar.lotse.entity.OrganizationInfo;
import com.sagar.lotse.pojo.common.OrganizationRequestPojo;
import com.sagar.lotse.repository.OrganizationRepository;
import com.sagar.lotse.util.GenericFileUtil;
import com.sagar.lotse.util.NullAwareBeanUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.File;

@Service
@RequiredArgsConstructor
public class OrganizationServiceImpl implements OrganizationService {

    private final OrganizationRepository organizationRepository;
    private final GenericFileUtil genericFileUtil;
    private final NullAwareBeanUtil nullAwareBeanUtil = new NullAwareBeanUtil();


    @Override
    public void saveOrganization(OrganizationRequestPojo organizationRequestPojo) {
        try {
            OrganizationInfo organizationInfo = new OrganizationInfo();
            nullAwareBeanUtil.copyProperties(organizationInfo, organizationRequestPojo);
            organizationInfo.setLogo(genericFileUtil.saveFile(organizationRequestPojo.getLogo()));
            OrganizationInfo organizationInfo1 = new OrganizationInfo();
            organizationRepository.save(organizationInfo1);
        } catch (Exception e) {
            genericFileUtil.deleteFile((File) organizationRequestPojo.getLogo());
            throw new RuntimeException(e);
        }
    }
}
