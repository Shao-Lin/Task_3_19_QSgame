package Task;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class FrameMain extends JFrame{
    Game game = new Game();
    MyGame myGame = new MyGame();
    JRadioButton firstVariant, secondVariant;
    public FrameMain() throws Exception {
        game.entryArrayDeck();

        setSize(500, 400);
        setLocation(100, 100);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JPanel panelCards = new JPanel(new GridLayout(13, 4));
        JPanel panelButtons = new JPanel(new GridLayout(1, 1, 5, 0));

        for(int i = 0; i < 52; i++){
            JLabel card = new JLabel(game.getCardDeck(i));
            panelCards.add(card);
        }

        game.entryQueueDeck();

        JButton result = new JButton("Выполнить");
        firstVariant = new JRadioButton("Свой вариант");
        secondVariant = new JRadioButton("Реализация java");


        panelButtons.add(result);

        JPanel buttons = new JPanel(new FlowLayout(FlowLayout.RIGHT));

        buttons.add(firstVariant);
        buttons.add(secondVariant);
        buttons.add(panelButtons);

        Container container = getContentPane();

        container.add(buttons, BorderLayout.SOUTH);
        container.add(panelCards);

        result.addActionListener(new ButtonResult());

    }

    class ButtonResult implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if(firstVariant.isSelected() && secondVariant.isSelected()){
                JOptionPane.showMessageDialog(null, "Невозможно выбрать два варианта", "Ошибка", JOptionPane.ERROR_MESSAGE);
            }
            else if(firstVariant.isSelected()){
                try {
                    myGame.LogicCardGame();
                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }
                try {
                    myGame.entryArrayTable();
                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }
                Main.frame.getContentPane().removeAll();

                setSize(300, 800);
                setLocation(100, 100);
                setDefaultCloseOperation(EXIT_ON_CLOSE);

                JLabel card1;
                JLabel card2;

                JPanel panelCard1 = new JPanel(new GridLayout(52, 1));
                JPanel panelCard2 = new JPanel(new GridLayout(52, 2));
                JPanel text = new JPanel(new FlowLayout(FlowLayout.LEFT));
                JPanel panelMovies = new JPanel(new FlowLayout(FlowLayout.RIGHT));


                JLabel textFirst = new JLabel("Карты на столе: |");
                JLabel textSecond = new JLabel("Оставшиеся карты в колоде: ");
                JLabel labelMovies = new JLabel("Количество ходов: " + Integer.toString(myGame.getMovies()));

                text.add(textFirst);
                text.add(textSecond);
                panelMovies.add(labelMovies);

                for(int i = 0; i < myGame.getSizeArrayTable(); i++){
                    card1 = new JLabel(myGame.getCardTable(i));
                    panelCard1.add(card1);
                }

                myGame.entryStackTable();

                try {
                    myGame.entryArrayDeck();
                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }

                for(int i = 0; i < myGame.getSizeArrayDeck(); i++){
                    card2 = new JLabel(myGame.getCardDeck(i));
                    panelCard2.add(card2);
                }

                myGame.entryQueueDeck();

                Container container = getContentPane();
                container.add(text, BorderLayout.NORTH);
                container.add(panelCard1);
                container.add(panelCard2, BorderLayout.EAST);
                container.add(panelMovies, BorderLayout.SOUTH);

                Main.frame.revalidate();
            }
            else{
                game.LogicCardGame();
                game.entryArrayTable();
                Main.frame.getContentPane().removeAll();

                setSize(300, 800);
                setLocation(100, 100);
                setDefaultCloseOperation(EXIT_ON_CLOSE);

                JLabel card1;
                JLabel card2;

                JPanel panelCard1 = new JPanel(new GridLayout(52, 1));
                JPanel panelCard2 = new JPanel(new GridLayout(52, 2));
                JPanel text = new JPanel(new FlowLayout(FlowLayout.LEFT));
                JPanel panelMovies = new JPanel(new FlowLayout(FlowLayout.RIGHT));


                JLabel textFirst = new JLabel("Карты на столе: |");
                JLabel textSecond = new JLabel("Оставшиеся карты в колоде: ");
                JLabel labelMovies = new JLabel("Количество ходов: " + Integer.toString(game.getMovies()));

                text.add(textFirst);
                text.add(textSecond);
                panelMovies.add(labelMovies);

                for(int i = 0; i < game.getSizeArrayTable(); i++){
                    card1 = new JLabel(game.getCardTable(i));
                    panelCard1.add(card1);
                }

                game.entryStackTable();

                game.entryArrayDeck();

                for(int i = 0; i < game.getSizeArrayDeck(); i++){
                    card2 = new JLabel(game.getCardDeck(i));
                    panelCard2.add(card2);
                }

                game.entryQueueDeck();

                Container container = getContentPane();
                container.add(text, BorderLayout.NORTH);
                container.add(panelCard1);
                container.add(panelCard2, BorderLayout.EAST);
                container.add(panelMovies, BorderLayout.SOUTH);

                Main.frame.revalidate();
            }
        }
    }

}
