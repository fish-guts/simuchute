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
    private double parachuteArea;
    private int parachuteTimeToOpen;
    private int springerGewicht;
    private double runTime;
    private double luftDichte;
    private double springerGeschwindigkeit;
    private double springerFlaeche;
    private double tOeffnen;
    private double tOffen;
    private double tEnde;
    private double tAnfang;
    private double schrittweiteH;
    private double[][] result;

    public double[][] getResult(){
        return result;
    }

    public double getSchrittweiteH(){
        return schrittweiteH;
    }

    public double getTEnde(){
        return tEnde;
    }

    public double getTAnfang(){
        return tAnfang;
    }

    public double getTOffen(){
        return tOffen;
    }

    public double getTOeffnen(){
        return tOeffnen;
    }

    public double getSpringerFlaeche(){
        return springerFlaeche;
    }

    public double getLuftDichte(){
        return luftDichte;
    }

    public double getSpringerGeschwindigkeit(){
        return springerGeschwindigkeit;
    }
    public double getRunTime(){
        return runTime;
    }
    public int getSpringerGewicht(){
        return springerGewicht;
    }
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
    public double getParachuteArea() {
        return parachuteArea;
    }
    public int getParachuteTimeToOpen(){
        return parachuteTimeToOpen;
    }
    /**
     * Setter Methode um die Flughöhe festzulegen
     * @param alt: Flughöhe in Metern. 
     */
    public void setAltitude(int alt) {
        altitude = alt;
    }

    public void setSchrittweite(double schrittweite){
        this.schrittweiteH = schrittweite;
    }

    public void setResult(double[][] result){
        this.result = result;
    }

    public void setTAnfang(double tAnfang){
        this.tAnfang = tAnfang;
    }

    public void setTEnde(double tEnde){
        this.tEnde = tEnde;
    }
    public void setTOffen(double tOffen){
        this.tOffen = tOffen;
    }

    public void setTOeffnen(double tOeffnen){
        this.tOeffnen = tOeffnen;
    }
    public void setSpringerFlaeche(double springerFlaeche){
        this.springerFlaeche = springerFlaeche;
    }
    public void setSpringerGeschwindigkeit(double springerGeschwindigkeit){
        this.springerGeschwindigkeit = springerGeschwindigkeit;
    }
    public void setLuftDichte(double luftDichte){
        this.luftDichte = luftDichte;
    }
    public void setRunTime(double runTime){
        this.runTime = runTime;
    }
    public void setSpringerGewicht(int gewicht){
        springerGewicht = gewicht;
    }
    public void setParachuteTimeToOpen(int time){
        parachuteTimeToOpen = time;
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
    public void setParachuteArea(double area) {
        parachuteArea = area;
    }

}
