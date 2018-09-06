package economysimulation.classes.economy.budget;

/**
 *
 * @author Max Carter
 */
public abstract class BudgetSector {
    
    public int
            spending,
            population;
    public double
            spendingInfluence,
            standardOfLiving,
            wageMultiplier;
    
    /**
     * 
     * @return The cumulative balance spent on the respected sector.
     */
    public abstract int getSpending();
    
    /**
     * Adds the {@code value} to the sector's spending.
     * @param value Amount of money being added.
     */
    public abstract void addSpending(int value);
    
    /**
     * 
     * @return The remaining influence the spent money has on the sectors.
     */
    public abstract double getSpendingInfluence();
    
    /**
     * Adds {@code value} to the {@code Spending Influence} of the respected sector.
     * 
     * @param value The amount the influence is affected by.
     */
    public abstract void addSpendingInfluence(double value);
    
    /**
     * Sets the {@code Spending Influence} of the respected sector to {@code value}.
     * 
     * @param value The amount the influence is affected by.
     */
    public abstract void setSpendingInfluence(double value);
    
    /**
     * 
     * @return The influence the sector has on the populations standard of living.
     */
    public abstract double getStandardLivingInfluence();
    
    /**
     * 
     * @return The influence that the sector has on the population size.
     */
    public abstract int getPopulationInfluence();
    
    /**
     * 
     * @return The influence that the sector has on wages.
     */
    public abstract double getWageInfluence();
    
}
