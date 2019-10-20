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
	    dataStorage.getSharedDataStorage().getRetrievalsoccerplayerList().clear();

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
	    FloatDesc  overallTorschussVorlagen = (FloatDesc) soccerplayer.getAllAttributeDescs().get("OverallxG90");
	    SymbolDesc positionDesc = (SymbolDesc) soccerplayer.getAllAttributeDescs().get("Position");
	    
		System.out.println(ph.getName()+"##############-NAME-##############");
		
		if(!(ph.getName().equals("undefined"))){
			System.out.println(soccerplayer.getInstance(ph.getName())+ "es klappt den spieler zu catchen");
			System.out.println(soccerplayer.getInstance(ph.getName()).getAttForDesc(alterDesc).getValueAsString() + "es klappt den spieler zu catchen");
			
			
			query.addAttribute(alterDesc, alterDesc.getAttribute(Integer.parseInt(soccerplayer.getInstance(ph.getName()).getAttForDesc(alterDesc).getValueAsString())));
	    	query.addAttribute(overallAbgefangeneBaelleDesc, overallAbgefangeneBaelleDesc.getAttribute(Float.parseFloat(soccerplayer.getInstance(ph.getName()).getAttForDesc(overallAbgefangeneBaelleDesc).getValueAsString())));
	    	query.addAttribute(overallAssistsDesc, overallAssistsDesc.getAttribute(Integer.parseInt(soccerplayer.getInstance(ph.getName()).getAttForDesc(overallAssistsDesc).getValueAsString())));
	    	query.addAttribute(overallBallEroberungenDesc, overallBallEroberungenDesc.getAttribute(Float.parseFloat(soccerplayer.getInstance(ph.getName()).getAttForDesc(overallBallEroberungenDesc).getValueAsString())));
	    	query.addAttribute(overallBallverlustDesc, overallBallverlustDesc.getAttribute(Float.parseFloat(soccerplayer.getInstance(ph.getName()).getAttForDesc(overallBallverlustDesc).getValueAsString())));
	    	query.addAttribute(overallBewertungDesc, overallBewertungDesc.getAttribute(Float.parseFloat(soccerplayer.getInstance(ph.getName()).getAttForDesc(overallBewertungDesc).getValueAsString())));
	    	query.addAttribute(overallBlockSchussDesc, overallBlockSchussDesc.getAttribute(Float.parseFloat(soccerplayer.getInstance(ph.getName()).getAttForDesc(overallBlockSchussDesc).getValueAsString())));
	    	query.addAttribute(overallDribblingsDesc, overallDribblingsDesc.getAttribute(Float.parseFloat(soccerplayer.getInstance(ph.getName()).getAttForDesc(overallDribblingsDesc).getValueAsString())));
	    	query.addAttribute(overallEinsatzquoteDesc, overallEinsatzquoteDesc.getAttribute(Float.parseFloat(soccerplayer.getInstance(ph.getName()).getAttForDesc(overallEinsatzquoteDesc).getValueAsString())));
	    	query.addAttribute(overallFoulsDesc, overallFoulsDesc.getAttribute(Float.parseFloat(soccerplayer.getInstance(ph.getName()).getAttForDesc(overallFoulsDesc).getValueAsString())));
	    	query.addAttribute(overallGeklaerteBaelleDesc, overallGeklaerteBaelleDesc.getAttribute(Float.parseFloat(soccerplayer.getInstance(ph.getName()).getAttForDesc(overallGeklaerteBaelleDesc).getValueAsString())));
	    	query.addAttribute(overallGoalsDesc, overallGoalsDesc.getAttribute(Integer.parseInt(soccerplayer.getInstance(ph.getName()).getAttForDesc(overallGoalsDesc).getValueAsString())));
	    	query.addAttribute(overallKP90Desc, overallKP90Desc.getAttribute(Float.parseFloat(soccerplayer.getInstance(ph.getName()).getAttForDesc(overallKP90Desc).getValueAsString())));
	    	query.addAttribute(overallkreierteGrosschancenDesc, overallkreierteGrosschancenDesc.getAttribute(Float.parseFloat(soccerplayer.getInstance(ph.getName()).getAttForDesc(overallkreierteGrosschancenDesc).getValueAsString())));
	    	query.addAttribute(overallMinPlayedDesc, overallMinPlayedDesc.getAttribute(Integer.parseInt(soccerplayer.getInstance(ph.getName()).getAttForDesc(overallMinPlayedDesc).getValueAsString())));
	    	query.addAttribute(overallPassquoteDesc, overallPassquoteDesc.getAttribute(Float.parseFloat(soccerplayer.getInstance(ph.getName()).getAttForDesc(overallPassquoteDesc).getValueAsString())));
	    	query.addAttribute(overallSchussgenauigkeitDesc, overallSchussgenauigkeitDesc.getAttribute(Float.parseFloat(soccerplayer.getInstance(ph.getName()).getAttForDesc(overallSchussgenauigkeitDesc).getValueAsString())));
	    	query.addAttribute(overallSH90Desc, overallSH90Desc.getAttribute(Float.parseFloat(soccerplayer.getInstance(ph.getName()).getAttForDesc(overallSH90Desc).getValueAsString())));
	    	query.addAttribute(overallTacklingquoteDesc, overallTacklingquoteDesc.getAttribute(Float.parseFloat(soccerplayer.getInstance(ph.getName()).getAttForDesc(overallTacklingquoteDesc).getValueAsString())));
	    	query.addAttribute(overallZweikampfquoteDesc, overallZweikampfquoteDesc.getAttribute(Float.parseFloat(soccerplayer.getInstance(ph.getName()).getAttForDesc(overallZweikampfquoteDesc).getValueAsString())));
	    	query.addAttribute(overallxADesc, overallxADesc.getAttribute(Float.parseFloat(soccerplayer.getInstance(ph.getName()).getAttForDesc(overallxADesc).getValueAsString())));
	    	query.addAttribute(overallxA90Desc, overallxA90Desc.getAttribute(Float.parseFloat(soccerplayer.getInstance(ph.getName()).getAttForDesc(overallxA90Desc).getValueAsString())));
	    	query.addAttribute(overallxGDesc, overallxGDesc.getAttribute(Float.parseFloat(soccerplayer.getInstance(ph.getName()).getAttForDesc(overallxGDesc).getValueAsString())));
	    	query.addAttribute(overallxG90Desc, overallxG90Desc.getAttribute(Float.parseFloat(soccerplayer.getInstance(ph.getName()).getAttForDesc(overallxG90Desc).getValueAsString())));
	    	query.addAttribute(overallTorschussVorlagen, overallTorschussVorlagen.getAttribute(Float.parseFloat(soccerplayer.getInstance(ph.getName()).getAttForDesc(overallTorschussVorlagen).getValueAsString())));
	    	query.addAttribute(positionDesc, positionDesc.getAttribute(soccerplayer.getInstance(ph.getName()).getAttForDesc(positionDesc).getValueAsString()));

			System.out.println("bin in der Spieleraustauschsuche");
	
		}else {
			query.addAttribute(alterDesc, alterDesc.getAttribute(1));
	    	query.addAttribute(overallAbgefangeneBaelleDesc, overallAbgefangeneBaelleDesc.getAttribute(1));
	    	query.addAttribute(overallAssistsDesc, overallAssistsDesc.getAttribute(1));
	    	query.addAttribute(overallBallEroberungenDesc, overallBallEroberungenDesc.getAttribute(1));
	    	query.addAttribute(overallBallverlustDesc, overallBallverlustDesc.getAttribute(1));
	    	query.addAttribute(overallBewertungDesc, overallBewertungDesc.getAttribute(1));
	    	query.addAttribute(overallBlockSchussDesc, overallBlockSchussDesc.getAttribute(1));
	    	query.addAttribute(overallDribblingsDesc, overallDribblingsDesc.getAttribute(1));
	    	query.addAttribute(overallEinsatzquoteDesc, overallEinsatzquoteDesc.getAttribute(1));
	    	query.addAttribute(overallFoulsDesc, overallFoulsDesc.getAttribute(1));
	    	query.addAttribute(overallGeklaerteBaelleDesc, overallGeklaerteBaelleDesc.getAttribute(1));
	    	query.addAttribute(overallGoalsDesc, overallGoalsDesc.getAttribute(1));
	    	query.addAttribute(overallKP90Desc, overallKP90Desc.getAttribute(1));
	    	query.addAttribute(overallkreierteGrosschancenDesc, overallkreierteGrosschancenDesc.getAttribute(1));
	    	query.addAttribute(overallMinPlayedDesc, overallMinPlayedDesc.getAttribute(1));
	    	query.addAttribute(overallPassquoteDesc, overallPassquoteDesc.getAttribute(1));
	    	query.addAttribute(overallSchussgenauigkeitDesc, overallSchussgenauigkeitDesc.getAttribute(1));
	    	query.addAttribute(overallSH90Desc, overallSH90Desc.getAttribute(1));
	    	query.addAttribute(overallTacklingquoteDesc, overallTacklingquoteDesc.getAttribute(1));
	    	query.addAttribute(overallZweikampfquoteDesc, overallZweikampfquoteDesc.getAttribute(1));
	    	query.addAttribute(overallxADesc, overallxADesc.getAttribute(1));
	    	query.addAttribute(overallxA90Desc, overallxA90Desc.getAttribute(1));
	    	query.addAttribute(overallxGDesc, overallxGDesc.getAttribute(1));
	    	query.addAttribute(overallxG90Desc, overallxG90Desc.getAttribute(1));
	    	query.addAttribute(overallTorschussVorlagen, overallTorschussVorlagen.getAttribute(Float.parseFloat(soccerplayer.getInstance(ph.getName()).getAttForDesc(overallTorschussVorlagen).getValueAsString())));
	    	query.addAttribute(positionDesc, positionDesc.getAttribute("RM"));
		}
    	
  
	    
	 //   if(Integer.parseInt(ph.getNfccheck()) > 0) {
	//	    query.addAttribute(nfcDesc, nfcDesc.getAttribute(ph.getNfc()));
	  //  	smartphone.getActiveAmalgamFct().setWeight(nfcDesc, Integer.parseInt(ph.getNfccheck()));
	  //  }
	    
	    System.out.println("##########################ICH WAR HIER IM RETRIEVAL######################");
	    
	    retrieve.start();
	    
	    List <Pair<Instance, Similarity>> result = retrieve.getResult();

	    for (int i = 0; i < 10; i++) {
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
			    	obj.getAttForDesc(positionDesc).getValueAsString()
		    		);		
		    
		 dataStorage.getSharedDataStorage().getRetrievalsoccerplayerList().add(soccerplayerretrieval);
		    
	    }
	    
	    
	} catch (Exception e) {
		e.printStackTrace();
	}
	
}
	}

