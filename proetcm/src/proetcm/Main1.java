package proetcm;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;

import java.lang.classfile.instruction.SwitchCase;

public class Main1 {








	static List<doctor> doctors;
	@SuppressWarnings("null")
	public static void main(String[] args) {
		CabinetMedicale.patients = new ArrayList<>();  secretaire.rdvs= new ArrayList<>(); 
        CabinetMedicale.doctors = new ArrayList<>();
        CabinetMedicale.secretaires = new ArrayList<>();
        doctor medecin1 = new doctor("Jean", "Martin", 987654321, "20 rue de la Santé", "Cardiologue", false ,"Dr.Martin","Santé55");
        doctor medecin2 = new doctor("Sophie", "Lemoine", 123789456, "15 rue des Lilas", "Dermatologue", true, "Dr.Lemoine","Santé66");
        doctor medecin3 = new doctor("hamid", "soup", 123784856, "10 rue des Lilas", "Cardiologue", true, "Dr.soup","Santé77");
        doctor medecin4 = new doctor("sarah", "ougour", 123879456, "8 rue des Lilas", "Dentiste", true, "Dr.ougour","Santé22");
        doctor medecin5 = new doctor("meriem", "ougnoune", 132789456, "2 rue des Lilas", "Endocrinologie", false, "Dr.ougnoune","Santé33");
        
    
        medecin1.addSchedule("Monday", 7, 30, 18, 40);  
        medecin2.addSchedule("Tuesday", 8, 15, 12, 0);
        medecin3.addSchedule("Monday", 6, 0, 14, 30);
        medecin4.addSchedule("Sunday", 9, 15, 13, 45);
        medecin5.addSchedule("Saturday", 8, 30, 14, 30);
        
        
        CabinetMedicale.ajouterMedecin(medecin1 );
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
        
     // Ajout d'une secrétaire
        secretaire secretaire1 = new secretaire("salah", "meroua", 123456789, "10 rue de la Paix", "meroua","Santé1");
        secretaire secretaire3 = new secretaire("sherine", "malah", 132456789, "5 rue de la Paix", "malah","Santé2");
        secretaire secretaire4 = new secretaire("imen", "tila", 123456789, "4 rue de la Paix", "tila","Santé3");
        secretaire secretaire5 = new secretaire("omar", "karit", 143256879, "2 rue de la Paix", "karit","Santé4");
        secretaire secretaire6 = new secretaire("omar", "karit", 143256879, "2 rue de la Paix", "karit","Santé4");
        secretaire secretaire2 = new secretaire("Anne", "Martin", 987645321, "15 avenue des Roses","Martin","Santé5");
        


        CabinetMedicale.ajouterSecretaire(secretaire1);
        CabinetMedicale.ajouterSecretaire(secretaire2);
        CabinetMedicale.ajouterSecretaire(secretaire3);
        CabinetMedicale.ajouterSecretaire(secretaire4);
        CabinetMedicale.ajouterSecretaire(secretaire5);
        CabinetMedicale.ajouterSecretaire(secretaire6);
        
     // Affichage des informations de la secrétaire
        CabinetMedicale.afficherSecretaire();
         
        RDV rdv1 = new RDV("september 9th",8, patient1, medecin1);
        RDV rdv2 = new RDV("september 9th",8, patient2, medecin2);
        RDV rdv3 = new RDV("september 9th",8, patient2, medecin3);


        secretaire.AjouterRDV(rdv1);
        secretaire.AjouterRDV(rdv2);
        secretaire.AjouterRDV(rdv3);
        
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
                  	              
                  	              patient.afficherConsultations(patient);
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
                		// les tache des secretaires...
                		System.out.println("quelle type de tache voulez vous effectuer?\n");
                        System.out.println("saisir 1 pour ajouter un patient et gerer son rdv ");
                        System.out.println("saisir 2 pour ajouter un noveau medcin ");
                        System.out.println("saisir 3 pour ajouter une nouvelle secretaire");
                        System.out.println("saisir 4 pour change an appointment pr a schedual");
                       
             
                	System.out.println("Veuillez saisir votre ID:");
                    String userId = scanner.nextLine();
                    System.out.println("Veuillez saisir votre mot de passe:");
                    String userMdp = scanner.nextLine();
                    if (CabinetMedicale.verifierUtilisateur(userId, userMdp)) {
                        System.out.println("Bienvenue, Secrétaire! Vous êtes authentifié.");
                        
                        
                        
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
                                
                            
                        
                            //gestion des rdv
                            secretaire.manageAppointments(CabinetMedicale.doctors, secretaire.rdvs, CabinetMedicale.patients);//jma3a succes mais ki tbadlo getter nom par prenom
                                }
                            }
                            
                            
                            
                            
                        p=false;
                    } else {
                        System.out.println("Authentification échouée. Vérifiez vos informations.");
                        
                        i++;
                    }
                    }while(i<3&&p==true);
                	if(p==true);
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
                	
                
                }
                }
	
	
	
	
	
	
	
	
	
	
	
	

