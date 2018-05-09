package economysimulation.classes;

import economysimulation.classes.panelsfront.QBudget;
import economysimulation.classes.panelsfront.QGovernment;
import economysimulation.classes.fronter.GameHold;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.StandardChartTheme;
import org.jfree.data.category.DefaultCategoryDataset;

/**
 *
 * @author Max Carter
 */
public class Methods {

    //Classes of panels to add at intro
    public static QBudget budgetClass;
    public static QGovernment govClass;
    
    public static String username; //players username
    public static int ANNUAL_BUDGET = 750; //how much money the player has per year (in billions)
    public static int TICKS; //how many gamer ticks / days have passed so far
    public static final int GRAPH_TICKS = 50; //Amount of days present on graph
    public static final String GRAPH_FONT_NAME = "Agency FB"; //graph font type
    
    public static double PRICE_LEVEL = 1;
    public static double
            INTEREST_RATE, CORP_TAX, CONS_TAX,
            UNEMPLOYMENT, REAL_GDP;
    public static int 
            CONSUMPTION, INVESTMENT, EXPORTS, IMPORTS,
            DISPOSABLE_INCOME, CBORROWING,
            GBORROWING, TAXATION;
    
    //Stores history of rates
    public static ArrayList<Double> INTEREST_RATES = new ArrayList<>();
    public static ArrayList<Double> CONSUMER_TAXES = new ArrayList<>();
    public static ArrayList<Double> CORPORATION_TAXES = new ArrayList<>();
    public static ArrayList<Double> PENSIONS_LIST = new ArrayList<>();
    
    // Budget variables
    public static int[] BUDGET_VARS = new int[8];

    public static void updateRealGDPLabel() {
        recalculateRealGDP();
        GameHold.labelGDP.setText("£" + REAL_GDP + "bn");
    }
    
    public static int getPublicSpendingTotal() {
        int value = 0;
        for (int i = 0; i < BUDGET_VARS.length; i++) {
            value+=BUDGET_VARS[i];
        }
        return value;
    }
    
    //<editor-fold defaultstate="collapsed" desc="Recalculates real GDP."> 
    public static void recalculateRealGDP() {
        REAL_GDP = PRICE_LEVEL * (CONSUMPTION + INVESTMENT + getPublicSpendingTotal() + (EXPORTS - IMPORTS));
    }//</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Recalculates the annual budget."> 
    public static void recalculateAnnualBudget() {
        ANNUAL_BUDGET = TAXATION - getPublicSpendingTotal();
    }//</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Returns the username with an extra 5 integers."> 
    public static String generateRandomUsername(String currentUsername) {
        return currentUsername + "#" + randomInt(0, 9999);
    }//</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Adds panel to another panel."> 
    public static void addToFrontPanel(JPanel backPanel, JPanel panel, boolean scrollable) {
        backPanel.removeAll();
        backPanel.revalidate();
        
        backPanel.setLayout(new BorderLayout());
        
        if (scrollable) {
            JScrollPane scrolling = new JScrollPane(panel,
                JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
                JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
            scrolling.getVerticalScrollBar().setUnitIncrement(16);
            
            backPanel.add(scrolling);
        } else {
            backPanel.add(panel);
        }

        backPanel.repaint();
    }//</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Applies specific theme to graph."> 
    public static void applyChartTheme(JFreeChart chart, boolean cataPlot) {
        StandardChartTheme theme = (StandardChartTheme)org.jfree.chart.StandardChartTheme.createJFreeTheme();
        
        // ---- Editing default graph theme: Fonts ----
        
        theme.setTitlePaint(new Color(204, 0, 0));
        theme.setExtraLargeFont( new Font(Methods.GRAPH_FONT_NAME,Font.BOLD, 32) );
        theme.setLargeFont( new Font(Methods.GRAPH_FONT_NAME,Font.BOLD, 25));
        theme.setRegularFont( new Font(Methods.GRAPH_FONT_NAME,Font.BOLD, 20));
        
        // ---- Editing default graph theme: Colours ----
        
        theme.setAxisLabelPaint(new Color(204, 0, 0));
        theme.setChartBackgroundPaint(Color.WHITE);
        theme.setPlotBackgroundPaint(Color.white);
        theme.setRangeGridlinePaint(new Color(0, 0, 0));
        
        // ---- Editing default graph theme: Formatting ----
        
        if (cataPlot) {
            chart.getCategoryPlot().setOutlineVisible(false);
            chart.getCategoryPlot().getRangeAxis().setAxisLineVisible(false);
        }
        
        theme.apply(chart);
    }//</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Creates a graph with given data."> 
    public static void createGraph(String title, ArrayList<Double> historyList, JPanel panel) {
        DefaultCategoryDataset dataSet = new DefaultCategoryDataset();

        int size = historyList.size();
        
        for (int i = 0; i < size; i++) {
            dataSet.addValue(historyList.get(i), title + " (%)", (i+1) + "");
        }

        JFreeChart chart = ChartFactory.createLineChart(title, "Days", title + " (%)", dataSet);

        Methods.applyChartTheme(chart, true);
        
        addChartToPanel(chart, panel);
        
    }//</editor-fold> 
    
    //<editor-fold defaultstate="collapsed" desc="Adds a chart to a panel."> 
    public static void addChartToPanel(JFreeChart chart, JPanel panel) {
        panel.setLayout(new BorderLayout());
        ChartPanel CP = new ChartPanel(chart);
        panel.add(CP, BorderLayout.CENTER);
        panel.validate();
    }//</editor-fold> 
    
    //<editor-fold defaultstate="collapsed" desc="Generates random number."> 
    public static int randomInt(int min, int max) {
        return new Random().nextInt((max-min)+1)+min;
    }//</editor-fold> 
    
    //<editor-fold defaultstate="collapsed" desc="Formats the button to open different jPanel."> 
    public static void addButtonFormat(JLabel label, JPanel panel) {
        label.addMouseListener(new MouseAdapter() {

            @Override 
            public void mouseEntered(MouseEvent e) {
                label.setForeground(Color.green);
            }
            
            @Override
            public void mouseExited(MouseEvent e) {
                label.setForeground(new Color(255, 55, 0));
            }
            
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    Methods.addToFrontPanel(GameHold.backadd, panel, false);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
            
        });
    }//</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Adds light grey text with a prompt until user selects text box."> 
    public static void addGhostText(JTextField field, String ghostText) {
        field.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                field.setText(field.getText().replace(ghostText, ""));
            }

            @Override
            public void focusLost(FocusEvent e) {
                if ("".equals(field.getText())) field.setText(ghostText);
            }

        });
    }//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Reset game variables."> 
    public static void resetGame() {
        INTEREST_RATE = 0;
        CORP_TAX = 0;
        CONS_TAX = 0;
        ANNUAL_BUDGET = 0;
        
        for (int i = 0; i < BUDGET_VARS.length; i++) {
            BUDGET_VARS[i] = 0;
        }
        
        int size = INTEREST_RATES.size();
        
        for (int i = 0; i < size; i++) {
            INTEREST_RATES.remove(0);
            CONSUMER_TAXES.remove(0);
            CORPORATION_TAXES.remove(0);
        }
        TICKS = 0;
    }//</editor-fold>
}
