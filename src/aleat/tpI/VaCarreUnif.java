package aleat.tpI;

import java.util.Random;

public class VaCarreUnif implements VariableAleatoire {

	Random rand = new Random();

	public double nextSimulation() {

		return Math.pow(rand.nextDouble(), 2);
		//return rand.nextDouble();

	}

}
