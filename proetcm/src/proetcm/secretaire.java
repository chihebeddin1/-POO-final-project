package proetcm;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;



public class secretaire extends user{ 
    
    static List<doctor> doctors;
    static List<Patient> patients;
    static List<RDV> rdvs;
    public String getIdentifiant() {
		return Identifiant;
	}


	public void setIdentifiant(String Identifiant) {
		this.Identifiant = Identifiant;
	}


	public String getMotDePasse() {
		return MotDePasse;
	}


	public void setMotDePasse(String MotDePasse) {
		this.MotDePasse = MotDePasse;
	}

	static Scanner scanner;
    private String Identifiant;
    private String MotDePasse;
    
    // Constructor
    public secretaire(String nom, String prenom, int numdetelephone, String adress , String Identifiant, String MotDePasse) {
    	super( nom,  prenom,  numdetelephone,  adress , "secretaire");
    	this.Identifiant = Identifiant;
    	this.MotDePasse = MotDePasse;
        secretaire.doctors = new ArrayList<>();
        secretaire.patients = new ArrayList<>();
        secretaire.rdvs = new ArrayList<>();
        secretaire.scanner = new Scanner(System.in);
        
    }

 
    public void setDoctors(List<doctor> doctors) {
        secretaire.doctors = doctors;
    }

    public void setPatients(List<Patient> patients) {
        secretaire.patients = patients;
    }

    public void setRdvs(List<RDV> rdvs) {
        secretaire.rdvs = rdvs;
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

	static List<doctor> filterDoctorsBySpecialtyAndDay(List<doctor> doctors, String specialty, String day) { 
	    List<doctor> filteredDoctors = new ArrayList<>();

	    // Null or empty check for inputs
	    if (doctors == null || doctors.isEmpty()) {
	        System.out.println("No doctors provided.");
	        return filteredDoctors;
	    }
	    if (specialty == null || day == null) {
	        System.out.println("Specialty or day is null.");
	        return filteredDoctors;
	    }

	    // Loop through the doctor list and filter by specialty and day
	    for (doctor doctor : doctors) {
	        // Check if the doctor matches the specialty
	        if (doctor.getSpecialty().equalsIgnoreCase(specialty)) {
	            // Check if the doctor has a schedule for the given day
	            if (doctor.getSchedule().containsKey(day)) {
	            	
	                filteredDoctors.add(doctor);
	                System.out.println(filteredDoctors);
	            }
	        }
	    }
        
	    return filteredDoctors;
	}

	//check if there is less than 8 appointments
	static boolean checkAppointmentsAvailability(String specialty, String day) {
	    int appointmentCount = 0;

	    // Iterate through the RDV list to count appointments that match the day and specialty
	    for (RDV rdv : rdvs) {
	        // Check if the doctor's specialty and the day of the RDV match the parameters
	        if (rdv.getMedecin().getSpecialty().equalsIgnoreCase(specialty) && rdv.getDate().equalsIgnoreCase(day)) {
	            appointmentCount++;
	        }
	    }

	    // Check if there are fewer than 8 appointments
	    return  appointmentCount < 8;
	    
	}
	
	
	
	//gestion des rdv //on a une boucle infini....
	static void manageAppointments(List<doctor> doctors, List<RDV> rdvs, List<Patient> patients ) {
		boolean continueAppointments = true;
	    System.out.print("Enter the specialty: ");
	    String specialty = scanner.nextLine();

	    do {
	        System.out.print("Enter the day (e.g., Monday, Tuesday, etc.): ");
	        String day = scanner.nextLine();

	        if (checkAppointmentsAvailability(specialty, day)) {
	            List<doctor> availableDoctors = filterDoctorsBySpecialtyAndDay(doctors, specialty, day);

	            if (availableDoctors.isEmpty()) {
	                System.out.println("No doctors available for " + specialty + " on " + day + ".");
	                continueAppointments = false;
	            } else {
	                System.out.println("Available doctors for " + specialty + " on " + day + ":");
	                for (doctor doc : availableDoctors) {
	                    System.out.println( " " + doc.getPrenom());
	                }

	                boolean validDoctor = false;
	                do {
	                    doctor selectedDoctor = null;
	                    Patient selectedPatient = null;

	                    System.out.print("Enter the name of the doctor: ");
	                    String doctorName = scanner.nextLine();

	                    System.out.print("Enter the time of the appointment: ");
	                    int hour = scanner.nextInt();
	                    scanner.nextLine(); // consume newline

	                    System.out.print("Enter the patient's ID: ");
	                    String patientId = scanner.nextLine();

	                    boolean doctorFound = false;
	                    boolean patientFound = false;

	                    // Search for the selected doctor
	                    for (doctor doc : availableDoctors) {
	                        if (doc.getPrenom().equalsIgnoreCase(doctorName)) {
	                            selectedDoctor = doc;
	                            doctorFound = true;
	                            break; // Stop searching once doctor is found
	                        }
	                    }

	                    if (doctorFound) {
	                        // Search for the selected patient
	                        for (Patient pat : patients) {
	                            if (pat.getIdPatient().equalsIgnoreCase(patientId)) {
	                                selectedPatient = pat;
	                                patientFound = true;
	                                validDoctor=true;
	                                break; // Stop searching once patient is found
	                            }
	                        }

	                        if (patientFound) {
	                            // Create and add the new RDV
	                            RDV newRdv = new RDV(day, hour, selectedPatient, selectedDoctor);
	                            rdvs.add(newRdv);
	                            System.out.println("Rendezvous added: " + newRdv);

	                        } else {
	                            System.out.println("Patient not found.");
	                        }

	                    } else {
	                        System.out.println("Doctor not found.");
	                    }
	                } while (validDoctor=false);
	            }
	        } else {
	            System.out.println("No more appointments available for " + specialty + " on " + day + ".");
	            continueAppointments = false;
	        }
	    } while (continueAppointments=false);
	}
	                    
	                    
	                    
	                    
	                    
	                 

	public static void AjouterRDV(RDV redv) {
		
		if(rdvs == null) {
			rdvs = new ArrayList<>();
			rdvs.add(redv);
		}else {
		for(RDV rdv : rdvs) {
			if (rdv == redv ) {
				System.out.println("Ce rendez_vous existe deja!");
				return;
			}else {
			
				rdvs.add(redv);
			}
			}
		}
	}}