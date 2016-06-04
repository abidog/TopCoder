public class TrainingCamp {


    public static void main(String[] args) {
        String[] att = {"-XXXX",
                "----X",
                "XXX--",
                "X-X-X"};
        String[] pro = {"X---X",
                "-X---",
                "XXX--",
                "--X--"};



        TrainingCamp tc = new TrainingCamp();
        String[] res = tc.determineSolvers(att, pro);
        for (int i = 0; i < res.length; i++) {
            System.out.println(res[i]);
        }


    }

    public String[] determineSolvers(String[] attendance, String[] problemTopics) {

        char[][] map = new char[attendance.length][problemTopics.length];


        for (int i = 0; i < attendance.length; i++) {
                // check this student is able to solve all the problems
            String attended = attendance[i];
            for (int j = 0; j < problemTopics.length; j++) {
                String required = problemTopics[j];
                boolean failed = false;
                for (int k = 0; k < required.length(); k++) {
                    if (required.charAt(k) == 'X' && attended.charAt(k) != 'X') {
                        failed = true;
                        break;
                    }
                }
                if (!failed) {
                    map[i][j] = 'X';
                } else {
                    map[i][j] = '-';
                }

            }
            
        }
        String[] res = new String[attendance.length];
        for (int i = 0; i < attendance.length; i++) {
            res[i] = new String(map[i]);
        }
        return res;
    }
}
