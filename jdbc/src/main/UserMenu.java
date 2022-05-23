package main;

import model.*;
import service.*;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

public final class UserMenu {

    private UserMenu(){

    }
    public static void userMenu(){

        System.out.println("User menu");
        char exit;

        do {
            System.out.println("\t\t\t\t------------------------------------------");
            System.out.println("\t\t\t\t1)) Show movie list");
            System.out.println("\t\t\t\t2)) Book ticket");
            System.out.println("\t\t\t\t3)) Show my ticket");
            System.out.println("\t\t\t\t4)) Cancel ticket");
            System.out.println("\t\t\t\t5)) Show personal details");

            MovieService movieService=new MovieServiceImpl();
            Booking booking=new Booking();
            BookingService bookingService=new BookingServiceImpl();
            Scanner in=new Scanner(System.in);
            Scanner scanner=new Scanner(System.in);
            UserService userService=new UserServiceImpl();
            TimeTable timeTable=new TimeTable();
            timeTableService timeTableService=new timeTableServiceImpl();
            int menu=in.nextInt();
            switch (menu){
                case 1:
                    System.out.println("\t\t\t\t((Show movie list))");
                    List<Movie> result1= movieService.getAllMovies();
                    for (Movie mov:result1) {
                        System.out.println(mov);
                    }
                    break;

                case 2:
                    System.out.println("Add new ticket");
                    booking.setUserId(Main.auth.getId());
                    System.out.println("Enter movie_id");

                    booking.setMovieId(scanner.nextInt());

                    List<TimeTable> result2= timeTableService.getAllTimeTablesByMovieId(booking.getMovieId());
                    for (TimeTable table:result2) {
                        System.out.println(table);
                    }

                    System.out.println("Enter seat_amount");
                    booking.setSeatAmount(scanner.nextInt());
                    System.out.println("Enter date");
                    booking.setDate(new Date());
                    bookingService.addBookings(booking);

                    break;

                case 3:

                    System.out.println("\t\t\t\t((Show my ticket))");
                    System.out.println(bookingService.getTicketById(Main.auth.getId()));

                    break;

                case 4:
                    System.out.println("\t\t\t\t((Cancel ticket))");
                    System.out.println("Enter booking id");
                    booking.setId(scanner.nextInt());
                    bookingService.deleteTicket(booking.getId());
                    break;

                case 5:
                    System.out.println("\t\t\t\t((Show personal details))");
                    System.out.println(userService.getUserById(Main.auth.getId()));
                    break;

                default:
                    System.out.println("Wrong");
                    break;
            }
            System.out.println("Type Q to exit or anything to continue");
            in.nextLine();
            exit=in.nextLine().charAt(0);
        }while (exit!='Q');
    }
}
