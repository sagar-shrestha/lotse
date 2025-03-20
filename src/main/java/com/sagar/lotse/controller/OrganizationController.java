package com.sagar.lotse.controller;

import com.sagar.lotse.common.constant.CommonMessages;
import com.sagar.lotse.pojo.common.GlobalApiResponse;
import com.sagar.lotse.pojo.common.OrganizationRequestPojo;
import com.sagar.lotse.service.OrganizationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("organization")
@RequiredArgsConstructor
public class OrganizationController implements CommonMessages {

    private final OrganizationService organizationService;

    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    private ResponseEntity<GlobalApiResponse> saveOrganization(@ModelAttribute @Valid OrganizationRequestPojo organizationRequestPojo) {
        organizationService.saveOrganization(organizationRequestPojo);
        return ResponseEntity.ok(GlobalApiResponse
                .builder()
                .data(null)
                .message("Organization" + SAVED_SUCCESSFULLY)
                .status(true)
                .build());
    }

}