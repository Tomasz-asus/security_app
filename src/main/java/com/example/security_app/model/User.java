 package com.example.security_app.model;


 import com.example.security_app.token.Token;
 import jakarta.persistence.*;
 import org.springframework.security.core.GrantedAuthority;
 import org.springframework.security.core.userdetails.UserDetails;

 import java.util.ArrayList;
 import java.util.Collection;
 import java.util.List;

 @Entity
 @Table(name = "_user")
 public class User implements UserDetails {

     @Id
     @GeneratedValue
     private Integer id;

     private String firstname;
     private String lastname;
     private String email;
     private String password;

     @Enumerated(EnumType.STRING)
     private Role role;

     @OneToMany(mappedBy = "user")
     private List<Token> tokens;


     @OneToOne(fetch = FetchType.EAGER)
     private Basket basket = new Basket();

     @OneToMany
     private List<OrderCart> orderCarts = new ArrayList<>();

     public User(Integer id, String firstname, String lastname, String email, String password, Role role, List<Token> tokens, Basket basket, List<OrderCart> orderCarts) {
         this.id = id;
         this.firstname = firstname;
         this.lastname = lastname;
         this.email = email;
         this.password = password;
         this.role = role;
         this.tokens = tokens;
         this.basket = basket;
         this.orderCarts = orderCarts;
     }

     public User() {
     }

     public static UserBuilder builder() {
         return new UserBuilder();
     }


     public List<OrderCart> getOrderCarts() {
         return orderCarts;
     }

     @Override
     public Collection<? extends GrantedAuthority> getAuthorities() {
         return role.getAuthorities();
     }

     @Override
     public String getPassword() {
         return password;
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

     public boolean equals(final Object o) {
         if (o == this) return true;
         if (!(o instanceof User)) return false;
         final User other = (User) o;
         if (!other.canEqual((Object) this)) return false;
         final Object this$id = this.getId();
         final Object other$id = other.getId();
         if (this$id == null ? other$id != null : !this$id.equals(other$id)) return false;
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
         final Object this$tokens = this.getTokens();
         final Object other$tokens = other.getTokens();
         if (this$tokens == null ? other$tokens != null : !this$tokens.equals(other$tokens)) return false;
         final Object this$basket = this.getBasket();
         final Object other$basket = other.getBasket();
         if (this$basket == null ? other$basket != null : !this$basket.equals(other$basket)) return false;
         final Object this$orderCarts = this.getOrderCarts();
         final Object other$orderCarts = other.getOrderCarts();
         if (this$orderCarts == null ? other$orderCarts != null : !this$orderCarts.equals(other$orderCarts))
             return false;
         return true;
     }

     protected boolean canEqual(final Object other) {
         return other instanceof User;
     }

     public int hashCode() {
         final int PRIME = 59;
         int result = 1;
         final Object $id = this.getId();
         result = result * PRIME + ($id == null ? 43 : $id.hashCode());
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
         final Object $tokens = this.getTokens();
         result = result * PRIME + ($tokens == null ? 43 : $tokens.hashCode());
         final Object $basket = this.getBasket();
         result = result * PRIME + ($basket == null ? 43 : $basket.hashCode());
         final Object $orderCarts = this.getOrderCarts();
         result = result * PRIME + ($orderCarts == null ? 43 : $orderCarts.hashCode());
         return result;
     }

     public String toString() {
         return "User(id=" + this.getId() + ", firstname=" + this.getFirstname() + ", lastname=" + this.getLastname() + ", email=" + this.getEmail() + ", password=" + this.getPassword() + ", role=" + this.getRole() + ", tokens=" + this.getTokens() + ", basket=" + this.getBasket() + ", orderCarts=" + this.getOrderCarts() + ")";
     }

     public Integer getId() {
         return this.id;
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

     public Role getRole() {
         return this.role;
     }

     public List<Token> getTokens() {
         return this.tokens;
     }

     public Basket getBasket() {
         return this.basket;
     }

     public void setId(Integer id) {
         this.id = id;
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

     public void setTokens(List<Token> tokens) {
         this.tokens = tokens;
     }

     public void setBasket(Basket basket) {
         this.basket = basket;
     }

     public void setOrderCarts(List<OrderCart> orderCarts) {
         this.orderCarts = orderCarts;
     }

     public static class UserBuilder {
         private Integer id;
         private String firstname;
         private String lastname;
         private String email;
         private String password;
         private Role role;
         private List<Token> tokens;
         private Basket basket;
         private List<OrderCart> orderCarts;

         UserBuilder() {
         }

         public UserBuilder id(Integer id) {
             this.id = id;
             return this;
         }

         public UserBuilder firstname(String firstname) {
             this.firstname = firstname;
             return this;
         }

         public UserBuilder lastname(String lastname) {
             this.lastname = lastname;
             return this;
         }

         public UserBuilder email(String email) {
             this.email = email;
             return this;
         }

         public UserBuilder password(String password) {
             this.password = password;
             return this;
         }

         public UserBuilder role(Role role) {
             this.role = role;
             return this;
         }

         public UserBuilder tokens(List<Token> tokens) {
             this.tokens = tokens;
             return this;
         }

         public UserBuilder basket(Basket basket) {
             this.basket = basket;
             return this;
         }

         public UserBuilder orderCarts(List<OrderCart> orderCarts) {
             this.orderCarts = orderCarts;
             return this;
         }

         public User build() {
             return new User(this.id, this.firstname, this.lastname, this.email, this.password, this.role, this.tokens, this.basket, this.orderCarts);
         }

         public String toString() {
             return "User.UserBuilder(id=" + this.id + ", firstname=" + this.firstname + ", lastname=" + this.lastname + ", email=" + this.email + ", password=" + this.password + ", role=" + this.role + ", tokens=" + this.tokens + ", basket=" + this.basket + ", orderCarts=" + this.orderCarts + ")";
         }
     }
 }
