package InterfaceHotel;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;



public class FileUtil {
	    
	    
    public static String readFileContent(String fileName) {
        StringBuilder content = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                content.append(line).append("\n");
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return content.toString();
    }

    public static String findLineByID(String fileName, String target) {
        String lineContainingID = null;
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.contains(target)) {
                    lineContainingID = line;
                    break;
                }
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return lineContainingID;
    }
    
    public static String findClientByID(String fileName, int clientID) {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("\t");
                for (String part : parts) {
                    if (part.startsWith("ID: " + clientID)) {
                        return line;
                    }
                }
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return null;
    }


    
    
    
   
    
}

