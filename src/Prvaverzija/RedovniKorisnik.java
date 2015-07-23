package Prvaverzija;

public class RedovniKorisnik extends Korisnik {
	RedovniKorisnik(String korisnik, String sifra) {
		super(korisnik, sifra);
		setAdmin(false);

	}
}
