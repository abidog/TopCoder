import java.util.*;

public class WhichDay {

    public static void main(String[] args) {
        String [] not = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday"};
        WhichDay wd = new WhichDay();
        System.out.println(wd.getDay(not));
    }

    public String getDay(String[] notOnThisDay) {
        Set<String> set = new HashSet<>();

        String[] days = {"Saturday","Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday"};
        for (String s : days) {
           set.add(s);
        }
        for (String s : notOnThisDay) {
            set.remove(s);
        }

        return set.iterator().next();

    }
}
