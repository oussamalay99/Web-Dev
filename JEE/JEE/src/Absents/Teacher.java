package Absents;

public class Teacher {
	String nom,prenom,email,matiere;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMatiere() {
		return matiere;
	}
	public void setMatiere(String matiere) {
		this.matiere = matiere;
	}
public Teacher(String email,String nom,String prenom,String matiere) {
	 this.email=email;
	 this.nom=nom;
	 this.prenom=prenom;
	 this.matiere=matiere;
	 
	 
 }
}
