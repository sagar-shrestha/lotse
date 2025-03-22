package com.sagar.lotse.common.service;

import com.sagar.lotse.util.GenericFileUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CommonServiceImpl implements CommonService {

    private final GenericFileUtil genericFileUtil;


    @Override
    public void getImage(String image) {
        genericFileUtil.getFile(image);
    }
}
