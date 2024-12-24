package proetcm;




public class RDV {


    private String date;
    private int heure;
    private Patient patient;
    private doctor medecin;
    


    // Constructor
    public RDV(String date, int heure, Patient patient, doctor medecin) {
        this.date = date;
        this.heure = heure;
        this.patient = patient;
        this.medecin = medecin;
        
    }


    // Getters and Setters
    public String getDate() {
        return date;
    }


    public void setDate(String date) {
        this.date = date;
    }


    public int getHeure() {
        return heure;
    }


    public void setHeure(int heure) {
        this.heure = heure;
    }


    public Patient getPatient() {
        return patient;
    }


    public void setPatient(Patient patient) {
        this.patient = patient;
    }


    public doctor getMedecin() {
        return medecin;
    }


    public void setMedecin(doctor medecin) {
        this.medecin = medecin;
    }




   
    


    // toString method for display
    @Override
    public String toString() {
        return "Rendezvous [Date=" + date + ", Heure=" + heure + 
               ", Patient=" + patient.getNom() + " " + patient.getPrenom() + 
               ", Médecin=" + medecin.getNom() + " " + medecin.getPrenom() ;
    }
}