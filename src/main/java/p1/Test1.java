package p1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Test1 {
    public static void main(String[] args) {

        Scanner scanner=new Scanner(System.in);
        String s= scanner.nextLine();

//        int count=scanner.nextInt();
        System.out.println();
        String[] strings;//=new int[count];

        strings=s.split(" ");
        int[] ints=new int[strings.length];
        List<Integer> p=new ArrayList<Integer>();
        List<Integer> v=new ArrayList<Integer>();

        for (int i = 0; i < ints.length; i++) {
            ints[i]=Integer.parseInt(strings[i]);
            if(i%2==0){
                p.add(ints[i]);
            }else {
                v.add(ints[i]);
            }
        }
//        System.out.println(p);
//        System.out.println(v);
        int ps = 0;
        int vs=0;
        for (int i:p){
            ps+=i;
        }
        for (int i:v){
            vs+=i;
        }
//        System.out.println(ps);
//        System.out.println(vs);

        if(ps>vs){
            System.out.println("Petya");
        }else if(ps<vs){
            System.out.println("Vasya");
        }else {
            int random = 1;

            if (p.get(random) > v.get(random)) {
                System.out.println("Petya");
            } else {
                System.out.println("Vasya");
            }
        }
    }
}
