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

    public void setId(Integer id) {
        this.id = id;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public void setTokenType(TokenType tokenType) {
        this.tokenType = tokenType;
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

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof Token)) return false;
        final Token other = (Token) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$id = this.getId();
        final Object other$id = other.getId();
        if (this$id == null ? other$id != null : !this$id.equals(other$id)) return false;
        final Object this$token = this.getToken();
        final Object other$token = other.getToken();
        if (this$token == null ? other$token != null : !this$token.equals(other$token)) return false;
        final Object this$tokenType = this.getTokenType();
        final Object other$tokenType = other.getTokenType();
        if (this$tokenType == null ? other$tokenType != null : !this$tokenType.equals(other$tokenType)) return false;
        if (this.isRevoked() != other.isRevoked()) return false;
        if (this.isExpired() != other.isExpired()) return false;
        final Object this$user = this.getUser();
        final Object other$user = other.getUser();
        if (this$user == null ? other$user != null : !this$user.equals(other$user)) return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof Token;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $id = this.getId();
        result = result * PRIME + ($id == null ? 43 : $id.hashCode());
        final Object $token = this.getToken();
        result = result * PRIME + ($token == null ? 43 : $token.hashCode());
        final Object $tokenType = this.getTokenType();
        result = result * PRIME + ($tokenType == null ? 43 : $tokenType.hashCode());
        result = result * PRIME + (this.isRevoked() ? 79 : 97);
        result = result * PRIME + (this.isExpired() ? 79 : 97);
        final Object $user = this.getUser();
        result = result * PRIME + ($user == null ? 43 : $user.hashCode());
        return result;
    }

    public String toString() {
        return "Token(id=" + this.getId() + ", token=" + this.getToken() + ", tokenType=" + this.getTokenType() + ", revoked=" + this.isRevoked() + ", expired=" + this.isExpired() + ", user=" + this.getUser() + ")";
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

        public String toString() {
            return "Token.TokenBuilder(id=" + this.id + ", token=" + this.token + ", tokenType=" + this.tokenType + ", revoked=" + this.revoked + ", expired=" + this.expired + ", user=" + this.user + ")";
        }
    }
}
