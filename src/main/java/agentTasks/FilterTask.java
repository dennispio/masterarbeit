package agentTasks;

import java.util.ArrayList;
import java.util.List;

import javax.xml.crypto.Data;

import jade.domain.DFGUIManagement.GetParents;
import objects.Case;
import objects.DataStorage;
import objects.Player;

public class FilterTask {
	
	//Filterung der Spielerwerte in den richtigen Datentyp.
	public void filterData(List<Player> player) {
		for(Player p : player) {
			parseData(p);
		}	
	}
	ArrayList<Case> cases = new ArrayList<Case>();
	
	public void parseData(Player player) {
		
		Case c = new Case(
				FilterInt(player.getAlter()),
				player.getName(),
				FilterFloat(player.getOverallAbgefangeneBaelle()),
				FilterInt(player.getOverallAssists()),
				FilterFloat(player.getOverallBallEroberungen()),
				FilterFloat(player.getOverallBallverlust()),
				FilterBewertungFloat(player.getOverallBewertung()),
				FilterFloat(player.getOverallBlockSchuss()),
				FilterProzent(player.getOverallDribblings()),
				FilterFloat(player.getOverallEinsatzquote()),
				FilterFloat(player.getOverallFouls()),
				FilterFloat(player.getOverallGeklaerteBaelle()),
				FilterInt(player.getOverallGoals()),
				FilterFloat(player.getOverallKPNEUN()),
				FilterFloat(player.getOverallkreierteGrosschancen()),
				FilterInt(player.getOverallMinPlayed()),
				FilterProzent(player.getOverallPassquote()),
				FilterProzent(player.getOverallSchussgenauigkeit()),
				FilterFloat(player.getOverallSHNeun()),
				FilterProzent(player.getOverallTacklingQuote()),
				FilterFloat(player.getOverallTorschussVorlagen()),
				FilterProzent(player.getOverallZweikampfquote()),
				FilterFloat(player.getOverallxA()),
				FilterFloat(player.getOverallxANEUN()),
				FilterFloat(player.getOverallxG()),
				FilterFloat(player.getOverallxGNEUN()),
				FilterPosition(player.getPosition()),
				FilterFloat(player.getOverallTorschuesse()),
				FilterProzent(player.getOverallLuftzweikampf()),
				FilterTransfermarktFloat(player.getTransfermarktwert()));

		System.out.println(c);
	    System.out.println("Start Filter-Task");
		
		DataStorage.getSharedDataStorage().getCases().add(c);
		
		
	}
	
	private float FilterTransfermarktFloat(String p) {
		if(p != null) {
				String numberString = p.replace(",", ".");
				float number = Float.parseFloat(numberString);
				return number;
		}
		return 0;
	}
	
	private float FilterProzent(String p) {
		if(p != null) {
			if(!(p.equals("-"))){
				String numberwithoutprozent = p.replaceAll("%", "");
				String numberString = numberwithoutprozent.replace(",", ".");
				float number = Float.parseFloat(numberString);
				return number;
			}
		}
		return 0;
	}
	
	private int FilterInt(String p) {
		
		if(p != null) {
			int number = Integer.parseInt(p);
			return number;
		}
		return 0;
	}
	
	private float FilterFloat(String p) {
		if(p != null) {
			if(!(p.equals("-"))){
				String numberString = p.replace(",", ".");
				float number = Float.parseFloat(numberString);
				return number;
			}
		}
		return 0;
	}
	
	private float FilterBewertungFloat(String p) {
		if(p.contains("-")){
			return 5;				
		} else {
			String numberwithoutprozent = p.replaceAll("%", "");
			String numberString = numberwithoutprozent.replace(",", ".");
			float number = Float.parseFloat(numberString);
			return number;
			}
	}
	
	
	private String FilterPosition(String m) {
		if(m.contains("Torhüter")) {
			return "TW";
		}
		if(m.contains("Innenverteidiger")) {
			return "IV";
		}
		if(m.contains("Linksverteidiger")) {
			return "LV";
		}
		if(m.contains("Rechtsverteidiger")) {
			return "RV";
		}
		if(m.contains("Defensives")) {
			return "DM";
		}
		if(m.contains("Zentrales")) {
			return "ZMF";
		}
		if(m.contains("Offensives")) {
			return "OMF";
		}
		if(m.contains("Linke")) {
			return "LMF";
		}
		if(m.contains("Rechte")) {
			return "RMF";
		}
		if(m.contains("Stürmer")) {
			return "ST";
		}
		return "Other";
	}
	
}
