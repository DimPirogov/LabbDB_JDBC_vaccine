import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface DogRepository {
    void save(Dog d);
    List<Dog> getAll();
    Optional<Dog> getById(int id);
    boolean deleteById(int id);
    boolean updateName(int id, String name);
    boolean updateVaccinated(int id, LocalDate dateVaccinated);
}
