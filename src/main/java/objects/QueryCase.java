package objects;

import java.io.Serializable;

public class QueryCase implements Serializable {
	
	private String manufacture;
	private String manufacturecheck;
	private String price;
	private String pricecheck;
	private String weight;
	private String weightcheck;
	private String size;
	private String sizecheck;
	private String displaytype;
	private String displaytypecheck;
	private String cpu;
	private String cpucheck;
	private String ram;
	private String ramcheck;
	private String akkukapa;
	private String akkukapacheck;
	private String kameraMegapixel;
	private String kameraMegapixelcheck;
	private String frontkameraMegapixel;
	private String frontkameraMegapixelcheck;
	private String memoryslot;
	private String memoryslotcheck;
	private String memory;
	private String memorycheck;
	private String nfc;
	private String nfccheck;
	private String thickness;
	private String thicknesscheck;
	private int anzahl;

	
	public QueryCase(String manufacture, String manufacturecheck, String price, String pricecheck, String weight,
			String weightcheck, String size, String sizecheck, String displaytype, String displaytypecheck, String cpu,
			String cpucheck, String ram, String ramcheck, String akkukapa, String akkukapacheck, String kameraMegapixel,
			String kameraMegapixelcheck, String frontkameraMegapixel, String frontkameraMegapixelcheck,
			String memoryslot, String memoryslotcheck, String memory, String memorycheck, String nfc, String nfccheck,
			String thickness, String thicknesscheck, int anzahl) {
		super();
		this.manufacture = manufacture;
		this.manufacturecheck = manufacturecheck;
		this.price = price;
		this.pricecheck = pricecheck;
		this.weight = weight;
		this.weightcheck = weightcheck;
		this.size = size;
		this.sizecheck = sizecheck;
		this.displaytype = displaytype;
		this.displaytypecheck = displaytypecheck;
		this.cpu = cpu;
		this.cpucheck = cpucheck;
		this.ram = ram;
		this.ramcheck = ramcheck;
		this.akkukapa = akkukapa;
		this.akkukapacheck = akkukapacheck;
		this.kameraMegapixel = kameraMegapixel;
		this.kameraMegapixelcheck = kameraMegapixelcheck;
		this.frontkameraMegapixel = frontkameraMegapixel;
		this.frontkameraMegapixelcheck = frontkameraMegapixelcheck;
		this.memoryslot = memoryslot;
		this.memoryslotcheck = memoryslotcheck;
		this.memory = memory;
		this.memorycheck = memorycheck;
		this.nfc = nfc;
		this.nfccheck = nfccheck;
		this.thickness = thickness;
		this.thicknesscheck = thicknesscheck;
		this.setAnzahl(anzahl);
	}
	
