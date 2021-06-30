package responsi_123190104.view;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



import java.awt.Cursor;
import java.awt.GridLayout;
import static java.awt.SystemColor.window;
import javax.swing.*;
import java.awt.event.*;
import responsi_123190104.controller.InputController;
import responsi_123190104.controller.LihatController;
import responsi_123190104.controller.MenuController;

/**
 *
 * @author asus
 */
public class MenuView extends JFrame implements ActionListener {
    JLabel menu;
    JButton btnlihat,btntambah;

    public MenuView() {
        menu = new JLabel("Main Menu  ");
        btntambah = new JButton("Tambah Barang");
        btnlihat = new JButton("Lihat Barang");
        
        setLayout(null);
        setSize(200,180);
        add(menu);
        add(btntambah);
        add(btnlihat);
        
       menu.setBounds(70,5,100,20);
       btntambah.setBounds(20,40,150,20);
       btnlihat.setBounds(20,65,150,20);
       btnlihat.addActionListener(this);
       btntambah.addActionListener(this);
       btnlihat.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
       btntambah.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
       setVisible(true);
       setDefaultCloseOperation(EXIT_ON_CLOSE);
       setLocationRelativeTo(null);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()== btntambah){
            InputController menu = new InputController();
                menu.openTambah();
                dispose();
        }
        else if(e.getSource()== btnlihat){
            LihatController menu = new LihatController();
                menu.openlihat();
                dispose();
        }
       
    }
    
}
