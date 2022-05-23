package service;

import model.Booking;

import java.util.List;


public interface BookingService {

    void deleteTicket(Integer id);

    List<Booking> getAllBookings();

    void addBookings(Booking booking);

    Booking getTicketById(Integer id);



}
