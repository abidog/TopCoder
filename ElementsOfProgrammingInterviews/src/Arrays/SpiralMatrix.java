package Arrays;

public class SpiralMatrix{
    public void spiral(int[][] mat) {
        for (int i = 0; i < mat.length / 2; i++) {
            printMat(i, mat);
        }
    }
    private void printMat(int offSet, int[][] mat) {
        if (offSet == mat.length - offSet - 1) {
            System.out.println( mat[offSet][offSet]);
            return;
        }
        for (int i = offSet; i < mat.length - offSet - 1; i++) {
            System.out.println(mat[offSet][i]);
        }
        for (int i = offSet; i < mat[0].length - offSet - 1; i++) {
            System.out.println(mat[i][mat[0].length - offSet - 1]);
        }
        for (int i = mat.length - offSet - 1; i > offSet; i--) {
            System.out.println(mat[mat.length - offSet - 1][i]);
        }
        for (int i = mat.length - offSet - 1; i > offSet; i--) {
            System.out.println(mat[i][offSet]);
        }
    }
}
