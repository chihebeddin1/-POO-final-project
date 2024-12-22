package proetcm;

import java.util.List;
import java.util.Scanner;



public class CabinetMedicale {
	//gestion des patients
    private List <Patient> patients;
    private List<doctor> doctors;



    Scanner scanner = new Scanner(System.in);
    public  boolean ajouterPatient(Patient patient) {
        // Vérifie si l'ID du patient est unique
        for (Patient p : patients) {
            if (p.getIdPatient().equals(patient.getIdPatient())) {
                System.out.println("Erreur : Un patient avec l'ID " + patient.getIdPatient() + " existe déjà.");
                return false;
            }
        }
        // Ajoute le patient s'il est unique
        String nom = scanner.nextLine();
        String prenom = scanner.nextLine();
        int numdetelephone = scanner.nextInt();
        String adress = scanner.nextLine();
        String IdPatient = scanner.nextLine();
        Patient newPatient = new Patient(nom, prenom, numdetelephone, adress, IdPatient);
        patients.add(newPatient);
        System.out.println("Patient " + patient.getNom() + patient.getPrenom()+ patient.getAdress() + patient.getNumdetelephone()+ patient.getIdPatient()+ " ajouté avec succès !");
        return true;
    }
	 
    
    public Patient rechercherPatient(String idPatient) {
        for (Patient p : patients) {
            if (p.idPatient.equals(idPatient)) {
                return p;
            }
        }
        return null;
  }
    
    
    public void afficherPatients() {
        if (patients.isEmpty()) {
            System.out.println("Aucun patient enregistré.");
        } else {
            System.out.println("Liste des patients :");
            for (Patient patient : patients) {
                System.out.println(patient.getNom() + " " + patient.getPrenom());
            }
        }
    }
    
    //gestion médcin 
    
    public void ajouterMedecin(doctor doctor) {
    	
    	doctors.add(doctor);
        System.out.println("Médecin ajouté: " + doctor);
    }
}
    
  
