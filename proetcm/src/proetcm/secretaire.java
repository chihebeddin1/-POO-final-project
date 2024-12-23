package proetcm;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class secretaire extends user{
    
    private List<doctor> doctors;
    private List<Patient> patients;
    private List<RDV> rdvs;
    private Scanner scanner;
    
    // Constructor
    public secretaire(String nom, String prenom, int numdetelephone, String adress) {
    	super( nom,  prenom,  numdetelephone,  adress , "secretaire");
        this.doctors = new ArrayList<>();
        this.patients = new ArrayList<>();
        this.rdvs = new ArrayList<>();
        this.scanner = new Scanner(System.in);
        
    }

 
    public void setDoctors(List<doctor> doctors) {
        this.doctors = doctors;
    }

    public void setPatients(List<Patient> patients) {
        this.patients = patients;
    }

    public void setRdvs(List<RDV> rdvs) {
        this.rdvs = rdvs;
    }

	public List<doctor> getDoctors() {
		return doctors;
	}

	public List<Patient> getPatients() {
		return patients;
	}

	public List<RDV> getRdvs() {
		return rdvs;
	}

//methode pour filtrer la liste des docteurs en liste des doc available
	public List<doctor> filterDoctorsBySpecialtyAndDay(String specialty, String day) {
        List<doctor> filteredDoctors = new ArrayList<>();

        // Loop through the doctor list and filter by specialty and day
        for (doctor doctor : doctors) {
            if (doctor.getSpecialty().equalsIgnoreCase(specialty) && doctor.getSchedule().containsKey(day)) {
                filteredDoctors.add(doctor);
            }
        }

        return filteredDoctors;
    }
	//check if there is less than 8 appointments
	public boolean checkAppointmentsAvailability(String specialty, String day) {
	    int appointmentCount = 0;

	    // Iterate through the RDV list to count appointments that match the day and specialty
	    for (RDV rdv : rdvs) {
	        // Check if the doctor's specialty and the day of the RDV match the parameters
	        if (rdv.getMedecin().getSpecialty().equalsIgnoreCase(specialty) && rdv.getDate().equalsIgnoreCase(day)) {
	            appointmentCount++;
	        }
	    }

	    // Check if there are fewer than 8 appointments
	    return appointmentCount < 8;
	}
	
	//gestion des rdv
	public void manageAppointments() {
		boolean p=true;
	    System.out.print("Enter the specialty: ");
	    String specialty = scanner.nextLine();  // Get specialty from user input
          do {
        	  System.out.print("Enter the day (e.g., Monday, Tuesday, etc.): ");
      	    String day = scanner.nextLine();  // Get day from user input

      	    // Check if the number of appointments for the given specialty and day is less than 8
      	    if (checkAppointmentsAvailability(specialty, day)) {
      	        // If there are fewer than 8 appointments, filter the doctors
      	        List<doctor> availableDoctors = filterDoctorsBySpecialtyAndDay(specialty, day);

      	        if (availableDoctors.isEmpty()) {
      	           System.out.println("No doctors available for " + specialty + " on " + day + ".");
      	           p=false;
      	        } else {
      	            System.out.println("Available doctors for " + specialty + " on " + day + ":");
      	            for (doctor doc : availableDoctors) {
      	                System.out.println(doc.getNom() + " " + doc.getPrenom());
      	            }
      	          boolean sr=true;
      	          do {
      	        	  
      	          System.out.print("Enter the name of the doctor: ");
                  String doctorName = scanner.nextLine();

                  System.out.print("Enter the time of the appointment: ");
                  int hour = scanner.nextInt();
                  scanner.nextLine(); // consume newline

                  doctor selectedDoctor = null;
                  for (doctor doc : availableDoctors) {
                      if (doc.getNom().equalsIgnoreCase(doctorName)) {
                          selectedDoctor = doc;
                          break;
                      }
                  }

                  if (selectedDoctor != null) {
                      System.out.print("Enter the patient's ID: ");
                      String patientId = scanner.nextLine();

                      Patient selectedPatient = null;
                      for (Patient pat : patients) {
                          if (pat.getIdPatient().equalsIgnoreCase(patientId)) {
                              selectedPatient = pat;
                              break;
                          }
                      }

                      if (selectedPatient != null) {
                          RDV newRdv = new RDV(day, hour, selectedPatient, selectedDoctor);
                          rdvs.add(newRdv);
                          System.out.println("Rendezvous added: " + newRdv);
                      } else {
                          System.out.println("Patient not found.");
                          sr=false;
                      } 
                  } else {
                      System.out.println("Doctor not found.");
                      sr=false;
                  }}while(sr=false);
      	            
      	        }
      	    } else {
      	        System.out.println("No more appointments available for " + specialty + " on " + day + ".");
      	        p=false;
      	    }
      	}while(p=false);
        	  
          }
}
