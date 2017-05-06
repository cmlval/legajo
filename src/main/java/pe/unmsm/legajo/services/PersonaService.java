package pe.unmsm.legajo.services;

import java.util.List;

import pe.unmsm.legajo.domain.Persona;

public interface PersonaService {

	List<Persona> listAllPersonas();
	void saveOrUpdate(Persona persona);
}
