/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package responsi_123190104.controller;

import responsi_123190104.model.InputModel;
import responsi_123190104.view.DetailView;
import responsi_123190104.view.LihatData;
import responsi_123190104.view.MenuView;

/**
 *
 * @author asus
 */
public class LihatController {
     
    public void openlihat(){
        new LihatData();
    }
    
    public void lihat(){
       InputModel mdl = new InputModel();
       String[][] data = mdl.readData();
       if(data==null)
           new MenuView();
       else 
           new LihatData();
    }
    public void readData(String kode){
        InputModel model = new InputModel();
        DetailView d = new DetailView();
//        d.openDetail(model.readData(kode));
    }

    
}
