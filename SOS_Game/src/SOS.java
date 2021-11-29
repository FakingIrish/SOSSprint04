import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;
import java.util.Random;

public class SOS extends GameLogic implements ActionListener {

    int gridSize;

    Random random = new Random();
    JFrame frame = new JFrame();
    JFrame board = new JFrame();
    JPanel title_panel = new JPanel();
    JPanel button_panel = new JPanel();
    JPanel bottom_panel = new JPanel();
    JPanel blue_panel = new JPanel();
    JPanel red_panel = new JPanel();
    JLabel blue_player = new JLabel();
    JLabel red_player = new JLabel();
    JRadioButton humanBlue, humanRed, compBlue, compRed;
    JLabel welcome_text = new JLabel();
    JLabel board_size_text = new JLabel();
    JFormattedTextField board_size = new JFormattedTextField();
    String opt;

    SOS() {
        setUpGame();
    }

    public void setUpGame() {

        JPanel settings_panel = new JPanel();
        settings_panel.setLayout(new GridLayout(2, 2));
        settings_panel.setBounds(0, 0, 500, 100);
        settings_panel.setSize(500, 200);

        JPanel welcome_panel = new JPanel();
        welcome_panel.setLayout(new GridLayout(1, 1));
        welcome_panel.setBounds(0, 0, 500, 200);
        welcome_panel.setSize(500, 100);

        board.setTitle("SOS Game Settings");
        board.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        board.setSize(500, 300);
        board.getContentPane().setBackground(Color.CYAN);
        board.setLayout(new BorderLayout(20, 20));
        board.setLocationRelativeTo(null);
        board.setVisible(true);

        welcome_text.setFont(new Font("Ink Free", Font.BOLD, 25));
        welcome_text.setHorizontalAlignment(SwingConstants.CENTER);
        welcome_text.setVerticalAlignment(SwingConstants.CENTER);
        welcome_text.setText("Welcome to SOS!");
        welcome_panel.add(welcome_text);

        simpleGame = new JRadioButton("Simple Game");
        simpleGame.setSelected(true);
        simpleGame.setHorizontalAlignment(SwingConstants.CENTER);
        generalGame = new JRadioButton("General Game");
        generalGame.setHorizontalAlignment(SwingConstants.CENTER);
        ButtonGroup gameGroup = new ButtonGroup();
        gameGroup.add(simpleGame);
        gameGroup.add(generalGame);
        simpleGame.addActionListener(this);
        generalGame.addActionListener(this);

        settings_panel.add(simpleGame, BorderLayout.NORTH);
        settings_panel.add(generalGame, BorderLayout.NORTH);
        settings_panel.add(board_size_text, BorderLayout.NORTH);
        settings_panel.add(board_size, BorderLayout.NORTH);

        board_size_text.setFont(new Font("Ink Free", Font.BOLD, 25));
        board_size_text.setHorizontalAlignment(SwingConstants.CENTER);
        board_size_text.setVerticalAlignment(SwingConstants.CENTER);
        board_size_text.setText("Board size");
        board_size.setHorizontalAlignment(SwingConstants.CENTER);
        board_size.addActionListener(this);

        board.add(welcome_panel, BorderLayout.NORTH);
        board.add(settings_panel, BorderLayout.CENTER);
    }

    public void createGame(int size) {
        gridSize = size * this.size;
        frame.setTitle("SOS");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 600);
        frame.getContentPane().setBackground(Color.CYAN);
        frame.setLayout(new BorderLayout(20, 20));
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        textfield.setBackground(Color.LIGHT_GRAY);
        textfield.setForeground(Color.BLACK);
        textfield.setFont(new Font("Ink Free", Font.BOLD, 25));
        textfield.setHorizontalAlignment(JLabel.CENTER);
        textfield.setText("SOS Game");
        textfield.setOpaque(true);

        title_panel.setLayout(new GridLayout(1, 1));
        title_panel.setBounds(0, 0, 800, 100);
        title_panel.setSize(600, 200);

        newGame = new JButton("New Game");
        newGame.addActionListener(this);

        humanBlue = new JRadioButton("Human");
        humanBlue.setSelected(true);
        humanRed = new JRadioButton("Human");
        humanRed.setSelected(true);
        compBlue = new JRadioButton("Computer");
        compRed = new JRadioButton("Computer");
        ButtonGroup bluePlayerType = new ButtonGroup();
        ButtonGroup redPlayerType = new ButtonGroup();
        bluePlayerType.add(humanBlue);
        bluePlayerType.add(compBlue);
        redPlayerType.add(humanRed);
        redPlayerType.add(compRed);
        humanBlue.addActionListener(this);
        humanRed.addActionListener(this);
        compBlue.addActionListener(this);
        compRed.addActionListener(this);

        blue_panel.setLayout(new GridLayout(0, 1, 10, 10));
        blue_player.setForeground(Color.BLUE);
        blue_player.setText("Blue");
        blue_player.setFont(new Font("Arial", Font.BOLD, 20));
        blue_panel.add(blue_player);
        if (generalGame.isSelected()) {
            blue_score.setText(String.valueOf(blueCounter));
        }
        blue_score.setForeground(Color.BLUE);
        blue_score.setFont(new Font("Arial", Font.BOLD, 20));
        blue_panel.add(blue_score);
        blue_panel.add(humanBlue);
        blue_panel.add(compBlue);

