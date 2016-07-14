package pl.hal.ara.core.model;

import com.google.common.base.MoreObjects;

public class Address {

    private final String street;
    private final String city;
    private final Integer buildingNumber;
    private final Integer apartmentNumber;

    public Address(String street, String city, Integer buildingNumber, Integer apartmentNumber) {
        this.street = street;
        this.city = city;
        this.buildingNumber = buildingNumber;
        this.apartmentNumber = apartmentNumber;
    }

    public String getStreet() {
        return street;
    }

    public String getCity() {
        return city;
    }

    public Integer getBuildingNumber() {
        return buildingNumber;
    }

    public Integer getApartmentNumber() {
        return apartmentNumber;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("street", street)
                .add("city", city)
                .add("buildingNumber", buildingNumber)
                .add("apartmentNumber", apartmentNumber)
                .toString();
    }
}
