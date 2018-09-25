package economysimulation.classes.gui.mainpanels.sim.consumer;

import economysimulation.classes.economy.structure.Component;
import static economysimulation.classes.global.Methods.ThemeManager;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.DecimalFormat;
import javax.swing.JPanel;

/**
 *
 * @author Max Carter
 */
public class ConsumerMiddle extends JPanel {

    public int sector = 6;
    public String title;
    public boolean consumer;
    
    public ConsumerMiddle(String title, boolean consumer) {
        super.setSize(450, 450);
        this.title = title;
        this.consumer = consumer;
        
        
    }
    
    public void addHoverEvent(JPanel panel, int id) {
        panel.addMouseListener(new MouseAdapter() {
            @Override 
            public void mouseEntered(MouseEvent e) {
                sector = id;
                repaint();
            }
            
            @Override
            public void mouseExited(MouseEvent e) {
                sector = 6;
                repaint();
            }
        });
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        for (int i = 0; i < 6; i++) {
            g.setColor(sector == i ? ThemeManager.Theme.getPrimaryColor() : ThemeManager.Theme.getPrimaryTextColor());
            g.fillArc(0, 0, 450, 450, (60*i)+62, 52);
        }
        
        g.setColor(ThemeManager.Theme.getPrimaryColor());
        g.fillOval(75, 75, 300, 300);
        
        g.setColor(ThemeManager.Theme.getPrimaryTextColor());
        g.setFont(new Font("Agency FB", Font.PLAIN, 60));
        g.drawString(this.title, 110 - (this.title.length() > 10 ? 18: 0), 220);
        
        g.setFont(new Font("Agency FB", Font.PLAIN, 40));
        g.drawString("Support: " + new DecimalFormat("0").format((consumer ? Component.ConsumerConfidence : Component.CorporationConfidence) * 100) + "%", 130, 270);
        
    }
    
}