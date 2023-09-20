package UserFunc;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import Registros.RemoverRegistro;
import Biblioteca.Livro.Livro;
import Registros.ProcurarRegistro;
import Registros.CriarRegistro;
import Registros.ListarRegistros;

public class Menu {

    public static void menuList() {
        System.out.println("-".repeat(20));
        System.out.println("Informe a opção desejada:");
        System.out.println("1 - Criar novo registro");
        System.out.println("2 - Listar registros");
        System.out.println("3 - Alterar registro");
        System.out.println("4 - Remover Registro");
        System.out.println("5 - Consultar Registro");
        System.out.println("0 - Encerrar");
        System.out.println("-".repeat(20));
    }

    public static void options(int op, File file, ArrayList<Object> array) {
        switch (op) {
            case 1:
                CriarRegistro.inserirLivro(file, array);
                break;
            case 2:
                ArrayList<Object> registros = ListarRegistros.ler(file);
                ListarRegistros.listarLivros(registros);
                break;
            case 3:
            
                break;
            case 4:
                RemoverRegistro.delete(file, array);
                break;
            case 5:
                Livro l = ProcurarRegistro.checkReg(file);
                if (l != null)
                    System.out.println(l);
                break;
        }
    }

}
