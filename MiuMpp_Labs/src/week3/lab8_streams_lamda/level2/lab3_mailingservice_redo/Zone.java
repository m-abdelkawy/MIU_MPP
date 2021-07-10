package week3.lab8_streams_lamda.level2.lab3_mailingservice_redo;

public enum Zone {
	Zone1(0), // IA, MT, OR and CA -> 0.35
	Zone2(1), // TX and UT -> 0.30
	Zone3(2), // FL, MA and OH -> 0.55
	Zone4(3) // others -> 0.43
;
	private int zone;

	Zone(int i) {
		this.zone = i;
	}
	
	public int getValue() {
		return zone;
	}
}
