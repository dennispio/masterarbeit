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
	private List<Phone> phoneList;
	private List<RetrievalCase> retrievalphoneList;
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
	private Concept smartphone;
	@JsonIgnore
	private ICaseBase casebasee;


	private DataStorage() {
		this.addedCases = 0;
		this.casesCount = 0;
		this.metaData = new MetaData();
		this.statusMessage = new StatusMessage();
		this.phoneList = new ArrayList<Phone>();
		this.retrievalphoneList = new ArrayList<RetrievalCase>();
        this.engine = new CBREngine();
        System.out.println("###################");
        System.out.println(engine.getConceptName());
        this.project = engine.createProjectFromPRJ();
        this.smartphone = project.getConceptByID(engine.getConceptName());
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


    public Project getProject() {
        return project;
    }

    public CBREngine getEngine() {
		return engine;
	}

	public void setEngine(CBREngine engine) {
		this.engine = engine;
	}

	public void setProject(Project project) {
		this.project = project;
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

	public List<Phone> getPhoneList() {
		return phoneList;
	}

	public void setPhoneList(List<Phone> phoneList) {
		this.phoneList = phoneList;
	}


	public ICaseBase getCasebasee() {
		return casebasee;
	}


	public void setCasebasee(ICaseBase casebase) {
		this.casebasee = casebase;
	}


	public Concept getSmartphone() {
		return smartphone;
	}


	public void setSmartphone(Concept smartphone) {
		this.smartphone = smartphone;
	}


	public ArrayList<Case> getCases() {
		return Cases;
	}


	public void setCases(ArrayList<Case> cases) {
		Cases = cases;
	}


	public List<RetrievalCase> getRetrievalphoneList() {
		return retrievalphoneList;
	}


	public void setRetrievalphoneList(List<RetrievalCase> retrievalphoneList) {
		this.retrievalphoneList = retrievalphoneList;
	}


	public Map<String, String> getCustomQuery() {
		return customQuery;
	}


	public void setCustomQuery(Map<String, String> customQuery) {
		this.customQuery = customQuery;
	}
	
	

}
