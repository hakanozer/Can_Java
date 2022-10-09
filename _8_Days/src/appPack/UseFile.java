package appPack;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UseFile {

    File file;
    public UseFile( String pathName ) {
        file = new File(pathName);
    }

    // Create New File
    public void createFile() {
        try {
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // File Delete
    public void deleteFile() {
        file.delete();
    }


    // File save data
    public void fileSaveData( String line ) {
        try {
            FileWriter writer = new FileWriter(file, true);
            writer.append(line);
            writer.append(System.lineSeparator());
            writer.close(); // save and close
        }catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    // File data read
    public List<String> fileRead() {
        List<String> lines = new ArrayList<>();
        try {
            Scanner scanner = new Scanner(file);
            while ( scanner.hasNextLine() ) {
                String line = scanner.nextLine();
                lines.add( line );
            }
        }catch (Exception ex) {
            ex.printStackTrace();
        }
        return lines;
    }

}
