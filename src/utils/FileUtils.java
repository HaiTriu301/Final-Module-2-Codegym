package utils;

import model.Post;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileUtils {
    private static final String FILE_POST = "posts.csv";
    private static final String FILE_CONTENT = "content.csv";

    public static void saveToFile(List<Post> posts){
        try (
                BufferedWriter bw1 = new BufferedWriter(new FileWriter(FILE_POST));
                BufferedWriter bw2 = new BufferedWriter(new FileWriter(FILE_CONTENT))
        ) {
            bw1.write("id,title,author,createdDate");
            bw1.newLine();

            bw2.write("id,content");
            bw2.newLine();

            for (Post p : posts) {
                bw1.write(p.toFileString());
                bw1.newLine();

                bw2.write(p.toContentString());
                bw2.newLine();
            }
            System.out.println("Successful to write to file");
        } catch (IOException e) {
            System.out.println("Error writing to file");
        }
    }

    public static List<Post> readFromFile() {
        List<Post> posts = new ArrayList<>();
        try (BufferedReader br1 = new BufferedReader(new FileReader(FILE_POST))) {
            String line;
            br1.readLine();

            while ((line = br1.readLine()) != null) {
                String[] arr = line.split(",");
                String id = arr[0];

                String content = getContentByPostId(id);
                posts.add(new Post(id, arr[1], content, arr[2], arr[3]));
            }
            System.out.println("Successful to read from file");
        } catch (IOException e) {
            System.out.println("File does not exist");
        }
        return posts;
    }

    public static String getContentByPostId(String postId) {
        try (BufferedReader br = new BufferedReader(new FileReader(FILE_CONTENT))) {
            String line;
            br.readLine();

            while ((line = br.readLine()) != null) {
                int commaIndex = line.indexOf(",");
                if (commaIndex == -1) continue;

                String id = line.substring(0, commaIndex);
                if (id.equalsIgnoreCase(postId)) {
                    String content = line.substring(commaIndex + 1);

                    if (content.startsWith("\"") && content.endsWith("\"")) {
                        content = content.substring(1, content.length() - 1)
                                .replace("\"\"", "\"");
                    }
                    return content;
                }
            }
        } catch (IOException e) {
            System.out.println("File content.csv not found");
        }

        return "";
    }

}
