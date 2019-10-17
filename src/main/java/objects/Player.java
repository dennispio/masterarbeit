package objects;

public class Player {
	
	private String alter;
	//private String lastAssists;
	//private String lastGoals;
	//private String lastKPNEUN;
	//private String lastMinPlayed;
	//private String lastSh90;
	//private String lastxA;
	//private String lastxANEUN;
	//private String lastxG;
	//private String lastxGNEUN;
	private String name;
	private String overallAbgefangeneBaelle;
	private String overllAssists;
	private String overallBallEroberungen;
	private String overallBallverlust;
	private String overallBewertung;
	private String overallBlockSchuss;
	private String overallDribblings;
	private String overallEinsatzquote;
	private String overallFouls;
	private String overallGeklaerteBaelle;
	private String overallGoals;
	private String overallKPNEUN;
	private String overallkreierteGrosschancen;
	private String overallMinPlayed;
	private String overallPassquote;
	private String overallSchussgenauigkeit;
	private String overallSHNeun;
	private String overallTacklingQuote;
	private String overallTorschussVorlagen;
	private String overallZweikampfquote;
	private String overallxA;
	private String overallxANEUN;
	private String overallxG;
	private String overallxGNEUN;
	private String position;
	private String spieltagbewertung;
	
	public Player(String alter,String name,
			String overallAbgefangeneBaelle, String overllAssists, String overallBallEroberungen,
			String overallBallverlust, String overallBewertung, String overallBlockSchuss, String overallDribblings,
			String overallEinsatzquote, String overallFouls, String overallGeklaerteBaelle, String overallGoals,
			String overallKPNEUN, String overallkreierteGrosschancen, String overallMinPlayed, String overallPassquote,
			String overallSchussgenauigkeit, String overallSHNeun, String overallTacklingQuote,
			String overallTorschussVorlagen, String overallZweikampfquote, String overallxA, String overallxANEUN,
			String overallxG, String overallxGNEUN, String position, String spieltagbewertung) {
		super();
		this.alter = alter;
		this.name = name;
		this.overallAbgefangeneBaelle = overallAbgefangeneBaelle;
		this.overllAssists = overllAssists;
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
		this.spieltagbewertung = spieltagbewertung;
	}

	@Override
	public String toString() {
		return "Case [alter=" + alter + ", name=" + name
				+ ", overallAbgefangeneBaelle=" + overallAbgefangeneBaelle + ", overllAssists=" + overllAssists
				+ ", overallBallEroberungen=" + overallBallEroberungen + ", overallBallverlust=" + overallBallverlust
				+ ", overallBewertung=" + overallBewertung + ", overallBlockSchuss=" + overallBlockSchuss
				+ ", overallDribblings=" + overallDribblings + ", overallEinsatzquote=" + overallEinsatzquote
				+ ", overallFouls=" + overallFouls + ", overallGeklaerteBaelle=" + overallGeklaerteBaelle
				+ ", overallGoals=" + overallGoals + ", overallKPNEUN=" + overallKPNEUN
				+ ", overallkreierteGrosschancen=" + overallkreierteGrosschancen + ", overallMinPlayed="
				+ overallMinPlayed + ", overallPassquote=" + overallPassquote + ", overallSchussgenauigkeit="
				+ overallSchussgenauigkeit + ", overallSHNeun=" + overallSHNeun + ", overallTacklingQuote="
				+ overallTacklingQuote + ", overallTorschussVorlagen=" + overallTorschussVorlagen
				+ ", overallZweikampfquote=" + overallZweikampfquote + ", overallxA=" + overallxA + ", overallxANEUN="
				+ overallxANEUN + ", overallxG=" + overallxG + ", overallxGNEUN=" + overallxGNEUN + ", position="
				+ position + ", spieltagbewertung=" + spieltagbewertung + "]";
	}

	public String getAlter() {
		return alter;
	}

