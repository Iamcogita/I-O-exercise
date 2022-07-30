import java.io.*;

public class CheckIfExists {

    public boolean CheckIfExistsBool() throws IOException{
        BufferedReader reader2 = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Please input \"path/file\" to check is it exists:");
        try {
            File path = new File(reader2.readLine());
            if (!path.exists()) {
                try {
                    throw new WrongInputException("Please input right path");
                } catch (WrongInputException e) {
                    System.out.println(e);
                    CheckIfExistsBool();
                }
            }
            System.out.println("Your file exists!");
        }
        catch (IOException e) {
            System.out.println(e.getMessage());
        }
        try {
            reader2.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return true;
    }
}