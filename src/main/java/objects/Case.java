package objects;

public class Case {
	
	private int alter;
	private String name;
	private float overallAbgefangeneBaelle;
	private int overallAssists;
	private float overallBallEroberungen;
	private float overallBallverlust;
	private float overallBewertung;
	private float overallBlockSchuss;
	private float overallDribblings;
	private float overallEinsatzquote;
	private float overallFouls;
	private float overallGeklaerteBaelle;
	private int overallGoals;
	private float overallKPNEUN;
	private float overallkreierteGrosschancen;
	private int overallMinPlayed;
	private float overallPassquote;
	private float overallSchussgenauigkeit;
	private float overallSHNeun;
	private float overallTacklingQuote;
	private float overallTorschussVorlagen;
	private float overallZweikampfquote;
	private float overallxA;
	private float overallxANEUN;
	private float overallxG;
	private float overallxGNEUN;
	private String position;
	private float overallTorschuesse;
	private float overallLuftzweikampf;
	private float transfermarktwert;
	
	//Konstruktor Case Objekt.
	public Case(int alter, String name, float overallAbgefangeneBaelle, int overallAssists,
			float overallBallEroberungen, float overallBallverlust, float overallBewertung, float overallBlockSchuss,
			float overallDribblings, float overallEinsatzquote, float overallFouls, float overallGeklaerteBaelle,
			int overallGoals, float overallKPNEUN, float overallkreierteGrosschancen, int overallMinPlayed,
			float overallPassquote, float overallSchussgenauigkeit, float overallSHNeun, float overallTacklingQuote,
			float overallTorschussVorlagen, float overallZweikampfquote, float overallxA, float overallxANEUN,
			float overallxG, float overallxGNEUN, String position, float overallTorschuesse, float overallLuftzweikampf,
			float transfermarktwert) {
		super();
		this.alter = alter;
		this.name = name;
		this.overallAbgefangeneBaelle = overallAbgefangeneBaelle;
		this.overallAssists = overallAssists;
		this.overallBallEroberungen = overallBallEroberungen;
		this.overallBallverlust = overallBallverlust;
		this.overallBewertung = overallBewertung;
		this.overallBlockSchuss = overallBlockSchuss;
		this.overallDribblings = overallDribblings;
		this.overallEinsatzquote = overallEinsatzquote;
		this.overallFouls = overallFouls;
		this.overallGeklaerteBaelle = overallGeklaerteBaelle;
		this.overallGoals = overallGoals;
		this.overallKPNEUN = overallKPNEUN;
		this.overallkreierteGrosschancen = overallkreierteGrosschancen;
		this.overallMinPlayed = overallMinPlayed;
		this.overallPassquote = overallPassquote;
		this.overallSchussgenauigkeit = overallSchussgenauigkeit;
		this.overallSHNeun = overallSHNeun;
		this.overallTacklingQuote = overallTacklingQuote;
		this.overallTorschussVorlagen = overallTorschussVorlagen;
		this.overallZweikampfquote = overallZweikampfquote;
		this.overallxA = overallxA;
		this.overallxANEUN = overallxANEUN;
		this.overallxG = overallxG;
		this.overallxGNEUN = overallxGNEUN;
		this.position = position;
		this.overallTorschuesse = overallTorschuesse;
		this.overallLuftzweikampf = overallLuftzweikampf;
		this.transfermarktwert = transfermarktwert;
	}
	public int getAlter() {
		return alter;
	}
	public void setAlter(int alter) {
		this.alter = alter;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public float getOverallAbgefangeneBaelle() {
		return overallAbgefangeneBaelle;
	}
	public void setOverallAbgefangeneBaelle(float overallAbgefangeneBaelle) {
		this.overallAbgefangeneBaelle = overallAbgefangeneBaelle;
	}
	public int getOverallAssists() {
		return overallAssists;
	}
	public void setOverallAssists(int overallAssists) {
		this.overallAssists = overallAssists;
	}
	public float getOverallBallEroberungen() {
		return overallBallEroberungen;
	}
	public void setOverallBallEroberungen(float overallBallEroberungen) {
		this.overallBallEroberungen = overallBallEroberungen;
	}
	public float getOverallBallverlust() {
		return overallBallverlust;
	}
	public void setOverallBallverlust(float overallBallverlust) {
		this.overallBallverlust = overallBallverlust;
	}
	public float getOverallBewertung() {
		return overallBewertung;
	}
	public void setOverallBewertung(float overallBewertung) {
		this.overallBewertung = overallBewertung;
	}
	public float getOverallBlockSchuss() {
		return overallBlockSchuss;
	}
	public void setOverallBlockSchuss(float overallBlockSchuss) {
		this.overallBlockSchuss = overallBlockSchuss;
	}
	public float getOverallDribblings() {
		return overallDribblings;
	}
	public void setOverallDribblings(float overallDribblings) {
		this.overallDribblings = overallDribblings;
	}
	public float getOverallEinsatzquote() {
		return overallEinsatzquote;
	}
	public void setOverallEinsatzquote(float overallEinsatzquote) {
		this.overallEinsatzquote = overallEinsatzquote;
	}
	public float getOverallFouls() {
		return overallFouls;
	}
	public void setOverallFouls(float overallFouls) {
		this.overallFouls = overallFouls;
	}
	public float getOverallGeklaerteBaelle() {
		return overallGeklaerteBaelle;
	}
	public void setOverallGeklaerteBaelle(float overallGeklaerteBaelle) {
		this.overallGeklaerteBaelle = overallGeklaerteBaelle;
	}
	public int getOverallGoals() {
		return overallGoals;
	}
	public void setOverallGoals(int overallGoals) {
		this.overallGoals = overallGoals;
	}
	public float getOverallKPNEUN() {
		return overallKPNEUN;
	}
	public void setOverallKPNEUN(float overallKPNEUN) {
		this.overallKPNEUN = overallKPNEUN;
	}
	public float getOverallkreierteGrosschancen() {
		return overallkreierteGrosschancen;
	}
	public void setOverallkreierteGrosschancen(float overallkreierteGrosschancen) {
		this.overallkreierteGrosschancen = overallkreierteGrosschancen;
	}
	public int getOverallMinPlayed() {
		return overallMinPlayed;
	}
	public void setOverallMinPlayed(int overallMinPlayed) {
		this.overallMinPlayed = overallMinPlayed;
	}
	public float getOverallPassquote() {
		return overallPassquote;
	}
	public void setOverallPassquote(float overallPassquote) {
		this.overallPassquote = overallPassquote;
	}
	public float getOverallSchussgenauigkeit() {
		return overallSchussgenauigkeit;
	}
	public void setOverallSchussgenauigkeit(float overallSchussgenauigkeit) {
		this.overallSchussgenauigkeit = overallSchussgenauigkeit;
	}
	public float getOverallSHNeun() {
		return overallSHNeun;
	}
	public void setOverallSHNeun(float overallSHNeun) {
		this.overallSHNeun = overallSHNeun;
	}
	public float getOverallTacklingQuote() {
		return overallTacklingQuote;
	}
	public void setOverallTacklingQuote(float overallTacklingQuote) {
		this.overallTacklingQuote = overallTacklingQuote;
	}
	public float getOverallTorschussVorlagen() {
		return overallTorschussVorlagen;
	}
	public void setOverallTorschussVorlagen(float overallTorschussVorlagen) {
		this.overallTorschussVorlagen = overallTorschussVorlagen;
	}
	public float getOverallZweikampfquote() {
		return overallZweikampfquote;
	}
	public void setOverallZweikampfquote(float overallZweikampfquote) {
		this.overallZweikampfquote = overallZweikampfquote;
	}
	public float getOverallxA() {
		return overallxA;
	}
	public void setOverallxA(float overallxA) {
		this.overallxA = overallxA;
	}
	public float getOverallxANEUN() {
		return overallxANEUN;
	}
	public void setOverallxANEUN(float overallxANEUN) {
		this.overallxANEUN = overallxANEUN;
	}
	public float getOverallxG() {
		return overallxG;
	}
	public void setOverallxG(float overallxG) {
		this.overallxG = overallxG;
	}
	public float getOverallxGNEUN() {
		return overallxGNEUN;
	}
	public void setOverallxGNEUN(float overallxGNEUN) {
		this.overallxGNEUN = overallxGNEUN;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public float getOverallTorschuesse() {
		return overallTorschuesse;
	}
	public void setOverallTorschuesse(float overallTorschuesse) {
		this.overallTorschuesse = overallTorschuesse;
	}
	public float getOverallLuftzweikampf() {
		return overallLuftzweikampf;
	}
	public void setOverallLuftzweikampf(float overallLuftzweikampf) {
		this.overallLuftzweikampf = overallLuftzweikampf;
	}
	public float getTransfermarktwert() {
		return transfermarktwert;
	}
	public void setTransfermarktwert(float transfermarktwert) {
		this.transfermarktwert = transfermarktwert;
	}
	@Override
	public String toString() {
		return "Case [alter=" + alter + ", name=" + name + ", overallAbgefangeneBaelle=" + overallAbgefangeneBaelle
				+ ", overallAssists=" + overallAssists + ", overallBallEroberungen=" + overallBallEroberungen
				+ ", overallBallverlust=" + overallBallverlust + ", overallBewertung=" + overallBewertung
				+ ", overallBlockSchuss=" + overallBlockSchuss + ", overallDribblings=" + overallDribblings
				+ ", overallEinsatzquote=" + overallEinsatzquote + ", overallFouls=" + overallFouls
				+ ", overallGeklaerteBaelle=" + overallGeklaerteBaelle + ", overallGoals=" + overallGoals
				+ ", overallKPNEUN=" + overallKPNEUN + ", overallkreierteGrosschancen=" + overallkreierteGrosschancen
				+ ", overallMinPlayed=" + overallMinPlayed + ", overallPassquote=" + overallPassquote
				+ ", overallSchussgenauigkeit=" + overallSchussgenauigkeit + ", overallSHNeun=" + overallSHNeun
				+ ", overallTacklingQuote=" + overallTacklingQuote + ", overallTorschussVorlagen="
				+ overallTorschussVorlagen + ", overallZweikampfquote=" + overallZweikampfquote + ", overallxA="
				+ overallxA + ", overallxANEUN=" + overallxANEUN + ", overallxG=" + overallxG + ", overallxGNEUN="
				+ overallxGNEUN + ", position=" + position + ", overallTorschuesse=" + overallTorschuesse
				+ ", overallLuftzweikampf=" + overallLuftzweikampf + ", transfermarktwert=" + transfermarktwert + "]";
	}
	
	
}