	public void setAlter(String alter) {
		this.alter = alter;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getOverallAbgefangeneBaelle() {
		return overallAbgefangeneBaelle;
	}

	public void setOverallAbgefangeneBaelle(String overallAbgefangeneBaelle) {
		this.overallAbgefangeneBaelle = overallAbgefangeneBaelle;
	}

	public String getOverllAssists() {
		return overllAssists;
	}

	public void setOverllAssists(String overllAssists) {
		this.overllAssists = overllAssists;
	}

	public String getOverallBallEroberungen() {
		return overallBallEroberungen;
	}

	public void setOverallBallEroberungen(String overallBallEroberungen) {
		this.overallBallEroberungen = overallBallEroberungen;
	}

	public String getOverallBallverlust() {
		return overallBallverlust;
	}

	public void setOverallBallverlust(String overallBallverlust) {
		this.overallBallverlust = overallBallverlust;
	}

	public String getOverallBewertung() {
		return overallBewertung;
	}

	public void setOverallBewertung(String overallBewertung) {
		this.overallBewertung = overallBewertung;
	}

	public String getOverallBlockSchuss() {
		return overallBlockSchuss;
	}

	public void setOverallBlockSchuss(String overallBlockSchuss) {
		this.overallBlockSchuss = overallBlockSchuss;
	}

	public String getOverallDribblings() {
		return overallDribblings;
	}

	public void setOverallDribblings(String overallDribblings) {
		this.overallDribblings = overallDribblings;
	}

	public String getOverallEinsatzquote() {
		return overallEinsatzquote;
	}

	public void setOverallEinsatzquote(String overallEinsatzquote) {
		this.overallEinsatzquote = overallEinsatzquote;
	}

	public String getOverallFouls() {
		return overallFouls;
	}

	public void setOverallFouls(String overallFouls) {
		this.overallFouls = overallFouls;
	}

	public String getOverallGeklaerteBaelle() {
		return overallGeklaerteBaelle;
	}

	public void setOverallGeklaerteBaelle(String overallGeklaerteBaelle) {
		this.overallGeklaerteBaelle = overallGeklaerteBaelle;
	}

	public String getOverallGoals() {
		return overallGoals;
	}

	public void setOverallGoals(String overallGoals) {
		this.overallGoals = overallGoals;
	}

	public String getOverallKPNEUN() {
		return overallKPNEUN;
	}

	public void setOverallKPNEUN(String overallKPNEUN) {
		this.overallKPNEUN = overallKPNEUN;
	}

	public String getOverallkreierteGrosschancen() {
		return overallkreierteGrosschancen;
	}

	public void setOverallkreierteGrosschancen(String overallkreierteGrosschancen) {
		this.overallkreierteGrosschancen = overallkreierteGrosschancen;
	}

	public String getOverallMinPlayed() {
		return overallMinPlayed;
	}

	public void setOverallMinPlayed(String overallMinPlayed) {
		this.overallMinPlayed = overallMinPlayed;
	}

	public String getOverallPassquote() {
		return overallPassquote;
	}

	public void setOverallPassquote(String overallPassquote) {
		this.overallPassquote = overallPassquote;
	}

	public String getOverallSchussgenauigkeit() {
		return overallSchussgenauigkeit;
	}

	public void setOverallSchussgenauigkeit(String overallSchussgenauigkeit) {
		this.overallSchussgenauigkeit = overallSchussgenauigkeit;
	}

	public String getOverallSHNeun() {
		return overallSHNeun;
	}

	public void setOverallSHNeun(String overallSHNeun) {
		this.overallSHNeun = overallSHNeun;
	}

	public String getOverallTacklingQuote() {
		return overallTacklingQuote;
	}

	public void setOverallTacklingQuote(String overallTacklingQuote) {
		this.overallTacklingQuote = overallTacklingQuote;
	}

	public String getOverallTorschussVorlagen() {
		return overallTorschussVorlagen;
	}

	public void setOverallTorschussVorlagen(String overallTorschussVorlagen) {
		this.overallTorschussVorlagen = overallTorschussVorlagen;
	}

	public String getOverallZweikampfquote() {
		return overallZweikampfquote;
	}

	public void setOverallZweikampfquote(String overallZweikampfquote) {
		this.overallZweikampfquote = overallZweikampfquote;
	}

	public String getOverallxA() {
		return overallxA;
	}

	public void setOverallxA(String overallxA) {
		this.overallxA = overallxA;
	}

	public String getOverallxANEUN() {
		return overallxANEUN;
	}

	public void setOverallxANEUN(String overallxANEUN) {
		this.overallxANEUN = overallxANEUN;
	}

	public String getOverallxG() {
		return overallxG;
	}

	public void setOverallxG(String overallxG) {
		this.overallxG = overallxG;
	}

	public String getOverallxGNEUN() {
		return overallxGNEUN;
	}

	public void setOverallxGNEUN(String overallxGNEUN) {
		this.overallxGNEUN = overallxGNEUN;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getSpieltagbewertung() {
		return spieltagbewertung;
	}

	public void setSpieltagbewertung(String spieltagbewertung) {
		this.spieltagbewertung = spieltagbewertung;
	}
	
	
}