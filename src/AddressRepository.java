import java.util.List;
import java.util.Optional;

public interface AddressRepository {

    void save(Address a);
    List<Address> getAll();
    Optional<Address> getById(int id);
    boolean deleteById(int id);
    boolean updateStreet(int id, String street);
}
