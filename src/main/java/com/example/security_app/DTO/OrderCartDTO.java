package com.example.security_app.DTO;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "_orderCartDTO")
public class OrderCartDTO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String firstAndLastName;
    private String street;
    private String postalCode;
    private String city;
    private Integer phoneNumber;
    private LocalDateTime orderDate;
    private String username;
    private String basketName;

    public OrderCartDTO(String username, String firstAndLastName, String basketName, String street, String postalCode, String city, Integer phoneNumber) {
    }

    public OrderCartDTO(Integer id, String firstAndLastName, String street, String postalCode, String city, Integer phoneNumber, LocalDateTime orderDate, String username, String basketName) {
        this.id = id;
        this.firstAndLastName = firstAndLastName;
        this.street = street;
        this.postalCode = postalCode;
        this.city = city;
        this.phoneNumber = phoneNumber;
        this.orderDate = orderDate;
        this.username = username;
        this.basketName = basketName;
    }

    public OrderCartDTO() {
    }

    public static OrderCartDTOBuilder builder() {
        return new OrderCartDTOBuilder();
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof OrderCartDTO)) return false;
        final OrderCartDTO other = (OrderCartDTO) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$id = this.getId();
        final Object other$id = other.getId();
        if (this$id == null ? other$id != null : !this$id.equals(other$id)) return false;
        final Object this$firstAndLastName = this.getFirstAndLastName();
        final Object other$firstAndLastName = other.getFirstAndLastName();
        if (this$firstAndLastName == null ? other$firstAndLastName != null : !this$firstAndLastName.equals(other$firstAndLastName))
            return false;
        final Object this$street = this.getStreet();
        final Object other$street = other.getStreet();
        if (this$street == null ? other$street != null : !this$street.equals(other$street)) return false;
        final Object this$postalCode = this.getPostalCode();
        final Object other$postalCode = other.getPostalCode();
        if (this$postalCode == null ? other$postalCode != null : !this$postalCode.equals(other$postalCode))
            return false;
        final Object this$city = this.getCity();
        final Object other$city = other.getCity();
        if (this$city == null ? other$city != null : !this$city.equals(other$city)) return false;
        final Object this$phoneNumber = this.getPhoneNumber();
        final Object other$phoneNumber = other.getPhoneNumber();
        if (this$phoneNumber == null ? other$phoneNumber != null : !this$phoneNumber.equals(other$phoneNumber))
            return false;
        final Object this$orderDate = this.getOrderDate();
        final Object other$orderDate = other.getOrderDate();
        if (this$orderDate == null ? other$orderDate != null : !this$orderDate.equals(other$orderDate)) return false;
        final Object this$username = this.getUsername();
        final Object other$username = other.getUsername();
        if (this$username == null ? other$username != null : !this$username.equals(other$username)) return false;
        final Object this$basketName = this.getBasketName();
        final Object other$basketName = other.getBasketName();
        if (this$basketName == null ? other$basketName != null : !this$basketName.equals(other$basketName))
            return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof OrderCartDTO;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $id = this.getId();
        result = result * PRIME + ($id == null ? 43 : $id.hashCode());
        final Object $firstAndLastName = this.getFirstAndLastName();
        result = result * PRIME + ($firstAndLastName == null ? 43 : $firstAndLastName.hashCode());
        final Object $street = this.getStreet();
        result = result * PRIME + ($street == null ? 43 : $street.hashCode());
        final Object $postalCode = this.getPostalCode();
        result = result * PRIME + ($postalCode == null ? 43 : $postalCode.hashCode());
        final Object $city = this.getCity();
        result = result * PRIME + ($city == null ? 43 : $city.hashCode());
        final Object $phoneNumber = this.getPhoneNumber();
        result = result * PRIME + ($phoneNumber == null ? 43 : $phoneNumber.hashCode());
        final Object $orderDate = this.getOrderDate();
        result = result * PRIME + ($orderDate == null ? 43 : $orderDate.hashCode());
        final Object $username = this.getUsername();
        result = result * PRIME + ($username == null ? 43 : $username.hashCode());
        final Object $basketName = this.getBasketName();
        result = result * PRIME + ($basketName == null ? 43 : $basketName.hashCode());
        return result;
    }

    public String toString() {
        return "OrderCartDTO(id=" + this.getId() + ", firstAndLastName=" + this.getFirstAndLastName() + ", street=" + this.getStreet() + ", postalCode=" + this.getPostalCode() + ", city=" + this.getCity() + ", phoneNumber=" + this.getPhoneNumber() + ", orderDate=" + this.getOrderDate() + ", username=" + this.getUsername() + ", basketName=" + this.getBasketName() + ")";
    }

    public Integer getId() {
        return this.id;
    }

    public String getFirstAndLastName() {
        return this.firstAndLastName;
    }

    public String getStreet() {
        return this.street;
    }

    public String getPostalCode() {
        return this.postalCode;
    }

    public String getCity() {
        return this.city;
    }

    public Integer getPhoneNumber() {
        return this.phoneNumber;
    }

    public LocalDateTime getOrderDate() {
        return this.orderDate;
    }

    public String getUsername() {
        return this.username;
    }

    public String getBasketName() {
        return this.basketName;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setFirstAndLastName(String firstAndLastName) {
        this.firstAndLastName = firstAndLastName;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setPhoneNumber(Integer phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setOrderDate(LocalDateTime orderDate) {
        this.orderDate = orderDate;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setBasketName(String basketName) {
        this.basketName = basketName;
    }

    public static class OrderCartDTOBuilder {
        private Integer id;
        private String firstAndLastName;
        private String street;
        private String postalCode;
        private String city;
        private Integer phoneNumber;
        private LocalDateTime orderDate;
        private String username;
        private String basketName;

        OrderCartDTOBuilder() {
        }

        public OrderCartDTOBuilder id(Integer id) {
            this.id = id;
            return this;
        }

        public OrderCartDTOBuilder firstAndLastName(String firstAndLastName) {
            this.firstAndLastName = firstAndLastName;
            return this;
        }

        public OrderCartDTOBuilder street(String street) {
            this.street = street;
            return this;
        }

        public OrderCartDTOBuilder postalCode(String postalCode) {
            this.postalCode = postalCode;
            return this;
        }

        public OrderCartDTOBuilder city(String city) {
            this.city = city;
            return this;
        }

        public OrderCartDTOBuilder phoneNumber(Integer phoneNumber) {
            this.phoneNumber = phoneNumber;
            return this;
        }

        public OrderCartDTOBuilder orderDate(LocalDateTime orderDate) {
            this.orderDate = orderDate;
            return this;
        }

        public OrderCartDTOBuilder username(String username) {
            this.username = username;
            return this;
        }

        public OrderCartDTOBuilder basketName(String basketName) {
            this.basketName = basketName;
            return this;
        }

        public OrderCartDTO build() {
            return new OrderCartDTO(this.id, this.firstAndLastName, this.street, this.postalCode, this.city, this.phoneNumber, this.orderDate, this.username, this.basketName);
        }

        public String toString() {
            return "OrderCartDTO.OrderCartDTOBuilder(id=" + this.id + ", firstAndLastName=" + this.firstAndLastName + ", street=" + this.street + ", postalCode=" + this.postalCode + ", city=" + this.city + ", phoneNumber=" + this.phoneNumber + ", orderDate=" + this.orderDate + ", username=" + this.username + ", basketName=" + this.basketName + ")";
        }
    }
}
