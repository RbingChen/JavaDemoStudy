package code2022;

// Ok
public class P6 {
    public static int numOfExam(String inTime, String outTime) {
        String[] inHourMin = inTime.split(":");
        String[] outHourMin = outTime.split(":");
        int examNum = 2*(Integer.parseInt(outHourMin[0]) - Integer.parseInt(inHourMin[0]) - 1);
        if(Integer.parseInt(inHourMin[1]) == 0){
            examNum += 2;
        } else if (Integer.parseInt(inHourMin[1]) <= 30){
            examNum += 1;
        }
        if(Integer.parseInt(outHourMin[1]) >= 30){
            examNum += 1;
        }
        if(examNum < 0){
            examNum += 48;
        }
        return examNum;
    }
    public static void main(String args[]){
        String in = "08:35";
        String out = "09:40";
        System.out.println(numOfExam(in,out));
        String in1 = "20:00";
        String out2 = "08:00";
        System.out.println(numOfExam(in1,out2));
    }


}
