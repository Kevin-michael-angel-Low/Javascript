
/**
 * Write a description of class Status here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */

import java.util.Random;
public class Status
{
    int MIN_VALUE;
    int MAX_VALUE;
    int current_value;
    String name;
    
    /**
     * Constructor for objects of class Status
     */
    public Status(int MIN_VALUE, int MAX_VALUE, int current_value, String name)
    {
        this.MIN_VALUE = MIN_VALUE;
        this.MAX_VALUE = MAX_VALUE;
        this.current_value = current_value;
        this.name = name;
    }
     /**
     * Methods
     */
    
    public int getStatus(){ 
        return current_value;
    }
    
    public int getMinValue(){
        return MIN_VALUE;
    }
    
    public int getMaxValue(){
        return MAX_VALUE;
    }
    
    public boolean increase()
    {
        if (current_value + 1 <= MAX_VALUE){
         current_value = current_value + 1;
         return true;
        }
        else{
         return false;   
        }
    }
    
    public boolean decrease(){
        if (current_value - 1 >= MIN_VALUE){
         current_value = current_value - 1;
         return true;
        }
        else{
         return false;   
        }
    }
    
    public static void main(String[] args){ //testing code
        Status hunger = new Status (0, 10, 4, "boy");
        
        hunger.decrease();
        System.out.println(hunger.getStatus());
    }
}
