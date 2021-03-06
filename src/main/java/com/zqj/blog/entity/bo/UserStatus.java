package com.zqj.blog.entity.bo;

public enum UserStatus {
    ACTIVE("A"),
    INACTIVE("I"),
    LOCK("L");

    private String code;

    UserStatus(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
