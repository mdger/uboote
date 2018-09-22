package game;

import com.google.gson.Gson;
import game.gui.Client;
import game.module.save.SaveFile;
import static game.module.save.SaveFile.readFromFile;
import game.module.save.SaveFileLaserPiratesUser;

/**
 *
 * Nothing to see here. Just launches the client
 * @author Marco
 * 
 */

public class Main {

    public static void main(String[] args) {
        Client.launchClient(args);
    }
}