        red_panel.setLayout(new GridLayout(0, 1, 10, 10));
        red_player.setForeground(Color.RED);
        red_player.setText("Red");
        red_player.setFont(new Font("Arial", Font.BOLD, 20));
        red_panel.add(red_player);
        if (generalGame.isSelected()) {
            red_score.setText(String.valueOf(redCounter));
        }
        red_score.setForeground(Color.RED);
        red_score.setFont(new Font("Arial", Font.BOLD, 20));
        red_panel.add(red_score);
        red_panel.add(humanRed);
        red_panel.add(compRed);

        sButton = new JRadioButton("S");
        sButton.setSelected(true);
        opt = "S";
        oButton = new JRadioButton("O");
        ButtonGroup playerGroup = new ButtonGroup();
        playerGroup.add(sButton);
        playerGroup.add(oButton);
        sButton.addActionListener(this);
        oButton.addActionListener(this);

        bottom_panel.setLayout(new GridLayout(1, 2));
        bottom_panel.add(sButton);
        bottom_panel.add(oButton);
        bottom_panel.add(newGame);
        sButton.setHorizontalAlignment(SwingConstants.CENTER);
        oButton.setHorizontalAlignment(SwingConstants.CENTER);

        button_panel.setLayout(new GridLayout(size, size, 10, 10));
        button_panel.setBackground(new Color(150, 150, 150));

