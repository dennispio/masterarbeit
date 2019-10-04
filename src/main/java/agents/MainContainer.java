package agents;

import jade.core.Profile;
import jade.core.ProfileImpl;
import jade.core.Runtime;
import jade.lang.acl.ACLMessage;
import jade.util.ExtendedProperties;
import jade.util.leap.List;
import jade.wrapper.AgentContainer;
import jade.wrapper.AgentController;
import jade.wrapper.StaleProxyException;
import objects.DataStorage;

public class MainContainer {
	
	private List agents;
	
	/**
	 * Starts the main container.
	 * @throws StaleProxyException
	 */
	public void startMainContainer() throws StaleProxyException {
		DataStorage dataStorage = DataStorage.getSharedDataStorage();
		Runtime runtime = jade.core.Runtime.instance();
		runtime.setCloseVM(true);
		/**
        * Setting profile properties
        */
		Profile profile = new ProfileImpl("127.0.0.1", 12344, null);
		profile.setParameter(Profile.GUI, "false"); 

		AgentContainer mainContainer = runtime.createMainContainer(profile);
		AgentController testAgent = mainContainer.createNewAgent("TEST_AGENT", TestAgent.class.getName(), new Object[0]);
		AgentController metaAgent = mainContainer.createNewAgent("META_AGENT", MetaAgent.class.getName(), new Object[0]);
		AgentController legiAgent = mainContainer.createNewAgent("LEGI_AGENT", LegitimationAgent.class.getName(), new Object[0]);
		AgentController fonoApiAgent = mainContainer.createNewAgent("FONOAPI_AGENT", FonoApiAgent.class.getName(), new Object[0]);
		AgentController filterAgent = mainContainer.createNewAgent("FILTER_AGENT", FilterAgent.class.getName(), new Object[0]);
		AgentController cbrAgent = mainContainer.createNewAgent("CBR_AGENT", CbrAgent.class.getName(), new Object[0]);
		AgentController retrievalAgent = mainContainer.createNewAgent("RETRIEVAL_AGENT", RetrievalAgent.class.getName(), new Object[0]);
		
		
		dataStorage.getMetaData().addAgent("TEST_AGENT");
		dataStorage.getMetaData().addAgent("META_AGENT");
		dataStorage.getMetaData().addAgent("LEGI_AGENT");
		dataStorage.getMetaData().addAgent("FONOAPI_AGENT");
		dataStorage.getMetaData().addAgent("FILTER_AGENT");
		dataStorage.getMetaData().addAgent("RETRIEVAL_AGENT");
		dataStorage.getMetaData().addAgent("CBR_AGENT");
		metaAgent.start();
		testAgent.start();
		legiAgent.start();
		fonoApiAgent.start();
		filterAgent.start();
		cbrAgent.start();
		retrievalAgent.start();
		System.out.println("_____________________________________________________");
		System.out.println("#####################################################");
		System.out.println("MAIN CONTAINER STARTED");
	}
	
	public List getAgents() {
		return agents;
	}

	public void send(ACLMessage msg) {	
	}
}
