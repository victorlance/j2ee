package test;

public class Voiture {
	
	private String matricule ;
	private String marque ;
	private Personne proprietaire;
	public Voiture() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getMatricule() {
		return matricule;
	}
	public void setMatricule(String matricule) {
		this.matricule = matricule;
	}
	public String getMarque() {
		return marque;
	}
	public void setMarque(String marque) {
		this.marque = marque;
	}
	public Personne getProprietaire() {
		return proprietaire;
	}
	public void setProprietaire(Personne proprietaire) {
		this.proprietaire = proprietaire;
	}
	
	
	

}
