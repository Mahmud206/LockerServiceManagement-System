package com.LockerService.Locker.Service.Management.DTO;

public class JWTAUTHRESPONSEDto {
    private String accessToken;
    private String tokenType = "Bearer";

    public JWTAUTHRESPONSEDto(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public String getTokenType() {
        return tokenType;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public void setTokenType(String tokenType) {
        this.tokenType = tokenType;
    }
}
