package ar.com.ada.api.hotelada.excepciones;

import ar.com.ada.api.hotelada.entities.*;

public class HuespedDNIException extends HuespedInfoException{

    public HuespedDNIException(Huesped huesped, String mensaje) {
        super(huesped, mensaje);
    }
    
}