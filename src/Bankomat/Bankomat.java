package Bankomat;

import java.util.Scanner;



public class Bankomat{
		
		private int dvadeset = 30;
		private int stotinu = 10;
		private int pedeset = 20;
		private int deset = 60;
		private int ukupno;
		private int dostupno;

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

		Scanner input = new Scanner(System.in);

		public int brojRacuna() {
			System.out.print("Unesite broj vaseg racuna: ");
			int racun;
			racun = input.nextInt();

			return racun;
		}

		public int sifraPin() {
			System.out.print("Unesite pin code: ");
			int pin;
			pin = input.nextInt();

			return pin;
		}

		public void startBankomat() {
			brojRacuna();
			sifraPin();
			ulazGlavniMeni();
		}

		public void ulazGlavniMeni() {
			int selection;

			System.out.println("\nDobro dosli u glavni meni:");
			System.out.println("1 - Provjerite stanje na racunu");
			System.out.println("2 -Podignite novac");
			System.out.println("3 - Zavrsite sa  transakcijom");
			System.out.print("Izaberite: ");
			selection = input.nextInt();

			switch (selection) {
			case 1:
				stanjeNaRacunu();
				break;
			case 2:
				podizanjeNovca();
				break;
			case 3:

				System.out
						.println("Hvala vam na koristenju nasih usluga!!! Dovidjenja");
			}
		}

		public void stanjeNaRacunu() {
			System.out.println("Stanje Na Racunu:");
			System.out.println("\t--Ukupno stanje: bam" + ukupno);
			System.out.println("\t--Dostupno stanje: bam" + dostupno);
			ulazGlavniMeni();
		}

		public void deposit(int iznosDepozita) {
			System.out.println("\n***Molimo ubacite vaš novac sada...***");
			ukupno = ukupno + iznosDepozita;
			dostupno = dostupno +iznosDepozita;
		}

		public void provjeraStanja(int iznosZaPodizanje) {
			if (ukupno - iznosZaPodizanje < 0)
				System.out
						.println("\n***GREŠKA !!! Nema dovoljno sredstava na raèunu***");
			else {
				ukupno = ukupno - iznosZaPodizanje;
				dostupno = dostupno - iznosZaPodizanje;
				System.out.println("\n***Molimo uzmite  Vas novac sada...***");
			}
		}

		public void dodajteSredstva() {
			int addSelection;

			System.out.println("depozit sredstva:");
			System.out.println("1 - bam 10");
			System.out.println("2 - bam 20");
			System.out.println("3 - bam 50");
			System.out.println("4 - bam 100");
			System.out.println("5 - Povratak u glavni meni");
			System.out.print("Choice: ");
			addSelection = input.nextInt();

			switch (addSelection) {
			case 1:
				deposit(20);
				ulazGlavniMeni();
				break;
			case 2:
				deposit(40);
				ulazGlavniMeni();
				break;
			case 3:
				deposit(60);
				ulazGlavniMeni();
				break;
			case 4:
				deposit(100);
				ulazGlavniMeni();
				break;
			case 5:
				ulazGlavniMeni();
				break;
			}
		}

		public void podizanjeNovca() {
			int withdrawSelection;

			System.out.println("Podignite novac:");
			System.out.println("1 - bam 10");
			System.out.println("2 - bam 20");
			System.out.println("3 - bam 50");
			System.out.println("4 - bam 100");
			System.out.println("5 - Povratak u glavni meni");
			System.out.print("Izaberite: ");
			withdrawSelection = input.nextInt();

			switch (withdrawSelection) {
			case 1:
				provjeraStanja(20);
				ulazGlavniMeni();
				break;
			case 2:
				provjeraStanja(40);
				ulazGlavniMeni();
				break;
			case 3:
				provjeraStanja(60);
				ulazGlavniMeni();
				break;
			case 4:
				provjeraStanja(100);
				ulazGlavniMeni();
				break;
			case 5:
				ulazGlavniMeni();
				break;
			}
		}

		public static void main(String args[]) {

			Bankomat startuj = new Bankomat();
			startuj.startBankomat();
		}
	}


