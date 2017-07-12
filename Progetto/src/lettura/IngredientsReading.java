/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lettura;

//classe lettura ingredienti
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import menu.Ingredient;
import menu.Ingredient;
import menu.MenuCompleto;
import menu.MenuCompleto;
import menu.Portata;
import menu.Portata;
import menu.TipoPortata;
import menu.TipoPortata;

/**
 *
 * @author emanuele
 */
public class IngredientsReading {
    MenuCompleto menuCompleto = new MenuCompleto();
    
    public void IngredientsReading(String path) throws FileNotFoundException, IOException,
    IndexOutOfBoundsException{
        
    try{
        String s[];
    String line = null;
    String name = null;
    String type = null;
    String ingredients = null;
    FileReader file = new FileReader(path);
    BufferedReader buffer = new BufferedReader(file);
    while((line=buffer.readLine())!=null){
        Portata portata= null;
        String ingredientName = null;
        int ingredientQuantity;
        s = line.split("\t");
        name = s[0];
        type = s[1];
        switch(type){
            case "primo":
                portata = new Portata(name, TipoPortata.Primo);
                break;
            case "secondo":
                portata = new Portata(name, TipoPortata.Secondo);
                break;
            case "dolce":
                portata = new Portata(name, TipoPortata.Dolce);
                break;
        }
        if(s.length>2){
            ingredients = s[2];
            String couple[];
            couple = ingredients.split(", ");
            for(int i = 0; i < couple.length; i++){
                String[] division;
                division = couple[i].split(" ");
                ingredientName = division[0];
                ingredientQuantity = Integer.valueOf(division[1]);  
                Ingredient ingredient = new Ingredient(ingredientName, ingredientQuantity);
                portata.getIngredienti().add(ingredient);
            }
        }
        menuCompleto.addPortata(portata);
    }
    file.close();
    
    }catch(NullPointerException ex){} 
    
    
    }
}




