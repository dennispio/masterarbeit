  package controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import agents.GatewayAgent;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import jade.wrapper.ControllerException;
import jade.wrapper.gateway.JadeGateway;
import objects.DataStorage;
import objects.QueryCase;
import jade.core.AID;
import jade.core.Profile;
import jade.domain.FIPAAgentManagement.DFAgentDescription;
import jade.domain.FIPAAgentManagement.ServiceDescription;
import jade.util.leap.List;
import jade.util.leap.Properties;

import java.util.Map;

import org.springframework.web.bind.annotation.*;

@RestController
public class AgentController {
		
	   @CrossOrigin(origins="http://localhost:3000")
	   @RequestMapping("/mas")
	    public GatewayAgent greeting(@RequestParam(value="task", defaultValue="META_AGENT") String task) {
	        return new GatewayAgent(task, "/");
	    }
	   
	   @CrossOrigin(origins="http://localhost:3000")
	   @RequestMapping("/filter")
	    public GatewayAgent filter() {
	        return new GatewayAgent("FILTER_AGENT", "/");
	    }
	   
	   @CrossOrigin(origins="http://localhost:3000")
	   @RequestMapping("/scrap")
	    public GatewayAgent fono() {
	        return new GatewayAgent("FONOAPI_AGENT", "/");
	    }
	   
	   @CrossOrigin(origins="http://localhost:3000")
	    @RequestMapping(method = RequestMethod.GET, value = "/retrievalPlayer")
	    public GatewayAgent doRetrievalTask(@RequestParam Map<String, String> customQuery) {
		
	    if(customQuery.get("spielername").equals("undefined")) {
	    	QueryCase player = new QueryCase(
	    	    	customQuery.get("alter"),
	    	    	customQuery.get("anzahl"),
	    	    	customQuery.get("spielername"),
	    	    	customQuery.get("overallAbgefangeneBaelle"),
	    	    	customQuery.get("overallAssists"),
	    	    	customQuery.get("overallBallEroberungen"),
	    	    	customQuery.get("overallBallverlust"),
	    	    	customQuery.get("overallBewertung"),
	    	    	customQuery.get("overallBlockSchuss"),
	    	    	customQuery.get("overallDribblings"),
	    	    	customQuery.get("overallEinsatzquote"),
	    	    	customQuery.get("overallFouls"),
	    	    	customQuery.get("overallGeklaerteBaelle"),
	    	    	customQuery.get("overallGoals"),
	    	    	customQuery.get("overallKP90"),
	    	    	customQuery.get("overallKreierteGrosschancen"),
	    	    	customQuery.get("overallPassquote"),
	    	    	customQuery.get("overallSchussgenauigkeit"),
	    	    	customQuery.get("overallSh90"),
	    	    	customQuery.get("overallTacklingquote"),
	    	    	customQuery.get("overallTorschussVorlagen"),
	    	    	customQuery.get("overallZweikampfquote"),
	    	    	customQuery.get("overallxA"),
	    	    	customQuery.get("overallxA90"),
	    	    	customQuery.get("overallxG"),
	    	    	customQuery.get("overallxG90"),
	    	    	customQuery.get("position"),
	    	    	customQuery.get("spieltagbewertung"),
	    	    	customQuery.get("overallTorschuesse"),
	    	    	customQuery.get("overallLuftzweikampf"),
	    	    	customQuery.get("transfermarktwert"),
	    	    	customQuery.get("spielertyp"));
	    			return new GatewayAgent("RETRIEVAL_AGENT", player);
	    	
	    }else {
	    			QueryCase player = new QueryCase(
	    	    	customQuery.get("spielername"),
	    	    	customQuery.get("anzahl"),
	    	    	customQuery.get("spielertyp"));
	    			return new GatewayAgent("RETRIEVAL_AGENT", player);
	    }
	   }
	   
	   @CrossOrigin(origins="http://localhost:3000")
	   @RequestMapping("/caseInfos")
	    public DataStorage data()  {
		   DataStorage dataStorage = DataStorage.getSharedDataStorage();
		   dataStorage.setCasesCount(dataStorage.getCasebasee().getCases().size());
	       return dataStorage;
	   }
}
