package enumTest;

import java.lang.reflect.InvocationTargetException;

public class EnumTest {

	public static void main(String[] args) throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, ClassNotFoundException {

		Animal animal = new Animal();

//		for (Animal.Code code : Animal.Code.values()) {
//			System.out.print(code.toString() + ", ");
//			System.out.println(code.getCode());
//		}
		
		
		Animal.InfoCode infoCode1 = Animal.InfoCode.Anaconda;
		Animal.Size size = infoCode1.generateAnimalWithCode(Animal.Size.class);
		
		System.out.println("size: " + size);

	}
}
