import java.time.LocalDate;

public class Dog {
    private int dogId;
    private String name;
    private String breed;
    private LocalDate vaccineDate;
    private int dogOwnerId;

    public Dog(int dogId, String name, String breed, LocalDate vaccineDate, int dogOwnerId) {
        this.dogId = dogId;
        this.name = name;
        this.breed = breed;
        this.vaccineDate = vaccineDate;
        this.dogOwnerId = dogOwnerId;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "dogId=" + dogId +
                ", name='" + name + '\'' +
                ", breed='" + breed + '\'' +
                ", dogOwnerId=" + dogOwnerId +
                '}';
    }

    public int getDogId() {
        return dogId;
    }

    public void setDogId(int dogId) {
        this.dogId = dogId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public int getDogOwnerId() {
        return dogOwnerId;
    }

    public void setDogOwnerId(int dogOwnerId) {
        this.dogOwnerId = dogOwnerId;
    }

    public LocalDate getVaccineDate() {
        return vaccineDate;
    }

    public void setVaccineDate(LocalDate vaccineDate) {
        this.vaccineDate = vaccineDate;
    }
}
