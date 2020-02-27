
/**
 * Write a description of class NeoPetGame here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */

import java.util.Random;
import java.util.Scanner;
import java.util.Arrays;
import java.util.ArrayList;
public class NeoPetGame
{
    // instance variables
    private int x;
    Scanner sc = new Scanner(System.in);
    String playerName;
    
    private final String menuOptions = //menu options for the main menu
                      "--------------------------------\n" 
                    +  "Main Menu\n"
                    + "--------------------------------\n"
                    + "1: Display Owner Information\n"
                    + "2: Visit the Pet Store\n" 
                    + "3: Play the Guessing Game\n"
                    + "4: Interact with your pet(s)\n"
                    + "5: Quit Game\n";
                    
    private final String interactMenu = //menu to interact with the pets
                        "--------------------------------\n" 
                    +  "Pet Interaction Menu\n"
                    + "--------------------------------\n"
                    + "1: Display Pet Status Information\n"
                    + "2: Give your pet some exercise\n" 
                    + "3: Give your pet a bath\n"
                    + "4: Feed your pet\n"
                    + "5: Give your pet medicine\n" 
                    + "6: Stop playing with your pets\n";
    Owner player;
    ArrayList<Pet> petShopStorage = new ArrayList<Pet>(6);
    Pet interactPet; //the pet that is interacted with in the interact menu
    /**
     * Constructor for objects of class NeoPetGame
     */
    public NeoPetGame(){ //called first before the main menu. Creates pet shop with default pets and user with random amount of coins.
        this.petShopStorage = new ArrayList<Pet>(6); //sets default pets in the pet shop
        petShopStorage.add(new Pet("Jean Luc", 2));
        petShopStorage.add(new Pet("Mochi", 3));
        petShopStorage.add(new Pet("Cho", 3));
        petShopStorage.add(new Pet("Mumbai", 1));
        petShopStorage.add(new Pet("Bodie", 6));
        petShopStorage.add(new Pet("Puff", 4));
        
        System.out.println("Welcome to my NeoPets Game! What's your name?");
        playerName = sc.nextLine();
        System.out.println("Creating your account!");
        System.out.println();
        this.player = new Owner(playerName, (int)(Math.random()*5 + 5)*10 );
        System.out.println(player.toString());
        System.out.println();
    }

    /**
     Methods
     */
    public void playGame(){ //plays the main game.
     System.out.println("Welcome to my NeoPets Game!");
     System.out.println(menuOptions);
        int num = sc.nextInt();
     while (num != 5){        
         if (num == 1){ //prints player information
             System.out.println(player.toString());
             System.out.println(menuOptions);
             num = sc.nextInt();
            }
         else if (num == 2){ //buy a pet
             petShop();
             System.out.println(menuOptions);
             num = sc.nextInt();
            }
         else if (num == 3){ //plays the guessing game
             guessingGame();
             System.out.println(menuOptions);
             num = sc.nextInt();
            }
         else if (num == 4){ //interact with one of your pets
             selectPet();
             System.out.println(menuOptions);
             num = sc.nextInt();
            }
         else{ //if the input is anything other than 1-5
             System.out.println("Invalid Input!");
             System.out.println(menuOptions);
             num = sc.nextInt();
            }
        }
      System.out.println("Qutting Program."); //arrives here when inputting 5 to quit
      return;
    }
    
    public void petShop(){
        System.out.println("Welcome to the Norweigan Blue Pet Shop! Any Pet can be bought with 10 coins.\n" + 
                            "Here are the list of pets for sale:");
        for (int i = 0; i < petShopStorage.size(); i ++){
         System.out.println((i + 1) + ": " + petShopStorage.get(i));   
        }
        System.out.println("Please enter the number of the Pet you would like to buy, or 0 to leave.");
        int buy = sc.nextInt();
        if (buy == 0){
            System.out.println("Return to the shop later!");
            return;   
        }
        if (player.addPet(petShopStorage.get(buy - 1)) ){
            player.removeCoins(10);
            System.out.println("Congrats, you adopted " 
                            + petShopStorage.get(buy - 1).getName() +
                            "! Your fee will be 10 coins. You have " + player.getMoney() + " coins.");
                            petShopStorage.remove(buy - 1);
                            System.out.println();
        }
        else{
            System.out.println("Return to the shop later!");
        }
    }
    
