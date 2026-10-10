import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Codefiles {

    static void findFiles(File directory, List<String> files) {
        File[] items = directory.listFiles();

        if (items == null) {
            return;
        }

        for (File item : items) {
            if (item.isFile()) {
                String name = item.getName();

                if (name.endsWith(".java") || name.endsWith(".cpp")) {
                    files.add(item.getPath());
                }
            } else if (item.isDirectory()) {
                findFiles(item, files);
            }
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter directory path: ");
        String path = input.nextLine();

        List<String> files = new ArrayList<>();

        findFiles(new File(path), files);

        System.out.println("\nJava and C++ files found:");

        for (String file : files) {
            System.out.println(file);
        }

        input.close();
    }
}
