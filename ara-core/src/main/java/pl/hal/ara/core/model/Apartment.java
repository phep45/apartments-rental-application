package pl.hal.ara.core.model;

public class Apartment {

    private static int idGenerator = 0;

    private Integer id;
    private Address address;
    private MapPosition mapPosition;

    public Apartment(Address address, MapPosition mapPosition) {
        this.id = ++idGenerator;
        this.address = address;
        this.mapPosition = mapPosition;
    }

    public Address getAddress() {
        return address;
    }

    public MapPosition getMapPosition() {
        return mapPosition;
    }
}
