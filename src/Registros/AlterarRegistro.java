package Registros;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import Biblioteca.Livro.Livro;
import Registros.*;

public class AlterarRegistro {
    public static void changeRegister(File file, ArrayList<Object> array) {
        Livro l = ProcurarRegistro.getLivro(array);
        if (l != null) {
            changeFields(l);
            try {
                CriarRegistro.writeRegistro(file, array);
                System.out.println("Registro alterado!");
            } catch (IOException ex) {

            }
        }
    }

    public static void changeFields(Livro l) {
        int op = 0;
        Scanner s = new Scanner(System.in);
        System.out.println("Informe a opção desejada:");
        do {
            fieldsOptions();
            op = Integer.parseInt(s.nextLine());
            switch (op) {
                case 1:
                    System.out.println("Código atual: " + l.getCodigo());
                    System.out.print("Novo código:");
                    int codigo = Integer.parseInt(s.nextLine());
                    l.setCodigo(codigo);
                    System.out.println("Código alterado!");
                    break;
                case 2:
                    System.out.println("Título Atual: " + l.getTitulo());
                    System.out.print("Novo Título: ");
                    String titulo = s.nextLine();
                    l.setTitulo(titulo);
                    System.out.println("\nTítulo alterado!");
                    break;
                case 3:
                    System.out.println("Autor Atual: " +l.getAutor());
                    System.out.print("Novo Autor: ");
                    String autor = s.nextLine();
                    l.setAutor(autor);
                    System.out.println("\nAutor alterado!");
                    break;
                case 4:
                    System.out.println("Quantidade Atual: "+l.getQuantidade());
                    System.out.print("Nova Quantidade: ");
                    int quantidade = Integer.parseInt(s.nextLine());
                    l.setQuantidade(quantidade);
                    System.out.println("\nQuantidade alterada!");
                    break;
                case 5:
                    System.out.println("Ano de Publicação Atual: "+l.getAnoPublicacao());
                    System.out.print("Nova Ano de Publicação: ");
                    int anoPublicacao = Integer.parseInt(s.nextLine());
                    l.setAnoPublicacao(anoPublicacao);
                    System.out.println("\nAno da Publicação alterado!");
                    break;    
                    case 0:
                    System.out.println("Retornando!");
                    break;
                default:
                    System.out.println("Não é uma opção!");
                    break;
            }

        } while (op != 0);
    }

    public static void fieldsOptions() {
        System.out.println("1 - Alterar código");
        System.out.println("2 - Alterar título");
        System.out.println("3 - Alterar autor(a)");
        System.out.println("4 - Alterar quantidade");
        System.out.println("5 - Alterar data de publicação");
        System.out.println("0 - Sair");
    }
}
