package proetcm;

import java.util.List;
import java.util.Scanner;




public class CabinetMedicale {
    static List <Patient> patients;
    static List<doctor> doctors;
    static secretaire secretaire;
    
    
    Scanner scanner = new Scanner(System.in);
	//gestion des patients

    public static boolean ajouterPatient(Patient patient) {
        // Vérifie si l'ID du patient est unique
        for (Patient p : patients) {
            if (p.getIdPatient().equals(patient.getIdPatient())) {
                System.out.println("Erreur : Un patient avec l'ID " + patient.getIdPatient() + " existe déjà.");
                return false;
            }
        }
        // Ajoute le patient s'il est unique
        patients.add(patient);
        System.out.println("Patient " + patient.getNom() + " ajouté avec succès !");
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
    
    public void ajouterMedecin(doctor medecin) {
        doctors.add(medecin);
        System.out.println("Médecin ajouté avec succès.");
    }
    
 // Afficher les médecins
    public void afficherMedecins() {
        if (doctors.isEmpty()) {
            System.out.println("Aucun médecin enregistré.");
            return;
        }
        System.out.println("Liste des médecins :");
        for (doctor medecin : doctors) {
            System.out.println(medecin);
        }
    }
}
    
  
