package economysimulation.classes.gui.startup;

import economysimulation.classes.gui.frame.MainFrame;
import economysimulation.classes.global.Methods;
import economysimulation.classes.gui.fronter.GameHold;
import economysimulation.classes.managers.themes.Theme;
import economysimulation.classes.managers.ui.Format;
import economysimulation.classes.gui.subpanels.BudgetList;
import economysimulation.classes.gui.subpanels.RateList;
import economysimulation.classes.managers.exception.InvalidSectorException;
import economysimulation.classes.managers.exception.InvalidThemeSetupException;
import economysimulation.classes.pulse.ControlPulse;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Max Carter
 */
public class Tutorial extends javax.swing.JPanel {

    private static JPanel[] backPanels;
    private static JPanel[] colorPanels;

    public Tutorial() throws InvalidThemeSetupException, InvalidSectorException {
        initComponents();

        Methods.BudgetDisplay = new BudgetList();
        Methods.RateDisplay = new RateList();
        
        Methods.addToFrontPanel(govPanel, Methods.RateDisplay, false);
        Methods.addToFrontPanel(budgetPanel, Methods.BudgetDisplay, false);
        
        backPanels = new JPanel[]{ back1, back2, back3, back4 };
        colorPanels = new JPanel[]{ col1, col2, col3, col4 };
        
        for (int i = 0; i < backPanels.length; i++) {
            Format.addButtonFormat(backPanels[i], colorPanels[i]);
        }
        
        Theme.applyPanelThemes(null, new JPanel[]{}, backPanels, colorPanels);
        Theme.applyTextThemes(new JLabel[]{ subTitle, titleLaunch, next, previous, titleQuit }, null);
        Methods.addDraggablePanel(new JPanel[]{ this });
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        subTitle = new javax.swing.JLabel();
        slideshowPanel = new javax.swing.JPanel();
        budgetPanel = new javax.swing.JPanel();
        govPanel = new javax.swing.JPanel();
        back1 = new javax.swing.JPanel();
        col1 = new javax.swing.JPanel();
        titleLaunch = new javax.swing.JLabel();
        back2 = new javax.swing.JPanel();
        col2 = new javax.swing.JPanel();
        previous = new javax.swing.JLabel();
        back3 = new javax.swing.JPanel();
        col3 = new javax.swing.JPanel();
        next = new javax.swing.JLabel();
        back4 = new javax.swing.JPanel();
        col4 = new javax.swing.JPanel();
        titleQuit = new javax.swing.JLabel();

        setBackground(new java.awt.Color(51, 51, 51));
        setOpaque(false);
        setPreferredSize(new java.awt.Dimension(1750, 825));

        subTitle.setFont(new java.awt.Font("Agency FB", 0, 64)); // NOI18N
        subTitle.setForeground(new java.awt.Color(204, 0, 0));
        subTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        subTitle.setText("How To Play");

        slideshowPanel.setOpaque(false);

        javax.swing.GroupLayout slideshowPanelLayout = new javax.swing.GroupLayout(slideshowPanel);
        slideshowPanel.setLayout(slideshowPanelLayout);
        slideshowPanelLayout.setHorizontalGroup(
            slideshowPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        slideshowPanelLayout.setVerticalGroup(
            slideshowPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        budgetPanel.setOpaque(false);

        javax.swing.GroupLayout budgetPanelLayout = new javax.swing.GroupLayout(budgetPanel);
        budgetPanel.setLayout(budgetPanelLayout);
        budgetPanelLayout.setHorizontalGroup(
            budgetPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1022, Short.MAX_VALUE)
        );
        budgetPanelLayout.setVerticalGroup(
            budgetPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 338, Short.MAX_VALUE)
        );

        govPanel.setOpaque(false);

        javax.swing.GroupLayout govPanelLayout = new javax.swing.GroupLayout(govPanel);
        govPanel.setLayout(govPanelLayout);
        govPanelLayout.setHorizontalGroup(
            govPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1073, Short.MAX_VALUE)
        );
        govPanelLayout.setVerticalGroup(
            govPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 322, Short.MAX_VALUE)
        );

        back1.setBackground(new java.awt.Color(255, 255, 255));
        back1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        back1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                back1MouseClicked(evt);
            }
        });

        col1.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout col1Layout = new javax.swing.GroupLayout(col1);
        col1.setLayout(col1Layout);
        col1Layout.setHorizontalGroup(
            col1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
        );
        col1Layout.setVerticalGroup(
            col1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        titleLaunch.setFont(new java.awt.Font("Agency FB", 0, 48)); // NOI18N
        titleLaunch.setForeground(new java.awt.Color(204, 0, 0));
        titleLaunch.setText("Launch Simulation");

        javax.swing.GroupLayout back1Layout = new javax.swing.GroupLayout(back1);
        back1.setLayout(back1Layout);
        back1Layout.setHorizontalGroup(
            back1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(back1Layout.createSequentialGroup()
                .addComponent(col1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(titleLaunch, javax.swing.GroupLayout.PREFERRED_SIZE, 309, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        back1Layout.setVerticalGroup(
            back1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(col1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(titleLaunch, javax.swing.GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE)
        );

        back2.setBackground(new java.awt.Color(255, 255, 255));
        back2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        col2.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout col2Layout = new javax.swing.GroupLayout(col2);
        col2.setLayout(col2Layout);
        col2Layout.setHorizontalGroup(
            col2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 250, Short.MAX_VALUE)
        );
        col2Layout.setVerticalGroup(
            col2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 20, Short.MAX_VALUE)
        );

        previous.setFont(new java.awt.Font("Agency FB", 0, 30)); // NOI18N
        previous.setForeground(new java.awt.Color(204, 0, 0));
        previous.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        previous.setText("Previous");

        javax.swing.GroupLayout back2Layout = new javax.swing.GroupLayout(back2);
        back2.setLayout(back2Layout);
        back2Layout.setHorizontalGroup(
            back2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(back2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(col2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(previous, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        back2Layout.setVerticalGroup(
            back2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, back2Layout.createSequentialGroup()
                .addComponent(previous, javax.swing.GroupLayout.DEFAULT_SIZE, 64, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(col2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        back3.setBackground(new java.awt.Color(255, 255, 255));
        back3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        col3.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout col3Layout = new javax.swing.GroupLayout(col3);
        col3.setLayout(col3Layout);
        col3Layout.setHorizontalGroup(
            col3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 250, Short.MAX_VALUE)
        );
        col3Layout.setVerticalGroup(
            col3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 20, Short.MAX_VALUE)
        );

        next.setFont(new java.awt.Font("Agency FB", 0, 30)); // NOI18N
        next.setForeground(new java.awt.Color(204, 0, 0));
        next.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        next.setText("Next");

        javax.swing.GroupLayout back3Layout = new javax.swing.GroupLayout(back3);
        back3.setLayout(back3Layout);
        back3Layout.setHorizontalGroup(
            back3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(back3Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(col3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(next, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        back3Layout.setVerticalGroup(
            back3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, back3Layout.createSequentialGroup()
                .addComponent(next, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(col3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        back4.setBackground(new java.awt.Color(255, 255, 255));
        back4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        back4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                back4MouseClicked(evt);
            }
        });

        col4.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout col4Layout = new javax.swing.GroupLayout(col4);
        col4.setLayout(col4Layout);
        col4Layout.setHorizontalGroup(
            col4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
        );
        col4Layout.setVerticalGroup(
            col4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        titleQuit.setFont(new java.awt.Font("Agency FB", 0, 48)); // NOI18N
        titleQuit.setForeground(new java.awt.Color(204, 0, 0));
        titleQuit.setText("Quit Simulation");

        javax.swing.GroupLayout back4Layout = new javax.swing.GroupLayout(back4);
        back4.setLayout(back4Layout);
        back4Layout.setHorizontalGroup(
            back4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(back4Layout.createSequentialGroup()
                .addComponent(col4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(titleQuit, javax.swing.GroupLayout.PREFERRED_SIZE, 309, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        back4Layout.setVerticalGroup(
            back4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(col4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(titleQuit, javax.swing.GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(slideshowPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(subTitle, javax.swing.GroupLayout.DEFAULT_SIZE, 702, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addComponent(back2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(back3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(budgetPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(23, 23, 23))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(govPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(back1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(back4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(subTitle)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(slideshowPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addComponent(govPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(budgetPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(back1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(back4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(back2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(back3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void back1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_back1MouseClicked
        try {
            Methods.GameDisplay = new GameHold();
            MainFrame.addToMainFrame(Methods.GameDisplay);
            new ControlPulse();
        } catch (InvalidThemeSetupException ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_back1MouseClicked

    private void back4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_back4MouseClicked
        System.exit(0);
    }//GEN-LAST:event_back4MouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel back1;
    private javax.swing.JPanel back2;
    private javax.swing.JPanel back3;
    private javax.swing.JPanel back4;
    private javax.swing.JPanel budgetPanel;
    private javax.swing.JPanel col1;
    private javax.swing.JPanel col2;
    private javax.swing.JPanel col3;
    private javax.swing.JPanel col4;
    private javax.swing.JPanel govPanel;
    private javax.swing.JLabel next;
    private javax.swing.JLabel previous;
    private javax.swing.JPanel slideshowPanel;
    private javax.swing.JLabel subTitle;
    private javax.swing.JLabel titleLaunch;
    private javax.swing.JLabel titleQuit;
    // End of variables declaration//GEN-END:variables
}
