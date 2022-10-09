package appPack;

import profile.UserProfile;
import settings.UserSettings;

import java.util.List;

public class MainApp {

    public static void main(String[] args) {

        UserProfile profile = new UserProfile();

        System.out.println( UserProfile.city );

        UserProfile.city = "Ankara";

        UserSettings settings = new UserSettings();
        settings.call();

        MainApp app = new MainApp();
        app.read();

        // istisnalar
        String age = "30 ";
        try {
            int i = 1 / 0;
            // Hata beklenen yada hata olma olasılığı olan kod parçaları
            int cAge = Integer.parseInt(age);
            int action = cAge * 2;
            System.out.println("Action : " + action);
        }catch ( Exception ex) {
            System.err.println(ex);
        }


        UserProfile prf = new UserProfile();
        try {
            prf.fileUsing("sample.txt");
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("This Line Call");


        UseFile file = new UseFile("data.txt");
        file.createFile();

        // delete file
        // file.deleteFile();

        // File Save Data
        file.fileSaveData("New Data " + Math.random() );

        // File read data
        List<String> ls = file.fileRead();
        System.out.println( ls.get(0) );

    }


    void read() {
        System.out.println("Read Call");
    }


}
