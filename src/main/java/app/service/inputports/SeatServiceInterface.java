package app.service.inputports;

import app.domain.Seat;

import java.util.List;

public interface SeatServiceInterface {

        public Seat createSeat(Integer seatId, String seatNumber, String seatSector, String isAvailable);
        public Seat selectSeat(int seatId);

        Seat selectSeatById(int seatId);

        public List<Seat> selectAllSeats();
        public Seat updateSeat(Integer seatId, String seatNumber, String seatSector);
        public void deleteSeat(Integer seatId);
    }

