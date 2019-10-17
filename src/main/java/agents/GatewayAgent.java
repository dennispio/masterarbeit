package agents;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import jade.core.AID;
import jade.core.behaviours.OneShotBehaviour;
import jade.lang.acl.ACLMessage;
import jade.wrapper.ControllerException;
import jade.wrapper.StaleProxyException;
import jade.wrapper.gateway.JadeGateway;
import objects.DataStorage;
import objects.QueryCase;

public class GatewayAgent {
	
	private DataStorage dataStorage = DataStorage.getSharedDataStorage();
	
	public GatewayAgent(String task, String url) {
		switch(task) {
			case "META_AGENT":
				addMetaData(task, dataStorage);
				sendMessageToMetaAgent();	
				break;
			case "FILTER_AGENT":
				addMetaData(task, dataStorage);
				sendMessageToFilterAgent(url);	
				break;
			case "FONOAPI_AGENT":
				addMetaData(task, dataStorage);
				sendMessageToFonoAPI(url);	
				break;
			case "CBR_AGENT":
				addMetaData(task, dataStorage);
				sendMessageToCbrAgent();	
				break;
			default:
				System.out.println("DEFAULT");
				break;
		}
	}
	
	public GatewayAgent(String task, QueryCase retrievalquery) {
		addMetaData(task, dataStorage);
		sendMessageToRetrievalAgent(retrievalquery);	
	}
	
	public void sendMessageToRetrievalAgent(QueryCase retrievalquery) {
		try {
			JadeGateway.execute(new OneShotBehaviour() {
			    @Override
			    public void action() {
			        final ACLMessage msg = new ACLMessage(ACLMessage.REQUEST);
			        AID theAgent = new AID("RETRIEVAL_AGENT", false);
			        msg.addReceiver(theAgent);
			        msg.setConversationId("RETRIEVAL_AGENT");
			        try {
						msg.setContentObject(retrievalquery);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			        System.out.println("BIN IN SENDMESSAGETORETRIVALAGENT");
			        myAgent.send(msg);
			        ACLMessage res = myAgent.receive();
			        if (res != null) {
			            System.out.println(res.getContent());
			        }
			    }
			});
		} catch (StaleProxyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ControllerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public void sendMessageToCbrAgent() {
		try {
			JadeGateway.execute(new OneShotBehaviour() {
			    /**
				 * 
				 */
				private static final long serialVersionUID = 1L;

				@Override
			    public void action() {
			        final ACLMessage msg = new ACLMessage(ACLMessage.REQUEST);
			        AID theAgent = new AID("CBR_AGENT", false);
			        msg.addReceiver(theAgent);
			        msg.setConversationId("TEST");
			        msg.setContent("STRING CONTENT TEST");
			        myAgent.send(msg);
			        ACLMessage res = myAgent.receive();
			        if (res != null) {
			            System.out.println(res.getContent());
			        }
			    }
			});
		} catch (StaleProxyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ControllerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public void sendMessageToTestAgent() {
		try {
			JadeGateway.execute(new OneShotBehaviour() {
			    @Override
			    public void action() {
			        final ACLMessage msg = new ACLMessage(ACLMessage.REQUEST);
			        AID theAgent = new AID("TEST_AGENT", false);
			        msg.addReceiver(theAgent);
			        msg.setConversationId("TEST");
			        msg.setContent("STRING CONTENT TEST");
			        myAgent.send(msg);
			        ACLMessage res = myAgent.receive();
			        if (res != null) {
			            System.out.println(res.getContent());
			        }
			    }
			});
		} catch (StaleProxyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ControllerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void sendMessageToMetaAgent() {
		try {
			JadeGateway.execute(new OneShotBehaviour() {
			    @Override
			    public void action() {
			        final ACLMessage msg = new ACLMessage(ACLMessage.REQUEST);
			        AID theAgent = new AID("META_AGENT", false);
			        msg.addReceiver(theAgent);
			        msg.setConversationId("META_AGENT");
			        msg.setContent("GET META DATA");
			        myAgent.send(msg);
			        ACLMessage res = myAgent.receive();
			        if (res != null) {
			            System.out.println(res.getContent());
			        }
			    }
			});
		} catch (StaleProxyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ControllerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void sendMessageToFilterAgent(String url) {
		try {
			JadeGateway.execute(new OneShotBehaviour() {
			    @Override
			    public void action() {
			        final ACLMessage msg = new ACLMessage(ACLMessage.REQUEST);
			        AID theAgent = new AID("FILTER_AGENT", false);
			        msg.addReceiver(theAgent);
			        msg.setConversationId("FILTER_AGENT");
			        msg.setContent(url);
			        myAgent.send(msg);
			        ACLMessage res = myAgent.receive();
			        if (res != null) {
			            System.out.println(res.getContent());
			        }
			    }
			});
		} catch (StaleProxyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ControllerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void sendMessageToFonoAPI(String url) {
		try {
			JadeGateway.execute(new OneShotBehaviour() {
			    @Override
			    public void action() {
			        final ACLMessage msg = new ACLMessage(ACLMessage.REQUEST);
			        AID theAgent = new AID("FONOAPI_AGENT", false);
			        msg.addReceiver(theAgent);
			        msg.setConversationId("FONOAPI_AGENT");
			        msg.setContent(url);
			        myAgent.send(msg);
			        ACLMessage res = myAgent.receive();
			        if (res != null) {
			            System.out.println(res.getContent());
			        }
			    }
			});
		} catch (StaleProxyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ControllerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/*
	 * Method to add MetaData to the DataStorage object evey time an agent
	 * does a task
	 */
	public void addMetaData(String task, DataStorage dataStorage) {
		dataStorage.getMetaData().setLastTask(task);
		dataStorage.getMetaData().addTaskToHistorie(new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date()), task);
	}

	public DataStorage getDataStorage() {
		return dataStorage;
	}

	public void setDataStorage(DataStorage dataStorage) {
		this.dataStorage = dataStorage;
	}

}
