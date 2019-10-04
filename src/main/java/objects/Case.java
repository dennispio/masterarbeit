package objects;

public class Case {
	
	private String manufacture;
	private String model;
	private String resolution;
	private float price;
	private float weight;
	private float size;
	private String displaytype;
	private String cpu;
	private int ram;
	private float akkukapa;
	private float kameraMegapixel;
	private float frontkameraMegapixel;
	private String memoryslot;
	private float memory;
	private int nfc;
	private float thickness;
	
	
	
	public Case(String manufacture, String model, String resolution, float price, float weight, float size,
			String displaytype, String cpu, int ram, float akkukapa, float kameraMegapixel, float frontkameraMegapixel,
			String memoryslot, float memory, int nfc, float thickness) {
		super();
		this.manufacture = manufacture;
		this.model = model;
		this.resolution = resolution;
		this.price = price;
		this.weight = weight;
		this.size = size;
		this.displaytype = displaytype;
		this.cpu = cpu;
		this.ram = ram;
		this.akkukapa = akkukapa;
		this.kameraMegapixel = kameraMegapixel;
		this.frontkameraMegapixel = frontkameraMegapixel;
		this.memoryslot = memoryslot;
		this.memory = memory;
		this.nfc = nfc;
		this.setThickness(thickness);
	}
	
	public String getManufacture() {
		return manufacture;
	}
	public void setManufacture(String manufacture) {
		this.manufacture = manufacture;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getResolution() {
		return resolution;
	}
	public void setResolution(String resolution) {
		this.resolution = resolution;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public float getWeight() {
		return weight;
	}
	public void setWeight(int weight) {
		this.weight = weight;
	}
	public float getSize() {
		return size;
	}
	public void setSize(float size) {
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
	public int getRam() {
		return ram;
	}
	public void setRam(int ram) {
		this.ram = ram;
	}
	public float getAkkukapa() {
		return akkukapa;
	}
	public void setAkkukapa(float akkukapa) {
		this.akkukapa = akkukapa;
	}
	public float getKameraMegapixel() {
		return kameraMegapixel;
	}
	public void setKameraMegapixel(float kameraMegapixel) {
		this.kameraMegapixel = kameraMegapixel;
	}
	public float getFrontkameraMegapixel() {
		return frontkameraMegapixel;
	}
	public void setFrontkameraMegapixel(float frontkameraMegapixel) {
		this.frontkameraMegapixel = frontkameraMegapixel;
	}
	public String getMemoryslot() {
		return memoryslot;
	}
	public void setMemoryslot(String memoryslot) {
		this.memoryslot = memoryslot;
	}
	public float getMemory() {
		return memory;
	}
	public void setMemory(float memory) {
		this.memory = memory;
	}
	public int getNfc() {
		return nfc;
	}
	public void setNfc(int nfc) {
		this.nfc = nfc;
	}

	@Override
	public String toString() {
		return "Case [manufacture=" + manufacture + ", model=" + model + ", resolution=" + resolution + ", price="
				+ price + ", weight=" + weight + ", size=" + size + ", displaytype=" + displaytype + ", cpu=" + cpu
				+ ", ram=" + ram + ", akkukapa=" + akkukapa + ", kameraMegapixel=" + kameraMegapixel
				+ ", frontkameraMegapixel=" + frontkameraMegapixel + ", memoryslot=" + memoryslot + ", memory=" + memory
				+ ", nfc=" + nfc + ", thickness=" + thickness + "]";
	}

	public float getThickness() {
		return thickness;
	}

	public void setThickness(float thickness) {
		this.thickness = thickness;
	}
	

}
