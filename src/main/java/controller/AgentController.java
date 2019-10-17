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
	    @RequestMapping(method = RequestMethod.GET, value = "/retrieval")
	    public GatewayAgent doRetrievalTask(@RequestParam Map<String, String> customQuery) {
   		//customQuery.get("manufacture"), customQuery.get("manufacturecheck"), 

	    QueryCase phone = new QueryCase();
			return new GatewayAgent("RETRIEVAL_AGENT", phone);
	   }
	   
	   @CrossOrigin(origins="http://localhost:3000")
	   @RequestMapping("/caseInfos")
	    public DataStorage data()  {
		   DataStorage dataStorage = DataStorage.getSharedDataStorage();
		   dataStorage.setCasesCount(dataStorage.getCasebasee().getCases().size());
	       return dataStorage;
	   }
}
