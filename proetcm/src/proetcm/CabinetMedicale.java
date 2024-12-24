package proetcm;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;





import java.util.Map.Entry;


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
          System.out.println("Patient " + patient.getNom() + patient.getPrenom()+ " ajouté avec succès !");
          return true;
    }
    
    
    public static Patient rechercherPatient(String idPatient) {
        for (Patient p : patients) {
            if (p.idPatient.equals(idPatient)) {
                return p;
            }
        }
        return null;
  }
    public static doctor rechercherdoctor(String iddoctor) {
        for (doctor p : doctors) {
            if (p.Identifiant.equals(iddoctor)) {
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
                System.out.println( patient.getNom() + patient.getPrenom());
            }
        }
    }
    
    
    //gestion médcin 
    
    public static void ajouterMedecin(doctor medecin) {
        // Ensure the doctors list is initialized
        if (CabinetMedicale.doctors == null) {
            CabinetMedicale.doctors = new ArrayList<>();
        }

        // Iterate through the doctors list from CabinetMedicale
        for (doctor d : CabinetMedicale.doctors) {
            // Check if a doctor with the same Identifiant already exists
            if (d.getIdentifiant().equals(medecin.getIdentifiant())) {
                System.out.println("Un médecin avec cet identifiant existe déjà : " + medecin.getIdentifiant());
                return;
            }
        }

        // Add the new doctor to the list
        CabinetMedicale.doctors.add(medecin);
        // Printing details of the added doctor
        System.out.println("Médecin ajouté avec succès : "  + " " + medecin.getNom() + " " + medecin.getPrenom());
        
        // Print the schedule in a readable format
        if (medecin.getSchedule().isEmpty()) {
            System.out.println("Pas de planning disponible.");
        } else {
            System.out.println("Planning du médecin :");
            for (Entry<String, hourschedule> entry : medecin.getSchedule().entrySet()) {
                System.out.println("Jour : " + entry.getKey() + " | Heures : " + entry.getValue());
            }
        }
    }
    
 // Afficher les médecins
    public static void afficherMedecins() {
        if (CabinetMedicale.doctors == null || CabinetMedicale.doctors.isEmpty()) {
            System.out.println("Aucun médecin enregistré.");
            return;
        }
        System.out.println("Liste des médecins :");
        for (doctor medecin : CabinetMedicale.doctors) {
            System.out.println(medecin);  // This will call the toString() method of doctor class
        }
    }
    
    
    // Gestion de la secrétaire
    public static void ajouterSecretaire(secretaire secretaire) {
        if (CabinetMedicale.secretaires == null) {
            CabinetMedicale.secretaires = new ArrayList<>();
        }

        for (secretaire s : secretaires) {
            if (s.getIdentifiant().equals(secretaire.getIdentifiant())) {
                System.out.println("Une secrétaire avec cet identifiant existe déjà : " + secretaire.getIdentifiant());
                return;
            }
        }

        secretaires.add(secretaire);
        System.out.println("Secrétaire ajoutée avec succès :"  + secretaire.getNom() + " " +  secretaire.getPrenom());
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
    
  
