package proetcm;

public class Main {

    public static void main(String[] args) {
    	
      	 // Ajout de médecins
        doctor medecin1 = new doctor("Jean", "Martin", 987654321, "20 rue de la Santé", "Cardiologue", false);
        doctor medecin2 = new doctor("Sophie", "Lemoine", 123789456, "15 rue des Lilas", "Dermatologue", true);
        CabinetMedicale.ajouterMedecin(medecin1);
        CabinetMedicale.ajouterMedecin(medecin2);

        // Ajout de patients
        Patient patient1 = new Patient("Alice", "Dubois", 112233445, "5 avenue des Champs",   "P001");
        Patient patient2 = new Patient("Marc", "Durand",  667788990, "3 boulevard Haussmann", "P002");
        CabinetMedicale.ajouterPatient(patient1);
        CabinetMedicale.ajouterPatient(patient2);

     // Ajout d'une secrétaire
        secretaire secretaire1 = new secretaire("Marie", "Dupont", 123456789, "10 rue de la Paix");
        CabinetMedicale.ajouterSecretaire(secretaire1);

        // Tentative d'ajout d'une autre secrétaire
        secretaire secretaire2 = new secretaire("Anne", "Martin", 987654321, "15 avenue des Roses");
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
    }
}