package proetcm;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class CabinetMedicale {
    static List <Patient> patients;
    static List<doctor> doctors;
    static secretaire secretaire;
    static List<secretaire> secretaires;
    
    
    Scanner scanner = new Scanner(System.in);
	//gestion des patients

    public static boolean ajouterPatient(Patient patient) {
    	  if (patients == null) {
              patients = new ArrayList<>();
          }
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
    
    
    public static void afficherPatients() {
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
    
    public static void ajouterMedecin(doctor medecin) {
        if (doctors == null) {
            doctors = new ArrayList<>(); // Initialisation de la liste si elle est null
        }
        doctors.add(medecin);
        System.out.println("Médecin ajouté avec succès.");
    }
    
 // Afficher les médecins
    public static void afficherMedecins() {
        if (doctors.isEmpty()) {
            System.out.println("Aucun médecin enregistré.");
            return;
        }
        System.out.println("Liste des médecins :");
        for (doctor medecin : doctors) {
            System.out.println(medecin);
        }
    }
    
    
    // Gestion de la secrétaire
    public static void ajouterSecretaire(secretaire secretaire) {
        if (CabinetMedicale.secretaire == null) {
            CabinetMedicale.secretaire = secretaire;
            System.out.println("Secrétaire ajoutée avec succès : " + secretaire.getNom() + " " + secretaire.getPrenom());
        } else {
            System.out.println("Une secrétaire est déjà assignée. Impossible d'en ajouter une autre.");
        }
    }

    public static void afficherSecretaire() {
        if (secretaire == null) {
            System.out.println("Aucune secrétaire assignée.");
        } else {
            System.out.println("Secrétaire actuelle : " + secretaire.getNom() + " " + secretaire.getPrenom());
        }
    }
    
    
    public static boolean verifierUtilisateur(String Identifiant, String MotDePasse) {
        // Vérifier dans la liste des médecins
        for (doctor medecin : doctors) {
            if (medecin.getIdentifiant().equals(Identifiant) && medecin.getMotDePasse().equals(MotDePasse)) {
                return true; // Médecin authentifié
            }
        }

        // Vérifier dans la liste des secrétaires
        for (secretaire secretaire : secretaires) {
            if (secretaire.getIdentifiant().equals(Identifiant) && secretaire.getMotDePasse().equals(MotDePasse)) {
                return true; // Secrétaire authentifié
            }
        }

        return false; // Utilisateur non trouvé
    }
    
    
}
    
  
