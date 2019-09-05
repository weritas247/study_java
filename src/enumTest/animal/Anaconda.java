package enumTest.animal;

import enumTest.Animal;

public class Anaconda extends AnimalBase {

	public Anaconda() {
		this.infoCode = Animal.InfoCode.Anaconda;
		this.code = Animal.Code.Anaconda; 
		this.kind = Animal.Kind.Reptile;
		this.size = Animal.Size.SMALL;
		this.countOfLeg = Animal.CountOfLeg.Zero;
	}
}
