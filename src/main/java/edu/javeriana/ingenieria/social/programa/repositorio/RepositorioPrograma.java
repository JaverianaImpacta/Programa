package edu.javeriana.ingenieria.social.programa.repositorio;

import edu.javeriana.ingenieria.social.programa.dominio.Programa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RepositorioPrograma extends JpaRepository<Programa, Integer> {
    List<Programa> findAllByFacultad(Integer facultad);

    Programa findOneByCodigo(Integer codigo);

    boolean existsByCodigo(Integer codigo);
}
