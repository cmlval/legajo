package pe.unmsm.legajo.repositories;

import org.springframework.data.repository.CrudRepository;

import pe.unmsm.legajo.domain.Persona;

public interface PersonaRepository extends CrudRepository<Persona, Integer> {

}
