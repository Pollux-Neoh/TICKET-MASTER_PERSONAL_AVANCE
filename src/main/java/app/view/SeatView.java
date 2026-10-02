package app.view;

import app.service.helpers.SetSeatStateHelper;
import app.service.inputports.SeatServiceInterface;
import app.service.validators.DataTypeValidator;

public class SeatView {

    private final SeatServiceInterface seatServiceinterface;

    public SeatView(SeatServiceInterface seatServiceinterface) {
        this.seatServiceinterface = seatServiceinterface;
    }




    public void createSeat(){

        int id = DataTypeValidator.validateInt("Ingrese el ID del seat");
        String seatNumber = DataTypeValidator.validateString("Ingrese el seat number");
        String seatSector = DataTypeValidator.validateString("Ingrese el sector");
        String seatState = SetSeatStateHelper.getSeatState();

        seatServiceinterface.createSeat(id, seatNumber, seatSector, seatState);
    }

    public void selectAllSeats(){

    }

    public void selectSeatById(int id){

    }

    public void updateSeat(){

    }

    public void deleteSeat(int id){

    }
}
