package Registros;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Scanner;

import Biblioteca.Livro.Livro;

public class CriarRegistro {

    public static void main(String[] args) {

    }

    public static void consultarLivro(File file) {

    }

    public static void inserirLivro(File file, ArrayList<Object> registros) {
        Scanner s = new Scanner(System.in);
        Livro l;
        String titulo, autor;
        int codigo, quantidade, anoPublicacao;
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
        registros.add(l);
        try{
            writeRegistro(file, registros);
        }catch(Exception e){
        }
        System.out.println("Livro adicionado!");

    }

    public static void writeRegistro(File file, ArrayList<Object> registros) throws IOException {
        OutputStream os = null;
        try {
            os = new FileOutputStream(file);
            ObjectOutputStream oos = new ObjectOutputStream(os);
            for (Object object : registros) {
                oos.writeObject(object);
            }
            oos.flush();
        } finally {
            if (os != null) {
                os.close();
            }
        }

    }

}
