import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface DogOwnerRepository {
    void save(DogOwner d);
    List<DogOwner> getAll();
    Optional<DogOwner> getById(int id);
    boolean deleteById(int id);
    boolean updateName(int id, String name);
    List<Dog> getDogsByOwnerId(int ownerId);
}
