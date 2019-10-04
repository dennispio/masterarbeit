package agentTasks;

import java.io.Serializable;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import de.dfki.mycbr.core.ICaseBase;
import de.dfki.mycbr.core.casebase.Instance;
import de.dfki.mycbr.core.model.Concept;
import de.dfki.mycbr.core.model.FloatDesc;
import de.dfki.mycbr.core.model.IntegerDesc;
import de.dfki.mycbr.core.model.StringDesc;
import de.dfki.mycbr.core.model.SymbolDesc;
import de.dfki.mycbr.core.retrieval.Retrieval;
import de.dfki.mycbr.core.retrieval.Retrieval.RetrievalMethod;
import de.dfki.mycbr.core.similarity.Similarity;
import de.dfki.mycbr.util.Pair;
import jade.content.lang.sl.ParseException;
import objects.Case;
import objects.DataStorage;
import objects.Phone;
import objects.QueryCase;
import objects.RetrievalCase;

public class RetrievalTask {
	private String message;
	
	public RetrievalTask() {
		message = "MESSAGE";
	}
	
	public String getMessage() {
		return this.message;
	}
	
	public void retrievalCases(Serializable phone) {
		DataStorage dataStorage = DataStorage.getSharedDataStorage();

	try {
		
		QueryCase ph = (QueryCase) phone;
		
		System.out.println(ph.toString());
		
		Concept smartphone = DataStorage.getSharedDataStorage().getProject().getConceptByID("Smartphone");

	    ICaseBase cb = DataStorage.getSharedDataStorage().getCasebasee();
	    dataStorage.getSharedDataStorage().getRetrievalphoneList().clear();

	    Retrieval retrieve = new Retrieval(smartphone, cb);
	    retrieve.setRetrievalMethod(RetrievalMethod.RETRIEVE_SORTED);
	    
	    Instance query = retrieve.getQueryInstance();	    
	  	
	    SymbolDesc manufactureDesc = (SymbolDesc) smartphone.getAllAttributeDescs().get("manufacture");
	    StringDesc modelDesc = (StringDesc) smartphone.getAllAttributeDescs().get("model");
	    StringDesc resolutionDesc = (StringDesc) smartphone.getAllAttributeDescs().get("resolution");
	    IntegerDesc ramDesc = (IntegerDesc) smartphone.getAllAttributeDescs().get("arbeitsspeicher");
	    FloatDesc  priceDesc = (FloatDesc) smartphone.getAllAttributeDescs().get("price");
	    FloatDesc  sizeDesc = (FloatDesc) smartphone.getAllAttributeDescs().get("size");
	    SymbolDesc displaytypeDesc = (SymbolDesc) smartphone.getAllAttributeDescs().get("displaytype");
	    SymbolDesc cpuDesc = (SymbolDesc) smartphone.getAllAttributeDescs().get("cpu");
	    FloatDesc  weightDesc = (FloatDesc) smartphone.getAllAttributeDescs().get("weight");
	    FloatDesc  akkukapaDesc = (FloatDesc) smartphone.getAllAttributeDescs().get("akkukapa");
	    FloatDesc  kameramegapixelDesc = (FloatDesc) smartphone.getAllAttributeDescs().get("kameramegapixel");
	    FloatDesc  frontkameraDesc = (FloatDesc) smartphone.getAllAttributeDescs().get("frontkameramegapixel");
	    SymbolDesc memoryslotDesc = (SymbolDesc) smartphone.getAllAttributeDescs().get("memoryslot");
	    FloatDesc  memoryDesc = (FloatDesc) smartphone.getAllAttributeDescs().get("memory");
	    IntegerDesc nfcDesc = (IntegerDesc) smartphone.getAllAttributeDescs().get("nfc");
	    FloatDesc  thicknessDesc = (FloatDesc) smartphone.getAllAttributeDescs().get("thickness");
	    	    
	    

	    System.out.println(ph.toString());
	    
	    if(Integer.parseInt(ph.getManufacturecheck()) > 0) {
		    if(!"keineangabe".equals(ph.getManufacture())) {
			    query.addAttribute(manufactureDesc, manufactureDesc.getAttribute(ph.getManufacture()));
			    smartphone.getActiveAmalgamFct().setWeight(manufactureDesc, Integer.parseInt(ph.getManufacturecheck()));
			    System.out.println("BIN IN DEN IF BEDINUNGEN manu");
		    }
	    }
	    
	    if(Integer.parseInt(ph.getRamcheck()) > 0) {
		    if(!"keineangabe".equals(ph.getRam())) {
			    System.out.println("BIN IN DEN IF BEDINUNGEN ram");
	
		    	query.addAttribute(ramDesc, ramDesc.getAttribute(ph.getRam()));
			    smartphone.getActiveAmalgamFct().setWeight(ramDesc, Integer.parseInt(ph.getRamcheck()));
			    System.out.println("BIN IN DEN IF BEDINUNGEN ram");
		    }
	    }
	    
	    if(Integer.parseInt(ph.getPricecheck()) > 0) {
		    if(Integer.parseInt(ph.getPrice()) >= 0) {
		    	query.addAttribute(priceDesc, priceDesc.getAttribute(ph.getPrice()));
			    smartphone.getActiveAmalgamFct().setWeight(priceDesc, Integer.parseInt(ph.getPricecheck()));
			    System.out.println("BIN IN DEN IF BEDINUNGEN price");
		    }
	    }
	    if(Integer.parseInt(ph.getSizecheck()) > 0) {
		    if(Integer.parseInt(ph.getSize()) >= 0) {
		    	query.addAttribute(sizeDesc, sizeDesc.getAttribute(ph.getSize()));
			    smartphone.getActiveAmalgamFct().setWeight(sizeDesc, Integer.parseInt(ph.getSizecheck()));
		    }
	    }
	    
	    if(Integer.parseInt(ph.getDisplaytypecheck()) > 0) {
		    if(!"keineangabe".equals(ph.getDisplaytype())) {
		    	query.addAttribute(displaytypeDesc, displaytypeDesc.getAttribute(ph.getDisplaytype()));
			    smartphone.getActiveAmalgamFct().setWeight(displaytypeDesc, Integer.parseInt(ph.getDisplaytypecheck()));
			    System.out.println("BIN IN DEN IF BEDINUNGEN price");
		    }
	    }
	    
	    if(Integer.parseInt(ph.getCpucheck()) > 0) {
		    if(!"keineangabe".equals(ph.getCpu())) {
		    	query.addAttribute(cpuDesc, cpuDesc.getAttribute(ph.getCpu()));
			    smartphone.getActiveAmalgamFct().setWeight(cpuDesc, Integer.parseInt(ph.getCpucheck()));
			    System.out.println("BIN IN DEN IF BEDINUNGEN price");
	
		    }
	    }
	    if(Integer.parseInt(ph.getWeightcheck()) > 0) {
		    if(Integer.parseInt(ph.getWeight()) >= 0) {
		    	query.addAttribute(weightDesc, weightDesc.getAttribute(ph.getWeight()));
		    	smartphone.getActiveAmalgamFct().setWeight(weightDesc, Integer.parseInt(ph.getWeightcheck()));
		    }
	    }
	    if(Integer.parseInt(ph.getAkkukapacheck()) > 0) {
		    if(Integer.parseInt(ph.getAkkukapa()) >= 0) {
		    	query.addAttribute(akkukapaDesc, akkukapaDesc.getAttribute(ph.getAkkukapa()));
		    	smartphone.getActiveAmalgamFct().setWeight(akkukapaDesc, Integer.parseInt(ph.getAkkukapacheck()));
		    }
	    }
	    
	    if(Integer.parseInt(ph.getKameraMegapixelcheck()) > 0) {
		    if(!"keineangabe".equals(ph.getKameraMegapixel())) {
		    	if("wichtig".equals(ph.getFrontkameraMegapixel())) {
		    		query.addAttribute(kameramegapixelDesc, kameramegapixelDesc.getAttribute(16));
		    	}else {
		    		query.addAttribute(kameramegapixelDesc, kameramegapixelDesc.getAttribute(42));
		    	}
		    	smartphone.getActiveAmalgamFct().setWeight(kameramegapixelDesc, Integer.parseInt(ph.getKameraMegapixelcheck()));
		    }
	    }
	    
	    if(Integer.parseInt(ph.getFrontkameraMegapixelcheck()) > 0) {
		    if(!"keineangabe".equals(ph.getFrontkameraMegapixel())) {
		    	if("wichtig".equals(ph.getFrontkameraMegapixel())) {
		    		query.addAttribute(frontkameraDesc, frontkameraDesc.getAttribute(16));
		    	}else {
		    		query.addAttribute(frontkameraDesc, frontkameraDesc.getAttribute(32));
		    	}
		    	smartphone.getActiveAmalgamFct().setWeight(frontkameraDesc, Integer.parseInt(ph.getFrontkameraMegapixelcheck()));
		    }	
	    }
	    
	    if(Integer.parseInt(ph.getMemoryslotcheck()) > 0) {
		    if(!"keineangabe".equals(ph.getMemoryslot())) {
		    	query.addAttribute(memoryslotDesc, memoryslotDesc.getAttribute(ph.getMemoryslot()));
		    	smartphone.getActiveAmalgamFct().setWeight(memoryslotDesc, Integer.parseInt(ph.getMemoryslotcheck()));
			    System.out.println("BIN IN DEN IF BEDINUNGEN price");
	
		    }
	    }
	    
	    if(Integer.parseInt(ph.getMemorycheck()) > 0) {
		    if(Integer.parseInt(ph.getMemory()) >= 0) {
		    	query.addAttribute(memoryDesc, memoryDesc.getAttribute(ph.getMemory()));
		    	smartphone.getActiveAmalgamFct().setWeight(memoryDesc, Integer.parseInt(ph.getMemorycheck()));
		    }
	    }
	    
	    if(Integer.parseInt(ph.getThicknesscheck()) > 0) {
		    if(Integer.parseInt(ph.getThickness()) >= 0) {
		    	query.addAttribute(thicknessDesc, thicknessDesc.getAttribute(ph.getThickness())); 
		    	smartphone.getActiveAmalgamFct().setWeight(thicknessDesc, Integer.parseInt(ph.getThicknesscheck()));
		    }
	    }
	    
	    if(Integer.parseInt(ph.getNfccheck()) > 0) {
		    query.addAttribute(nfcDesc, nfcDesc.getAttribute(ph.getNfc()));
	    	smartphone.getActiveAmalgamFct().setWeight(nfcDesc, Integer.parseInt(ph.getNfccheck()));
	    }
	    
	    System.out.println("##########################ICH WAR HIER IM RETRIEVAL######################");
	    
	    retrieve.start();
	    
	    List <Pair<Instance, Similarity>> result = retrieve.getResult();


	    for (int i = 0; i < ph.getAnzahl(); i++) {
		    System.out.println("##########################"+i+"######################");
	    	Instance obj = smartphone.getInstance(result.get(i).getFirst().getName());
	    	System.out.println(obj);
	    	System.out.println(retrieve.getResult().get(i).getSecond().getValue() + " - Ähnlichkeit");
	    	System.out.println(obj.getAttForDesc(manufactureDesc).getValueAsString() + " - Manufacture");
	    	System.out.println(obj.getAttForDesc(modelDesc).getValueAsString() + " - Model");
	    	System.out.println(obj.getAttForDesc(resolutionDesc).getValueAsString() + " - Resolution");
	    	System.out.println(obj.getAttForDesc(ramDesc).getValueAsString() + " - RAM");
	    	System.out.println(obj.getAttForDesc(priceDesc).getValueAsString() + " - Price");
	    	System.out.println(obj.getAttForDesc(sizeDesc).getValueAsString() + " - Size");
	    	System.out.println(obj.getAttForDesc(displaytypeDesc).getValueAsString() + " - Displaytype");
	    	System.out.println(obj.getAttForDesc(cpuDesc).getValueAsString() + " - CPU");
	    	System.out.println(obj.getAttForDesc(weightDesc).getValueAsString() + " - weight");
	    	System.out.println(obj.getAttForDesc(akkukapaDesc).getValueAsString() + " - Akkukapazität");
	    	System.out.println(obj.getAttForDesc(frontkameraDesc).getValueAsString() + " - Frontkamera");
	    	System.out.println(obj.getAttForDesc(memoryslotDesc).getValueAsString() + " - Memoryslot");
	    	System.out.println(obj.getAttForDesc(memoryDesc).getValueAsString() + " - memory");
	    	System.out.println(obj.getAttForDesc(nfcDesc).getValueAsString() + " - NFC");
	    	System.out.println(obj.getAttForDesc(thicknessDesc).getValueAsString() + " - Thickness");
		    System.out.println("################################################");
		    
		    RetrievalCase phoned = new RetrievalCase(
		    		Double.toString(retrieve.getResult().get(i).getSecond().getValue()),
		    		obj.getAttForDesc(manufactureDesc).getValueAsString(),
		    		obj.getAttForDesc(modelDesc).getValueAsString(),
		    		obj.getAttForDesc(resolutionDesc).getValueAsString(),
		    		obj.getAttForDesc(priceDesc).getValueAsString(),
		    		obj.getAttForDesc(weightDesc).getValueAsString(),
		    		obj.getAttForDesc(sizeDesc).getValueAsString(),
		    		obj.getAttForDesc(displaytypeDesc).getValueAsString(),
		    		obj.getAttForDesc(cpuDesc).getValueAsString(),
		    		obj.getAttForDesc(ramDesc).getValueAsString(),
		    		obj.getAttForDesc(akkukapaDesc).getValueAsString(),
		    		obj.getAttForDesc(kameramegapixelDesc).getValueAsString(),
		    		obj.getAttForDesc(frontkameraDesc).getValueAsString(),
		    		obj.getAttForDesc(memoryslotDesc).getValueAsString(),
		    		obj.getAttForDesc(memoryDesc).getValueAsString(),
		    		obj.getAttForDesc(nfcDesc).getValueAsString(),
		    		obj.getAttForDesc(thicknessDesc).getValueAsString()
		    		);		
		    
		    dataStorage.getSharedDataStorage().getRetrievalphoneList().add(phoned);
		    
	    }
	    
	    
	} catch (Exception e) {
		e.printStackTrace();
	}
	
}
	}

