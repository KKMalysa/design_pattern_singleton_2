package singleton;

import java.util.Random;
import java.util.Scanner;

public class GuessGame {

    private int score =0;
    private Random random = new Random();
    private Scanner scanner = new Scanner(System.in);
    private static GuessGame instance = new GuessGame();                 // odporny na wielowątkowość

    private GuessGame() {

    }

    public static GuessGame getInstance(){

        return instance;

    }

    public int getScore() {
        return score;
    }

    protected Object readResolve() {                                    //odporny na serializację
        return getInstance();
    }

    public void play(){
        for (int i=0; i<10; i++){
            int number = random.nextInt(10);
            System.out.println("Zgadnij cyfrę: ");
            int guess = scanner.nextInt();

            if(number == guess) {
                System.out.println("udało się!");
                score++;
            }else {
                System.out.println("Nie udało sie, wylosowana liczba to: "+number);
            }
        }
        System.out.println("twój wynik: " + score);


    }
}
