package au.com.qantas;

import java.util.Scanner;

/**
 * @author SM
 *
 * Main execution class
 */
public class MainClass {


    public static void main(String args[]){

        // create a scanner so we can read the command-line input
        Scanner scanner = new Scanner(System.in);

        String startDate, endDate;

        while(true) {
            //  prompt for the user's name
            System.out.print("Enter start date in: yyyy-mm-dd format");

            // get their input as a String
            startDate = scanner.next();

            if (DateUtil.validateDate(startDate)) {
                break;
            }
        }

        while(true){
            // prompt for their age
            System.out.print("Enter end date in: yyyy-mm-dd format");

            // get their input as a String
            endDate = scanner.next();

            if (DateUtil.validateDate(endDate)) {
                break;
            }
        }

        // print number of days
        System.out.println(DateUtil.getDaysBetweenTwoDates(startDate, endDate));
    }
}
