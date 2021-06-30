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
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

/**
 *
 * @author asus
 */
public class TotalView extends JFrame implements ActionListener{
    
    JLabel lna,lma,lha,ltot,lnma,lmas,lhr,ltotal;
    public JTextField fbanyak;
    JButton k;
    

    public TotalView(){
      
        setLayout(null);
        setSize(410,300);
        lna = new JLabel("Nama");
        lma = new JLabel("Massa(gr)");
        lha = new JLabel("Harga Satuan");
        ltot = new JLabel("Total Harga");
            
        
        k = new JButton("Kembali");
        
        
        lnma = new JLabel("");
        lmas = new JLabel("");
        lhr = new JLabel("");
        ltotal = new JLabel("");

        add(lna);
        add(lma);
        add(lha);
        add(ltot);
        
        add(k);
        
        add(lnma);
        add(lmas);
        add(lhr);
        
        lna.setBounds(30, 30, 120, 20);
        lnma.setBounds(160,30,200,20);
        lma.setBounds(30, 60, 120, 20);
        lmas.setBounds(160,60,200,20);
        lha.setBounds(30, 90, 120, 20);
        lhr.setBounds(160,90,200,20);
        ltot.setBounds(30, 120, 120, 20);
        ltotal.setBounds(160,120,200,20);
        
        k.setBounds(20, 200, 100, 20);
        k.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        k.addActionListener(this);

        
        setTitle(lnma.getText());
        
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
}

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==k){
            DetailView de = new DetailView();
            dispose();
        }
    }
}
