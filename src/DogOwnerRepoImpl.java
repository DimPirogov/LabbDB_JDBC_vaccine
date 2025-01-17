import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class DogOwnerRepoImpl implements DogOwnerRepository{

    private Connection conn;
    private AddressRepoImpl addressRepo;
    private PreparedStatement allPS, savePS, idPS, deletePS, updatePS, getDogsByOwnerIdPS;

    public DogOwnerRepoImpl() {
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost/world", "root", "Workbench!");
            allPS = conn.prepareStatement("SELECT * FROM dog_owner");
            savePS = conn.prepareStatement("INSERT INTO dog_owner (name, phone, addressId) VALUES (?, ?, ?)");
            idPS = conn.prepareStatement("SELECT * FROM dog_owner WHERE id = ?");
            deletePS = conn.prepareStatement("DELETE FROM dog_owner WHERE id = ?");
            updatePS = conn.prepareStatement("UPDATE dog_owner SET name = ? WHERE id = ?");
            getDogsByOwnerIdPS = conn.prepareStatement("SELECT * FROM dog WHERE ownerId = ?");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void save(DogOwner d) {
        try {
            savePS.setString(1, d.getName());
            savePS.setString(2, d.getPhoneNumber());
            savePS.setInt(3, d.getAddressId());
            savePS.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<DogOwner> getAll() {
        ArrayList<DogOwner> list = new ArrayList<>();
        try {
            ResultSet rs = allPS.executeQuery();
            while(rs.next()) {
                    DogOwner d = new DogOwner(
                            rs.getInt("dogOwnerId"),
                            rs.getString("name"),
                            rs.getString("phone"),
                            rs.getInt("addressId"));
                    list.add(d);
            }
            return list;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Optional<DogOwner> getById(int id) {
        try {
            idPS.setInt(1, id);
            ResultSet rs = idPS.executeQuery();
            if (rs.next()) {
                 DogOwner d = new DogOwner(
                        rs.getInt("dogOwnerId"),
                        rs.getString("name"),
                        rs.getString("phone"),
                        rs.getInt("addressId"));
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
            int rows = deletePS.executeUpdate();
            return rows > 0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean updateName(int id, String name) {
        try {
            updatePS.setString(1, name);
            updatePS.setInt(2, id);
            int rows = updatePS.executeUpdate();
            return rows > 0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Dog> getDogsByOwnerId(int ownerId) {
        ArrayList<Dog> list = new ArrayList<>();
        try {
            getDogsByOwnerIdPS.setInt(1, ownerId);
            ResultSet rs = getDogsByOwnerIdPS.executeQuery();
            while (rs.next()) {
                Dog d = new Dog(
                        rs.getInt("dogId"),
                        rs.getString("name"),
                        rs.getString("breed"),
                        rs.getDate("vaccineDate").toLocalDate(),
                        rs.getInt("ownerId"));
                list.add(d);
            }
            return list;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
