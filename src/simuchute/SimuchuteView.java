package simuchute;

/*
 * SimuchuteView.java
 */
import java.awt.Point;
import org.jdesktop.application.Action;
import org.jdesktop.application.ResourceMap;
import org.jdesktop.application.SingleFrameApplication;
import org.jdesktop.application.FrameView;
import org.jdesktop.application.Task;
import org.jdesktop.application.TaskMonitor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.Timer;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import simuchute.ch.i10a.chute.logic.SimulationObject;
import simuchute.ch.i10a.chute.logic.Springer;
import simuchute.ch.i10a.chute.threads.ChuteRunnable;
import simuchute.ch.i10a.chute.tools.Tools;

/**
 * Das Hauptfenster der Applikation.
 * @author Severin Mueller
 */
public class SimuchuteView extends FrameView {

    public SimuchuteView(SingleFrameApplication app) {
        super(app);

        initComponents();
        jumper.setVisible(false);
        plane.setVisible(false);
        altitudeValueLabel.setText("4000 m");
        currentPositionLabel.setVisible(false);
        currentPositionLabelX.setVisible(false);
        currentPositionLabelY.setVisible(false);
        currentPositionValueX.setVisible(false);
        currentPositionValueY.setVisible(false);
        currentSpeedLabel.setVisible(false);
        currentSpeedValue.setVisible(false);

        landingPoint.setLocation(294, 710);
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
        jumper = new javax.swing.JLabel();
        landingPoint = new javax.swing.JLabel();
        plane = new javax.swing.JLabel();
        coordinateLayer = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        startButton = new javax.swing.JButton();
        altitudeLabel = new javax.swing.JLabel();
        flightSpeedLabel = new javax.swing.JLabel();
        airSpeedValueLabel = new javax.swing.JLabel();
        jumperAreaValueLabel = new javax.swing.JLabel();
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
        jumperAreaLabel = new javax.swing.JLabel();
        jumperWeightValueLabel = new javax.swing.JLabel();
        jumperAreaValue = new javax.swing.JTextField();
        windSpeedLabel = new javax.swing.JLabel();
        currentPositionLabel = new javax.swing.JLabel();
        currentPositionLabelX = new javax.swing.JLabel();
        currentPositionLabelY = new javax.swing.JLabel();
        currentPositionValueY = new javax.swing.JTextField();
        currentPositionValueX = new javax.swing.JTextField();
        calcLabel = new javax.swing.JLabel();
        airDensityLabel = new javax.swing.JLabel();
        airDensityValue = new javax.swing.JTextField();
        airDensityValueLabel = new javax.swing.JLabel();
        timeToOpenLabel = new javax.swing.JLabel();
        timeToOpenValue = new javax.swing.JTextField();
        timeToOpenValueLabel = new javax.swing.JLabel();
        timeWhenToOpenLabel = new javax.swing.JLabel();
        timeWhenToOpenValue = new javax.swing.JTextField();
        timeWhenToOpenValueLabel = new javax.swing.JLabel();
        landingPointLabel = new javax.swing.JLabel();
        landingPointValue = new javax.swing.JSlider();
        landingPointValueLabel = new javax.swing.JLabel();
        resetButton = new javax.swing.JButton();
        currentSpeedLabel = new javax.swing.JLabel();
        currentSpeedValue = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        simulatonOutput = new javax.swing.JTextArea();
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
        jumper.setIcon(resourceMap.getIcon("jumper.icon")); // NOI18N
        jumper.setText(resourceMap.getString("jumper.text")); // NOI18N
        jumper.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jumper.setAlignmentY(5.0F);
        jumper.setIconTextGap(0);
        jumper.setName("jumper"); // NOI18N
        jumper.setBounds(180, 98, 38, 40);
        jLayeredPane1.add(jumper, javax.swing.JLayeredPane.DEFAULT_LAYER);

        landingPoint.setIcon(resourceMap.getIcon("landingPoint.icon")); // NOI18N
        landingPoint.setText(resourceMap.getString("landingPoint.text")); // NOI18N
        landingPoint.setName("landingPoint"); // NOI18N
        landingPoint.setBounds(290, 710, 40, 40);
        jLayeredPane1.add(landingPoint, javax.swing.JLayeredPane.DEFAULT_LAYER);

        plane.setIcon(resourceMap.getIcon("plane.icon")); // NOI18N
        plane.setText(resourceMap.getString("plane.text")); // NOI18N
        plane.setName("plane"); // NOI18N
        plane.setBounds(1010, 700, 20, 30);
        jLayeredPane1.add(plane, javax.swing.JLayeredPane.DEFAULT_LAYER);

        coordinateLayer.setIcon(resourceMap.getIcon("coordinateLayer.icon")); // NOI18N
        coordinateLayer.setText(resourceMap.getString("coordinateLayer.text")); // NOI18N
        coordinateLayer.setName("coordinateLayer"); // NOI18N
        coordinateLayer.setBounds(10, 0, 1010, 760);
        jLayeredPane1.add(coordinateLayer, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(resourceMap.getString("jPanel1.border.title"))); // NOI18N
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

        jumperAreaValueLabel.setText(resourceMap.getString("jumperAreaValueLabel.text")); // NOI18N
        jumperAreaValueLabel.setName("jumperAreaValueLabel"); // NOI18N

        flightSpeedValueLabel.setText(resourceMap.getString("flightSpeedValueLabel.text")); // NOI18N
        flightSpeedValueLabel.setName("flightSpeedValueLabel"); // NOI18N

        altitudeValueLabel.setText(resourceMap.getString("altitudeValueLabel.text")); // NOI18N
        altitudeValueLabel.setName("altitudeValueLabel"); // NOI18N

        altitudeValue.setMaximum(6000);
        altitudeValue.setMinimum(4000);
        altitudeValue.setPaintTicks(true);
        altitudeValue.setSnapToTicks(true);
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

        jumperAreaLabel.setText(resourceMap.getString("jumperAreaLabel.text")); // NOI18N
        jumperAreaLabel.setName("jumperAreaLabel"); // NOI18N

        jumperWeightValueLabel.setText(resourceMap.getString("jumperWeightValueLabel.text")); // NOI18N
        jumperWeightValueLabel.setName("jumperWeightValueLabel"); // NOI18N

        jumperAreaValue.setText(resourceMap.getString("jumperAreaValue.text")); // NOI18N
        jumperAreaValue.setName("jumperAreaValue"); // NOI18N

        windSpeedLabel.setText(resourceMap.getString("windSpeedLabel.text")); // NOI18N
        windSpeedLabel.setName("windSpeedLabel"); // NOI18N

        currentPositionLabel.setText(resourceMap.getString("currentPositionLabel.text")); // NOI18N
        currentPositionLabel.setName("currentPositionLabel"); // NOI18N

        currentPositionLabelX.setText(resourceMap.getString("currentPositionLabelX.text")); // NOI18N
        currentPositionLabelX.setName("currentPositionLabelX"); // NOI18N

        currentPositionLabelY.setText(resourceMap.getString("currentPositionLabelY.text")); // NOI18N
        currentPositionLabelY.setName("currentPositionLabelY"); // NOI18N

        currentPositionValueY.setFont(resourceMap.getFont("currentPositionValueY.font")); // NOI18N
        currentPositionValueY.setForeground(resourceMap.getColor("currentPositionValueY.foreground")); // NOI18N
        currentPositionValueY.setText(resourceMap.getString("currentPositionValueY.text")); // NOI18N
        currentPositionValueY.setName("currentPositionValueY"); // NOI18N

        currentPositionValueX.setFont(resourceMap.getFont("currentPositionValueX.font")); // NOI18N
        currentPositionValueX.setForeground(resourceMap.getColor("currentPositionValueX.foreground")); // NOI18N
        currentPositionValueX.setText(resourceMap.getString("currentPositionValueX.text")); // NOI18N
        currentPositionValueX.setName("currentPositionValueX"); // NOI18N

        calcLabel.setFont(resourceMap.getFont("calcLabel.font")); // NOI18N
        calcLabel.setForeground(resourceMap.getColor("calcLabel.foreground")); // NOI18N
        calcLabel.setText(resourceMap.getString("calcLabel.text")); // NOI18N
        calcLabel.setName("calcLabel"); // NOI18N

        airDensityLabel.setText(resourceMap.getString("airDensityLabel.text")); // NOI18N
        airDensityLabel.setName("airDensityLabel"); // NOI18N

        airDensityValue.setText(resourceMap.getString("airDensityValue.text")); // NOI18N
        airDensityValue.setName("airDensityValue"); // NOI18N

        airDensityValueLabel.setText(resourceMap.getString("airDensityValueLabel.text")); // NOI18N
        airDensityValueLabel.setName("airDensityValueLabel"); // NOI18N

        timeToOpenLabel.setText(resourceMap.getString("timeToOpenLabel.text")); // NOI18N
        timeToOpenLabel.setName("timeToOpenLabel"); // NOI18N

        timeToOpenValue.setText(resourceMap.getString("timeToOpenValue.text")); // NOI18N
        timeToOpenValue.setName("timeToOpenValue"); // NOI18N

        timeToOpenValueLabel.setText(resourceMap.getString("timeToOpenValueLabel.text")); // NOI18N
        timeToOpenValueLabel.setName("timeToOpenValueLabel"); // NOI18N

        timeWhenToOpenLabel.setText(resourceMap.getString("timeWhenToOpenLabel.text")); // NOI18N
        timeWhenToOpenLabel.setName("timeWhenToOpenLabel"); // NOI18N

        timeWhenToOpenValue.setText(resourceMap.getString("timeWhenToOpenValue.text")); // NOI18N
        timeWhenToOpenValue.setName("timeWhenToOpenValue"); // NOI18N

        timeWhenToOpenValueLabel.setText(resourceMap.getString("timeWhenToOpenValueLabel.text")); // NOI18N
        timeWhenToOpenValueLabel.setName("timeWhenToOpenValueLabel"); // NOI18N

        landingPointLabel.setText(resourceMap.getString("landingPointLabel.text")); // NOI18N
        landingPointLabel.setName("landingPointLabel"); // NOI18N

        landingPointValue.setMaximum(1010);
        landingPointValue.setPaintTicks(true);
        landingPointValue.setSnapToTicks(true);
        landingPointValue.setValue(300);
        landingPointValue.setName("landingPointValue"); // NOI18N
        landingPointValue.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                landingPointValueStateChanged(evt);
            }
        });

        landingPointValueLabel.setText(resourceMap.getString("landingPointValueLabel.text")); // NOI18N
        landingPointValueLabel.setName("landingPointValueLabel"); // NOI18N

        resetButton.setText(resourceMap.getString("resetButton.text")); // NOI18N
        resetButton.setName("resetButton"); // NOI18N
        resetButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetButtonActionPerformed(evt);
            }
        });

        currentSpeedLabel.setText(resourceMap.getString("currentSpeedLabel.text")); // NOI18N
        currentSpeedLabel.setName("currentSpeedLabel"); // NOI18N

        currentSpeedValue.setFont(resourceMap.getFont("currentSpeedValue.font")); // NOI18N
        currentSpeedValue.setForeground(resourceMap.getColor("currentSpeedValue.foreground")); // NOI18N
        currentSpeedValue.setText(resourceMap.getString("currentSpeedValue.text")); // NOI18N
        currentSpeedValue.setName("currentSpeedValue"); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jumperAreaLabel)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(jPanel1Layout.createSequentialGroup()
                                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(altitudeLabel)
                                                        .addComponent(flightSpeedLabel)
                                                        .addComponent(airDensityLabel))
                                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                                                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                                .addComponent(airSpeedValue, javax.swing.GroupLayout.Alignment.LEADING)
                                                                .addComponent(flightSpeedValue, javax.swing.GroupLayout.Alignment.LEADING)
                                                                .addComponent(parachuteAreaValue)
                                                                .addComponent(jumperWeightValue)
                                                                .addComponent(jumperAreaValue, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 82, Short.MAX_VALUE)
                                                                .addComponent(airDensityValue, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 82, Short.MAX_VALUE)
                                                                .addComponent(timeToOpenValue, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(timeWhenToOpenValue, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                            .addGap(113, 113, 113))
                                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                            .addGap(16, 16, 16)
                                                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                                .addComponent(landingPointValue, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(altitudeValue, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                            .addGap(71, 71, 71))))
                                                .addGroup(jPanel1Layout.createSequentialGroup()
                                                    .addComponent(windSpeedLabel)
                                                    .addGap(234, 234, 234)))
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(parachuteAreaLabel)
                                                .addGap(253, 253, 253)))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addComponent(jumpgerWeightLabel)
                                            .addGap(252, 252, 252)))
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(flightSpeedValueLabel)
                                        .addComponent(altitudeValueLabel)
                                        .addComponent(airSpeedValueLabel)
                                        .addComponent(airSpeedValueLabel1)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(airDensityValueLabel)
                                                .addComponent(jumperAreaValueLabel)
                                                .addComponent(jumperWeightValueLabel)
                                                .addComponent(timeToOpenValueLabel)
                                                .addComponent(timeWhenToOpenValueLabel)
                                                .addComponent(landingPointValueLabel))))
                                    .addGap(59, 59, 59)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 166, Short.MAX_VALUE)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                    .addComponent(currentPositionLabelX, javax.swing.GroupLayout.PREFERRED_SIZE, 6, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(currentPositionLabelY, javax.swing.GroupLayout.PREFERRED_SIZE, 6, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(23, 23, 23))
                                            .addComponent(currentPositionLabel)
                                            .addComponent(currentSpeedLabel))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(currentPositionValueY, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(currentPositionValueX, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(currentSpeedValue, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(resetButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(startButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 115, Short.MAX_VALUE))
                                        .addGap(18, 18, 18)
                                        .addComponent(calcLabel)
                                        .addGap(22, 22, 22)))
                                .addGap(119, 119, 119)))
                        .addGap(336, 336, 336))
                    .addComponent(timeToOpenLabel)
                    .addComponent(timeWhenToOpenLabel)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(landingPointLabel)
                        .addContainerGap(430, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(altitudeLabel)
                        .addGap(15, 15, 15)
                        .addComponent(flightSpeedLabel))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(altitudeValue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(altitudeValueLabel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(flightSpeedValue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(flightSpeedValueLabel))))
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
                            .addComponent(jumperWeightValue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jumperWeightValueLabel))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jumperAreaLabel)
                            .addComponent(jumperAreaValue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jumperAreaValueLabel))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(airDensityLabel)
                            .addComponent(airDensityValue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(airDensityValueLabel)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(airSpeedValueLabel)
                        .addGap(18, 18, 18)
                        .addComponent(airSpeedValueLabel1)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(timeToOpenLabel)
                    .addComponent(timeToOpenValue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(timeToOpenValueLabel))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(timeWhenToOpenLabel)
                    .addComponent(timeWhenToOpenValue, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(timeWhenToOpenValueLabel))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(landingPointLabel)
                            .addComponent(landingPointValue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(24, 24, 24)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(startButton)
                            .addComponent(calcLabel))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(56, 56, 56)
                                        .addComponent(currentPositionLabelX, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(currentPositionLabelY, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(54, 54, 54)
                                        .addComponent(currentPositionValueX, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(15, 15, 15)
                                        .addComponent(currentPositionValueY, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(currentSpeedValue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(currentSpeedLabel)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGap(11, 11, 11)
                                .addComponent(resetButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 56, Short.MAX_VALUE)
                                .addComponent(currentPositionLabel)
                                .addGap(45, 45, 45))))
                    .addComponent(landingPointValueLabel))
                .addGap(14, 14, 14))
        );

        jScrollPane2.setName("jScrollPane2"); // NOI18N

        simulatonOutput.setBackground(resourceMap.getColor("simulatonOutput.background")); // NOI18N
        simulatonOutput.setColumns(20);
        simulatonOutput.setForeground(resourceMap.getColor("simulatonOutput.foreground")); // NOI18N
        simulatonOutput.setRows(5);
        simulatonOutput.setAutoscrolls(false);
        simulatonOutput.setMaximumSize(new java.awt.Dimension(164, 94));
        simulatonOutput.setName("simulatonOutput"); // NOI18N
        jScrollPane2.setViewportView(simulatonOutput);

        javax.swing.GroupLayout mainPanelLayout = new javax.swing.GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 508, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 504, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLayeredPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1024, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        mainPanelLayout.setVerticalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLayeredPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 785, Short.MAX_VALUE))
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
            .addComponent(statusPanelSeparator, javax.swing.GroupLayout.DEFAULT_SIZE, 1562, Short.MAX_VALUE)
            .addGroup(statusPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(statusMessageLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 1392, Short.MAX_VALUE)
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

    private void landingPointValueStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_landingPointValueStateChanged
        Integer spinValue = new Integer(landingPointValue.getValue());
        String str = spinValue.toString();
        landingPointValueLabel.setText(str);
        landingPoint.setLocation(spinValue - 6, 710);

    }//GEN-LAST:event_landingPointValueStateChanged

    private void resetButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetButtonActionPerformed
       this.resetGui();
    }//GEN-LAST:event_resetButtonActionPerformed
    // updaten wenn Wert verändert wird.   sm

    public void resetGui() {
        airDensityValue.setEnabled(true);
        airSpeedValue.setEnabled(true);
        altitudeValue.setEnabled(true);
        flightSpeedValue.setEnabled(true);
        timeToOpenValue.setEnabled(true);
        timeWhenToOpenValue.setEnabled(true);
        jumperAreaValue.setEnabled(true);
        parachuteAreaValue.setEnabled(true);
        landingPoint.setEnabled(true);
        jumperWeightValue.setEnabled(true);
        File newFile = new File("src\\simuchute\\ch\\i10a\\chute\\ui\\resources\\jumper_no_para.png");
        String imageName = newFile.getAbsolutePath();
        jumper.setIcon(new ImageIcon(imageName));
        plane.setVisible(false);
        jumper.setVisible(false);
        altitudeValueLabel.setText("4000 m");
        currentPositionLabel.setVisible(false);
        currentPositionLabelX.setVisible(false);
        currentPositionLabelY.setVisible(false);
        currentPositionValueX.setVisible(false);
        currentPositionValueY.setVisible(false);
        currentSpeedLabel.setVisible(false);
        currentSpeedValue.setVisible(false);
        landingPoint.setLocation(294, 710);
        calcLabel.setVisible(false);
        startButton.setEnabled(true);
        this.calcLabel.setText("Berechne Flugbahn...");


    }
    @Action
    public Task startSimulation() {
        return new StartSimulationTask(getApplication(), this);

    }

    private class StartSimulationTask extends org.jdesktop.application.Task<Object, Void> {

        private org.jdesktop.application.Application backupApp;
        private final SimuchuteView view;

        StartSimulationTask(org.jdesktop.application.Application app, SimuchuteView view) {
            super(app);
            backupApp = app;
            this.view = view;
        }
        // Wir verschieben die Simulation in den Hintergrund, damit die Berechnungen nicht auf dem Event Dispatch Thread laufen.

        @Override
        protected Object doInBackground() {
            disableGui();
            // validierungen, damit nur korrekte Werte übergeben werten
            if (!Tools.isDouble(view.flightSpeedValue.getText())) {
                JOptionPane.showMessageDialog(null, "Der Wert im Feld Fluggeschwindigkeit muss eine Zahl sein", "Fehler", JOptionPane.ERROR_MESSAGE);
                return null;
            }
            if (!Tools.isDouble(view.airSpeedValue.getText())) {
                JOptionPane.showMessageDialog(null, "Der Wert im Feld Windgeschwindkigkeit muss eine Zahl sein", "Fehler", JOptionPane.ERROR_MESSAGE);
                return null;
            }
            if (!Tools.isDouble(view.parachuteAreaValue.getText())) {
                JOptionPane.showMessageDialog(null, "Der Wert im Feld Fallschirmfläche muss eine Zahl sein", "Fehler", JOptionPane.ERROR_MESSAGE);
                return null;
            }
            if (!Tools.isInteger(view.jumperWeightValue.getText())) {
                JOptionPane.showMessageDialog(null, "Der Wert im Feld Gewicht Springer muss eine ganze Zahl sein", "Fehler", JOptionPane.ERROR_MESSAGE);
                return null;
            }
            if (!Tools.isDouble(view.jumperAreaValue.getText())) {
                JOptionPane.showMessageDialog(null, "Der Wert im Feld Fläche Springer muss eine Zahl sein", "Fehler", JOptionPane.ERROR_MESSAGE);
                return null;
            }
            if (!Tools.isDouble(view.airDensityValue.getText())) {
                JOptionPane.showMessageDialog(null, "Der Wert im Feld Luftdichte muss eine Zahl sein", "Fehler", JOptionPane.ERROR_MESSAGE);
                return null;
            }
            if (!Tools.isInteger(view.timeToOpenValue.getText())) {
                JOptionPane.showMessageDialog(null, "Der Wert im Feld Fallschirmöffnungszeit muss eine Zahl sein", "Fehler", JOptionPane.ERROR_MESSAGE);
                return null;
            }
            if (!Tools.isInteger(view.timeWhenToOpenValue.getText())) {
                JOptionPane.showMessageDialog(null, "Der Wert im Feld Zeitpunkt Öffnung muss eine Zahl sein", "Fehler", JOptionPane.ERROR_MESSAGE);
                return null;
            }
            // Hier legen wir ein Objekt an, um die GUI Werte zu kapseln
            SimulationObject sim = new SimulationObject();
            sim.setAltitude(view.altitudeValue.getValue());
            sim.setParachuteArea(new Double(view.parachuteAreaValue.getText()));
            sim.setPlaneSpeed(new Double(view.flightSpeedValue.getText()));
            sim.setWindSpeed(new Double(view.airSpeedValue.getText()));
            sim.setLuftDichte(new Double(view.jumperAreaValue.getText()));
            sim.setSpringerGewicht(new Integer(view.jumperWeightValue.getText()));
            sim.setParachuteTimeToOpen(new Integer(view.timeToOpenValue.getText()));
            sim.setSpringerFlaeche(new Double(view.jumperAreaValue.getText()));
            sim.setLuftDichte(new Double(view.airDensityValue.getText()));
            sim.setTOffen(new Double(view.timeWhenToOpenValue.getText()));
            sim.setLandePunkt(new Double(view.landingPointValue.getValue() * 10));
            // statische Anfangswerte, die wir nicht dynamisch haben wollen.
            sim.setSpringerFlaecheStart(0.5);
            sim.setTOeffnen(2);
            sim.setSchrittweite(0.1);
            sim.setTAnfang(0);
            sim.setTEnde(1000);
            sim.setSchrittweiteResult(0.1);
            sim.setCwStart(0.5);
            sim.setCwEnde(3.0);
            view.startButton.setEnabled(false);
            view.calcLabel.setVisible(true);
            Point pt = plane.getLocation();
            // Springer Object erstellen und mit Werten abfüllen
            Springer springer = new Springer(sim);
            // Flugbahn etc berechnen
            springer.calcSpringer();
            // Object mit den berechneten Werten abholen,
            sim = springer.getFlugbahnSpringer();

            // Test Print, Springerflugbahn
            Tools.printArrayInTextArea(view, sim.getResult());


            // Werte anzeigen nach Berechnen
            System.out.println(" Neuer Abspringpunkt : " + sim.getResultAbsprungPunkt());
            System.out.println(" Maximale Geschwindigkeit : " + sim.getMaxSpringerGeschwindigkeit());
            System.out.println(" Springer Gewicht : " + sim.getSpringerGewicht());
            System.out.println(" Springer Fläche Start : " + sim.getSpringerFlaecheStart());
            System.out.println(" Springer Fläche Ende (Berechnet): " + sim.getSpringerFlaeche());
            System.out.println(" Springer Fläche Ende (Gesetzter Wert): " + sim.getParachuteArea());
            System.out.println(" Springer Gewicht : " + sim.getSpringerGewicht());
            System.out.println(" Fallschirm wird geöffnet bei : " + sim.getTOffen());
            System.out.println(" Fallschirm öffnen dauert : " + sim.getTOeffnen());
            System.out.println(" CW Start : " + sim.getCwStart());
            System.out.println(" CW Ende : " + sim.getCwEnde());
            System.out.println(" Springer End Geschwindigkeit : " + sim.getSpringerEndGeschwindigkeit());
            System.out.println(" Springer Flugzeit : " + sim.getSpringerFlugzeit());
            calcLabel.setText("Berechne Flugbahn...Fertig!");

            // Berechnungen sind Fertig, nun Simulieren wir den Sprung
            double[][] result = sim.getResult();
            Point jumperLocation = new Point();

            plane.setVisible(true);
            Thread planeThread = new Thread(new ChuteRunnable(view, sim));
            planeThread.start();

            return null;
        }

        @Override
        protected void succeeded(Object result) {
        }
    }

    private void disableGui() {
        airDensityValue.setEnabled(false);
        airSpeedValue.setEnabled(false);
        altitudeValue.setEnabled(false);
        flightSpeedValue.setEnabled(false);
        timeToOpenValue.setEnabled(false);
        timeWhenToOpenValue.setEnabled(false);
        jumperAreaValue.setEnabled(false);
        parachuteAreaValue.setEnabled(false);
        landingPointValue.setEnabled(false);
        jumperWeightValue.setEnabled(false);
        resetButton.setEnabled(false);
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
            return null;  // return your result
        }

        @Override
        protected void succeeded(Object result) {
        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JLabel airDensityLabel;
    public javax.swing.JTextField airDensityValue;
    public javax.swing.JLabel airDensityValueLabel;
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
    public javax.swing.JLabel currentSpeedLabel;
    public javax.swing.JTextField currentSpeedValue;
    public javax.swing.JLabel flightSpeedLabel;
    public javax.swing.JTextField flightSpeedValue;
    public javax.swing.JLabel flightSpeedValueLabel;
    public javax.swing.JLayeredPane jLayeredPane1;
    public javax.swing.JPanel jPanel1;
    public javax.swing.JScrollPane jScrollPane2;
    public javax.swing.JLabel jumper;
    public javax.swing.JLabel jumperAreaLabel;
    public javax.swing.JTextField jumperAreaValue;
    public javax.swing.JLabel jumperAreaValueLabel;
    public javax.swing.JTextField jumperWeightValue;
    public javax.swing.JLabel jumperWeightValueLabel;
    public javax.swing.JLabel jumpgerWeightLabel;
    public javax.swing.JLabel landingPoint;
    public javax.swing.JLabel landingPointLabel;
    public javax.swing.JSlider landingPointValue;
    public javax.swing.JLabel landingPointValueLabel;
    public javax.swing.JPanel mainPanel;
    public javax.swing.JMenuBar menuBar;
    public javax.swing.JLabel parachuteAreaLabel;
    public javax.swing.JTextField parachuteAreaValue;
    public javax.swing.JLabel plane;
    private javax.swing.JProgressBar progressBar;
    public javax.swing.JButton resetButton;
    public javax.swing.JTextArea simulatonOutput;
    public javax.swing.JButton startButton;
    private javax.swing.JLabel statusAnimationLabel;
    private javax.swing.JLabel statusMessageLabel;
    public javax.swing.JPanel statusPanel;
    public javax.swing.JLabel timeToOpenLabel;
    public javax.swing.JTextField timeToOpenValue;
    public javax.swing.JLabel timeToOpenValueLabel;
    public javax.swing.JLabel timeWhenToOpenLabel;
    public javax.swing.JTextField timeWhenToOpenValue;
    public javax.swing.JLabel timeWhenToOpenValueLabel;
    public javax.swing.JLabel windSpeedLabel;
    // End of variables declaration//GEN-END:variables
    private final Timer messageTimer;
    private final Timer busyIconTimer;
    private final Icon idleIcon;
    private final Icon[] busyIcons = new Icon[15];
    private int busyIconIndex = 0;
    private JDialog aboutBox;
}
