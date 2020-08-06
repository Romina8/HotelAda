package ar.com.ada.api.hotelada.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ar.com.ada.api.hotelada.entities.Reserva;

@Repository
public interface ReservaRepository extends JpaRepository<Reserva, Integer>{

    // En este caso se hace un JPQL por el nombre del huesped
    @Query(value = "SELECT * FROM reserva r inner join huesped h on h.huesped_id = r.huesped_id where nombre like CONCAT('%', :nombre,'%')", nativeQuery = true)
    List<Reserva> findByNombreHuesped(@Param("nombre") String nombre);
}