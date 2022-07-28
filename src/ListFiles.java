import java.io.*;
public class ListFiles {

    public void ListFilesMethod() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new FileWriter("ListFiles.txt"));

        System.out.println("Please input a path:");
        try {
            File path = new File(reader.readLine());
            File[] filesPath = path.listFiles();
            if (!path.exists()) {
                try{
                throw new WrongInputException("Please input right path");
                }
                catch (WrongInputException e) {
                    System.out.println(e);
                    ListFilesMethod();
                }
            }
            for (File file : filesPath) {
                writer.write(file.getName() + "\n");
                System.out.println(file.getName());
            }
        }
        catch (IOException e) {
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