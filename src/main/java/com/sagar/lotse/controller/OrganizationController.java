package com.sagar.lotse.controller;

import com.sagar.lotse.common.constant.CommonMessages;
import com.sagar.lotse.pojo.common.response.GlobalApiResponse;
import com.sagar.lotse.pojo.common.request.OrganizationRequestPojo;
import com.sagar.lotse.pojo.common.response.OrganizationResponsePojo;
import com.sagar.lotse.service.OrganizationService;
import jakarta.annotation.Nullable;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("organization")
@RequiredArgsConstructor
public class OrganizationController implements CommonMessages {

    private final OrganizationService organizationService;

    @PostMapping
    public ResponseEntity<GlobalApiResponse> saveOrganization(@ModelAttribute @Valid OrganizationRequestPojo organizationRequestPojo) {
        organizationService.saveAndUpdateOrganization(organizationRequestPojo);
        return ResponseEntity.ok(GlobalApiResponse
                .builder()
                .data(null)
                .message(ORGANIZATION + (organizationRequestPojo.getId() != null ? SAVED_SUCCESSFULLY : UPDATED_SUCCESSFULLY))
                .status(true)
                .build());
    }

    @PostMapping("getOrganization")
    public ResponseEntity<GlobalApiResponse> getOrganization(@RequestParam @Nullable Integer id) {
        List<OrganizationResponsePojo> organizationResponsePojos = organizationService.getOrganization(id);
        return ResponseEntity.ok(GlobalApiResponse
                .builder()
                .data(organizationResponsePojos)
                .message(DATA_FETCHED_SUCCESSFULLY)
                .status(true)
                .build());
    }
}