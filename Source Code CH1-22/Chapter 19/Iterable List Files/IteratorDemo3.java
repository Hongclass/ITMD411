public class IteratorDemo3
{
	public static void main(String[] args)
	{
      // Create a list to hold Car objects.
      ListType<Car> carList = new ListType<Car>();
      
      // Create a few Car objects.
      Car vw = new Car("227H54", "1997 Volkswagen");
      Car porsche = new Car("453B55", "2007 Porsche");
      Car bmw = new Car("177R60", "1980 BMW");

      // Add the cars to the list.
      carList.add(vw);
      carList.add(porsche);
      carList.add(bmw);
		
		for (Car c : carList)
			System.out.println(c);
	}
}