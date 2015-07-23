package Prvaverzija;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Kes extends Korisnik {
	private int deset = 60;
	private int dvadeset = 30;
	private int pedeset = 20;
	private int stotinu = 10;
	private int ukupno;
	private int dostupno;
	private List<Korisnik> korisnickaLista = new ArrayList<Korisnik>();

	public Kes() {

		Admin admin = new Admin("Dijana", "0011");
		korisnickaLista.add(admin);
		RedovniKorisnik lice1 = new RedovniKorisnik("Denis", "0000");
		lice1.setIznosNaRacunu(3000);
		korisnickaLista.add(lice1);
		RedovniKorisnik lice2 = new RedovniKorisnik("Ceca", "5723");
		lice2.setIznosNaRacunu(1500);
		korisnickaLista.add(lice2);
		RedovniKorisnik lice3 = new RedovniKorisnik("Goran", "0943");
		lice3.setIznosNaRacunu(2000);
		korisnickaLista.add(lice3);
		RedovniKorisnik lice4 = new RedovniKorisnik("Lisac", "6453");
		lice4.setIznosNaRacunu(2500);
		korisnickaLista.add(lice4);
		RedovniKorisnik lice5 = new RedovniKorisnik("Dejan", "2343");
		lice5.setIznosNaRacunu(4500);
		korisnickaLista.add(lice5);
		RedovniKorisnik lice6 = new RedovniKorisnik("Bojan", "1153");
		lice6.setIznosNaRacunu(980);
		korisnickaLista.add(lice6);
	}

	public int getUkupno() {
		return ukupno;
	}

	public void setUkupno(int ukupno) {
		this.ukupno = this.deset * 10 + this.dvadeset * 20 + this.pedeset * 50
				+ this.stotinu * 100; // stanje na bankomatu
	}

	public int getStotinu() {
		return stotinu;
	}

	public void setStotinu(int stotinu) {
		if (stotinu < 100) {

		}
		this.stotinu = stotinu;
	}

	public int getPedeset() {
		return pedeset;
	}

	public void setPedeset(int pedeset) {
		if (pedeset < 100) {

		}
		this.pedeset = pedeset;
	}

	public int getDvadeset() {
		return dvadeset;
	}

	public void setDvadeset(int dvadeset) {
		if (dvadeset < 100) {

		}
		this.dvadeset = dvadeset;
	}

	public int getDeset() {
		return deset;
	}

	public void setDeset(int deset) {
		if (deset < 100) {

		}
		this.deset = deset;
	}

	public List<Korisnik> getkorisnickaLista() {
		return korisnickaLista;
	}

	public void setkorisnickaLista(List<Korisnik> korisnickaLista) {
		this.korisnickaLista = korisnickaLista;
	}

	public void start() {
		System.out.println("Dobro Dosli   ");

		int index = logIn();
		if (this.korisnickaLista.get(index).isAdmin()) {
			optionsForAdminUser();
		} else {
			opcijeZaRedovneKorisnike(index);
		}
	}

	public boolean PostojiLiKorisnik(String username) {
		int num = 0;
		for (int i = 0; i < korisnickaLista.size(); i++) {
			if (korisnickaLista.get(i).getKorisnik().toLowerCase()
					.equals(username.toLowerCase())) {
				num++;
			}
		}
		return (num == 1);
	}

	public boolean daLiSifraOdgovara(String username, String password) {
		int rez = 0;
		for (int i = 0; i < this.korisnickaLista.size(); i++) {
			if (this.korisnickaLista.get(i).getKorisnik().toLowerCase()
					.equals(username.toLowerCase())
					&& this.korisnickaLista.get(i).getSifra().equals(password)) {
				rez++;
			}
		}
		return (rez == 1);

	}

	public int getUserIndex(String korisnik, String sifra) {

		int rez = 0;
		for (int i = 0; i < this.korisnickaLista.size(); i++) {
			if (this.korisnickaLista.get(i).getKorisnik().toLowerCase()
					.equals(korisnik.toLowerCase())
					&& this.korisnickaLista.get(i).getSifra().equals(sifra)) {
				rez = i;
			}
		}
		return rez;
	}

	public int getUserIndex(String korisnik) {
		int rez = 0;
		for (int i = 0; i < this.korisnickaLista.size(); i++) {
			if (this.korisnickaLista.get(i).getKorisnik().toLowerCase()
					.equals(korisnik.toLowerCase())) {
				rez = i;
			}
		}
		return rez;
	}

	public int logIn() {

		Scanner scan = new Scanner(System.in);
		System.out.println("Molim unesite Vase korisnicko ime: ");
		String username = scan.nextLine();

		while (!PostojiLiKorisnik(username)) {
			System.out
					.println("Ovaj korisnik ne postoji. Molimo unesite Vase korisnicko ime: ");
			username = scan.nextLine();
		}

		System.out.println("Unesite Vas Pin Kod: ");
		String password = scan.nextLine();
		while (!daLiSifraOdgovara(username, password)) {
			System.out.println("Pogresan Pin Kod. Pokusajte ponovo: ");
			password = scan.nextLine();
		}

		System.out.println("Uspjesno ste se ulogovani!");
		return getUserIndex(username, password);
	}

	public void logOut() {

		System.out.println("Hvala sto ste koristili nase uluge. Dovidjenja.");

		start();
	}

	public void dodajKorisnika() {
		Scanner scan = new Scanner(System.in);

		System.out.println("Unesite korisnicko ime: ");
		String username = scan.nextLine();

		while (PostojiLiKorisnik(username)) {
			System.out
					.println("Ovaj korisnik vec postoji. Odaberite drugog korisnika:");
			username = scan.nextLine();
		}

		System.out.println("Unesite Pin Kod: ");
		String password = scan.nextLine();

		String user;
		do {
			System.out
					.println("Unesite R ako ste redovan korisnik, A ako ste admin: ");
			user = scan.next();

			if (user.toLowerCase().equals("r")) {
				boolean inputIsOk = false;
				System.out.println("Unesite korisnicko stanje na racunu: ");

				do {
					try {
						inputIsOk = true;
						int amount = Integer.parseInt(scan.next());
						RedovniKorisnik ru = new RedovniKorisnik(username,
								password);
						ru.setIznosNaRacunu(ukupno);
						korisnickaLista.add(ru);
					} catch (NumberFormatException e) {
						inputIsOk = false;
						System.out
								.println("Pogresan unos. Unesite stanje na racunu: ");
					}
				} while (!inputIsOk);
			}

			else if (user.toLowerCase().equals("a")) {
				Admin au = new Admin(username, password);
				korisnickaLista.add(au);
			}

			else {
				System.out
						.println("Unijeli ste pogresno slovo. Molim pokusajte ponovo.");
			}

		} while (!user.toLowerCase().equals("r")
				&& !user.toLowerCase().equals("a"));
		System.out.println("User added successfully.");
	}

	public void brisanjeKorisnika() {
		System.out
				.println("Unesite korisnicko ime korisnika kojeg zelite brisati: ");
		Scanner scan = new Scanner(System.in);
		String username = scan.nextLine();

		if (PostojiLiKorisnik(username)) {
			korisnickaLista.remove(korisnickaLista.get(getUserIndex(username)));
			System.out.println("Korisnik uspjesno obrisan.");
		} else {
			System.out.println("Ovo korisnicko ime ne postoji.");
		}
	}

	public void printBanknoteStatus() {

		System.out.println("Bankomat stanje je:\n" + "10s - " + getDeset()
				+ " | " + "20s - " + getDvadeset() + " | " + "50s - "
				+ getPedeset() + " | " + "100s - " + getStotinu() + " | \n"
				+ "Total - " + getUkupno());
	}

	public void changeBanknoteStatus() {
		Scanner scan = new Scanner(System.in);
		int[] banknotesArray = { 10, 20, 50, 100 };
		int[] statusArray = new int[4];
		printBanknoteStatus();

		for (int i = 0; i < banknotesArray.length; i++) {
			boolean inputIsOk = false;
			while (!inputIsOk) {
				try {
					inputIsOk = true;
					System.out.println("Type new status for the "
							+ banknotesArray[i] + "s:");
					int newStatus = Integer.parseInt(scan.next());
					statusArray[i] = newStatus;

				} catch (Exception e) {
					inputIsOk = false;
					System.out.println("Wrong syntax. Try again.");
				}
			}
		}
		setDeset(statusArray[0]);
		setDvadeset(statusArray[1]);
		setPedeset(statusArray[2]);
		setStotinu(statusArray[3]);
		setUkupno(deset);
		printBanknoteStatus();
	}

	public void optionsForAdminUser() {

		Scanner scan = new Scanner(System.in);
		int option = 0;
		do {

			System.out.println("Admin Meni");
			System.out.println("1. Novi korisnik\n" + "2. Brisanje korisnika\n"
					+ "3. Promjena bankomat stanja\n"
					+ "4. Povratak u glavni meni\n");

			System.out.println("Unesite broj pored opcije: ");

			boolean inputIsOk = false;
			do {
				try {
					inputIsOk = true;
					option = Integer.parseInt(scan.next());
					switch (option) {
					case 1:
						dodajKorisnika();
						break;
					case 2:
						brisanjeKorisnika();
						break;
					case 3:
						changeBanknoteStatus();
						break;
					case 4:
						logOut();
						break;
					default:
						System.out
								.println("Unijeli ste pogresan broj.  Molim ponovite: ");
						break;
					}
				} catch (Exception e) {
					inputIsOk = false;
					System.out.println("Greska. Unesite broj pored opcije: ");
				}
			} while (!inputIsOk);
		} while (option != 4);
	}

	public void podizanjeNovca(int i) {
		Scanner scan = new Scanner(System.in);
		boolean inputIsOk = false;
		int howMuchCash = 0;
		while (!inputIsOk) {
			try {
				System.out.println("Unesite koliko novca zelite da podignete:");
				howMuchCash = Integer.parseInt(scan.next());
				if (howMuchCash > korisnickaLista.get(i).getIznosNaRacunu()) {
					System.out
							.println("Upozorenje! Iznos na Vasem racunu je manje od trazenog.");
				} else if (howMuchCash > getUkupno()) {
					System.out
							.println("Zao nam je, nemamo dovoljno sredstava u bankomatu za Vasu isplatu. Molimo posjetite nasu poslovnicu.");
				} else {
					calculate(howMuchCash);
					korisnickaLista.get(i).setIznosNaRacunu(
							korisnickaLista.get(i).getIznosNaRacunu()
									- howMuchCash);
					setUkupno(howMuchCash);
				}
				inputIsOk = true;
			} catch (Exception e) {
				inputIsOk = false;
				System.out.println("Greska. Molim ponovite.");
			}
		}
	}

	public void calculate(int howMuchCash) {
		int[] outBill = { 0, 0, 0, 0 };
		int[] statusBegin = { getDeset(), getDvadeset(), getPedeset(),
				getStotinu() };
		int[] banknote = { 10, 20, 50, 100 };

		for (int i = 3; i >= 0; i--) {
			while (howMuchCash != 0 && statusBegin[i] > 5
					&& (howMuchCash - banknote[i]) >= 0) {
				outBill[i]++;
				howMuchCash -= banknote[i];
			}
		}
		setDeset(statusBegin[0] - outBill[0]);
		setDvadeset(statusBegin[1] - outBill[1]);
		setPedeset(statusBegin[2] - outBill[2]);
		setStotinu(statusBegin[3] - outBill[3]);
		System.out.println("Podigli ste: ");
		for (int i = 0; i < 4; i++) {
			System.out.print(outBill[i] + "*" + banknote[i] + " | ");
		}
		System.out.println();
	}

	public void provjeraStanjaNaRacunu(int i) {

		System.out.println("Iznos na Vasem racunu je: "
				+ korisnickaLista.get(i).getIznosNaRacunu());
	}

	public void opcijeZaRedovneKorisnike(int index) {

		Scanner scan = new Scanner(System.in);
		int option = 0;
		do {

			System.out.println("Glavni Meni");
			System.out.println("1. Podignite novac\n"
					+ "2. Provjerite stanje na racunu\n" + "3. Izlaz\n");

			System.out.println("Unesite broj pored opcije: ");
			boolean inputIsOk = false;
			do {
				try {
					inputIsOk = true;
					option = Integer.parseInt(scan.next());
					switch (option) {
					case 1:
						podizanjeNovca(index);
						break;
					case 2:
						provjeraStanjaNaRacunu(index);
						break;
					case 3:
						logOut();
						break;
					default:
						System.out
								.println("Unijeli ste pogresan broj.  Molim ponovite: ");
						break;
					}
				} catch (Exception e) {
					inputIsOk = false;
					System.out.println("Greska. Unesite broj pored opcije: ");
				}
			} while (!inputIsOk);
		} while (option != 3);
	}

}
