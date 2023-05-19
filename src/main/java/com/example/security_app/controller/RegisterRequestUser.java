package com.example.security_app.controller;


import com.example.security_app.model.Role;

public class RegisterRequestUser {

    private String firstname;
    private String lastname;
    private String email;
    private String password;
    private Role role = Role.USER;

    public RegisterRequestUser(String firstname, String lastname, String email, String password, Role role) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.password = password;
        this.role = role;
    }

    public RegisterRequestUser() {
    }

    public static RegisterRequestUserBuilder builder() {
        return new RegisterRequestUserBuilder();
    }


    public String getFirstname() {
        return this.firstname;
    }

    public String getLastname() {
        return this.lastname;
    }

    public String getEmail() {
        return this.email;
    }

    public String getPassword() {
        return this.password;
    }

    public Role getRole() {
        return this.role;
    }

    public static class RegisterRequestUserBuilder {
        private String firstname;
        private String lastname;
        private String email;
        private String password;
        private Role role;

        RegisterRequestUserBuilder() {
        }

        public RegisterRequestUserBuilder firstname(String firstname) {
            this.firstname = firstname;
            return this;
        }

        public RegisterRequestUserBuilder lastname(String lastname) {
            this.lastname = lastname;
            return this;
        }

        public RegisterRequestUserBuilder email(String email) {
            this.email = email;
            return this;
        }

        public RegisterRequestUserBuilder password(String password) {
            this.password = password;
            return this;
        }

        public RegisterRequestUserBuilder role(Role role) {
            this.role = role;
            return this;
        }

        public RegisterRequestUser build() {
            return new RegisterRequestUser(this.firstname, this.lastname, this.email, this.password, this.role);
        }

        public String toString() {
            return "RegisterRequestUser.RegisterRequestUserBuilder(firstname=" + this.firstname + ", lastname=" + this.lastname + ", email=" + this.email + ", password=" + this.password + ", role=" + this.role + ")";
        }
    }
}
