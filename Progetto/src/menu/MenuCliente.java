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
public class MenuCliente {
    private ArrayList<Portata> menuCliente;

    public MenuCliente(){
        menuCliente = new ArrayList<>();
    }
    
    public ArrayList<Portata> getMenuCliente() {
        return menuCliente;
    }

    public void setMenuCliente(ArrayList<Portata> menuCliente) {
        this.menuCliente = menuCliente;
    }
    
    
    
    
}
