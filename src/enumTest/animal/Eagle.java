package enumTest.animal;

import enumTest.Animal;

public class Eagle extends AnimalBase {

	public Eagle() {
		this.infoCode = Animal.InfoCode.Eagle;
		this.code = Animal.Code.Eagle; 
		this.kind = Animal.Kind.Birds;
		this.size = Animal.Size.MEDIUM;
		this.countOfLeg = Animal.CountOfLeg.Zero;
	}
}
