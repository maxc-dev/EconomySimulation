package economysimulation;

import java.awt.BorderLayout;
import java.util.ArrayList;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 *
 * @author Max Carter
 */
public class PGovernment extends javax.swing.JPanel {

    private static final String[] TITLES = new String[]{ "Interest Rates", "Exchange Rates" };
    private static final double[] VALUES = new double[]{ Methods.INTEREST_RATE, Methods.EXCHANGE_RATE };
    private static final ArrayList<Double>[] HISTORY = new ArrayList[]{ Methods.INTEREST_RATES, Methods.EXCHANGE_RATES };
    private static JPanel[] panelsBack;
    
    //<editor-fold defaultstate="collapsed" desc="Receives clock pulse."> 
    public static void globalClockPulseGov() {
        Methods.INTEREST_RATES.add(Methods.INTEREST_RATE);
//
//        Methods.createGraph("Interest Rates", Methods.INTEREST_RATES, graphPanelIR);
        
        for (int i = 0; i < 2; i++) {
            //history[i].add(values[i]);
            
            Methods.createGraph(TITLES[i], HISTORY[i], panelsBack[i]);
        }
        
    }//</editor-fold> 
  
    
    
    //<editor-fold defaultstate="collapsed" desc="Adjusts Interest Rates"> 
    private void adjustInterestRates(int tenth, int dec) {
        min.setText(tenth + "%");
        max.setText((tenth + 1) + "%");
        Methods.INTEREST_RATE = tenth + ((double) dec / 10);
        valueIR.setText("Interest Rates: " + Methods.INTEREST_RATE + "%");
    }//</editor-fold> 

