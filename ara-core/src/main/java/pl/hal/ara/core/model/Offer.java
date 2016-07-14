package pl.hal.ara.core.model;

import javax.persistence.Entity;

@Entity
public class Offer {


    private Apartment apartment;
    private Price price;
    private OfferingUser offeringUser;

    public Apartment getApartment() {
        return apartment;
    }

    public Price getPrice() {
        return price;
    }

    public OfferingUser getOfferingUser() {
        return offeringUser;
    }
}
