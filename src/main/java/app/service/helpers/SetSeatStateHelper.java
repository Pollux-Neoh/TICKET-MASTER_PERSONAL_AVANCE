package app.service.helpers;

import app.domain.enums.SeatStateEnum;
import app.service.validators.DataTypeValidator;

public class SetSeatStateHelper {

    public static String getSeatState() {

        int option = DataTypeValidator.validateInt(
                "Seleccione : 1. Disponible 2. No disponible 3. Reservado 4. Ocupado"
        );

        String state = "";
        switch (option) {
            case 1: state = SeatStateEnum.IS_AVAILABLE.toString();
            break;
            case 2: state = SeatStateEnum.IS_NOT_AVAILABLE.toString();
            break;
            case 3: state = SeatStateEnum.IS_RESERVED.toString();
            break;
            case 4: state = SeatStateEnum.IS_OCUPED.toString();
            break;
            default:
                System.out.println("Ingresaste informacion no valida");
        }
        return state;
    }



}
