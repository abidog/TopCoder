package primitivetypes;

public class PowXtoY {

    public double power(double x, int y) {
        if (y < 0) {
            return 1.0 / pow(x, y);
        } else {
            return pow(x, y);
        }
    }

    public double pow(double x, int y) {
        if (y == 0) {
            return 1;
        } else if (y == 1) {
            return x;
        } else if (y == 2) {
            return x * x;
        } else if (y % 2 == 1) {
            return pow(x, y/2) * pow(x, y/2) * x;
        } else {
            return pow(x, y/2) * pow(x, y/2);
        }
    }
}
