package com.transferz.util;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ErrorsMapperUtil {

    public static Map<String, List<String>> getErrorsMap(List<String> errors) {
        Map<String, List<String>> errorResponse = new HashMap<>();
        errorResponse.put("errors", errors);
        return errorResponse;
    }

}