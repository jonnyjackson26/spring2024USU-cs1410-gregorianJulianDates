public class JulianDate extends Date {
    public JulianDate() {
        super(1,1,1);
        this.addDays(719164); //makes it jan 1, 1970 (gregorian)
        long msSince = System.currentTimeMillis()+java.util.TimeZone.getDefault().getRawOffset();
        long daysSince=msSince/86400000;
        this.addDays((int) daysSince);
    }
    public JulianDate(int year, int month, int day) {
        super(year,month,day);
    }

    public void addDays(int days) {
        for(int i=0; i<days; i++) {
            super.setDay(super.getDay()+1);
            if(super.getDay()>getNumberOfDaysInMonth(super.getYear(),super.getMonth())) {
                super.setDay(1);
                super.setMonth(super.getMonth()+1);
                if(super.getMonth()==13) {
                    super.setMonth(1);
                    super.setYear(super.getYear()+1);
                }
            }
        }
    }

    public void subtractDays(int days) {
        for(int i=0; i<days; i++) {
            super.setDay(super.getDay()-1);
            if(super.getDay()==0) {
                super.setMonth(super.getMonth()-1);
                if(super.getMonth()==0) {
                    super.setMonth(12);
                    super.setYear(super.getYear()-1);
                }
                super.setDay(getNumberOfDaysInMonth(super.getYear(),super.getMonth()));
            }
        }
    }

    public boolean isLeapYear(int year) {
        return year%4==0;
    }

}