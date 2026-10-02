package app.domain.enums;

public enum SeatStateEnum {

    IS_AVAILABLE("Disponible"),
    IS_NOT_AVAILABLE("No dispoble"),
    IS_RESERVED("Disponible"),
    IS_OCUPED("Ocupado");

    private final String state;
    SeatStateEnum(String state) {
        this.state = state;
    }

    public String getState() {
        return state;
    }


}
