package proetcm;

public class Main {

    public static void main(String[] args) {
    	// Create a doctor instance
        doctor doc = new doctor("John", "Doe", 123456789, "123 Main St", "Cardiology", true);

        // Test adding a schedule
        System.out.println("---- Test Adding Schedule ----");
        System.out.println("We will now attempt to add a schedule for a specific day.");
        doc.addSchedule();  // Try adding a schedule for a day
        System.out.println("Next, we will try adding the same schedule again. It should notify us that the schedule already exists.");
        doc.addSchedule();  // Try adding the same schedule again (it should notify the user)

        // Test updating a schedule
        System.out.println("\n---- Test Updating Schedule ----");
        System.out.println("Now, we will attempt to update the existing schedule.");
        doc.updateSchedule();  // Try updating an existing schedule
        System.out.println("Next, we will try updating a schedule for a day that doesn't exist yet, it should prompt us to add it first.");
        doc.updateSchedule();  // Try updating a non-existing schedule (should prompt user to add first)

        // Test printing the schedule after updates
        System.out.println("\n---- Printing the Doctor's Schedule ----");
        System.out.println("Finally, we will print the doctor's schedule after the operations to see the changes.");
        doc.printSchedule();  // Print the doctor's schedule after the operations
    }
}