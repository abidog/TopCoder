// start : 6:50pm

public class AlphabetPath {

    public static void main(String[] args) {
        String[] maze = {"..............",
                "..............",
                "..............",
                "...DEFGHIJK...",
                "...C......L...",
                "...B......M...",
                "...A......N...",
                "..........O...",
                "..ZY..TSRQP...",
                "...XWVU.......",
                ".............."};
        AlphabetPath ap = new AlphabetPath();
        System.out.println(ap.doesItExist(maze));
    }

    public String doesItExist(String[] letterMaze) {
        int sx = -1;
        int sy = -1;
        for (int i = 0; i < letterMaze.length; i++) {
                if (letterMaze[i].indexOf('A') >= 0) {
                    sy = i;
                    sx = letterMaze[i].indexOf('A');
                    break;
                }
        }
        int count = 1;
        char current = 'A';
        int[] dx = {-1,1,0,0};
        int[] dy = {0,0,1,-1};
        boolean isGood = true;
        while (isGood) {
            isGood = false;
            for (int i = 0; i < 4; i++) {
                int mx = dx[i] + sx;
                int my = dy[i] + sy;

                if (mx >= 0 && my >= 0 && mx < letterMaze[0].length() && my < letterMaze.length) {
                    if (letterMaze[my].charAt(mx) == (char)(current + 1)) {
                        current++;
                        sx =  mx;
                        sy =  my;
                        count++;
                        isGood = true;
                        break;
                    }
                }
            }


        }
        if (count == 26) {
            return "YES";
        } else {
            return "No";
        }

    }
}
