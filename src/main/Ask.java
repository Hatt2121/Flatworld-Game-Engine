package main;
import java.util.Scanner;

public class Ask {
	
	public Scanner sca = new Scanner(System.in);
	public String a;
	
	public boolean readBoolean(String str) {
		System.out.println(str);
		return sca.nextBoolean();
	}
	
	public boolean yeno(String str) {
		Boolean t = false;
		System.out.println(str + " y/[n]: ");
		String h = sca.nextLine();
		if(h.equals("y")) {
			t = true;
		} else if(h.equals("n")) {
			t = false;
		}
		return t;
	}
	
	public String whatToDo() {
		System.out.println();
		System.out.println("What do you want to do?");
		String a = sca.nextLine();
		this.a = a;
		return a;
	}
	
	public String returnString(String str) {
		System.out.println();
		System.out.println(str);
		String a = sca.nextLine();
		return a;
	}
}
