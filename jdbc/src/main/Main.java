package main;

import model.AuthenticatedUser;
import model.Booking;
import service.AdminService;
import service.AdminServiceImpl;

import java.util.Scanner;

public class Main {
    public static AuthenticatedUser auth = null;
   public static Booking bok=null;

    public static void main(String[] args) {

        try (Scanner input = new Scanner(System.in)) {
            char exit;

            do {
                System.out.print("\n\n\n");
                System.out.println("\t\t\t\t------------------------------------------");
                System.out.println("\t\t\t\t--WELCOME TO MOVIE TICKET BOOKING SYSTEM--");
                System.out.println("\t\t\t\t------------------------------------------");
                System.out.print("\t\t\t\tEnter email:   ");
                String email = input.nextLine();
                System.out.print("\t\t\t\tEnter password:   ");
                String password = input.nextLine();
                if (!email.isEmpty() && !password.isEmpty()) {
                    AdminService adminService = new AdminServiceImpl();
                    adminService.loginUser(email, password);
                    if (auth != null) {
                        System.out.println("Welcome " + auth.getName());
                        switch (auth.getRole()) {
                            case "ADMIN":
                                AdminMenu.menu();
                                break;

                            case "USER":

                               UserMenu.userMenu();
                                break;

                            default:
                                System.out.println("You can access our app ");
                                break;
                        }
                        auth = null;
                    } else {
                        System.out.println("\nWrong credentials! Try again!");
                    }
                } else {
                    System.out.println("Email and password are required");
                }
                System.out.println("Press Q to exit or any other key to login again");
                exit = input.nextLine().charAt(0);
            }while (exit != 'Q');
            System.out.println("Thanks for using our app");
        }catch (Exception e){
            System.err.println(e.getMessage());
        }
    }
}
