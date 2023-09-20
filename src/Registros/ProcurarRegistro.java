package Registros;
import java.util.Scanner;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;

import Biblioteca.Livro.Livro;

public class ProcurarRegistro {
    private static Livro findRegistro(File file, int codigo) throws IOException {
        Livro l = new Livro(codigo);

        InputStream is = null;
        try {
            is = new FileInputStream(file);
            ObjectInputStream ois = new ObjectInputStream(is);
            while (true) {
                try {
                    Object obj = ois.readObject();
                    if (l.equals(obj)) {
                        return (Livro) obj;
                    }
                } catch (EOFException e) {
                    ois.close();
                    return null;
                } catch (Exception a) {

                }
            }
            
        } finally {
            if (is != null) {
                is.close();
            }

        }

    }

    public static Livro checkReg(File file){
        Scanner s = new Scanner(System.in);
        int codigo =0;
        System.out.println("Informe o código do livro:");
        codigo = Integer.parseInt(s.nextLine());
        try{
            return findRegistro(file, codigo);
        }catch(IOException ex){
            return null;
        }

    }
}
