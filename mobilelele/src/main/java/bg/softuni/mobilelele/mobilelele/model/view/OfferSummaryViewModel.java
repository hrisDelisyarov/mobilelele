package bg.softuni.mobilelele.mobilelele.model.view;

import bg.softuni.mobilelele.mobilelele.model.entities.ModelEntity;
import bg.softuni.mobilelele.mobilelele.model.entities.enums.OffersEngineEnum;
import bg.softuni.mobilelele.mobilelele.model.entities.enums.TransmissionTypeEnum;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToOne;

public class OfferSummaryViewModel {


    private OffersEngineEnum engine;

    private String imageUrl;

    private int mileage;

    private int price;

    private TransmissionTypeEnum transmission;

    private int year;

//    @ManyToOne
//    private ModelEntity model;

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
}
