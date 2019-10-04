package agentTasks;

import java.util.ArrayList;
import java.util.List;

import javax.xml.crypto.Data;

import jade.domain.DFGUIManagement.GetParents;
import objects.Case;
import objects.DataStorage;
import objects.Phone;

public class FilterTask {
	
	public void filterData(List<Phone> phones) {
		for(Phone p : phones) {
			parseData(p);
		}	
	}
	ArrayList<Case> cases = new ArrayList<Case>();
	
	public void parseData(Phone phone) {
		Case c = new Case(filterManufacturer(phone.getManufacture()), 
				phone.getModel(), 
				phone.getResolution(), 
				checkPrice(parseToNumber(phone.getPrice())),
				parseWeight(phone.getWeight()),
				getZoll(phone.getSize()),
				filterDisplayType(phone.getDisplaytype()),
				filterCPU(phone.getCpu()),
				parseRAM(phone.getRam()),
				parseAkkuKappa(phone.getAkkukapa()),
				parseMegapixel(phone.getKameraMegapixel()),
				parseMegapixel(phone.getFrontkameraMegapixel()),
				filterMemorySlot(phone.getMemoryslot()),
				parseMemory(phone.getMemory()),
				getNFC(phone.getNfc()),
				parseThickness(phone.getThickness()));
		System.out.println("#####################");
		System.out.println(phone.getModel());
		System.out.println(phone.getWeight());
		System.out.println(parseWeight(phone.getWeight()));
		System.out.println(phone.getPrice());
		System.out.println(c.toString());
		System.out.println("#####################");

		DataStorage.getSharedDataStorage().getCases().add(c);
		
	}
	
	private float checkPrice(float p) {
		if(p > 3000) {
			return 0;
		}
		return p;
	}
	
	private String filterManufacturer(String m) {
		if(m.toLowerCase().contains("apple")) {
			return "Apple";
		}
		if(m.toLowerCase().contains("asus")) {
			return "Asus";
		}
		if(m.toLowerCase().contains("htc")) {
			return "HTC";
		}
		if(m.toLowerCase().contains("huawei")) {
			return "Huawei";
		}
		if(m.toLowerCase().contains("lg")) {
			return "LG";
		}
		if(m.toLowerCase().contains("motorola")) {
			return "Motorola";
		}
		if(m.toLowerCase().contains("nokia")) {
			return "Nokia";
		}
		if(m.toLowerCase().contains("oneplus")) {
			return "OnePlus";
		}
		if(m.toLowerCase().contains("rauer")) {
			return "Rauer";
		}
		if(m.toLowerCase().contains("samsung")) {
			return "Samsung";
		}
		if(m.toLowerCase().contains("sony")) {
			return "Sony";
		}
		if(m.toLowerCase().contains("xiaomi")) {
			return "Xiaomi";
		}
		if(m.toLowerCase().contains("zte")) {
			return "ZTE";
		}
		return "Other";
	}
	
	private String filterCPU(String m) {
		if(m.toLowerCase().contains("dual-core")) {
			return "Dual-core";
		}
		if(m.toLowerCase().contains("hexa-core")) {
			return "Hexa-core";
		}
		if(m.toLowerCase().contains("octa-core")) {
			return "Octa-core";
		}
		if(m.toLowerCase().contains("quad-core")) {
			return "Quad-core";
		}
		if(m.toLowerCase().contains("triple-core")) {
			return "Triple-core";
		}
		return "Other";
	}
	
	private String filterDisplayType(String m) {
		if(m.toLowerCase().contains("lcd")) {
			return "LCD";
		}
		if(m.toLowerCase().contains("led")) {
			return "LED";
		}
		if(m.toLowerCase().contains("oled")) {
			return "OLED";
		}
		if(m.toLowerCase().contains("tft")) {
			return "TFT";
		}
		return "Other";
	}
	
	private String filterMemorySlot(String m) {
		if(m.toLowerCase().contains("microsd")) {
			return "MicroSD";
		}
		if(m.toLowerCase().contains("nanosd")) {
			return "NanoSD";
		}
		return "None";
	}
	
	public float parseToNumber(String p) {
		String extractNumber;
		float number = 0;
		if(p == "") {
			return number;
		}
		
		extractNumber = p.replaceAll("\\D+","");
		number = Integer.parseInt(extractNumber);
		return number;
	}
	
	public float parseWeight(String w) {
		try {
			if(Float.parseFloat(w.split(" ")[0].replaceAll("\\D+","")) > 1000 ) {
				return Float.parseFloat(w.split(" ")[0].replaceAll("\\D+","")) / 10;
			}
			return Float.parseFloat(w.split(" ")[0].replaceAll("\\D+",""));

		} catch(NumberFormatException e) {
			return 0;
		}

	}
	
	public float getZoll(String size) {
		if(size.isEmpty()) {
			return 0;
		}
		if(!size.matches(".*\\d.*")) {
			return 0;
		}
		return Float.parseFloat(size.split("inches")[0]);
	}
	
	public int parseRAM(String r) {
		if(r.contains("GB RAM DDR2")) {
			try {
				String s1 = r.substring(r.indexOf(",")+1);
				return Integer.parseInt(s1.split(" GB RAM DDR2")[0].replaceAll("\\D+",""));

			} catch(NumberFormatException e) {
				return 0;
			}
		}
		if(r.contains("GB RAM DDR3")) {
			try {
				String s1 = r.substring(r.indexOf(",")+1);
				return Integer.parseInt(s1.split(" GB RAM DDR3")[0].replaceAll("\\D+",""));

			} catch(NumberFormatException e) {
				return 0;
			}
		}
		if(r.contains("GB RAM")) {
			try {
				String s1 = r.substring(r.indexOf(",")+1);
				return Integer.parseInt(s1.split(" GB RAM")[0].replaceAll("\\D+",""));

			} catch(NumberFormatException e) {
				return 0;
			}
		}
		if(r.contains("MB RAM")) {
			try {
				String s1 = r.substring(r.indexOf(",")+1);
				//return -1 * Integer.parseInt(s1.split(" MB RAM")[0].replaceAll("\\D+",""));
				return 0;

			} catch(NumberFormatException e) {
				return 0;
			}
		}
		return 0;
	}
	
	public float parseAkkuKappa(String a) {
		if(a.contains("(")) {
			try {
				String s1 = a.substring(0, a.indexOf("("));
				return Float.parseFloat(s1.replaceAll("\\D+",""));

			} catch(NumberFormatException e) {
				return 0;
			}	
		}
		if(!a.matches(".*\\d.*")) {
			return 0;
		}
		 return Float.parseFloat(a.replaceAll("\\D+",""));
	}
	
	public float parseMegapixel(String m) {
		if(m.contains("MP")) {
			String s1 = m.substring(0, m.indexOf("MP"));
			return Float.parseFloat(s1.replaceAll("\\D+",""));
		}
		return 0;
	}
	
	public int getNFC(String n) {
		if(n.contains("Yes")) {
			return 1;
		}else {
			return 0;
		}
	}
	
	public float parseThickness(String t) {
//		if(t.contains("thickness")) {
//			return Float.parseFloat(t.replaceAll("\\D+",""));
//		} else {
//			return 0;
//		}
		return 0;
	}
	
	private int parseMemory(String m) {
        if(m.toLowerCase().contains("16") && m.toLowerCase().contains("32")) {
           return 32;
        }
        else if(m.toLowerCase().contains("32") && m.toLowerCase().contains("64")) {
          return 64;
        } 
        else if(m.toLowerCase().contains("64") && m.toLowerCase().contains("256")) {
          return 256;
        } else {
            return 16;
        }
      }
	
}
