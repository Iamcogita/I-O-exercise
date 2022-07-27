import java.io.*;

public class CreateNewFile {

    public void CreateNewFilePathAndName() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = null;

        try {
            System.out.println("Please insert path");
            File path = new File(reader.readLine());
            System.out.println(path);

            System.out.println("Please insert file");
            File file = new File(reader.readLine());
            System.out.println(file);

            String filePath = path.getName().concat("/").concat(file.getName());
            writer = new BufferedWriter(new FileWriter(filePath));
        }
        catch (IOException e) {
            System.out.println(e.getMessage());
        }
        try {
            writer.close();
            reader.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}