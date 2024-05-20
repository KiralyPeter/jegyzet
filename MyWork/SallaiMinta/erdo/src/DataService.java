import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

public class DataService {
    
    public static void insertData(ArrayList<Erdo> erdoLista) {
        Connection conn = null;
        try {
            String user = "root";
            String pass = "";
            String url = "jdbc:mariadb://localhost:3306/erdo";
            conn = DriverManager.getConnection(url, user, pass);
            String sql = """
                    insert into erdok
                    (id, nev,tipus,meret,terulet,orszag,vedett_terulet)
                    values
                    (?,?,?,?,?,?,?)
                    """;
            for (Erdo erdo : erdoLista) {
                PreparedStatement ps = conn.prepareStatement(sql);
                ps.setInt(1, erdo.id);
                ps.setString(2, erdo.nev);
                ps.setString(3, erdo.tipus);
                ps.setInt(4, erdo.meret);
                ps.setString(5, erdo.terulet);
                ps.setString(6, erdo.orszag);
                ps.setBoolean(7, erdo.vedett);
                ps.execute();
            }
            conn.close();
            System.out.println("Ok");
        } catch (SQLException e) {
            System.err.println("Hiba! Az adatbázis elérés sikertlen!");
            System.err.println(e.getMessage());
        }
    }

}
