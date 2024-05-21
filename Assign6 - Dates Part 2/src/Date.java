public abstract class Date {
    private int year;
    private int month;
    private int day;

    private static String[] monthNames = {
            "January", "February", "March", "April", "May", "June",
            "July", "August", "September", "October", "November", "December"
    };

    public Date(int year, int month, int day) {
        this.month=month;
        this.year=year;
        this.day=day;
    }

    public abstract void addDays(int days);

    public abstract void subtractDays(int days);

    public abstract boolean isLeapYear(int year);

    public boolean isLeapYear() {
        return isLeapYear(this.year);
    }

    public void printShortDate() { // mm/dd/yyyy
        System.out.printf("%d/%d/%d", this.month, this.day, this.year);
    }

    public void printLongDate() {
        System.out.printf("%s %d, %d", monthNames[this.month - 1], this.day, this.year);
    }

    public String getMonthName() {
        return monthNames[this.month-1];
    }

    public int getDayOfMonth() {
        return this.day;
    }

    public int getNumberOfDaysInMonth(int year, int month) {
        switch (month) {
            case 1:  // January
            case 3:  // March
            case 5:  // May
            case 7:  // July
            case 8:  // August
            case 10: // October
            case 12: // December
                return 31;
            case 4:  // April
            case 6:  // June
            case 9:  // September
            case 11: // November
                return 30;
            case 2:  // February
                if (isLeapYear(year))
                    return 29;
                else
                    return 28;
            default:
                return -1; // Invalid month
        }
    }

    private int getNumberOfDaysInYear(int year) {
        if(isLeapYear(year)) {
            return 366;
        }
        return 365;
    }
    private String getMonthName(int month) {
        return monthNames[month-1];
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getYear() {
        return this.year;
    }

    public int getMonth() {
        return this.month;
    }

    public int getDay() {
        return this.day;
    }


}