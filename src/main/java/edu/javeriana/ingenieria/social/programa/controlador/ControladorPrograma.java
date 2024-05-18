package edu.javeriana.ingenieria.social.programa.controlador;

import edu.javeriana.ingenieria.social.programa.dominio.Programa;
import edu.javeriana.ingenieria.social.programa.servicio.ServicioPrograma;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/programas")
@CrossOrigin(origins="http://localhost:4200")
public class ControladorPrograma {
    @Autowired
    private ServicioPrograma servicio;

    @GetMapping("listar")
    public List<Programa> obtenerProgramas() {
        return servicio.obtenerProgramas();
    }

    @GetMapping("obtener")
    public ResponseEntity<Programa> obtenerPrograma(@RequestParam Integer codigo){
        if(codigo==null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        if(!servicio.programaExiste(codigo)){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(servicio.obtenerPrograma(codigo), HttpStatus.OK);
    }

    @GetMapping("obtenerFacultad")
    public ResponseEntity<List<Programa>> obtenerProgramas(@RequestParam Integer facultad){
        if(facultad==null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        if(servicio.obtenerProgramas(facultad).isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(servicio.obtenerProgramas(facultad), HttpStatus.OK);
    }
}
