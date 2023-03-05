import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Scanner;

public class randomPassGenerator {
    public static void main(String[] args) throws IOException {
        Scanner input = new Scanner(System.in);
        String fileName = "Passwords";

        //Int variable to take in total # of passwords user would like generated
        System.out.print("How many passwords would you like to generate?:\t");
        int passwordTotal = input.nextInt();

        //Takes in the # of characters the user would like the password to contain in length
        System.out.print("How many characters would you like your password to contain?:\t");
        int passwordLength = input.nextInt();

        //An array to store the Strings passwordTotal
        String[] generalPasswords = new String[passwordTotal];


        //for loop to take in number of passwords to create inputted by user
        for (int i = 0; i < passwordTotal; i++) {


            //String variable to store characters
            String password = "";

            //for loop to print and store the password into array
            for (int j = 0; j < passwordLength; j++) {
                password += randomCharacters();//password is equal to plus randomCharacters(),
                // so it inputs password into randomCharacters
                generalPasswords[i] = password;//generalPasswords array is set equal to password

                //Saves passwords to file 
                BufferedWriter writer = new BufferedWriter(new FileWriter(fileName + ".txt"));
                writer.write("Your randomly generated passwords are: " + Arrays.toString(generalPasswords).replaceAll("[\\[|\\]]", ""));
                Charset.forName("UTF-8");
                writer.close();
            }


        }//end for loop

        

        //prints Array(generalPasswords)
        printArray(generalPasswords);
        input.close();
    }//end main

    //Method used to print out array String using for loop, and prints out String variable s
    public static void printArray(String[] arr) {
        for (String s : arr) {
            System.out.println(s);
        }
    }

    //Method to generate random characters into password using ASCII
    public static char randomCharacters() {

        int randomGen = (int) (Math.random() * 62);


        if (randomGen <= 9) {
            int number = randomGen + 48;
            return (char) (number);
        } else if (randomGen <= 35) {
            int uppercase = randomGen + 35;
            return (char) (uppercase);
        } else {
            int lowercase = randomGen + 61;
            return (char) (lowercase);
        }

    }//end randomCharacters

}