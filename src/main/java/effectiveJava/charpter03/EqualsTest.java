package effectiveJava.charpter03;

public class EqualsTest {
    public static void main(String args[]){
        Long a = new Long(10);
        Long b = new Long(10);
        System.out.println(a==b);
        System.out.println(a.equals(b));
        System.out.println("a.hashCode : "+a.hashCode()+" ; b.hashCode : "+ b.hashCode());
        compareToTest ca = new compareToTest(10);
        compareToTest cb = new compareToTest(12);

    }
}
