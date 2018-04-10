package economysimulation;

import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 *
 * @author Max Carter
 */
public class PGovernment extends javax.swing.JPanel {

    private static final String[] TITLES = new String[]{ "Interest Rates", "Consumer Taxes", "Corporation Taxes", "Regulations", "Subsidies", "Government Spending", "Pensions" };
    private static final double[] VALUES = new double[]{ Methods.INTEREST_RATE, Methods.CONS_TAX, Methods.CORP_TAX, Methods.REGULATIONS, Methods.SUBSIDIES, Methods.GOV_SPENDING, Methods.PENSIONS };
    private static final ArrayList<Double>[] HISTORY = new ArrayList[]{ Methods.INTEREST_RATES, Methods.CONSUMER_TAXES, Methods.CORPORATION_TAXES, Methods.REGULATIONS_LIST, Methods.SUBSIDIES_LIST, Methods.GOV_SPENDING_LIST, Methods.PENSIONS_LIST };
    private static JButton[] graphButtons;
    
    private static int graphCode = 1;
    
    //<editor-fold defaultstate="collapsed" desc="Receives clock pulse."> 
    public static void globalClockPulseGov() {
        Methods.INTEREST_RATES.add(Methods.INTEREST_RATE);
        Methods.CONSUMER_TAXES.add(Methods.CONS_TAX);

        Methods.createGraph("Interest Rates", Methods.INTEREST_RATES, graphPanel);
        
        
    }//</editor-fold> 

    //<editor-fold defaultstate="collapsed" desc="Adjusts rates of a specific component."> 
    private void adjustRates(String title, double value, JLabel output, JLabel minLabel, JLabel maxLabel, int tenth) {
        minLabel.setText(tenth + "%");
        maxLabel.setText((tenth + 1) + "%");
        output.setText(title + value + "%");
    }//</editor-fold> 

    //<editor-fold defaultstate="collapsed" desc="Switch case that uses slider listener ID to change component."> 
    private void sliderEditEvent(int id) {
        switch (id) {
            case 1:
                Methods.INTEREST_RATE = sliderIR.getValue() + ((double) sliderIRDec.getValue() / 10);
                adjustRates("Interest Rates: ", Methods.INTEREST_RATE, valueIR, minIR, maxIR, sliderIR.getValue());
                break;
            case 2:
                Methods.CONS_TAX = sliderCT.getValue() + ((double) sliderCTDec.getValue() / 10);
                adjustRates("Consumer Tax Rates: ", Methods.CONS_TAX, valueCT, minCT, maxCT, sliderCT.getValue());
                break;
            case 3:
                break;
        }
    }//</editor-fold> 
    
    private void addButtonListener(JButton button) {
        
    }
    
