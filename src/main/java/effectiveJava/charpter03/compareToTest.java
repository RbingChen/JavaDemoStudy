package effectiveJava.charpter03;

public class compareToTest implements Comparable<compareToTest>{
    public int a ;
    public compareToTest(int a){this.a=a;}
    public int compareTo(compareToTest obj){
          if(this.a>obj.a)
              return 1;
          else if(this.a==obj.a)
              return 0;
          else
              return -1;
    }
}
