package enumTest;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

import enumTest.animal.AnimalBase;

public class Animal {

	interface AnimalBaseCode {

		// public AnimalBaseCode();
	}

	abstract class AnimalBaseCode1 {

	}

	public enum Code implements AnimalBaseCode {
		NONE(0), Anaconda(100), Elephant(101), Eagle(102);

		private Code(int code) {
			this.code = code;
		}

		public int getCode() {
			return code;
		}

		private int code;

		public static int modifiedBasicUnit() {
			return Code.Anaconda.code;
		}
	}

	public enum Kind implements AnimalBaseCode {
		NONE(0), Mammalia(100_000), Birds(200_000), Reptile(300_000);

		private Kind(int code) {
			this.code = code;
		}

		public int getCode() {
			return code;
		}

		private int code;

		public static int modifiedBasicUnit() {
			return Kind.Mammalia.code;
		}
	}

	public enum Size implements AnimalBaseCode {
		NONE(0), BIG(10_000), MEDIUM(20_000), SMALL(30_000);

		private Size(int code) {
			this.code = code;
		}

		public int getCode() {
			return code;
		}

		private int code;

		public static int modifiedBasicUnit() {
			return Size.BIG.code;
		}
	}

	public enum CountOfLeg implements AnimalBaseCode {
		NONE(0), Zero(1_000), Two(2_000), Four(3_000);

		private CountOfLeg(int code) {
			this.code = code;
		}

		public int getCode() {
			return code;
		}

		private int code;

		public static int modifiedBasicUnit() {
			return CountOfLeg.Zero.code;
		}
	}

	// kind_size_CountOfLeg
	public enum InfoCode implements AnimalBaseCode {
		NONE(0), Anaconda(331_100), Elephant(113_101), Eagle(222_102);

		private InfoCode(int code) {
			this.code = code;
		}

		public int getCode() {
			return code;
		}

		private int code;

		public <E extends Enum<E>> E generateAnimalWithCode(Class<E> enumType)
				throws InstantiationException, IllegalAccessException, IllegalArgumentException,
				InvocationTargetException, NoSuchMethodException, SecurityException, ClassNotFoundException {

			int rawValue = 0;

			rawValue = this.code % Animal.Kind.modifiedBasicUnit()
					/ Animal.Size.modifiedBasicUnit();

			System.out.println("-----");

			// return new E.();
			// return (E) new Size(rawValue);

			// Enum e1 = Enum.valueOf(enumType, name)
			// Enum e = Enum.valueOf(enumType, "MEDIUM");

			// System.out.println("-----");

			Animal.Size size = Animal.Size.BIG;

			Class<?> clazz = Class.forName(enumType.getName());
			Constructor<?> constructor = clazz.getDeclaredConstructors()[0];

			constructor.setAccessible(true);
			Object o = constructor.newInstance("MEDIUM", 20_000, 1);

			E e = (E) constructor.newInstance();

			// return e;

			//
			// Constructor[] constructors = enumType.getConstructors();
			//
			// System.out.println("=======");
			// for (Constructor constructor : constructors) {
			// System.out.println(constructor.toString());
			// // Class[] parameterTypes = constructor.getParameterTypes();
			// }
			// System.out.println("=======");

			// System.out.println(enumType.getConstructors());

			return enumType.getConstructor(int.class).newInstance();

		}

		// public <T implements AnimalBase> T generateAnimalWithInfoCode(enumType) {
		//
		// }

	}
}
