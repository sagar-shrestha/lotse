package com.sagar.lotse.pojo.common.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class GlobalApiResponse {

    private String message;
    private Object data;
    private boolean status;
}
