
/**
 * Write a description of class Owner here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.util.Arrays;
public class Owner
{
    String name;
    int money;
    Pet petList[] = new Pet[3];
    
    /**
     * Constructor for objects of class Owner
     */
    public Owner(String name, int money){
        this.name = name;
        this.money = money;
        this.petList = new Pet[3];
    }
    
     /**
     * Methods
     */
    //Getters
    public Pet getFirstPet(){
        return petList[0];
    }
    
    public Pet getSecondPet(){
        return petList[1];
    }
    
    public Pet getThirdPet(){
        return petList[2];
    }
    
    public int getMoney(){
        return money;   
    }
    
    //coin setters
    public void addCoins(int cash){
     this.money = money + cash;   
    }
    
    public void removeCoins(int cash){
     this.money = money - cash;   
    }
    
    //adds pets to the owner's pet list, if empty.
    public boolean addPet(Pet addPet){
        if (petList[2] == null){
            for (int i = 0; i <= 3; i++){
                if (petList[i] == null){
                    petList[i] = addPet;
                    return true;
                }
            }
        }
        System.out.println("You have the maximum amount of pets!");
        return false;
    }
    
    //returns number of pets the owner owns
    public int getNumPets(){
        int numPets;
        if (petList[0] == null){
            return 0;
            }
        else if (petList[1] == null){
            return 1;
        }
        else if (petList[2] == null){
            return 2;
        }
        return 3;
    }
   
    //prints out owner information and pets they own
    public String toString(){
        String bigString;
        if (petList[0] == null){
            return "Owner: " + name + " has " + money + " coins.\n" + 
                name + " doesn't have any pets yet!";
            }
        else if (petList[1] == null){
            return "Owner: " + name + " has " + money + " coins.\n" + 
                name + " is the proud owner of " + getNumPets() + " pet:\n" +
                petList[0].toString();
        }
        else if (petList[2] == null){
            return "Owner: " + name + " has " + money + " coins.\n" + 
                name + " is the proud owner of " + getNumPets() + " pets:\n" +
                petList[0].toString() + "\n" +
                petList[1].toString();
        }
        return "Owner: " + name + " has " + money + " coins.\n" + 
                name + " is the proud owner of " + getNumPets() + " pets:\n" +
                petList[0].toString() + "\n" +
                petList[1].toString() + "\n" +
                petList[2].toString();
    }
}
