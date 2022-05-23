package util;

public final class AdminQueries {
    private AdminQueries(){
    }
    public static final String LOGIN_USER ="SELECT name,id,role,email FROM user WHERE email=? AND password=?";
    public static final String GET_ALL_USERS="SELECT * FROM user";
    public static final String ADD_USER="INSERT INTO `moviedb`.`user`(`name`,`surname`,`birthdate`,`role`,`email`,`password`,`telephone`) VALUES(?,?,?,?,?,?,?)";
    public static final String ADD_MOVIE="INSERT INTO `moviedb`.`movies`(`name`,`movie_type`,`technology`,`rating`,`theater_id`) VALUES(?,?,?,?,?)";
    public static final String GET_ALL_MOVIES="SELECT * FROM movies";
    public static final String DELETE_MOVIE="DELETE FROM `moviedb`.`movies` WHERE id=?";
    public static final String ADD_THEATER="INSERT INTO `moviedb`.`theater`(`name`,`seats_total`) VALUES(?,?)";
    public static final String GET_ALL_THEATERS="SELECT * FROM theater";
    public static final String GET_ALL_DETAILS="SELECT * FROM user WHERE id = ?";
    public static final String ADD_BOOKINGS="INSERT INTO `moviedb`.`booking`(`user_id`,`movie_id`,`seat_amount`,`date`) VALUES(?,?,?,?)";
    public static final String DELETE_TICKET="DELETE FROM `moviedb`.`booking` WHERE id=?";
    public static final String GET_TICKET_DETAILS="SELECT * FROM booking WHERE id = ?";
    public static final String GET_ALL_BOOKINGS="SELECT * FROM booking";
    public static final String ADD_TIMETABLE="INSERT INTO `moviedb`.`timetable`(`date`,`movie_id`,`startTime`,`endTime`) VALUES(?,?,?,?)";
    public static final String GET_ALL_TIMETABLESBYID="SELECT * FROM timetable WHERE movie_id=?";

}
