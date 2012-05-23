package simuchute.ch.i10a.chute.logic;

/**
 * Klasse SimulationObject: Klasse für ein Objekt mit den Simulationsparametern
 * @author chsmrs
 */
public class SimulationObject {

    /* klassenvariablen */
    private double altitude; // Regler, Meter
    private double planeSpeed; // m/s
    private double windDirection; // nicht in GUI
    private double windSpeed; // m/s
    private double parachuteArea; // m^2
    private int parachuteTimeToOpen; // s
    private int springerGewicht; // kg
    private double runTime; //
    private double luftDichte; // kg/m^3
    private double springerGeschwindigkeit; //
    private double springerFlaeche; //
    private double tOeffnen; //
    private double tOffen;
    private double tEnde;
    private double tAnfang;
    private double schrittweiteH; //
    private double[][] result;
    private double[][] flugbahn;

    public double[][] getFlugbahn(){
        return flugbahn;
    }

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
    public double getAltitude() {
        return altitude;
    }
    public double getPlaneSpeed() {
        return planeSpeed;
    }
    public double getWindDirection() {
        return windDirection;
    }
    public double getWindSpeed() {
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
    public void setAltitude(double alt) {
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

    public void setFlugbahn(double[][] flugbahn){
        this.flugbahn = flugbahn;
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
    public void setPlaneSpeed(double speed) {
        planeSpeed = speed;
    }

    /**
     * Setter Methode um die Windgeschwindigkeit festzulegen
     * @param speed: Geschwindigkeit in m/s
     */
    public void setWindSpeed(double speed) {
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