    //<editor-fold defaultstate="collapsed" desc="Slider Event">   
    private void addSliderListener(JSlider slider) { 
        slider.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                
                adjustInterestRates(sliderIR.getValue(), sliderIRDec.getValue());
            }
        });
        
    }//</editor-fold> 
    
    //<editor-fold defaultstate="collapsed" desc="Constructor."> 
    public PGovernment() {
        initComponents();
        
        panelsBack = new JPanel[]{ graphPanelIR, graphPanelER };
        
        addSliderListener(sliderIR);
        addSliderListener(sliderIRDec);
        
        adjustInterestRates(sliderIR.getValue(), sliderIRDec.getValue());
    }//</editor-fold>

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        subTitle = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        panelIR = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        sliderIR = new javax.swing.JSlider();
        valueIR = new javax.swing.JLabel();
        min = new javax.swing.JLabel();
        hunnit = new javax.swing.JLabel();
        sliderIRDec = new javax.swing.JSlider();
        zero1 = new javax.swing.JLabel();
        max = new javax.swing.JLabel();
        graphPanelIR = new javax.swing.JPanel();
        panelER = new javax.swing.JPanel();
        graphPanelER = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        valueIR1 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();

        setBackground(new java.awt.Color(51, 51, 51));

        subTitle.setFont(new java.awt.Font("Agency FB", 1, 72)); // NOI18N
        subTitle.setForeground(new java.awt.Color(204, 0, 0));
        subTitle.setText("Government");

        panelIR.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Interest Rates", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Agency FB", 1, 36), new java.awt.Color(255, 255, 255))); // NOI18N
        panelIR.setOpaque(false);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Control", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Agency FB", 1, 24), new java.awt.Color(255, 255, 255))); // NOI18N
        jPanel2.setOpaque(false);

        sliderIR.setForeground(new java.awt.Color(204, 51, 0));
        sliderIR.setMajorTickSpacing(1);
        sliderIR.setMaximum(99);
        sliderIR.setValue(0);
        sliderIR.setOpaque(false);

        valueIR.setFont(new java.awt.Font("Agency FB", 1, 30)); // NOI18N
        valueIR.setForeground(new java.awt.Color(255, 255, 255));
        valueIR.setText("Interest Rates: ");

        min.setFont(new java.awt.Font("Agency FB", 1, 30)); // NOI18N
        min.setForeground(new java.awt.Color(255, 255, 255));
        min.setText("0%");

        hunnit.setFont(new java.awt.Font("Agency FB", 1, 30)); // NOI18N
        hunnit.setForeground(new java.awt.Color(255, 255, 255));
        hunnit.setText("99%");

        sliderIRDec.setForeground(new java.awt.Color(204, 51, 0));
        sliderIRDec.setMajorTickSpacing(1);
        sliderIRDec.setMaximum(10);
        sliderIRDec.setValue(5);
        sliderIRDec.setOpaque(false);

        zero1.setFont(new java.awt.Font("Agency FB", 1, 30)); // NOI18N
        zero1.setForeground(new java.awt.Color(255, 255, 255));
        zero1.setText("0%");

        max.setFont(new java.awt.Font("Agency FB", 1, 30)); // NOI18N
        max.setForeground(new java.awt.Color(255, 255, 255));
        max.setText("100%");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addContainerGap(51, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addComponent(zero1)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(hunnit))
                                .addComponent(sliderIR, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(sliderIRDec, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(valueIR, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(min)
                                .addGap(121, 121, 121)
                                .addComponent(max)
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addComponent(sliderIR, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(zero1)
                    .addComponent(hunnit))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sliderIRDec, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(min)
                    .addComponent(max))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(valueIR)
                .addContainerGap(180, Short.MAX_VALUE))
        );

        graphPanelIR.setOpaque(false);

        javax.swing.GroupLayout graphPanelIRLayout = new javax.swing.GroupLayout(graphPanelIR);
        graphPanelIR.setLayout(graphPanelIRLayout);
        graphPanelIRLayout.setHorizontalGroup(
            graphPanelIRLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 749, Short.MAX_VALUE)
        );
        graphPanelIRLayout.setVerticalGroup(
            graphPanelIRLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout panelIRLayout = new javax.swing.GroupLayout(panelIR);
        panelIR.setLayout(panelIRLayout);
        panelIRLayout.setHorizontalGroup(
            panelIRLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelIRLayout.createSequentialGroup()
                .addComponent(graphPanelIR, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        panelIRLayout.setVerticalGroup(
            panelIRLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(graphPanelIR, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        panelER.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Exchange Rate", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Agency FB", 1, 36), new java.awt.Color(255, 255, 255))); // NOI18N
        panelER.setOpaque(false);

        graphPanelER.setOpaque(false);

        javax.swing.GroupLayout graphPanelERLayout = new javax.swing.GroupLayout(graphPanelER);
        graphPanelER.setLayout(graphPanelERLayout);
        graphPanelERLayout.setHorizontalGroup(
            graphPanelERLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 749, Short.MAX_VALUE)
        );
        graphPanelERLayout.setVerticalGroup(
            graphPanelERLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Control", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Agency FB", 1, 24), new java.awt.Color(255, 255, 255))); // NOI18N
        jPanel1.setOpaque(false);

        valueIR1.setFont(new java.awt.Font("Agency FB", 1, 30)); // NOI18N
        valueIR1.setForeground(new java.awt.Color(255, 255, 255));
        valueIR1.setText("Exchange Rate: £1 = €1.14");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(valueIR1, javax.swing.GroupLayout.DEFAULT_SIZE, 238, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(313, Short.MAX_VALUE)
                .addComponent(valueIR1)
                .addContainerGap())
        );

        javax.swing.GroupLayout panelERLayout = new javax.swing.GroupLayout(panelER);
        panelER.setLayout(panelERLayout);
        panelERLayout.setHorizontalGroup(
            panelERLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelERLayout.createSequentialGroup()
                .addGap(1, 1, 1)
                .addComponent(graphPanelER, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        panelERLayout.setVerticalGroup(
            panelERLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(graphPanelER, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelER, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jSeparator2)
                    .addComponent(jSeparator1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(subTitle)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(panelIR, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(subTitle)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelIR, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(9, 9, 9)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3)
                .addComponent(panelER, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(2365, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel graphPanelER;
    private static javax.swing.JPanel graphPanelIR;
    private javax.swing.JLabel hunnit;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel max;
    private javax.swing.JLabel min;
    private javax.swing.JPanel panelER;
    private javax.swing.JPanel panelIR;
    private javax.swing.JSlider sliderIR;
    private javax.swing.JSlider sliderIRDec;
    private javax.swing.JLabel subTitle;
    private javax.swing.JLabel valueIR;
    private javax.swing.JLabel valueIR1;
    private javax.swing.JLabel zero1;
    // End of variables declaration//GEN-END:variables
}