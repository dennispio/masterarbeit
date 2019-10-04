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
import objects.Phone;
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
	   @RequestMapping("/scrap")
	    public GatewayAgent legitimation(@RequestParam Map<String, String> customQuery) {
		   	DataStorage dataStorage = DataStorage.getSharedDataStorage();
		   	dataStorage.setCustomQuery(customQuery);
	        return new GatewayAgent("LEGI_AGENT", customQuery.get("url"));
	    }
	   
	   @CrossOrigin(origins="http://localhost:3000")
	    @RequestMapping(method = RequestMethod.GET, value = "/retrieval")
	    public GatewayAgent doRetrievalTask(@RequestParam Map<String, String> customQuery) {	       
	        QueryCase phone = new QueryCase(
	        		customQuery.get("manufacture"), customQuery.get("manufacturecheck"), 
	        		customQuery.get("price"), customQuery.get("pricecheck"),
	        		customQuery.get("weight"), customQuery.get("weightcheck"),
	        		customQuery.get("size"), customQuery.get("sizecheck"),
	        		customQuery.get("displaytype"),customQuery.get("displaytypecheck"),
	        		customQuery.get("cpu"),	customQuery.get("cpucheck"),
	        		customQuery.get("ram"), customQuery.get("ramcheck"),
	        		customQuery.get("akkukapa"), customQuery.get("akkukapacheck"),
	        		customQuery.get("kameramegapixel"), customQuery.get("kameramegapixelcheck"),
	        		customQuery.get("frontkamera"), customQuery.get("frontkameracheck"),
	        		customQuery.get("memoryslot"), customQuery.get("memoryslotcheck"),
	        		customQuery.get("memory"), customQuery.get("memorycheck"),
	        		customQuery.get("nfc"), customQuery.get("nfccheck"),
	        		customQuery.get("thickness"), customQuery.get("thicknesscheck"),
	        		Integer.parseInt(customQuery.get("anzahl"))
	        		);
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
