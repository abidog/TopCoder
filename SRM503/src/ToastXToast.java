import java.util.Arrays;

public class ToastXToast {
    public static void main(String[] args) {
        ToastXToast txt = new ToastXToast();
        int[] under = 	 {1267, 31326, 31584, 40868, 52412, 90150, 99701, 101201, 112054, 137711, 155982, 159216, 178057, 200511, 204038, 212231, 212943, 225291, 225988, 247840, 251164, 253443, 266872, 269177, 273752, 294518, 306554, 308742, 312880, 322800, 329077, 331994, 353189, 354613, 362268, 364661, 381150, 403304, 419068, 430213, 432639, 434694, 446168, 447790, 449449, 452622, 455963, 495075, 504307};
        int [] over ={504487, 516046, 524289, 544297, 567001, 575499, 588506, 589028, 592645, 629478, 629593, 636874, 648333, 650008, 662400, 664978, 670958, 692281, 708426, 712257, 737798, 738945, 748971, 757552, 765540, 770935, 785624, 796438, 796574, 800703, 818476, 828397, 831102, 844143, 847481, 847821, 862603, 863554, 889334, 892808, 937125, 944639, 959137, 962705, 972476, 975100, 976024, 978282, 978331};
       System.out.println(txt.bake(under, over));
    }

    public int bake(int[] undertoasted, int[] overtoasted) {
        Arrays.sort(undertoasted);
        Arrays.sort(overtoasted);

        if (undertoasted[0] >= overtoasted[0]) {
            return -1;
        }
        if (undertoasted[undertoasted.length - 1] < overtoasted[0]) {
            return 1;
        }
        return 2;

    }
}