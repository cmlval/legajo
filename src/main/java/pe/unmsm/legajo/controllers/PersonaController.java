package pe.unmsm.legajo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import pe.unmsm.legajo.services.PersonaService;

@Controller
public class PersonaController {
	
	private PersonaService personaService;
	
	@Autowired
	public void setPersonaService(PersonaService personaService) {
		this.personaService = personaService;
	}

	@RequestMapping("/personas")
	public String listPersonas(Model model) {
		model.addAttribute("personas", personaService.listAllPersonas());
		return "personas";
	}
}
