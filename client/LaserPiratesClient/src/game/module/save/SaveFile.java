package game.module.save;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;


/**
 * @author Marco
 */
public class SaveFile {
    private static final String save_file_location = "./save_file.json";
    private static final Gson gson = new Gson();
    
    public static final String SAVE_FILE_PATH = "./save_file.json"; 
 
    // Save to file Utility
    public static void writeToFile(String myData) {
        File file = new File(save_file_location);
        if (!file.exists()) {
            try {
                File directory = new File(file.getParent());
                if (!directory.exists()) {
                        directory.mkdirs();
                }
                file.createNewFile();
            } catch (IOException e) {
                log("Excepton Occured: " + e.toString());
            }
        }

        try {
            // Convenience class for writing character files
            FileWriter fileWriter;
            fileWriter = new FileWriter(file.getAbsoluteFile(), false);

            // Writes text to a character-output stream
            BufferedWriter bufferWriter = new BufferedWriter(fileWriter);
            bufferWriter.write(myData.toString());
            bufferWriter.close();

            log("Company data saved at file location: " + save_file_location + " Data: " + myData + "\n");
        } catch (IOException e) {
            log("Hmm.. Got an error while saving Company data to file " + e.toString());
        }
    }

    // Read From File Utility
    public static SaveFileLaserPiratesUser readFromFile() {
        File saveFile = new File(save_file_location);
        if (!saveFile.exists()) {
            log("File doesn't exist");
        }

        InputStreamReader isReader;
        try {
            isReader = new InputStreamReader(new FileInputStream(saveFile), "UTF-8");

            JsonReader myReader = new JsonReader(isReader);
            String s = myReader.toString();
            SaveFileLaserPiratesUser userData = gson.fromJson(myReader, SaveFileLaserPiratesUser.class);
            
            return userData;
        } catch (FileNotFoundException e) {
            log("FileNotFoundException " + e.toString());
        } catch (UnsupportedEncodingException e) {
            log("UnsupportedEncodingException " + e.toString());
        }

        log("\nUser Data loaded successfully from file " + save_file_location);
        
        return null;
    }

    private static void log(String string) {
        System.out.println(string);
    }
}
