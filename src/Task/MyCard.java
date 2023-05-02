package Task;

import java.util.Objects;
public class MyCard {
    private final String suit;
    private final String value;
    public String getSuit() {
        return suit;
    }
    public String getValue() {
        return value;
    }
    public MyCard(String suit, String value) {
        this.suit = suit;
        this.value = value;
    }
    public boolean equals(Object o){
        MyCard card = (MyCard) o;
        return Objects.equals(suit, card.suit) || Objects.equals(value,card.value);
    }
    public String toString(){
        return value + " " + "of" + " " + suit;
    }
}
