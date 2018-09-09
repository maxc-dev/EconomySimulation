package economysimulation.classes.managers.comp;

import economysimulation.classes.global.Methods;
import economysimulation.classes.gui.fronter.GameHold;
import economysimulation.classes.managers.themes.Theme;
import java.awt.Font;
import java.awt.Graphics;
import java.text.DecimalFormat;
import javax.swing.JPanel;

/**
 *
 * @author Max Carter
 */
public class CircleProgressBar extends JPanel {
    
    public static final long serialVersionUID = 1;
    public static final int plus = 290;
    
    @Override
    protected void paintComponent(Graphics g) {
        for (int i = 0; i < GameHold.Percents.length; i++) {
            
            // Draws the respected progess bar title.
            g.setColor(Theme.secondaryText);
            g.setFont(new Font("Agency FB", Font.PLAIN, 40));
            g.drawString(Methods.GameDisplay.TITLES[i], 1, 32 + (i * plus));
            
            // Draws background of progress bar.
            g.setColor(Theme.secondaryBack);
            g.fillOval(1, 41 + (i * plus), 238, 238);

            // Draws progress bar.
            g.setColor(Theme.primaryText);
            g.fillArc(0, 40 + (i * plus), 240, 240, 90, -(int) (360 * GameHold.Percents[i]));

            // Fills in middle of circle.
            g.setColor(Theme.secondaryBack);
            g.fillOval(20, 60 + (i * plus), 200, 200);

            //Configures color and font for percentage display.
            g.setColor(Theme.primaryText);
            g.setFont(new Font("Agency FB", Font.PLAIN, 82));
            String text = new DecimalFormat("0").format(GameHold.Percents[i]*100) + "%";

            // Adjusts x coordinate of text based on text length.
            int x = 0;
            switch (text.length()) {
                case 2:
                    x = 70;
                    break;
                case 3:
                    x = 65;
                    break;
                case 4:
                    x = 55;
                    break;
            }

            // Draws text percentage in middle of circle.
            g.drawString(text, x, 185 + (i * plus));

        }
 
    }
    
}
