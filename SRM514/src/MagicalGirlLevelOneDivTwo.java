public class MagicalGirlLevelOneDivTwo {

    public static void main(String[] args) {
        MagicalGirlLevelOneDivTwo mg = new MagicalGirlLevelOneDivTwo();
        int d = 345;
        int x = -471;
        int y = 333;
        System.out.println(mg.theMinDistance(d, x,y));
    }

    public double theMinDistance(int d, int x, int y) {
        int posX = -1;
        int posY = -1;
        if (x >= 0 && y >= 0) {
            posX = Math.max(0, x-d);
            posY = Math.max(0, y - d);

        } else if (x <= 0 && y >= 0) {
            posX = Math.min(x + d, 0);
            posY = Math.max(0, y-d);
        } else if (x <= 0 && y <= 0) {
            posX = Math.min(x + d, 0);
            posY = Math.min(0, y + d);
        } else {
            posX = Math.max(0, x-d);
            posY = Math.min(0, y + d);
        }
        return Math.sqrt(posX * posX + posY * posY);
    }
}
