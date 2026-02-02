package service;

import exception.InvalidPostException;
import model.Post;
import utils.FileUtils;
import utils.ValidationUtils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class PostService {
    ArrayList<Post> posts = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);

    public void addPost() {
        String id, title, content, author;

        while (true) {
            try {
                System.out.print("Enter the ID (Ex: P001): ");
                id = scanner.nextLine();
                if (!ValidationUtils.isValidId(id)) {
                    throw new InvalidPostException("Invalid Post ID, please try again");
                }
                break;
            } catch (InvalidPostException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }

        while (true) {
            try {
                System.out.print("Enter title: ");
                title = scanner.nextLine();
                if (!ValidationUtils.isNotEmpty(title)) {
                    throw new InvalidPostException("The title must not be empty");
                }
                break;
            } catch (InvalidPostException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }

        System.out.print("Enter content: ");
        content = scanner.nextLine();

        System.out.print("Enter author: ");
        author = scanner.nextLine();

        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String createdDate = now.format(formatter);

        posts.add(new Post(id, title, content, author, createdDate));
        System.out.println("Post added successfully");
    }

    public void displayPosts() {
        if (posts.isEmpty()) {
            System.out.println("The list of posts is empty");
            return;
        }

        for (Post post : posts) {
            System.out.println(post);
        }
    }

    public void findById() {
        System.out.print("Enter post ID: ");
        String id = scanner.nextLine();
        for (Post post : posts) {
            if (post.getId().equals(id)) {
                System.out.println(post);
                return;
            }
        }

        System.out.println("Post not found");
    }

    public void findByAuthor() {
        System.out.print("Enter post author: ");
        String author = scanner.nextLine();
        for (Post post : posts) {
            if (post.getAuthor().equals(author)) {
                System.out.println(post);
            }
        }
    }

    public void saveFile() {
        FileUtils.saveToFile(posts);
    }

    public void loadFile() {
        posts = new ArrayList<>(FileUtils.readFromFile());
    }
}
