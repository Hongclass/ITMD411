/*Hong Zhang*/

public class TestHouse {

	/**
	 * @param args
	 * @throws CloneNotSupportedException 
	 */
	public static void main(String[] args) throws CloneNotSupportedException {
		// create some house objects
		House house1 = new House(1, 1750.50);
		House house1c = (House) house1.clone();
		
		// check to see if whenBuilt members are the same
		System.out.println("house1/house1c whenBuilt reference: " + 
		        equalWhenBuilt(house1, house1c));

		// check to see if whenBuilt data is the same
		System.out.println("house1/house1c whenBuilt data: " + 
		        equalWhenBuiltDate(house1, house1c));
	}
	
	// a method for comparing the whenBuilt reference variable
	public static boolean equalWhenBuilt(House obj1, House obj2) {
		return obj1.getWhenBuilt() == obj2.getWhenBuilt();
	}

	// a method for comparing the whenBuild data of the objects
	public static boolean equalWhenBuiltDate(House obj1, House obj2) {
		return obj1.getWhenBuilt().equals(obj2.getWhenBuilt());
	}
}
