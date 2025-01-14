import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class DogOwnerRepoImpl implements DogOwnerRepository{

    private Connection conn;
    private PreparedStatement allPS;

    public DogOwnerRepoImpl() {
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost/world", "root", "Workbench!");
            allPS = conn.prepareStatement("SELECT * FROM dog_owner");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void save(DogOwner d) {

    }

    @Override
    public List<DogOwner> getAll() {
        ArrayList<DogOwner> list = new ArrayList<>();
//        try {
//            ResultSet rs = allPS.executeQuery();
//            while(rs.next()) {
//                DogOwner d = new DogOwner(
//                        rs.getInt("id"),
//                        rs.getString("name"),
//                        rs.getString("phone"),
//                        rs.getInt("addressId"));
//                list.add(d);
//            }
//            return List.of();
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
        return list;
    }

    @Override
    public Optional<DogOwner> getById(int id) {
        return Optional.empty();
    }

    @Override
    public boolean deleteById(int id) {
        return false;
    }

    @Override
    public boolean updateName(int id, String name) {
        return false;
    }

    @Override
    public List<Dog> getDogsByOwnerId(int ownerId) {
        return List.of();
    }
}
