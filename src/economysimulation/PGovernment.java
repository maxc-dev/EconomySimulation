package economysimulation;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 *
 * @author Max Carter
 */
public class PGovernment extends javax.swing.JPanel {

    private static final String[] TITLES = new String[]{ "Interest Rates", "Consumer Taxes", "Corporation Taxes", "Pensions" };
    private static final double[] VALUES = new double[]{ Methods.INTEREST_RATE, Methods.CONS_TAX, Methods.CORP_TAX, Methods.PENSIONS};
    private static final ArrayList<Double>[] HISTORY = new ArrayList[]{ Methods.INTEREST_RATES, Methods.CONSUMER_TAXES, Methods.CORPORATION_TAXES, Methods.PENSIONS_LIST, };
    
    private static JButton[] graphButtons;
    private static JLabel[] valueLabels;
    private static JLabel[] mins;
    private static JLabel[] maxs;
    private static JSlider[] sliders;
    private static JSlider[] slidersDec;
    private static int graphCode = 0;
    
    //<editor-fold defaultstate="collapsed" desc="Receives clock pulse."> 
    public static void globalClockPulseGov() {
        Methods.INTEREST_RATES.add(Methods.INTEREST_RATE);
        Methods.CONSUMER_TAXES.add(Methods.CONS_TAX);
        Methods.CORPORATION_TAXES.add(Methods.CORP_TAX);
        Methods.PENSIONS_LIST.add(Methods.PENSIONS);

        Methods.createGraph(TITLES[graphCode], HISTORY[graphCode], graphPanel);
        
    }//</editor-fold> 

    //<editor-fold defaultstate="collapsed" desc="Adjusts rates of a specific component."> 
    private void adjustRates(double value, JLabel output, JLabel minLabel, JLabel maxLabel, int tenth) {
        minLabel.setText(tenth + "%");
        maxLabel.setText((tenth + 1) + "%");
        output.setText(value + "%");
    }//</editor-fold> 

    //<editor-fold defaultstate="collapsed" desc="Returns percent of a slider."> 
    private double getSliderValue(int id) {
        return sliders[id].getValue() + ((double) slidersDec[id].getValue() / 10);
    }//</editor-fold> 
    
    //<editor-fold defaultstate="collapsed" desc="Switch case that uses slider listener ID to change component."> 
    private void sliderEditEvent(int id) {
        double newValue = getSliderValue(id);
        
        switch (id) {
            case 0:
                Methods.INTEREST_RATE = newValue;
                break;
            case 1:
                Methods.CONS_TAX = newValue;
                break;
            case 2:
                Methods.CORP_TAX = newValue;
                break;
            case 3:
                Methods.PENSIONS = newValue;
                break;
            
        }
        adjustRates(newValue, valueLabels[id], mins[id], maxs[id], sliders[id].getValue());
    }//</editor-fold> 
    
