package edu.javeriana.ingenieria.social.programa.servicio;

import edu.javeriana.ingenieria.social.programa.dominio.Programa;
import edu.javeriana.ingenieria.social.programa.repositorio.RepositorioPrograma;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServicioPrograma {
    @Autowired
    private RepositorioPrograma repositorio;

    public List<Programa> obtenerProgramas() {
        return repositorio.findAll();
    }

    public List<Programa> obtenerProgramas(Integer facultad){
        return repositorio.findAllByFacultad(facultad);
    }

    public Programa obtenerPrograma(Integer codigo){
        return repositorio.findOneByCodigo(codigo);
    }

    public boolean programaExiste(Integer codigo){
        return repositorio.existsByCodigo(codigo);
    }

}
