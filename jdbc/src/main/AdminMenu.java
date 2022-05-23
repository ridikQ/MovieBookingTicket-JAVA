package main;

import model.*;
import service.*;

import java.util.List;
import java.util.Scanner;

public final class AdminMenu {
    public static final Scanner SCANNER = new Scanner(System.in);

    private AdminMenu() {

    }

    public static void menu() {

        System.out.println("Admin menu");
        char exit;
        do {
            System.out.println("\t\t\t\t------------------------------------------");
            System.out.println("\t\t\t\t1)) Show all users");
            System.out.println("\t\t\t\t2)) Add user");
            System.out.println("\t\t\t\t3)) Add new movie");
            System.out.println("\t\t\t\t4)) Delete movie");
            System.out.println("\t\t\t\t5)) Show Movie list");
            System.out.println("\t\t\t\t6)) See total bookings");
            System.out.println("\t\t\t\t7)) Add new theater");
            System.out.println("\t\t\t\t8)) See total theaters");
            System.out.println("\t\t\t\t9)) Create timetable");

            TimeTable timeTable = new TimeTable();
            AdminService adminService = new AdminServiceImpl();
            MovieService movieService = new MovieServiceImpl();
            timeTableService timeTableService = new timeTableServiceImpl();
            BookingService bookingService = new BookingServiceImpl();
            Booking booking = new Booking();
            User user = new User();
            Movie movie = new Movie();
            Theater theater = new Theater();
            Scanner sc = new Scanner(System.in);

            Scanner in = new Scanner(System.in);
            int menu = in.nextInt();
            switch (menu) {
                case 1:
                    System.out.println("\t\t\t\t((Show all users))");
                    List<User> result = adminService.getAllUsers();
                    for (User use : result) {
                        System.out.println(use);
                    }
                    break;

                case 2:
                    System.out.println("\t\t\t\t((Add new user))");
                    System.out.println("Enter name");
                    user.setName(sc.nextLine());
                    System.out.println("Enter surname");
                    user.setSurname(sc.nextLine());
                    System.out.println("Enter  birthdate(YYYY-MM-DD)");
                    String birthdate = SCANNER.nextLine();
                    user.setBirthdate(java.sql.Date.valueOf(birthdate));
                    System.out.println("Enter role");
                    user.setRole(sc.nextLine());
                    System.out.println("Enter email");
                    user.setEmail(sc.nextLine());
                    System.out.println("Enter password");
                    user.setPassword(sc.nextLine());
                    System.out.println("Enter telephone");
                    user.setTelephone(sc.nextLine());

                    adminService.addUser(user);
                    System.out.println("\t\t\t\t((User details))");
                    System.out.println(user);
                    break;

                case 3:

                    System.out.println("\t\t\t\t((Add new movie))");
                    System.out.println("Enter movie name");
                    movie.setName(sc.nextLine());
                    System.out.println("Enter movie type");
                    movie.setType(sc.nextLine());
                    System.out.println("Enter technology");
                    movie.setTechnology(sc.nextLine());
                    System.out.println("Enter rating");
                    movie.setRating(sc.nextDouble());
                    System.out.println("Enter theater id");
                    movie.setTheaterId(sc.nextInt());

                    movieService.addMovie(movie);
                    System.out.println("Movie details");
                    System.out.println(movie);

                    break;

                case 4:
                    System.out.println("\t\t\t\t((Delete movie))");
                    System.out.println("Enter movie id");
                    movie.setId(sc.nextInt());
                    movieService.deleteMovie(movie.getId());
                    System.out.println("Movie is deleted");

                    break;

                case 5:

                    System.out.println("\t\t\t\t((Show movie list))");
                    List<Movie> result1 = movieService.getAllMovies();
                    for (Movie mov : result1) {
                        System.out.println(mov);
                    }
                    break;

                case 6:
                    System.out.println("\t\t\t\t((See total bookings))");

                    List<Booking> result4 = bookingService.getAllBookings();
                    for (Booking mov : result4) {
                        System.out.println(mov);
                    }
                    break;

                case 7:
                    System.out.println("\t\t\t\t((Add new theater))");
                    System.out.println("Enter theater name");
                    theater.setTheaterName(sc.nextLine());
                    System.out.println("Seat total");
                    theater.setSeatsTotal(sc.nextInt());
                    movieService.addTheater(theater);
                    System.out.println("Theater details))");
                    System.out.println(theater);
                    break;

                case 8:
                    System.out.println("\t\t\t\t((Total theaters))");
                    List<Theater> result2 = movieService.getAllTheaters();
                    for (Theater theate : result2) {
                        System.out.println(theate);
                    }
                    break;

                case 9:
                    System.out.println("\t\t\t\t((Create Timetable))");
                    System.out.println("Enter movie id");
                    timeTable.setMovie_id(sc.nextInt());
                    System.out.println("Enter date");
                    String movieDate = SCANNER.nextLine();
                    timeTable.setDate(java.sql.Date.valueOf(movieDate));
                    System.out.println("Set Start time");
                    String start_Time = SCANNER.nextLine();
                    timeTable.setStartTime(java.sql.Time.valueOf(start_Time));
                    System.out.println("Set End time");
                    String end_Time = SCANNER.nextLine();
                    timeTable.setEndTime(java.sql.Time.valueOf(end_Time));
                    timeTableService.addTimeTable(timeTable);

                    break;

                default:
                    System.out.println("Wrong");
                    break;
            }
            System.out.println("Enter Q if you want to quit or type anything to continue");
            in.nextLine();
            exit = in.nextLine().charAt(0);
        } while (exit != 'Q');
    }
}