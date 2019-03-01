package Date;

/*
 *   This class is a Date ADT. The date's month, day, and year are represented
 *   as integers (for example, 5/15/2011). There are three methods; one will
 *   advance the date by one day. The two other methods will be used to display the date
 *   by using either numbers (05/16/2011) or words for the month (May 16, 2011).
 * */
public class Date {
    // Data fields for Date
    private int month_;
    private int day_;
    private int year_;

    // Constructor to initialize a Date with no params
    public Date() {
        month_ = 1;
        day_ = 1;
        year_ = 0;
    }

    // Constructor to initialize a Date with values from user
    public Date(int month, int day, int year) {
        month_ = month;
        day_ = day;
        year_ = year;
    }

    // Method to return month
    public int month() {
        return month_;
    }

    // Method to return day
    public int day() {
        return day_;
    }

    // Method to return year
    public int year() {
        return year_;
    }

    // Method to advance the date by one day
    public void advanceByOneDay() {
        // Determine if the month is a month with 31 days
        if (month_ == 1 || month_ == 3 || month_ == 5 || month_ == 7 || month_ == 8 || month_ == 10 || month_ == 12) {
            // Increase by one if it's day 30
            if (day_ == 30) {
                day_++;
            // If it is month 12 and day 31, change month and day to 1, and increase year by 1
            } else if (day_ == 31 && month_ == 12) {
                month_ = 1;
                day_ = 1;
                year_++;
            // If it's not month 12 but any other month with 31 days, change day to 1 and increase month by one
            } else if (day_ == 31) {
                month_++;
                day_ = 1;
            // If it's a regular day 1-29, just increase the day by 1
            } else {
                day_++;
            }
        // If the month is a month with 30 days
        } else if (month_ == 4 || month_ == 6 || month_ == 9 || month_ == 11) {
            // And if it is day 29, increase the day by 1
            if (day_ == 29) {
                day_++;
            // If it is day 30, increase the month by one and reset day to 1
            } else if (day_ == 30) {
                month_++;
                day_ = 1;
            // Otherwise just increase the day by one
            } else {
                day_++;
            }
        // Otherwise it is February
        } else {
            // If the day is 27, increase the day by one
            if (day_ == 27) {
                day_++;
            // If it is day 28, increase the month by one and reset the day to 1
            } else if (day_ == 28) {
                day_ = 1;
                month_++;
            // Otherwise, just increase the day by one
            } else {
                day_++;
            }
        }
    }

    // Method to display date in int format
    public void displayIntFormat() {
        // if month or day is single digit add needs leading 0
        String formattedMonth;
        String formattedDay;

        // Need to determine if month or day is a single digit month or day, if it is then add a leading 0
        if ((month_ > 0 && month_ < 10) && (day_ > 0 && day_ < 10)) {
            formattedMonth = ("0" + month_);
            formattedDay = ("0" + day_);
            System.out.println(formattedMonth + "/" + formattedDay + "/" + year_);
        // If it is only the month that is a single digit, then add a leading 0 and leave the day alone
        } else if (month_ > 0 && month_ < 10) {
            formattedMonth = ("0" + month_);
            System.out.println(formattedMonth + "/" + day_ + "/" + year_);
        // If it is only the day that is a single digit, then add a leading 0 to day and leave the month alone
        } else if (day_ > 0 && day_ < 10) {
            formattedDay = ("0" + day_);
            System.out.println(month_ + "/" + formattedDay + "/" + year_);
        // Otherwise, leave the double digit month and day alone
        } else {
            System.out.println(month_ + "/" + day_ + "/" + year_);
        }
    }

    // Method to display data in month format (May 14, 2001)
    public void displayMonthFormat() {
        // monthString for switch statement values
        String monthString;

        // Switch on the month_ data field
        switch(month_) {
            case 1:
                monthString = "January"; // assign each integer value to its equivalent month value
                break;
            case 2:
                monthString = "February";
                break;
            case 3:
                monthString = "March";
                break;
            case 4:
                monthString = "April";
                break;
            case 5:
                monthString = "May";
                break;
            case 6:
                monthString = "June";
                break;
            case 7:
                monthString = "July";
                break;
            case 8:
                monthString = "August";
                break;
            case 9:
                monthString = "September";
                break;
            case 10:
                monthString = "October";
                break;
            case 11:
                monthString = "November";
                break;
            case 12:
                monthString = "December";
                break;
            default:
                monthString = "Invalid month";
        }
        // Print the month, day and year like "May 5, 1999"
        System.out.println(monthString + " " + day_ + ", " + year_);
    }
}
