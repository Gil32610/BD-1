package Registros;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;

import Biblioteca.Livro.Livro;

public class ProcurarRegistro {
    public static Object findRegistro(File file, int codigo)throws IOException{
        Livro l = new Livro(codigo);

        InputStream is = null;
        try{
            is = new FileInputStream(file);
            ObjectInputStream ois = new ObjectInputStream(is);
            while(true){
                try{
                    Object obj = ois.readObject();
                    if(l.equals(obj)){
                        return obj;
                    }
                }catch (EOFException e){
                    return null;
                }
            }
        }
        finally{
            if(is!=null){
                is.close();
            }

        }

    }
}
