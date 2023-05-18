package com.example.security_app.DTO;

import com.example.security_app.model.MotorcycleCategory;


public class MotorcycleDTO {

    private String motorcycleName;
    private String motorcycleDescription;
    private Double motorcyclePrice;
    private String imageURL;
    private MotorcycleCategory category;

    public MotorcycleDTO(String motorcycleName, String motorcycleDescription, Double motorcyclePrice, String imageURL, MotorcycleCategory category) {
        this.motorcycleName = motorcycleName;
        this.motorcycleDescription = motorcycleDescription;
        this.motorcyclePrice = motorcyclePrice;
        this.imageURL = imageURL;
        this.category = category;
    }

    public MotorcycleDTO() {
    }

    public static MotorcycleDTOBuilder builder() {
        return new MotorcycleDTOBuilder();
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof MotorcycleDTO)) return false;
        final MotorcycleDTO other = (MotorcycleDTO) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$motorcycleName = this.getMotorcycleName();
        final Object other$motorcycleName = other.getMotorcycleName();
        if (this$motorcycleName == null ? other$motorcycleName != null : !this$motorcycleName.equals(other$motorcycleName))
            return false;
        final Object this$motorcycleDescription = this.getMotorcycleDescription();
        final Object other$motorcycleDescription = other.getMotorcycleDescription();
        if (this$motorcycleDescription == null ? other$motorcycleDescription != null : !this$motorcycleDescription.equals(other$motorcycleDescription))
            return false;
        final Object this$motorcyclePrice = this.getMotorcyclePrice();
        final Object other$motorcyclePrice = other.getMotorcyclePrice();
        if (this$motorcyclePrice == null ? other$motorcyclePrice != null : !this$motorcyclePrice.equals(other$motorcyclePrice))
            return false;
        final Object this$imageURL = this.getImageURL();
        final Object other$imageURL = other.getImageURL();
        if (this$imageURL == null ? other$imageURL != null : !this$imageURL.equals(other$imageURL)) return false;
        final Object this$category = this.getCategory();
        final Object other$category = other.getCategory();
        if (this$category == null ? other$category != null : !this$category.equals(other$category)) return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof MotorcycleDTO;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $motorcycleName = this.getMotorcycleName();
        result = result * PRIME + ($motorcycleName == null ? 43 : $motorcycleName.hashCode());
        final Object $motorcycleDescription = this.getMotorcycleDescription();
        result = result * PRIME + ($motorcycleDescription == null ? 43 : $motorcycleDescription.hashCode());
        final Object $motorcyclePrice = this.getMotorcyclePrice();
        result = result * PRIME + ($motorcyclePrice == null ? 43 : $motorcyclePrice.hashCode());
        final Object $imageURL = this.getImageURL();
        result = result * PRIME + ($imageURL == null ? 43 : $imageURL.hashCode());
        final Object $category = this.getCategory();
        result = result * PRIME + ($category == null ? 43 : $category.hashCode());
        return result;
    }

    public String toString() {
        return "MotorcycleDTO(motorcycleName=" + this.getMotorcycleName() + ", motorcycleDescription=" + this.getMotorcycleDescription() + ", motorcyclePrice=" + this.getMotorcyclePrice() + ", imageURL=" + this.getImageURL() + ", category=" + this.getCategory() + ")";
    }

    public String getMotorcycleName() {
        return this.motorcycleName;
    }

    public String getMotorcycleDescription() {
        return this.motorcycleDescription;
    }

    public Double getMotorcyclePrice() {
        return this.motorcyclePrice;
    }

    public String getImageURL() {
        return this.imageURL;
    }

    public MotorcycleCategory getCategory() {
        return this.category;
    }

    public void setMotorcycleName(String motorcycleName) {
        this.motorcycleName = motorcycleName;
    }

    public void setMotorcycleDescription(String motorcycleDescription) {
        this.motorcycleDescription = motorcycleDescription;
    }

    public void setMotorcyclePrice(Double motorcyclePrice) {
        this.motorcyclePrice = motorcyclePrice;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public void setCategory(MotorcycleCategory category) {
        this.category = category;
    }

    public static class MotorcycleDTOBuilder {
        private String motorcycleName;
        private String motorcycleDescription;
        private Double motorcyclePrice;
        private String imageURL;
        private MotorcycleCategory category;

        MotorcycleDTOBuilder() {
        }

        public MotorcycleDTOBuilder motorcycleName(String motorcycleName) {
            this.motorcycleName = motorcycleName;
            return this;
        }

        public MotorcycleDTOBuilder motorcycleDescription(String motorcycleDescription) {
            this.motorcycleDescription = motorcycleDescription;
            return this;
        }

        public MotorcycleDTOBuilder motorcyclePrice(Double motorcyclePrice) {
            this.motorcyclePrice = motorcyclePrice;
            return this;
        }

        public MotorcycleDTOBuilder imageURL(String imageURL) {
            this.imageURL = imageURL;
            return this;
        }

        public MotorcycleDTOBuilder category(MotorcycleCategory category) {
            this.category = category;
            return this;
        }

        public MotorcycleDTO build() {
            return new MotorcycleDTO(this.motorcycleName, this.motorcycleDescription, this.motorcyclePrice, this.imageURL, this.category);
        }

        public String toString() {
            return "MotorcycleDTO.MotorcycleDTOBuilder(motorcycleName=" + this.motorcycleName + ", motorcycleDescription=" + this.motorcycleDescription + ", motorcyclePrice=" + this.motorcyclePrice + ", imageURL=" + this.imageURL + ", category=" + this.category + ")";
        }
    }
}
