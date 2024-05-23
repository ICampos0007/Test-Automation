package Streams;

import org.testng.Assert;
import org.testng.annotations.Test;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Test1 {
    @Test(enabled = false)
    public void regular() {
        ArrayList<String> names = new ArrayList<>();
        names.add("Miya");
        names.add("Cozy");
        names.add("Jaymee");
        names.add("Irvin");
        names.add("Nora");
        names.add("Mia");
        int count = 0;

        for (int i = 0; i< names.size(); i++) {
            String actual = names.get(i);
            if (actual.startsWith("M")){
                count++;
            }
        }
        System.out.println(count);
    }

    @Test(enabled = false)
    public void streamFilter() {
        ArrayList<String> names = new ArrayList<>();
        names.add("Miya");
        names.add("Cozy");
        names.add("Jaymee");
        names.add("Irvin");
        names.add("Nora");
        names.add("Mia");
        int count = 0;
//      there is no life for intermediate op if there is no terminal op
//      terminal operation will execute only if inter op (filter) returns true
//      we can create stream
//      how to use filter in Stream API
        Long c = names.stream().filter(m ->m.startsWith("M")).count();
        System.out.println(c);

       Long stream =  Stream.of("Miya","Cozy","Jaymee","Irvin","Nora","Mia").filter(m ->
                m.startsWith("M")).count();

       System.out.println(stream);
//     print all the names in the arraylist
//       names.stream().forEach(System.out::println);
        names.stream().filter(s -> s.length()>4).forEach(System.out::println);
        names.stream().filter(s -> s.length()>4).limit(1).forEach(System.out::println);

    }

    @Test(enabled = false)
    public void streamMap() {
        ArrayList<String> names = new ArrayList<>();
        names.add("Man");
        names.add("Don");
        names.add("Woman");
//        print names which ends as a with uppercase
        Stream.of("Miya","Cozy","Jaymee","Irvin","Nora","Mia").filter(m ->
                m.endsWith("a")).map(m->m.toUpperCase())
        .forEach(System.out::println);
//        print names which have first letter as m with uppercase and sorted
        List<String>namesOne = Arrays.asList("Miya","Cozy","Jaymee","Irvin","Nora","Mia");
        namesOne.stream().filter(s -> s.startsWith("M")).sorted().map(s -> s.toUpperCase()).forEach(System.out::println);
//      merging 2 different lists
        Stream<String> newString =Stream.concat(names.stream(),namesOne.stream());
//        newString.sorted().forEach(System.out::println);

        boolean flag =  newString.anyMatch(s -> s.equalsIgnoreCase("Miya"));
        Assert.assertTrue(flag);
    }
    @Test
    public void streamCollect() {
        List<String> ls = Stream.of("Miya","Cozy","Jaymee","Irvin","Nora","Mia").filter(m ->
                m.endsWith("a")).map(m->m.toUpperCase()).collect(Collectors.toList());
        System.out.println(ls.get(0));

//
        List<Integer> values = Arrays.asList(3,2,2,7,5,1,9,7);
//        print unique numbers from this array
//        sort the array - get number 3  1 2 3 5 7 9
//        values.stream().distinct().forEach(System.out::println);
        List<Integer> li = values.stream().distinct().sorted().collect(Collectors.toList());
        System.out.println(li.get(2));

    }
}
