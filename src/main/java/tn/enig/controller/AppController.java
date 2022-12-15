package tn.enig.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import tn.enig.dao.IGestion;
import tn.enig.model.Affectation;
import tn.enig.model.Enseignant;
import tn.enig.model.Matiere;

@Controller
public class AppController {
	
	@Autowired
	private IGestion dao;

	private void setDao(IGestion dao) {
		this.dao = dao;
	}
	
	@GetMapping("/matiere")
	public String getAllMatiere(Model m) {
		List<Matiere> liste= dao.getAllMatiere();
		m.addAttribute("liste",liste);
		return "matiere";
	}
	
	@GetMapping("/ajouterMatiere")
	public String addMatiere(Model model) {
		Matiere mat = new Matiere() ;
		List<Affectation> listA = dao.getAllAffectation();
		model.addAttribute("matiere", mat);
		model.addAttribute("affectation", listA);
		return "addMatiere";
	}
	
	@GetMapping("/enseignant")
	public String getAllEnseignant(Model m) {
		List<Enseignant> liste= dao.getAllEnseignant();
		m.addAttribute("liste",liste);
		return "enseignant";
	}
	
	@GetMapping("/ajouterEnseignant")
	public String addEnseignant(Model model) {
		Enseignant ens = new Enseignant() ;
		List<Affectation> listA = dao.getAllAffectation();
		model.addAttribute("enseignant", ens);
		model.addAttribute("Affectation", listA);
		return "addEnseignant";
	}
	
	@GetMapping("/affectation")
	public String getAllAffectation(Model m) {
		List<Affectation> liste= dao.getAllAffectation();
		m.addAttribute("liste",liste);
		return "affectation";
	}
	
	@GetMapping("/ajouterAffectation")
	public String addAffectation(Model model) {
		Affectation aff = new Affectation() ;
		List<Matiere> listM = dao.getAllMatiere();
		List<Enseignant> listE = dao.getAllEnseignant();
		model.addAttribute("Affectation", aff);
		model.addAttribute("Matiere", listM);
		model.addAttribute("Enseignant", listE);
		return "addAffectation";
	}

}
