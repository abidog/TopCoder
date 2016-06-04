// start : 2:26pm
// end :

public class RotatedClock {

    public static void main(String[] args) {
        RotatedClock rc = new RotatedClock();
        System.out.println(rc.getEarliest(315, 90));
    }

    public String getEarliest(int hourHand, int minuteHand) {

        for(int mark = 0; mark < 360; mark += 30)
        {
            int hour = (hourHand + mark) % 360;
            int minute = (hour*12)%360; // minute hand moves 12 times faster
            if( minute==(minuteHand+mark)%360)
            {
                hour = hour / 30;
                minute = minute / 6;
                return String.format("%02d:%02d", hour, minute);
            }
        }
        return "";
    }
}
