/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package responsi_123190104.model;

import java.sql.*;
import static javax.management.remote.JMXConnectorFactory.connect;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import responsi_123190104.DBConnect;
import responsi_123190104.view.InputData;
import responsi_123190104.view.LihatData;



/**
 *
 * @author asus
 */
public class InputModel extends InputData{
  public Connection connection;
  public Statement statement;

    public InputModel(){
        DBConnect connect = new DBConnect();
        connection = connect.getConnection();
    }
   
    public void tambahdata(String[] data){
        try{
            
            String query = "INSERT INTO barang (nama, massa, harga) VALUES (?,?,?)";
            
            PreparedStatement pst = connection.prepareStatement(query);
            pst.setString(1, data[0]);
            pst.setString(2, data[1]);
            pst.setString(3, data[2]);
            pst.execute();
            connection.close();
            System.out.println("Insert Berhasil");
            JOptionPane.showMessageDialog(null,"Insert Berhasil !!");}
            
       catch (SQLException ex){
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    
    }
    
    
     public String[][] readData(){
        try{
            int Rows = 0;
            int numRows = numRows("barang");
            if(numRows==0){
                return null;
            }
            String[][] dt = new String[numRows][4];
            statement = connection.createStatement();
            String query = "Select * from 'barang'";
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()){
                dt[Rows][0] = resultSet.getString("id"); 
                dt[Rows][1] = resultSet.getString("nama"); 
                dt[Rows][2] = resultSet.getString("massa");
                dt[Rows][3] = resultSet.getString("harga");
                Rows++; 
            }
            return dt;
        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(null, e.getMessage());
            return null;
        }
    }
   
    private int numRows(String table) {
        int jmlData = 0; //nilai awal 0
        try{
            statement = connection.createStatement();
            String query = "Select * from "+ table;
            ResultSet resultSet = statement.executeQuery(query); //pengambilan data dalam java dari database
            while(resultSet.next()){ //ambil nilai dari baris ke 0 sampai baris akhir
                jmlData++;
            }
            return jmlData; //mengembalikan jumlah data ke readData
        }catch(SQLException e){
            System.out.println(e.getMessage());
            System.out.println("SQL Error");
            return 0;
        }    }
    
    public String[] readData(String kode){
        try{
            String[] data = new String[4];
            statement = connection.createStatement();
            String query = "select * from barang";
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()){
                data[0] = resultSet.getString("id");
                data[1] = resultSet.getString("nama");
                data[2] = resultSet.getString("massa");
                data[3] = resultSet.getString("harga");
            }
            return data;
        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(null, e.getMessage());
            return null;
        }
    }

}



