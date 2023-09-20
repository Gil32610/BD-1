package Registros;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import Biblioteca.Livro.Livro;

public class EmprestimoLivros {
    
    public static void emprestimos(File file, ArrayList<Object> array) {
        Livro l = ProcurarRegistro.checkReg(file);
        if (l != null) {
            emprestimoLivros(l);
            try {
                CriarRegistro.writeRegistro(file, array);
                System.out.println("Operação Concluída!");
            } catch (IOException ex) {

            }
        }
    }

    public static void emprestimoLivros(Livro l) {
        int op = 0;
        Scanner s = new Scanner(System.in);
        System.out.println("Informe a opção desejada:");
        do {
            fieldsOptions();
            op = Integer.parseInt(s.nextLine());
            switch (op) {
                case 1:
                    System.out.println(l);
                    break;
                case 2:
                    System.out.println("Quantos exemplares você deseja emprestar: ");
                    int quantidadeE = Integer.parseInt(s.nextLine());
                    l.setQuantidade(l.getQuantidade()-quantidadeE);
                    System.out.println("\nExemplares Emprestados!");
                    break;
                case 3:
                    System.out.println("Quantos exemplares você deseja desvolver: ");
                    int quantidadeD = Integer.parseInt(s.nextLine());
                    l.setQuantidade(l.getQuantidade()+quantidadeD);
                    System.out.println("\nExemplares Devolvidos!");
                    break;   
                default:
                    System.out.println("Não é uma opção!");
                    break;
            }

        } while (op != 0);
    }

    public static void fieldsOptions() {
        System.out.println("1 - Consultar Livro");
        System.out.println("2 - Emprestar Livro");
        System.out.println("3 - Devolver Livro");
        System.out.println("0 - Sair");
    }
}
