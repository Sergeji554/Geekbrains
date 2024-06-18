import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class PersonalDataApp {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your Surname, Name, Patronymic, Date of Birth (dd.mm.yyyy), Phone Number, and Gender (f/m):");
        String input = scanner.nextLine();
        String[] data = input.split(" ");
        
        // Check if the number of inputs is correct
        if (data.length != 6) {
            System.out.println("You have entered " + (data.length < 6 ? "less" : "more") + " data than required.");
            return;
        }
        
        try {
            String surname = data[0];
            String name = data[1];
            String patronymic = data[2];
            String dob = validateDateOfBirth(data[3]);
            long phoneNumber = validatePhoneNumber(data[4]);
            char gender = validateGender(data[5]);
            
            // Write to file
            writeToFile(surname, name, patronymic, dob, phoneNumber, gender);
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    private static String validateDateOfBirth(String dob) throws Exception {
        if (!dob.matches("\\d{2}\\.\\d{2}\\.\\d{4}")) {
            throw new Exception("Invalid date of birth format.");
        }
        return dob;
    }
    
    private static long validatePhoneNumber(String number) throws Exception {
        try {
            return Long.parseLong(number);
        } catch (NumberFormatException e) {
            throw new Exception("Invalid phone number format.");
        }
    }
    
    private static char validateGender(String gender) throws Exception {
        if (gender.length() == 1 && (gender.charAt(0) == 'f' || gender.charAt(0) == 'm')) {
            return gender.charAt(0);
        } else {
            throw new Exception("Invalid gender format.");
        }
    }
    
    private static void writeToFile(String surname, String name, String patronymic,
                                    String dob, long phoneNumber, char gender) throws IOException {
        BufferedWriter writer = null;
        try {
            writer = new BufferedWriter(new FileWriter(surname + ".txt", true));
            writer.write(surname + name + patronymic + dob + " " + phoneNumber + gender);
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (writer != null) {
                writer.close();
            }
        }
    }
}
