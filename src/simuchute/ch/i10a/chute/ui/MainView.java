package simuchute.ch.i10a.chute.ui;

import javax.swing.JFrame;
/**
 *
 * @author Severin
 * MainView: Die Benutzeroberfläche
 */
public class MainView extends JFrame {
   /**
     * Creates new form MainView
     */
    public MainView() {
        initComponents();
      }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        altitudeLabel = new javax.swing.JLabel();
        altitude = new javax.swing.JSlider();
        altitudeValue = new javax.swing.JLabel();
        velocityLabel = new javax.swing.JLabel();
        velocityValue = new javax.swing.JTextField();
        velocityValueLabel = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        windSpeedValue = new javax.swing.JTextField();
        windSpeedValueLabel = new javax.swing.JLabel();
        windDirection = new javax.swing.JLabel();
        windDirectionValue = new javax.swing.JSlider();
        windDirectionValueLabel = new javax.swing.JLabel();
        startButton = new javax.swing.JButton();
        plane = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Simuchute");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Parameter"));

        altitudeLabel.setText("Flughöhe");

        altitude.setMaximum(9680);
        altitude.setMinimum(3000);
        altitude.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                altitudeStateChanged(evt);
            }
        });

        altitudeValue.setText("m");

        velocityLabel.setText("Geschwindigkeit");

        velocityValue.setText("jTextField1");

        velocityValueLabel.setText("m/s");

        jLabel1.setText("Wind");

        windSpeedValue.setText("jTextField1");

        windSpeedValueLabel.setText("m/s");

        windDirection.setText("Windrichtung");

        windDirectionValue.setMaximum(359);
        windDirectionValue.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                windDirectionValueStateChanged(evt);
            }
        });

        windDirectionValueLabel.setText("°");

        startButton.setText("Start!");
        startButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                startButtonMouseClicked(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                startButtonMouseReleased(evt);
            }
        });
        startButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                startButtonActionPerformed(evt);
            }
        });

        plane.setIcon(new javax.swing.ImageIcon(getClass().getResource("/simuchute/ch/i10a/chute/ui/resources/airplane.png"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(velocityLabel)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(windSpeedValue, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(windSpeedValueLabel))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(velocityValue, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(velocityValueLabel))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(altitudeLabel)
                        .addGap(42, 42, 42)
                        .addComponent(altitude, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addComponent(windDirection)
                        .addGap(18, 18, 18)
                        .addComponent(windDirectionValue, javax.swing.GroupLayout.DEFAULT_SIZE, 131, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 299, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(altitudeValue)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(windDirectionValueLabel)
                        .addGap(15, 15, 15))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(117, 117, 117)
                .addComponent(plane)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(startButton)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(altitudeValue)
                    .addComponent(altitude, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(altitudeLabel))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(velocityLabel)
                    .addComponent(velocityValue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(velocityValueLabel))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(windSpeedValue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(windSpeedValueLabel))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(windDirection)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(windDirectionValueLabel)
                        .addComponent(windDirectionValue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(35, 35, 35)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(startButton)
                    .addComponent(plane, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(667, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(1066, 1066, 1066))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(12, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(243, 243, 243))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void startButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_startButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_startButtonActionPerformed

    private void altitudeStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_altitudeStateChanged
        Integer spinValue = new Integer(altitude.getValue());
        String str = spinValue.toString() + " m";
        altitudeValue.setText(str);
    }//GEN-LAST:event_altitudeStateChanged

    private void windDirectionValueStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_windDirectionValueStateChanged
        Integer spinValue = new Integer(windDirectionValue.getValue());
        String str = spinValue.toString() + " °";
        windDirectionValueLabel.setText(str);
    }//GEN-LAST:event_windDirectionValueStateChanged

    private void startButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_startButtonMouseClicked
       
    }//GEN-LAST:event_startButtonMouseClicked

    private void startButtonMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_startButtonMouseReleased
         drawCoordinateSystem();
    }//GEN-LAST:event_startButtonMouseReleased

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        // Hauptfenster erstellen
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new MainView().setVisible(true);
            }
        });

    }
  
    public void drawCoordinateSystem() {
        //mainContainer.setBackground(Color.WHITE); // das Koordinatensystem soll einen weissen Hintergrund haben. 
        ShowCoordinates.create(this);
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JSlider altitude;
    private javax.swing.JLabel altitudeLabel;
    private javax.swing.JLabel altitudeValue;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel plane;
    private javax.swing.JButton startButton;
    private javax.swing.JLabel velocityLabel;
    private javax.swing.JTextField velocityValue;
    private javax.swing.JLabel velocityValueLabel;
    private javax.swing.JLabel windDirection;
    private javax.swing.JSlider windDirectionValue;
    private javax.swing.JLabel windDirectionValueLabel;
    private javax.swing.JTextField windSpeedValue;
    private javax.swing.JLabel windSpeedValueLabel;
    // End of variables declaration//GEN-END:variables
}