    public void guessingGame(){
        boolean runGuessGame = true;
        System.out.println("Welcome to my guessing game!" +
                           "If you guess the correct number, you earn up to 20 coins.");
        while(runGuessGame){
            System.out.println("I'm thinking of a number between 1 and 5. What's your guess?");
            int gameNum = (int)(Math.random()*5 + 1);
            int playerNum = sc.nextInt();
            if (playerNum == gameNum){
                int reward = (int)(Math.random() * 20 + 1);
                player.addCoins(reward);
                System.out.println("That's correct! You have been awarded " + reward 
                                    + " coins, and you now have " + player.getMoney()); 
                runGuessGame = false;
            }
            else{
                System.out.println("Incorrect! Guess again.");
            }
        }
        System.out.println("Hope you had fun with my game!");
    }
    
    public void selectPet(){ //first checks how many pets you have.  
        if (player.getFirstPet() == null){ //no pets, then goes back to main menu
         System.out.println("You don't have any pets! Buy some from the pet store.");
         return; //these quits the selectPet method to go back to main menu.
        }
        else if (player.getSecondPet() == null){ //one pet, sets the one pet as the interact Pet
            interactPet = player.getFirstPet();
            interactPet();
            return;
        }
        System.out.println("Select one of your pets!"); //more than one pet, select which one you want to interact with
        System.out.println(player.toString());
        int select = sc.nextInt();
        if (select == 1){
         interactPet = player.getFirstPet();
         interactPet();
         return;
        }
        else if (select == 2){
            interactPet = player.getSecondPet();
            interactPet();
            return;
        }
        else if(select == 3){
            interactPet = player.getThirdPet();
            interactPet();
            return;
        }       
    }
    
    public void interactPet(){ //note: manipulates the interactPet object
        System.out.println("You're interacting with " + interactPet.getName());
        System.out.println(interactMenu);
        int interNum = sc.nextInt();
        while (interNum != 6){        
         if (interNum == 1){ //display pet statuses
             System.out.println(interactPet.petStatus());
             System.out.println(interactMenu);
             interNum = sc.nextInt();
            }
         else if (interNum == 2){ //excercise pet
             interactPet.play();
             System.out.println(interactMenu);
             interNum = sc.nextInt();
            }
         else if (interNum == 3){ //Bathe pet
             interactPet.takeBath();
             System.out.println(interactMenu);
             interNum = sc.nextInt();
            }
         else if (interNum == 4){ //feed pet
             interactPet.feed();
             player.removeCoins(5);
             System.out.println("You now have " + player.getMoney() + " coins.");
             System.out.println(interactMenu);
             interNum = sc.nextInt();
            }
         else if (interNum == 5){ //medicine pet
             interactPet.giveMedicine();
             player.removeCoins(10);
             System.out.println("You now have " + player.getMoney() + " coins.");
             System.out.println(interactMenu);
             interNum = sc.nextInt();
            }
         else{
             System.out.println("Invalid Input!");
             System.out.println(interactMenu);
             interNum = sc.nextInt();
            }
        }
        System.out.println("You've stopped playing with " + interactPet + "."); 
        return; //returns to main menu.
    }
   
    public static void main(String[] args){ //final runner to play the game.
     NeoPetGame myGame = new NeoPetGame();
     boolean keepRunning = true;
     while (keepRunning){
         myGame.playGame();
         System.out.println("Goodbye!");
         keepRunning = false;
        }
     
    }
}
