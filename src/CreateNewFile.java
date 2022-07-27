import java.io.*;

public class CreateNewFile {

    public void CreateNewFilePathAndName() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = null;

        try {
            System.out.println("Please insert path");
            File path = new File(reader.readLine());
            if (!path.exists()) {
                throw new WrongInputException("Please input a real path");
            }
            System.out.println("Please choose file name to create");
            File file = new File(reader.readLine());

            String filePath = path.getName().concat("/").concat(file.getName());
            writer = new BufferedWriter(new FileWriter(filePath));
            System.out.println("Your file was created!");

        }
        catch (IOException | WrongInputException e) {
            System.out.println(e.getMessage());
        }
        try {
            writer.close();
            reader.close();
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}