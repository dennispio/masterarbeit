package agents;

import agentTasks.GetMetaData;
import agentTasks.TestTask;
import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;
import jade.domain.FIPAAgentManagement.DFAgentDescription;
import jade.domain.FIPAAgentManagement.ServiceDescription;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.MessageTemplate;

public class MetaAgent extends Agent {
	private static final long serialVersionUID = 1L;
	private GetMetaData task;
	protected void setup() {	
		 /**
         * Setting the agent description and service
         */
		DFAgentDescription dfd = new DFAgentDescription();
        dfd.setName(getAID());
        ServiceDescription sd = new ServiceDescription();
        sd.setType("META_TYPE");
        sd.setName("META_AGENT");
        dfd.addServices(sd);
		// Define the behaviour
        System.out.println("agent: " + sd.getName() + " active -- type: " + sd.getType());
        this.task = new GetMetaData();
        this.addBehaviour(new getMetaData());
    }
     
    /**
     * method to take down the agent
     */
    protected void takeDown() {
         
    }
     
    private class getMetaData extends CyclicBehaviour {
        private static final long serialVersionUID = 1L;
 
        @Override
        public void action() {
             
            MessageTemplate mt = MessageTemplate.MatchPerformative(ACLMessage.REQUEST);
            mt = MessageTemplate.MatchConversationId("META_AGENT");
            ACLMessage message = receive(mt);
                      
            if (message != null) {
            	task.getMetaData();
                
            } else {
                block();
            }    
        }         
    }
}
