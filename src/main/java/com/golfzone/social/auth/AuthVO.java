package com.golfzone.social.auth;

public class AuthVO {

    private int authNum;
    private String authName;
    private String authDescription;

    public int getAuthNum() {
        return authNum;
    }

    public void setAuthNum(int authNum) {
        this.authNum = authNum;
    }

    public String getAuthName() {
        return authName;
    }

    public void setAuthName(String authName) {
        this.authName = authName;
    }

    public String getAuthDescription() {
        return authDescription;
    }

    public void setAuthDescription(String authDescription) {
        this.authDescription = authDescription;
    }

    @Override
    public String toString() {
        return "AuthVO{" +
                "authNum=" + authNum +
                ", authName='" + authName + '\'' +
                ", authDescription='" + authDescription + '\'' +
                '}';
    }
}
