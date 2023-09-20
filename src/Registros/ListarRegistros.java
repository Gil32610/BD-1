package Registros;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;

public class ListarRegistros {
    static ArrayList<Object> registros;

    public static void listar(File file){
        registros = new ArrayList<Object>();
        boolean cont = true;
        try {
            FileInputStream fis = new FileInputStream(file);
            ObjectInputStream ois = new ObjectInputStream(fis);
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

    }
}
