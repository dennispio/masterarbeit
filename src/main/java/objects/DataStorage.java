package objects;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnore;

import de.dfki.mycbr.core.ICaseBase;
import de.dfki.mycbr.core.Project;
import de.dfki.mycbr.core.model.Concept;
import no.ntnu.mycbr.CBREngine;

/*
 * Singleton
 */

public class DataStorage {

	private String test;
	private MetaData metaData;
	private StatusMessage statusMessage;
	private List<Player> soccerplayerList;
	private List<RetrievalCase> retrievalsoccerplayerList;
	private ArrayList<Case> Cases = new ArrayList<Case>(); 
	private int addedCases = 0;
	private int casesCount;
	public int getAddedCases() {
		return addedCases;
	}


	public void setAddedCases(int addedCases) {
		this.addedCases = addedCases;
	}


	public int getCasesCount() {
		return casesCount;
	}


	public void setCasesCount(int casesCount) {
		this.casesCount = casesCount;
	}


	@JsonIgnore
	private Map<String, String> customQuery;
	@JsonIgnore
	private CBREngine engine;
	@JsonIgnore
    private Project project;
	private static DataStorage _data;
	@JsonIgnore
	private Concept soccerplayer;
	@JsonIgnore
	private ICaseBase casebasee;


	//Konstruktor DataStorage Objekt
	private DataStorage() {
		this.addedCases = 0;
		this.casesCount = 0;
		this.metaData = new MetaData();
		this.statusMessage = new StatusMessage();
		this.soccerplayerList = new ArrayList<Player>();
		this.retrievalsoccerplayerList = new ArrayList<RetrievalCase>();
        this.engine = new CBREngine();
        System.out.println("###################");
        System.out.println(engine.getConceptName());
        this.project = engine.createProjectFromPRJ();
        this.soccerplayer = project.getConceptByID(engine.getConceptName());
        try {
			this.casebasee = project.createDefaultCB("cb");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public static DataStorage getSharedDataStorage() {
		if(_data == null) {
			_data = new DataStorage();
		}
		return _data;
	}


	public String getTest() {
		return test;
	}


	public void setTest(String test) {
		this.test = test;
	}


	public MetaData getMetaData() {
		return metaData;
	}


	public void setMetaData(MetaData metaData) {
		this.metaData = metaData;
	}


	public StatusMessage getStatusMessage() {
		return statusMessage;
	}


	public void setStatusMessage(StatusMessage statusMessage) {
		this.statusMessage = statusMessage;
	}


	public List<Player> getSoccerplayerList() {
		return soccerplayerList;
	}


	public void setSoccerplayerList(List<Player> soccerplayerList) {
		this.soccerplayerList = soccerplayerList;
	}


	public List<RetrievalCase> getRetrievalsoccerplayerList() {
		return retrievalsoccerplayerList;
	}


	public void setRetrievalsoccerplayerList(List<RetrievalCase> retrievalsoccerplayerList) {
		this.retrievalsoccerplayerList = retrievalsoccerplayerList;
	}


	public ArrayList<Case> getCases() {
		return Cases;
	}


	public void setCases(ArrayList<Case> cases) {
		Cases = cases;
	}


	public Map<String, String> getCustomQuery() {
		return customQuery;
	}


	public void setCustomQuery(Map<String, String> customQuery) {
		this.customQuery = customQuery;
	}


	public CBREngine getEngine() {
		return engine;
	}


	public void setEngine(CBREngine engine) {
		this.engine = engine;
	}


	public Project getProject() {
		return project;
	}


	public void setProject(Project project) {
		this.project = project;
	}


	public static DataStorage get_data() {
		return _data;
	}


	public static void set_data(DataStorage _data) {
		DataStorage._data = _data;
	}


	public Concept getSoccerplayer() {
		return soccerplayer;
	}


	public void setSoccerplayer(Concept soccerplayer) {
		soccerplayer = soccerplayer;
	}


	public ICaseBase getCasebasee() {
		return casebasee;
	}


	public void setCasebasee(ICaseBase casebasee) {
		this.casebasee = casebasee;
	}	

}
