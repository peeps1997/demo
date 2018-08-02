import java.util.*;
public class CollectionExample implements Comparator < String > {


    public static void main(String args[]) {
        int i = 0;

        List < String > strListArray = new ArrayList < String > ();
        List < String > strListLinked = new ArrayList < String > ();
        HashMap < Integer, String > strMap = new HashMap < Integer, String > ();
        if (strListArray.isEmpty())
            if (strMap.isEmpty())
                System.out.println("List n map empty");
        while (i < 10) {
            strListArray.add("string Array List" + i);
            strListLinked.add("string Linked List" + i);
            strMap.put(i, "string Map " + i);
            i++;
        }

        if (strListArray.contains("string Array List1")) {
            System.out.println("strListArray contains " + strListArray.get(1));
        }
        if (strListArray.equals(strListLinked)) {
            System.out.println("strList equivalent to strLinked List");
        }
        Set set = strMap.entrySet();
        Iterator j = set.iterator();
        Iterator x = strListArray.iterator();

        System.out.println("strMap hashcode: " + strMap.hashCode());
        System.out.println("Set :" + set);
        Collections.shuffle(strListLinked);
        Collections.shuffle(strListArray);
        Collections.sort(strListLinked, new CollectionExample());
        Iterator y = strListLinked.iterator();
        while (j.hasNext()) {

            System.out.println("StrList Map " + j.next());
            j.remove();
            System.out.println("StrList Array " + x.next());
            x.remove();
            System.out.println("StrList Linked " + y.next());
            y.remove();
        }
        if (strListArray.isEmpty()) {
            System.out.println("Array List empty");
        }

        if (strMap.isEmpty()) {
            System.out.println("Map empty");
        }
    }

    @Override
    public int compare(String arg0, String arg1) {

        return arg0.compareTo(arg1);
    }
}