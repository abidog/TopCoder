public class MagicalSquare {

    public long getCount(String[] rowStrings, String[] columnStrings) {

        // Precalculate the comparison:
        // precalc[z] [a][x] [b][y] is true if
        // row_a.substr(x,z) == col_b.substr(y,z)

        boolean[][][][][] precalc = new boolean[51][3][51][3][51];

        for (int a=0; a<3; a++) {
            for (int b=0; b<3; b++) {
                for (int z=0; z<=50; z++) {
                    for (int x=0; x+z<=rowStrings[a].length(); x++) {
                        for (int y=0; y+z<=columnStrings[b].length(); y++) {
                            precalc[z][a][x][b][y] =
                                    (rowStrings[a].substring(x, z) == columnStrings[b].substring(y, z));
                        }
                    }
                }
            }
        }

        int res = 0;
        for (int a=0; a<=rowStrings[0].length(); a++) {
            for (int b=0; b+a<=rowStrings[0].length(); b++) {
                for (int x=0; x<=rowStrings[1].length() && a+x<=columnStrings[0].length(); x++) {
                    for (int y=0; x+y<=rowStrings[1].length() && b+y<=columnStrings[1].length(); y++) {
                        int c = rowStrings[0].length() - a - b;
                        int z = rowStrings[1].length() - x - y;

                        // String row0[0..a]+row1[0..x] must be a prefix of
                        //        column0.
                        if ( !( precalc[a] [0][0] [0][0]  && precalc[x] [1][0] [0][a] ) ) {
                            continue;
                        }

                        // String row0[a..b]+row1[x..y] must be a prefix of
                        //        column1.
                        if ( !( precalc[b] [0][a] [1][0]  && precalc[y] [1][x] [1][b] ) ) {
                            continue;
                        }

                        // String row0[a+b..c]+row1[x+y..z] must be a prefix of
                        //        column2.
                        if ( !( precalc[c] [0][a+b] [2][0]  && precalc[z] [1][x+y] [2][c] ) ) {
                            continue;
                        }

                        // String col0[a+x..] + col1[b+y..] + col2[c+z..]
                        // must be equal to row2
                        int l0 = columnStrings[0].length() - a - x;
                        int l1 = columnStrings[1].length() - b - y;
                        int l2 = columnStrings[2].length() - c - z;

                        if ( l0 + l1 + l2 !=  rowStrings[2].length() ) {
                            continue;
                        }

                        if ( ! precalc[l0] [2][0] [0][a+x]  ) {
                            continue;
                        }
                        if ( ! precalc[l1] [2][l0] [1][b+y]  ) {
                            continue;
                        }
                        if ( ! precalc[l2] [2][l0+l1] [2][c+z]  ) {
                            continue;
                        }
                        res++;
                    }
                }
            }
        }
        return res;
    }
}
