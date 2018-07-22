package com.onmo.wgames.sdk;

public class WGameAccess {

    String token;
    
    public WGameAccess(String token){
        this.token = token;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
