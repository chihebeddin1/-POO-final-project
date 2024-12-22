
	package proetcm;
	import java.util.ArrayList;
public class Patient extends user {
	
    private String ordonnance;
    private String observation;
    private String certificate;
    String idPatient;
    private ArrayList<String> consultationhistory;    //l'historique de chaque patient
    
    
    // Constructor to initialize the patient's basic information
    public Patient(String nom, String prenom, int numdetelephone, String adress, String idPatient) {
        super(nom, prenom, numdetelephone, adress, "Patient"); // Set role as "Patient"
        this.idPatient = idPatient;
        this.consultationhistory = new ArrayList<>();
    }

    // Setters
    public void setOrdonnance(String ordonnance) {
        this.ordonnance = ordonnance;
    }

    public void setObservation(String observation) {
        this.observation = observation;
    }

    public void setCertificate(String certificate) {
        this.certificate = certificate;
    }

    // Getters
    public String getOrdonnance() {
        return ordonnance;
    }

    public String getObservation() {
        return observation;
    }

    public String getCertificate() {
        return certificate;
    }
 
    public String getIdPatient() {
        return idPatient;
    }
    
   
    public void afficherConsultations() {
        System.out.println("Historique des consultations pour le patient " + nom + " :");
        if (consultationhistory.isEmpty()) {
            System.out.println("Aucune consultation enregistrée.");
        } else {
            for (int i = 0; i < consultationhistory.size(); i++) {
                System.out.println((i + 1) + ". " + consultationhistory.get(i));
            }
        }
    }
    
 // toString method for displaying the patient's info
    @Override
    public String toString() {
        return "Patient [ID=" + idPatient + ", Nom=" + nom + ", Prénom=" + prenom + ", Téléphone=" + numdetelephone + ", Adresse=" + adress + "]";
    }
    
	}
