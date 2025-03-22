package com.sagar.lotse.common.controller;

import com.sagar.lotse.common.constant.CommonMessages;
import com.sagar.lotse.common.service.CommonService;
import com.sagar.lotse.pojo.common.response.GlobalApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping
public class CommonController implements CommonMessages {

    private final CommonService commonService;

    @PostMapping(value = "getImage", produces = MediaType.MULTIPART_MIXED_VALUE)
    public ResponseEntity<GlobalApiResponse> downloadImage(@RequestParam("image") String image) {
        commonService.getImage(image);
        return ResponseEntity.ok(GlobalApiResponse
                .builder()
                .data(null)
                .message(DATA_FETCHED_SUCCESSFULLY)
                .status(true)
                .build());
    }
}
