package proetcm;
import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;

public class doctor extends user {
    String specialty;
    boolean surgery;
    private Scanner scanner;
    private Map<String, hourschedule> schedule;  // Map to store the schedule by day
    
    // Constructor
    public doctor(String nom, String prenom, int numdetelephone, String adress, String specialty, boolean surgery) {
        super(nom, prenom, numdetelephone, adress, "Docteur"); // Correct constructor call
        this.specialty = specialty;
        this.surgery = surgery;
        this.scanner = new Scanner(System.in);
        this.schedule = new HashMap<>();
    }
    
    // Add or update the schedule for a specific day
    public void addSchedule() {
        // Read day and start/end times as strings first
        System.out.print("Enter the day of the week (e.g., Monday, Tuesday, etc.): ");
        String day = scanner.nextLine();

        if (this.schedule.containsKey(day)) {
            // If the schedule exists, prompt for confirmation to update it
            System.out.println("Schedule already exists for " + day + ". Do you want to update it? (yes/no)");
            String response = scanner.nextLine();
            if (response.equalsIgnoreCase("yes")) {
                System.out.print("Enter the new start hour: ");
                
                // Instead of nextInt(), we use nextLine() to handle input cleanly
                boolean sh=true;
                int startHour,startMin, endHour, endMin;
                
                do {
                 startHour = Integer.parseInt(scanner.nextLine()); // Convert the string input taken by nextline() to int for starthour
                
                
                System.out.print("Enter the new start min: ");

                 startMin = Integer.parseInt(scanner.nextLine()); 
                System.out.print("Enter the new end hour: ");
                 endHour = Integer.parseInt(scanner.nextLine()); // Convert input to int
                System.out.print("Enter the new end min: ");

                 endMin = Integer.parseInt(scanner.nextLine()); // Convert input to int
                if(startHour<0 || startHour>23 || startMin<0 || startMin>59 || endHour<0 || endHour>23 || endMin<0 || endMin>59) {
                    sh=false; };
                }while(sh=false);

                this.schedule.put(day, new hourschedule(startHour,startMin, endHour, endMin));
                System.out.println("Schedule for " + day + " updated: " + startHour + "H" + startMin+ "min" + "to" + endHour + "H" + endMin + "min");
                }
        } else {
            // If the schedule doesn't exist, add it
            System.out.print("Enter the start hour: ");
            int startHour = Integer.parseInt(scanner.nextLine()); // Convert input to int
            System.out.print("Enter the new start min: ");

            int startMin = Integer.parseInt(scanner.nextLine());
            System.out.print("Enter the end hour: ");
            int endHour = Integer.parseInt(scanner.nextLine()); // Convert input to int
            System.out.print("Enter the new end min: ");

            int endMin = Integer.parseInt(scanner.nextLine()); 
            this.schedule.put(day, new hourschedule(startHour,startMin, endHour, endMin));
            System.out.println("Schedule for " + day + " updated: " + startHour + "H" + startMin+ "min" + "to" + endHour + "H" + endMin + "min");
        }
    }

    public void updateSchedule() {
        // Method for updating an existing schedule
        System.out.print("Enter the day of the week (e.g., Monday, Tuesday, etc.): ");
        String day = scanner.nextLine();
        
        if (this.schedule.containsKey(day)) {
            System.out.println("Schedule already exists for " + day + ". Do you want to update it? (yes/no)");
            String response = scanner.nextLine();
            
            if (response.equalsIgnoreCase("yes")) {
                System.out.print("Enter the new start hour: ");
                boolean sh=true;
                int startHour,startMin, endHour, endMin;
                do {
                 startHour = (scanner.nextInt());
                System.out.print("Enter the new start min: ");

                 startMin = Integer.parseInt(scanner.nextLine());  

                System.out.print("Enter the new end hour: ");
                 endHour = (scanner.nextInt());
                System.out.print("Enter the new end min: ");

                 endMin = Integer.parseInt(scanner.nextLine()); // Convert input to int
                 if(startHour<0 || startHour>23 || startMin<0 || startMin>59 || endHour<0 || endHour>23 || endMin<0 || endMin>59) {
                     sh=false; };
                 }while(sh=false);


                // Update the schedule for the day
                this.schedule.put(day, new hourschedule(startHour,startMin, endHour, endMin));
                System.out.println("Schedule for " + day + " updated: " + startHour + "H" + startMin+ "min" + "to" + endHour + "H" + endMin + "min");
            } else {
                System.out.println("No changes made to the schedule for " + day);
            }
        } else {
            System.out.println("No schedule found for " + day + ". Please add a schedule first.");
        }
    }
    
    // Remove the schedule for a specific day
    public void removeSchedule() {
        System.out.print("Enter the day to remove the schedule for: ");
        String day = scanner.nextLine();  // Input day
        
        if (this.schedule.containsKey(day)) {
            this.schedule.remove(day);
            System.out.println("Schedule for " + day + " has been removed.");
        } else {
            System.out.println("No schedule found for " + day);
        }
    }
    
    // Print the doctor's schedule
    public void printSchedule() {
        if (schedule.isEmpty()) {
            System.out.println("No schedule available.");
            return;
        }

        System.out.println("Doctor's Schedule:");
        //iterate the list with keys
        for (Map.Entry<String, hourschedule> entry : schedule.entrySet()) {
            System.out.println("Day: " + entry.getKey() + " | Working Hours: " + entry.getValue());
        }
    }

    // Getters and setters for Doctor-specific fields
    public String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }

    public boolean isSurgery() {
        return surgery;
    }

    public void setSurgery(boolean surgery) {
        this.surgery = surgery;
    }
    
    // Getter for the schedule for a specific day
    public hourschedule getScheduleForDay(String day) {
        return this.schedule.get(day);
    }

    // Setter for the schedule map (if you need to directly set it)
    public void setSchedule(Map<String, hourschedule> schedule) {
        this.schedule = schedule;
    }

    // Getter for the schedule map (if you need to get it directly)
    public Map<String, hourschedule> getSchedule() {
        return this.schedule;
    }
    
    // Method to close scanner (be careful with this if you use System.in elsewhere)
    public void closeScanner() {
        if (scanner != null) {
            scanner.close();
        }
    }
}