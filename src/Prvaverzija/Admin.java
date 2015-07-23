package Prvaverzija;

public class Admin extends Korisnik {
	Admin(String korisnik, String sifra) {
		super(korisnik, sifra);
		setAdmin(true);
	}

}
