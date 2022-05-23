package service;


import model.Booking;
import repository.BookingRepository;

import java.util.List;

public class BookingServiceImpl implements BookingService {

    BookingRepository bookingRepository = new BookingRepository();

    @Override
    public List<Booking> getAllBookings() {
               return bookingRepository.getAllBookings();
    }

    @Override
    public void addBookings(Booking booking) {
        bookingRepository.addBookings(booking);
    }


    public void deleteTicket(Integer id){
        bookingRepository.deleteTicket(id);
    }

    public Booking getTicketById(Integer id){
        return bookingRepository.getTicketById(id);
    }

}
