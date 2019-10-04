package objects;

public class RetrievalCase {
	
	
	private String sim;
	private String manufacture;
	private String model;
	private String resolution;
	private String price;
	private String weight;
	private String size;
	private String displaytype;
	private String cpu;
	private String ram;
	private String akkukapa;
	private String kameraMegapixel;
	private String frontkameraMegapixel;
	private String memoryslot;
	private String memory;
	private String nfc;
	private String thickness;
	
	/**
	 * @param sim
	 * @param manufacture
	 * @param model
	 * @param resolution
	 * @param price
	 * @param weight
	 * @param size
	 * @param displaytype
	 * @param cpu
	 * @param ram
	 * @param akkukapa
	 * @param kameraMegapixel
	 * @param frontkameraMegapixel
	 * @param memoryslot
	 * @param memory
	 * @param nfc
	 */
	public RetrievalCase(String sim, String manufacture, String model, String resolution, String price, String weight, String size,
			String displaytype, String cpu, String ram, String akkukapa, String kameraMegapixel,
			String frontkameraMegapixel, String memoryslot, String memory, String nfc, String thickness) {
		super();
		this.setSim(sim);
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
		this.thickness = thickness;
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
		return "Phone [manufacture=" + manufacture + ", model=" + model + ", resolution=" + resolution + ", price="
				+ price + ", weight=" + weight + ", size=" + size + ", displaytype=" + displaytype + ", cpu=" + cpu
				+ ", ram=" + ram + ", akkukapa=" + akkukapa + ", kameraMegapixel=" + kameraMegapixel
				+ ", frontkameraMegapixel=" + frontkameraMegapixel + ", memoryslot=" + memoryslot + ", memory=" + memory
				+ ", nfc=" + nfc + "]";
	}
	public String getThickness() {
		return thickness;
	}
	public void setThickness(String thickness) {
		this.thickness = thickness;
	}
	public String getSim() {
		return sim;
	}
	public void setSim(String sim) {
		this.sim = sim;
	}
}
