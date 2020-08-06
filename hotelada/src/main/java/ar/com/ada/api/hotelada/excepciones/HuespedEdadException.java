package ar.com.ada.api.hotelada.excepciones;

import ar.com.ada.api.hotelada.entities.*;

public class HuespedEdadException extends HuespedInfoException{

    public HuespedEdadException(Huesped huesped, String mensaje) {
        super(huesped, mensaje);
    }
    
}