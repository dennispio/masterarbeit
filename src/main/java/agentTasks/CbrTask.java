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
	
	public void saveCases() {
		ArrayList<Case> playerarray = DataStorage.getSharedDataStorage().getCases();
		System.out.println("iuch bin in CbrTask");
		
		
		for(Case element : DataStorage.getSharedDataStorage().getCases()){ 
				System.out.println("Spieler: "  +element);
				
			}
    	
    	Concept soccerplayer = DataStorage.getSharedDataStorage().getProject().getConceptByID("Soccerplayer");

    	ICaseBase cb = DataStorage.getSharedDataStorage().getCasebasee();
    	//Collection<Instance> instances = smartphone.getAllInstances();
    	int count = 0;
		for(Case c: playerarray) {
			try {
				Instance i = soccerplayer.addInstance(c.getName());
				i.addAttribute("Alter", c.getAlter());
				i.addAttribute("OverallAbgefangeneBaelle", c.getOverallAbgefangeneBaelle());
				i.addAttribute("OverallAssists", c.getOverallAssists());
				i.addAttribute("OverallBallEroberungen", c.getOverallBallEroberungen());
				i.addAttribute("OverallBallverlust", c.getOverallBallverlust());
				i.addAttribute("OverallBewertung", c.getOverallBewertung());
				i.addAttribute("OverallBlockSchuss", c.getOverallBlockSchuss());
				i.addAttribute("OverallDribblings", c.getOverallDribblings());
				i.addAttribute("OverallEinsatzquote", c.getOverallEinsatzquote());
				i.addAttribute("OverallFouls", c.getOverallFouls());
				i.addAttribute("OverallGeklaerteBaelle", c.getOverallGeklaerteBaelle());
				i.addAttribute("OverallGoals", c.getOverallGoals());
				i.addAttribute("OverallKP90", c.getOverallKPNEUN());
				i.addAttribute("OverallKreierteGrosschancen", c.getOverallkreierteGrosschancen());
				i.addAttribute("OverallMinPlayed", c.getOverallMinPlayed());
				i.addAttribute("OverallPassquote", c.getOverallPassquote());
				i.addAttribute("OverallSchussgenauigkeit", c.getOverallSchussgenauigkeit());
				i.addAttribute("OverallSh90", c.getOverallSHNeun());
				i.addAttribute("OverallTacklingquote", c.getOverallTacklingQuote());
				i.addAttribute("OverallTorschussVorlagen", c.getOverallTorschussVorlagen());
				i.addAttribute("OverallZweikampfquote", c.getOverallZweikampfquote());
				i.addAttribute("OverallxA", c.getOverallxA());
				i.addAttribute("OverallxA90", c.getOverallxANEUN());
				i.addAttribute("OverallxG", c.getOverallxG());
				i.addAttribute("OverallxG90", c.getOverallxGNEUN());
				i.addAttribute("Position", c.getPosition());
				i.addAttribute("OverallTorschuesse", c.getOverallTorschuesse());
				i.addAttribute("OverallLuftzweikampf", c.getOverallLuftzweikampf());
				i.addAttribute("transfermarktwert", c.getTransfermarktwert());
		
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
