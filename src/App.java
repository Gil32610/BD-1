import java.io.File;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Scanner;
import Registros.CriarRegistro;
import Registros.ListarRegistros;
import UserFunc.*;

public class App {
    public static void main(String[] args) throws Exception {
        
        String filename = "files/data_set_library.dat";
        File file = new File(filename);
        if(file.createNewFile()){
            System.out.println("Binary file created");
        }
        System.out.printf("%s",file.exists()?"It's here": "Was not created"); 
        Scanner s = new Scanner (System.in);
        ArrayList<Object> registros =ListarRegistros.ler(file);
        int op;
        do{
            Menu.menuList();
            op = Integer.parseInt(s.nextLine());
            Menu.options(op, file,registros);
        }while(op!= 0);
        
    }
}
