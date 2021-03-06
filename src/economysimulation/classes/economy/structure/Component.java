package economysimulation.classes.economy.structure;

/**
 * @author Max Carter
 */
public class Component {
    
    //List of all the variables used in the simulation.
    public static double
        InterestRate = 0, CorporationTax = 0, IncomeTax = 0,
        Unemployment, GrossDomesticProduct, PropensityToConsume = 1,
        CorporationConfidence = 1, ConsumerConfidence = 1,
        Population = 1000000,
        TotalSavings = 1, PoliticalInflluence = 1,
        Consumption, Investment,
        Taxation, SpendingBudget = 250,
        TotalCorporationProfits = 1, TotalConsumption,
        TotalCorporationTax, TotalIncomeTax,
        CostOfProduction, Wages,
        DailyCorporationTax, DailyIncomeTax, StandardOfLiving = 1, WageMultiplier = 1;

}
