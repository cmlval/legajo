package pe.unmsm.legajo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.unmsm.legajo.domain.Persona;
import pe.unmsm.legajo.repositories.PersonaRepository;

@Service
public class PersonaServiceImpl implements PersonaService {
	
	private PersonaRepository personaRepository;
	
	@Autowired
	public void setPersonaRepository(PersonaRepository personaRepository) {
		this.personaRepository = personaRepository;
	}

	@Override
	public List<Persona> listAllPersonas() {
		// TODO Auto-generated method stub
		return (List<Persona>) personaRepository.findAll();
	}

	@Override
	public void saveOrUpdate(Persona persona) {
		// TODO Auto-generated method stub
		personaRepository.save(persona);
	}

}
