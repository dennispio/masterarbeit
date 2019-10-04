package agents;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;

import agentTasks.CbrTask;
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
import jade.core.behaviours.OneShotBehaviour;
import jade.domain.FIPAAgentManagement.DFAgentDescription;
import jade.domain.FIPAAgentManagement.ServiceDescription;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.MessageTemplate;
import jade.tools.logging.ontology.GetAllLoggers;
import jade.wrapper.StaleProxyException;
import objects.Case;
import objects.DataStorage;
import objects.Phone;

public class CbrAgent extends Agent {
	private static final long serialVersionUID = 1L;
	private CbrTask cbrTask;
	private DataStorage dataStorage = DataStorage.getSharedDataStorage();

	protected void setup() {	
		 /**
         * Setting the agent description and service
         */
		DFAgentDescription dfd = new DFAgentDescription();
        dfd.setName(getAID());
        ServiceDescription sd = new ServiceDescription();
        sd.setType("CBRType");
        sd.setName("CBR_AGENT");
        dfd.addServices(sd);
		// Define the behaviour
        System.out.println("agent: " + sd.getName() + " active -- type: " + sd.getType());
        this.cbrTask = new CbrTask();
        this.addBehaviour(new doCbrTask());
         
    }
     
    /**
     * method to take down the agent
     */
    protected void takeDown() {
         
    }
     
    private class doCbrTask extends CyclicBehaviour {
        private static final long serialVersionUID = 1L;
 
        @Override
        public void action() {
        	
        	MessageTemplate mt = MessageTemplate.MatchPerformative(ACLMessage.REQUEST);
            mt = MessageTemplate.MatchConversationId("CBR_AGENT");
            ACLMessage message = receive(mt);
                      
            if (message != null) {
            	cbrTask.saveCases();
    		    dataStorage.getPhoneList().clear();

            } else {
                block();
            }    
            
//    		DataStorage.getSharedDataStorage().getCasebasee().addCase(inii);			
    		dataStorage.getMetaData().setLastTask("CASE_AGENT");
    		dataStorage.getMetaData().addTaskToHistorie(new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date()), "CASE_AGENT");
    		System.out.println("#############'CASES'###################");
    		System.out.println(DataStorage.getSharedDataStorage().getCasebasee().getCases().size());
        }         
    }
}