package za.ac.cput.service;
/*
Name: Yasmeen Nel
Student Number: 219250553
BookingsService.java
Date : October '22
 */

import za.ac.cput.domain.Bookings;
import za.ac.cput.repository.BookingsRepository;
import java.util.List;
import java.util.Optional;

public class BookingsService implements IBookingsService{

        private final BookingsRepository repository;
        private static IBookingsService service;


        private BookingsService(){
            this.repository = BookingsRepository.getRepository();
        }

        public static IBookingsService getService() {
            if (service == null)
                service = new BookingsService();
            return service;

        }

        public Bookings save(Bookings bookings) {
            return this.repository.save(bookings);
        }


        public Optional<Bookings> read(String s) {
            return this.repository.read(s);
        }

        public void delete(Bookings bookings) {
            this.repository.delete(bookings);
        }


        public List<Bookings> getAll() {
            return this.repository.getAll();
        }
}
