public class DucksAlignment {

    public static void main(String[] args) {
        DucksAlignment da = new DucksAlignment();
        String[] grid = {"...o..........................",
                "............................o.",
                ".o............................",
                "............o.................",
                ".................o............",
                "......................o.......",
                "......o.......................",
                "....o.........................",
                "...............o..............",
                ".......................o......",
                "...........................o..",
                ".......o......................"};
        System.out.println(da.minimumTime(grid));
    }

    public int minimumTime(String[] grid) {

        int res = Integer.MAX_VALUE;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length(); j++) {
                int dis = 0;
                int leftDuck = 0;
                int rightDuck = 0;
                // align row base
                for (int k = j; k >= 0; k--) {
                    // check this column if it has a duck
                    for (int r = 0; r < grid.length; r++) {
                        if (grid[r].charAt(k) == 'o') {
                            dis += j - k + Math.abs(r -i) - leftDuck;
                            leftDuck++;
                        }
                    }
                }
                rightDuck = leftDuck > 0 ? 1 : 0;
                for (int k = j+1; k  < grid[0].length(); k++) {
                    // check this column if it has a duck
                    for (int r = 0; r < grid.length; r++) {
                        if (grid[r].charAt(k) == 'o') {
                            dis += k - j + Math.abs(r -i) - rightDuck;
                            rightDuck++;
                        }
                    }
                }


                res = Math.min(res, dis);


                // align them in column base

                int upperDuck = 0;
                int lowerDuck = 0;
                dis  = 0;
                for (int upperRow = i; upperRow >= 0 ; upperRow--) {
                    for (int column = 0; column < grid[0].length(); column++) {
                        if (grid[upperRow].charAt(column)=='o') {
                            dis += i - upperRow - upperDuck;
                            upperDuck++;
                            dis += Math.abs(column - j);
                        }
                    }

                }
                lowerDuck = upperDuck > 0 ? 1 : 0;
                for (int lowerRow = i + 1; lowerRow < grid.length ; lowerRow++) {
                    for (int column = 0; column < grid[0].length(); column++) {
                        if (grid[lowerRow].charAt(column)=='o') {
                            dis += lowerRow - i - lowerDuck;
                            lowerDuck++;
                            dis += Math.abs(column - j);
                        }
                    }

                }
                res = Math.min(res, dis);

            }

        }
        return res;
    }
}
