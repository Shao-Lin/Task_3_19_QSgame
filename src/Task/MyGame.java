package Task;

import java.util.*;
public class MyGame {
    public MyGame() throws Exception {
        fillingOut();
        stirringTheDeck();
    }
    private MyQueue<Card> deck = new MyQueue<>();
    private MyStack<Card> table = new MyStack<>();
    private ArrayList<Card> cardsDeck = new ArrayList<>();
    private ArrayList<Card> cardsTable = new ArrayList<>();
    int movies = 0;
    public void fillingOut(){
        String[] values = new String[]{"2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace"};
        String[] suits = new String[]{"♥", "♦", "♠", "♣"};
        for (String value : values) {
            for (String suit : suits) {
                deck.add(new Card(suit, value));
            }
        }
    }
    public void stirringTheDeck() throws Exception {
        deck.shuffleQ(deck);
    }
    public void LogicCardGame() throws Exception {

        table.push(deck.pool());
        movies++;
        int counter = 0;
        while (counter != deck.count()) {
            movies++;
            if (!deck.peek().equals(table.peek())) {
                deck.add(deck.pool());
                counter++;
            } else {
                table.push(deck.pool());
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
    public void entryArrayDeck() throws Exception {
        int size = deck.count();

        for(int i = 0; i < size; i++){
            cardsDeck.add(deck.pool());
        }
    }
    public void entryArrayTable() throws Exception {
        int size = table.count();

        for(int i = 0; i < size; i++){
            cardsTable.add(table.pop());
        }
    }
    public void entryQueueDeck(){
        for(int i = 0; i < cardsDeck.size(); i++){
            deck.add(cardsDeck.get(i));
        }
        this.cardsDeck.clear();
    }
    public void entryStackTable(){
        for(int i = 0; i < cardsTable.size(); i++){
            table.push(cardsTable.get(i));
        }
        this.cardsTable.clear();
    }
    public int getSizeArrayTable(){
        return cardsTable.size();
    }
    public int getSizeArrayDeck(){
        return cardsDeck.size();
    }
    public int getMovies(){
        return movies;
    }
}