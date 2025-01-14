public class Address {
    private int addressId;
    private String street;
    private String city;
    private int PostalCode;

    public Address(int addressId, String street, String city, int PostalCode) {
        this.addressId = addressId;
        this.street = street;
        this.city = city;
        this.PostalCode = PostalCode;
    }

    @Override
    public String toString() {
        return "Address{" +
                "addressId=" + addressId +
                ", street='" + street + '\'' +
                ", city='" + city + '\'' +
                ", PostalCode=" + PostalCode +
                '}';
    }

    public int getAddressId() {
        return addressId;
    }

    public void setAddressId(int addressId) {
        this.addressId = addressId;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getPostalCode() {
        return PostalCode;
    }

    public void setPostalCode(int postalCode) {
        this.PostalCode = postalCode;
    }
}
