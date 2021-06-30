/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package responsi_123190104.controller;

import responsi_123190104.model.InputModel;
import responsi_123190104.view.InputData;

/**
 *
 * @author asus
 */
public class InputController {
    public void openTambah(){
        new InputData();
    }
    
    public void tbhbarang(String[] data){
        InputModel in = new InputModel();
        in.tambahdata(data);
        
    }
}
