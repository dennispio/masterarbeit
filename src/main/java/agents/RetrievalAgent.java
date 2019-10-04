package agents;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.logging.Level;

import agentTasks.CbrTask;
import agentTasks.RetrievalTask;
import agentTasks.TestTask;
import de.dfki.mycbr.core.ICaseBase;
import de.dfki.mycbr.core.casebase.Instance;
import de.dfki.mycbr.core.model.AttributeDesc;
import de.dfki.mycbr.core.model.Concept;
import de.dfki.mycbr.core.model.IntegerDesc;
import de.dfki.mycbr.core.retrieval.Retrieval;
import de.dfki.mycbr.core.retrieval.Retrieval.RetrievalMethod;
import de.dfki.mycbr.core.similarity.Similarity;
import de.dfki.mycbr.util.Pair;
import jade.core.AID;
import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;
import jade.domain.FIPAAgentManagement.DFAgentDescription;
import jade.domain.FIPAAgentManagement.ServiceDescription;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.MessageTemplate;
import jade.lang.acl.UnreadableException;
import jade.tools.logging.ontology.GetAllLoggers;
import jade.wrapper.StaleProxyException;
import objects.Case;
import objects.DataStorage;

public class RetrievalAgent extends Agent {
	private static final long serialVersionUID = 1L;
	private RetrievalTask retrievalTask;
	protected void setup() {	
		 /**
         * Setting the agent description and service
         */
		DFAgentDescription dfd = new DFAgentDescription();
        dfd.setName(getAID());
        ServiceDescription sd = new ServiceDescription();
        sd.setType("RETRIEVALType");
        sd.setName("RETRIEVAL_AGENT");
        dfd.addServices(sd);
		// Define the behaviour
        System.out.println("agent: " + sd.getName() + " active -- type: " + sd.getType());
        this.retrievalTask = new RetrievalTask();
        this.addBehaviour(new doRetrievalTask());    
    }
     
    /**
     * method to take down the agent
     */
    protected void takeDown() {
         
    }
     
    private class doRetrievalTask extends CyclicBehaviour {
        private static final long serialVersionUID = 1L;
 
        @Override
        public void action() {
        	
        	 MessageTemplate mt = MessageTemplate.MatchPerformative(ACLMessage.REQUEST);
             mt = MessageTemplate.MatchConversationId("RETRIEVAL_AGENT");
             ACLMessage message = receive(mt);
             System.out.println(message);
                      
            if (message != null) {
            		try {
                        System.out.println("bin in RETRIEVALTASK");
						Serializable phone = message.getContentObject();
						System.out.println(phone.toString());
						retrievalTask.retrievalCases(phone);

					} catch (UnreadableException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
            } else {
                block();
            }                      
        }         
    }
}