import java.io.*;

public class ListFiles implements FileFilter {

    public void ListFilesMethod() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new FileWriter("ListFiles.txt", true));

        System.out.println("Please input a path:");
        try {
            File path = new File(reader.readLine());
            File[] filesPath = path.listFiles();
            if (!path.exists()) {
                try {
                    throw new WrongInputException("Please input right path");
                } catch (WrongInputException e) {
                    System.out.println(e);
                    ListFilesMethod();
                }
            }
            for (File file : filesPath) {
                writer.write(file.getName() + "\n");
                System.out.println(file.getName());
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        try {
            writer.close();
            reader.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void filterFiles() throws IOException {
        BufferedReader readerf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writerf = new BufferedWriter(new FileWriter("ListFiles.txt", true));

        try {
            System.out.println("Please insert path");
            File path = new File(readerf.readLine());

            if (!path.exists()) {
                try {
                    throw new WrongInputException("Please input a real path");
                } catch (WrongInputException e) {
                    System.out.println(e);
                    filterFiles();
                }
            }
            System.out.println("Show files that start with: ");
            File filesStartWith = new File(readerf.readLine());
            String[] filesFound = path.list((dir, name) -> name.startsWith(filesStartWith.toString()));
            System.out.println("Number of files found: " + filesFound.length);
            for (String file : filesFound) {
                writerf.write(file + "\n");
                System.out.println(file);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        try {
            writerf.close();
            readerf.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean accept(File pathname) {
        return false;
    }
}