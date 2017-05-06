package pe.unmsm.legajo.bootstrap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import pe.unmsm.legajo.domain.Persona;
import pe.unmsm.legajo.services.PersonaService;

@Component
public class LegajoDataBootstrap implements ApplicationListener<ContextRefreshedEvent> {
	
	private PersonaService personaService;
	
	@Autowired
	public void setPersonaService(PersonaService personaService) {
		this.personaService = personaService;
	}

	@Override
	public void onApplicationEvent(ContextRefreshedEvent arg0) {
		// TODO Auto-generated method stub
		loadPersonas();
	}

	private void loadPersonas() {
		// TODO Auto-generated method stub
		Persona persona1 = new Persona();
		persona1.setApellidoMaterno("Vera");
		persona1.setApellidoPaterno("Luque");
		persona1.setNombres("Christian");
		
		personaService.saveOrUpdate(persona1);
		
		Persona persona2 = new Persona();
		persona2.setApellidoMaterno("Vera1");
		persona2.setApellidoPaterno("Luque1");
		persona2.setNombres("Christian1");
		
		personaService.saveOrUpdate(persona2);
	}

}
