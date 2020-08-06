package ar.com.ada.api.hotelada.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ar.com.ada.api.hotelada.entities.reportes.Reserva;

@Repository
public interface ReservaRepository extends JpaRepository<Reserva, Integer>{
    
}