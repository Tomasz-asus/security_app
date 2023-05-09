 package com.example.security_app.model;


import com.example.security_app.token.Token;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Data
 @Entity
 @Table(name ="_user")
 @Builder
 @NoArgsConstructor
 @AllArgsConstructor
public class User implements UserDetails {
     @Id
     @GeneratedValue(strategy = GenerationType.TABLE)
     private Long id;

     private String firstname;

     private String lastname;

     private String email;

     private String password;
     @Enumerated(EnumType.STRING)
     private Role role;

     @OneToMany(mappedBy = "user")
     private List<Token>tokens;

     public Role getRole() {
         return role;
     }

     public void setRole(Role role) {
         this.role = role;
     }


     public Long getId() {
         return id;
     }

     public void setId(Long id) {
         this.id = id;
     }

     public String getFirstname() {
         return firstname;
     }

     public void setFirstname(String firstname) {
         this.firstname = firstname;
     }

     public String getLastname() {
         return lastname;
     }

     public void setLastname(String lastname) {
         this.lastname = lastname;
     }

     public String getEmail() {
         return email;
     }

     public void setEmail(String email) {
         this.email = email;
     }


     @Override
     public Collection<? extends GrantedAuthority> getAuthorities() {
         return List.of(new SimpleGrantedAuthority(role.name()));
     }

     @Override
     public String getUsername() {
         return email;
     }

     @Override
     public boolean isAccountNonExpired() {
         return true;
     }

     @Override
     public boolean isAccountNonLocked() {
         return true;
     }

     @Override
     public boolean isCredentialsNonExpired() {
         return true;
     }

     @Override
     public boolean isEnabled() {
         return true;
     }

     @Override
     public String getPassword() {
         return password;
     }

 }

