package economysimulation.classes.gui.subpanels;

import economysimulation.classes.managers.popup.hint.HintManager;
import economysimulation.classes.managers.popup.hint.Hints;
import economysimulation.classes.managers.theme.GraphicUpdater;
import economysimulation.classes.managers.theme.ThemeUpdateEvent;
import economysimulation.classes.managers.ui.Format;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import economysimulation.classes.economy.structure.Component;
import economysimulation.classes.global.Methods;
import economysimulation.classes.managers.extcon.multiplayer.StorageComponent;
import economysimulation.classes.managers.extcon.multiplayer.VariableUpdater;
import economysimulation.classes.mode.Mode;

/**
 * @author Max Carter
 */
public class RateList extends javax.swing.JPanel implements ThemeUpdateEvent {

    /** The multiplayer component updater. */
    private VariableUpdater variableUpdater = null;
    
    /** Selected rate. */
    public int selectedType = 0;
    
    //variables for the buttons.
    private JPanel[]
            backPanels,
            colorPanels;
    private JLabel[] arrowLabels;
    private final String[] titles = new String[]{ "Interest Rates", "Corporation Tax", "Income Tax" };
    
    /**
     * Displays information about a certain rate.
     * @param id Index of the rate.
     */
    private void applySelectedType(int id) {
        selectedType = id;
        title.setText(titles[id]);
        slider.setValue(id);
        saveChanges.setText("Save Changes");
        
        double newValue = 0;
        switch (id) {
            case 0:
                newValue = Component.InterestRate;
                break;
            case 1:
                newValue = Component.CorporationTax;
                break;
            case 2:
                newValue = Component.IncomeTax;
                break;
        }
        
        slider.setValue((int) newValue * 10);
        updatePercent();
    }
    
