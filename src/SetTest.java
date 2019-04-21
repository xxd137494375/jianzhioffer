import java.util.*;
public class SetTest {
    public static void main(String[] args) {
        TreeSet<Integer> ts = new TreeSet<>();
        HashSet<Integer>  hs = new HashSet<>();
//[240, 100, 6, 150, 520, 330]

        ts.add(100);
        ts.add(6);
        ts.add(150);
        ts.add(240);
        ts.add(330);
        ts.add(520);
        System.out.println(ts);

//        hs.add("b");
//        hs.add("a");
//        hs.add("c");
//        hs.add("d");
//        hs.add("e");
//        hs.add("f");
//        hs.add("g");
//        hs.add("h");
//        hs.add("i");
//        hs.add("j");
//        hs.add("k");
//        hs.add("l");
//        hs.add("m");
//        hs.add(",");
//        hs.add("1");
//        hs.add("3");
//        hs.add("A");
//        hs.add("B");
//        hs.add("C");

        hs.add(100);
        hs.add(6);
        hs.add(150);
        hs.add(240);
        hs.add(330);
        hs.add(520);
        System.out.println(hs);
//        Iterator <Integer> it2 = hs.iterator();
//        while(it2.hasNext()){
//            System.out.println(it2.next());
//        }
//        Map<Integer,String> hashMap = new HashMap<>();
//        Map<Integer,String> treeMap = new TreeMap<>();
//        hashMap.put(2,"two");
//        hashMap.put(1,"one");
//        hashMap.put(3,"three");
//        for(Integer i :hashMap.keySet()){
//            System.out.println(i);
//        }
//        treeMap.put(2,"two");
//        treeMap.put(1,"one");
//        treeMap.put(3,"three");
//        for(Integer i :treeMap.keySet()){
//            System.out.println(i);
//        }


    }
}
