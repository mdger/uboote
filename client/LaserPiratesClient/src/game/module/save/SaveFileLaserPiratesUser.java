package game.module.save;

import com.google.gson.Gson;
import game.controller.LevelState;
import game.module.game.SuccessCounter;

/**
 *
 * @author Marco
 */
public class SaveFileLaserPiratesUser {
    private LevelState currentLevel;
    private double currentScore;
    
    private boolean[] lastGames;
    private int failuresTolerated;
    private int progress;
    private int pointer;
    private int successesNeeded;

    public void setCurrentLevel(LevelState currentLevel) {
        this.currentLevel = currentLevel;
    }

    public LevelState getCurrentLevel() {
        return currentLevel;
    }

    public double getCurrentScore() {
        return currentScore;
    }

    public void setCurrentScore(double currentScore) {
        this.currentScore = currentScore;
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
    
    public int getProgress() {
        return progress;
    }

    public int getSuccessesNeeded() {
        return successesNeeded;
    }

    public void setFailuresTolerated(int failuresTolerated) {
        this.failuresTolerated = failuresTolerated;
    }

    public void setLastGames(boolean[] lastGames) {
        this.lastGames = lastGames;
    }

    public void setPointer(int pointer) {
        this.pointer = pointer;
    }

    public void setProgress(int progress) {
        this.progress = progress;
    }

    public void setSuccessesNeeded(int successesNeeded) {
        this.successesNeeded = successesNeeded;
    }
    
    public String toJson() {
        Gson gson = new Gson();
        return gson.toJson(this);
    }
}
