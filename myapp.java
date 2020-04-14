package text;
import java.util.Scanner;
import text.arithmetic;
public class myapp {
	public static void main(String[] args) 
	  { String a;
	    Scanner sc= new Scanner(System.in);
	    a=sc.nextLine();
	    String[] arr =a.split("\\ ");
	    arithmetic.main(arr);
	    System.out.println("Çë´ðÌâ");
	    String s=sc.nextLine();
	    Read.proofread("Answers.txt","Answers2.txt");
	  }
}
