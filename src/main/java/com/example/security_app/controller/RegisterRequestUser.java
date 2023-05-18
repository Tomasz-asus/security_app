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

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof RegisterRequestUser)) return false;
        final RegisterRequestUser other = (RegisterRequestUser) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$firstname = this.getFirstname();
        final Object other$firstname = other.getFirstname();
        if (this$firstname == null ? other$firstname != null : !this$firstname.equals(other$firstname)) return false;
        final Object this$lastname = this.getLastname();
        final Object other$lastname = other.getLastname();
        if (this$lastname == null ? other$lastname != null : !this$lastname.equals(other$lastname)) return false;
        final Object this$email = this.getEmail();
        final Object other$email = other.getEmail();
        if (this$email == null ? other$email != null : !this$email.equals(other$email)) return false;
        final Object this$password = this.getPassword();
        final Object other$password = other.getPassword();
        if (this$password == null ? other$password != null : !this$password.equals(other$password)) return false;
        final Object this$role = this.getRole();
        final Object other$role = other.getRole();
        if (this$role == null ? other$role != null : !this$role.equals(other$role)) return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof RegisterRequestUser;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $firstname = this.getFirstname();
        result = result * PRIME + ($firstname == null ? 43 : $firstname.hashCode());
        final Object $lastname = this.getLastname();
        result = result * PRIME + ($lastname == null ? 43 : $lastname.hashCode());
        final Object $email = this.getEmail();
        result = result * PRIME + ($email == null ? 43 : $email.hashCode());
        final Object $password = this.getPassword();
        result = result * PRIME + ($password == null ? 43 : $password.hashCode());
        final Object $role = this.getRole();
        result = result * PRIME + ($role == null ? 43 : $role.hashCode());
        return result;
    }

    public String toString() {
        return "RegisterRequestUser(firstname=" + this.getFirstname() + ", lastname=" + this.getLastname() + ", email=" + this.getEmail() + ", password=" + this.getPassword() + ", role=" + this.getRole() + ")";
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

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setRole(Role role) {
        this.role = role;
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
