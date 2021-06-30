/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package responsi_123190104.view;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import responsi_123190104.DBConnect;

/**
 *
 * @author asus
 */
public class DetailView extends JFrame implements ActionListener{
    public String id;
     DBConnect connect = new DBConnect();
    JLabel ln,lm,lh,lbanyak,lnm,lmsa,lhrga;
    public JTextField fbanyak;
    JButton k,edt,hps,tot;
    

    public DetailView(){
      
        setLayout(null);
        setSize(410,300);
        ln = new JLabel("Nama");
        lm = new JLabel("Massa(gr)");
        lh = new JLabel("Harga Satuan");
        lbanyak = new JLabel("Banyak");
            fbanyak = new JTextField();
        
        k = new JButton("Kembali");
        edt = new JButton("Edit");
        hps = new JButton("Hapus");
        tot= new JButton("Total Harga");
        
        lnm = new JLabel("");
        lmsa = new JLabel("");
        lhrga = new JLabel("");
        

        add(ln);
        add(lm);
        add(lh);
        add(lbanyak);
        add(fbanyak);
        add(k);
        add(edt);
        add(hps);
        add(tot);
        
        add(lnm);
        add(lmsa);
        add(lhrga);
        
        ln.setBounds(30, 30, 120, 20);
        lnm.setBounds(160,30,200,20);
        lm.setBounds(30, 60, 120, 20);
        lmsa.setBounds(160,60,200,20);
        lh.setBounds(30, 90, 120, 20);
        lhrga.setBounds(160,90,200,20);
        lbanyak.setBounds(30, 120, 120, 20);
        fbanyak.setBounds(160,120,200,20);
        tot.setBounds(130,150,120,20);
        tot.addActionListener(this);
        k.setBounds(20, 200, 100, 20);
        k.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        k.addActionListener(this);
        edt.setBounds(140,200,100,20);
        edt.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        edt.setBackground(Color.blue);
        edt.setForeground(Color.white);
        edt.addActionListener(this);
        hps.setBounds(260, 200, 100, 20);
        hps.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        hps.setBackground(Color.red);
        hps.setForeground(Color.white);
        hps.addActionListener(this);
        
        
        setTitle(lnm.getText());
        
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
             
        
    } 
    @Override
     public void actionPerformed(ActionEvent e) {
        if(e.getSource()==tot){
            try{
           TotalView tv = new TotalView();
           double banyak=0, harga=0,total=0;
           String b = fbanyak.getText();
           String h = lhrga.getText();
           banyak = Double.parseDouble(b);
           harga = Double.parseDouble(h);
           
           total = banyak*harga;
 
            String t = Double.toString(total);
            tv.lnma.setText(lnm.getText());
            tv.lmas.setText(lmsa.getText());
            tv.lhr.setText(lhrga.getText());
            tv.ltotal.setText(t);
           
            dispose();
            }
            catch(Exception exe){
             JOptionPane.showMessageDialog(null, "Total Error");

            }
           
        }
        else if(e.getSource()==k){
            LihatData l = new LihatData();
            dispose();
        }
        else if(e.getSource()==edt){
//            try{
//            String query = " update barang set id=?, nama=?,massa=?,harga=?";
//            PreparedStatement preparedStmt = connection.prepareStatement(query);
//            preparedStmt.setString (1, data[0]);
//            preparedStmt.setString (2, data[1]);
//            preparedStmt.setString (3, data[2]);
//            preparedStmt.setString (4, data[3]);
//            preparedStmt.execute();
//            statement.close();
//            connection.close();
//            JOptionPane.showMessageDialog(null, "Berhasil");
//        } catch (SQLException e) {
//            JOptionPane.showMessageDialog(null, e.getMessage());
//        }
            
        }
        else{
//             try {
//            connect.statement = connect.connection.createStatement();
//            String query = " delete from barang where id = ?";
//            ResultSet resultSet = connect.statement.executeQuery(query); 
//         
//            query = " delete from barang where id = ?";
//           
//
//            JOptionPane.showMessageDialog(null, "Hapus Berhasil");
//        }
//        catch (SQLException e){
//            JOptionPane.showMessageDialog(null, "Gagal! Hapus dulu data status orang dengan id = " + id);
//        }
//        
//            
//        }
    }

}
}
