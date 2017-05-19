package iea.jade.simplescript.util;

import iea.jade.simplescript.SimpleScript;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Parser {
    public static void parse(File f) {
        int index = 0;
        MemoryManager mem = SimpleScript.getMemMan();
        
        try(BufferedReader br = new BufferedReader(new FileReader(f))) {
            for(String line; (line = br.readLine()) != null; ) {
                if (line.length() == 1) {
                    Character c = line.charAt(0);
                    switch (c) {
                        case '>':
                            if (index + 1 < mem.getMax()) {
                                index++;
                            } else {
                                index = 0;
                            }   
                            break;
                        case '<':
                            if (index > 0) {
                                index--;
                            } else {
                                index = mem.getMax();
                            }   
                            break;
                        case 'I':
                            mem.set(index, (char) (mem.get(index) + 1));
                            break;
                        case 'D':
                            mem.set(index, (char) (mem.get(index)+1));
                        default:
                            break;
                    }
                }
            }
        } catch (IOException ex) {
            Logger.getLogger(Parser.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
