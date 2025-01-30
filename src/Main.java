import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        AddressRepository addressRepo = new AddressRepoImpl();
        DogOwnerRepository dogOwnerRepo = new DogOwnerRepoImpl();
        DogRepository dogRepo = new DogRepoImpl();

        Address address = new Address(1, "Kungsgatan 1", "Stockholm", 11122);
        DogOwner dogOwner = new DogOwner(1, "Uffe", "070-1234567", 2);
        Dog dog = new Dog(1, "Fido", "Golden Retriever", LocalDate.parse("2020-01-25"),2);

        //addressRepo.save(address);
        //System.out.println(address);
        //dogOwnerRepo.save(dogOwner);
        //dogRepo.save(dog);

        System.out.println("Hundägare: " + dogOwnerRepo.getAll());

        System.out.println("Adresser: " + addressRepo.getAll());
        System.out.println("Address id 1: " + addressRepo.getById(1));

        System.out.println("Alla hundar: " + dogRepo.getAll());
    }
}