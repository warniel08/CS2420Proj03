/*
*   Warner Nielsen
*   1/30/19
*   Project 03
*   CS 2420
*   Garth Sorenson
* */

package Date;

import java.util.Scanner;

/*
*  This driver program takes the class Date created in the Date.java file
*  and creates a new Date obj and uses the class methods on the object.
*  There are 3 data fields for a Date obj that will be collected from the
*  user. Those are then entered into the Date constructor. Later the user
*  is presented a menu of 4 options. 3 of the options are to run the methods
*  that the book asked us to create. Two are display methods and the third is
*  a method to increase the Date by one day. The 4th option in the menu is to
*  quit the program.
* */
public class NielWarnProj03 {
    public static void main(String[] args) {
        // Variables to be used to create a Date object
        int month, day, year, usrMenuChoice;
        boolean stopLoop = false;

        // Welcome message
        System.out.println("This program will ask you for three separate integers " +
                "\nrepresenting a month, day, and year. The program" +
                "\nwill display the dates in two different formats. There" +
                "\nis also a method that increases the date by one day.\n");

        // New scanner for input values from user
        Scanner input = new Scanner(System.in);

         /*
         *  Do-while loop to get the month from a user, validates values >= 1 and
         *  <= 12. Also, if something other than an int gets inputted, it lets
         *  the user know that input is invalid.
         * */
        do {
            System.out.print("Please enter a month (an integer value 1-12): ");
            while (!input.hasNextInt()) {
                System.out.println("That's not an integer value.");
                System.out.print("Please enter a month (an integer value 1-12): ");
                input.next();
            }
            month = input.nextInt();
        } while (month < 1 || month > 12);
        System.out.println("Month = " + month);

        /*
        *  Do-while loop the captures the month of February and makes sure that there
        *  is valid day input. February only has 28 days (this program does not account
        *  for leap year). It also makes sure that months with 30 days only allow int
        *  values from 1-30. If a particular month has 31 days in validates that. It
        *  also returns a message if a user inputs something other than an int and lets
        *  the user try again.
        * */
        do {
            if (month == 2) {
                System.out.print("Please enter a day (an integer value 1-28): ");
                while (!input.hasNextInt()) {
                    System.out.println("That's not an integer value.");
                    System.out.print("Please enter a day (an integer value 1-28): ");
                    input.next();
                }
                day = input.nextInt();
                if (day < 0 || day > 28) {
                    day = 0;
                }
            } else if (month == 4 || month == 6 || month == 9 || month == 11) {
                System.out.print("Please enter a day (an integer value 1-30): ");
                while (!input.hasNextInt()) {
                    System.out.println("That's not an integer value.");
                    System.out.print("Please enter a day (an integer value 1-30): ");
                    input.next();
                }
                day = input.nextInt();
                if (day < 0 || day > 30) {
                    day = 0;
                }
            } else {
                System.out.print("Please enter a day (an integer value 1-31): ");
                while (!input.hasNextInt()) {
                    System.out.println("That's not an integer value.");
                    System.out.print("Please enter a day (an integer value 1-31): ");
                    input.next();
                }
                day = input.nextInt();
            }
        } while (day < 1 || day > 31);
        System.out.println("Day = " + day);

        /*
        *  Do-while loop validates the year and makes sure the input is greater
        *  than 0. It also makes sure the user input an int value.
        * */
        do {
            System.out.print("Please enter a four digit year (ie. 2001): ");
            while (!input.hasNextInt()) {
                System.out.println("That's not an integer value.");
                System.out.print("Please enter a four digit year (ie. 2001): ");
                input.next();
            }
            year = input.nextInt();
        } while (year < 0);
        System.out.println("Year = " + year);

        // Create new date object using month, day, year int variables collected from user
        Date d = new Date(month, day, year);

        System.out.println("\nPlease select from the options which method you would" +
                "\nlike to perform on the Date object:");

        /*
        *  Do-while loop gives user a Menu option to choose from the 3 different methods
        *  that the book asked us to create. The first method prints the Date in integer
        *  format (01/06/2001). The second method prints the Date in month format
        *  (May 4, 1999). The third method will increase the Date by one day. The input
        *  is validated for correct days as seen above. It also captures if February 28
        *  is increase by one day it will not go to Feb 29 but March 1. December 31 will
        *  increase to January 1 of the next year and so on.
        * */
        do {
            // Display menu choices
            System.out.println("\nMenu:");
            System.out.println("\t1 - Display the Date in integer format (01/01/2001)");
            System.out.println("\t2 - Display the Date in written month format (May 5, 2015)");
            System.out.println("\t3 - Increase the Date by one day");
            System.out.println("\t4 - Quit");

            // New scanner for menu choice
            Scanner menuChoiceScanner = new Scanner(System.in);

            System.out.print("Enter a choice: ");
            usrMenuChoice = menuChoiceScanner.nextInt();

            // Switch statement for user choice from menu options
            switch (usrMenuChoice) {
                case 1:
                    // Display the date in the int format (01/05/20119)
                    System.out.print("\nDate displayed in integer format: ");
                    d.displayIntFormat();
                    break;
                case 2:
                    // Display the date in the month spelled out format (March 5, 2001)
                    System.out.print("\nDate display in month format: ");
                    d.displayMonthFormat();
                    break;
                case 3:
                    // Advance the Date by one day
                    System.out.println("\nYou advanced the Date by one day...");
                    d.advanceByOneDay();
                    break;
                case 4:
                    // Quit menu loop
                    stopLoop = true;
                    break;
                default:
                    System.out.println("Invalid choice, try again...");
            }
        } while (!stopLoop);
    }
}
