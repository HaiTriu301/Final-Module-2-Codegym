package utils;

import model.Post;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileUtils {
    private static final String FILE_NAME = "posts.csv";

    public static void saveToFile(List<Post> posts){
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_NAME))) {
            bw.write("id,title,author,createdDate");
            bw.newLine();

            for (Post p : posts) {
                bw.write(p.toFileString());
                bw.newLine();
            }
            System.out.println("Successful to write to file");
        } catch (IOException e) {
            System.out.println("Error writing to file");
        }
    }

    public static List<Post> readFromFile() {
        List<Post> posts = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            br.readLine();

            while ((line = br.readLine()) != null) {
                String[] arr = line.split(",");
                posts.add(new Post(arr[0], arr[1], "",arr[2], arr[3]));
            }
            System.out.println("Successful to read from file");
        } catch (IOException e) {
            System.out.println("File is not exist");
        }

        return posts;
    }
}
