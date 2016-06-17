import java.util.*;
import java.math.*;
import static java.lang.Math.*;
import java.util.*;


public class Suminator {

    class Node{
        boolean hasX;
        long val;
        public Node(long v, boolean x) {
            val = v;
            hasX = x;
        }
    }

    public static void main(String[] args) {
        int[] program = new int[] {279808452, 620805437, 83635404, 838871679, 857178021, 691041863, 84348544, 575676690, 0, 910430492, 0, 215400751, 238179932, 0, 525142367, 0, 0, 0, 11990241, 957341740, 0, 0, 934141887, 418006881, 0, 267811800, 555461679, 0, 432168824, 835612860, 0, 0, 0, 568807639, 201562867, 0, 47484219, 0, 0, 934223454, 110523480, 0, -1, 0};
        int wantedResult = 925423618;
        System.out.println(new Suminator().findMissing(program, wantedResult));
    }

	public int findMissing(int[] program, int wantedResult) {

        // x can be zero or non zero
        int[] cp = Arrays.copyOf(program, program.length);
        for (int i = 0; i < cp.length; i++) {
            if (cp[i] == -1) {
                cp[i] = 0;
                break;
            }
        }
        long res = simulate(cp);
        if (res == wantedResult) {
            return 0;
        }
        Stack<Node> stack = new Stack<>();
        for (int i = 0; i < program.length; i++) {
            if (program[i] == 0) {
                Node a = new Node(0, false);
                Node b = new Node(0, false);
                if (!stack.isEmpty()) {
                    a = stack.pop();
                }
                if (!stack.isEmpty()) {
                    b = stack.pop();
                }
                stack.push(new Node(a.val + b.val, a.hasX || b.hasX));
            } else if (program[i] == -1) {
                Node val = new Node(0, true);
                stack.push(val);
            } else {
                stack.push(new Node(program[i], false));
            }
        }
        if (stack.isEmpty()) {
            return 0;
        }
        // x + need.val = wantedResilt
        Node need = stack.pop();
        if (need.hasX) {
            if (wantedResult == need.val) {
                return -1;
            }
            long x = wantedResult - need.val;
            if (x <= 0) {
                return -1;
            }
            return (int)x;
        } else {

            if (need.val != wantedResult) {
                return -1;
            }
        }
        return -1;
	}

    public long simulate(int[] program) {

        Stack<Long> stack = new Stack<>();

        for (int i = 0; i < program.length; i++) {
            if (program[i] == 0) {
                long a = 0;
                long b = 0;
                if (!stack.isEmpty()) {
                    a = stack.pop();
                }
                if (!stack.isEmpty()) {
                    b = stack.pop();
                }
                stack.push(a + b);
            } else {
                stack.push((long)program[i]);
            }
        }
        if (stack.isEmpty()) {
            return 0;
        } else {
            return stack.pop();
        }

    }
}
