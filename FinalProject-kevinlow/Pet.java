
/**
 * Write a description of class Pet here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Pet
{
    String name;
    int age;
    Status hunger;
    Status happiness;
    Status health;
    
    /**
     * Constructor for objects of class Pet
     */
    //Pet Constructor
    public Pet(String name, int age)
    {
        this.name = name;
        this.age = age;
        this.hunger = new Status(0, 30, (int)(Math.random()*30 + 1), "hunger");
        this.happiness = new Status(0, 15, (int)(Math.random() * 15 + 1), "happiness");
        this.health = new Status(0, 10, (int)(Math.random() * 10 + 1), "health");
    }
    
    /**
     * Methods
     */
    //Getter methods
    public int getHunger(){
        return hunger.getStatus();
    }
    
    public int getHappiness(){
        return happiness.getStatus();
    }
    
    public int getHealth(){
        return health.getStatus();
    }
    
    public String getName(){
     return name;
    }
    
    public int getAge(){
     return age;   
    }
    
    //action methods
    public void feed(){
     hunger.increase();
     System.out.println(name + " had some snacks! (costs 5 coins) +1 hunger");
    }
    
    public void play(){
        hunger.decrease();
        happiness.increase();
        health.decrease();
        System.out.println(name + " played fetch for awhile! -1 hunger, +1 happiness, -1 health");
    }
    
    public void takeBath(){
        happiness.decrease();
        health.increase();
        System.out.println("You gave " + name + " a bath! -1 happiness, +1 health");

    }
    
    public void giveMedicine(){
        health.increase();
        hunger.decrease();
        System.out.println("You fed " + name + " some medicine (costs 10 coins!). -1 happiness, +1 health");

    }
    
    //other methods
    public String toString(){
        return age + "-year old dog named " + name;
    }
    
    public String petStatus(){ //toString to print out all the pet's statuses
        return  
                toString() + "\n"
                + "Hunger: " + getHunger() + "/" + hunger.getMaxValue() + "\n"
                + "Happiness: " + getHappiness() + "/" + happiness.getMaxValue() + "\n"
                + "Health: " + getHealth() + "/" + health.getMaxValue() + "\n";
    }
}
