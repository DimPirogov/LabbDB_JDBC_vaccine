import java.util.ArrayList;

public class DogOwner {
    private int dogOwnerId;
    private String name;
    private String phoneNumber;
    private Address address;
    private ArrayList<Dog> dogs;

    public DogOwner(int dogOwnerId, String name, String phoneNumber, Address address) {
        this.dogOwnerId = dogOwnerId;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.dogs = new ArrayList<>();
    }

    @Override
    public String toString() {
        return "DogOwner{" +
                "dogOwnerId=" + dogOwnerId +
                ", name='" + name + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", address=" + address +
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

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
