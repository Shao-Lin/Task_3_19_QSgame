package Task;

import java.util.*;
import java.util.ArrayList;
public class Game {
    public Game() {
        fillingOut();
        stirringTheDeck();
    }
    private Queue<Card> deck = new LinkedList<>();
    private Stack<Card> table = new Stack<>();
    private ArrayList<Card> cardsDeck = new ArrayList<>();
    private ArrayList<Card> cardsTable = new ArrayList<>();
    int movies = 0;
    public void fillingOut(){
        String[] values = new String[]{"2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace"};
        String[] suits = new String[]{"♥", "♦", "♠", "♣"};
        for (String value : values) {
            for (String suit : suits) {
                this.deck.add(new Card(suit, value));
            }
        }
    }
    public void stirringTheDeck(){
        Collections.shuffle((LinkedList) deck);
    }
    public void LogicCardGame() {
        table.push(deck.poll());
        this.movies++;
        int counter = 0;
        while (counter != deck.size()) {
            this.movies++;
            if (!deck.peek().equals(table.peek())) {
                deck.add(deck.poll());
                counter++;
            } else {
                table.push(deck.poll());
                counter = 0;
            }
        }
    }
    public String getCardDeck(int count){
        return cardsDeck.get(count).toString();
    }
    public String getCardTable(int count){
        return cardsTable.get(count).toString();
    }
    public void entryArrayDeck(){
        int size = deck.size();

        for(int i = 0; i < size; i++){
            cardsDeck.add(deck.poll());
        }
    }
    public void entryArrayTable(){
        int size = table.size();

        for(int i = 0; i < size; i++){
            cardsTable.add(table.pop());
        }
    }
    public void entryQueueDeck(){
        deck.addAll(cardsDeck);
        this.cardsDeck.clear();
    }
    public void entryStackTable(){
        table.addAll(cardsTable);
        this.cardsTable.clear();
    }
    public int getSizeArrayDeck(){
        return cardsDeck.size();
    }
    public int getSizeArrayTable(){
        return cardsTable.size();
    }
    public int getMovies(){
        return movies;
    }
}