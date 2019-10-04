package agentTasks;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import de.dfki.mycbr.core.ICaseBase;
import de.dfki.mycbr.core.casebase.Instance;
import de.dfki.mycbr.core.model.Concept;
import de.dfki.mycbr.core.model.IntegerDesc;
import de.dfki.mycbr.core.retrieval.Retrieval;
import de.dfki.mycbr.core.retrieval.Retrieval.RetrievalMethod;
import de.dfki.mycbr.core.similarity.Similarity;
import de.dfki.mycbr.util.Pair;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.MessageTemplate;
import objects.Case;
import objects.DataStorage;

public class CbrTask {
	
	private String message;
	
	public CbrTask() {
		message = "MESSAGE";
	}
	
	public String getMessage() {
		return this.message;
	}
	
	public void saveCases() {
		ArrayList<Case> phonearray = DataStorage.getSharedDataStorage().getCases();
    	
    	Concept smartphone = DataStorage.getSharedDataStorage().getProject().getConceptByID("Smartphone");

    	ICaseBase cb = DataStorage.getSharedDataStorage().getCasebasee();
    	//Collection<Instance> instances = smartphone.getAllInstances();
    	int count = 0;
		for(Case c: phonearray) {
			try {
				Instance i = smartphone.addInstance(smartphone.getName() + " #" + (cb.getCases().size()+1));
				i.addAttribute("manufacture", c.getManufacture());
				i.addAttribute("model", c.getModel());
				i.addAttribute("resolution", c.getResolution());
				i.addAttribute("price", c.getPrice());
				i.addAttribute("weight", c.getWeight());
				i.addAttribute("size", c.getSize());
				i.addAttribute("displaytype", c.getDisplaytype());
				i.addAttribute("cpu", c.getCpu());
				i.addAttribute("arbeitsspeicher", c.getRam());
				i.addAttribute("akkukapa", c.getAkkukapa());
				i.addAttribute("kameramegapixel", c.getKameraMegapixel());
				i.addAttribute("frontkameramegapixel", c.getFrontkameraMegapixel());
				i.addAttribute("memoryslot", c.getMemoryslot());
				i.addAttribute("memory", c.getMemory());
				i.addAttribute("nfc", c.getNfc());
				i.addAttribute("thickness", c.getThickness());
				
				cb.addCase(i);
				count++;
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		DataStorage.getSharedDataStorage().setAddedCases(0);

		DataStorage.getSharedDataStorage().setAddedCases(count);
		Collection<Instance> cases = cb.getCases();
//		for(Instance i : cases) {
//			System.out.println(i.getAttributes());
//			System.out.println(i.getName());
//		}
	}
}
