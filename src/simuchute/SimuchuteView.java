package simuchute;


/*
 * SimuchuteView.java
 */import java.awt.Paint;

/*
 * SimuchuteView.java
 */


import org.jdesktop.application.Action;
import org.jdesktop.application.ResourceMap;
import org.jdesktop.application.SingleFrameApplication;
import org.jdesktop.application.FrameView;
import org.jdesktop.application.Task;
import org.jdesktop.application.TaskMonitor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;
import javax.swing.Icon;
import javax.swing.JDialog;
import javax.swing.JFrame;
import simuchute.ch.i10a.chute.logic.Flugzeug;
import simuchute.ch.i10a.chute.ui.ShowCoordinates;

/**
 * The application's main frame.
 */
public class SimuchuteView extends FrameView {

    public SimuchuteView(SingleFrameApplication app) {
        super(app);

        initComponents();
        // status bar initialization - message timeout, idle icon and busy animation, etc
        ResourceMap resourceMap = getResourceMap();
        int messageTimeout = resourceMap.getInteger("StatusBar.messageTimeout");
        messageTimer = new Timer(messageTimeout, new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                statusMessageLabel.setText("");
            }
        });
        messageTimer.setRepeats(false);
        int busyAnimationRate = resourceMap.getInteger("StatusBar.busyAnimationRate");
        for (int i = 0; i < busyIcons.length; i++) {
            busyIcons[i] = resourceMap.getIcon("StatusBar.busyIcons[" + i + "]");
        }
        busyIconTimer = new Timer(busyAnimationRate, new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                busyIconIndex = (busyIconIndex + 1) % busyIcons.length;
                statusAnimationLabel.setIcon(busyIcons[busyIconIndex]);
            }
        });
        idleIcon = resourceMap.getIcon("StatusBar.idleIcon");
        statusAnimationLabel.setIcon(idleIcon);
        progressBar.setVisible(false);

        // connecting action tasks to status bar via TaskMonitor
        TaskMonitor taskMonitor = new TaskMonitor(getApplication().getContext());
        taskMonitor.addPropertyChangeListener(new java.beans.PropertyChangeListener() {

            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                String propertyName = evt.getPropertyName();
                if ("started".equals(propertyName)) {
                    if (!busyIconTimer.isRunning()) {
                        statusAnimationLabel.setIcon(busyIcons[0]);
                        busyIconIndex = 0;
                        busyIconTimer.start();
                    }
                    progressBar.setVisible(true);
                    progressBar.setIndeterminate(true);
                } else if ("done".equals(propertyName)) {
                    busyIconTimer.stop();
                    statusAnimationLabel.setIcon(idleIcon);
                    progressBar.setVisible(false);
                    progressBar.setValue(0);
                } else if ("message".equals(propertyName)) {
                    String text = (String) (evt.getNewValue());
                    statusMessageLabel.setText((text == null) ? "" : text);
                    messageTimer.restart();
                } else if ("progress".equals(propertyName)) {
                    int value = (Integer) (evt.getNewValue());
                    progressBar.setVisible(true);
                    progressBar.setIndeterminate(false);
                    progressBar.setValue(value);
                }
            }
        });
    }

    @Action
    public void showAboutBox() {
        if (aboutBox == null) {
            JFrame mainFrame = SimuchuteApp.getApplication().getMainFrame();
            aboutBox = new SimuchuteAboutBox(mainFrame);
            aboutBox.setLocationRelativeTo(mainFrame);
        }
        SimuchuteApp.getApplication().show(aboutBox);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainPanel = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        altitudeLabel = new javax.swing.JLabel();
        flightSpeedLabel = new javax.swing.JLabel();
        windDirectionLabel = new javax.swing.JLabel();
        airSpeedLabel = new javax.swing.JLabel();
        airSpeedValueLabel = new javax.swing.JLabel();
        windDirectionValueLabel = new javax.swing.JLabel();
        flightSpeedValueLabel = new javax.swing.JLabel();
        altitudeValueLabel = new javax.swing.JLabel();
        altitudeValue = new javax.swing.JSlider();
        windDirectionValue = new javax.swing.JSlider();
        flightSpeedValue = new javax.swing.JTextField();
        aurSpeedValue = new javax.swing.JTextField();
        jLayeredPane1 = new javax.swing.JLayeredPane();
        plane = new javax.swing.JLabel();
        jumper = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        menuBar = new javax.swing.JMenuBar();
        javax.swing.JMenu fileMenu = new javax.swing.JMenu();
        javax.swing.JMenuItem exitMenuItem = new javax.swing.JMenuItem();
        javax.swing.JMenu helpMenu = new javax.swing.JMenu();
        javax.swing.JMenuItem aboutMenuItem = new javax.swing.JMenuItem();
        statusPanel = new javax.swing.JPanel();
        javax.swing.JSeparator statusPanelSeparator = new javax.swing.JSeparator();
        statusMessageLabel = new javax.swing.JLabel();
        statusAnimationLabel = new javax.swing.JLabel();
        progressBar = new javax.swing.JProgressBar();

        mainPanel.setName("mainPanel"); // NOI18N

        jPanel1.setName("jPanel1"); // NOI18N

        javax.swing.ActionMap actionMap = org.jdesktop.application.Application.getInstance(simuchute.SimuchuteApp.class).getContext().getActionMap(SimuchuteView.class, this);
        jButton1.setAction(actionMap.get("startSimulation")); // NOI18N
        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance(simuchute.SimuchuteApp.class).getContext().getResourceMap(SimuchuteView.class);
        jButton1.setText(resourceMap.getString("jButton1.text")); // NOI18N
        jButton1.setName("jButton1"); // NOI18N

        altitudeLabel.setText(resourceMap.getString("altitudeLabel.text")); // NOI18N
        altitudeLabel.setName("altitudeLabel"); // NOI18N

        flightSpeedLabel.setText(resourceMap.getString("flightSpeedLabel.text")); // NOI18N
        flightSpeedLabel.setName("flightSpeedLabel"); // NOI18N

        windDirectionLabel.setText(resourceMap.getString("windDirectionLabel.text")); // NOI18N
        windDirectionLabel.setName("windDirectionLabel"); // NOI18N

        airSpeedLabel.setText(resourceMap.getString("airSpeedLabel.text")); // NOI18N
        airSpeedLabel.setName("airSpeedLabel"); // NOI18N

        airSpeedValueLabel.setText(resourceMap.getString("airSpeedValueLabel.text")); // NOI18N
        airSpeedValueLabel.setName("airSpeedValueLabel"); // NOI18N

        windDirectionValueLabel.setText(resourceMap.getString("windDirectionValueLabel.text")); // NOI18N
        windDirectionValueLabel.setName("windDirectionValueLabel"); // NOI18N

        flightSpeedValueLabel.setText(resourceMap.getString("flightSpeedValueLabel.text")); // NOI18N
        flightSpeedValueLabel.setName("flightSpeedValueLabel"); // NOI18N

        altitudeValueLabel.setText(resourceMap.getString("altitudeValueLabel.text")); // NOI18N
        altitudeValueLabel.setName("altitudeValueLabel"); // NOI18N

        altitudeValue.setMaximum(9680);
        altitudeValue.setMinimum(3000);
        altitudeValue.setName("altitudeValue"); // NOI18N
        altitudeValue.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                altitudeValueStateChanged(evt);
            }
        });

        windDirectionValue.setMaximum(359);
        windDirectionValue.setValue(0);
        windDirectionValue.setName("windDirectionValue"); // NOI18N
        windDirectionValue.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                windDirectionValueStateChanged(evt);
            }
        });

        flightSpeedValue.setText(resourceMap.getString("flightSpeedValue.text")); // NOI18N
        flightSpeedValue.setName("flightSpeedValue"); // NOI18N

        aurSpeedValue.setText(resourceMap.getString("aurSpeedValue.text")); // NOI18N
        aurSpeedValue.setName("aurSpeedValue"); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(altitudeLabel)
                            .addComponent(flightSpeedLabel)
                            .addComponent(windDirectionLabel))
                        .addGap(16, 16, 16)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                                    .addComponent(flightSpeedValue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(55, 55, 55))
                                .addComponent(windDirectionValue, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(altitudeValue, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(airSpeedLabel)
                            .addGap(48, 48, 48)
                            .addComponent(aurSpeedValue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jButton1)))
                .addGap(69, 69, 69)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(altitudeValueLabel)
                    .addComponent(flightSpeedValueLabel)
                    .addComponent(windDirectionValueLabel)
                    .addComponent(airSpeedValueLabel))
                .addGap(90, 90, 90))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(altitudeLabel)
                        .addGap(15, 15, 15)
                        .addComponent(flightSpeedLabel)
                        .addGap(18, 18, 18)
                        .addComponent(windDirectionLabel)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(airSpeedLabel)
                            .addComponent(aurSpeedValue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(altitudeValue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(flightSpeedValue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(windDirectionValue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(altitudeValueLabel)
                        .addGap(18, 18, 18)
                        .addComponent(flightSpeedValueLabel)
                        .addGap(18, 18, 18)
                        .addComponent(windDirectionValueLabel)
                        .addGap(18, 18, 18)
                        .addComponent(airSpeedValueLabel)))
                .addGap(61, 61, 61)
                .addComponent(jButton1)
                .addContainerGap(564, Short.MAX_VALUE))
        );

        jLayeredPane1.setName("jLayeredPane1"); // NOI18N

        plane.setIcon(resourceMap.getIcon("plane.icon")); // NOI18N
        plane.setText(resourceMap.getString("plane.text")); // NOI18N
        plane.setName("plane"); // NOI18N
        plane.setBounds(40, 10, 20, 30);
        jLayeredPane1.add(plane, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jumper.setIcon(resourceMap.getIcon("jumper.icon")); // NOI18N
        jumper.setText(resourceMap.getString("jumper.text")); // NOI18N
        jumper.setName("jumper"); // NOI18N
        jumper.setBounds(360, 0, 38, 38);
        jLayeredPane1.add(jumper, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel1.setIcon(resourceMap.getIcon("jLabel1.icon")); // NOI18N
        jLabel1.setText(resourceMap.getString("jLabel1.text")); // NOI18N
        jLabel1.setName("jLabel1"); // NOI18N
        jLabel1.setBounds(-6, 0, 1020, 460);
        jLayeredPane1.add(jLabel1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout mainPanelLayout = new javax.swing.GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLayeredPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 717, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(311, Short.MAX_VALUE))
        );
        mainPanelLayout.setVerticalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addComponent(jLayeredPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 535, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        menuBar.setName("menuBar"); // NOI18N

        fileMenu.setText(resourceMap.getString("fileMenu.text")); // NOI18N
        fileMenu.setName("fileMenu"); // NOI18N

        exitMenuItem.setAction(actionMap.get("quit")); // NOI18N
        exitMenuItem.setName("exitMenuItem"); // NOI18N
        fileMenu.add(exitMenuItem);

        menuBar.add(fileMenu);

        helpMenu.setText(resourceMap.getString("helpMenu.text")); // NOI18N
        helpMenu.setName("helpMenu"); // NOI18N

        aboutMenuItem.setAction(actionMap.get("showAboutBox")); // NOI18N
        aboutMenuItem.setName("aboutMenuItem"); // NOI18N
        helpMenu.add(aboutMenuItem);

        menuBar.add(helpMenu);

        statusPanel.setName("statusPanel"); // NOI18N

        statusPanelSeparator.setName("statusPanelSeparator"); // NOI18N

        statusMessageLabel.setName("statusMessageLabel"); // NOI18N

        statusAnimationLabel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        statusAnimationLabel.setName("statusAnimationLabel"); // NOI18N

        progressBar.setName("progressBar"); // NOI18N

        javax.swing.GroupLayout statusPanelLayout = new javax.swing.GroupLayout(statusPanel);
        statusPanel.setLayout(statusPanelLayout);
        statusPanelLayout.setHorizontalGroup(
            statusPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(statusPanelSeparator, javax.swing.GroupLayout.DEFAULT_SIZE, 1482, Short.MAX_VALUE)
            .addGroup(statusPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(statusMessageLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 1312, Short.MAX_VALUE)
                .addComponent(progressBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(statusAnimationLabel)
                .addContainerGap())
        );
        statusPanelLayout.setVerticalGroup(
            statusPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(statusPanelLayout.createSequentialGroup()
                .addComponent(statusPanelSeparator, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(statusPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(statusMessageLabel)
                    .addComponent(statusAnimationLabel)
                    .addComponent(progressBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(3, 3, 3))
        );

        setComponent(mainPanel);
        setMenuBar(menuBar);
        setStatusBar(statusPanel);
    }// </editor-fold>//GEN-END:initComponents
    // updaten wenn Wert verändert wird. 
    private void altitudeValueStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_altitudeValueStateChanged
        Integer spinValue = new Integer(altitudeValue.getValue());
        String str = spinValue.toString() + " m";
        altitudeValueLabel.setText(str);
    }//GEN-LAST:event_altitudeValueStateChanged
    // updaten wenn Wert verändert wird. sm
    private void windDirectionValueStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_windDirectionValueStateChanged
        Integer spinValue = new Integer(windDirectionValue.getValue());
        String str = spinValue.toString() + " °";
        windDirectionValueLabel.setText(str);
    }//GEN-LAST:event_windDirectionValueStateChanged

    @Action
    public Task startSimulation() {
        return new StartSimulationTask(getApplication(),this);

    }

    private class StartSimulationTask extends org.jdesktop.application.Task<Object, Void> {
        private org.jdesktop.application.Application backupApp;
        private final SimuchuteView view;
        StartSimulationTask(org.jdesktop.application.Application app, SimuchuteView view) {
            // Runs on the EDT.  Copy GUI state that
            // doInBackground() depends on from parameters
            // to StartSimulationTask fields, here.
            super(app);
            backupApp = app;
            this.view = view;
            jumper.setVisible(false);
        }

        @Override
        protected Object doInBackground() {
            ShowCoordinates sc = new ShowCoordinates();
            //sc.create(this.view.getFrame());
            Flugzeug flugzeug = new Flugzeug();
            double[] startKO = {0, 0};
            flugzeug.setKO(startKO);
            flugzeug.setTime(5);
            flugzeug.setTStart(0);
            flugzeug.calcFlugbahn();
            double[][] flugbahn = flugzeug.getFlugbahn();
            int j = 10;
            for(int i = 50;i<1000000;i++) {
                try {
                    Thread.sleep(1);
                } catch(InterruptedException ie) {
                    return null;
                }
                plane.setLocation(i/5,10);
                if((i>=1725) && (j<=4280)) {
                    jumper.setVisible(true);
                    jumper.setLocation(1725/5,j/10);
                    flightSpeedValue.setText("Hahahaha");
                    j++;
                }
            }

            return null;
        }

        @Override
        protected void succeeded(Object result) {
            // Runs on the EDT.  Update the GUI based on
            // the result computed by doInBackground().
        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JLabel airSpeedLabel;
    public javax.swing.JLabel airSpeedValueLabel;
    public javax.swing.JLabel altitudeLabel;
    public javax.swing.JSlider altitudeValue;
    public javax.swing.JLabel altitudeValueLabel;
    public javax.swing.JTextField aurSpeedValue;
    public javax.swing.JLabel flightSpeedLabel;
    public javax.swing.JTextField flightSpeedValue;
    public javax.swing.JLabel flightSpeedValueLabel;
    public javax.swing.JButton jButton1;
    public javax.swing.JLabel jLabel1;
    public javax.swing.JLayeredPane jLayeredPane1;
    public javax.swing.JPanel jPanel1;
    public javax.swing.JLabel jumper;
    public javax.swing.JPanel mainPanel;
    public javax.swing.JMenuBar menuBar;
    public javax.swing.JLabel plane;
    private javax.swing.JProgressBar progressBar;
    private javax.swing.JLabel statusAnimationLabel;
    private javax.swing.JLabel statusMessageLabel;
    public javax.swing.JPanel statusPanel;
    public javax.swing.JLabel windDirectionLabel;
    public javax.swing.JSlider windDirectionValue;
    public javax.swing.JLabel windDirectionValueLabel;
    // End of variables declaration//GEN-END:variables
    private final Timer messageTimer;
    private final Timer busyIconTimer;
    private final Icon idleIcon;
    private final Icon[] busyIcons = new Icon[15];
    private int busyIconIndex = 0;
    private JDialog aboutBox;
}
