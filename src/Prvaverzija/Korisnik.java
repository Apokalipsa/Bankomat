package Prvaverzija;

public class Korisnik {
	private String korisnik;
	private String sifra;
	private int iznosNaRacunu;
	private boolean Admin;

	Korisnik() {

	}

	public Korisnik(String korisnik, String sifra) {
		this.korisnik = korisnik;
		this.sifra = sifra;

	}

	public String getKorisnik() {
		return korisnik;
	}

	public void setKorisnik(String korisnik) {
		this.korisnik = korisnik;
	}

	public String getSifra() {
		return sifra;
	}

	public void setSifra(String sifra) {
		this.sifra = sifra;
	}

	public int getIznosNaRacunu() {
		return iznosNaRacunu;
	}

	public void setIznosNaRacunu(int iznosNaRacunu) {
		this.iznosNaRacunu = iznosNaRacunu;
	}

	public boolean isAdmin() {
		return Admin;
	}

	public void setAdmin(boolean admin) {
		Admin = admin;
	}

}
