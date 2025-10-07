package com.jspiders.project.utils;

import com.jspiders.project.data.dto.CommonResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class ResponseUtil {

    public static ResponseEntity<CommonResponse> getOkResponse(String message,Object data)
    {
        CommonResponse commonResponse = new CommonResponse();
        commonResponse.setHttpStatus(HttpStatus.OK);
        commonResponse.setSuccess(true);
        commonResponse.setStatusCode(HttpStatus.OK.value());

        commonResponse.setMessage(message);
        commonResponse.setData(data);

        return ResponseEntity.ok(commonResponse);
    }
}
