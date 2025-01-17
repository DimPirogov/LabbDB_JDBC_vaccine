
public class Main {
    public static void main(String[] args) {
        AddressRepository addressRepo = new AddressRepoImpl();
        DogOwnerRepository dogOwnerRepo = new DogOwnerRepoImpl();
        DogRepository dogRepo = new DogRepoImpl();

        //Address address = new Address(1, "Kungsgatan 1", "Stockholm", 11122);
        DogOwner dogOwner = new DogOwner(1, "Uffe", "070-1234567", 2);

        //addressRepo.save(address);
        //System.out.println(address);
        dogOwnerRepo.save(dogOwner);

        System.out.println(dogOwnerRepo.getAll());

        System.out.println(addressRepo.getAll());
        System.out.println(addressRepo.getById(1));
    }
}