package agents;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import org.json.JSONException;

import agentTasks.APICrawler;
import agentTasks.TestTask;
import jade.core.AID;
import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;
import jade.domain.FIPAAgentManagement.DFAgentDescription;
import jade.domain.FIPAAgentManagement.ServiceDescription;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.MessageTemplate;
import objects.DataStorage;

public class FonoApiAgent extends Agent {
	private DataStorage dataStorage = DataStorage.getSharedDataStorage();
	private static final long serialVersionUID = 1L;
	private APICrawler apiCrawler = new APICrawler();
	protected void setup() {	
		 /**
         * Setting the agent description and service
         */
		DFAgentDescription dfd = new DFAgentDescription();
        dfd.setName(getAID());
        ServiceDescription sd = new ServiceDescription();
        sd.setType("FonoApi");
        sd.setName("FONOAPI_AGENT");
        dfd.addServices(sd);
		// Define the behaviour
        System.out.println("agent: " + sd.getName() + " active -- type: " + sd.getType());
        this.addBehaviour(new crawlAPI());
         
    }
     
    /**
     * method to take down the agent
     */
    protected void takeDown() {
         
    }
     
    private class crawlAPI extends CyclicBehaviour {
        private static final long serialVersionUID = 1L;
 
        @Override
        public void action() {
            MessageTemplate mt = MessageTemplate.MatchPerformative(ACLMessage.REQUEST);
            mt = MessageTemplate.MatchConversationId("FONOAPI_AGENT");
            ACLMessage message = receive(mt);
            if (message != null) {
                DataStorage dataStorage = DataStorage.getSharedDataStorage();
				Map<String, String> customQuery = dataStorage.getCustomQuery();

    		//	if(!customQuery.get("sony").equalsIgnoreCase("true")) {
			//		apiCrawler.crawlApi("sony");
    		//	}
				
				try {
					apiCrawler.crawlApi();
					dataStorage.getMetaData().setLastTask("FONOAPI_AGENT");
					dataStorage.getMetaData().addTaskToHistorie(new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date()), "FONOAPI_AGENT");
					System.out.println(dataStorage.getSoccerplayerList());
					final ACLMessage msg = new ACLMessage(ACLMessage.REQUEST);
					AID theAgent = new AID("FILTER_AGENT", false);
					msg.addReceiver(theAgent);
					msg.setConversationId("FILTER_AGENT");
					myAgent.send(msg);
					ACLMessage res = myAgent.receive();
					if (res != null) {
					    System.out.println(res.getContent());
					}
					else {
						block();
	            }  
				} catch (JSONException | IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
						 
            }         
        }
    }
}