        buttons = new JButton[size][size];

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                buttons[i][j] = new JButton();
                buttons[i][j].setFont(new Font("MV Boli", Font.BOLD, 20));
                buttons[i][j].setFocusable(false);
                buttons[i][j].addActionListener(this);
                button_panel.add(buttons[i][j]);
                button_panel.setVisible(true);
            }
        }
        title_panel.add(textfield);

        frame.add(button_panel, BorderLayout.CENTER);
        frame.add(title_panel, BorderLayout.NORTH);
        frame.add(blue_panel, BorderLayout.WEST);
        frame.add(red_panel, BorderLayout.EAST);
        frame.add(bottom_panel, BorderLayout.SOUTH);

        firstTurn();
    }

    // Check for events

    @Override
    public void actionPerformed(ActionEvent event) {

        if (event.getSource() == board_size) {
            this.size = Integer.parseInt(board_size.getText());
            board.setVisible(false);
            createGame(size);
        }

        if (event.getSource() == newGame) {
            frame.setVisible(false);
            SOS sosGame = new SOS();
        }

        if (event.getSource() == sButton) {
            opt = "S";
        } else if (event.getSource() == oButton) {
            opt = "O";
        }

        for (int i = 0; i < this.size; i++) {
            for (int j = 0; j < this.size; j++) {
                if (event.getSource() == buttons[i][j]) {
                    int row = i;
                    int col = j;


                    makeMove(row, col, opt);
                    gameOver();
                }
            }
        }
    }

    public void makeMove(int i, int j, String opt) {

        if (humanBlue.isSelected() && humanRed.isSelected()) {
            if (playerBlue_turn) {
                if (Objects.equals(buttons[i][j].getText(), "")) {
                    buttons[i][j].setEnabled(false);
                    buttons[i][j].setForeground(Color.BLUE);
                    buttons[i][j].setText(opt);
                    getCell(i, j);
                    playerBlue_turn = false;
                    gameCounter++;
                    textfield.setText("Red turn");
                    if (Objects.equals(opt, "S")) {
                        checkS(i, j);
                    }
                    if (Objects.equals(opt, "O")) {
                        checkO(i, j);
                    }
                }
            } else {
                if (Objects.equals(buttons[i][j].getText(), "")) {
                    buttons[i][j].setEnabled(false);
                    buttons[i][j].setForeground(Color.RED);
                    buttons[i][j].setText(opt);
                    getCell(i, j);
                    playerBlue_turn = true;
                    gameCounter++;
                    textfield.setText("Blue turn");
                    if (Objects.equals(opt, "S")) {
                        checkS(i, j);
                    }
                    if (Objects.equals(opt, "O")) {
                        checkO(i, j);
                    }
                }
            }
        }

        if (compBlue.isSelected() && humanRed.isSelected()) {
            if (!playerBlue_turn) {
                redHumanMove(i, j);
            } else {
                blueComputerMove();
            }
        }

        if (compBlue.isSelected() && compRed.isSelected()) {
            if (playerBlue_turn) {
                blueComputer2Move();
            } else {
                redComputer2Move();
            }
        }


        if (humanBlue.isSelected() && compRed.isSelected()) {

            if (playerBlue_turn) {
                blueHumanMove(i, j);
            } else {
                redComputerMove();
            }
        }
    }

    public void blueHumanMove(int i, int j) {

        if (playerBlue_turn) {
            if (Objects.equals(buttons[i][j].getText(), "")) {
                buttons[i][j].setEnabled(false);
                buttons[i][j].setForeground(Color.BLUE);
                buttons[i][j].setText(opt);
                getCell(i, j);
                playerBlue_turn = false;
                gameCounter++;
                textfield.setText("Red turn");
                if (Objects.equals(opt, "S")) {
                    checkS(i, j);
                }
                if (Objects.equals(opt, "O")) {
                    checkO(i, j);
                }
                redComputerMove();
            }
        }
    }

    public void redHumanMove(int i, int j) {

        if (!playerBlue_turn) {
            if (Objects.equals(buttons[i][j].getText(), "")) {
                buttons[i][j].setEnabled(false);
                buttons[i][j].setForeground(Color.RED);
                buttons[i][j].setText(opt);
                getCell(i, j);
                playerBlue_turn = true;
                gameCounter++;
                textfield.setText("Blue turn");
                if (Objects.equals(opt, "S")) {
                    checkS(i, j);
                }
                if (Objects.equals(opt, "O")) {
                    checkO(i, j);
                }
                blueComputerMove();
            }
        }
    }

    public void blueComputerMove() {

        int biRand = blueiRand.nextInt(size);
        int bjRand = bluejRand.nextInt(size);
        String cOpt;

        if (Objects.equals(buttons[biRand][bjRand].getText(), "")) {
            String chars = "SO";
            Random rnd = new Random();
            char c = chars.charAt(rnd.nextInt(chars.length()));
            cOpt = Character.toString(c);
            buttons[biRand][bjRand].setEnabled(false);
            buttons[biRand][bjRand].setForeground(Color.BLUE);
            buttons[biRand][bjRand].setText(cOpt);
            getCell(biRand, bjRand);
            playerBlue_turn = false;
            gameCounter++;
            textfield.setText("Red turn");
            if (Objects.equals(cOpt, "S")) {
                checkS(biRand, bjRand);
            }
            if (Objects.equals(cOpt, "O")) {
                checkO(biRand, bjRand);
            }
        }
    }

    public void redComputerMove() {

        int riRand = rediRand.nextInt(size);
        int rjRand = redjRand.nextInt(size);
        String cOpt;

        if (Objects.equals(buttons[riRand][rjRand].getText(), "")) {
            String chars = "SO";
            Random rnd = new Random();
            char c = chars.charAt(rnd.nextInt(chars.length()));
            cOpt = Character.toString(c);
            buttons[riRand][rjRand].setEnabled(false);
            buttons[riRand][rjRand].setForeground(Color.RED);
            buttons[riRand][rjRand].setText(cOpt);
            getCell(riRand, rjRand);
            playerBlue_turn = true;
            gameCounter++;
            textfield.setText("Blue turn");
            if (Objects.equals(cOpt, "S")) {
                checkS(riRand, rjRand);
            }
            if (Objects.equals(cOpt, "O")) {
                checkO(riRand, rjRand);
            }
        }
    }

    public void blueComputer2Move() {
        int i;
        int j;
        int biRand = blueiRand.nextInt(size);
        int bjRand = bluejRand.nextInt(size);
        i = biRand;
        j = bjRand;
        if (Objects.equals(buttons[i][j].getText(), "")) {
            String chars = "SO";
            Random rnd = new Random();
            char c = chars.charAt(rnd.nextInt(chars.length()));
            opt = Character.toString(c);
            buttons[i][j].setEnabled(false);
            buttons[i][j].setForeground(Color.BLUE);
            buttons[i][j].setText(opt);
            getCell(i, j);
            playerBlue_turn = false;
            gameCounter++;
            textfield.setText("Red turn");
            if (Objects.equals(opt, "S")) {
                checkS(i, j);
            }
            if (Objects.equals(opt, "O")) {
                checkO(i, j);
            }
        }
        redComputer2Move();
    }

    public void redComputer2Move() {
        int i;
        int j;
        int riRand = rediRand.nextInt(size);
        int rjRand = redjRand.nextInt(size);
        i = riRand;
        j = rjRand;
        if (Objects.equals(buttons[i][j].getText(), "")) {
            String chars = "SO";
            Random rnd = new Random();
            char c = chars.charAt(rnd.nextInt(chars.length()));
            opt = Character.toString(c);
            buttons[i][j].setEnabled(false);
            buttons[i][j].setForeground(Color.RED);
            buttons[i][j].setText(opt);
            getCell(i, j);
            playerBlue_turn = true;
            gameCounter++;
            textfield.setText("Blue turn");
            if (Objects.equals(opt, "S")) {
                checkS(i, j);
            }
            if (Objects.equals(opt, "O")) {
                checkO(i, j);
            }
        }
        blueComputer2Move();
    }

    public void gameOver() {
        if (gameCounter == gridSize) {
            gameOver = true;
            for (int k = 0; k < this.size; k++) {
                for (int l = 0; l < this.size; l++) {
                    buttons[k][l].setEnabled(false);
                }
            }
        }
    }

    // Randomizer to decide who goes first
    public void firstTurn() {

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        if (random.nextInt(2) == 0) {
            playerBlue_turn = true;
            textfield.setText("Blue turn");
        } else {
            playerBlue_turn = false;
            textfield.setText("Red turn");
        }
    }
}
