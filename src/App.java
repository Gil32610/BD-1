import java.io.File;
import java.nio.file.Files;

import UserFunc.*;
public class App {
    public static void main(String[] args) throws Exception {
        Menu.menuList();
        String filename = "files/data_set_library.dat";
        File file = new File(filename);
        if(file.createNewFile()){
            System.out.println("Binary file created");
        }
        System.out.printf("%s",file.exists()?"It's here": "Was not created"); 
    }
}
