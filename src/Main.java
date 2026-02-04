import service.PostService;

import java.util.Scanner;

public class Main{
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        PostService postService = new PostService();
        int choice;

        do{
            System.out.println("\n==== POST MANAGEMENT ====");
            System.out.println("1. Add Post");
            System.out.println("2. Display List of Posts");
            System.out.println("3. Find Post by ID");
            System.out.println("4. Find Post by Author");
            System.out.println("5. Sort by Post ID");
            System.out.println("6. Save to File");
            System.out.println("7. Read from File");
            System.out.println("0. Exit");

            System.out.print("Choose your function that you want: ");
            choice = input.nextInt();

            switch (choice){
                case 1 -> postService.addPost();
                case 2 -> postService.displayPosts();
                case 3 -> postService.findById();
                case 4 -> postService.findByAuthor();
                case 5 -> postService.sortById();
                case 6 -> postService.saveFile();
                case 7 -> postService.loadFile();
                case 0 -> System.out.println("Goodbye!");
                default -> System.out.println("Invalid choice, please try again");
            }
        } while(choice != 0);
    }
}