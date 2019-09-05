package day;

public class dayTest {

	public static void main(String[] args) {

		
		
		
	}

	
	
	interface Day {	}

	public enum Weekday implements Day {
		MON, TUE, WED, THU, FRI;
	}

	public enum WeekendDay implements Day {
		SAT, SUN;
	}

}
