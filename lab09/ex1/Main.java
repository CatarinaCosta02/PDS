package ex1;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        VectorGeneric<Integer> v = new VectorGeneric<Integer>();

        // add some elements to the vector
        v.addElem(1);
        v.addElem(2);
        v.addElem(3);
        v.addElem(4);
        v.addElem(5);
        v.addElem(6);
        v.addElem(7);

        // Iterator test
        System.out.println("Iterator test:");
        Iterator<Integer> it = v.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
        System.out.println();
        
        // ListIterator test
        System.out.println("ListIterator test:");
        ListIterator<Integer> lit = v.listIterator();
        while (lit.hasNext()) {
            System.out.println(lit.next());
        }
        System.out.println();

        // ListIterator test with index
        System.out.println("ListIterator test with index:");
        // starts at index 2
        ListIterator<Integer> lit2 = v.listIterator(2);
        while (lit2.hasNext()) {
            System.out.println(lit2.next());
        }
        System.out.println();

        // Test Iterator and ListIterator at the same time

        System.out.println("Test Iterator and ListIterator at the same time:");
        Iterator<Integer> it2 = v.iterator();
        ListIterator<Integer> lit3 = v.listIterator(2);
        while (it2.hasNext() && lit3.hasNext()) {
            System.out.println(it2.next());
            System.out.println(lit3.next());
        }
        System.out.println();
    }

    
}
