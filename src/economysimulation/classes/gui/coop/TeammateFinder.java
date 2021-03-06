package economysimulation.classes.gui.coop;

import economysimulation.classes.global.Methods;
import economysimulation.classes.global.User;
import economysimulation.classes.managers.extcon.lobby.LobbyConnector;
import economysimulation.classes.managers.extcon.lobby.UserHold;
import economysimulation.classes.managers.theme.GraphicUpdater;
import economysimulation.classes.managers.theme.ThemeUpdateEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JPanel;

/**
 * @author Max Carter
 */
public class TeammateFinder extends javax.swing.JPanel implements ThemeUpdateEvent {

    /** Instance of the teammate controller. */
    private ControlPanel teammateController = null;
    
    //Variables that define how the control panel moves.
    public final int HEIGHT = 600, SPEED = 1;
    public int START = 0, plus = 0;
    
    /** Whether or not the user is ready (locally). */
    private volatile boolean ready = false;
    
    /** The animation thread for moving the control panel. */
    private Thread animationThread;
    
    /** List of user's names in the lobby. */
    private List<String> userDummys;
    
    /** List of UserHold's in the lobby. */
    private List<UserHold> holds;
    
    /** Creates new form TeammateFinder */
    public TeammateFinder() {
        initComponents();
        START = 870;
        
        //initialize the teammate finder lobby mechanics.
        userDummys = new ArrayList<>();
        holds = new ArrayList<>();
        teammateController = new ControlPanel(this);
        Methods.LobbyHandler = new LobbyConnector(teammateController, this);
        
        Methods.LobbyHandler.addCoopUser(Methods.getUser().getID());
        
        //adds the control panel to the top.
        add(teammateController);
        teammateController.setSize(1800, 600);
        teammateController.setLocation(0, START);
        
        //starts pulling data from the database.
        Methods.LobbyHandler.startLoop();
    }
    
    /** Displays all users that are not in a party */
    public void onLobbyUpdateEvent() {
        //gets all the users in the lobby who aren't in a party.
        List<User> freshLonelyUsers = Methods.LobbyHandler.getUsersNotInParty(), toAddList = new ArrayList<>();
        for (User user : freshLonelyUsers) {
            //adds a user to the local user pool if they're not already in it.
            if (user.getID() != Methods.getUser().getID() && !userDummys.contains(user.getFullName())) toAddList.add(user);
        }
        addUsersToLobby(toAddList);
    }
    
    /**
     * Adds a list of users to the lobby display.
     * @param users List of users.
     */
    private void addUsersToLobby(List<User> users) {
        //loops through the new user's and adds them to the lobby pool.
        for (User user : users) {
            userDummys.add(user.getFullName());
            UserHold hold = new UserHold(user);
            add(hold);
            holds.add(hold);
            //defines the random location of the user in the pool.
            hold.setLocation(Methods.randomInt(
                0, getWidth()-hold.getWidth()),
                Methods.randomInt(0, getHeight()-hold.getHeight()-200)
            );
        }
    }
    /**
     * Removes a local UserHold from the lobby pool.
     * @param userHold UserHold to remove.
     */
    public void destroyUserHold(UserHold userHold) {
        userDummys.remove(userHold.getUser().getFullName());
    }
    
    /** Expands the control panel onto the lobby display. */
    public void openControlPanel() {
        teammateController.arrowState(false);
        moveControlPanel(true);
    }
    
    /** Collapses the control panel. */
    public void closeControlPanel() {
        teammateController.arrowState(true);
        moveControlPanel(false);
    }
    
    /**
     * Moves the control panel up or down depending on the {@code up} argument.
     * @param up When set to true, the control panel will move upwards.
     */
    private void moveControlPanel(boolean up) {
        //if memory saver is true, move the panel directly.
        if (Methods.MemorySaver) {
            teammateController.setLocation(0, teammateController.getY() + (up ? - 470 : 470));
            return;
        }
        
        //if not on memory saver, animate the panel in the correct direction.
        animationThread = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 470; i++) {
                    teammateController.setLocation(0, teammateController.getY() + (up ? -1 : 1));
                    
                    try {
                        Thread.sleep(SPEED);
                    } catch (InterruptedException ex) {
                        ex.printStackTrace();
                    }
                }
            }
        });
        animationThread.start();
    }
    
    /**
     * Gets the {@code ControlPanel} object used by the class.
     * @return The {@code ControlPanel}.
     */
    public ControlPanel getTeammateController() {
        return teammateController;
    }
    
    /**
     * The status of the user regarding if they are ready to launch the simulation or not.
     * @return Whether the user is ready to start or not.
     */
    public synchronized boolean isReady() {
        return ready;
    }
    
    /**
     * Modifies the state of whether the user is ready or not.
     * @param state The new state of the user.
     */
    public void setGameReadyState(boolean state) {
        if (ready == state) return;
        ready = state;
        Methods.LobbyHandler.setGameReadyState(Methods.getUser().getID(), state);
    }

    @Override
    public void onThemeUpdate(GraphicUpdater updater) {
        updater.applyPanelThemes(new JPanel[]{}, null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setBackground(new java.awt.Color(204, 204, 204));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1800, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 900, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
