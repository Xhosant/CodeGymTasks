package com.codegym.task.task22.task2208;

import java.util.LinkedHashMap;
import java.util.Map;

/* 
Build a WHERE query

*/

public class Solution {
    public static void main(String[] args) {
        Map<String, String> paramsMap = new LinkedHashMap<String, String>();
        paramsMap.put("name", "Johnson");
        paramsMap.put("country", "United States");
        paramsMap.put("city", "Los Angeles");
        paramsMap.put("age", null);

        System.out.println(getQuery(paramsMap));
    }

    public static String getQuery(Map<String, String> params) {
        StringBuilder queryBuilder = new StringBuilder();
        for (String s : params.keySet()) {
            String value = params.get(s);
            if (value == null) {
                continue;
            }
            if (queryBuilder.toString().length() != 0) {
                queryBuilder.append(" and ");
            }
            queryBuilder.append(s + " = '" + value + "'");
        }
        return queryBuilder.toString();
    }
}
