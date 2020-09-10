package org.example.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.BrowserManager;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.List;

public class FileUtils {
    public static Logger log = LogManager.getLogger(FileUtils.class.getName());

    public static void writeToFile(String filePath , List<String> lines) {
        try(FileWriter fileWriter = new FileWriter(filePath);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)){
            for(String line : lines){
                bufferedWriter.write(line);
                bufferedWriter.write('\n');
            }
            bufferedWriter.flush();
        }catch (Exception e){
            e.getMessage();
        }
    }

    public static void createFolder(File folder , boolean recursive){
        if(folder.exists() && folder.isDirectory()){
           log.info(folder.getName() + " directory already exist");
        }else if((recursive ? folder.mkdirs() : folder.mkdir())){
            log.info(folder.getName() + " directory created successfully");
        }else{
            log.error("failed to create '" + folder.getName() + "' directory");
        }
    }


}
