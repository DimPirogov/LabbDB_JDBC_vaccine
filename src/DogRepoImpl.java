import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class DogRepoImpl implements DogRepository {
    private Connection conn;
    private PreparedStatement allPS, savePS, idPS, deletePS, updateNamePS, updateVaccinatedPS;

    public DogRepoImpl() {
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost/world", "root", "Workbench!");
            allPS = conn.prepareStatement("SELECT * FROM dogs");
            savePS = conn.prepareStatement("INSERT INTO dogs (name, breed, dateOfBirth, ownerId) VALUES (?, ?, ?, ?)");
            idPS = conn.prepareStatement("SELECT * FROM dogs WHERE id = ?");
            deletePS = conn.prepareStatement("DELETE FROM dogs WHERE id = ?");
            updateNamePS = conn.prepareStatement("UPDATE dogs SET name = ? WHERE id = ?");
            updateVaccinatedPS = conn.prepareStatement("UPDATE dogs SET dateVaccinated = ? WHERE id = ?");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void save(Dog d) {
        try {
            savePS.setString(1, d.getName());
            savePS.setString(2, d.getBreed());
            if (d.getVaccineDate() != null) {
                savePS.setDate(3, Date.valueOf(d.getVaccineDate()));
            } else {
                savePS.setNull(3, Types.DATE);
            }
            savePS.setInt(4, d.getDogOwnerId());
            savePS.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Dog> getAll() {
        List<Dog> list = new ArrayList<>();
        try {
            ResultSet rs = allPS.executeQuery();
            while (rs.next()) {
                Dog d = new Dog(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("breed"),
                        rs.getDate("dateOfBirth").toLocalDate(),
                        rs.getInt("ownerId"));
                list.add(d);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return list;
    }

    @Override
    public Optional<Dog> getById(int id) {
        try {
            idPS.setInt(1, id);
            ResultSet rs = idPS.executeQuery();
            if (rs.next()) {
                Dog d = new Dog(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("breed"),
                        rs.getDate("dateOfBirth").toLocalDate(),
                        rs.getInt("ownerId"));
                return Optional.of(d);
            } else {
                return Optional.empty();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean deleteById(int id) {
        try {
            deletePS.setInt(1, id);
            return deletePS.executeUpdate() > 0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean updateName(int id, String name) {
        try {
            updateNamePS.setString(1, name);
            updateNamePS.setInt(2, id);
            return updateNamePS.executeUpdate() > 0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean updateVaccinated(int id, LocalDate dateVaccinated) {
        try {
            updateVaccinatedPS.setDate(1, Date.valueOf(dateVaccinated));
            updateVaccinatedPS.setInt(2, id);
            return updateVaccinatedPS.executeUpdate() > 0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
