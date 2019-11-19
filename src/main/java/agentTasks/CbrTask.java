package agentTasks;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import de.dfki.mycbr.core.ICaseBase;
import de.dfki.mycbr.core.casebase.Instance;
import de.dfki.mycbr.core.model.Concept;
import de.dfki.mycbr.core.model.IntegerDesc;
import de.dfki.mycbr.core.retrieval.Retrieval;
import de.dfki.mycbr.core.retrieval.Retrieval.RetrievalMethod;
import de.dfki.mycbr.core.similarity.Similarity;
import de.dfki.mycbr.util.Pair;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.MessageTemplate;
import objects.Case;
import objects.DataStorage;

public class CbrTask {
	
	private String message;
	
	public CbrTask() {
		message = "MESSAGE";
	}
	
	public String getMessage() {
		return this.message;
	}
	
	//Speicherung der Fälle in die Fallbasis
	public void saveCases() {
		ArrayList<Case> playerarray = DataStorage.getSharedDataStorage().getCases();		
		for(Case element : DataStorage.getSharedDataStorage().getCases()){ 
				System.out.println("Spieler: "  + element);
		}
    	Concept soccerplayer = DataStorage.getSharedDataStorage().getProject().getConceptByID("Soccerplayer");
    	ICaseBase cb = DataStorage.getSharedDataStorage().getCasebasee();
    	int count = 0;
		for(Case c: playerarray) {
			try {
				Instance i = soccerplayer.addInstance(c.getName());			
				i.addAttribute("Alter", c.getAlter());
				if(c.getOverallAbgefangeneBaelle() != 0) {
					i.addAttribute("OverallAbgefangeneBaelle", c.getOverallAbgefangeneBaelle());
				}else {
					i.addAttribute("OverallAbgefangeneBaelle", null);
				}
				if(c.getOverallBallEroberungen() != 0) {
					i.addAttribute("OverallBallEroberungen", c.getOverallBallEroberungen());
				}else {
					i.addAttribute("OverallBallEroberungen", null);				
				}
				if(c.getOverallBallverlust() != 0) {
					i.addAttribute("OverallBallverlust", c.getOverallBallverlust());
				}else {
					i.addAttribute("OverallBallverlust", null);				
				}
				if(c.getOverallBewertung() != 5) {
					i.addAttribute("OverallBewertung", c.getOverallBewertung());
				}else {
					i.addAttribute("OverallBewertung", null);					
				}
				if(c.getOverallBlockSchuss() != 0) {
					i.addAttribute("OverallBlockSchuss", c.getOverallBlockSchuss());
				}else {
					i.addAttribute("OverallBlockSchuss", null);
				}
				if(c.getOverallDribblings() != 0) {
					i.addAttribute("OverallDribblings", c.getOverallDribblings());
				}else {
					i.addAttribute("OverallDribblings", null);					
				}
				if(c.getOverallEinsatzquote() != 0) {
					i.addAttribute("OverallEinsatzquote", c.getOverallEinsatzquote());
				}else {
					i.addAttribute("OverallEinsatzquote", null);					
				}
				if(c.getOverallFouls() != 0) {
					i.addAttribute("OverallFouls", c.getOverallFouls());
				}else {
					i.addAttribute("OverallFouls", null);
					
				}
				if(c.getOverallGeklaerteBaelle() != 0) {
					i.addAttribute("OverallGeklaerteBaelle", c.getOverallGeklaerteBaelle());
				}else {
					i.addAttribute("OverallGeklaerteBaelle", null);
					
				}
				if(c.getOverallKPNEUN() != 0) {
					i.addAttribute("OverallKP90", c.getOverallKPNEUN());
				}else {
					i.addAttribute("OverallKP90", null);
					
				}
				if(c.getOverallkreierteGrosschancen() != 0) {
					i.addAttribute("OverallKreierteGrosschancen", c.getOverallkreierteGrosschancen());
				}else {
					i.addAttribute("OverallKreierteGrosschancen", null);
					
				}
				if(c.getOverallMinPlayed() != 0) {
					i.addAttribute("OverallMinPlayed", c.getOverallMinPlayed());
				}else {
					i.addAttribute("OverallMinPlayed", null);
					
				}
				if(c.getOverallPassquote() != 0) {
					i.addAttribute("OverallPassquote", c.getOverallPassquote());
				}else {
					i.addAttribute("OverallPassquote", null);	
				}
				if(c.getOverallSchussgenauigkeit() != 0) {
					i.addAttribute("OverallSchussgenauigkeit", c.getOverallSchussgenauigkeit());
				}else {
					i.addAttribute("OverallSchussgenauigkeit", null);	
				}
				if(c.getOverallSHNeun() != 0) {
					i.addAttribute("OverallSh90", c.getOverallSHNeun());
				}else {
					i.addAttribute("OverallSh90", null);
					
				}
				if(c.getOverallTacklingQuote() != 0) {
					i.addAttribute("OverallTacklingquote", c.getOverallTacklingQuote());
				}else {
					i.addAttribute("OverallTacklingquote", null);
					
				}
				if(c.getOverallTorschussVorlagen() != 0) {
					i.addAttribute("OverallTorschussVorlagen", c.getOverallTorschussVorlagen());
				}else {
					i.addAttribute("OverallTorschussVorlagen", null);
					
				}
				if(c.getOverallZweikampfquote() != 0) {
					i.addAttribute("OverallZweikampfquote", c.getOverallZweikampfquote());
				}else {
					i.addAttribute("OverallTorschussVorlagen", null);
					
				}
				if(c.getOverallxA() != 0) {
					i.addAttribute("OverallxA", c.getOverallxA());
				}else {
					i.addAttribute("OverallxA", null);
					
				}
				if(c.getOverallxANEUN() != 0) {
					i.addAttribute("OverallxA90", c.getOverallxANEUN());
				}else {
					i.addAttribute("OverallxA90", null);
					
				}
				if(c.getOverallxG() != 0) {
					i.addAttribute("OverallxG", c.getOverallxG());
				}else {
					i.addAttribute("OverallxG", null);
					
				}
				if(c.getOverallxGNEUN() != 0) {
					i.addAttribute("OverallxG90", c.getOverallxGNEUN());
				}else {
					i.addAttribute("OverallxG90", null);
					
				}
				if(c.getOverallTorschuesse() != 0) {
					i.addAttribute("OverallTorschuesse", c.getOverallTorschuesse());
				}else {
					i.addAttribute("OverallTorschuesse", null);
					
				}
				if(c.getOverallLuftzweikampf() != 0) {
					i.addAttribute("OverallLuftzweikampf", c.getOverallLuftzweikampf());
				}else {
					i.addAttribute("OverallLuftzweikampf", null);	
				}
				if(c.getTransfermarktwert() != 0) {
					i.addAttribute("transfermarktwert", c.getTransfermarktwert());
				}else {
					i.addAttribute("transfermarktwert", null);
					
				}
				i.addAttribute("OverallAssists", c.getOverallAssists());				
				i.addAttribute("Alter", c.getAlter());
				i.addAttribute("OverallGoals", c.getOverallGoals());
				i.addAttribute("Position", c.getPosition());
				cb.addCase(i);
				count++;
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		DataStorage.getSharedDataStorage().setAddedCases(0);

		DataStorage.getSharedDataStorage().setAddedCases(count);
		Collection<Instance> cases = cb.getCases();
		for(Instance i : cases) {
			System.out.println(i.getAttributes());
			System.out.println(i.getName());
		}
	}
}
