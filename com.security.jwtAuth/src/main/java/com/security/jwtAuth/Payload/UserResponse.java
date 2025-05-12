package com.security.jwtAuth.Payload;


import lombok.Data;


public class UserResponse {
    public UserResponse(String token, String note) {
        this.token = token;
        this.note = note;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    private String token;
    private String note;


}
