import java.io.File;
import java.util.Scanner;

public class ReadFile {
    public String readFile(String filePath) {
        File file = new File(filePath);
        StringBuilder sb = new StringBuilder();
        try (Scanner sc = new Scanner(file)) {
            sb.append(sc.nextLine());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sb.toString();
    }
}
