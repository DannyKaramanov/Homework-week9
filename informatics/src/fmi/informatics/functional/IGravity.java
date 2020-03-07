package fmi.informatics.functional;

// Създаваме интерфейс IGravity с default метод
public interface IGravity {
	
	default double acceleration() {
		return 9.80665;
	}
	
	default double height() {
		return 100;
	}
	
	default double speedAtImpact(double heightMeters) {
		return heightMeters = Math.sqrt(2*acceleration() * height());
	}
	
}
