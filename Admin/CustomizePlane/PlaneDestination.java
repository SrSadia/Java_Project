package Admin.CustomizePlane;

import java.io.FileWriter;
import java.io.IOException;

public class PlaneDestination {
    public static void saveToFile(String... data) {
        try {
            FileWriter writer = new FileWriter("PlaneDestination.txt", true);
            writer.write(String.join(";", data) + "\n");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
