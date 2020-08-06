package ar.com.ada.api.hotelada.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ar.com.ada.api.hotelada.entities.reportes.Huesped;
import ar.com.ada.api.hotelada.models.response.GenericResponse;
import ar.com.ada.api.hotelada.services.HuespedService;

@RestController
public class HuespedController{

    /**
     * GET: Se tiene que traer una lista de huespedes.
     */
    @Autowired
    HuespedService huespedService;

    @GetMapping("/huespedes")
    public List<Huesped> getHuespedes(@RequestParam(value = "nombre", required = false) String nombre) {
        List<Huesped> lh;

        if (nombre == null) {
            lh = huespedService.buscarTodosOrdenadoPorNombre();
        } else {
            lh = huespedService.buscarTodosPorNombre(nombre);
        }

        return lh;
    }

    /**
     * Versión que devuelve diferentes tipos de status según se requiera, se hace
     * usando la clase ResponseEntity. En este caso devuelve un "Ok(Huesped)" o un
     * ResponseEntity notfound (404) El responseEntity se le debe pasar en el
     * operador diamante el tipo de objeto a devolver.
     * 
     * @param id
     * @return
     */

    @GetMapping("/huespedes/{id}")
    public ResponseEntity<Huesped> getHuespedById(@PathVariable int id) {
        Huesped h = huespedService.buscarPorId(id);

        if (h == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(h);
    }

    @PostMapping("/huespedes")
    public ResponseEntity<?> postHuesped(@RequestBody Huesped req) {

        GenericResponse r = new GenericResponse();

        boolean resultado = huespedService.crearHuesped(req);

        if (resultado) {
            r.isOk = true;
            r.id = req.getHuespedId();
            r.message = "Creaste una huesped con éxito.";
            return ResponseEntity.ok(r);
        } else {

            r.isOk = false;
            r.message = "¡No se pudo crear el huesped! Ya existe alguien con ese DNI.";

            return ResponseEntity.badRequest().body(r);
        }

    }

    @PutMapping("/huespedes/{id}")
    public ResponseEntity<?> putHuesped(@PathVariable int id, @RequestBody Huesped req) {

        GenericResponse r = new GenericResponse();

        Huesped huespedOriginal = huespedService.buscarPorId(id);

        if (huespedOriginal == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        boolean resultado = false;
        resultado = huespedService.actualizarHuesped(huespedOriginal, req);

        if (resultado) {
            r.isOk = true;
            r.id = req.getHuespedId();
            r.message = "Huesped actualizado con éxito.";
            return ResponseEntity.ok(r);
        } else {

            r.isOk = false;
            r.message = "No se pudo actualizar el huesped.";

            return ResponseEntity.badRequest().body(r);
        }

    }


    
}