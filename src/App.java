import java.io.File;

import UserFunc.*;
public class App {
    public static void main(String[] args) throws Exception {
        Menu.menuList();
        System.out.println("Current Working Directory = " + new File("").getAbsolutePath());
        String filename = "files/data_set_library.csv";
        File file = new File(filename);
        System.out.printf("%s",file.exists()?"It's here": "Was not created");
        
    }
}
