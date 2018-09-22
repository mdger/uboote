package game.module.game;


import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class SuccessCounter {
    private boolean[] lastGames; // Ring-Buffer
    private int pointer = 0;
    private int successesNeeded;
    private int failuresTolerated;
    
    private IntegerProperty progress;

    public SuccessCounter(int successesNeeded, int failuresTolerated) {
        this.successesNeeded = successesNeeded;
        this.failuresTolerated = failuresTolerated;
        this.lastGames = new boolean[successesNeeded + failuresTolerated];
        
        this.progress = new SimpleIntegerProperty(getProgress());
    }


    public SuccessCounter(boolean[] lastGames, int successesNeeded, int failuresTolerated, 
        int pointer, int progress) {
        this.lastGames = lastGames;
        this.pointer = pointer;
        this.successesNeeded = successesNeeded;
        this.failuresTolerated = failuresTolerated;
        this.progress = new SimpleIntegerProperty(progress);
    }

    public void onGame(boolean success) {
        lastGames[pointer] = success;
        pointer = (pointer + 1) % lastGames.length;
        this.progress.setValue(getProgress());
    }
    
    public IntegerProperty progress() {
        return this.progress;
    }
    
    public void reset(int successesNeeded, int failuresTolerated) {
        this.successesNeeded = successesNeeded;
        this.failuresTolerated = failuresTolerated;
        this.lastGames = new boolean[successesNeeded + failuresTolerated];
        this.progress.setValue(getProgress());
    }
    
    private int getProgress() {
        int successes = 0;
        int failures = 0;
        for (int i = pointer + lastGames.length - 1; i >= pointer; i--) {
            boolean success = lastGames[i % lastGames.length];
            if (success) {
                successes++;
            } else {
                failures++;
                if (failures > failuresTolerated) {
                    return successes;
                }
            }
        }
        return successes;
    }
    
    public boolean passLevel() {
        return getProgress() >= successesNeeded;
    }

    public int getFailuresTolerated() {
        return failuresTolerated;
    }

    public boolean[] getLastGames() {
        return lastGames;
    }

    public int getPointer() {
        return pointer;
    }
    
    public int getProgressValue() {
        return this.progress.getValue();
    }

    public int getSuccessesNeeded() {
        return successesNeeded;
    }
}
