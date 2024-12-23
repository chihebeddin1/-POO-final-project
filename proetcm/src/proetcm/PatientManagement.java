package proetcm;
import java.util.Scanner;

public class PatientManagement {

    private Scanner scanner;

    // Constructor to initialize the scanner
    public PatientManagement() {
        this.scanner = new Scanner(System.in);
    }

    // Write an ordonnance
 // Write an ordonnance
    public void writeOrdonnance(Patient patient) {
 
            System.out.println("Veuillez saisir l'ordonnance pour " + patient.getNom() + ":");
            System.out.print("Nom du médicament: ");
            
            String nommedicament = scanner.nextLine();

            System.out.print("Doses : ");
            String lesdoses = scanner.nextLine();

            System.out.print("Durée : ");
            String duree = scanner.nextLine();

            ordonnance ordonnance = new ordonnance(nommedicament, lesdoses, duree);
           
         // Check if any of the fields in ordonnance are invalid (null or empty)
            if (nommedicament == null || nommedicament.trim().isEmpty() ||
                lesdoses == null || lesdoses.trim().isEmpty() ||
                duree == null || duree.trim().isEmpty()) {
                
                System.out.println("Invalid ordonnance. Please provide valid details for all fields.");
                return;
            }

            // Set the ordonnance for the patient
            patient.setOrdonnance(ordonnance);

            // Print confirmation
            System.out.println("Ordonnance ajoutée avec succès pour " + patient.getNom());
        }

    // Add an observation
    public void addObservation(Patient patient) {
        System.out.print("Enter observation for " + patient.getNom() + ": ");
        String observation = scanner.nextLine();

        if (observation == null || observation.trim().isEmpty()) {
            System.out.println("Invalid observation. Please provide a valid observation.");
            return;
        }
        patient.setObservation(observation);
        System.out.println("Observation added successfully for " + patient.getNom());
    }

    // Add a certificate
    public void addCertificate(Patient patient) {
        System.out.print("Enter certificate for " + patient.getNom() + ": ");
        String certificate = scanner.nextLine();

        if (certificate == null || certificate.trim().isEmpty()) {
            System.out.println("Invalid certificate. Please provide a valid certificate.");
            return;
        }
        patient.setCertificate(certificate);
        System.out.println("Certificate added successfully for " + patient.getNom());
    }

    // Close the scanner when done (if you're done with input)
    public void closeScanner() {
        if (scanner != null) {
            scanner.close();
        }
    }
}