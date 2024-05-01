package labTen;


import java.util.ArrayList;
import java.util.Scanner;

public class Menu {
    // instance var
    private Scanner myScan = new Scanner(System.in);
    private Pokedex pokedex = new Pokedex();


    //default  constructor -- no need to write
    //public menu(){}

    //methods
    public void displayMenu()
    {
        while(true){
            String selection;
            System.out.printf("\n%s MENU %s\n","*".repeat(9),"*".repeat(9));
            System.out.print("Please make a selection : \n"+
                    "1) Add a Pokemon\n"+
                    "2) Remove a Pokemon\n"+
                    "3) Display Pokemon INFO\n"+
                    "4) Display All Pokemon INFO\n"+
                    "5) Exit\n"+
                    ">> ");
            selection = myScan.nextLine();
            if(selection.equals("1")){
                createPokemon();

                //create pokemon method

            } else if (selection.equals("2")) {
                deletePokemon();;
                //deletePokemon
            }else if (selection.equals("3")){
                displayPokemon();
                //Display pokemon info
            }else if (selection.equals("4")){
                displayAllPokemon();
                //Display all Pokémon info
            }else if (selection.equals("5")){
                //Exit
                System.out.println("Exiting .... don't let a wild pokemon get you");
                break;
            }else {
                System.out.println("Invalid entry try again or Exit!!!");
            }
        }
    }
    //display all pokemon
    private void displayAllPokemon(){
        ArrayList<Pokemon> pokemonArrayList = pokedex.getPokemonArrayList();
        for (int i = 0; i < pokemonArrayList.size();i++){
            System.out.printf("%d. %s\n\n",i + 1,pokemonArrayList.get(i));
        }

    }
    // Display Pokémon method
    private void displayPokemon(){
        //variable
        String name;
        Pokemon pokemon;

        System.out.println("Enter the Pokemon name to find in the pokedex!");
        name = myScan.nextLine();
        // use the instance of the Pokédex to get a Pokémon
        pokemon=pokedex.getPokemon(name);
        if (pokemon == null){
            System.out.println("The Pokemon can not be found!!!");

        }else{
            System.out.println(pokemon.toString());
        }

    }
    //delete pokemon
    private void deletePokemon(){
        //variables
        Pokemon pokemon;
        String name;
        System.out.print("Enter the name of the Pokemon you want to release:  ");
         name =myScan.nextLine();
        //instance to call pokdex mothod to get a pokmon
        pokemon = pokedex.getPokemon(name);
        if(pokemon == null){
            System.out.println("The Pokemon can not be found!!!");

        }else { pokedex.removePokemon(pokemon);
            //removes pokemon
            System.out.printf("%s Removed from the Pokedex\n",name);

        }
    }
    //create pokemon method
    private void createPokemon(){
        //int var
        String name;
        int hp;
        Pokemon pokemon;
        String moveName;
        int movePower;
        int moveSpeed;
        Move move;

        //prompting
        System.out.println("Enter pokemon's name:");
        name = myScan.nextLine();
        System.out.println("Enter pokemon's HP");
        hp = Integer.parseInt(myScan.nextLine());
        //pokemon constructor
        pokemon = new Pokemon(name,hp);
        System.out.printf("Enter Moves for %s,\n",name);
        while(true){
            System.out.println("\tEnter a Move name or Q if finished:  ");
              moveName = myScan.nextLine();
              if(moveName.equals("Q")){
                  break;

              }
              //promt input
            System.out.print("\t Enter move's power: ");
              movePower = Integer.parseInt(myScan.nextLine());
            System.out.print("\t Enter move's speed: ");
            moveSpeed = Integer.parseInt(myScan.nextLine());
            move=new Move(moveName,movePower,moveSpeed);
            // add the move to the Pokémon
            pokemon.addMove(move);

        }//add pokemon to pokedex arraylist
        
        pokedex.addPokemon(pokemon);
        System.out.printf("%s added to Pokedex\n\n",name);





    }


}
