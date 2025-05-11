package com.sagar.lotse.controller;

import com.sagar.lotse.common.constant.CommonMessages;
import com.sagar.lotse.pojo.common.request.UsersAddressInfoRequestPojo;
import com.sagar.lotse.pojo.common.request.UsersBasicInfoRequestPojo;
import com.sagar.lotse.pojo.common.request.UsersDocumentInfoRequestPojo;
import com.sagar.lotse.pojo.common.response.GlobalApiResponse;
import com.sagar.lotse.service.UsersInfoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("users")
@RequiredArgsConstructor
public class UsersInfoController implements CommonMessages {

    private final UsersInfoService usersInfoService;

    @PostMapping("/saveAndUpdateUserBasic")
    public ResponseEntity<GlobalApiResponse> saveAndUpdateUsersBasicInfo(@ModelAttribute @Valid
                                                                         UsersBasicInfoRequestPojo usersBasicInfoRequestPojo) {
        usersInfoService.saveAndUpdateUsersBasicInfo(usersBasicInfoRequestPojo);
        return ResponseEntity.ok(GlobalApiResponse
                .builder()
                .data(null)
                .message(USER + BASIC_INFO + (usersBasicInfoRequestPojo.getId() == null ? SAVED_SUCCESSFULLY : UPDATED_SUCCESSFULLY))
                .status(true)
                .build()
        );
    }

    @PostMapping("/saveAndUpdateUsersAddressInfo")
    public ResponseEntity<GlobalApiResponse> saveAndUpdateUsersAddressInfo(@ModelAttribute @Valid
                                                                           UsersAddressInfoRequestPojo usersAddressInfoRequestPojo) {
        usersInfoService.saveAndUpdateUsersAddressInfo(usersAddressInfoRequestPojo);
        return ResponseEntity.ok(GlobalApiResponse
                .builder()
                .data(null)
                .message(USER + ADDRESS_INFO + (usersAddressInfoRequestPojo.getId() == null ? SAVED_SUCCESSFULLY : UPDATED_SUCCESSFULLY))
                .status(true)
                .build());
    }

    @PostMapping("/saveAndUpdateUsersDocumentInfo")
    public ResponseEntity<GlobalApiResponse> saveAndUpdateUsersDocumentInfo(@ModelAttribute @Valid
                                                                            UsersDocumentInfoRequestPojo usersDocumentInfoRequestPojo) {
        usersInfoService.saveAndUpdateUsersDocumentInfo(usersDocumentInfoRequestPojo);
        return ResponseEntity.ok(GlobalApiResponse
                .builder()
                .data(null)
                .message(USER + DOCUMENT_INFO + (usersDocumentInfoRequestPojo.getId() == null ? SAVED_SUCCESSFULLY : UPDATED_SUCCESSFULLY))
                .status(true)
                .build());
    }

    @GetMapping("/getUsersBasicInfo")
    public ResponseEntity<GlobalApiResponse> getUsersBasicInfo(@RequestParam Long id) {
        return ResponseEntity.ok(GlobalApiResponse
                .builder()
                .data(usersInfoService.getUsersBasicInfo(id))
                .message(USER + BASIC_INFO + DATA_FETCHED_SUCCESSFULLY)
                .status(true)
                .build());
    }

    @GetMapping("/getUsersAddressInfo")
    public ResponseEntity<GlobalApiResponse> getUsersAddressInfo(@RequestParam Long id) {
        return ResponseEntity.ok(GlobalApiResponse
                .builder()
                .data(usersInfoService.getUsersAddressInfo(id))
                .message(USER + ADDRESS_INFO + DATA_FETCHED_SUCCESSFULLY)
                .status(true)
                .build());
    }

    @GetMapping("/getUsersDocumentInfo")
    public ResponseEntity<GlobalApiResponse> getUsersDocumentInfo(@RequestParam Long id) {
        return ResponseEntity.ok(GlobalApiResponse
                .builder()
                .data(usersInfoService.getUsersDocumentInfo(id))
                .message(USER + DOCUMENT_INFO + DATA_FETCHED_SUCCESSFULLY)
                .status(true)
                .build());
    }

    @GetMapping("/getUser")
    public ResponseEntity<GlobalApiResponse> getUser(@RequestParam Long id) {
        return ResponseEntity.ok(GlobalApiResponse
                .builder()
                .data(usersInfoService.getUser(id))
                .message(USER + DATA_FETCHED_SUCCESSFULLY)
                .status(true)
                .build());
    }

    @GetMapping("/getUsersGender")
    public ResponseEntity<GlobalApiResponse> getUsersGender() {
        return ResponseEntity.ok(GlobalApiResponse
                .builder()
                .data(usersInfoService.getGender())
                .message(DATA_FETCHED_SUCCESSFULLY)
                .status(true)
                .build());
    }

    @GetMapping("/getUsersCategory")
    public ResponseEntity<GlobalApiResponse> getUsersCategory() {
        return ResponseEntity.ok(GlobalApiResponse
                .builder()
                .data(usersInfoService.getUserCategory())
                .message(DATA_FETCHED_SUCCESSFULLY)
                .status(true)
                .build());
    }

    @GetMapping("/getUsersRegistrationCountry")
    public ResponseEntity<GlobalApiResponse> getUsersRegistrationCountry() {
        return ResponseEntity.ok(GlobalApiResponse
                .builder()
                .data(usersInfoService.getUsersRegistrationCountry())
                .message(DATA_FETCHED_SUCCESSFULLY)
                .status(true)
                .build());
    }

    @GetMapping("/getUsersRegistrationType")
    public ResponseEntity<GlobalApiResponse> getUsersRegistrationType() {
        return ResponseEntity.ok(GlobalApiResponse
                .builder()
                .data(usersInfoService.getUsersRegistrationType())
                .message(DATA_FETCHED_SUCCESSFULLY)
                .status(true)
                .build());
    }

    @GetMapping("/getUsersDocumentType")
    public ResponseEntity<GlobalApiResponse> getUsersDocumentType() {
        return ResponseEntity.ok(GlobalApiResponse
                .builder()
                .data(usersInfoService.getUsersDocumentsType())
                .message(DATA_FETCHED_SUCCESSFULLY)
                .status(true)
                .build());
    }
}
