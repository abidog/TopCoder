public class NetworkXZeroOne {

    public static void main(String[] args) {
        String s = "???????x"
                ;
        NetworkXZeroOne n = new NetworkXZeroOne();
        System.out.println(n.reconstruct(s));
    }
    public String reconstruct(String message) {

        int x = 0;
        int o = 0;
        int unKnown= 0;
        for (int i = 0; i < message.length(); i++) {
            if (message.charAt(i) == 'x') {
                x++;
            } else if (message.charAt(i) == 'o') {
                o++;
            } else {
                unKnown++;
            }
        }
        int difx = 0;
        int difo = 0;
        if (x > o) {
            difo = x-o;
        } else {
            difx = o-x;
        }
        char[] mes = message.toCharArray();
        if (difx == 0) {
            for (int i = 0; i < mes.length; i++) {
                if (difo == 0) {
                    break;
                }
                if (mes[i] == '?') {
                    mes[i] = 'o';
                    difo--;
                    unKnown--;
                }

            }

        }
        if (difo == 0) {
            for (int i = 0; i < mes.length; i++) {
                if (difx == 0) {
                    break;
                }
                if (mes[i] == '?') {
                    mes[i] = 'x';
                    difx--;
                    unKnown--;
                }

            }
        }
        if (unKnown > 0) {
            boolean alternate = true;
            for (int i = 0; i < mes.length; i++) {
                if (mes[i] == '?' && alternate) {
                    mes[i] = 'o';
                    alternate = false;
                } else if (mes[i] == '?') {
                    alternate = true;
                    mes[i] = 'x';

                }
            }
        }
        return new String(mes);
    }
}
