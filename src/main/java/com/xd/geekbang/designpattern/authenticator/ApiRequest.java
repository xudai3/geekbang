package com.xd.geekbang.designpattern.authenticator;

import java.net.MalformedURLException;
import java.net.URL;

public class ApiRequest {
    private String baseUrl;
    private String token;
    private String appId;
    private long timestamp;

    public ApiRequest(String baseUrl, String token, String appId, long timestamp){
        this.baseUrl = baseUrl;
        this.token = token;
        this.appId = appId;
        this.timestamp = timestamp;
    }

//    public static ApiRequest createFromFullUrl(String fullUrl){
//        try{
//            URL url = new URL(fullUrl);
//            String query = url.getQuery();
//        } catch (MalformedURLException e) {
//            System.out.println("Malformed URL: " + e.getMessage());
//        }
//    }

    public String getBaseUrl(){return this.baseUrl;}
    public String getToken(){return this.token;}
    public String getAppId(){return this.appId;}
    public long getTimestamp(){return this.timestamp;}
}


