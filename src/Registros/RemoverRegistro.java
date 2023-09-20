package Registros;
import java.util.Scanner;

import Biblioteca.Livro.Livro;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class RemoverRegistro {
   

    public static void delete(File file, ArrayList<Object> registros){
        Scanner s = new Scanner(System.in);
        System.out.println("Informe o código do livro:");
        int codigo = Integer.parseInt(s.nextLine());
        Livro l = new Livro(codigo);
        if(registros.contains(l)){
            registros.remove(l);
            try{
                CriarRegistro.writeRegistro(file, registros);
                System.out.println("Registro removido!");
                return;
            }catch(IOException ex){
                
            }
        }
        System.out.println("Registro não encontrado.");
        
    }
}
