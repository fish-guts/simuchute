/*
 * SimuchuteApp.java
 */

package simuchute;

import org.jdesktop.application.Application;
import org.jdesktop.application.SingleFrameApplication;

/**
 * The main class of the application.
 */
public class SimuchuteApp extends SingleFrameApplication {

    /**
     * At startup create and show the main frame of the application.
     */
    @Override protected void startup() {
        show(new SimuchuteView(this));
            }

    @Override protected void configureWindow(java.awt.Window root) {
    }

    /**
     * A convenient static getter for the application instance.
     * @return the instance of SimuchuteApp
     */
    public static SimuchuteApp getApplication() {
        return Application.getInstance(SimuchuteApp.class);
    }

    /**
     * Main method launching the application.
     */
    public static void main(String[] args) {
        launch(SimuchuteApp.class, args);

    }
}
