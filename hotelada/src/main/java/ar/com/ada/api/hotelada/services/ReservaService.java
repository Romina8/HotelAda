package ar.com.ada.api.hotelada.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.com.ada.api.hotelada.entities.Reserva;
import ar.com.ada.api.hotelada.repos.ReservaRepository;

@Service
public class  ReservaService{

    @Autowired
    ReservaRepository reservaRepo;

    public boolean crearReserva(Reserva reserva){
        grabar(reserva);
        return true;
    }

    public void grabar(Reserva reserva) {

        reservaRepo.save(reserva);
    }

    public Reserva buscarPorId(int reservaId) {

        Optional<Reserva> b = reservaRepo.findById(reservaId);

        if (b.isPresent())
            return b.get();

        return null;
    }

    public boolean baja(int reservaId) {

        Reserva reserva = buscarPorId(reservaId);

        if (reserva == null)
            return false;

        return baja(reserva);
    }

    public boolean baja(Reserva reserva) {

        reservaRepo.delete(reserva);
        return true;
    }

    public List<Reserva> getReservas() {

        return reservaRepo.findAll();
    }

    public List<Reserva> buscarReservasPorNombre(String nombre) {

        return reservaRepo.findByNombreHuesped(nombre);
    }

    public boolean actualizarReserva(Reserva reservaOriginal, Reserva reservaConInfoNueva) {

        reservaOriginal.setFechaReserva(reservaConInfoNueva.getFechaReserva());
        reservaOriginal.setFechaIngreso(reservaConInfoNueva.getFechaIngreso());
        reservaOriginal.setFechaEgreso(reservaConInfoNueva.getFechaEgreso());
        reservaOriginal.setHabitacion(reservaConInfoNueva.getHabitacion());
        reservaOriginal.setImportReserva(reservaConInfoNueva.getImportReserva());
        reservaOriginal.setImportePagado(reservaConInfoNueva.getImportePagado());
        reservaOriginal.setImportTotal(reservaConInfoNueva.getImportTotal());
        reservaOriginal.setEstadoPago(reservaConInfoNueva.getEstadoPago());

        grabar(reservaOriginal);

        return true;
    }
    
}