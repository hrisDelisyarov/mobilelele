package bg.softuni.mobilelele.mobilelele.model.service;

import bg.softuni.mobilelele.mobilelele.model.entities.enums.OffersEngineEnum;
import bg.softuni.mobilelele.mobilelele.model.entities.enums.TransmissionTypeEnum;
import bg.softuni.mobilelele.mobilelele.model.validation.YearPastOrPresent;

import javax.validation.constraints.*;
import java.math.BigDecimal;

public class OfferServiceModel {
    @NotEmpty
    @Size(min = 10, max = 1024)
    private String description;
    @NotNull
    private OffersEngineEnum engine;
    @NotNull
    @NotEmpty
    private String imageUrl;
    @NotNull
    @Positive
    private Integer mileage;
    @NotNull
    @DecimalMin("100")
    private BigDecimal price;
    @NotNull
    private TransmissionTypeEnum transmission;
    //TODO:
    @YearPastOrPresent(minYear = 1930)
    private Integer year;
    @NotNull
    private Long modelId;

    public String getDescription() {
        return description;
    }

    public OfferServiceModel setDescription(String description) {
        this.description = description;
        return this;
    }

    public OffersEngineEnum getEngine() {
        return engine;
    }

    public OfferServiceModel setEngine(OffersEngineEnum engine) {
        this.engine = engine;
        return this;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public OfferServiceModel setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
        return this;
    }

    public Integer getMileage() {
        return mileage;
    }

    public OfferServiceModel setMileage(Integer mileage) {
        this.mileage = mileage;
        return this;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public OfferServiceModel setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    public TransmissionTypeEnum getTransmission() {
        return transmission;
    }

    public OfferServiceModel setTransmission(TransmissionTypeEnum transmission) {
        this.transmission = transmission;
        return this;
    }

    public Integer getYear() {
        return year;
    }

    public OfferServiceModel setYear(Integer year) {
        this.year = year;
        return this;
    }

    public Long getModelId() {
        return modelId;
    }

    public OfferServiceModel setModelId(Long modelId) {
        this.modelId = modelId;
        return this;
    }

    @Override
    public String toString() {
        return "OfferServiceModel{" +
                "description='" + description + '\'' +
                ", engine=" + engine +
                ", imageUrl='" + imageUrl + '\'' +
                ", mileage=" + mileage +
                ", price=" + price +
                ", transmission=" + transmission +
                ", year=" + year +
                ", modelId=" + modelId +
                '}';
    }
}
