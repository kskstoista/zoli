package Zoldseges;

public class Zoldseg {

	String nev;
	int ar;
	float mennyiseg;
	String szin;
	boolean akcios;

	public Zoldseg() {
	}

	public String toString() {
		return "A zöldaseg neve: " + this.nev + "\n" + "Ár: " + this.ar + "\n" + "mennyiseg: " + this.mennyiseg + "\n"
				+ "Szin: " + this.szin + "\n" + "Akciós: " + this.akcios; 
	}

	public Zoldseg(String ZoldsegNev, int ar) {
		// System.out.println("konstruktor hivas");
		this.nev = ZoldsegNev;
		this.ar = ar;
	}

	public void SetNev(String ujNev) {
		this.nev = ujNev;
	}

	public void SetAr(int ujAr) {
		this.ar = ujAr;
	}

	public void SetMennyiseg(float ujMennyiseg) {
		this.mennyiseg = ujMennyiseg;
	}

	public void SetSzin(String ujSzin) {
		this.szin = ujSzin;
	}

	public void SetAkcios(boolean ujAkcios) {
		this.akcios = ujAkcios;
		}
	
		
	

	public String getNev() {
		return this.nev;
	}

	public int getAr() {
		return this.ar;
	}

	public float getMennyiseg() {
		return this.mennyiseg;
	}

	public boolean getAkcios() {
		return this.akcios;
	} 
	
	
	public String getSzin() {
		return this.szin;
	}

}
