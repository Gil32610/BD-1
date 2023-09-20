package Registros;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;

public class ListarRegistros {

    public static ArrayList<Object> ler(File file){
        ArrayList<Object> registros = new ArrayList<Object>();
        boolean cont = true;
        FileInputStream fis;
        ObjectInputStream ois;
        try {
            fis = new FileInputStream(file);
             ois = new ObjectInputStream(fis);
            while(cont){
                Object obj = ois.readObject();
                if(obj!=null){
                    registros.add(obj);
                }else{
                    cont = false;
                    ois.close();
                }
            }
            
        } catch (Exception e) {
        
        }
        finally{
            
        }
        return registros;
    }

    public static void listarLivros(ArrayList<Object> registros){
        for (int i = 0; i < registros.size(); i++) {
            System.out.println(registros.get(i));
        }
    }
}