	public String getManufacture() {
		return manufacture;
	}
	public void setManufacture(String manufacture) {
		this.manufacture = manufacture;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getWeight() {
		return weight;
	}
	public void setWeight(String weight) {
		this.weight = weight;
	}
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	public String getDisplaytype() {
		return displaytype;
	}
	public void setDisplaytype(String displaytype) {
		this.displaytype = displaytype;
	}
	public String getCpu() {
		return cpu;
	}
	public void setCpu(String cpu) {
		this.cpu = cpu;
	}
	public String getRam() {
		return ram;
	}
	public void setRam(String ram) {
		this.ram = ram;
	}
	public String getAkkukapa() {
		return akkukapa;
	}
	public void setAkkukapa(String akkukapa) {
		this.akkukapa = akkukapa;
	}
	public String getKameraMegapixel() {
		return kameraMegapixel;
	}
	public void setKameraMegapixel(String kameraMegapixel) {
		this.kameraMegapixel = kameraMegapixel;
	}
	public String getFrontkameraMegapixel() {
		return frontkameraMegapixel;
	}
	public void setFrontkameraMegapixel(String frontkameraMegapixel) {
		this.frontkameraMegapixel = frontkameraMegapixel;
	}
	public String getMemoryslot() {
		return memoryslot;
	}
	public void setMemoryslot(String memoryslot) {
		this.memoryslot = memoryslot;
	}
	public String getMemory() {
		return memory;
	}
	public void setMemory(String memory) {
		this.memory = memory;
	}
	public String getNfc() {
		return nfc;
	}
	public void setNfc(String nfc) {
		this.nfc = nfc;
	}
	
	
	@Override
	public String toString() {
		return "QueryCase [manufacture=" + manufacture + ", manufacturecheck=" + manufacturecheck + ", price=" + price
				+ ", pricecheck=" + pricecheck + ", weight=" + weight + ", weightcheck=" + weightcheck + ", size="
				+ size + ", sizecheck=" + sizecheck + ", displaytype=" + displaytype + ", displaytypecheck="
				+ displaytypecheck + ", cpu=" + cpu + ", cpucheck=" + cpucheck + ", ram=" + ram + ", ramcheck="
				+ ramcheck + ", akkukapa=" + akkukapa + ", akkukapacheck=" + akkukapacheck + ", kameraMegapixel="
				+ kameraMegapixel + ", kameraMegapixelcheck=" + kameraMegapixelcheck + ", frontkameraMegapixel="
				+ frontkameraMegapixel + ", frontkameraMegapixelcheck=" + frontkameraMegapixelcheck + ", memoryslot="
				+ memoryslot + ", memoryslotcheck=" + memoryslotcheck + ", memory=" + memory + ", memorycheck="
				+ memorycheck + ", nfc=" + nfc + ", nfccheck=" + nfccheck + ", thickness=" + thickness
				+ ", thicknesscheck=" + thicknesscheck + "]";
	}
	public String getThickness() {
		return thickness;
	}
	public void setThickness(String thickness) {
		this.thickness = thickness;
	}
	public String getThicknesscheck() {
		return thicknesscheck;
	}
	public void setThicknesscheck(String thicknesscheck) {
		this.thicknesscheck = thicknesscheck;
	}
	public String getNfccheck() {
		return nfccheck;
	}
	public void setNfccheck(String nfccheck) {
		this.nfccheck = nfccheck;
	}
	public String getMemorycheck() {
		return memorycheck;
	}
	public void setMemorycheck(String memorycheck) {
		this.memorycheck = memorycheck;
	}
	public String getMemoryslotcheck() {
		return memoryslotcheck;
	}
	public void setMemoryslotcheck(String memoryslotcheck) {
		this.memoryslotcheck = memoryslotcheck;
	}
	public String getFrontkameraMegapixelcheck() {
		return frontkameraMegapixelcheck;
	}
	public void setFrontkameraMegapixelcheck(String frontkameraMegapixelcheck) {
		this.frontkameraMegapixelcheck = frontkameraMegapixelcheck;
	}
	public String getKameraMegapixelcheck() {
		return kameraMegapixelcheck;
	}
	public void setKameraMegapixelcheck(String kameraMegapixelcheck) {
		this.kameraMegapixelcheck = kameraMegapixelcheck;
	}
	public String getAkkukapacheck() {
		return akkukapacheck;
	}
	public void setAkkukapacheck(String akkukapacheck) {
		this.akkukapacheck = akkukapacheck;
	}
	public String getRamcheck() {
		return ramcheck;
	}
	public void setRamcheck(String ramcheck) {
		this.ramcheck = ramcheck;
	}
	public String getCpucheck() {
		return cpucheck;
	}
	public void setCpucheck(String cpucheck) {
		this.cpucheck = cpucheck;
	}
	public String getDisplaytypecheck() {
		return displaytypecheck;
	}
	public void setDisplaytypecheck(String displaytypecheck) {
		this.displaytypecheck = displaytypecheck;
	}
	public String getSizecheck() {
		return sizecheck;
	}
	public void setSizecheck(String sizecheck) {
		this.sizecheck = sizecheck;
	}
	public String getWeightcheck() {
		return weightcheck;
	}
	public void setWeightcheck(String weightcheck) {
		this.weightcheck = weightcheck;
	}
	public String getPricecheck() {
		return pricecheck;
	}
	public void setPricecheck(String pricecheck) {
		this.pricecheck = pricecheck;
	}
	public String getManufacturecheck() {
		return manufacturecheck;
	}
	public void setManufacturecheck(String manufacturecheck) {
		this.manufacturecheck = manufacturecheck;
	}

	public int getAnzahl() {
		return anzahl;
	}

	public void setAnzahl(int anzahl) {
		this.anzahl = anzahl;
	}
}
