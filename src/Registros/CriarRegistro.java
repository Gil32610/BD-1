package Registros;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Scanner;

import Biblioteca.Livro.Livro;

public class CriarRegistro {

    public static void main(String[] args) {

    }
    public static void consultarLivro(File file){
        	
    }

    public static void inserirLivro(File file) {
        Scanner s = new Scanner(System.in);
        Livro l;
        String titulo,autor;
        int codigo, quantidade,anoPublicacao;
        System.out.println("Informe o código do Livro:");
        codigo = Integer.parseInt(s.nextLine());
        System.out.println("Informe o Título");
        titulo = s.nextLine();
        System.out.println("Informe o Autor");
        autor = s.nextLine();
        System.out.println("Informe o ano de publicação");
        anoPublicacao = Integer.parseInt(s.nextLine());
        System.out.println("Informe a Quantidade:");
        quantidade = Integer.parseInt(s.nextLine());
        l = new Livro(titulo, codigo, autor, quantidade, anoPublicacao);
        FileOutputStream fout;
        try {
            fout = new FileOutputStream(file);
             ObjectOutputStream out = new ObjectOutputStream(fout);
             out.writeObject(l);
             out.close();
             System.out.println("Livro adicionado!");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
         catch (IOException e) {
            e.printStackTrace();
        }
        
    }

}
