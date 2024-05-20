import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.ArrayList;

public class DataService {

    Connection conn = null;

    String user = "peter";
    String pass = "almafa12";
    String url = "jdbc:mariadb://localhost:3306/Konyvtar";

    public void insertKolcsonzok(ArrayList<Kolcsonzok> kolcsonzok){

        try {
            
            conn = DriverManager.getConnection(url, user, pass);

            String sql = """
                    insert into Kolcsonzok
                    (nev, szulido)
                    values
                    (?, ?)
                    """;
            for (Kolcsonzok kolcsonvevo : kolcsonzok) {
                PreparedStatement ps = conn.prepareStatement(sql);
                ps.setString(1, kolcsonvevo.nev);
                ps.setString(2, kolcsonvevo.szulido);
                ps.execute();                
            }
            conn.close();
            System.out.println("Kolcsonzok feltoltese rendben!");

        } catch (Exception e) {
            System.err.println("Hiba, az adatbazis eleres sikertelen");
            System.err.println(e.getMessage());
        }       


    }

    public void insertKolcsonzesek(ArrayList<Kolcsonzesek> kolcsonzesek){

        try {
            
            conn = DriverManager.getConnection(url, user, pass);

            String sql = """
                    insert into Kolcsonzesek
                    (kolcsonzoId, iro, mufaj, cim)
                    values
                    (?, ?, ?, ?)
                    """;
            for (Kolcsonzesek kolcsonzes : kolcsonzesek) {
                PreparedStatement ps = conn.prepareStatement(sql);
                ps.setInt(1, kolcsonzes.kolcsonzoId);
                ps.setString(2, kolcsonzes.iro);
                ps.setString(3, kolcsonzes.mufaj);
                ps.setString(4, kolcsonzes.cim);
                ps.execute();                
            }
            conn.close();
            System.out.println("Kolcsonzesek feltoltese rendben!");

        } catch (Exception e) {
            System.err.println("Hiba, az adatbazis eleres sikertelen");
            System.err.println(e.getMessage());
        } 

    }
    
}
