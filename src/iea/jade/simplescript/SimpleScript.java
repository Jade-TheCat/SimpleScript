package iea.jade.simplescript;

import iea.jade.simplescript.util.MemoryManager;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class SimpleScript {
    private static Map<String, Object> arguments;
    private static MemoryManager memMan;
    public static void main(String[] args) {
        arguments = parseArgs(args);
        if (arguments.get("memsize") != null) {
            memMan = new MemoryManager((int) arguments.get("memsize"));
        } else {
            memMan = new MemoryManager();
        }
    }
    
    public static MemoryManager getMemMan() {
        return memMan;
    }
    
    private static Map<String, Object> parseArgs(String[] args) {
        Map<String, Object> out = new HashMap<>();
        for (String s : args) {
            if (s.startsWith("--")) {
                s = s.replaceFirst("--", "");
                if (s.startsWith("script=")) {
                    s = s.replaceFirst("script=","");
                    out.put("cli", false);
                    out.put("script", new File(s));
                } else if (s.startsWith("Mem=")) {
                    s = s.replaceFirst("Mem=", "");
                    out.put("memsize", Integer.parseInt(s));
                }
            }
        }
        return out;
    }
    
}
