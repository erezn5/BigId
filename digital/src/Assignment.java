import java.util.Scanner;

public class Assignment {
    static Scanner sc=new Scanner(System.in);

    public static void main(String[] args) {
        int input = 0;
        double sum =0, i=0;

        while (true){
            input=getInputFromUser();//input=3
            if((input==-1) && (i!=0)){
                break;
            }
            sum+=input;//sum=6
            i++;//i=3
        }

        System.out.println(sum/i);
    }

    private static int getInputFromUser() {
        System.out.print("Enter a number- ");
        return sc.nextInt();
    }

}
//#1
//1 2 4 -1

//#2
//negative numbers

//#3
//performance

//#4
//1000328928924328237582378529923