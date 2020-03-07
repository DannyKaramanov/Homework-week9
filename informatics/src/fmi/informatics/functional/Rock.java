package fmi.informatics.functional;

// Демонстриране чрез клас имплементиращ интерфейса IGravity
public class Rock implements IGravity {

	public void drop(double height) {
		double heightMeters = Math.abs(height());
		double timeToHitGround = Math.sqrt(2 * height() / acceleration()); 
		System.out.format("It took %f seconds for the rock to hit the ground", timeToHitGround);
		System.out.format("\nThe speed of the rock at impact was: %f", speedAtImpact(heightMeters));
	}
}
