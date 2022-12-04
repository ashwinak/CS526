package java_concepts;

public class MainTester{
    public static void main(String [] args)
    {
        BottomClass b = new BottomClass();
        b.method3();
//        int i = 0;
//        int j = 0;
//        while(i <= 10) {
//            j = j + 1; // 1
//            i = i + 1; // 1 2 3 4 5 6 7 8 9 10 11
//        }
//
//        System.out.println(i);
//        System.out.println(j);
        int [] x = {1,3,4,8,2};
        int y = 0;
        for(int i = 0; i < x.length;i++)
        {
            if (x[i]%2==0) {
                y = y + x[i];
                System.out.println("if " + y);
            }
            else {
                y = y - x[i];
                System.out.println("else " + y);
            }
        }

        System.out.println(y);

    }

}
