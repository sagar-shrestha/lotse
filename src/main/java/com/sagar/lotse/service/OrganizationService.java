package com.sagar.lotse.service;

import com.sagar.lotse.pojo.common.request.OrganizationRequestPojo;
import com.sagar.lotse.pojo.common.response.OrganizationResponsePojo;

import java.util.List;

public interface OrganizationService {

    void saveAndUpdateOrganization(OrganizationRequestPojo organizationRequestPojo);

    List<OrganizationResponsePojo> getOrganization(Integer id);
}
