package simuchute.ch.i10a.chute.logic;

/**
 * Klasse SimulationObject: Klasse für ein Objekt mit den Simulationsparametern
 * @author chsmrs
 */
public class SimulationObject {

    /* klassenvariablen */
    private int altitude;
    private int planeSpeed;
    private int windDirection;
    private int windSpeed;
    private int parachuteArea;



    public int getAltitude() {
        return altitude;
    }
    public int getPlaneSpeed() {
        return planeSpeed;
    }
    public int getWindDirection() {
        return windDirection;
    }
    public int getWindSpeed() {
        return windSpeed;
    }
    public int getParachuteArea() {
        return parachuteArea;
    }
    /**
     * Setter Methode um die Flughöhe festzulegen
     * @param alt: Flughöhe in Metern. 
     */
    public void setAltitude(int alt) {
        altitude = alt;
    }
    /**
     * Setter Methode um die Fluggeschwindigkeit festzulegen
     * @param speed: Geschwindigkeit in m/s
     */
    public void setPlaneSpeed(int speed) {
        planeSpeed = speed;
    }
    /**
     * Setter Mthode um die Windirchtung festzulegen.
     * @param dir: Windirchtung in Grad (0/360° = Vertikal nach oben)
     */
    public void setWindDirection(int dir) {
        windDirection = dir;
    }
    /**
     * Setter Methode um die Windgeschwindigkeit festzulegen
     * @param speed: Geschwindigkeit in m/s
     */
    public void setWindSpeed(int speed) {
        windSpeed = speed;
    }
     /**
     * Setter Methode um die Fläche des Fallchirms festzulegen
     * @param area: Fläche in m²
     */
    public void setParachuteArea(int area) {
        parachuteArea = area;
    }

}
