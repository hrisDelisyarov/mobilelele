package bg.softuni.mobilelele.mobilelele.entities;

import bg.softuni.mobilelele.mobilelele.entities.enums.OffersEngineEnum;
import bg.softuni.mobilelele.mobilelele.entities.enums.TransmissionTypeEnum;

import javax.persistence.*;

@Entity
@Table(name="offers")
public class OfferEntity extends BaseEntity {

    @Column
    private String description;

    @Enumerated(EnumType.STRING)
    private OffersEngineEnum engine;

    @Column
    private String imageUrl;

    @Column
    private int mileage;

    @Column
    private int price;

    @Enumerated(EnumType.STRING)
    private TransmissionTypeEnum transmission;

    @Column
    private int year;

    @ManyToOne
    private ModelEntity model;

    @ManyToOne
    private UserEntity seller;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public OffersEngineEnum getEngine() {
        return engine;
    }

    public void setEngine(OffersEngineEnum engine) {
        this.engine = engine;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public int getMileage() {
        return mileage;
    }

    public void setMileage(int mileage) {
        this.mileage = mileage;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public TransmissionTypeEnum getTransmission() {
        return transmission;
    }

    public void setTransmission(TransmissionTypeEnum transmission) {
        this.transmission = transmission;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public ModelEntity getModel() {
        return model;
    }

    public void setModel(ModelEntity model) {
        this.model = model;
    }

    public UserEntity getSeller() {
        return seller;
    }

    public void setSeller(UserEntity seller) {
        this.seller = seller;
   }
}
