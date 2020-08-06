package ar.com.ada.api.hotelada.entities.exception;

import ar.com.ada.api.hotelada.entities.reportes.Huesped;

public class HuespedInfoException extends Exception {

    private Huesped huesped;
    
    public HuespedInfoException(Huesped huesped, String mensaje) {

        super(huesped.getNombre() + ":" + mensaje);
        this.huesped = huesped;
    }

    
}