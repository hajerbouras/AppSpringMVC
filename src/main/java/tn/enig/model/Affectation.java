package tn.enig.model;

public class Affectation {
	
	private int id;
	private Matiere matiere;
	private Enseignant enseignant;
	
	public Affectation() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Affectation(int id, Matiere matiere, Enseignant enseignant) {
		super();
		this.id = id;
		this.matiere = matiere;
		this.enseignant = enseignant;
	}
	
	public Affectation(int id, Matiere matiere) {
		super();
		this.id = id;
		this.matiere = matiere;
	}
	
	public Affectation(int id, Enseignant e) {
		super();
		this.id = id;
		this.enseignant = enseignant;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Matiere getMatiere() {
		return matiere;
	}

	public void setMatiere(Matiere matiere) {
		this.matiere = matiere;
	}

	public Enseignant getEnseignant() {
		return enseignant;
	}

	public void setEnseignant(Enseignant enseignant) {
		this.enseignant = enseignant;
	}

	@Override
	public String toString() {
		return "Affectation [id=" + id + ", matiere=" + matiere + ", enseignant=" + enseignant + "]";
	}

	
	
	
	
	

}
