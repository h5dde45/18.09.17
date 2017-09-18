package p1;

import java.util.*;

public class T3 {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        List<String> firstStr= new ArrayList<>();
        Map<String, Integer> mapSum = new HashMap<>();
        Map<Integer, String> mapSort = new TreeMap<>();

        Scanner scanner = new Scanner(System.in);
        int num = 5;//100

        for (int i = 0; i < num; i++) {
            String s = scanner.nextLine();
            firstStr.add(s);
            String[] strings = s.split(" - ");

            switch (strings[2]) {
                case "1:0":
                    list.add(strings[0] + " " + 2);
                    list.add(strings[1] + " " + 0);
                    break;
                case "0:1":
                    list.add(strings[1] + " " + 2);
                    list.add(strings[0] + " " + 0);
                    break;
                case "0.5:0.5":
                    list.add(strings[0] + " " + 1);
                    list.add(strings[1] + " " + 1);
            }
        }

        int sum = 0;
        for (String s : list) {
            String[] str = s.split(" ");
            if(mapSum.get(str[0])!=null) {
                sum = mapSum.get(str[0]) + Integer.parseInt(str[1]);
                mapSum.put(str[0], sum);
            }else {
                mapSum.put(str[0], Integer.parseInt(str[1]));
                sum=Integer.parseInt(str[1]);
            }
        }

        System.out.println(list);
        System.out.println(mapSum);
        System.out.println("*********************");

        for(String s:firstStr){
            System.out.println(s);
        }
        System.out.println("*********************");

        for(Map.Entry<String, Integer> set: mapSum.entrySet()){
            mapSort.put(set.getValue(),set.getKey());
        }

        TreeMap<Integer, String> mapIndex = new TreeMap<>();
        int i=1;
        for(Map.Entry<Integer, String> set: mapSort.entrySet()){
            mapIndex.put(i++,set.getValue());
        }

        System.out.println(mapSum);
        System.out.println(mapSort);
        System.out.println(mapIndex);
        System.out.println("************************");

        i=1;

        for(Map.Entry<String, Integer> set: mapSum.entrySet()){
            System.out.println();

            System.out.println("|"+i+"| "+set.getKey()+" | "+set.getValue()+
            " | " +i);
            i++;
        }
    }

}

