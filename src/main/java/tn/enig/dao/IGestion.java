package tn.enig.dao;

import java.util.List;

import tn.enig.model.Affectation;
import tn.enig.model.Enseignant;
import tn.enig.model.Matiere;

public interface IGestion {
	
	public List<Matiere> getAllMatiere();
	public void addMatiere(Matiere m);
	
	public List<Enseignant> getAllEnseignant();
	public void addEnseignant(Enseignant e);
	
	public List<Affectation> getAllAffectation();
	public void addAffectation(Affectation a);
	
	public Matiere getMatierebyID(int id);
	public Enseignant getEnseignantbyID(int id);

}
