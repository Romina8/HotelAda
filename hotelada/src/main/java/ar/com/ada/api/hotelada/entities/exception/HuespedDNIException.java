package ar.com.ada.api.hotelada.entities.exception;

import ar.com.ada.api.hotelada.entities.*;

public class HuespedDNIException extends HuespedInfoException{

    public HuespedDNIException(Huesped huesped, String mensaje) {
        super(huesped, mensaje);
    }
    
}