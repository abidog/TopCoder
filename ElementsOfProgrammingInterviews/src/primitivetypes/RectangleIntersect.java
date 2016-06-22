package primitivetypes;
class Rectangle{
    int lowerLeftX;
    int lowerLeftY;
    int upperRightX;
    int upperRightY;
    public Rectangle(int lx, int ly, int ux, int uy) {
        lowerLeftX = lx;
        lowerLeftY = ly;
        upperRightX = ux;
        upperRightY = uy;
    }
    public int hashCode() {
        int hash = 31;
        hash = hash * 31 + lowerLeftX;
        hash = hash * 31 + lowerLeftY;
        hash = hash * 31 + upperRightX;
        hash = hash * 31 + upperRightY;
        return hash;
    }

    public boolean equals(Object o) {
        Rectangle rect =  (Rectangle) o;
        return rect.lowerLeftX == lowerLeftX && rect.lowerLeftY == lowerLeftY && rect. upperRightX ==  upperRightX && rect.upperRightY == upperRightY;
    }
}

public class RectangleIntersect {



    class Rectangle{
        int lowerLeftX;
        int lowerLeftY;
        int upperRightX;
        int upperRightY;
        public Rectangle(int lx, int ly, int ux, int uy) {
            lowerLeftX = lx;
            lowerLeftY = ly;
            upperRightX = ux;
            upperRightY = uy;
        }
        public int hashCode() {
            int hash = 31;
            hash = hash * 31 + lowerLeftX;
            hash = hash * 31 + lowerLeftY;
            hash = hash * 31 + upperRightX;
            hash = hash * 31 + upperRightY;
            return hash;
        }

        public boolean equals(Object o) {
            Rectangle rect =  (Rectangle) o;
            return rect.lowerLeftX == lowerLeftX && rect.lowerLeftY == lowerLeftY && rect. upperRightX ==  upperRightX && rect.upperRightY == upperRightY;
        }
    }

    public primitivetypes.Rectangle  intersect(primitivetypes.Rectangle r1, primitivetypes.Rectangle r2) {
        int lx = Math.max(r1.lowerLeftX, r2.lowerLeftX);
        int ly = Math.max(r1.lowerLeftY, r2.lowerLeftY);
        int ux = Math.min(r1.upperRightX, r2.upperRightX);
        int uy = Math.min(r1.upperRightY, r2.upperRightY);
        if (lx < ux && ly < uy) {
            return new primitivetypes.Rectangle(lx, ly, ux,  uy);
        } else {
            return null;
        }
    }
}
