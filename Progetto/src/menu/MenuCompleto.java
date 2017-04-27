package menu;

import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author luby
 */
public class MenuCompleto {
    private static ArrayList<Portata> menuCompleto = new ArrayList<>();

    public ArrayList<Portata> getMenuCompleto() {
        return menuCompleto;
    }
    
    public void addPortata(Portata portata){
        menuCompleto.add(portata);
    }
    
    
}    
    
    


