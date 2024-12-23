package proetcm;

import java.util.ArrayList;
import java.util.Scanner;

public class Main1 {

	@SuppressWarnings("null")
	public static void main(String[] args) {
		CabinetMedicale.patients = new ArrayList<>();
        CabinetMedicale.doctors = new ArrayList<>();
        CabinetMedicale.secretaires = new ArrayList<>();
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
        ArrayList<String> allergiesPatient1 =  new ArrayList<>();
        allergiesPatient1.add("chat");
        ArrayList<String> allergiesPatient2 = new ArrayList<>();
        allergiesPatient2.add("Fraise");
        ArrayList<String> allergiesPatient3 =  new ArrayList<>();
        allergiesPatient3.add("poussière");
        ArrayList<String> allergiesPatient4 =  new ArrayList<>();
        allergiesPatient4.add("glutin");
        ArrayList<String> allergiesPatient5 =  new ArrayList<>();
        allergiesPatient5.add("kiwi");


        
        
        Patient patient1 = new Patient("Alice", "Dubois", 112233445, "Cheraga",   "P001" ,"A", allergiesPatient1,2);
        Patient patient2 = new Patient("Marc", "Durand",  667788990, "Douera", "P002", "B+", allergiesPatient2, 0);
        Patient patient3 = new Patient("Ahmed", "trun", 112132456, "BabaHassen",   "P003", "AB+", allergiesPatient3, 0);
        Patient patient4 = new Patient("Qwidar", "Fadali", 122333447, "Bebzouar",   "P004", "A-", allergiesPatient4, 3);
        Patient patient5 = new Patient("Anis", "Diara", 819235045, "Draria",   "P005", "O-", allergiesPatient5, 1);

        CabinetMedicale.ajouterPatient(patient1);
        CabinetMedicale.ajouterPatient(patient2);
        CabinetMedicale.ajouterPatient(patient3);
        CabinetMedicale.ajouterPatient(patient4);
        CabinetMedicale.ajouterPatient(patient5);
     // Vérification de l'utilisateur
        boolean p= true;
        //identifier l'user
        	    	p= true;
                Scanner scanner = new Scanner(System.in);
                do {
                System.out.println("veuillez saisir votre role:");
                
                String userrole = scanner.nextLine().toLowerCase();//lower case to work in switch
                switch (userrole) {
                case "doctor": {
                	
               
					int i=0;
					do {
                	System.out.println("Veuillez saisir votre ID:");
                    String userId = scanner.nextLine();
                    System.out.println("Veuillez saisir votre mot de passe:");
                    String userMdp = scanner.nextLine();
                    if (CabinetMedicale.verifierUtilisateur(userId, userMdp)) {
                        System.out.println("Bienvenue, Docteur! Vous êtes authentifié.");
                        System.out.println("Entre l'ID de votre patient:");
                        String idpatientString=scanner.nextLine();
                      Patient patient= CabinetMedicale.rechercherPatient(idpatientString);
                        if(patient==null) {
                        	System.out.println("votre patient n'exist pas");
                        	System.out.println("voulez vous l'ajouter?");
                        	String decisionString=scanner.nextLine();
                            if(decisionString.equalsIgnoreCase("yes")) {
                            	System.out.println("entrer le nom de votre pateint:");
                            	  String nom=scanner.nextLine();
                            	  System.out.println("entrer le prenom de votre pateint:");
                            	  String prenom=scanner.nextLine();
                            	  System.out.println("entrer l'adress de votre pateint:");
                            	  String adress=scanner.nextLine();
                            	  
                            	  
                            	  System.out.println("entrer le id de votre pateint:");
                            	  String id=scanner.nextLine();
                            	  
                            	  System.out.println("entrer le numero de telephone de votre pateint:");
                            	  int numdetelephon=scanner.nextInt();
                            	  scanner.nextLine();
                            	  
                            	  System.out.println("entrer le groupe sanguin de votre pateint:");
                            	  String sang=scanner.nextLine();
                            	  
                            	  
                            	  
                            	  System.out.println("entrer le nombre d'operations votre pateint:");
                            	  int numdeop=scanner.nextInt();
                            	  
                            	  scanner.nextLine();
                            	  
                            	  System.out.println("entrer les allergies votre pateint:");
                            	  String alergie=scanner.nextLine();
                            	  
                            	  ArrayList<String> alergieStrings = new ArrayList<>();;
                            	  alergieStrings.add(alergie);
                            	  
                                  Patient patient21= new Patient(nom,prenom,numdetelephon,adress,id,sang,alergieStrings,numdeop);
                                  CabinetMedicale.ajouterPatient(patient21);
                                  patient= CabinetMedicale.rechercherPatient(patient21.idPatient);
                            }
                        }
                        
                                  scanner.nextLine();
                  	              System.out.println("la consultation de "+patient.nom+""+patient.prenom);
                  	              PatientManagement patientManagement = new PatientManagement();
                                  System.out.println("Entrez l'ordonnance:");
                                  String orString=   patientManagement.writeOrdonnance(patient);
                                  System.out.println("Ajoutez une observation:");                    
                                  String obString=  patientManagement.addObservation(patient);
                                  System.out.println("Ajoutez un certificat:");                      
                                  String cerString= patientManagement.addCertificate(patient); 
                                  StringBuilder sb = new StringBuilder();
                                  
                                  sb.append(orString);
                                  sb.append("\n");
                                  sb.append("2. observation");
                                  sb.append(" ");
                                  sb.append("{");
                                  sb.append(obString);
                                  sb.append("}");
                                  sb.append("\n");
                                  sb.append("3. certaficat");
                                  sb.append(" ");
                                  sb.append("{");
                  	              sb.append(cerString);
                  	              sb.append("}");
                  	              sb.append("\n");
                  	              String result = sb.toString();
                  	              patient.getConsultationhistory().add(result);
                  	              
                  	              patient.afficherConsultations();
                  	             p=false;
                  	  
                  	  
                  	  
                        //les tahes des docteurs
                    } else {
                        System.out.println("Authentification échouée. Vérifiez vos informations.");
                       
                        i=i+1;
                    }
                    }while(i<3&&p==true);
					if(p==true);
					System.out.print("error");
					return;
                }
                case "secretaire": {
                    int i=0;
                	
                	do {
                	System.out.println("Veuillez saisir votre ID:");
                    String userId = scanner.nextLine();
                    System.out.println("Veuillez saisir votre mot de passe:");
                    String userMdp = scanner.nextLine();
                    if (CabinetMedicale.verifierUtilisateur(userId, userMdp)) {
                        System.out.println("Bienvenue, Secrétaire! Vous êtes authentifié.");
                        // les tache des secretaires...
                    } else {
                        System.out.println("Authentification échouée. Vérifiez vos informations.");
                        p=false;
                        i++;
                    }}while(i<3);
                	System.out.print("error");
					return;
                   
                }
                default: {
                    System.out.println("Rôle invalide. Veuillez entrer 'doctor' ou 'secretaire'.");
                    p=false;
                    
                    break;
                }
                
            }
               
                }while(p==true);
            // Close the scanner to release system resources
    	
                
                
                
                
                
                
                
      	 // Ajout de médecins
     




     // Ajout d'une secrétaire
        secretaire secretaire1 = new secretaire("salah", "meroua", 123456789, "10 rue de la Paix", "meroua","Santé1");
        secretaire secretaire3 = new secretaire("sherine", "malah", 132456789, "5 rue de la Paix", "malah","Santé2");
        secretaire secretaire4 = new secretaire("imen", "tila", 123456789, "4 rue de la Paix", "tila","Santé3");
        secretaire secretaire5 = new secretaire("omar", "karit", 143256879, "2 rue de la Paix", "karit","Santé4");
        secretaire secretaire6 = new secretaire("omar", "karit", 143256879, "2 rue de la Paix", "karit","Santé4");

        

        CabinetMedicale.ajouterSecretaire(secretaire1);
        CabinetMedicale.ajouterSecretaire(secretaire3);
        CabinetMedicale.ajouterSecretaire(secretaire4);
        CabinetMedicale.ajouterSecretaire(secretaire5);
        CabinetMedicale.ajouterSecretaire(secretaire6);


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
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
