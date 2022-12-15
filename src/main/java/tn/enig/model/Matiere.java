package tn.enig.model;

public class Matiere {
	
	private int id;
	private String titre;
	private String niveau;
	private int nbheure;
	
	public Matiere() {
		super();
		// TODO Auto-generated constructor stub
	}
	

	public Matiere(int id, String titre, String niveau, int nbheure) {
		super();
		this.id = id;
		this.titre = titre;
		this.niveau = niveau;
		this.nbheure = nbheure;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public String getNiveau() {
		return niveau;
	}

	public void setNiveau(String niveau) {
		this.niveau = niveau;
	}

	public int getNbheure() {
		return nbheure;
	}

	public void setNbheure(int nbheure) {
		this.nbheure = nbheure;
	}


	@Override
	public String toString() {
		return "Matiere [id=" + id + ", titre=" + titre + ", niveau=" + niveau + ", nbheure=" + nbheure + "]";
	}
	
	
	
	
	
	

}
