package iea.jade.simplescript.util;

import java.util.Arrays;
import java.util.List;



public class MemoryManager {
    private List<Character> memory;
    int size;
    public MemoryManager() {
        this.memory = Arrays.asList(new Character[255]);
        this.size = 255;
    }
    public MemoryManager(int size) {
        this.memory = Arrays.asList(new Character[size]);
        this.size = size;
    }
    
    public void set(int address, Character value) {
        memory.set(address, value);
    }
    public Character get(int address) {
        return memory.get(address);
    }
    public int getMax() {
        return size;
    }
}
