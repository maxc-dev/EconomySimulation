package economysimulation.classes.managers.events.events;

/**
 *
 * @author Max Carter
 */
public abstract class Event {
    
    /**
     * 
     * @return The title of the event.
     */
    public abstract String getTitle();
    
    /**
     * 
     * @return  The description of the event.
     */
    public abstract String getDescription();
    
    /**
     * 
     * @return The image file name of the event.
     */
    public abstract String getImageFileName();
    
}