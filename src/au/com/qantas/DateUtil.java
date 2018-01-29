package au.com.qantas;

/**
 * @author SM
 *
 * Date Utility Class
 */
public class DateUtil {

    private static final int DAYS_IN_YEAR = 365;

    private static final int[] MONTHS_NON_LEAP = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    private static final int[] MONTHS_LEAP = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    private DateUtil(){
        // do nothing
        // object can't be created
    }

    /**
     * Get the number of days between 2 days
     *
     * @param startDate
     * @param endDate
     * @return number of days
     */
    public static int getDaysBetweenTwoDates(String startDate, String endDate){

        if(validateDate(startDate) && validateDate(endDate)){
            // start Date
            int startDateDay = getDaysFromDateString(startDate);
            int startDateMonth = getMonthFromDateString(startDate);
            int startDateYear = getYearFromDateString(startDate);

            // end Date
            int endDateDay = getDaysFromDateString(endDate);
            int endDateMonth = getMonthFromDateString(endDate);
            int endDateYear = getYearFromDateString(endDate);

            return getDaysFromFirstJan(endDateDay, endDateMonth, endDateYear) - getDaysFromFirstJan(startDateDay, startDateMonth, startDateYear) + getDaysBetweenYears(startDateYear, endDateYear) - 1;
        }
        throw new RuntimeException("Invalid Date Format");
    }

    /**
     * Get the number of days from 1st Jan (eg. 15th Feb will return 46)
     *
     * @param day
     * @param month
     * @param year
     * @return days count
     */
    private static int getDaysFromFirstJan(int day, int month, int year){

        int count = day;
        month-=1;
        count+=getDaysFromMonths(month, year);
        return count;
    }

    /**
     * Get the total number of days from the month passed (1 for jan, 12 for dec etc)
     * Takes leap year into consideration
     * eg. passing 2 as month and 2016 as year will return 60 (31+29)
     *
     * @param month
     * @param year
     * @return
     */
    private static int getDaysFromMonths(int month, int year){

        int days=0;
        for(int i=month;i>0;i--){
            if(isLeapYear(year)){
                days+=MONTHS_LEAP[i-1];
            } else {
                days+=MONTHS_NON_LEAP[i-1];
            }

        }
        return days;
    }

    /**
     * Get number of days between years
     * Takes leap year into consideration
     * eg. 2017 as startYear and 2018 as endYear will return 730 (365+365)
     *
     * @param startYear
     * @param endYear
     * @return days count
     */
    public static int getDaysBetweenYears(int startYear, int endYear){

        int days=0;
        for(int i=startYear;i<endYear;i++){
            if(isLeapYear(i)){
                days+=DAYS_IN_YEAR+1;
            }else{
                days+=DAYS_IN_YEAR;
            }
        }
        return days;
    }

    /**
     * Check if an year is a leap year
     *
     * @param year
     * @return boolean
     */
    public static boolean isLeapYear(int year){

        if((year%400==0)||((year%4==0)&&(year%100!=0))){
            return true;
        }
        return false;
    }

    /**
     * Get day from date String
     *
     * @param date
     * @return day
     */
    public static int getDaysFromDateString(String date){
        if(validateDate(date)){
            return Integer.valueOf(date.substring(8));
        }
        throw new RuntimeException("Invalid Date Format");
    }

    /**
     * Get month from date String
     *
     * @param date
     * @return month
     */
    public static int getMonthFromDateString(String date){
        if(validateDate(date)){
            return Integer.valueOf(date.substring(5,7));
        }
        throw new RuntimeException("Invalid Date Format");
    }

    /**
     * Get year from date String
     *
     * @param date
     * @return year
     */
    public static int getYearFromDateString(String date){
        if(validateDate(date)){
            return Integer.valueOf(date.substring(0,4));
        }
        throw new RuntimeException("Invalid Date Format");
    }

    /**
     * Validates if date is in yyyy/mm/dd format
     *
     * @param date
     * @return boolean
     */
    public static boolean validateDate(String date){
        if(date!=null && !date.isEmpty()) {
            return date.matches("[0-9]{4}[-][0-9]{2}[-][0-9]{2}");
        }
        throw new RuntimeException("Date String is Null/Empty");
    }
}