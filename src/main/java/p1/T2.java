package p1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class T2 {
    public static void main(String[] args) {
        int n = 0;
        int k =89;// Integer.MAX_VALUE;
        int s = 0;
        int c = 0;
        List<Integer> list = new ArrayList<>();

        for (int i = 1; i < k; i++) {
            s = 0;
            int t = i;
            while (t > 0) {
                c = t % 10;
                s += c;
                t /= 10;
            }

            n = k / s;
            if (n > 0) {
                list.add(n);
            }
        }
        Collections.sort(list);
        System.out.println(list);
        System.out.println(list.get(0));
    }
}
