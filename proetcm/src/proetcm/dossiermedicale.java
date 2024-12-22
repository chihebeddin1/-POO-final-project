package proetcm;

public interface dossiermedicale {
    void writeordonnance(Patient patient, String ordonnance);
    void addobservation(Patient patient, String observation);
    void addcertificate(Patient patient, String certificate); 
}