package Zoldseges;

import java.util.Scanner;
import java.util.Vector;

public class Bode {
	
	Vector<Zoldseg> raktar = new Vector<Zoldseg>(10);

	public static Zoldseg bekeres() {
		Scanner s = new Scanner(System.in);
		Zoldseg z = new Zoldseg();
		System.out.println("a Zoldseg Neve? ");
		z.SetNev(s.nextLine());
		System.out.println("a Zoldseg ára? ");
		z.SetAr(s.nextInt());
		System.out.println("mennyisége? ");
		z.SetMennyiseg(s.nextFloat());
		s.nextLine();
		System.out.println("Szine?");
		z.SetSzin(s.nextLine());
		System.out.println("Akcióse? Igen: y Nem: n");
		String kaki = (s.nextLine());
		if (kaki.equals("y")) {
			z.SetAkcios(true);
		} else {
			z.SetAkcios(false);
		}
		return z;
	}

	public void kiiratas() {

		System.out.println("A Raktar: ");
		for (int i = 0; i < raktar.size(); i++) {
			System.out.println(raktar.get(i).toString());
		}
	}

	public int kereses(String keresett) {
		for (int i = 0; i < raktar.size(); i++) {
			if (raktar.get(i).getNev().equals(keresett)) {
				return i;
			}
		}
		return -1;
	}

	public void run() {
		

		Scanner s = new Scanner(System.in);

		int valasz = 0;

		while (valasz != 9) {
			System.out.println("1: Hozol? 2: Raktár lista 3 : keresés 9: Kilép");
			valasz = s.nextInt();
			switch (valasz) {
			case 1:
				raktar.add(bekeres());
				break;
			case 2:
				kiiratas();
				break;
			 case 3:
				 String keresesicel = s.next();
				 int pozicio = kereses(keresesicel);
			 		if (pozicio > -1) {
			 		System.out.println(raktar.get(pozicio).toString());	
			 	} else{
			 		System.out.println("Nincs ilyen");
			 		 	
			 	}
			  break;
			default:
				System.out.println("Bye Bye");
			}

		}

		s.close();
		// Zoldseg z = bekeres();
		// System.out.println(z.toString());

	}
}
