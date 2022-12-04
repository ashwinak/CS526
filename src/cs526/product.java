package cs526;
import java.util.*;

public class product {
    public static int prod(int m, int n) {
        if (n==0) {
            return 0;
        }
        if (m==0) {
            return 0;
        }
        int p=0;
        n--;
        p+= m+prod(m,n);
        return p;
    }
    public static int method2(int[ ] a, int[ ] b) { // assume equal‐length arrays
        int x = 0;
        int i = 0;
        int n=a.length;
        int c1 = 0;
        int c2 = 0;
        int c3 = 0;
        while (i < n) { // n is the number of elements in each array
            int y = 0;
            int j = 0;
            c1++;
            while (j < n) {
                int k = 0;
                c2++;
                while (k <= j) {
                    y = y + a[k];
                    k = k + 1;
                    c3++;
                }
                j = j + 1;
            }
            if (b[i] == y) {
                x++;
            } i = i + 1;
        }
        return x;
    }

    // n is the length of array a
// p is an array of integers of length 2
// initial call: method3(a, n-1, p)
// initially p[0] = 0, p[1] = 0
    public static void method3(int[] a, int i, int[] p)  {
        if (i == 0) {
            p[0] = a[0];
            p[1] = a[0];
        }
        else {
            i=i-1;
            method3(a, i, p);
            if (a[i] < p[0]) {
                p[0] = a[i];
            }
            if (a[i] > p[1]) {
                p[1] = a[i];
            }
        }
    }

    // initial call: method4(a, 0, n‐1) // n is the length of array a
    public static int method4(int[] a, int x, int y) { //finding smallest int in an array.
        if (x >= y)
        {
            return a[x];
        }
        else
        {
            int z = (x + y) / 2; // integer division
            int u = method4(a, x, z);
            int v = method4(a, z+1, y);
            if (u < v) return u;
            else return v;
        }
    }
    public static long fibonacciBad(int n) {
        if (n <= 1)
            return n;
        else
            return fibonacciBad(n-2) + fibonacciBad(n-1);
    }
    public static int method5(int a, int n) {
        if (n<1) {
            return 1;
        }
        else {
            int x= n;
            while (x>=1) {
                a = a+a;
                x = x-1;
            }
            return (a +method5(a,n-1));

        }
    }
    public static int method6(int a, int b) { // this method returns integer
        if (b == 0) {
            return 1;
        }
        else {
            int x = method6(a, b/3);
            int y = 2 * x;
            if (b % 2 == 1)
                y = y + a;
            return y;
        }
    }
    public static int method7 (int m , int n ) {
        if ((m == 0) || (n == 0)) return 0;
        else if (n > 0) return m + method7(m, n - 1);
        else {
            if (m > 0) return method7(-n, m);
            else return method7(-m, -n);
        }
    }
//    public void add(int i, E e) throws IndexOutOfBoundsException {
//        int [] data = {5,6,7,8};
//        int n = data.length;
//        if (i < 0 || i >= n)
//            throw new IndexOutOfBoundsException("Illegal index: " + i);
//        if (n == data.length)
//            resize(2 * data.length); // double the capacity of array
//        for (int j=n-1; j >= i; j--)
//            data[j+1] = data[j];
//        data[i] = e;
//        n++;
//    }
    public static void main(String[] args) {
//        System.out.println(prod(8,5));
        int [] a = {33,22,55,12,66,77,88,99,100,111};
        int [] b = {5,6,7,8};
        int [] p = {9,10};
//        method2(a,b);
//        method3(a,a.length-1,p);
        int k = method4(a,0,a.length-1);

//        int q = method5(2,3);
//        System.out.println(q);
//        System.out.println(method6(2,11));
//        System.out.println(k);
//        int o = method7(-2,-5);
//        System.out.println(o);
//        fibonacciBad(10);
        {
            // create a ArrayList String type
//            ArrayList<Integer> gfg = new ArrayList<Integer>();
//            gfg.add(42);
//            gfg.add(16);
//            gfg.add(13);
//            gfg.add(27);
//            gfg.add(31);
//            gfg.add(5);
//            System.out.println("ArrayList : " + gfg);
//            // print ArrayList
//            ListIterator<Integer> listIter;
//            listIter = gfg.listIterator();
//            listIter.add(10);
//            int c = listIter.next();
//            listIter.add(20);
//            c = listIter.previous();
//            c = listIter.previous();
//            listIter.remove();
//            System.out.println("Next is : " + listIter.next());
//            System.out.println("ArrayList : " + gfg);
        }
    }
}
