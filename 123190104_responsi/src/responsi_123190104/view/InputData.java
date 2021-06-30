/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package responsi_123190104.view;

import java.awt.Color;
import java.awt.Cursor;
import responsi_123190104.view.MenuView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import responsi_123190104.DBConnect;
import responsi_123190104.controller.InputController;
import responsi_123190104.controller.MenuController;


/**
 *
 * @author asus
 */
public class InputData extends JFrame implements ActionListener {
    public String nama, massa, harga;
    
      
    
    JLabel linput,lnama,lmassa,lhrg;
    public JTextField fnama,fmassa,fhrg;
    JButton sbmt,rst, kmbl;

    public InputData() {
        
        linput = new JLabel("Input Barang");
        lnama = new JLabel("Nama");
            fnama = new JTextField();
        lmassa = new JLabel("Massa(gr)");
            fmassa = new JTextField();
        lhrg = new JLabel("Harga Satuan");
            fhrg = new JTextField();
        
        sbmt = new JButton("Submit");
        rst = new JButton("Reset");
        kmbl = new JButton("Kembali");
        
        add(linput);
        add(lnama);
        add(fnama);
        add(lmassa);
        add(fmassa);
        add(lhrg);
        add(fhrg);
        add(sbmt);
        add(rst);
        add(kmbl);
        
        linput.setBounds(20, 30, 120, 20);
        lnama.setBounds(30, 60, 120, 20);
        fnama.setBounds(160,60,200,20);
        lmassa.setBounds(30, 90, 120, 20);
        fmassa.setBounds(160,90,200,20);
        lhrg.setBounds(30, 120, 120, 20);
        fhrg.setBounds(160,120,200,20);
        sbmt.setBounds(80, 160, 130, 20);
        sbmt.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        sbmt.addActionListener(this);
        rst.setBounds(230,160,130,20);
        rst.setBackground(Color.red);
        rst.setForeground(Color.white);
        rst.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        rst.addActionListener(this);
        kmbl.setBounds(20, 200, 350, 25);
        kmbl.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        kmbl.addActionListener(this);

        
        
        setTitle("Input Barang");
        setLayout(null);
        setSize(410,300);
        setVisible(true);
        setLocationRelativeTo(null);
        setResizable(false);


       // setDefaultCloseOperation(EXIT_ON_CLOSE);
//
//        sbmt.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent arg0) {
//                   try {
//                      
//                       if(fnama.getText().equals("")){
//                           JOptionPane.showMessageDialog(null,"Nama tidak boleh kosong!!");
//                       }
//                       if(fmassa.getText().equals("")){
//                           JOptionPane.showMessageDialog(null,"Massa tidak boleh kosong!!");
//                       }
//                       if(fhrg.getText().equals("")){
//                           JOptionPane.showMessageDialog(null,"Harga tidak boleh kosong!!");
//                       }
//                       if(Double.parseDouble(fmassa.getText())<0){
//                           JOptionPane.showMessageDialog(null,"Massa dan Harga harus positif!!");
//                       }else if(Double.parseDouble(fhrg.getText())<0){
//                           JOptionPane.showMessageDialog(null,"Massa dan Harga harus positif!!");
//                       }
////                       else if(Double.parseDouble(getHarga())== String){
////                           JOptionPane.showMessageDialog(null,"Massa dan Harga harus angka!!");
////                       }
//                     
//                       else{
//                           String[] data={
//                               fnama.getText(),fmassa.getText(),fhrg.getText()
//                           };
//                    dispose();
//                    InputController input = new InputController();
//                    input.tbhbarang(data);
//                       
//                   }
//                   
//        } catch (Exception ex){
//            System.out.println(ex.getMessage());
//        } 
//                   
//            }
//        });
        
//        rst.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent arg0) {
//                fnama.setText("");
//                fmassa.setText("");
//                fhrg.setText("");
//            }
//        });
//        kmbl.addActionListener(new ActionListener() {
//
//            @Override
//            public void actionPerformed(ActionEvent arg0) {
//                MenuController mn = new MenuController();
//                mn.openMenu();
//                dispose();
//            }
//        });
    }
    
//    public String getNama(){
//        return fnama.getText();
//    }
//
//    public String getMassa() {
//        return fmassa.getText();
//    }
//
//    public String getHarga() {
//        return fhrg.getText();
//    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==sbmt) {
             if(fnama.getText().equals("")){
                           JOptionPane.showMessageDialog(null,"Nama tidak boleh kosong!!");
                       }
                       if(fmassa.getText().equals("")){
                           JOptionPane.showMessageDialog(null,"Massa tidak boleh kosong!!");
                       }
                       if(fhrg.getText().equals("")){
                           JOptionPane.showMessageDialog(null,"Harga tidak boleh kosong!!");
                       }
                       if(Double.parseDouble(fmassa.getText())<0){
                           JOptionPane.showMessageDialog(null,"Massa dan Harga harus positif!!");
                       }else if(Double.parseDouble(fhrg.getText())<0){
                           JOptionPane.showMessageDialog(null,"Massa dan Harga harus positif!!");
                       }
            else {
                String[] data = {
                               fnama.getText(),fmassa.getText(),fhrg.getText()
                };
                InputController inpt = new InputController();
                inpt.tbhbarang(data);
            }
        }
        else if(e.getSource()==rst){
            fnama.setText("");
            fmassa.setText("");
            fhrg.setText("");
        }
        else if(e.getSource()==kmbl){
            dispose();
            MenuController m = new MenuController();
            m.openMenu();
        }

    }
    
}
