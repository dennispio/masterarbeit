package objects;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MetaData {

	private ArrayList<String> agents;
	private String lastTask;
	private	Map<String, String> taskHistorie;
	
	public MetaData() {
		this.agents = new ArrayList<String>();
		this.taskHistorie = new HashMap<>();
	}

	public ArrayList<String> getAgents() {
		return agents;
	}

	public void addAgent(String agentName) {
		this.agents.add(agentName);
	}

	public String getLastTask() {
		return lastTask;
	}

	public void setLastTask(String lastTask) {
		this.lastTask = lastTask;
	}

	public Map<String, String> getTaskHistorie() {
		return taskHistorie;
	}

	public void addTaskToHistorie(String timestamp, String task) {
		this.taskHistorie.put(timestamp, task);
	}

}
