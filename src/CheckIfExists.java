import java.io.*;

public class CheckIfExists {

    public CheckIfExists(){}

    public boolean CheckIfExistsBool() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Please input \"path/file\" to check is it exists:");
        try {
            File path = new File(reader.readLine());
            if (!path.exists()) {
                throw new WrongInputException("Please input right path");
            }
            System.out.println("Your file exists!");
        } catch (IOException | WrongInputException e) {
            System.out.println(e.getMessage());
        }
        try {
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return true;
    }
}