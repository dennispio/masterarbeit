package agentTasks;

import java.io.Serializable;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import de.dfki.mycbr.core.ICaseBase;
import de.dfki.mycbr.core.casebase.Instance;
import de.dfki.mycbr.core.model.Concept;
import de.dfki.mycbr.core.model.FloatDesc;
import de.dfki.mycbr.core.model.IntegerDesc;
import de.dfki.mycbr.core.model.StringDesc;
import de.dfki.mycbr.core.model.SymbolDesc;
import de.dfki.mycbr.core.retrieval.Retrieval;
import de.dfki.mycbr.core.retrieval.Retrieval.RetrievalMethod;
import de.dfki.mycbr.core.similarity.Similarity;
import de.dfki.mycbr.util.Pair;
import jade.content.lang.sl.ParseException;
import objects.Case;
import objects.DataStorage;
import objects.QueryCase;
import objects.RetrievalCase;

public class RetrievalTask {
	private String message;
	
	public RetrievalTask() {
		message = "MESSAGE";
	}
	
	public String getMessage() {
		return this.message;
	}
	
	public void retrievalCases(Serializable player) {
		DataStorage dataStorage = DataStorage.getSharedDataStorage();

	try {
		
		QueryCase ph = (QueryCase) player;
				
		Concept soccerplayer = DataStorage.getSharedDataStorage().getProject().getConceptByID("Soccerplayer");

	    ICaseBase cb = DataStorage.getSharedDataStorage().getCasebasee();

	    Retrieval retrieve = new Retrieval(soccerplayer, cb);
	    retrieve.setRetrievalMethod(RetrievalMethod.RETRIEVE_SORTED);
	    
	    Instance query = retrieve.getQueryInstance();	    
	  	
	    IntegerDesc alterDesc = (IntegerDesc) soccerplayer.getAllAttributeDescs().get("Alter");
	    FloatDesc overallAbgefangeneBaelleDesc = (FloatDesc) soccerplayer.getAllAttributeDescs().get("OverallAbgefangeneBaelle");
	    IntegerDesc overallAssistsDesc = (IntegerDesc) soccerplayer.getAllAttributeDescs().get("OverallAssists");
	    FloatDesc overallBallEroberungenDesc = (FloatDesc) soccerplayer.getAllAttributeDescs().get("OverallBallEroberungen");
	    FloatDesc  overallBallverlustDesc = (FloatDesc) soccerplayer.getAllAttributeDescs().get("OverallBallverlust");
	    FloatDesc  overallBewertungDesc = (FloatDesc) soccerplayer.getAllAttributeDescs().get("OverallBewertung");
	    FloatDesc  overallBlockSchussDesc = (FloatDesc) soccerplayer.getAllAttributeDescs().get("OverallBlockSchuss");
	    FloatDesc  overallDribblingsDesc = (FloatDesc) soccerplayer.getAllAttributeDescs().get("OverallDribblings");
	    FloatDesc  overallEinsatzquoteDesc = (FloatDesc) soccerplayer.getAllAttributeDescs().get("OverallEinsatzquote");
	    FloatDesc  overallFoulsDesc = (FloatDesc) soccerplayer.getAllAttributeDescs().get("OverallFouls");
	    FloatDesc  overallGeklaerteBaelleDesc = (FloatDesc) soccerplayer.getAllAttributeDescs().get("OverallGeklaerteBaelle");
	    IntegerDesc overallGoalsDesc = (IntegerDesc) soccerplayer.getAllAttributeDescs().get("OverallGoals");
	    FloatDesc  overallKP90Desc = (FloatDesc) soccerplayer.getAllAttributeDescs().get("OverallKP90");
	    FloatDesc  overallkreierteGrosschancenDesc = (FloatDesc) soccerplayer.getAllAttributeDescs().get("OverallKreierteGrosschancen");
	    IntegerDesc  overallMinPlayedDesc = (IntegerDesc) soccerplayer.getAllAttributeDescs().get("OverallMinPlayed");
	    FloatDesc  overallPassquoteDesc = (FloatDesc) soccerplayer.getAllAttributeDescs().get("OverallPassquote");
	    FloatDesc  overallSchussgenauigkeitDesc = (FloatDesc) soccerplayer.getAllAttributeDescs().get("OverallSchussgenauigkeit");
	    FloatDesc  overallSH90Desc = (FloatDesc) soccerplayer.getAllAttributeDescs().get("OverallSh90");
	    FloatDesc  overallTacklingquoteDesc = (FloatDesc) soccerplayer.getAllAttributeDescs().get("OverallTacklingquote");
	    FloatDesc  overallZweikampfquoteDesc = (FloatDesc) soccerplayer.getAllAttributeDescs().get("OverallZweikampfquote");
	    FloatDesc  overallxADesc = (FloatDesc) soccerplayer.getAllAttributeDescs().get("OverallxA");
	    FloatDesc  overallxA90Desc = (FloatDesc) soccerplayer.getAllAttributeDescs().get("OverallxA90");
	    FloatDesc  overallxGDesc = (FloatDesc) soccerplayer.getAllAttributeDescs().get("OverallxG");
	    FloatDesc  overallxG90Desc = (FloatDesc) soccerplayer.getAllAttributeDescs().get("OverallxG90");
	    FloatDesc  overallTorschussVorlagen = (FloatDesc) soccerplayer.getAllAttributeDescs().get("OverallTorschussVorlagen");
	    SymbolDesc positionDesc = (SymbolDesc) soccerplayer.getAllAttributeDescs().get("Position");
	    FloatDesc  overallTorschuesseDesc = (FloatDesc) soccerplayer.getAllAttributeDescs().get("OverallTorschuesse");
	    FloatDesc  overallLuftzweikampfDesc = (FloatDesc) soccerplayer.getAllAttributeDescs().get("OverallLuftzweikampf");
	    FloatDesc  transfermarktwertDesc = (FloatDesc) soccerplayer.getAllAttributeDescs().get("transfermarktwert");
	    
		System.out.println(ph.getName()+"##############-NAME-##############");
		
		if(!(ph.getName().equals("undefined"))){
			
			System.out.println(soccerplayer.getInstance(ph.getName())+ "es klappt den spieler zu catchen");
			System.out.println(soccerplayer.getInstance(ph.getName()).getAttForDesc(alterDesc).getValueAsString() + "es klappt den spieler zu catchen");		
			
			query.addAttribute(alterDesc, alterDesc.getAttribute(Integer.parseInt(soccerplayer.getInstance(ph.getName()).getAttForDesc(alterDesc).getValueAsString())));
			if(soccerplayer.getInstance(ph.getName()).getAttForDesc(overallAbgefangeneBaelleDesc).getValueAsString() != "_unknown_") {
				query.addAttribute(overallAbgefangeneBaelleDesc, overallAbgefangeneBaelleDesc.getAttribute(Float.parseFloat(soccerplayer.getInstance(ph.getName()).getAttForDesc(overallAbgefangeneBaelleDesc).getValueAsString())));
			};
			if(soccerplayer.getInstance(ph.getName()).getAttForDesc(overallAssistsDesc).getValueAsString() != "_unknown_") {
				query.addAttribute(overallAssistsDesc, overallAssistsDesc.getAttribute(Integer.parseInt(soccerplayer.getInstance(ph.getName()).getAttForDesc(overallAssistsDesc).getValueAsString())));
			};
			if(soccerplayer.getInstance(ph.getName()).getAttForDesc(overallBallEroberungenDesc).getValueAsString() != "_unknown_") {
				query.addAttribute(overallBallEroberungenDesc, overallBallEroberungenDesc.getAttribute(Float.parseFloat(soccerplayer.getInstance(ph.getName()).getAttForDesc(overallBallEroberungenDesc).getValueAsString())));
			};
			if(soccerplayer.getInstance(ph.getName()).getAttForDesc(overallBallverlustDesc).getValueAsString() != "_unknown_") {
				query.addAttribute(overallBallverlustDesc, overallBallverlustDesc.getAttribute(Float.parseFloat(soccerplayer.getInstance(ph.getName()).getAttForDesc(overallBallverlustDesc).getValueAsString())));
			};
			if(soccerplayer.getInstance(ph.getName()).getAttForDesc(overallBewertungDesc).getValueAsString() != "_unknown_") {
				query.addAttribute(overallBewertungDesc, overallBewertungDesc.getAttribute(Float.parseFloat(soccerplayer.getInstance(ph.getName()).getAttForDesc(overallBewertungDesc).getValueAsString())));
			};
	
			if(soccerplayer.getInstance(ph.getName()).getAttForDesc(overallBlockSchussDesc).getValueAsString() != "_unknown_") {
				query.addAttribute(overallBlockSchussDesc, overallBlockSchussDesc.getAttribute(Float.parseFloat(soccerplayer.getInstance(ph.getName()).getAttForDesc(overallBlockSchussDesc).getValueAsString())));
			};
			if(soccerplayer.getInstance(ph.getName()).getAttForDesc(overallDribblingsDesc).getValueAsString() != "_unknown_") {
				query.addAttribute(overallDribblingsDesc, overallDribblingsDesc.getAttribute(Float.parseFloat(soccerplayer.getInstance(ph.getName()).getAttForDesc(overallDribblingsDesc).getValueAsString())));
			};
			if(soccerplayer.getInstance(ph.getName()).getAttForDesc(overallEinsatzquoteDesc).getValueAsString() != "_unknown_") {
				query.addAttribute(overallEinsatzquoteDesc, overallEinsatzquoteDesc.getAttribute(Float.parseFloat(soccerplayer.getInstance(ph.getName()).getAttForDesc(overallEinsatzquoteDesc).getValueAsString())));
			};
			if(soccerplayer.getInstance(ph.getName()).getAttForDesc(overallFoulsDesc).getValueAsString() != "_unknown_") {
				query.addAttribute(overallFoulsDesc, overallFoulsDesc.getAttribute(Float.parseFloat(soccerplayer.getInstance(ph.getName()).getAttForDesc(overallFoulsDesc).getValueAsString())));
			};
			if(soccerplayer.getInstance(ph.getName()).getAttForDesc(overallGeklaerteBaelleDesc).getValueAsString() != "_unknown_") {
				query.addAttribute(overallGeklaerteBaelleDesc, overallGeklaerteBaelleDesc.getAttribute(Float.parseFloat(soccerplayer.getInstance(ph.getName()).getAttForDesc(overallGeklaerteBaelleDesc).getValueAsString())));
			};
			if(soccerplayer.getInstance(ph.getName()).getAttForDesc(overallGoalsDesc).getValueAsString() != "_unknown_") {
				query.addAttribute(overallGoalsDesc, overallGoalsDesc.getAttribute(Integer.parseInt(soccerplayer.getInstance(ph.getName()).getAttForDesc(overallGoalsDesc).getValueAsString())));
			};
			if(soccerplayer.getInstance(ph.getName()).getAttForDesc(overallKP90Desc).getValueAsString() != "_unknown_") {
				query.addAttribute(overallKP90Desc, overallKP90Desc.getAttribute(Float.parseFloat(soccerplayer.getInstance(ph.getName()).getAttForDesc(overallKP90Desc).getValueAsString())));
			};
			if(soccerplayer.getInstance(ph.getName()).getAttForDesc(overallkreierteGrosschancenDesc).getValueAsString() != "_unknown_") {
				query.addAttribute(overallkreierteGrosschancenDesc, overallkreierteGrosschancenDesc.getAttribute(Float.parseFloat(soccerplayer.getInstance(ph.getName()).getAttForDesc(overallkreierteGrosschancenDesc).getValueAsString())));
			};
			if(soccerplayer.getInstance(ph.getName()).getAttForDesc(overallMinPlayedDesc).getValueAsString() != "_unknown_") {
				query.addAttribute(overallMinPlayedDesc, overallMinPlayedDesc.getAttribute(Integer.parseInt(soccerplayer.getInstance(ph.getName()).getAttForDesc(overallMinPlayedDesc).getValueAsString())));
			};
			if(soccerplayer.getInstance(ph.getName()).getAttForDesc(overallPassquoteDesc).getValueAsString() != "_unknown_") {
				query.addAttribute(overallPassquoteDesc, overallPassquoteDesc.getAttribute(Float.parseFloat(soccerplayer.getInstance(ph.getName()).getAttForDesc(overallPassquoteDesc).getValueAsString())));
			};
			if(soccerplayer.getInstance(ph.getName()).getAttForDesc(overallSchussgenauigkeitDesc).getValueAsString() != "_unknown_") {
				query.addAttribute(overallSchussgenauigkeitDesc, overallSchussgenauigkeitDesc.getAttribute(Float.parseFloat(soccerplayer.getInstance(ph.getName()).getAttForDesc(overallSchussgenauigkeitDesc).getValueAsString())));
			};
			if(soccerplayer.getInstance(ph.getName()).getAttForDesc(overallSH90Desc).getValueAsString() != "_unknown_") {
				query.addAttribute(overallSH90Desc, overallSH90Desc.getAttribute(Float.parseFloat(soccerplayer.getInstance(ph.getName()).getAttForDesc(overallSH90Desc).getValueAsString())));
			};
			if(soccerplayer.getInstance(ph.getName()).getAttForDesc(overallTacklingquoteDesc).getValueAsString() != "_unknown_") {
				query.addAttribute(overallTacklingquoteDesc, overallTacklingquoteDesc.getAttribute(Float.parseFloat(soccerplayer.getInstance(ph.getName()).getAttForDesc(overallTacklingquoteDesc).getValueAsString())));
			};
			if(soccerplayer.getInstance(ph.getName()).getAttForDesc(overallZweikampfquoteDesc).getValueAsString() != "_unknown_") {
				query.addAttribute(overallZweikampfquoteDesc, overallZweikampfquoteDesc.getAttribute(Float.parseFloat(soccerplayer.getInstance(ph.getName()).getAttForDesc(overallZweikampfquoteDesc).getValueAsString())));
			};
			if(soccerplayer.getInstance(ph.getName()).getAttForDesc(overallxADesc).getValueAsString() != "_unknown_") {
				query.addAttribute(overallxADesc, overallxADesc.getAttribute(Float.parseFloat(soccerplayer.getInstance(ph.getName()).getAttForDesc(overallxADesc).getValueAsString())));
			};
			if(soccerplayer.getInstance(ph.getName()).getAttForDesc(overallxA90Desc).getValueAsString() != "_unknown_") {
				query.addAttribute(overallxA90Desc, overallxA90Desc.getAttribute(Float.parseFloat(soccerplayer.getInstance(ph.getName()).getAttForDesc(overallxA90Desc).getValueAsString())));
			};
			if(soccerplayer.getInstance(ph.getName()).getAttForDesc(overallxGDesc).getValueAsString() != "_unknown_") {
				query.addAttribute(overallxGDesc, overallxGDesc.getAttribute(Float.parseFloat(soccerplayer.getInstance(ph.getName()).getAttForDesc(overallxGDesc).getValueAsString())));
			};
			if(soccerplayer.getInstance(ph.getName()).getAttForDesc(overallxG90Desc).getValueAsString() != "_unknown_") {
				query.addAttribute(overallxG90Desc, overallxG90Desc.getAttribute(Float.parseFloat(soccerplayer.getInstance(ph.getName()).getAttForDesc(overallxG90Desc).getValueAsString())));
			};
			if(soccerplayer.getInstance(ph.getName()).getAttForDesc(overallTorschussVorlagen).getValueAsString() != "_unknown_") {
				query.addAttribute(overallTorschussVorlagen, overallTorschussVorlagen.getAttribute(Float.parseFloat(soccerplayer.getInstance(ph.getName()).getAttForDesc(overallTorschussVorlagen).getValueAsString())));
			};
			if(soccerplayer.getInstance(ph.getName()).getAttForDesc(positionDesc).getValueAsString() != "_unknown_") {
				query.addAttribute(positionDesc, positionDesc.getAttribute(soccerplayer.getInstance(ph.getName()).getAttForDesc(positionDesc).getValueAsString()));
			};
			if(soccerplayer.getInstance(ph.getName()).getAttForDesc(overallTorschuesseDesc).getValueAsString() != "_unknown_") {
				query.addAttribute(overallTorschuesseDesc, overallTorschuesseDesc.getAttribute(Float.parseFloat(soccerplayer.getInstance(ph.getName()).getAttForDesc(overallTorschuesseDesc).getValueAsString())));
			};
			if(soccerplayer.getInstance(ph.getName()).getAttForDesc(overallLuftzweikampfDesc).getValueAsString() != "_unknown_") {
				query.addAttribute(overallLuftzweikampfDesc, overallLuftzweikampfDesc.getAttribute(Float.parseFloat(soccerplayer.getInstance(ph.getName()).getAttForDesc(overallLuftzweikampfDesc).getValueAsString())));
			};
			if(soccerplayer.getInstance(ph.getName()).getAttForDesc(transfermarktwertDesc).getValueAsString() != "_unknown_") {
				query.addAttribute(transfermarktwertDesc, transfermarktwertDesc.getAttribute(Float.parseFloat(soccerplayer.getInstance(ph.getName()).getAttForDesc(transfermarktwertDesc).getValueAsString())));
				};


			switch(ph.getSpielertyp()){
			
			case "identisch": 
				soccerplayer.getActiveAmalgamFct().setWeight(alterDesc, 1);
		    	soccerplayer.getActiveAmalgamFct().setWeight(overallAbgefangeneBaelleDesc, 1);
		    	soccerplayer.getActiveAmalgamFct().setWeight(overallAssistsDesc, 1);
		    	soccerplayer.getActiveAmalgamFct().setWeight(overallBallEroberungenDesc, 1);
		    	soccerplayer.getActiveAmalgamFct().setWeight(overallBallverlustDesc, 1);
		    	soccerplayer.getActiveAmalgamFct().setWeight(overallBewertungDesc, 1);
		    	soccerplayer.getActiveAmalgamFct().setWeight(overallBlockSchussDesc, 1);
		    	soccerplayer.getActiveAmalgamFct().setWeight(overallDribblingsDesc, 1);
		    	soccerplayer.getActiveAmalgamFct().setWeight(overallEinsatzquoteDesc, 1);
		    	soccerplayer.getActiveAmalgamFct().setWeight(overallFoulsDesc, 1);
		    	soccerplayer.getActiveAmalgamFct().setWeight(overallGeklaerteBaelleDesc, 1);
		    	soccerplayer.getActiveAmalgamFct().setWeight(overallGoalsDesc, 1);
		    	soccerplayer.getActiveAmalgamFct().setWeight(overallKP90Desc, 1);
		    	soccerplayer.getActiveAmalgamFct().setWeight(overallkreierteGrosschancenDesc, 1);
		    	soccerplayer.getActiveAmalgamFct().setWeight(overallMinPlayedDesc, 1);
		    	soccerplayer.getActiveAmalgamFct().setWeight(overallPassquoteDesc, 1);
		    	soccerplayer.getActiveAmalgamFct().setWeight(overallSchussgenauigkeitDesc, 1);
		    	soccerplayer.getActiveAmalgamFct().setWeight(overallSH90Desc, 1);
		    	soccerplayer.getActiveAmalgamFct().setWeight(overallTacklingquoteDesc, 1);
		    	soccerplayer.getActiveAmalgamFct().setWeight(overallZweikampfquoteDesc, 1);
		    	soccerplayer.getActiveAmalgamFct().setWeight(overallxADesc, 1);
		    	soccerplayer.getActiveAmalgamFct().setWeight(overallxA90Desc, 1);
		    	soccerplayer.getActiveAmalgamFct().setWeight(overallxGDesc, 1);
		    	soccerplayer.getActiveAmalgamFct().setWeight(overallxG90Desc, 1);
		    	soccerplayer.getActiveAmalgamFct().setWeight(overallTorschussVorlagen, 1);
		    	soccerplayer.getActiveAmalgamFct().setWeight(overallTorschuesseDesc, 1);
		    	soccerplayer.getActiveAmalgamFct().setWeight(overallLuftzweikampfDesc, 1);
		    	soccerplayer.getActiveAmalgamFct().setWeight(transfermarktwertDesc, 1);
		    	soccerplayer.getActiveAmalgamFct().setWeight(positionDesc, 1);
		    	break;
	
			case "defensiv": 
			
				soccerplayer.getActiveAmalgamFct().setWeight(alterDesc, 0.2);
		    	soccerplayer.getActiveAmalgamFct().setWeight(overallAbgefangeneBaelleDesc, 2);
		    	soccerplayer.getActiveAmalgamFct().setWeight(overallAssistsDesc, 0.5);
		    	soccerplayer.getActiveAmalgamFct().setWeight(overallBallEroberungenDesc, 2);
		    	soccerplayer.getActiveAmalgamFct().setWeight(overallBallverlustDesc, 0.2);
		    	soccerplayer.getActiveAmalgamFct().setWeight(overallBewertungDesc, 0.7);
		    	soccerplayer.getActiveAmalgamFct().setWeight(overallBlockSchussDesc, 2);
		    	soccerplayer.getActiveAmalgamFct().setWeight(overallDribblingsDesc, 0.5);
		    	soccerplayer.getActiveAmalgamFct().setWeight(overallEinsatzquoteDesc, 0.5);
		    	soccerplayer.getActiveAmalgamFct().setWeight(overallFoulsDesc, 0.5);
		    	soccerplayer.getActiveAmalgamFct().setWeight(overallGeklaerteBaelleDesc, 1.0);
		    	soccerplayer.getActiveAmalgamFct().setWeight(overallGoalsDesc, 0.5);
		    	soccerplayer.getActiveAmalgamFct().setWeight(overallKP90Desc, 0.5);
		    	soccerplayer.getActiveAmalgamFct().setWeight(overallkreierteGrosschancenDesc, 0.5);
		    	soccerplayer.getActiveAmalgamFct().setWeight(overallMinPlayedDesc, 0.1);
		    	soccerplayer.getActiveAmalgamFct().setWeight(overallPassquoteDesc, 1.5);
		    	soccerplayer.getActiveAmalgamFct().setWeight(overallSchussgenauigkeitDesc, 0.5);
		    	soccerplayer.getActiveAmalgamFct().setWeight(overallSH90Desc, 0.5);
		    	soccerplayer.getActiveAmalgamFct().setWeight(overallTacklingquoteDesc, 2);
		    	soccerplayer.getActiveAmalgamFct().setWeight(overallZweikampfquoteDesc, 2);
		    	soccerplayer.getActiveAmalgamFct().setWeight(overallxADesc, 0.5);
		    	soccerplayer.getActiveAmalgamFct().setWeight(overallxA90Desc, 0.5);
		    	soccerplayer.getActiveAmalgamFct().setWeight(overallxGDesc, 0.5);
		    	soccerplayer.getActiveAmalgamFct().setWeight(overallxG90Desc, 0.5);
		    	soccerplayer.getActiveAmalgamFct().setWeight(overallTorschussVorlagen, 0.5);
		    	soccerplayer.getActiveAmalgamFct().setWeight(overallTorschuesseDesc, 5.0);
		    	soccerplayer.getActiveAmalgamFct().setWeight(overallLuftzweikampfDesc, 1.5);
		    	soccerplayer.getActiveAmalgamFct().setWeight(transfermarktwertDesc, 0.5);
		    	soccerplayer.getActiveAmalgamFct().setWeight(positionDesc, 4.0);
		    	break;

			case "offensiv": 
		    	System.out.println("asdasdasd++++++++++++++++++++");
		    	soccerplayer.getActiveAmalgamFct().setWeight(alterDesc, 0.2);
		    	soccerplayer.getActiveAmalgamFct().setWeight(overallAbgefangeneBaelleDesc, 0.2);
		    	soccerplayer.getActiveAmalgamFct().setWeight(overallAssistsDesc, 1.5);
		    	soccerplayer.getActiveAmalgamFct().setWeight(overallBallEroberungenDesc, 0.5);
		    	soccerplayer.getActiveAmalgamFct().setWeight(overallBallverlustDesc, 0.2);
		    	soccerplayer.getActiveAmalgamFct().setWeight(overallBewertungDesc, 0.5);
		    	soccerplayer.getActiveAmalgamFct().setWeight(overallBlockSchussDesc, 0.2);
		    	soccerplayer.getActiveAmalgamFct().setWeight(overallDribblingsDesc, 1);
		    	soccerplayer.getActiveAmalgamFct().setWeight(overallEinsatzquoteDesc, 0.5);
		    	soccerplayer.getActiveAmalgamFct().setWeight(overallFoulsDesc, 0.2);
		    	soccerplayer.getActiveAmalgamFct().setWeight(overallGeklaerteBaelleDesc, 0.1);
		    	soccerplayer.getActiveAmalgamFct().setWeight(overallGoalsDesc, 2.4);
		    	soccerplayer.getActiveAmalgamFct().setWeight(overallKP90Desc, 1.5);
		    	soccerplayer.getActiveAmalgamFct().setWeight(overallkreierteGrosschancenDesc, 1);
		    	soccerplayer.getActiveAmalgamFct().setWeight(overallMinPlayedDesc, 0.1);
		    	soccerplayer.getActiveAmalgamFct().setWeight(overallPassquoteDesc, 0.7);
		    	soccerplayer.getActiveAmalgamFct().setWeight(overallSchussgenauigkeitDesc, 1);
		    	soccerplayer.getActiveAmalgamFct().setWeight(overallSH90Desc, 1.5);
		    	soccerplayer.getActiveAmalgamFct().setWeight(overallTacklingquoteDesc, 0.2);
		    	soccerplayer.getActiveAmalgamFct().setWeight(overallZweikampfquoteDesc, 1);
		    	soccerplayer.getActiveAmalgamFct().setWeight(overallxADesc, 1.5);
		    	soccerplayer.getActiveAmalgamFct().setWeight(overallxA90Desc, 1.5);
		    	soccerplayer.getActiveAmalgamFct().setWeight(overallxGDesc, 1.5);
		    	soccerplayer.getActiveAmalgamFct().setWeight(overallxG90Desc, 1.5);
		    	soccerplayer.getActiveAmalgamFct().setWeight(overallTorschussVorlagen, 1.5);
		    	soccerplayer.getActiveAmalgamFct().setWeight(overallTorschuesseDesc, 2);
		    	soccerplayer.getActiveAmalgamFct().setWeight(overallLuftzweikampfDesc, 0.5);
		    	soccerplayer.getActiveAmalgamFct().setWeight(transfermarktwertDesc, 0.5);
		    	soccerplayer.getActiveAmalgamFct().setWeight(positionDesc, 4.0);

				break;		
			}
	    	

			System.out.println("bin in der Spieleraustauschsuche");
	
		}else {
			query.addAttribute(alterDesc, alterDesc.getAttribute(Integer.parseInt(ph.getAlter())));
	    	query.addAttribute(overallAbgefangeneBaelleDesc, overallAbgefangeneBaelleDesc.getAttribute(Float.parseFloat(ph.getOverallAbgefangeneBaelle())));
	    	query.addAttribute(overallAssistsDesc, overallAssistsDesc.getAttribute(Integer.parseInt(ph.getOverllAssists())));
	    	query.addAttribute(overallBallEroberungenDesc, overallBallEroberungenDesc.getAttribute(Float.parseFloat(ph.getOverallBallEroberungen())));
	    	query.addAttribute(overallBallverlustDesc, overallBallverlustDesc.getAttribute(Float.parseFloat(ph.getOverallBallverlust())));
	    	query.addAttribute(overallBewertungDesc, overallBewertungDesc.getAttribute(Float.parseFloat(ph.getOverallBewertung())));
	    	query.addAttribute(overallBlockSchussDesc, overallBlockSchussDesc.getAttribute(Float.parseFloat(ph.getOverallBlockSchuss())));
	    	query.addAttribute(overallDribblingsDesc, overallDribblingsDesc.getAttribute(Float.parseFloat(ph.getOverallDribblings())));
	    	query.addAttribute(overallEinsatzquoteDesc, overallEinsatzquoteDesc.getAttribute(Float.parseFloat(ph.getOverallEinsatzquote())));
	    	query.addAttribute(overallFoulsDesc, overallFoulsDesc.getAttribute(Float.parseFloat(ph.getOverallFouls())));
	    	query.addAttribute(overallGeklaerteBaelleDesc, overallGeklaerteBaelleDesc.getAttribute(Float.parseFloat(ph.getOverallGeklaerteBaelle())));
	    	query.addAttribute(overallGoalsDesc, overallGoalsDesc.getAttribute(Integer.parseInt(ph.getOverallGoals())));
	    	query.addAttribute(overallKP90Desc, overallKP90Desc.getAttribute(Float.parseFloat(ph.getOverallKPNEUN())));
	    	query.addAttribute(overallkreierteGrosschancenDesc, overallkreierteGrosschancenDesc.getAttribute(Float.parseFloat(ph.getOverallkreierteGrosschancen())));
	    	query.addAttribute(overallPassquoteDesc, overallPassquoteDesc.getAttribute(Float.parseFloat(ph.getOverallPassquote())));
	    	query.addAttribute(overallSchussgenauigkeitDesc, overallSchussgenauigkeitDesc.getAttribute(Float.parseFloat(ph.getOverallSchussgenauigkeit())));
	    	query.addAttribute(overallSH90Desc, overallSH90Desc.getAttribute(Float.parseFloat(ph.getOverallSHNeun())));
	    	query.addAttribute(overallTacklingquoteDesc, overallTacklingquoteDesc.getAttribute(Float.parseFloat(ph.getOverallTacklingQuote())));
	    	query.addAttribute(overallZweikampfquoteDesc, overallZweikampfquoteDesc.getAttribute(Float.parseFloat(ph.getOverallZweikampfquote())));
	    	query.addAttribute(overallxADesc, overallxADesc.getAttribute(Float.parseFloat(ph.getOverallxA())));
	    	query.addAttribute(overallxA90Desc, overallxA90Desc.getAttribute(Float.parseFloat(ph.getOverallxANEUN())));
	    	query.addAttribute(overallxGDesc, overallxGDesc.getAttribute(Float.parseFloat(ph.getOverallxG())));
	    	query.addAttribute(overallxG90Desc, overallxG90Desc.getAttribute(Float.parseFloat(ph.getOverallxGNEUN())));
	    	query.addAttribute(overallTorschussVorlagen, overallTorschussVorlagen.getAttribute(Float.parseFloat(ph.getOverallTorschussVorlagen())));
	    	query.addAttribute(positionDesc, positionDesc.getAttribute(ph.getPosition()));
	    	query.addAttribute(overallTorschuesseDesc, overallTorschuesseDesc.getAttribute(Float.parseFloat(ph.getOverallTorschuesse())));
	    	query.addAttribute(overallLuftzweikampfDesc, overallLuftzweikampfDesc.getAttribute(Float.parseFloat(ph.getOverallLuftzweikampf())));
	    	query.addAttribute(transfermarktwertDesc, transfermarktwertDesc.getAttribute(Float.parseFloat(ph.getTransfermarktwert())));
	    	
	    	soccerplayer.getActiveAmalgamFct().setWeight(alterDesc, 1);
	    	soccerplayer.getActiveAmalgamFct().setWeight(overallAbgefangeneBaelleDesc, 1);
	    	soccerplayer.getActiveAmalgamFct().setWeight(overallAssistsDesc, 1);
	    	soccerplayer.getActiveAmalgamFct().setWeight(overallBallEroberungenDesc, 1);
	    	soccerplayer.getActiveAmalgamFct().setWeight(overallBallverlustDesc, 1);
	    	soccerplayer.getActiveAmalgamFct().setWeight(overallBewertungDesc, 1);
	    	soccerplayer.getActiveAmalgamFct().setWeight(overallBlockSchussDesc, 1);
	    	soccerplayer.getActiveAmalgamFct().setWeight(overallDribblingsDesc, 1);
	    	soccerplayer.getActiveAmalgamFct().setWeight(overallEinsatzquoteDesc, 1);
	    	soccerplayer.getActiveAmalgamFct().setWeight(overallFoulsDesc, 1);
	    	soccerplayer.getActiveAmalgamFct().setWeight(overallGeklaerteBaelleDesc, 1);
	    	soccerplayer.getActiveAmalgamFct().setWeight(overallGoalsDesc, 1);
	    	soccerplayer.getActiveAmalgamFct().setWeight(overallKP90Desc, 1);
	    	soccerplayer.getActiveAmalgamFct().setWeight(overallkreierteGrosschancenDesc, 1);
	    	soccerplayer.getActiveAmalgamFct().setWeight(overallMinPlayedDesc, 1);
	    	soccerplayer.getActiveAmalgamFct().setWeight(overallPassquoteDesc, 1);
	    	soccerplayer.getActiveAmalgamFct().setWeight(overallSchussgenauigkeitDesc, 1);
	    	soccerplayer.getActiveAmalgamFct().setWeight(overallSH90Desc, 1);
	    	soccerplayer.getActiveAmalgamFct().setWeight(overallTacklingquoteDesc, 1);
	    	soccerplayer.getActiveAmalgamFct().setWeight(overallZweikampfquoteDesc, 1);
	    	soccerplayer.getActiveAmalgamFct().setWeight(overallxADesc, 1);
	    	soccerplayer.getActiveAmalgamFct().setWeight(overallxA90Desc, 1);
	    	soccerplayer.getActiveAmalgamFct().setWeight(overallxGDesc, 1);
	    	soccerplayer.getActiveAmalgamFct().setWeight(overallxG90Desc, 1);
	    	soccerplayer.getActiveAmalgamFct().setWeight(overallTorschussVorlagen, 1);
	    	soccerplayer.getActiveAmalgamFct().setWeight(overallTorschuesseDesc, 1);
	    	soccerplayer.getActiveAmalgamFct().setWeight(overallLuftzweikampfDesc, 1);
	    	soccerplayer.getActiveAmalgamFct().setWeight(transfermarktwertDesc, 1);
	    	soccerplayer.getActiveAmalgamFct().setWeight(positionDesc, 1);
		}
	    
	    System.out.println("##########################ICH WAR HIER IM RETRIEVAL######################");
	    
	    retrieve.start();
	    
	    List <Pair<Instance, Similarity>> result = retrieve.getResult();
		dataStorage.getSharedDataStorage().getRetrievalsoccerplayerList().clear();

	    for (int i = 0; i < Integer.parseInt(ph.getAnzahl()); i++) {
		    System.out.println("##########################"+i+"######################");
	    	Instance obj = soccerplayer.getInstance(result.get(i).getFirst().getName());
	    	System.out.println(obj);
	    	System.out.println(retrieve.getResult().get(i).getSecond().getValue() + " - Ähnlichkeit");
	    	System.out.println(obj.getAttForDesc(alterDesc).getValueAsString() + " - Alter");
	    	System.out.println(obj.getAttForDesc(overallAbgefangeneBaelleDesc).getValueAsString() + " - overallAbgefangeneBaelleDesc");
	    	System.out.println(obj.getAttForDesc(overallAssistsDesc).getValueAsString() + " - overllAssistsDesc");
	    	System.out.println(obj.getAttForDesc(overallBallEroberungenDesc).getValueAsString() + " - overallBallEroberungen");
	    	System.out.println(obj.getAttForDesc(overallBallverlustDesc).getValueAsString() + " - overallBallverlust");
	    	System.out.println(obj.getAttForDesc(overallBewertungDesc).getValueAsString() + " - overallBewertung");
	    	System.out.println(obj.getAttForDesc(overallBlockSchussDesc).getValueAsString() + " - overallBlockSchuss");
	    	System.out.println(obj.getAttForDesc(overallDribblingsDesc).getValueAsString() + " - overallDribblings");
	    	System.out.println(obj.getAttForDesc(overallEinsatzquoteDesc).getValueAsString() + " - overallEinsatzquote");
	    	System.out.println(obj.getAttForDesc(overallFoulsDesc).getValueAsString() + " - overallFouls");
	    	System.out.println(obj.getAttForDesc(overallGeklaerteBaelleDesc).getValueAsString() + " - overallGeklaerteBaelle");
	    	System.out.println(obj.getAttForDesc(overallGoalsDesc).getValueAsString() + " - overallGoals");
	    	System.out.println(obj.getAttForDesc(overallKP90Desc).getValueAsString() + " - overallKP90");
	    	System.out.println(obj.getAttForDesc(overallkreierteGrosschancenDesc).getValueAsString() + " - overallkreierteGrosschancen");
	    	System.out.println(obj.getAttForDesc(overallMinPlayedDesc).getValueAsString() + " - overallMinPlayed");
	    	System.out.println(obj.getAttForDesc(overallPassquoteDesc).getValueAsString() + " - overallPassquote");	    	
	    	System.out.println(obj.getAttForDesc(overallSchussgenauigkeitDesc).getValueAsString() + " - overallSchussgenauigkeit");	    	
	    	System.out.println(obj.getAttForDesc(overallSH90Desc).getValueAsString() + " - overallSH90");	    	
	    	System.out.println(obj.getAttForDesc(overallTacklingquoteDesc).getValueAsString() + " - overallTacklingquote");	
	    	System.out.println(obj.getAttForDesc(overallTorschussVorlagen).getValueAsString() + " - overallTorschussvorlagen");	    	
	    	System.out.println(obj.getAttForDesc(overallZweikampfquoteDesc).getValueAsString() + " - overallZweikampfquote");	    	
	    	System.out.println(obj.getAttForDesc(overallxADesc).getValueAsString() + " - overallxA");	    	
	    	System.out.println(obj.getAttForDesc(overallxA90Desc).getValueAsString() + " - overallxA90");	    	
	    	System.out.println(obj.getAttForDesc(overallxGDesc).getValueAsString() + " - overallxG");
	    	System.out.println(obj.getAttForDesc(overallxG90Desc).getValueAsString() + " - overallxG90");
	    	System.out.println(obj.getAttForDesc(positionDesc).getValueAsString() + " - position");
	    	System.out.println(obj.getAttForDesc(overallTorschuesseDesc).getValueAsString() + " - Torschusse");
	    	System.out.println(obj.getAttForDesc(overallLuftzweikampfDesc).getValueAsString() + " - Luftzweikampf");
	    	System.out.println(obj.getAttForDesc(transfermarktwertDesc).getValueAsString() + " - Transfermarktwert");
		    System.out.println("################################################");
		    
		    RetrievalCase soccerplayerretrieval = new RetrievalCase(
		    		obj.getValueAsString(),
		    		Double.toString(retrieve.getResult().get(i).getSecond().getValue()),
		    		obj.getAttForDesc(alterDesc).getValueAsString(),
			    	obj.getAttForDesc(overallAbgefangeneBaelleDesc).getValueAsString(),
			    	obj.getAttForDesc(overallAssistsDesc).getValueAsString(),
			    	obj.getAttForDesc(overallBallEroberungenDesc).getValueAsString(),
			    	obj.getAttForDesc(overallBallverlustDesc).getValueAsString(),
			    	obj.getAttForDesc(overallBewertungDesc).getValueAsString(),
			    	obj.getAttForDesc(overallBlockSchussDesc).getValueAsString(),
			    	obj.getAttForDesc(overallDribblingsDesc).getValueAsString(),
			    	obj.getAttForDesc(overallEinsatzquoteDesc).getValueAsString(),
			    	obj.getAttForDesc(overallFoulsDesc).getValueAsString(),
			    	obj.getAttForDesc(overallGeklaerteBaelleDesc).getValueAsString(),
			    	obj.getAttForDesc(overallGoalsDesc).getValueAsString(),
			    	obj.getAttForDesc(overallKP90Desc).getValueAsString(),
			    	obj.getAttForDesc(overallkreierteGrosschancenDesc).getValueAsString(),
			    	obj.getAttForDesc(overallMinPlayedDesc).getValueAsString(),
			    	obj.getAttForDesc(overallPassquoteDesc).getValueAsString(),	
			    	obj.getAttForDesc(overallSchussgenauigkeitDesc).getValueAsString(),    	
			    	obj.getAttForDesc(overallSH90Desc).getValueAsString(),    	
			    	obj.getAttForDesc(overallTacklingquoteDesc).getValueAsString(),
			    	obj.getAttForDesc(overallTorschussVorlagen).getValueAsString(),   	
			    	obj.getAttForDesc(overallZweikampfquoteDesc).getValueAsString(),    	
			    	obj.getAttForDesc(overallxADesc).getValueAsString(),    	
			    	obj.getAttForDesc(overallxA90Desc).getValueAsString(),    	
			    	obj.getAttForDesc(overallxGDesc).getValueAsString(),
			    	obj.getAttForDesc(overallxG90Desc).getValueAsString(),
			    	obj.getAttForDesc(positionDesc).getValueAsString(),
			    	obj.getAttForDesc(overallTorschuesseDesc).getValueAsString(),
			    	obj.getAttForDesc(overallLuftzweikampfDesc).getValueAsString(),
			    	obj.getAttForDesc(transfermarktwertDesc).getValueAsString()
		    		);		
		  
		 dataStorage.getSharedDataStorage().getRetrievalsoccerplayerList().add(soccerplayerretrieval);
		    
	    }
	    
	    
	} catch (Exception e) {
		e.printStackTrace();
	}
	
}
	}

