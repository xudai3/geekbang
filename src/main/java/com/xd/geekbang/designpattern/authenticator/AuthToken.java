package com.xd.geekbang.designpattern.authenticator;

import java.sql.Timestamp;
import java.util.Date;
import java.util.Map;

public class AuthToken {
    private static final long DEFAULT_EXPIRED_TIME_INTERVAL = 1 * 60 * 1000;
    private String token;
    private long createTime;
    private long expiredTimeInterval = DEFAULT_EXPIRED_TIME_INTERVAL;

    public AuthToken(String token, long createTime){
        this.token = token;
        this.createTime = createTime;
    }
    public AuthToken(String token, long createTime, long expiredTimeInterval){
        this.token = token;
        this.createTime = createTime;
        this.expiredTimeInterval = expiredTimeInterval;
    }
//    public static AuthToken create(String baseUrl, long createTime, Map<String, String> params){
//        return new AuthToken();
//    }
    public String getToken(){
        return this.token;
    }
    public boolean isExpired(){
        return this.createTime + this.expiredTimeInterval > new Date().getTime();
    }
    public boolean match(AuthToken authToken){
        return this.token.equals(authToken.getToken());
    }
}
