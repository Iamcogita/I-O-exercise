import java.io.*;

public class CreateNewFile {

    public void CreateNewFilePathAndName() throws IOException {
        BufferedReader reader1 = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer1 = null;

        try {
            System.out.println("Please insert path");
            File path = new File(reader1.readLine());

            if (!path.exists()) {
                try{
                throw new WrongInputException("Please input a real path");
                }
                catch (WrongInputException e) {
                    System.out.println(e);
                    CreateNewFilePathAndName();
                }

            }
            System.out.println("Please choose file name to create");
            File file = new File(reader1.readLine());

            String filePath = path.getName().concat("/").concat(file.getName());
            writer1 = new BufferedWriter(new FileWriter(filePath));
            System.out.println("Your file was created!");

        }
        catch (IOException e) {
            System.out.println(e.getMessage());
        }
        try {
            writer1.close();
            reader1.close();
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}