    /**
     * Formats the button to update the information displayed when clicked.
     * @param id 
     */
    public void addButtonFormat(int id) {
        backPanels[id].addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                applySelectedType(id);
                
                //update the red arrow on the side of the selected button.
                for (int i = 0; i < colorPanels.length; i++) {
                    arrowLabels[i].setIcon(i == id ? new javax.swing.ImageIcon(getClass().getResource("/economysimulation/resources/misc/arrow40.png")) : null);
                }
            }
        });
    }
    
    /**
     * When a user saves the changes made via the slider.
     * @param backPanel The button to add the click listener to.
     */
    public void addSaveChangesFormat(JPanel backPanel) {
        backPanel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int newValue = slider.getValue() / 10;
                
                StorageComponent component = null;
        
                //identify the component changed.
                switch (selectedType) {
                    case 0:
                        Component.InterestRate = newValue;
                        component = StorageComponent.INTEREST_RATE;
                        break;
                    case 1:
                        Component.CorporationTax = newValue;
                        component = StorageComponent.CORPORATION_TAX;
                        break;
                    case 2:
                        Component.IncomeTax = newValue;
                        component = StorageComponent.INCOME_TAX;
                        break;
                    
                }
                
                //if it is multiplayer, update the components on the database.
                if (Methods.ModeHandler.isMode(Mode.MULTI_PLAYER) && variableUpdater != null && component != null)
                    variableUpdater.onLocalComponentUpdateEvent(component, newValue);

                saveChanges.setText("Changes Saved");
                
                //display error if the new rate is higher than 90%.
                if (newValue > 90) HintManager.createHint(selectedType == 0 ? Hints.InterestRatesTooHigh : Hints.TaxesTooHigh);
            }
            
        });
    }
    
    /**
     * Adds a listener for the slider to update the percentagge when the slider is moved.
     * @param slider Slider to add the listener to.
     */
    private void addSliderListener(JSlider slider) { 
        slider.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                saveChanges.setText("Save Changes");
                updatePercent();
            }
        });
        
    }
    
    //** Updates the percentage of the component. */
    private static void updatePercent() {
        percent.setText((double) slider.getValue() / 10 + "%");
    }
    
    @Override
    public void onThemeUpdate(GraphicUpdater updater) {
        updater.applyPanelThemes(new JPanel[]{ displayPanel, color1, color2, color3, panelPic, panel1, panel2, panel3, saveChangesPanel }, null);
        updater.applyTextThemes(new JLabel[]{ min, max, title1, title2, title3, title, percent, saveChanges }, null);
    }

    /**
     * Creates a new RateList.
     * @param variableUpdater The instance of the multiplayer component updater.
     */
    public RateList(VariableUpdater variableUpdater) {
        initComponents();
        
        //sets the variable updater if is not set to null.
        if (variableUpdater != null) this.variableUpdater = variableUpdater;
        
        //formats the buttons and labels.
        backPanels = new JPanel[]{ panel1, panel2, panel3 };
        colorPanels = new JPanel[]{ color1, color2, color3 };
        arrowLabels = new JLabel[]{ arrow1, arrow2, arrow3 };
        
        addSaveChangesFormat(saveChangesPanel);
        addSliderListener(slider);
        
        
        for (int i = 0; i < backPanels.length; i++) {
            addButtonFormat(i);
            Format.addButtonFormat(backPanels[i], colorPanels[i]);
        }
        Format.addButtonFormat(saveChangesPanel, panelPic);
        
        //sets the theme.
        Methods.ThemeHandler.addThemeUpdateListener(this);
        
        //sets the default selected rate to index:0.
        applySelectedType(0);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel1 = new javax.swing.JPanel();
        title1 = new javax.swing.JLabel();
        color1 = new javax.swing.JPanel();
        arrow1 = new javax.swing.JLabel();
        panel2 = new javax.swing.JPanel();
        title2 = new javax.swing.JLabel();
        color2 = new javax.swing.JPanel();
        arrow2 = new javax.swing.JLabel();
        panel3 = new javax.swing.JPanel();
        title3 = new javax.swing.JLabel();
        color3 = new javax.swing.JPanel();
        arrow3 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        displayPanel = new javax.swing.JPanel();
        title = new javax.swing.JLabel();
        percent = new javax.swing.JLabel();
        slider = new javax.swing.JSlider();
        saveChangesPanel = new javax.swing.JPanel();
        panelPic = new javax.swing.JPanel();
        tickHold = new javax.swing.JLabel();
        saveChanges = new javax.swing.JLabel();
        min = new javax.swing.JLabel();
        max = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setOpaque(false);

        panel1.setBackground(new java.awt.Color(255, 255, 255));
        panel1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        title1.setFont(new java.awt.Font("Agency FB", 0, 48)); // NOI18N
        title1.setForeground(new java.awt.Color(204, 0, 0));
        title1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        title1.setText("Interest Rates");
        title1.setPreferredSize(new java.awt.Dimension(333, 100));

        color1.setBackground(new java.awt.Color(255, 255, 255));

        arrow1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/economysimulation/resources/misc/arrow40.png"))); // NOI18N

        javax.swing.GroupLayout color1Layout = new javax.swing.GroupLayout(color1);
        color1.setLayout(color1Layout);
        color1Layout.setHorizontalGroup(
            color1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, color1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(arrow1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        color1Layout.setVerticalGroup(
            color1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(arrow1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout panel1Layout = new javax.swing.GroupLayout(panel1);
        panel1.setLayout(panel1Layout);
        panel1Layout.setHorizontalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel1Layout.createSequentialGroup()
                .addComponent(title1, javax.swing.GroupLayout.DEFAULT_SIZE, 291, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(color1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        panel1Layout.setVerticalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(color1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(title1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        panel2.setBackground(new java.awt.Color(255, 255, 255));
        panel2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        panel2.setPreferredSize(new java.awt.Dimension(337, 100));

        title2.setFont(new java.awt.Font("Agency FB", 0, 48)); // NOI18N
        title2.setForeground(new java.awt.Color(204, 0, 0));
        title2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        title2.setText("Corporation Tax");

        color2.setBackground(new java.awt.Color(255, 255, 255));

        arrow2.setPreferredSize(new java.awt.Dimension(40, 100));

        javax.swing.GroupLayout color2Layout = new javax.swing.GroupLayout(color2);
        color2.setLayout(color2Layout);
        color2Layout.setHorizontalGroup(
            color2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(arrow2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        color2Layout.setVerticalGroup(
            color2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(arrow2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout panel2Layout = new javax.swing.GroupLayout(panel2);
        panel2.setLayout(panel2Layout);
        panel2Layout.setHorizontalGroup(
            panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel2Layout.createSequentialGroup()
                .addComponent(title2, javax.swing.GroupLayout.DEFAULT_SIZE, 291, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(color2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        panel2Layout.setVerticalGroup(
            panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(color2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(title2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        panel3.setBackground(new java.awt.Color(255, 255, 255));
        panel3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        panel3.setPreferredSize(new java.awt.Dimension(337, 100));

        title3.setFont(new java.awt.Font("Agency FB", 0, 48)); // NOI18N
        title3.setForeground(new java.awt.Color(204, 0, 0));
        title3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        title3.setText("Income Tax");

        color3.setBackground(new java.awt.Color(255, 255, 255));

        arrow3.setPreferredSize(new java.awt.Dimension(40, 100));

        javax.swing.GroupLayout color3Layout = new javax.swing.GroupLayout(color3);
        color3.setLayout(color3Layout);
        color3Layout.setHorizontalGroup(
            color3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(arrow3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        color3Layout.setVerticalGroup(
            color3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(arrow3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout panel3Layout = new javax.swing.GroupLayout(panel3);
        panel3.setLayout(panel3Layout);
        panel3Layout.setHorizontalGroup(
            panel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel3Layout.createSequentialGroup()
                .addComponent(title3, javax.swing.GroupLayout.DEFAULT_SIZE, 291, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(color3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        panel3Layout.setVerticalGroup(
            panel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(color3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(title3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel1.setBackground(new java.awt.Color(204, 0, 0));

        displayPanel.setBackground(new java.awt.Color(255, 255, 255));

        title.setFont(new java.awt.Font("Agency FB", 0, 48)); // NOI18N
        title.setForeground(new java.awt.Color(204, 0, 0));
        title.setText("Interest Rates");
        title.setPreferredSize(null);

        percent.setFont(new java.awt.Font("Agency FB", 0, 48)); // NOI18N
        percent.setForeground(new java.awt.Color(204, 0, 0));
        percent.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        percent.setText("99.9%");

        slider.setMaximum(1000);
        slider.setFocusable(false);
        slider.setOpaque(false);

        saveChangesPanel.setBackground(new java.awt.Color(255, 255, 255));
        saveChangesPanel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        panelPic.setBackground(new java.awt.Color(255, 255, 255));

        tickHold.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        tickHold.setIcon(new javax.swing.ImageIcon(getClass().getResource("/economysimulation/resources/misc/wtick50.png"))); // NOI18N

        javax.swing.GroupLayout panelPicLayout = new javax.swing.GroupLayout(panelPic);
        panelPic.setLayout(panelPicLayout);
        panelPicLayout.setHorizontalGroup(
            panelPicLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPicLayout.createSequentialGroup()
                .addComponent(tickHold, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        panelPicLayout.setVerticalGroup(
            panelPicLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelPicLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(tickHold, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        saveChanges.setFont(new java.awt.Font("Agency FB", 0, 48)); // NOI18N
        saveChanges.setForeground(new java.awt.Color(204, 0, 0));
        saveChanges.setText("Save Changes");

        javax.swing.GroupLayout saveChangesPanelLayout = new javax.swing.GroupLayout(saveChangesPanel);
        saveChangesPanel.setLayout(saveChangesPanelLayout);
        saveChangesPanelLayout.setHorizontalGroup(
            saveChangesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(saveChangesPanelLayout.createSequentialGroup()
                .addComponent(panelPic, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(saveChanges, javax.swing.GroupLayout.DEFAULT_SIZE, 265, Short.MAX_VALUE))
        );
        saveChangesPanelLayout.setVerticalGroup(
            saveChangesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(saveChangesPanelLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(saveChangesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(panelPic, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(saveChanges, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        min.setFont(new java.awt.Font("Agency FB", 0, 24)); // NOI18N
        min.setForeground(new java.awt.Color(204, 0, 0));
        min.setText("0%");

        max.setFont(new java.awt.Font("Agency FB", 0, 24)); // NOI18N
        max.setForeground(new java.awt.Color(204, 0, 0));
        max.setText("100%");

        javax.swing.GroupLayout displayPanelLayout = new javax.swing.GroupLayout(displayPanel);
        displayPanel.setLayout(displayPanelLayout);
        displayPanelLayout.setHorizontalGroup(
            displayPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(displayPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(displayPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, displayPanelLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(saveChangesPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(displayPanelLayout.createSequentialGroup()
                        .addGroup(displayPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(displayPanelLayout.createSequentialGroup()
                                .addComponent(title, javax.swing.GroupLayout.PREFERRED_SIZE, 411, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                                .addComponent(percent, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(displayPanelLayout.createSequentialGroup()
                                .addComponent(min)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(slider, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(max)))
                        .addContainerGap())))
        );
        displayPanelLayout.setVerticalGroup(
            displayPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, displayPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(displayPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(title, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(percent))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(displayPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(slider, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(min, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(max, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(35, 35, 35)
                .addComponent(saveChangesPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(displayPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(displayPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(panel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(panel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(panel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(panel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(panel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel arrow1;
    private javax.swing.JLabel arrow2;
    private javax.swing.JLabel arrow3;
    public static javax.swing.JPanel color1;
    public static javax.swing.JPanel color2;
    public static javax.swing.JPanel color3;
    public static javax.swing.JPanel displayPanel;
    public static javax.swing.JPanel jPanel1;
    public static javax.swing.JLabel max;
    public static javax.swing.JLabel min;
    public static javax.swing.JPanel panel1;
    public static javax.swing.JPanel panel2;
    public static javax.swing.JPanel panel3;
    public static javax.swing.JPanel panelPic;
    public static javax.swing.JLabel percent;
    public static javax.swing.JLabel saveChanges;
    public static javax.swing.JPanel saveChangesPanel;
    public static javax.swing.JSlider slider;
    public static javax.swing.JLabel tickHold;
    public static javax.swing.JLabel title;
    public static javax.swing.JLabel title1;
    public static javax.swing.JLabel title2;
    public static javax.swing.JLabel title3;
    // End of variables declaration//GEN-END:variables
}
