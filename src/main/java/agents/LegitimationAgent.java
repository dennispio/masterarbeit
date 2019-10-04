package agents;

import agentTasks.GetMetaData;
import agentTasks.Legitimation;
import jade.core.AID;
import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;
import jade.domain.FIPAAgentManagement.DFAgentDescription;
import jade.domain.FIPAAgentManagement.ServiceDescription;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.MessageTemplate;
import objects.DataStorage;

public class LegitimationAgent extends Agent {
	private static final long serialVersionUID = 1L;
	private Legitimation task;
	protected void setup() {	
		 /**
         * Setting the agent description and service
         */
		DFAgentDescription dfd = new DFAgentDescription();
        dfd.setName(getAID());
        ServiceDescription sd = new ServiceDescription();
        sd.setType("LEGI_TYPE");
        sd.setName("LEGI_AGENT");
        dfd.addServices(sd);
		// Define the behaviour
        System.out.println("agent: " + sd.getName() + " active -- type: " + sd.getType());
        this.task = new Legitimation();
        this.addBehaviour(new legitimation());
    }
     
    /**
     * method to take down the agent
     */
    protected void takeDown() {
         
    }
     
    private class legitimation extends CyclicBehaviour {
        private static final long serialVersionUID = 1L;
 
        @Override
        public void action() {
            MessageTemplate mt = MessageTemplate.MatchPerformative(ACLMessage.REQUEST);
            mt = MessageTemplate.MatchConversationId("LEGI_AGENT");
            ACLMessage message = receive(mt);
                      
            if (message != null) {
            	//Wenn Link ein Link ist, welcher der Agent kennt
            	if(task.checkLink(message.getContent())) {
            		DataStorage dataStorage = DataStorage.getSharedDataStorage();
            		dataStorage.getStatusMessage().setMessage("Link " + message.getContent() + " gültig! Fälle werden erstellt");
            		dataStorage.getStatusMessage().setWasSuccesfull(true);
            		String url = message.getContent();
            		String nextAgent = task.getDataAgent(message.getContent());
            		System.out.println(nextAgent);
            		
			        final ACLMessage msg = new ACLMessage(ACLMessage.REQUEST);
			        AID theAgent = new AID(nextAgent, false);
			        msg.addReceiver(theAgent);
			        msg.setConversationId(nextAgent);
			        msg.setContent(url);
			        myAgent.send(msg);
			        ACLMessage res = myAgent.receive();
			        if (res != null) {
			            System.out.println(res.getContent());
			        }	
            	}
            	//Wenn Link ein falscher ist
            	else {
            		DataStorage dataStorage = DataStorage.getSharedDataStorage();
            		dataStorage.getStatusMessage().setMessage("Ungültiger Link");
            		dataStorage.getStatusMessage().setWasSuccesfull(false);
            	}
            } else {
                block();
            }    
        }         
    }
}

