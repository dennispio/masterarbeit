package agents;

import java.text.SimpleDateFormat;
import java.util.Date;

import agentTasks.FilterTask;
import agentTasks.GetMetaData;
import agentTasks.Legitimation;
import jade.core.AID;
import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;
import jade.core.behaviours.OneShotBehaviour;
import jade.domain.FIPAAgentManagement.DFAgentDescription;
import jade.domain.FIPAAgentManagement.ServiceDescription;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.MessageTemplate;
import objects.DataStorage;

public class FilterAgent extends Agent {
	private static final long serialVersionUID = 1L;
	private FilterTask task;
	private DataStorage dataStorage = DataStorage.getSharedDataStorage();

	protected void setup() {	
		 /**
         * Setting the agent description and service
         */
		DFAgentDescription dfd = new DFAgentDescription();
        dfd.setName(getAID());
        ServiceDescription sd = new ServiceDescription();
        sd.setType("FILTER_TYPE");
        sd.setName("FILTER_AGENT");
        dfd.addServices(sd);
		// Define the behaviour
        System.out.println("agent: " + sd.getName() + " active -- type: " + sd.getType());
        this.task = new FilterTask();
        this.addBehaviour(new Filter());
    }
     
    /**
     * method to take down the agent
     */
    protected void takeDown() {
         
    }
     
    private class Filter extends CyclicBehaviour {
        private static final long serialVersionUID = 1L;
 
        @Override
        public void action() {
            MessageTemplate mt = MessageTemplate.MatchPerformative(ACLMessage.REQUEST);
            mt = MessageTemplate.MatchConversationId("FILTER_AGENT");
            ACLMessage message = receive(mt);
                      
            if (message != null) {
            	task.filterData(DataStorage.getSharedDataStorage().getPhoneList());
        		dataStorage.getMetaData().setLastTask("FILTER_AGENT");
        		dataStorage.getMetaData().addTaskToHistorie(new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date()), "FILTER_AGENT");
            	final ACLMessage msg = new ACLMessage(ACLMessage.REQUEST);
		        AID theAgent = new AID("CBR_AGENT", false);
		        msg.addReceiver(theAgent);
		        msg.setConversationId("CBR_AGENT");
		        myAgent.send(msg);
		        ACLMessage res = myAgent.receive();

            } else {
                block();
            }    
        }         
    }
}