import java.util.ArrayList;

public class DogOwner {
    private int dogOwnerId;
    private String name;
    private String phoneNumber;
    private int addressId;
    private ArrayList<Dog> dogs;

    public DogOwner(int dogOwnerId, String name, String phoneNumber, int addressId) {
        this.dogOwnerId = dogOwnerId;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.addressId = addressId;
        this.dogs = new ArrayList<>();
    }

    @Override
    public String toString() {
        return "DogOwner{" +
                "dogOwnerId=" + dogOwnerId +
                ", name='" + name + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", address=" + addressId +
                ", dogs=" + dogs +
                '}';
    }

    public int getDogOwnerId() {
        return dogOwnerId;
    }

    public void setDogOwnerId(int dogOwnerId) {
        this.dogOwnerId = dogOwnerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getAddressId() {
        return addressId;
    }

    public void setAddressId(Address address) {
        this.addressId = addressId;
    }
}
