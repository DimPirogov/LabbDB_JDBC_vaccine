import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class AddressRepoImpl implements AddressRepository {

    private Connection conn;
    private PreparedStatement allPS, idPS, deletePS;

    public AddressRepoImpl() {
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost/world", "root", "Workbench!");
            allPS = conn.prepareStatement("SELECT * FROM address");
            idPS = conn.prepareStatement("SELECT * FROM address WHERE addressId = ?");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void save(Address a) {
        // Save address to database
    }

    @Override
    public List<Address> getAll() {
        List<Address> list = new ArrayList<>();
        try {
            ResultSet rs = allPS.executeQuery();
            while (rs.next()) {
                Address a = new Address(
                        rs.getInt("addressId"),
                        rs.getString("street"),
                        rs.getString("city"),
                        rs.getInt("postalCode"));
                list.add(a);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return list;
    }

    @Override
    public Optional<Address> getById(int id) {
        try {
            idPS.setInt(1, id);
            ResultSet rs = idPS.executeQuery();
            if (rs.next()) {
                Address address = new Address (
                        rs.getInt("addressId"),
                        rs.getString("street"),
                        rs.getString("city"),
                        rs.getInt("postalCode"));
                return Optional.of(address);
            } else {
                throw new RuntimeException("Address not found for id: " + id);
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
    public boolean updateStreet(int id, String street) {
        // Update street by id in database
        return false;
    }
}
