package economysimulation.classes.managers.sorting;

import economysimulation.classes.gui.mainpanels.extra.leaderboard.DisplayType;
import economysimulation.classes.managers.extcon.GamePackage;
import economysimulation.classes.managers.sorting.conditions.SearchComponent;
import economysimulation.classes.managers.sorting.conditions.SearchCondition;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Max Carter
 */
public class GameSorter {
    
    /** List of games that are ready to be sorted. */
    private List<GamePackage> gamePackageList = null;
    
    /** The condition that will manipulate the output of the sort. */
    private SearchCondition searchCondition = null;
    
    /** The condition that will manipulate the output of the sort. */
    private SearchComponent searchComponent = null;
    
    
    /** The display type, multiplayer, singleplayer etc. */
    private DisplayType displayType = null;
    
    /**
     * Creates a new game sorter that will sort
     * a list of games for the leaderboards.
     * 
     * @param gamePackageList List of games.
     */
    public GameSorter(List<GamePackage> gamePackageList) {
        setList(gamePackageList);
    }
    
    /** Sort the game list in the instance. */
    public void sort() {
        if (gamePackageList == null) return;
        
        if (displayType != DisplayType.COMBINED) {
            List<GamePackage> removeList = new ArrayList<>();

            //single-player: remove all games were player size is greater than 1.
            if (displayType == DisplayType.SINGLE_PLAYER) {
                for (GamePackage pkg : gamePackageList) {
                    if (pkg.getPlayers().size() > 1) {
                        removeList.add(pkg);
                    }
                }
            //multi-player: remove all games were the player size is 1.    
            } else if (displayType == DisplayType.MULTI_PLAYER) {
                for (GamePackage pkg : gamePackageList) {
                    if (pkg.getPlayers().size() == 1) {
                        removeList.add(pkg);
                    }
                }
            }

            //clear all unwanted games.
            for (GamePackage pkg : removeList) {
                if (gamePackageList.contains(pkg)) {
                    gamePackageList.remove(pkg);
                }
            }
        }
        
        // Checks that the list being sorted has more than one item.
        if (gamePackageList.isEmpty() || gamePackageList.size() == 1) return;
        
        //conducts merge sort.
        MergeSort mergeSort = new MergeSort(this);
        
        GamePackage[] gamePkgStaticList = new GamePackage[gamePackageList.size()];
        
        //converts to primitive list.
        for (int i = 0; i < gamePkgStaticList.length; i++) {
            gamePkgStaticList[i] = gamePackageList.get(i);
        }
        
        mergeSort.sort(gamePkgStaticList, 0, gamePkgStaticList.length-1);
        
        //resets the game package list to the sorted version.
        gamePackageList.clear();
        for (int i = 0; i < gamePkgStaticList.length; i++) {
            gamePackageList.add(gamePkgStaticList[i]);
        }
    }
    
    /**
     * Sets the list of the instance.
     * @param gamePackageList List of games.
     */
    public void setList(List<GamePackage> gamePackageList) {
        this.gamePackageList = gamePackageList;
    }
    
    /**
     * Retrieves the list of game packages.
     * @return The list of games.
     */
    public List<GamePackage> getList() {
        return gamePackageList;
    }
    
    /**
     * Specifies the {@code DisplayType} of the
     * search, multiplayer, singleplayer etc.
     * @param displayType The display type.
     */
    public void setDisplayType(DisplayType displayType) {
        if (displayType == null) {
            displayType = DisplayType.COMBINED;
        } else {
            this.displayType = displayType;
        }
    }
    
    /**
     * Gets the display type which is being sorted.
     * @return DisplayType of sort.
     */
    public DisplayType getDisplayType() {
        return displayType;
    }
    
    /**
     * Specifies the search condition for the instance.
     * @param searchCondition Condition of the sort.
     */
    public void setSearchCondition(SearchCondition searchCondition) {
        if (searchCondition == null) {
            this.searchCondition = SearchCondition.HIGH_TO_LOW;
        } else {
            this.searchCondition = searchCondition;
        }
    }
    
    /**
     * Gets the SearchCondition used by the sort.
     * @return SearchCondition of the sort.
     */
    public SearchCondition getSearchCondition() {
        return searchCondition;
    }
    
    /**
     * Sets the search component used by the sort.
     * @param searchComponent New search component to use.
     */
    public void setSearchComponent(SearchComponent searchComponent) {
        if (searchComponent == null) {
            this.searchComponent = SearchComponent.GDP;
        } else {
            this.searchComponent = searchComponent;
        }
    }
    
    /**
     * Gets the SearchComponent used by the sort.
     * @return The SearchComponent used by the sort.
     */
    public SearchComponent getSearchComponent() {
        return searchComponent;
    }
    
}