    //<editor-fold defaultstate="collapsed" desc="Slider Event">   
    private void addSliderListener(JSlider slider, int id) { 
        slider.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                sliderEditEvent(id);
            }
        });
        
    }//</editor-fold> 
    
    //<editor-fold defaultstate="collapsed" desc="Constructor."> 
    public PGovernment() {
        initComponents();
        
        graphButtons = new JButton[]{ historyIR, historyCT };
        JSlider[] sliders = new JSlider[]{ sliderIR, sliderIRDec, sliderCT, sliderCTDec };
        
        for (int i = 0; i < graphButtons.length; i++) {
            addButtonListener(graphButtons[i]);
        }
        
        int c = 1;
        boolean wait = true;
        for (int i = 0; i < sliders.length; i++) {
            addSliderListener(sliders[i], c);
            if (!wait) {
                c++;
                wait = true;
            } else {
                wait = false;
            }
        }
        
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
        valueIR = new javax.swing.JLabel();
        sliderIR = new javax.swing.JSlider();
        zero1 = new javax.swing.JLabel();
        hunnit = new javax.swing.JLabel();
        sliderIRDec = new javax.swing.JSlider();
        minIR = new javax.swing.JLabel();
        maxIR = new javax.swing.JLabel();
        historyIR = new javax.swing.JButton();
        graphPanel = new javax.swing.JPanel();
        panelIR2 = new javax.swing.JPanel();
        valueCT = new javax.swing.JLabel();
        sliderCT = new javax.swing.JSlider();
        zero4 = new javax.swing.JLabel();
        hunnit3 = new javax.swing.JLabel();
        sliderCTDec = new javax.swing.JSlider();
        minCT = new javax.swing.JLabel();
        maxCT = new javax.swing.JLabel();
        historyCT = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JSeparator();

        setBackground(new java.awt.Color(51, 51, 51));

        subTitle.setFont(new java.awt.Font("Agency FB", 1, 72)); // NOI18N
        subTitle.setForeground(new java.awt.Color(204, 0, 0));
        subTitle.setText("Government");

        panelIR.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Interest Rates", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Agency FB", 1, 36), new java.awt.Color(255, 255, 255))); // NOI18N
        panelIR.setOpaque(false);

        valueIR.setFont(new java.awt.Font("Agency FB", 1, 80)); // NOI18N
        valueIR.setForeground(new java.awt.Color(255, 0, 51));
        valueIR.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        valueIR.setText("99.9%");
        valueIR.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 2, true));

        sliderIR.setForeground(new java.awt.Color(204, 51, 0));
        sliderIR.setMajorTickSpacing(1);
        sliderIR.setMaximum(99);
        sliderIR.setValue(0);
        sliderIR.setOpaque(false);

        zero1.setFont(new java.awt.Font("Agency FB", 1, 30)); // NOI18N
        zero1.setForeground(new java.awt.Color(255, 255, 255));
        zero1.setText("0%");

        hunnit.setFont(new java.awt.Font("Agency FB", 1, 30)); // NOI18N
        hunnit.setForeground(new java.awt.Color(255, 255, 255));
        hunnit.setText("99%");

        sliderIRDec.setForeground(new java.awt.Color(204, 51, 0));
        sliderIRDec.setMajorTickSpacing(1);
        sliderIRDec.setMaximum(10);
        sliderIRDec.setValue(5);
        sliderIRDec.setOpaque(false);

        minIR.setFont(new java.awt.Font("Agency FB", 1, 30)); // NOI18N
        minIR.setForeground(new java.awt.Color(255, 255, 255));
        minIR.setText("0%");

        maxIR.setFont(new java.awt.Font("Agency FB", 1, 30)); // NOI18N
        maxIR.setForeground(new java.awt.Color(255, 255, 255));
        maxIR.setText("100%");

        historyIR.setBackground(new java.awt.Color(255, 255, 255));
        historyIR.setFont(new java.awt.Font("Agency FB", 1, 24)); // NOI18N
        historyIR.setForeground(new java.awt.Color(204, 0, 0));
        historyIR.setText("History (Graph)");

        javax.swing.GroupLayout panelIRLayout = new javax.swing.GroupLayout(panelIR);
        panelIR.setLayout(panelIRLayout);
        panelIRLayout.setHorizontalGroup(
            panelIRLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelIRLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelIRLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(historyIR, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(panelIRLayout.createSequentialGroup()
                        .addComponent(minIR)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(maxIR))
                    .addGroup(panelIRLayout.createSequentialGroup()
                        .addComponent(zero1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(hunnit))
                    .addComponent(valueIR, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(sliderIR, javax.swing.GroupLayout.DEFAULT_SIZE, 214, Short.MAX_VALUE)
                    .addComponent(sliderIRDec, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        panelIRLayout.setVerticalGroup(
            panelIRLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelIRLayout.createSequentialGroup()
                .addComponent(valueIR, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sliderIR, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelIRLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(zero1)
                    .addComponent(hunnit))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sliderIRDec, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelIRLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(minIR)
                    .addComponent(maxIR))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(historyIR)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        graphPanel.setOpaque(false);

        javax.swing.GroupLayout graphPanelLayout = new javax.swing.GroupLayout(graphPanel);
        graphPanel.setLayout(graphPanelLayout);
        graphPanelLayout.setHorizontalGroup(
            graphPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        graphPanelLayout.setVerticalGroup(
            graphPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 348, Short.MAX_VALUE)
        );

        panelIR2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Consumer Taxes", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Agency FB", 1, 36), new java.awt.Color(255, 255, 255))); // NOI18N
        panelIR2.setOpaque(false);

        valueCT.setFont(new java.awt.Font("Agency FB", 1, 80)); // NOI18N
        valueCT.setForeground(new java.awt.Color(255, 0, 51));
        valueCT.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        valueCT.setText("99.9%");
        valueCT.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 2, true));

        sliderCT.setForeground(new java.awt.Color(204, 51, 0));
        sliderCT.setMajorTickSpacing(1);
        sliderCT.setMaximum(99);
        sliderCT.setValue(0);
        sliderCT.setOpaque(false);

        zero4.setFont(new java.awt.Font("Agency FB", 1, 30)); // NOI18N
        zero4.setForeground(new java.awt.Color(255, 255, 255));
        zero4.setText("0%");

        hunnit3.setFont(new java.awt.Font("Agency FB", 1, 30)); // NOI18N
        hunnit3.setForeground(new java.awt.Color(255, 255, 255));
        hunnit3.setText("99%");

        sliderCTDec.setForeground(new java.awt.Color(204, 51, 0));
        sliderCTDec.setMajorTickSpacing(1);
        sliderCTDec.setMaximum(10);
        sliderCTDec.setValue(5);
        sliderCTDec.setOpaque(false);

        minCT.setFont(new java.awt.Font("Agency FB", 1, 30)); // NOI18N
        minCT.setForeground(new java.awt.Color(255, 255, 255));
        minCT.setText("0%");

        maxCT.setFont(new java.awt.Font("Agency FB", 1, 30)); // NOI18N
        maxCT.setForeground(new java.awt.Color(255, 255, 255));
        maxCT.setText("100%");

        historyCT.setBackground(new java.awt.Color(255, 255, 255));
        historyCT.setFont(new java.awt.Font("Agency FB", 1, 24)); // NOI18N
        historyCT.setForeground(new java.awt.Color(204, 0, 0));
        historyCT.setText("History (Graph)");

        javax.swing.GroupLayout panelIR2Layout = new javax.swing.GroupLayout(panelIR2);
        panelIR2.setLayout(panelIR2Layout);
        panelIR2Layout.setHorizontalGroup(
            panelIR2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelIR2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelIR2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(historyCT, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(panelIR2Layout.createSequentialGroup()
                        .addComponent(minCT)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(maxCT))
                    .addGroup(panelIR2Layout.createSequentialGroup()
                        .addComponent(zero4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(hunnit3))
                    .addComponent(valueCT, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(sliderCT, javax.swing.GroupLayout.DEFAULT_SIZE, 214, Short.MAX_VALUE)
                    .addComponent(sliderCTDec, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        panelIR2Layout.setVerticalGroup(
            panelIR2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelIR2Layout.createSequentialGroup()
                .addComponent(valueCT, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sliderCT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelIR2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(zero4)
                    .addComponent(hunnit3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sliderCTDec, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelIR2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(minCT)
                    .addComponent(maxCT))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(historyCT)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jSeparator2.setOrientation(javax.swing.SwingConstants.VERTICAL);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(graphPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jSeparator1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(subTitle)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(panelIR, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(panelIR2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 550, Short.MAX_VALUE)))
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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(panelIR, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelIR2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jSeparator2))
                .addGap(358, 358, 358)
                .addComponent(graphPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(37, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private static javax.swing.JPanel graphPanel;
    private javax.swing.JButton historyCT;
    private javax.swing.JButton historyIR;
    private javax.swing.JLabel hunnit;
    private javax.swing.JLabel hunnit2;
    private javax.swing.JLabel hunnit3;
    private javax.swing.JButton jButton2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel maxCT;
    private javax.swing.JLabel maxIR;
    private javax.swing.JLabel maxIR1;
    private javax.swing.JLabel minCT;
    private javax.swing.JLabel minIR;
    private javax.swing.JLabel minIR1;
    private javax.swing.JPanel panelIR;
    private javax.swing.JPanel panelIR1;
    private javax.swing.JPanel panelIR2;
    private javax.swing.JSlider sliderCT;
    private javax.swing.JSlider sliderCTDec;
    private javax.swing.JSlider sliderIR;
    private javax.swing.JSlider sliderIR1;
    private javax.swing.JSlider sliderIRDec;
    private javax.swing.JSlider sliderIRDec1;
    private javax.swing.JLabel subTitle;
    private javax.swing.JLabel valueCT;
    private javax.swing.JLabel valueIR;
    private javax.swing.JLabel valueIR1;
    private javax.swing.JLabel zero1;
    private javax.swing.JLabel zero3;
    private javax.swing.JLabel zero4;
    // End of variables declaration//GEN-END:variables
}
