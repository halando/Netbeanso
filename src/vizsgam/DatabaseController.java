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
import java.sql.Date;
import java. util.ArrayList;
import java.sql.PreparedStatement;
import java.sql.SQLException;




public class DatabaseController {

        private Connection conn;
        private String lenderFile;
        private String lendingFile;
        int counter = 0;

    public DatabaseController(String lenderFile, String lendingFile){
        
        this.lenderFile = lenderFile;
        this.lendingFile = lendingFile;


      buildConnection();
    }

    private void buildConnection(){
        Connect connect =new Connect();
        connect.connecting();
        conn = connect.getConnection();
        if (conn == null) {
            System.out.println("buildConnection conn == null");
        }
    }

    public int setLendersTable(){
        ArrayList<Lender> lenders = new ArrayList<>();
        FileController fileCtr = new FileController();
        lenders = fileCtr.ReadKolcsonzok(lenderFile);

        String sql = "INSERT INTO lenders(name,born) VALUES" +
                 "(?,?)";
        PreparedStatement pstmt = null;

        try {
            pstmt = conn.prepareStatement(sql);

            for(Lender len : lenders){

                pstmt .setString(1, len.getName());
                System.out.println(len.getBorn());
                pstmt.setDate(2, Date.valueOf(len.getBorn()));

                pstmt.executeQuery();

                counter++;

            }
        } catch (SQLException e) {
            System.out.println("Hiba az írás során");
        }

        return counter;
    }

    public int setLendingsTable(){
        ArrayList<Lending> lendings = new ArrayList<>();
        FileController fileCtr = new FileController();
        lendings = fileCtr.ReadKolcsonzesek(lendingFile);
        String sql = "INSERT INTO lendings(writer,type,title,lender_id) VALUES" +  
        "( ?,?,?,?)";
        PreparedStatement pstmt = null;

        try {
            

            for(Lending len : lendings){
                pstmt = conn.prepareStatement(sql);
                pstmt .setString(1, len.getWriter());
                pstmt .setString(2, len.getType());
                pstmt .setString(3, len.getTitle());
                pstmt .setInt(4, Integer.parseInt(len.getLender_id()));;
             

                pstmt.executeQuery();

                counter++;

            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return counter;
    }
    


}