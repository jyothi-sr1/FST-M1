package Activities;

public class Activity3 {
	
	    // Method to calculate age on a given planet
	    public static double ageOnPlanet(long seconds, double orbitalPeriod) {
	        // Earth years in seconds
	        final double EARTH_YEAR_SECONDS = 31557600.0;

	        // Calculate age in Earth years
	        double earthAge = seconds / EARTH_YEAR_SECONDS;

	        // Calculate age on the given planet
	        return earthAge / orbitalPeriod;
	    }

	    public static void main(String[] args) {
	        // Given age in seconds
	        long ageInSeconds = 1000000000L;

	        // Orbital periods of planets in Earth years
	        double mercuryOrbitalPeriod = 0.2408467;
	        double venusOrbitalPeriod = 0.61519726;
	        double marsOrbitalPeriod = 1.8808158;
	        double jupiterOrbitalPeriod = 11.862615;
	        double saturnOrbitalPeriod = 29.447498;
	        double uranusOrbitalPeriod = 84.016846;
	        double neptuneOrbitalPeriod = 164.79132;

	        // Calculate and print the age on each planet
	        System.out.println("Age on Earth: " + ageOnPlanet(ageInSeconds, 1) + " Earth years");
	        System.out.println("Age on Mercury: " + ageOnPlanet(ageInSeconds, mercuryOrbitalPeriod) + " Mercury years");
	        System.out.println("Age on Venus: " + ageOnPlanet(ageInSeconds, venusOrbitalPeriod) + " Venus years");
	        System.out.println("Age on Mars: " + ageOnPlanet(ageInSeconds, marsOrbitalPeriod) + " Mars years");
	        System.out.println("Age on Jupiter: " + ageOnPlanet(ageInSeconds, jupiterOrbitalPeriod) + " Jupiter years");
	        System.out.println("Age on Saturn: " + ageOnPlanet(ageInSeconds, saturnOrbitalPeriod) + " Saturn years");
	        System.out.println("Age on Uranus: " + ageOnPlanet(ageInSeconds, uranusOrbitalPeriod) + " Uranus years");
	        System.out.println("Age on Neptune: " + ageOnPlanet(ageInSeconds, neptuneOrbitalPeriod) + " Neptune years");
	    }
	}


