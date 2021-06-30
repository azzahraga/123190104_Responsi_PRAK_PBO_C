/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package responsi_123190104;

import java.sql.*;
        
/**
 *
 * @author asus
 */
public class DBConnect {
    String url = "jdbc:mysql://localhost/barang";
    //String url = "jdbc:mysql://localhost:3306/coba_jdbc?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    String username = "root";
    String password = "";
    public Connection connection;
    public Statement statement;
    public DBConnect() {
        try{
            Class.forName("com.mysql.jdbc.Driver");
            connection = (Connection) DriverManager.getConnection(url,username,password);
            System.out.println("Koneksi Berhasil");
        }catch(Exception ex){
            System.out.println("Koneksi gagal");
        }
    }
    public Connection getConnection(){
        return  connection;
    }
  
}
