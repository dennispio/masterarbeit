package agents;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;

import agentTasks.TestTask;
import jade.core.AID;
import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;
import jade.domain.FIPAAgentManagement.DFAgentDescription;
import jade.domain.FIPAAgentManagement.ServiceDescription;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.MessageTemplate;
import jade.wrapper.StaleProxyException;

public class TestAgent extends Agent {
	private static final long serialVersionUID = 1L;
	private TestTask testTask;
	protected void setup() {	
		 /**
         * Setting the agent description and service
         */
		DFAgentDescription dfd = new DFAgentDescription();
        dfd.setName(getAID());
        ServiceDescription sd = new ServiceDescription();
        sd.setType("TestType");
        sd.setName("TEST_AGENT");
        dfd.addServices(sd);
		// Define the behaviour
        System.out.println("agent: " + sd.getName() + " active -- type: " + sd.getType());
        this.testTask = new TestTask();
        this.addBehaviour(new doTestTask());
         
    }
     
    /**
     * method to take down the agent
     */
    protected void takeDown() {
         
    }
     
    private class doTestTask extends CyclicBehaviour {
        private static final long serialVersionUID = 1L;
 
        @Override
        public void action() {
             
            MessageTemplate mt = MessageTemplate.MatchPerformative(ACLMessage.REQUEST);
            mt = MessageTemplate.MatchConversationId("TEST");
            ACLMessage message = receive(mt);
            System.out.println(message);
                      
            if (message != null) {
            	testTask.exampleTask();
                
            } else {
                block();
            }    
        }         
    }
}