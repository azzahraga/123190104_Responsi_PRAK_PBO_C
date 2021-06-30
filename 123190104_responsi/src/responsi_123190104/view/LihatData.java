/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package responsi_123190104.view;

import java.awt.Cursor;
import responsi_123190104.view.MenuView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.TableModel;
import responsi_123190104.DBConnect;
import responsi_123190104.controller.InputController;
import responsi_123190104.controller.LihatController;
import responsi_123190104.model.InputModel;

/**
 *
 * @author asus
 */
public class LihatData extends JFrame{
    public String id,nama, massa, harga;
    int jumlah;
    String data[][] = new String[500][4];  
    
   DBConnect connect = new DBConnect();
    
    JTable table;
    JButton kembali;
    DefaultTableModel tableModel; //otomatis dibuat kalo buat JTable
    JScrollPane scrollPane;
    Object namaKolom[] = {"id","Nama","Massa(gr)","Harga"}; //membuat kolom dgn array tipe object;
  
    public LihatData(){
       setLayout(null);
    
       setSize(550,600);
      //  window.setDefaultCloseOperation(3);
       setVisible(true);
       setLocationRelativeTo(null);
       setResizable(false);

       try{
            int jmlData = 0; //menampung jumlah data sebanyak jumlah data yang ada, defaultnya 0
            String query = "Select * from `barang`"; //proses pengambilan data
            connect.statement = connect.connection.createStatement();
            ResultSet resultSet = connect.statement.executeQuery(query); //result isinya tabel belum berupa string
            while(resultSet.next()){ //konversi tabel ke string
                data[jmlData][0] = resultSet.getString("id"); 
                data[jmlData][1] = resultSet.getString("nama"); 
                data[jmlData][2] = resultSet.getString("massa");
                data[jmlData][3] = resultSet.getString("harga");
                jmlData++; 
            }
            connect.statement.close();
        }catch(SQLException e){
            System.out.println(e.getMessage());
            System.out.println("SQL Error");
        }
        
        table = new JTable(data,namaKolom); //tabel merupakan variabel untuk tabelnya dengan isi tablemodel
        scrollPane = new JScrollPane(table);
        kembali= new JButton("Kembali");
        add(scrollPane);
        add(kembali);
        
        scrollPane.setBounds(20, 35, 500, 300);
        kembali.setBounds(0,530,550,30);
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
       
       
        kembali.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                dispose();
                MenuView mv = new MenuView();
                
            }
        });
        
       table.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
//                int pilih = table.rowAtPoint(evt.getPoint());
//                int col = table.columnAtPoint(evt.getPoint());
                        DetailView dv = new DetailView();
                        int pilih = table.getSelectedRow();

                        TableModel tm = table.getModel();
				
                               
				String nama = tm.getValueAt(pilih, 1).toString();
				dv.lnm.setText(nama);
				String massa = tm.getValueAt(pilih, 2).toString();
				dv.lmsa.setText(massa);
				String harga = tm.getValueAt(pilih, 3).toString();
				dv.lhrga.setText(harga);
			dispose();
                                
                                
            }
});
    }
    
    public int getBanyakData(){ //menghitung jumlah baris yg ada pada db
        int jmlData = 0; //nilai awal 0
        try{
            connect.statement = connect.connection.createStatement();
            String query = "Select * from `barang`";
            ResultSet resultSet = connect.statement.executeQuery(query); //pengambilan data dalam java dari database
            while(resultSet.next()){ //ambil nilai dari baris ke 0 sampai baris akhir
                jmlData++;
            }
            return jmlData; //mengembalikan jumlah data ke readData
        }catch(SQLException e){
            System.out.println(e.getMessage());
            System.out.println("SQL Error");
            return 0;
        }
        
    }
    
    public String[][] readData(){ //dua dimensi (baris-kolom)
        try{
            int jmlData = 0; //menampung jumlah data sebanyak jumlah data yang ada, defaultnya 0
            String data[][] = new String[getBanyakData()][4];//menampung array. barisnya isinya di getBanyakData,kolomnya itu atribut
            String query = "Select * from `barang`"; //proses pengambilan data
            ResultSet resultSet = connect.statement.executeQuery(query); //result isinya tabel belum berupa string
            while(resultSet.next()){ //konversi tabel ke string
                data[jmlData][0] = resultSet.getString("id"); 
                data[jmlData][1] = resultSet.getString("nama"); 
                data[jmlData][2] = resultSet.getString("massa");
                data[jmlData][3] = resultSet.getString("harga");
                jmlData++; 
                
            }
            return data;
        }catch(SQLException e){
            System.out.println(e.getMessage());
            System.out.println("SQL Error");
            return null;
        }
    }

}
