/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vizsgam;

/**
 *
 * @author ando
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connect {

    private Connection conn;

    public Connect() {

        conn = null;

    }

    public void connecting() {
        String connectStr = "jdbc:mariadb://localhost:3306/diakdu_konyvtardu?user=diakdu&password=123";

        try {

            conn = DriverManager.getConnection(connectStr);

        } catch (SQLException e) {
            System.out.println("Hiba a kapcsolódás során");
        }
        /*if (conn != null) {
            System.out.println("Ok");
        }else{
            System.out.println("Nincs kapcsolat");
        }*/
    }

    public Connection getConnection() {
        return conn;
    }
}
