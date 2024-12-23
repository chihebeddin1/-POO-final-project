
	package proetcm;
	import java.util.ArrayList;
public class Patient extends user {
	
    private ordonnance ordonnance;
    private String observation;
    private String certificate;
    String idPatient;
    private ArrayList<String> consultationhistory;    //l'historique de chaque patient
    private String groupeSanguin;
    private ArrayList<String> allergies; // Liste des allergies du patient
    private int nombreOperations; // Nombre d'opérations effectuées
    
    // Constructor to initialize the patient's basic information
    public Patient(String nom, String prenom, int numdetelephone, String adress, String role, String idPatient,String groupeSanguin, ArrayList<String> allergies, int nombreOperations) {
		super(nom, prenom, numdetelephone, adress, "Patient");
		this.idPatient = idPatient;
		this.consultationhistory =  new ArrayList<>();
		this.groupeSanguin = groupeSanguin;
		this.allergies = allergies;
		this.nombreOperations = nombreOperations;
	}
   
    public void setOrdonnance(ordonnance ordonnance) {
        this.ordonnance = ordonnance;
    }

    public ordonnance getOrdonnance() {
        return ordonnance;
    }




	public String getObservation() {
		return observation;
	}




	public void setObservation(String observation) {
		this.observation = observation;
	}




	public String getCertificate() {
		return certificate;
	}




	public void setCertificate(String certificate) {
		this.certificate = certificate;
	}




	public String getIdPatient() {
		return idPatient;
	}




	public void setIdPatient(String idPatient) {
		this.idPatient = idPatient;
	}




	public ArrayList<String> getConsultationhistory() {
		return consultationhistory;
	}




	public void setConsultationhistory(ArrayList<String> consultationhistory) {
		this.consultationhistory = consultationhistory;
	}




	public String getGroupeSanguin() {
		return groupeSanguin;
	}




	public void setGroupeSanguin(String groupeSanguin) {
		this.groupeSanguin = groupeSanguin;
	}




	public ArrayList<String> getAllergies() {
		return allergies;
	}




	public void setAllergies(ArrayList<String> allergies) {
		this.allergies = allergies;
	}




	public int getNombreOperations() {
		return nombreOperations;
	}




	public void setNombreOperations(int nombreOperations) {
		this.nombreOperations = nombreOperations;
	}


	public void ajouterAllergie(String allergie) {
        this.allergies.add(allergie);
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

	@Override
	public String toString() {
		return "Patient [ordonnance=" + ordonnance + ", observation=" + observation + ", certificate=" + certificate
				+ ", idPatient=" + idPatient + ", consultationhistory=" + consultationhistory + ", groupeSanguin="
				+ groupeSanguin + ", allergies=" + allergies + ", nombreOperations=" + nombreOperations + "]";
	}
    
	}
