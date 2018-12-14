package economysimulation.classes.managers.popup.frame;

import economysimulation.classes.gui.frame.MainFrame;
import economysimulation.classes.managers.theme.GraphicUpdater;
import economysimulation.classes.managers.theme.ThemeUpdateEvent;
import java.awt.Frame;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import static economysimulation.classes.global.Methods.ThemeHandler;

/**
 *
 * @author Max Carter
 */
public class PopUpFrame extends JFrame implements ThemeUpdateEvent {

    private static JPanel panel, back;
    private String title;
    
    public PopUpFrame(JPanel panel, String title) {
        if (panel == null || title == null) {
            throw new NullPointerException();
        }
        
        setIconImage(new ImageIcon(getClass().getResource("/economysimulation/resources/icon/icon128.png")).getImage());
        
        this.panel = panel;
        this.title = title;
        
        back = new JPanel();
        this.add(back);
        ThemeHandler.addThemeUpdateListener(this);
    }

    public void createPopUpFrame() {
        back.add(panel);
        this.setResizable(false);
        this.setVisible(true);
        this.setSize(panel.getWidth(), panel.getHeight());
        this.setTitle("Economy Simulation: " + title);
        this.pack();
    }
    
    public boolean isOpen(String title) {
        for (Frame frame : MainFrame.getFrames()) {
            if (frame.getTitle().equals("Economy Simulation: " + title)) return true;
        } 
        return false;
    }

    @Override
    public void onThemeUpdate(GraphicUpdater updater) {
        updater.applyPanelThemes(new JPanel[]{ back }, null);
    }
    
}