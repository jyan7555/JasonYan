package javaTheHardWay;

public class Wilderness extends Habitat{
	private String description;
	
	public Wilderness(String description, int livingCapacity) {
		super(livingCapacity);
		this.description = description;
	}
	public static void main(String[] args) {
		Wilderness w= new WIlderness("An  empty dessert", 10);
		w.simulate(3);
	}
	
	public String toString() {
		return this.description + "\n" + animalReport();
	}
	public void simulate(int rounds) {
		for (int i=0; i <rounds; i++) {
			for(Animal a: getAnimals()) {
				if (a instanceof ReproductionAnimal)((ReproductionAnimal)a).reset();
			}
		}
	}
}
