package proetcm;
import java.util.Scanner;

public class PatientManagement {

    private Scanner scanner;

    // Constructor to initialize the scanner
    public PatientManagement() {
        this.scanner = new Scanner(System.in);
    }

    // Write an ordonnance
    public void writeOrdonnance(Patient patient) {
        System.out.print("Enter ordonnance for " + patient.getNom() + ": ");
        String ordonnance = scanner.nextLine();

        if (ordonnance == null || ordonnance.trim().isEmpty()) {
            System.out.println("Invalid ordonnance. Please provide a valid ordonnance.");
            return;
        }
        patient.setOrdonnance(ordonnance);
        System.out.println("Ordonnance added successfully for " + patient.getNom());
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