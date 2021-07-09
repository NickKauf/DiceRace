import java.util.Random;
import java.util.Scanner;
import java.util.ArrayList;

public class GameOfDice {
    public static void main(String [] args) {
        /*
        Game of Dice - Pseudocode

        begin

            make randNum a random number between 1 - 6
            print welcome message
            continue is yes
            dice 1 is an int
            dice 2 is an int
            totalscore is 0

            while continue is yes
                dice1 is randnum
                dice2 is randnum
                sum is dice1+dice2
                print "dice 1:" dice1
                print "dice 2:" dice2
                if dice 1 or dice 2 is 1
                    set roundscore to 0
                    totalscore = totalscore + roundscore
                    print totalscore
                    if totalscore is 100
                        print you win
                        continue is no
                    endif
                    prompt continue y/n
                    if input is n or N
                        set continue to false
                    endif

                else if dice 1 and dice 2 are 1
                    set roundscore to 25
                    totalscore = totalscore + roundscore
                    print totalscore
                    if total score is 100
                        print you win
                        continue is no
                    endif
                    prompt continue y/n
                    if input is n or N
                        continue is no
                    endif

                else
                    set roundscore to sum
                    print roundscore
                    totalscore = totalscore + roundscore
                    print totalscore
                    if total score is 100
                        print you win
                        continue is no
                    endif
                    prompt continue y/n
                    if input is n or N
                        set continue to false
                    endif

                endif
                endwhile



        end

         */

        //ingredients

        int dice1 = 0;
        int dice2 = 0;
        //String rollAgain = "y";
        boolean rollAgain = true;

        int totalScore = 0;
        int roundScore = 0;
        Scanner kb = new Scanner(System.in);
        Random randomizer = new Random();
        ArrayList<Integer> diceArray = new ArrayList<>(); //building a dice to roll
        diceArray.add(1);
        diceArray.add(2);
        diceArray.add(3);
        diceArray.add(4);
        diceArray.add(5);
        diceArray.add(6);
        int randomIndex = randomizer.nextInt(6); // restate these to generate
        int rollDie = diceArray.get(randomIndex); // a single dice roll
        int rounds = 0;


        System.out.println("Welcome! Let's play dice.\nRace to 100!\nSnake eyes = 25pts\nRolls with a one = 0pts\n");

        while (rollAgain == true) {
            rounds++;
            randomIndex = randomizer.nextInt(6);
            rollDie = diceArray.get(randomIndex);
            dice1 = rollDie;

            randomIndex = randomizer.nextInt(6);
            rollDie = diceArray.get(randomIndex);
            dice2 = rollDie;

            System.out.println("Your Rolls: "+dice1+" & "+dice2);

            if(dice1 == 1 && dice2 == 1) {
                roundScore = 25;
                totalScore += roundScore;
                System.out.println("Round Score: " + roundScore + " (nice!)"+"\nTotal Score: "+totalScore);
                if (totalScore >= 100){
                    rollAgain = false;
                }

            }
            else if(dice1 == 1 || dice2 == 1) {
                roundScore = 0;
                totalScore += roundScore;
                System.out.println("Round Score: " + roundScore + " (too bad!)"+"\nTotal Score: "+totalScore);
                if (totalScore >= 100){
                    rollAgain = false;
                }
            }
            else {
                roundScore = dice1 + dice2;
                totalScore += roundScore;
                System.out.println("Round Score: " + roundScore+"\nTotal Score: "+totalScore);
                if (totalScore >= 100){
                    rollAgain = false;
                }
            }


            if(totalScore >=100){
                System.out.println("You won in "+rounds+" rounds!");
                rollAgain = false;
            }
            else {
                System.out.println("Roll again? y/n\n");
                String answer = kb.nextLine();
                if (answer.equals("n") || answer.equals("N") || answer.equals("NO") || answer.equals("No")) {
                    rollAgain = false;
                }
            }

        }
        System.out.println("Thank you for playing!");





    }
}

