package com.sagar.lotse.helper;

import com.sagar.lotse.common.constant.CommonMessages;
import com.sagar.lotse.entity.OrganizationInfo;
import com.sagar.lotse.pojo.common.response.OrganizationResponsePojo;
import com.sagar.lotse.repository.OrganizationRepository;
import com.sagar.lotse.util.GenericFileUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class OrganizationHelper implements CommonMessages {

    private final OrganizationRepository organizationRepository;
    private final GenericFileUtil genericFileUtil;

    public List<OrganizationResponsePojo> getOrganizationById(Integer id) {
        OrganizationInfo organizationInfo = organizationRepository.findOrganizationById(id)
                .orElseThrow(() -> new RuntimeException(ORGANIZATION + DATA_NOT_FOUND));
        return Collections.singletonList(OrganizationResponsePojo.builder()
                .id(organizationInfo.getId())
                .organizationName(organizationInfo.getOrganizationName())
                .address(organizationInfo.getAddress())
                .panOrVat(organizationInfo.getPanOrVat())
                .logo(organizationInfo.getImageLogo())
                .build());
    }

    public List<OrganizationResponsePojo> getAllOrganizations() {
        return organizationRepository.getAllOrganizations().stream().map(organizationInfo ->
                OrganizationResponsePojo.builder()
                        .id(organizationInfo.getId())
                        .organizationName(organizationInfo.getOrganizationName())
                        .address(organizationInfo.getAddress())
                        .panOrVat(organizationInfo.getPanOrVat())
                        .logo(organizationInfo.getImageLogo())
                        .build()
        ).collect(Collectors.toList());
    }
}