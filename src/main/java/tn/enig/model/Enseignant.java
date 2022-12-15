package tn.enig.model;

public class Enseignant {
	
	private int id;
	private String nom;
	private String prenom;
	private String charge;
	
	public Enseignant() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Enseignant(int id, String nom, String prenom, String charge) {
		super();
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.charge = charge;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getCharge() {
		return charge;
	}

	public void setCharge(String charge) {
		this.charge = charge;
	}

	@Override
	public String toString() {
		return "Enseignant [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", charge=" + charge + "]";
	}
	
	
	
	

}
