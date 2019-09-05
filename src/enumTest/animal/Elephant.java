package enumTest.animal;

import enumTest.Animal;

public class Elephant extends AnimalBase {

	public Elephant() {
		this.infoCode = Animal.InfoCode.Elephant;
		this.code = Animal.Code.Elephant; 
		this.kind = Animal.Kind.Mammalia;
		this.size = Animal.Size.BIG;
		this.countOfLeg = Animal.CountOfLeg.Four;
	}
}
