package com.example.security_app.controller;


import com.fasterxml.jackson.annotation.JsonProperty;

public class AuthenticationResponse {

    @JsonProperty("access_token")
    private String accessToken;
    @JsonProperty("refresh_token")
    private String refreshToken;

    public AuthenticationResponse(String accessToken, String refreshToken) {
        this.accessToken = accessToken;
        this.refreshToken = refreshToken;
    }


    public static AuthenticationResponseBuilder builder() {
        return new AuthenticationResponseBuilder();
    }

    public String getAccessToken() {
        return this.accessToken;
    }

    public String getRefreshToken() {
        return this.refreshToken;
    }

    @JsonProperty("access_token")
    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    @JsonProperty("refresh_token")
    public void setRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
    }

    public static class AuthenticationResponseBuilder {
        private String accessToken;
        private String refreshToken;

        AuthenticationResponseBuilder() {
        }

        @JsonProperty("access_token")
        public AuthenticationResponseBuilder accessToken(String accessToken) {
            this.accessToken = accessToken;
            return this;
        }

        @JsonProperty("refresh_token")
        public AuthenticationResponseBuilder refreshToken(String refreshToken) {
            this.refreshToken = refreshToken;
            return this;
        }

        public AuthenticationResponse build() {
            return new AuthenticationResponse(this.accessToken, this.refreshToken);
        }

        public String toString() {
            return "AuthenticationResponse.AuthenticationResponseBuilder(accessToken=" + this.accessToken + ", refreshToken=" + this.refreshToken + ")";
        }
    }
}
