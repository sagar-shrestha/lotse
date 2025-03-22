package com.sagar.lotse.helper;

import com.sagar.lotse.common.constant.CommonMessages;
import com.sagar.lotse.entity.OrganizationInfo;
import com.sagar.lotse.pojo.common.response.OrganizationResponsePojo;
import com.sagar.lotse.repository.OrganizationRepository;
import com.sagar.lotse.util.GenericFileUtil;
import com.sagar.lotse.util.NullAwareBeanUtil;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Component;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class OrganizationHelper implements CommonMessages {

    private final OrganizationRepository organizationRepository;
    private final NullAwareBeanUtil nullAwareBeanUtil = new NullAwareBeanUtil();

    public List<OrganizationResponsePojo> getOrganizationById(Integer id) throws InvocationTargetException, IllegalAccessException {
        OrganizationResponsePojo organizationResponsePojo = new OrganizationResponsePojo();
        OrganizationInfo organizationInfo = organizationRepository.findOrganizationById(id)
                .orElseThrow(() -> new RuntimeException(ORGANIZATION + DATA_NOT_FOUND));
        nullAwareBeanUtil.copyProperties(organizationResponsePojo, organizationInfo);
        return Collections.singletonList(organizationResponsePojo);
    }

    public List<OrganizationResponsePojo> getAllOrganizations() {
        try {
            List<OrganizationResponsePojo> organizationResponsePojoList = new ArrayList<>();
            for (OrganizationInfo organizationInfo : organizationRepository.getAllOrganizations()) {
                OrganizationResponsePojo organizationResponsePojo = apply(organizationInfo);
                organizationResponsePojoList.add(organizationResponsePojo);
            }
            return organizationResponsePojoList;
        } catch (Exception e) {
            return Collections.emptyList();
        }
    }

    private OrganizationResponsePojo apply(OrganizationInfo organizationInfo) throws InvocationTargetException, IllegalAccessException {
        OrganizationResponsePojo organizationResponsePojo = new OrganizationResponsePojo();
        nullAwareBeanUtil.copyProperties(organizationResponsePojo, organizationInfo);
        return organizationResponsePojo;
    }
}