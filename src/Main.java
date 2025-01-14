import java.sql.*;

public class Main {
    public static void main(String[] args) {
        AddressRepository repo = new AddressRepoImpl();

        System.out.println(repo.getAll());
        System.out.println(repo.getById(1));
        //todo: all reposImpl
    }
}