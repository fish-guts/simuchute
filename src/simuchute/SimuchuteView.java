package simuchute;

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
import javax.swing.Icon;
import javax.swing.JDialog;
import javax.swing.Timer;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import numerik_tests.springer_1;
import simuchute.ch.i10a.chute.logic.Flugzeug;
import simuchute.ch.i10a.chute.logic.SimulationObject;
import simuchute.ch.i10a.chute.tools.Helper;
import simuchute.ch.i10a.chute.tools.Tools;

/**
 * The application's main frame.
 */
public class SimuchuteView extends FrameView {

    public SimuchuteView(SingleFrameApplication app) {
        super(app);

        initComponents();
        jumper.setVisible(false);
        plane.setVisible(false);
        currentPositionLabel.setVisible(false);
        currentPositionLabelX.setVisible(false);
        currentPositionLabelY.setVisible(false);
        currentPositionValueY.setVisible(false);
        currentPositionValueX.setVisible(false);
        calcLabel.setVisible(false);
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
        jLayeredPane1 = new javax.swing.JLayeredPane();
        coordinateLayer = new javax.swing.JLabel();
        jumper = new javax.swing.JLabel();
        plane = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        startButton = new javax.swing.JButton();
        altitudeLabel = new javax.swing.JLabel();
        flightSpeedLabel = new javax.swing.JLabel();
        airSpeedValueLabel = new javax.swing.JLabel();
        jumperWeightValueLabel1 = new javax.swing.JLabel();
        flightSpeedValueLabel = new javax.swing.JLabel();
        altitudeValueLabel = new javax.swing.JLabel();
        altitudeValue = new javax.swing.JSlider();
        flightSpeedValue = new javax.swing.JTextField();
        parachuteAreaLabel = new javax.swing.JLabel();
        airSpeedValue = new javax.swing.JTextField();
        parachuteAreaValue = new javax.swing.JTextField();
        jumpgerWeightLabel = new javax.swing.JLabel();
        airSpeedValueLabel1 = new javax.swing.JLabel();
        jumperWeightValue = new javax.swing.JTextField();
        airDensityLabel = new javax.swing.JLabel();
        jumperWeightValueLabel = new javax.swing.JLabel();
        airDensityValue = new javax.swing.JTextField();
        windSpeedLabel = new javax.swing.JLabel();
        currentPositionLabel = new javax.swing.JLabel();
        currentPositionLabelX = new javax.swing.JLabel();
        currentPositionLabelY = new javax.swing.JLabel();
        currentPositionValueX = new javax.swing.JTextField();
        currentPositionValueY = new javax.swing.JTextField();
        calcLabel = new javax.swing.JLabel();
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

        jLayeredPane1.setName("jLayeredPane1"); // NOI18N

        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance(simuchute.SimuchuteApp.class).getContext().getResourceMap(SimuchuteView.class);
        coordinateLayer.setIcon(resourceMap.getIcon("coordinateLayer.icon")); // NOI18N
        coordinateLayer.setText(resourceMap.getString("coordinateLayer.text")); // NOI18N
        coordinateLayer.setName("coordinateLayer"); // NOI18N
        coordinateLayer.setBounds(-10, -40, 1010, 720);
        jLayeredPane1.add(coordinateLayer, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jumper.setIcon(resourceMap.getIcon("jumper.icon")); // NOI18N
        jumper.setText(resourceMap.getString("jumper.text")); // NOI18N
        jumper.setName("jumper"); // NOI18N
        jumper.setBounds(350, 10, 38, 38);
        jLayeredPane1.add(jumper, javax.swing.JLayeredPane.DEFAULT_LAYER);

        plane.setIcon(resourceMap.getIcon("plane.icon")); // NOI18N
        plane.setText(resourceMap.getString("plane.text")); // NOI18N
        plane.setName("plane"); // NOI18N
        plane.setBounds(10, 0, 20, 30);
        jLayeredPane1.add(plane, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jPanel1.setName("jPanel1"); // NOI18N

        javax.swing.ActionMap actionMap = org.jdesktop.application.Application.getInstance(simuchute.SimuchuteApp.class).getContext().getActionMap(SimuchuteView.class, this);
        startButton.setAction(actionMap.get("startSimulation")); // NOI18N
        startButton.setText(resourceMap.getString("startButton.text")); // NOI18N
        startButton.setName("startButton"); // NOI18N

        altitudeLabel.setText(resourceMap.getString("altitudeLabel.text")); // NOI18N
        altitudeLabel.setName("altitudeLabel"); // NOI18N

        flightSpeedLabel.setText(resourceMap.getString("flightSpeedLabel.text")); // NOI18N
        flightSpeedLabel.setName("flightSpeedLabel"); // NOI18N

        airSpeedValueLabel.setText(resourceMap.getString("airSpeedValueLabel.text")); // NOI18N
        airSpeedValueLabel.setName("airSpeedValueLabel"); // NOI18N

        jumperWeightValueLabel1.setText(resourceMap.getString("jumperWeightValueLabel1.text")); // NOI18N
        jumperWeightValueLabel1.setName("jumperWeightValueLabel1"); // NOI18N

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

        flightSpeedValue.setText(resourceMap.getString("flightSpeedValue.text")); // NOI18N
        flightSpeedValue.setName("flightSpeedValue"); // NOI18N

        parachuteAreaLabel.setText(resourceMap.getString("parachuteAreaLabel.text")); // NOI18N
        parachuteAreaLabel.setName("parachuteAreaLabel"); // NOI18N

        airSpeedValue.setText(resourceMap.getString("airSpeedValue.text")); // NOI18N
        airSpeedValue.setName("airSpeedValue"); // NOI18N

        parachuteAreaValue.setText(resourceMap.getString("parachuteAreaValue.text")); // NOI18N
        parachuteAreaValue.setName("parachuteAreaValue"); // NOI18N

        jumpgerWeightLabel.setText(resourceMap.getString("jumpgerWeightLabel.text")); // NOI18N
        jumpgerWeightLabel.setName("jumpgerWeightLabel"); // NOI18N

        airSpeedValueLabel1.setText(resourceMap.getString("airSpeedValueLabel1.text")); // NOI18N
        airSpeedValueLabel1.setName("airSpeedValueLabel1"); // NOI18N

        jumperWeightValue.setText(resourceMap.getString("jumperWeightValue.text")); // NOI18N
        jumperWeightValue.setName("jumperWeightValue"); // NOI18N

        airDensityLabel.setText(resourceMap.getString("airDensityLabel.text")); // NOI18N
        airDensityLabel.setName("airDensityLabel"); // NOI18N

        jumperWeightValueLabel.setText(resourceMap.getString("jumperWeightValueLabel.text")); // NOI18N
        jumperWeightValueLabel.setName("jumperWeightValueLabel"); // NOI18N

        airDensityValue.setText(resourceMap.getString("airDensityValue.text")); // NOI18N
        airDensityValue.setName("airDensityValue"); // NOI18N

        windSpeedLabel.setText(resourceMap.getString("windSpeedLabel.text")); // NOI18N
        windSpeedLabel.setName("windSpeedLabel"); // NOI18N

        currentPositionLabel.setText(resourceMap.getString("currentPositionLabel.text")); // NOI18N
        currentPositionLabel.setName("currentPositionLabel"); // NOI18N

        currentPositionLabelX.setText(resourceMap.getString("currentPositionLabelX.text")); // NOI18N
        currentPositionLabelX.setName("currentPositionLabelX"); // NOI18N

        currentPositionLabelY.setText(resourceMap.getString("currentPositionLabelY.text")); // NOI18N
        currentPositionLabelY.setName("currentPositionLabelY"); // NOI18N

        currentPositionValueX.setFont(resourceMap.getFont("currentPositionValueX.font")); // NOI18N
        currentPositionValueX.setForeground(resourceMap.getColor("currentPositionValueX.foreground")); // NOI18N
        currentPositionValueX.setText(resourceMap.getString("currentPositionValueX.text")); // NOI18N
        currentPositionValueX.setName("currentPositionValueX"); // NOI18N

        currentPositionValueY.setFont(resourceMap.getFont("currentPositionValueY.font")); // NOI18N
        currentPositionValueY.setForeground(resourceMap.getColor("currentPositionValueY.foreground")); // NOI18N
        currentPositionValueY.setText(resourceMap.getString("currentPositionValueY.text")); // NOI18N
        currentPositionValueY.setName("currentPositionValueY"); // NOI18N

        calcLabel.setFont(resourceMap.getFont("calcLabel.font")); // NOI18N
        calcLabel.setForeground(resourceMap.getColor("calcLabel.foreground")); // NOI18N
        calcLabel.setText(resourceMap.getString("calcLabel.text")); // NOI18N
        calcLabel.setName("calcLabel"); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(altitudeLabel)
                                    .addComponent(flightSpeedLabel))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(16, 16, 16)
                                        .addComponent(altitudeValue, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                    .addComponent(currentPositionLabelX, javax.swing.GroupLayout.PREFERRED_SIZE, 6, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(currentPositionLabelY, javax.swing.GroupLayout.PREFERRED_SIZE, 6, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(23, 23, 23)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                        .addComponent(airSpeedValue, javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(flightSpeedValue, javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(parachuteAreaValue)
                                                        .addComponent(jumperWeightValue)
                                                        .addComponent(airDensityValue, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 82, Short.MAX_VALUE)
                                                        .addComponent(currentPositionValueX, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                    .addComponent(currentPositionValueY, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                            .addComponent(startButton, javax.swing.GroupLayout.DEFAULT_SIZE, 112, Short.MAX_VALUE))
                                        .addGap(18, 18, 18)
                                        .addComponent(calcLabel)
                                        .addGap(3, 3, 3))))
                            .addComponent(airDensityLabel)
                            .addComponent(parachuteAreaLabel)
                            .addComponent(jumpgerWeightLabel)
                            .addComponent(windSpeedLabel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 122, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(airSpeedValueLabel)
                            .addComponent(airSpeedValueLabel1)
                            .addComponent(altitudeValueLabel)
                            .addComponent(flightSpeedValueLabel)
                            .addComponent(jumperWeightValueLabel)
                            .addComponent(jumperWeightValueLabel1))
                        .addGap(115, 115, 115))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(currentPositionLabel)
                        .addContainerGap(472, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(altitudeValueLabel)
                        .addGap(18, 18, 18)
                        .addComponent(flightSpeedValueLabel))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(altitudeLabel)
                        .addGap(15, 15, 15)
                        .addComponent(flightSpeedLabel))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(altitudeValue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(flightSpeedValue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(windSpeedLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(airSpeedValue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(9, 9, 9)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(parachuteAreaLabel)
                            .addComponent(parachuteAreaValue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(17, 17, 17)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jumpgerWeightLabel)
                            .addComponent(jumperWeightValue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(airDensityLabel)
                            .addComponent(jumperWeightValueLabel1)
                            .addComponent(airDensityValue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(airSpeedValueLabel)
                        .addGap(9, 9, 9)
                        .addComponent(airSpeedValueLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(jumperWeightValueLabel)))
                .addGap(29, 29, 29)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(startButton)
                    .addComponent(calcLabel))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addComponent(currentPositionLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(currentPositionLabelX, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(currentPositionLabelY, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(54, 54, 54)
                        .addComponent(currentPositionValueY, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(15, 15, 15)
                        .addComponent(currentPositionValueX, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(341, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout mainPanelLayout = new javax.swing.GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLayeredPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1009, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        mainPanelLayout.setVerticalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLayeredPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 535, javax.swing.GroupLayout.PREFERRED_SIZE))
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
            .addComponent(statusPanelSeparator, javax.swing.GroupLayout.DEFAULT_SIZE, 1675, Short.MAX_VALUE)
            .addGroup(statusPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(statusMessageLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 1505, Short.MAX_VALUE)
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

    private void altitudeValueStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_altitudeValueStateChanged
        Integer spinValue = new Integer(altitudeValue.getValue());
        String str = spinValue.toString() + " m";
        altitudeValueLabel.setText(str);
}//GEN-LAST:event_altitudeValueStateChanged
    // updaten wenn Wert verändert wird.     // updaten wenn Wert verändert wird. sm

    @Action
    public Task startSimulation() {
        return new StartSimulationTask(getApplication(), this);

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
        }

        @Override
        protected Object doInBackground() {

            // validierungen, damit nur korrekte werte übergeben werten
            if (!Helper.isDouble(view.flightSpeedValue.getText())) {
                JOptionPane.showMessageDialog(null, "Der Wert im Feld Fluggeschwindigkeit muss eine Zahl sein", "Fehler", JOptionPane.ERROR_MESSAGE);
                return null;
            }
            if (!Helper.isDouble(view.airSpeedValue.getText())) {
                JOptionPane.showMessageDialog(null, "Der Wert im Feld Windgeschwindkigkeit muss eine Zahl sein", "Fehler", JOptionPane.ERROR_MESSAGE);
                return null;
            }
            if (!Helper.isDouble(view.airDensityValue.getText())) {
                JOptionPane.showMessageDialog(null, "Der Wert im Feld Luftdichte muss eine Zahl sein", "Fehler", JOptionPane.ERROR_MESSAGE);
                return null;
            }
            if (!Helper.isInteger(view.jumperWeightValue.getText())) {
                JOptionPane.showMessageDialog(null, "Der Wert im Feld Gewicht Springer muss eine ganze Zahl sein", "Fehler", JOptionPane.ERROR_MESSAGE);
                return null;
            }

            if (!Helper.isDouble(view.parachuteAreaValue.getText())) {
                JOptionPane.showMessageDialog(null, "Der Wert im Feld Fallschirmfläche muss eine Zahl sein", "Fehler", JOptionPane.ERROR_MESSAGE);
                return null;
            }

            SimulationObject sim = new SimulationObject();
            sim.setAltitude(view.altitudeValue.getValue());
            sim.setParachuteArea(new Double(view.parachuteAreaValue.getText()));
            sim.setPlaneSpeed(new Double(view.flightSpeedValue.getText()));
            sim.setWindSpeed(new Double(view.airSpeedValue.getText()));
            sim.setLuftDichte(new Double(view.airDensityValue.getText()));
            sim.setSpringerGewicht(new Integer(view.jumperWeightValue.getText()));
            Flugzeug flugzeug = new Flugzeug();
            double[] startKO = {0, 0};
            springer_1 springer = new springer_1();
            view.startButton.setEnabled(false);
            view.calcLabel.setVisible(true);
            //double t0, double t1, double tn, double tAnfang, double[] yAnfang, double h
            /** z[0] = x-Komponente des Positionsvektors        **/
            /** z[1] = y-Komponente des Positionsvektors        **/
            /** z[2] = x-Komponente des Geschwindigkeitsvektors **/
            /** z[3] = y-Komponente des Geschwindigkeitsvektors **/
            // t0: erster  Zeitpunkt der Tabelle tTable
            // t1: zweiter Zeitpunkt der Tabelle tTable
            // tn: letzter Zeitpunkt der Tabelle tTable
            double[] yAnfang = {100, 1000, 5, -5};
            //Tools.printArray2D(springer.fTable(0, 1, 1000, 0, yAnfang, 1));
            double[][] result = springer.fTable(0, 0.01, 1000, 0, yAnfang, 0.01);
            double KoNull = 0;
            int n = result.length;

            for (int i = 0; i < n; i++) {

                if (result[i][1] <= 0) {

                    System.out.println("End Resultat: " + result[i][0] + " " + result[i][1]);
                    KoNull = result[i][0];
                    i = n;

                }
            }

            if (KoNull != 110) {

                yAnfang[0] = yAnfang[0] - (KoNull - 110);
                System.out.println(yAnfang[0]);
                result = springer.fTable(0, 0.01, 1000, 0, yAnfang, 0.01);

                for (int i = 0; i < n; i++) {

                    if (result[i][1] <= 0) {

                        System.out.println("End Resultat: " + result[i][0] + " " + result[i][1]);
                        System.out.println(yAnfang[0]);
                        KoNull = result[i][0];
                        i = n;

                    }
                }
            }

            SimulationObject simulationObject = new SimulationObject();


            n = result.length;


            int o = 0;
            for (int i = 0; i < n; i++) {


                if (result[i][1] <= 0) {
                } else {
                    o++;
                }
            }
            double[][] resultnew = new double[o][4];
            for (int i = 0; i < n; i++) {


                if (result[i][1] <= 0) {
                    o++;

                } else {

                    resultnew[i][0] = result[i][0];
                    resultnew[i][1] = result[i][1];
                    resultnew[i][2] = result[i][2];
                    resultnew[i][3] = result[i][3];

                }
            }

            System.out.println(" NEUES ARRAYY                      NEU ARRAY");
            Tools.printArray2D(resultnew);
            view.calcLabel.setText("Berechne Flugbahn.... OK!!, starte Simulation");

            simulationObject.setFlugbahn(resultnew);
            currentPositionLabel.setVisible(true);
            currentPositionLabelX.setVisible(true);
            currentPositionLabelY.setVisible(true);
            currentPositionValueY.setVisible(true);
            currentPositionValueX.setVisible(true);
            for (int i = 0; i < resultnew.length; i++) {
                try {
                    Thread.sleep(32);
                } catch (InterruptedException ie) {
                    return null;
                }
                plane.setLocation(i / 5, 10);
                jumper.setVisible(true);
                jumper.setLocation((int) resultnew[i][1] * 10, (int) resultnew[i][0]);
                currentPositionValueX.setText(new Double(resultnew[i][1]).toString());
                currentPositionValueY.setText(new Double(resultnew[i][0]).toString());
            }
            view.startButton.setEnabled(true);
            return null;
        }

        @Override
        protected void succeeded(Object result) {
            // Runs on the EDT.  Update the GUI based on
            // the result computed by doInBackground().
        }
    }

    @Action
    public Task calculateJumper() {
        return new CalculateJumperTask(getApplication());
    }

    private class CalculateJumperTask extends org.jdesktop.application.Task<Object, Void> {

        CalculateJumperTask(org.jdesktop.application.Application app) {
            super(app);
        }

        @Override
        protected Object doInBackground() {
            // Your Task's code here.  This method runs
            // on a background thread, so don't reference
            // the Swing GUI from here.
            return null;  // return your result
        }

        @Override
        protected void succeeded(Object result) {
            // Runs on the EDT.  Update the GUI based on
            // the result computed by doInBackground().
        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JLabel airDensityLabel;
    public javax.swing.JTextField airDensityValue;
    public javax.swing.JTextField airSpeedValue;
    public javax.swing.JLabel airSpeedValueLabel;
    public javax.swing.JLabel airSpeedValueLabel1;
    public javax.swing.JLabel altitudeLabel;
    public javax.swing.JSlider altitudeValue;
    public javax.swing.JLabel altitudeValueLabel;
    public javax.swing.JLabel calcLabel;
    public javax.swing.JLabel coordinateLayer;
    public javax.swing.JLabel currentPositionLabel;
    public javax.swing.JLabel currentPositionLabelX;
    public javax.swing.JLabel currentPositionLabelY;
    public javax.swing.JTextField currentPositionValueX;
    public javax.swing.JTextField currentPositionValueY;
    public javax.swing.JLabel flightSpeedLabel;
    public javax.swing.JTextField flightSpeedValue;
    public javax.swing.JLabel flightSpeedValueLabel;
    public javax.swing.JLayeredPane jLayeredPane1;
    public javax.swing.JPanel jPanel1;
    public javax.swing.JLabel jumper;
    public javax.swing.JTextField jumperWeightValue;
    public javax.swing.JLabel jumperWeightValueLabel;
    public javax.swing.JLabel jumperWeightValueLabel1;
    public javax.swing.JLabel jumpgerWeightLabel;
    public javax.swing.JPanel mainPanel;
    public javax.swing.JMenuBar menuBar;
    public javax.swing.JLabel parachuteAreaLabel;
    public javax.swing.JTextField parachuteAreaValue;
    public javax.swing.JLabel plane;
    private javax.swing.JProgressBar progressBar;
    public javax.swing.JButton startButton;
    private javax.swing.JLabel statusAnimationLabel;
    private javax.swing.JLabel statusMessageLabel;
    public javax.swing.JPanel statusPanel;
    public javax.swing.JLabel windSpeedLabel;
    // End of variables declaration//GEN-END:variables
    private final Timer messageTimer;
    private final Timer busyIconTimer;
    private final Icon idleIcon;
    private final Icon[] busyIcons = new Icon[15];
    private int busyIconIndex = 0;
    private JDialog aboutBox;
}
