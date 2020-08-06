package ar.com.ada.api.hotelada.entities.exception;

import ar.com.ada.api.hotelada.entities.*;
import ar.com.ada.api.hotelada.entities.reportes.Huesped;

public class HuespedEdadException extends HuespedInfoException{

    public HuespedEdadException(Huesped huesped, String mensaje) {
        super(huesped, mensaje);
    }
    
}