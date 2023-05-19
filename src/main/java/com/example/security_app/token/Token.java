package com.example.security_app.token;

import com.example.security_app.model.User;
import jakarta.persistence.*;

@Entity
public class Token {

    @Id
    @GeneratedValue
    public Integer id;

    @Column(unique = true)
    public String token;

    @Enumerated(EnumType.STRING)
    public TokenType tokenType = TokenType.BEARER;

    public boolean revoked;

    public boolean expired;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    public User user;

    public Token(Integer id, String token, TokenType tokenType, boolean revoked, boolean expired, User user) {
        this.id = id;
        this.token = token;
        this.tokenType = tokenType;
        this.revoked = revoked;
        this.expired = expired;
        this.user = user;
    }

    public Token() {
    }

    public static TokenBuilder builder() {
        return new TokenBuilder();
    }

    public Integer getId() {
        return this.id;
    }

    public String getToken() {
        return this.token;
    }

    public TokenType getTokenType() {
        return this.tokenType;
    }

    public boolean isRevoked() {
        return this.revoked;
    }

    public boolean isExpired() {
        return this.expired;
    }

    public User getUser() {
        return this.user;
    }

    public void setRevoked(boolean revoked) {
        this.revoked = revoked;
    }

    public void setExpired(boolean expired) {
        this.expired = expired;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public static class TokenBuilder {
        private Integer id;
        private String token;
        private TokenType tokenType;
        private boolean revoked;
        private boolean expired;
        private User user;

        TokenBuilder() {
        }

        public TokenBuilder id(Integer id) {
            this.id = id;
            return this;
        }

        public TokenBuilder token(String token) {
            this.token = token;
            return this;
        }

        public TokenBuilder tokenType(TokenType tokenType) {
            this.tokenType = tokenType;
            return this;
        }

        public TokenBuilder revoked(boolean revoked) {
            this.revoked = revoked;
            return this;
        }

        public TokenBuilder expired(boolean expired) {
            this.expired = expired;
            return this;
        }

        public TokenBuilder user(User user) {
            this.user = user;
            return this;
        }

        public Token build() {
            return new Token(this.id, this.token, this.tokenType, this.revoked, this.expired, this.user);
        }

    }
}
