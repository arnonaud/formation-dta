package fr.operateur.console;
import java.math.BigDecimal;
import java.util.Scanner;
public class OperateursApp {
	public static void main(String args[]){
				
		System.out.println("***** Application Opérateurs *****");
		System.out.println("Veuillez saisir le premier nombre...");
		Scanner sc = new Scanner(System.in);
		String valeur1 = sc.nextLine();
		System.out.println("Veuillez saisir un deuxieme nombre...");
		String valeur2 = sc.nextLine();
		double val1 = Double.parseDouble(valeur1);
		double val2 = Double.parseDouble(valeur2);
		System.out.println(valeur1 + " + " + valeur2 + " = " + (val1+val2));
		System.out.println(valeur1 + " - " + valeur2 + " = " + new BigDecimal(valeur1).subtract(new BigDecimal(valeur2)));
		System.out.println(valeur1 + " * " + valeur2 + " = " + (val1*val2));
		if(val2 == 0){
			System.out.println("Division par 0 impossible");
		}
		else {
			System.out.println(valeur1 + " / " + valeur2 + " = " + (val1/val2));
			System.out.println(valeur1 + " % " + valeur2 + " = " + (val1%val2));
			
		}
		sc.close();
			
	}
}
