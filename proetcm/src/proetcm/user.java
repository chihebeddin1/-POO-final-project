package proetcm;

public abstract class user {
    static String nom;
    String prenom;
    int numdetelephone;
    String adress;
    String role;
    

    // Constructor
    public user(String nom, String prenom, int numdetelephone, String adress, String role) {
        this.nom = nom;
        this.prenom = prenom;  // Fix the typo here
        this.numdetelephone = numdetelephone;
        this.adress = adress;
        this.role = role;
    }

    // Getters and Setters
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

    public int getNumdetelephone() {
        return numdetelephone;
    }

    public void setNumdetelephone(int numdetelephone) {
        this.numdetelephone = numdetelephone;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;  // Correct the setter for role
    }

    // Method to display user information
    public void afficherInfos() {
        System.out.println("Nom: " + nom + ", Prénom: " + prenom + ", Téléphone: " + numdetelephone + 
                           ", Adresse: " + adress + ", Role: " + role);
    }
}
