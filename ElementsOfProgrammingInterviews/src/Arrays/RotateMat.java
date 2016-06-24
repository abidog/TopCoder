package Arrays;

public class RotateMat {

    public static void main(String[] args) {
        RotateMat rm = new RotateMat();
        int[][] mat = {{1,2,3,4},{5,6,7,8}, {9, 10,11,12}, {13,14,15,16}};
        rm.rotateMat(mat);
    }

    public void rotateMat(int[][] mat) {
        int n = mat.length - 1;
        for (int layer = 0; layer < mat.length / 2; layer++) {
            for (int i = layer; i < n - layer; i++) {
                int temp = mat[layer][i];
                mat[layer][i] = mat[n - i][layer];
                mat[n - i][layer] = mat[n - layer][n - i];
                mat[n - layer][n - i] = mat[i][n - layer];
                mat[i][n - layer] = temp;
            }
        }
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat.length; j++) {
                System.out.print(mat[i][j] + " ");
            }
            System.out.println();
        }
    }
}