    //<editor-fold defaultstate="collapsed" desc="Button listener to change graph type."> 
    private void addButtonListenerGraph(JButton button, int id) {
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                graphButtons[graphCode].setEnabled(true);
                graphCode = id;
                graphButtons[id].setEnabled(false);
            }
        });
    }//</editor-fold> 
    
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
        
        graphButtons = new JButton[]{ historyIR, historyCT, historyCT2, historyP };
        sliders = new JSlider[]{ sliderIR, sliderCT, sliderCT2, sliderP };
        slidersDec = new JSlider[]{ sliderIRDec, sliderCTDec, sliderCT2Dec, sliderPDec };
        valueLabels = new JLabel[]{ valueIR, valueCT, valueCT2, valueP };
        mins = new JLabel[]{ minIR, minCT, minCT2, minP };
        maxs = new JLabel[]{ maxIR, maxCT, maxCT2, maxP };

        
        
        for (int i = 0; i < graphButtons.length; i++) {
            addButtonListenerGraph(graphButtons[i], i);
            addSliderListener(sliders[i], i);
            addSliderListener(slidersDec[i], i);
            valueLabels[i].setText(getSliderValue(i) + "%");
        }

        
    }//</editor-fold>

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
        panelP = new javax.swing.JPanel();
        valueP = new javax.swing.JLabel();
        sliderP = new javax.swing.JSlider();
        zero4 = new javax.swing.JLabel();
        hunnit3 = new javax.swing.JLabel();
        sliderPDec = new javax.swing.JSlider();
        minP = new javax.swing.JLabel();
        maxP = new javax.swing.JLabel();
        historyP = new javax.swing.JButton();
        panelIR3 = new javax.swing.JPanel();
        valueCT = new javax.swing.JLabel();
        sliderCT = new javax.swing.JSlider();
        zero5 = new javax.swing.JLabel();
        hunnit4 = new javax.swing.JLabel();
        sliderCTDec = new javax.swing.JSlider();
        minCT = new javax.swing.JLabel();
        maxCT = new javax.swing.JLabel();
        historyCT = new javax.swing.JButton();
        panelIR4 = new javax.swing.JPanel();
        valueCT2 = new javax.swing.JLabel();
        sliderCT2 = new javax.swing.JSlider();
        zero6 = new javax.swing.JLabel();
        hunnit5 = new javax.swing.JLabel();
        sliderCT2Dec = new javax.swing.JSlider();
        minCT2 = new javax.swing.JLabel();
        maxCT2 = new javax.swing.JLabel();
        historyCT2 = new javax.swing.JButton();

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
            .addGap(0, 400, Short.MAX_VALUE)
        );

        panelP.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Pensions", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Agency FB", 1, 36), new java.awt.Color(255, 255, 255))); // NOI18N
        panelP.setOpaque(false);

        valueP.setFont(new java.awt.Font("Agency FB", 1, 80)); // NOI18N
        valueP.setForeground(new java.awt.Color(255, 0, 51));
        valueP.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        valueP.setText("99.9%");
        valueP.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 2, true));

        sliderP.setForeground(new java.awt.Color(204, 51, 0));
        sliderP.setMajorTickSpacing(1);
        sliderP.setMaximum(99);
        sliderP.setValue(0);
        sliderP.setOpaque(false);

        zero4.setFont(new java.awt.Font("Agency FB", 1, 30)); // NOI18N
        zero4.setForeground(new java.awt.Color(255, 255, 255));
        zero4.setText("0%");

        hunnit3.setFont(new java.awt.Font("Agency FB", 1, 30)); // NOI18N
        hunnit3.setForeground(new java.awt.Color(255, 255, 255));
        hunnit3.setText("99%");

        sliderPDec.setForeground(new java.awt.Color(204, 51, 0));
        sliderPDec.setMajorTickSpacing(1);
        sliderPDec.setMaximum(10);
        sliderPDec.setValue(5);
        sliderPDec.setOpaque(false);

        minP.setFont(new java.awt.Font("Agency FB", 1, 30)); // NOI18N
        minP.setForeground(new java.awt.Color(255, 255, 255));
        minP.setText("0%");

        maxP.setFont(new java.awt.Font("Agency FB", 1, 30)); // NOI18N
        maxP.setForeground(new java.awt.Color(255, 255, 255));
        maxP.setText("100%");

        historyP.setBackground(new java.awt.Color(255, 255, 255));
        historyP.setFont(new java.awt.Font("Agency FB", 1, 24)); // NOI18N
        historyP.setForeground(new java.awt.Color(204, 0, 0));
        historyP.setText("History (Graph)");

        javax.swing.GroupLayout panelPLayout = new javax.swing.GroupLayout(panelP);
        panelP.setLayout(panelPLayout);
        panelPLayout.setHorizontalGroup(
            panelPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(historyP, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(panelPLayout.createSequentialGroup()
                        .addComponent(minP)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(maxP))
                    .addGroup(panelPLayout.createSequentialGroup()
                        .addComponent(zero4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(hunnit3))
                    .addComponent(valueP, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(sliderP, javax.swing.GroupLayout.DEFAULT_SIZE, 214, Short.MAX_VALUE)
                    .addComponent(sliderPDec, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        panelPLayout.setVerticalGroup(
            panelPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPLayout.createSequentialGroup()
                .addComponent(valueP, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sliderP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(zero4)
                    .addComponent(hunnit3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sliderPDec, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(minP)
                    .addComponent(maxP))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(historyP)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        panelIR3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Consumer Taxes", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Agency FB", 1, 36), new java.awt.Color(255, 255, 255))); // NOI18N
        panelIR3.setOpaque(false);

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

        zero5.setFont(new java.awt.Font("Agency FB", 1, 30)); // NOI18N
        zero5.setForeground(new java.awt.Color(255, 255, 255));
        zero5.setText("0%");

        hunnit4.setFont(new java.awt.Font("Agency FB", 1, 30)); // NOI18N
        hunnit4.setForeground(new java.awt.Color(255, 255, 255));
        hunnit4.setText("99%");

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

        javax.swing.GroupLayout panelIR3Layout = new javax.swing.GroupLayout(panelIR3);
        panelIR3.setLayout(panelIR3Layout);
        panelIR3Layout.setHorizontalGroup(
            panelIR3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelIR3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelIR3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(historyCT, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(panelIR3Layout.createSequentialGroup()
                        .addComponent(minCT)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(maxCT))
                    .addGroup(panelIR3Layout.createSequentialGroup()
                        .addComponent(zero5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(hunnit4))
                    .addComponent(valueCT, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(sliderCT, javax.swing.GroupLayout.DEFAULT_SIZE, 214, Short.MAX_VALUE)
                    .addComponent(sliderCTDec, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        panelIR3Layout.setVerticalGroup(
            panelIR3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelIR3Layout.createSequentialGroup()
                .addComponent(valueCT, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sliderCT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelIR3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(zero5)
                    .addComponent(hunnit4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sliderCTDec, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelIR3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(minCT)
                    .addComponent(maxCT))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(historyCT)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        panelIR4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Corporation Taxes", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Agency FB", 1, 36), new java.awt.Color(255, 255, 255))); // NOI18N
        panelIR4.setOpaque(false);

        valueCT2.setFont(new java.awt.Font("Agency FB", 1, 80)); // NOI18N
        valueCT2.setForeground(new java.awt.Color(255, 0, 51));
        valueCT2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        valueCT2.setText("99.9%");
        valueCT2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 2, true));

        sliderCT2.setForeground(new java.awt.Color(204, 51, 0));
        sliderCT2.setMajorTickSpacing(1);
        sliderCT2.setMaximum(99);
        sliderCT2.setValue(0);
        sliderCT2.setOpaque(false);

        zero6.setFont(new java.awt.Font("Agency FB", 1, 30)); // NOI18N
        zero6.setForeground(new java.awt.Color(255, 255, 255));
        zero6.setText("0%");

        hunnit5.setFont(new java.awt.Font("Agency FB", 1, 30)); // NOI18N
        hunnit5.setForeground(new java.awt.Color(255, 255, 255));
        hunnit5.setText("99%");

        sliderCT2Dec.setForeground(new java.awt.Color(204, 51, 0));
        sliderCT2Dec.setMajorTickSpacing(1);
        sliderCT2Dec.setMaximum(10);
        sliderCT2Dec.setValue(5);
        sliderCT2Dec.setOpaque(false);

        minCT2.setFont(new java.awt.Font("Agency FB", 1, 30)); // NOI18N
        minCT2.setForeground(new java.awt.Color(255, 255, 255));
        minCT2.setText("0%");

        maxCT2.setFont(new java.awt.Font("Agency FB", 1, 30)); // NOI18N
        maxCT2.setForeground(new java.awt.Color(255, 255, 255));
        maxCT2.setText("100%");

        historyCT2.setBackground(new java.awt.Color(255, 255, 255));
        historyCT2.setFont(new java.awt.Font("Agency FB", 1, 24)); // NOI18N
        historyCT2.setForeground(new java.awt.Color(204, 0, 0));
        historyCT2.setText("History (Graph)");

        javax.swing.GroupLayout panelIR4Layout = new javax.swing.GroupLayout(panelIR4);
        panelIR4.setLayout(panelIR4Layout);
        panelIR4Layout.setHorizontalGroup(
            panelIR4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelIR4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelIR4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(historyCT2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(panelIR4Layout.createSequentialGroup()
                        .addComponent(minCT2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(maxCT2))
                    .addGroup(panelIR4Layout.createSequentialGroup()
                        .addComponent(zero6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(hunnit5))
                    .addComponent(valueCT2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(sliderCT2, javax.swing.GroupLayout.DEFAULT_SIZE, 214, Short.MAX_VALUE)
                    .addComponent(sliderCT2Dec, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        panelIR4Layout.setVerticalGroup(
            panelIR4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelIR4Layout.createSequentialGroup()
                .addComponent(valueCT2, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sliderCT2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelIR4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(zero6)
                    .addComponent(hunnit5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sliderCT2Dec, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelIR4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(minCT2)
                    .addComponent(maxCT2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(historyCT2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(graphPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jSeparator1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(panelIR, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(22, 22, 22)
                        .addComponent(panelIR3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(panelIR4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(22, 22, 22)
                        .addComponent(panelP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(subTitle)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(subTitle)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(panelIR, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(panelIR3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(panelIR4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(panelP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(graphPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private static javax.swing.JPanel graphPanel;
    private javax.swing.JButton historyCT;
    private javax.swing.JButton historyCT2;
    private javax.swing.JButton historyIR;
    private javax.swing.JButton historyP;
    private javax.swing.JLabel hunnit;
    private javax.swing.JLabel hunnit3;
    private javax.swing.JLabel hunnit4;
    private javax.swing.JLabel hunnit5;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel maxCT;
    private javax.swing.JLabel maxCT2;
    private javax.swing.JLabel maxIR;
    private javax.swing.JLabel maxP;
    private javax.swing.JLabel minCT;
    private javax.swing.JLabel minCT2;
    private javax.swing.JLabel minIR;
    private javax.swing.JLabel minP;
    private javax.swing.JPanel panelIR;
    private javax.swing.JPanel panelIR3;
    private javax.swing.JPanel panelIR4;
    private javax.swing.JPanel panelP;
    private javax.swing.JSlider sliderCT;
    private javax.swing.JSlider sliderCT2;
    private javax.swing.JSlider sliderCT2Dec;
    private javax.swing.JSlider sliderCTDec;
    private javax.swing.JSlider sliderIR;
    private javax.swing.JSlider sliderIRDec;
    private javax.swing.JSlider sliderP;
    private javax.swing.JSlider sliderPDec;
    private javax.swing.JLabel subTitle;
    private javax.swing.JLabel valueCT;
    private javax.swing.JLabel valueCT2;
    private javax.swing.JLabel valueIR;
    private javax.swing.JLabel valueP;
    private javax.swing.JLabel zero1;
    private javax.swing.JLabel zero4;
    private javax.swing.JLabel zero5;
    private javax.swing.JLabel zero6;
    // End of variables declaration//GEN-END:variables
}
