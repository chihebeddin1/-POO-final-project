package proetcm;

import java.util.ArrayList;
import java.util.Scanner;

public class Main1 {

	public static void main(String[] args) {
		CabinetMedicale.patients = new ArrayList<>();
        CabinetMedicale.doctors = new ArrayList<>();
        CabinetMedicale.secretaires = new ArrayList<>();

    	
      	 // Ajout de médecins
        doctor medecin1 = new doctor("Jean", "Martin", 987654321, "20 rue de la Santé", "Cardiologue", false ,"Dr.Martin","Santé55");
        doctor medecin2 = new doctor("Sophie", "Lemoine", 123789456, "15 rue des Lilas", "Dermatologue", true, "Dr.Lemoine","Santé66");
        doctor medecin3 = new doctor("hamid", "soup", 123784856, "10 rue des Lilas", "Ophetalmologue", true, "Dr.soup","Santé77");
        doctor medecin4 = new doctor("sarah", "ougour", 123879456, "8 rue des Lilas", "Dentiste", true, "Dr.ougour","Santé22");
        doctor medecin5 = new doctor("meriem", "ougnoune", 132789456, "2 rue des Lilas", "Endocrinologie", false, "Dr.ougnoune","Santé33");

        CabinetMedicale.ajouterMedecin(medecin1);
        CabinetMedicale.ajouterMedecin(medecin2);
        CabinetMedicale.ajouterMedecin(medecin3);
        CabinetMedicale.ajouterMedecin(medecin4);
        CabinetMedicale.ajouterMedecin(medecin5);


        // Ajout de patients
        Patient patient1 = new Patient("Alice", "Dubois", 112233445, "Cheraga",   "P001");
        Patient patient2 = new Patient("Marc", "Durand",  667788990, "Douera", "P002");
        Patient patient3 = new Patient("Ahmed", "trun", 112132456, "BabaHassen",   "P003");
        Patient patient4 = new Patient("Qwidar", "Fadali", 122333447, "Bebzouar",   "P004");
        Patient patient5 = new Patient("Anis", "Diara", 819235045, "Draria",   "P005");

        CabinetMedicale.ajouterPatient(patient1);
        CabinetMedicale.ajouterPatient(patient2);
        CabinetMedicale.ajouterPatient(patient3);
        CabinetMedicale.ajouterPatient(patient4);
        CabinetMedicale.ajouterPatient(patient5);


     // Ajout d'une secrétaire
        secretaire secretaire1 = new secretaire("salah", "meroua", 123456789, "10 rue de la Paix", "meroua","Santé1");
        secretaire secretaire3 = new secretaire("sherine", "malah", 132456789, "5 rue de la Paix", "malah","Santé2");
        secretaire secretaire4 = new secretaire("imen", "tila", 123456789, "4 rue de la Paix", "tila","Santé3");
        secretaire secretaire5 = new secretaire("omar", "karit", 143256879, "2 rue de la Paix", "karit","Santé4");

        CabinetMedicale.ajouterSecretaire(secretaire1);
        CabinetMedicale.ajouterSecretaire(secretaire3);
        CabinetMedicale.ajouterSecretaire(secretaire4);
        CabinetMedicale.ajouterSecretaire(secretaire5);

        // Tentative d'ajout d'une autre secrétaire
        secretaire secretaire2 = new secretaire("Anne", "Martin", 987645321, "15 avenue des Roses","Martin","Santé5");
        CabinetMedicale.ajouterSecretaire(secretaire2);

        // Affichage des informations de la secrétaire
        CabinetMedicale.afficherSecretaire();
        
        

        // Affichage des données
        System.out.println("\n--- Secrétaire ---");
        CabinetMedicale.afficherSecretaire();
        System.out.println("\n--- Patients ---");
        CabinetMedicale.afficherPatients();
        System.out.println("\n--- Médecins ---");
        CabinetMedicale.afficherMedecins();
        
        // Test adding a schedule
        System.out.println("---- Test Adding Schedule ----");
        System.out.println("We will now attempt to add a schedule for a specific day.");
        medecin1.addSchedule();  // Try adding a schedule for a day
        System.out.println("Next, we will try adding the same schedule again. It should notify us that the schedule already exists.");
        medecin1.addSchedule();  // Try adding the same schedule again (it should notify the user)

        // Test updating a schedule
        System.out.println("\n---- Test Updating Schedule ----");
        System.out.println("Now, we will attempt to update the existing schedule.");
        medecin1.updateSchedule();  // Try updating an existing schedule
        System.out.println("Next, we will try updating a schedule for a day that doesn't exist yet, it should prompt us to add it first.");
        medecin1.updateSchedule();  // Try updating a non-existing schedule (should prompt user to add first)

        // Test printing the schedule after updates
        System.out.println("\n---- Printing the Doctor's Schedule ----");
        System.out.println("Finally, we will print the doctor's schedule after the operations to see the changes.");
        medecin1.printSchedule();  // Print the doctor's schedule after the operations
        
        
     // Vérification de l'utilisateur
        Scanner scanner = new Scanner(System.in);
        System.out.println("Veuillez entrer votre Identifiant :");
        String Identifiant = scanner.nextLine();
        System.out.println("Veuillez entrer votre Mot De Passe :");
        String MotDePasse = scanner.nextLine();

        if (CabinetMedicale.verifierUtilisateur(Identifiant, MotDePasse)) {
            System.out.println("Authentification réussie. Bienvenue dans l'application !");
            // Le reste du code (gestion des médecins, patients, etc.)
        } else {
            System.out.println("Erreur : Identifiant ou mot de passe incorrect. Vous n'êtes pas autorisé à accéder à cette application.");
        }

        scanner.close();
        //save

	}

}
