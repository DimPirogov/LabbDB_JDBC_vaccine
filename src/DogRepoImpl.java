import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public class DogRepoImpl implements DogRepository {
    @Override
    public void save(Dog d) {
        // Save dog to database
    }

    @Override
    public List<Dog> getAll() {
        // Get all dogs from database
        return null;
    }

    @Override
    public Optional<Dog> getById(int id) {
        // Get dog by id from database
        return Optional.empty();
    }

    @Override
    public boolean deleteById(int id) {
        // Delete dog by id from database
        return false;
    }

    @Override
    public boolean updateName(int id, String name) {
        // Update name by id in database
        return false;
    }

    @Override
    public boolean updateVaccinated(int id, LocalDate dateVaccinated) {
        return false;
    }
}
