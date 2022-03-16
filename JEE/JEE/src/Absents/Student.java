package Absents;

public class Student {
	String nom,prenom,email,niveau,filiere;
	public Student(String email,String nom,String prenom,String niveau,String filiere) {
		 this.email=email;
		 this.nom=nom;
		 this.prenom=prenom;
		 this.niveau=niveau;
		 this.filiere=filiere;
		
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getNiveau() {
		return niveau;
	}
	public void setNiveau(String niveau) {
		this.niveau = niveau;
	}
	public String getFiliere() {
		return filiere;
	}
	public void setFiliere(String filiere) {
		this.filiere = filiere;
	}

}
