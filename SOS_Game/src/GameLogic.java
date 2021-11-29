import javax.swing.*;
import java.awt.*;
import java.util.Objects;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;


public class GameLogic {

    int blueCounter;
    int redCounter;
    int size;
    boolean gameOver = false;
    int gameCounter = 0;

    Random blueiRand = new Random();
    Random bluejRand = new Random();
    Random rediRand = new Random();
    Random redjRand = new Random();
    JLabel blue_score = new JLabel();
    JLabel red_score = new JLabel();
    JLabel textfield = new JLabel();
    JButton[][] buttons;
    JButton newGame;
    JRadioButton simpleGame, generalGame, sButton, oButton, human, computer;
    boolean playerBlue_turn;

    public void checkS(int row, int col) {

        if (row == 0 && col == 0) {
            if (
                    (Objects.equals(buttons[row + 1][col].getText(), "O")) &&
                            (Objects.equals(buttons[row + 2][col].getText(), "S")) &&
                            !playerBlue_turn) {
                blueWins(row, col);
            }
            if (
                    (Objects.equals(buttons[row + 1][col + 1].getText(), "O")) &&
                            (Objects.equals(buttons[row + 2][col + 2].getText(), "S")) &&
                            !playerBlue_turn) {
                blueWins(row, col);
            }
            if (
                    (Objects.equals(buttons[row][col + 1].getText(), "O")) &&
                            (Objects.equals(buttons[row][col + 2].getText(), "S")) &&
                            !playerBlue_turn) {
                blueWins(row, col);
            }
            if (
                    (Objects.equals(buttons[row + 1][col].getText(), "O")) &&
                            (Objects.equals(buttons[row + 2][col].getText(), "S")) &&
                            playerBlue_turn) {
                redWins(row, col);
            }
            if (
                    (Objects.equals(buttons[row + 1][col + 1].getText(), "O")) &&
                            (Objects.equals(buttons[row + 2][col + 2].getText(), "S")) &&
                            playerBlue_turn) {
                redWins(row, col);
            }
            if (
                    (Objects.equals(buttons[row][col + 1].getText(), "O")) &&
                            (Objects.equals(buttons[row][col + 2].getText(), "S")) &&
                            playerBlue_turn) {
                redWins(row, col);
            }

        }

        if (row == 0 && col > 0 && col < size - 1) {
            if (
                    (Objects.equals(buttons[row][col - 1].getText(), "O")) &&
                            (Objects.equals(buttons[row][col - 2].getText(), "S")) &&
                            !playerBlue_turn) {
                blueWins(row, col);
            }
            if (
                    (Objects.equals(buttons[row][col + 1].getText(), "O")) &&
                            (Objects.equals(buttons[row][col + 2].getText(), "S")) &&
                            !playerBlue_turn) {
                blueWins(row, col);
            }
            if (
                    (Objects.equals(buttons[row + 1][col].getText(), "O")) &&
                            (Objects.equals(buttons[row + 2][col].getText(), "S")) &&
                            !playerBlue_turn) {
                blueWins(row, col);
            }
            if (
                    (Objects.equals(buttons[row + 1][col + 1].getText(), "O")) &&
                            (Objects.equals(buttons[row + 2][col + 2].getText(), "S")) &&
                            !playerBlue_turn) {
                blueWins(row, col);
            }
            if (
                    (Objects.equals(buttons[row + 1][col - 1].getText(), "O")) &&
                            (Objects.equals(buttons[row + 2][col - 2].getText(), "S")) &&
                            !playerBlue_turn) {
                blueWins(row, col);
            }
            if (
                    (Objects.equals(buttons[row][col - 1].getText(), "O")) &&
                            (Objects.equals(buttons[row][col - 2].getText(), "S")) &&
                            playerBlue_turn) {
                redWins(row, col);
            }
            if (
                    (Objects.equals(buttons[row][col + 1].getText(), "O")) &&
                            (Objects.equals(buttons[row][col + 2].getText(), "S")) &&
                            playerBlue_turn) {
                redWins(row, col);
            }
            if (
                    (Objects.equals(buttons[row + 1][col].getText(), "O")) &&
                            (Objects.equals(buttons[row + 2][col].getText(), "S")) &&
                            playerBlue_turn) {
                redWins(row, col);
            }
            if (
                    (Objects.equals(buttons[row + 1][col + 1].getText(), "O")) &&
                            (Objects.equals(buttons[row + 2][col + 2].getText(), "S")) &&
                            playerBlue_turn) {
                redWins(row, col);
            }
            if (
                    (Objects.equals(buttons[row + 1][col - 1].getText(), "O")) &&
                            (Objects.equals(buttons[row + 2][col - 2].getText(), "S")) &&
                            playerBlue_turn) {
                redWins(row, col);
            }
        }

        if (row == 0 && col == size - 1) {
            if (
                    (Objects.equals(buttons[row + 1][col].getText(), "O")) &&
                            (Objects.equals(buttons[row + 2][col].getText(), "S")) &&
                            !playerBlue_turn) {
                blueWins(row, col);
            }
            if (
                    (Objects.equals(buttons[row][col - 1].getText(), "O")) &&
                            (Objects.equals(buttons[row][col - 2].getText(), "S")) &&
                            !playerBlue_turn) {
                blueWins(row, col);
            }
            if (
                    (Objects.equals(buttons[row + 1][col - 1].getText(), "O")) &&
                            (Objects.equals(buttons[row + 2][col - 2].getText(), "S")) &&
                            !playerBlue_turn) {
                blueWins(row, col);
            }
            if (
                    (Objects.equals(buttons[row + 1][col].getText(), "O")) &&
                            (Objects.equals(buttons[row + 2][col].getText(), "S")) &&
                            playerBlue_turn) {
                redWins(row, col);
            }
            if (
                    (Objects.equals(buttons[row][col - 1].getText(), "O")) &&
                            (Objects.equals(buttons[row][col - 2].getText(), "S")) &&
                            playerBlue_turn) {
                redWins(row, col);
            }
            if (
                    (Objects.equals(buttons[row + 1][col - 1].getText(), "O")) &&
                            (Objects.equals(buttons[row + 2][col - 2].getText(), "S")) &&
                            playerBlue_turn) {
                redWins(row, col);
            }
        }

        if (row > 0 && row < size - 1 && col == 0) {
            if (
                    (Objects.equals(buttons[row - 1][col].getText(), "O")) &&
                            (Objects.equals(buttons[row - 2][col].getText(), "S")) &&
                            !playerBlue_turn) {
                blueWins(row, col);
            }
            if (
                    (Objects.equals(buttons[row + 1][col].getText(), "O")) &&
                            (Objects.equals(buttons[row + 2][col].getText(), "S")) &&
                            !playerBlue_turn) {
                blueWins(row, col);
            }
            if (
                    (Objects.equals(buttons[row][col + 1].getText(), "O")) &&
                            (Objects.equals(buttons[row][col + 2].getText(), "S")) &&
                            !playerBlue_turn) {
                blueWins(row, col);
            }
            if (
                    (Objects.equals(buttons[row - 1][col + 1].getText(), "O")) &&
                            (Objects.equals(buttons[row - 2][col + 2].getText(), "S")) &&
                            !playerBlue_turn) {
                blueWins(row, col);
            }
            if (
                    (Objects.equals(buttons[row + 1][col + 1].getText(), "O")) &&
                            (Objects.equals(buttons[row + 2][col + 2].getText(), "S")) &&
                            !playerBlue_turn) {
                blueWins(row, col);
            }
            if (
                    (Objects.equals(buttons[row - 1][col].getText(), "O")) &&
                            (Objects.equals(buttons[row - 2][col].getText(), "S")) &&
                            playerBlue_turn) {
                redWins(row, col);
            }
            if (
                    (Objects.equals(buttons[row + 1][col].getText(), "O")) &&
                            (Objects.equals(buttons[row + 2][col].getText(), "S")) &&
                            playerBlue_turn) {
                redWins(row, col);
            }
            if (
                    (Objects.equals(buttons[row][col + 1].getText(), "O")) &&
                            (Objects.equals(buttons[row][col + 2].getText(), "S")) &&
                            playerBlue_turn) {
                redWins(row, col);
            }
            if (
                    (Objects.equals(buttons[row - 1][col + 1].getText(), "O")) &&
                            (Objects.equals(buttons[row - 2][col + 2].getText(), "S")) &&
                            playerBlue_turn) {
                redWins(row, col);
            }
            if (
                    (Objects.equals(buttons[row + 1][col + 1].getText(), "O")) &&
                            (Objects.equals(buttons[row + 2][col + 2].getText(), "S")) &&
                            playerBlue_turn) {
                redWins(row, col);
            }
        }

        if (row == size - 1 && col == 0) {
            if (
                    (Objects.equals(buttons[row - 1][col].getText(), "O")) &&
                            (Objects.equals(buttons[row - 2][col].getText(), "S")) &&
                            !playerBlue_turn) {
                blueWins(row, col);
            }
            if (
                    (Objects.equals(buttons[row][col + 1].getText(), "O")) &&
                            (Objects.equals(buttons[row][col + 2].getText(), "S")) &&
                            !playerBlue_turn) {
                blueWins(row, col);
            }
            if (
                    (Objects.equals(buttons[row - 1][col + 1].getText(), "O")) &&
                            (Objects.equals(buttons[row - 2][col + 2].getText(), "S")) &&
                            !playerBlue_turn) {
                blueWins(row, col);
            }
            if (
                    (Objects.equals(buttons[row - 1][col].getText(), "O")) &&
                            (Objects.equals(buttons[row - 2][col].getText(), "S")) &&
                            playerBlue_turn) {
                redWins(row, col);
            }
            if (
                    (Objects.equals(buttons[row][col + 1].getText(), "O")) &&
                            (Objects.equals(buttons[row][col + 2].getText(), "S")) &&
                            playerBlue_turn) {
                redWins(row, col);
            }
            if (
                    (Objects.equals(buttons[row - 1][col + 1].getText(), "O")) &&
                            (Objects.equals(buttons[row - 2][col + 2].getText(), "S")) &&
                            playerBlue_turn) {
                redWins(row, col);
            }
        }

        if (row == size - 1 && col > 0 && col < size - 1) {
            if (
                    (Objects.equals(buttons[row - 1][col].getText(), "O")) &&
                            (Objects.equals(buttons[row - 2][col].getText(), "S")) &&
                            !playerBlue_turn) {
                blueWins(row, col);
            }
            if (
                    (Objects.equals(buttons[row][col - 1].getText(), "O")) &&
                            (Objects.equals(buttons[row][col - 2].getText(), "S")) &&
                            !playerBlue_turn) {
                blueWins(row, col);
            }
            if (
                    (Objects.equals(buttons[row][col + 1].getText(), "O")) &&
                            (Objects.equals(buttons[row][col + 2].getText(), "S")) &&
                            !playerBlue_turn) {
                blueWins(row, col);
            }
            if (
                    (Objects.equals(buttons[row - 1][col - 1].getText(), "O")) &&
                            (Objects.equals(buttons[row - 2][col - 2].getText(), "S")) &&
                            !playerBlue_turn) {
                blueWins(row, col);
            }
            if (
                    (Objects.equals(buttons[row - 1][col + 1].getText(), "O")) &&
                            (Objects.equals(buttons[row - 2][col + 2].getText(), "S")) &&
                            !playerBlue_turn) {
                blueWins(row, col);
            }
            if (
                    (Objects.equals(buttons[row - 1][col].getText(), "O")) &&
                            (Objects.equals(buttons[row - 2][col].getText(), "S")) &&
                            playerBlue_turn) {
                redWins(row, col);
            }
            if (
                    (Objects.equals(buttons[row][col - 1].getText(), "O")) &&
                            (Objects.equals(buttons[row][col - 2].getText(), "S")) &&
                            playerBlue_turn) {
                redWins(row, col);
            }
            if (
                    (Objects.equals(buttons[row][col + 1].getText(), "O")) &&
                            (Objects.equals(buttons[row][col + 2].getText(), "S")) &&
                            playerBlue_turn) {
                redWins(row, col);
            }
            if (
                    (Objects.equals(buttons[row - 1][col - 1].getText(), "O")) &&
                            (Objects.equals(buttons[row - 2][col - 2].getText(), "S")) &&
                            playerBlue_turn) {
                redWins(row, col);
            }
            if (
                    (Objects.equals(buttons[row - 1][col + 1].getText(), "O")) &&
                            (Objects.equals(buttons[row - 2][col + 2].getText(), "S")) &&
                            playerBlue_turn) {
                redWins(row, col);
            }
        }

        if (row > 0 && row < size - 1 && col == size - 1) {
            if (
                    (Objects.equals(buttons[row - 1][col].getText(), "O")) &&
                            (Objects.equals(buttons[row - 2][col].getText(), "S")) &&
                            !playerBlue_turn) {
                blueWins(row, col);
            }
            if (
                    (Objects.equals(buttons[row + 1][col].getText(), "O")) &&
                            (Objects.equals(buttons[row + 2][col].getText(), "S")) &&
                            !playerBlue_turn) {
                blueWins(row, col);
            }
            if (
                    (Objects.equals(buttons[row][col - 1].getText(), "O")) &&
                            (Objects.equals(buttons[row][col - 2].getText(), "S")) &&
                            !playerBlue_turn) {
                blueWins(row, col);
            }
            if (
                    (Objects.equals(buttons[row + 1][col - 1].getText(), "O")) &&
                            (Objects.equals(buttons[row + 2][col - 2].getText(), "S")) &&
                            !playerBlue_turn) {
                blueWins(row, col);
            }
            if (
                    (Objects.equals(buttons[row - 1][col - 1].getText(), "O")) &&
                            (Objects.equals(buttons[row - 2][col - 2].getText(), "S")) &&
                            !playerBlue_turn) {
                blueWins(row, col);
            }
            if (
                    (Objects.equals(buttons[row - 1][col].getText(), "O")) &&
                            (Objects.equals(buttons[row - 2][col].getText(), "S")) &&
                            playerBlue_turn) {
                redWins(row, col);
            }
            if (
                    (Objects.equals(buttons[row + 1][col].getText(), "O")) &&
                            (Objects.equals(buttons[row + 2][col].getText(), "S")) &&
                            playerBlue_turn) {
                redWins(row, col);
            }
            if (
                    (Objects.equals(buttons[row][col - 1].getText(), "O")) &&
                            (Objects.equals(buttons[row][col - 2].getText(), "S")) &&
                            playerBlue_turn) {
                redWins(row, col);
            }
            if (
                    (Objects.equals(buttons[row + 1][col - 1].getText(), "O")) &&
                            (Objects.equals(buttons[row + 2][col - 2].getText(), "S")) &&
                            playerBlue_turn) {
                redWins(row, col);
            }
            if (
                    (Objects.equals(buttons[row - 1][col - 1].getText(), "O")) &&
                            (Objects.equals(buttons[row - 2][col - 2].getText(), "S")) &&
                            playerBlue_turn) {
                redWins(row, col);
            }
        }

        if (row == size - 1 && col == size - 1) {
            if (
                    (Objects.equals(buttons[row - 1][col].getText(), "O")) &&
                            (Objects.equals(buttons[row - 2][col].getText(), "S")) &&
                            !playerBlue_turn) {
                blueWins(row, col);
            }
            if (
                    (Objects.equals(buttons[row][col - 1].getText(), "O")) &&
                            (Objects.equals(buttons[row][col - 2].getText(), "S")) &&
                            !playerBlue_turn) {
                blueWins(row, col);
            }
            if (
                    (Objects.equals(buttons[row - 1][col - 1].getText(), "O")) &&
                            (Objects.equals(buttons[row - 2][col - 2].getText(), "S")) &&
                            !playerBlue_turn) {
                blueWins(row, col);
            }
            if (
                    (Objects.equals(buttons[row - 1][col].getText(), "O")) &&
                            (Objects.equals(buttons[row - 2][col].getText(), "S")) &&
                            playerBlue_turn) {
                redWins(row, col);
            }
            if (
                    (Objects.equals(buttons[row][col - 1].getText(), "O")) &&
                            (Objects.equals(buttons[row][col - 2].getText(), "S")) &&
                            playerBlue_turn) {
                redWins(row, col);
            }
            if (
                    (Objects.equals(buttons[row - 1][col - 1].getText(), "O")) &&
                            (Objects.equals(buttons[row - 2][col - 2].getText(), "S")) &&
                            playerBlue_turn) {
                redWins(row, col);
            }
        }

        if (row == 1 && col == 1) {
            if (
                    (Objects.equals(buttons[row + 1][col].getText(), "O")) &&
                            (Objects.equals(buttons[row + 2][col].getText(), "S")) &&
                            !playerBlue_turn) {
                blueWins(row, col);
            }
            if (
                    (Objects.equals(buttons[row][col + 1].getText(), "O")) &&
                            (Objects.equals(buttons[row][col + 2].getText(), "S")) &&
                            !playerBlue_turn) {
                blueWins(row, col);
            }
            if (
                    (Objects.equals(buttons[row + 1][col + 1].getText(), "O")) &&
                            (Objects.equals(buttons[row + 2][col + 2].getText(), "S")) &&
                            !playerBlue_turn) {
                blueWins(row, col);
            }
            if (
                    (Objects.equals(buttons[row + 1][col].getText(), "O")) &&
                            (Objects.equals(buttons[row + 2][col].getText(), "S")) &&
                            playerBlue_turn) {
                redWins(row, col);
            }
            if (
                    (Objects.equals(buttons[row][col + 1].getText(), "O")) &&
                            (Objects.equals(buttons[row][col + 2].getText(), "S")) &&
                            playerBlue_turn) {
                redWins(row, col);
            }
            if (
                    (Objects.equals(buttons[row + 1][col + 1].getText(), "O")) &&
                            (Objects.equals(buttons[row + 2][col + 2].getText(), "S")) &&
                            playerBlue_turn) {
                redWins(row, col);
            }
        }

        if (row > 0 && row < size - 1 && col > 0 && col < size - 1) {
            if (
                    (Objects.equals(buttons[row][col - 1].getText(), "O")) &&
                            (Objects.equals(buttons[row][col - 2].getText(), "S")) &&
                            !playerBlue_turn) {
                blueWins(row, col);
            }
            if (
                    (Objects.equals(buttons[row][col + 1].getText(), "O")) &&
                            (Objects.equals(buttons[row][col + 2].getText(), "S")) &&
                            !playerBlue_turn) {
                blueWins(row, col);
            }
            if (
                    (Objects.equals(buttons[row - 1][col].getText(), "O")) &&
                            (Objects.equals(buttons[row - 2][col].getText(), "S")) &&
                            !playerBlue_turn) {
                blueWins(row, col);
            }
            if (
                    (Objects.equals(buttons[row + 1][col].getText(), "O")) &&
                            (Objects.equals(buttons[row + 2][col].getText(), "S")) &&
                            !playerBlue_turn) {
                blueWins(row, col);
            }
            if (
                    (Objects.equals(buttons[row][col - 1].getText(), "O")) &&
                            (Objects.equals(buttons[row][col - 2].getText(), "S")) &&
                            playerBlue_turn) {
                redWins(row, col);
            }
            if (
                    (Objects.equals(buttons[row][col + 1].getText(), "O")) &&
                            (Objects.equals(buttons[row][col + 2].getText(), "S")) &&
                            playerBlue_turn) {
                redWins(row, col);
            }
            if (
                    (Objects.equals(buttons[row - 1][col].getText(), "O")) &&
                            (Objects.equals(buttons[row - 2][col].getText(), "S")) &&
                            playerBlue_turn) {
                redWins(row, col);
            }
            if (
                    (Objects.equals(buttons[row + 1][col].getText(), "O")) &&
                            (Objects.equals(buttons[row + 2][col].getText(), "S")) &&
                            playerBlue_turn) {
                redWins(row, col);
            }
        }


        if (row == 1 && col == size - 2) {
            if (
                    (Objects.equals(buttons[row + 1][col].getText(), "O")) &&
                            (Objects.equals(buttons[row + 2][col].getText(), "S")) &&
                            !playerBlue_turn) {
                blueWins(row, col);
            }
            if (
                    (Objects.equals(buttons[row][col - 1].getText(), "O")) &&
                            (Objects.equals(buttons[row][col - 2].getText(), "S")) &&
                            !playerBlue_turn) {
                blueWins(row, col);
            }
            if (
                    (Objects.equals(buttons[row + 1][col - 1].getText(), "O")) &&
                            (Objects.equals(buttons[row + 2][col - 2].getText(), "S")) &&
                            !playerBlue_turn) {
                blueWins(row, col);
            }
            if (
                    (Objects.equals(buttons[row + 1][col].getText(), "O")) &&
                            (Objects.equals(buttons[row + 2][col].getText(), "S")) &&
                            playerBlue_turn) {
                redWins(row, col);
            }
            if (
                    (Objects.equals(buttons[row][col - 1].getText(), "O")) &&
                            (Objects.equals(buttons[row][col - 2].getText(), "S")) &&
                            playerBlue_turn) {
                redWins(row, col);
            }
            if (
                    (Objects.equals(buttons[row + 1][col - 1].getText(), "O")) &&
                            (Objects.equals(buttons[row + 2][col - 2].getText(), "S")) &&
                            playerBlue_turn) {
                redWins(row, col);
            }
        }
        if (row == size - 2 && col == 1) {
            if (
                    (Objects.equals(buttons[row - 1][col].getText(), "O")) &&
                            (Objects.equals(buttons[row - 2][col].getText(), "S")) &&
                            !playerBlue_turn) {
                blueWins(row, col);
            }
            if (
                    (Objects.equals(buttons[row][col + 1].getText(), "O")) &&
                            (Objects.equals(buttons[row][col + 2].getText(), "S")) &&
                            !playerBlue_turn) {
                blueWins(row, col);
            }
            if (
                    (Objects.equals(buttons[row - 1][col + 1].getText(), "O")) &&
                            (Objects.equals(buttons[row - 2][col + 2].getText(), "S")) &&
                            !playerBlue_turn) {
                blueWins(row, col);
            }
            if (
                    (Objects.equals(buttons[row - 1][col].getText(), "O")) &&
                            (Objects.equals(buttons[row - 2][col].getText(), "S")) &&
                            playerBlue_turn) {
                redWins(row, col);
            }
            if (
                    (Objects.equals(buttons[row][col + 1].getText(), "O")) &&
                            (Objects.equals(buttons[row][col + 2].getText(), "S")) &&
                            playerBlue_turn) {
                redWins(row, col);
            }
            if (
                    (Objects.equals(buttons[row - 1][col + 1].getText(), "O")) &&
                            (Objects.equals(buttons[row - 2][col + 2].getText(), "S")) &&
                            playerBlue_turn) {
                redWins(row, col);
            }
        }
        if (row == size - 2 && col == size - 2) {
            if (
                    (Objects.equals(buttons[row][col - 1].getText(), "O")) &&
                            (Objects.equals(buttons[row][col - 2].getText(), "S")) &&
                            !playerBlue_turn) {
                blueWins(row, col);
            }
            if (
                    (Objects.equals(buttons[row - 1][col].getText(), "O")) &&
                            (Objects.equals(buttons[row - 2][col].getText(), "S")) &&
                            !playerBlue_turn) {
                blueWins(row, col);
            }
            if (
                    (Objects.equals(buttons[row - 1][col - 1].getText(), "O")) &&
                            (Objects.equals(buttons[row - 2][col - 2].getText(), "S")) &&
                            !playerBlue_turn) {
                blueWins(row, col);
            }
            if (
                    (Objects.equals(buttons[row][col - 1].getText(), "O")) &&
                            (Objects.equals(buttons[row][col - 2].getText(), "S")) &&
                            playerBlue_turn) {
                redWins(row, col);
            }
            if (
                    (Objects.equals(buttons[row - 1][col].getText(), "O")) &&
                            (Objects.equals(buttons[row - 2][col].getText(), "S")) &&
                            playerBlue_turn) {
                redWins(row, col);
            }
            if (
                    (Objects.equals(buttons[row - 1][col - 1].getText(), "O")) &&
                            (Objects.equals(buttons[row - 2][col - 2].getText(), "S")) &&
                            playerBlue_turn) {
                redWins(row, col);
            }
        }

        if (row > 1 && row < size - 2 && col > 1 && col < size - 2) {
            if (
                    (Objects.equals(buttons[row - 1][col].getText(), "O")) &&
                            (Objects.equals(buttons[row - 2][col].getText(), "S")) &&
                            !playerBlue_turn) {
                blueWins(row, col);
            }
            if (
                    (Objects.equals(buttons[row + 1][col].getText(), "O")) &&
                            (Objects.equals(buttons[row + 2][col].getText(), "S")) &&
                            !playerBlue_turn) {
                blueWins(row, col);
            }
            if (
                    (Objects.equals(buttons[row][col - 1].getText(), "O")) &&
                            (Objects.equals(buttons[row][col - 2].getText(), "S")) &&
                            !playerBlue_turn) {
                blueWins(row, col);
            }
            if (
                    (Objects.equals(buttons[row][col + 1].getText(), "O")) &&
                            (Objects.equals(buttons[row][col + 2].getText(), "S")) &&
                            !playerBlue_turn) {
                blueWins(row, col);
            }
            if (
                    (Objects.equals(buttons[row - 1][col - 1].getText(), "O")) &&
                            (Objects.equals(buttons[row - 2][col - 2].getText(), "S")) &&
                            !playerBlue_turn) {
                blueWins(row, col);
            }
            if (
                    (Objects.equals(buttons[row + 1][col + 1].getText(), "O")) &&
                            (Objects.equals(buttons[row + 2][col + 2].getText(), "S")) &&
                            !playerBlue_turn) {
                blueWins(row, col);
            }
            if (
                    (Objects.equals(buttons[row - 1][col + 1].getText(), "O")) &&
                            (Objects.equals(buttons[row - 2][col + 2].getText(), "S")) &&
                            !playerBlue_turn) {
                blueWins(row, col);
            }
            if (
                    (Objects.equals(buttons[row + 1][col - 1].getText(), "O")) &&
                            (Objects.equals(buttons[row + 2][col - 2].getText(), "S")) &&
                            !playerBlue_turn) {
                blueWins(row, col);
            }
            if (
                    (Objects.equals(buttons[row - 1][col].getText(), "O")) &&
                            (Objects.equals(buttons[row - 2][col].getText(), "S")) &&
                            playerBlue_turn) {
                redWins(row, col);
            }
            if (
                    (Objects.equals(buttons[row + 1][col].getText(), "O")) &&
                            (Objects.equals(buttons[row + 2][col].getText(), "S")) &&
                            playerBlue_turn) {
                redWins(row, col);
            }
            if (
                    (Objects.equals(buttons[row][col - 1].getText(), "O")) &&
                            (Objects.equals(buttons[row][col - 2].getText(), "S")) &&
                            playerBlue_turn) {
                redWins(row, col);
            }
            if (
                    (Objects.equals(buttons[row][col + 1].getText(), "O")) &&
                            (Objects.equals(buttons[row][col + 2].getText(), "S")) &&
                            playerBlue_turn) {
                redWins(row, col);
            }
            if (
                    (Objects.equals(buttons[row - 1][col - 1].getText(), "O")) &&
                            (Objects.equals(buttons[row - 2][col - 2].getText(), "S")) &&
                            playerBlue_turn) {
                redWins(row, col);
            }
            if (
                    (Objects.equals(buttons[row + 1][col + 1].getText(), "O")) &&
                            (Objects.equals(buttons[row + 2][col + 2].getText(), "S")) &&
                            playerBlue_turn) {
                redWins(row, col);
            }
            if (
                    (Objects.equals(buttons[row - 1][col + 1].getText(), "O")) &&
                            (Objects.equals(buttons[row - 2][col + 2].getText(), "S")) &&
                            playerBlue_turn) {
                redWins(row, col);
            }
            if (
                    (Objects.equals(buttons[row + 1][col - 1].getText(), "O")) &&
                            (Objects.equals(buttons[row + 2][col - 2].getText(), "S")) &&
                            playerBlue_turn) {
                redWins(row, col);
            }
        }

    }


    public void checkO(int row, int col) {

        if (row == 0 && col > 0) {
            if (
                    (Objects.equals(buttons[row][col - 1].getText(), "S")) &&
                            (Objects.equals(buttons[row][col + 1].getText(), "S")) &&
                            !playerBlue_turn) {
                blueWins(row, col);
            }
            if (
                    (Objects.equals(buttons[row][col - 1].getText(), "S")) &&
                            (Objects.equals(buttons[row][col + 1].getText(), "S")) &&
                            playerBlue_turn) {
                redWins(row, col);
            }
        }
        if (row > 0 && row < size - 1 && col == 0) {
            if (
                    (Objects.equals(buttons[row - 1][col].getText(), "S")) &&
                            (Objects.equals(buttons[row + 1][col].getText(), "S")) &&
                            !playerBlue_turn) {
                blueWins(row, col);
            }
            if (
                    (Objects.equals(buttons[row - 1][col].getText(), "S")) &&
                            (Objects.equals(buttons[row + 1][col].getText(), "S")) &&
                            playerBlue_turn) {
                redWins(row, col);
            }
        }
        if (row == size - 1 && col > 0 && col < size - 1) {
            if (
                    (Objects.equals(buttons[row][col - 1].getText(), "S")) &&
                            (Objects.equals(buttons[row][col + 1].getText(), "S")) &&
                            !playerBlue_turn) {
                blueWins(row, col);
            }
            if (
                    (Objects.equals(buttons[row][col - 1].getText(), "S")) &&
                            (Objects.equals(buttons[row][col + 1].getText(), "S")) &&
                            playerBlue_turn) {
                redWins(row, col);
            }
        }

        if (row > 0 && row < size - 1 && col == size - 1) {
            if (
                    (Objects.equals(buttons[row - 1][col].getText(), "S")) &&
                            (Objects.equals(buttons[row + 1][col].getText(), "S")) &&
                            !playerBlue_turn) {
                blueWins(row, col);
            }
            if (
                    (Objects.equals(buttons[row - 1][col].getText(), "S")) &&
                            (Objects.equals(buttons[row + 1][col].getText(), "S")) &&
                            playerBlue_turn) {
                redWins(row, col);
            }
        }

        if (row > 0 && row < size - 1 && col > 0 && col < size - 1) {

            if (
                    (Objects.equals(buttons[row][col - 1].getText(), "S")) &&
                            (Objects.equals(buttons[row][col + 1].getText(), "S")) &&
                            !playerBlue_turn) {
                blueWins(row, col);
            }
            if (
                    (Objects.equals(buttons[row - 1][col].getText(), "S")) &&
                            (Objects.equals(buttons[row + 1][col].getText(), "S")) &&
                            !playerBlue_turn) {
                blueWins(row, col);
            }
            if (
                    (Objects.equals(buttons[row - 1][col - 1].getText(), "S")) &&
                            (Objects.equals(buttons[row + 1][col + 1].getText(), "S")) &&
                            !playerBlue_turn) {
                blueWins(row, col);
            }
            if (
                    (Objects.equals(buttons[row - 1][col + 1].getText(), "S")) &&
                            (Objects.equals(buttons[row + 1][col - 1].getText(), "S")) &&
                            !playerBlue_turn) {
                blueWins(row, col);
            }
            if (
                    (Objects.equals(buttons[row][col - 1].getText(), "S")) &&
                            (Objects.equals(buttons[row][col + 1].getText(), "S")) &&
                            playerBlue_turn) {
                redWins(row, col);
            }
            if (
                    (Objects.equals(buttons[row - 1][col].getText(), "S")) &&
                            (Objects.equals(buttons[row + 1][col].getText(), "S")) &&
                            playerBlue_turn) {
                redWins(row, col);
            }
            if (
                    (Objects.equals(buttons[row - 1][col - 1].getText(), "S")) &&
                            (Objects.equals(buttons[row + 1][col + 1].getText(), "S")) &&
                            playerBlue_turn) {
                redWins(row, col);
            }
            if (
                    (Objects.equals(buttons[row - 1][col + 1].getText(), "S")) &&
                            (Objects.equals(buttons[row + 1][col - 1].getText(), "S")) &&
                            playerBlue_turn) {
                redWins(row, col);
            }
        }
    }

    // Winning graphics and output

    public void blueWins(int row, int col) {
        buttons[row][col].setBackground(new Color(135, 206, 250));
        if (simpleGame.isSelected()) {
            blueCounter++;
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    buttons[i][j].setEnabled(false);
                }
            }
            if (blueCounter == 1) {
                textfield.setText("Blue wins");
            } else {
                textfield.setText("Tie game");
            }
        }
        if (generalGame.isSelected()) {
            blueCounter++;
            System.out.println(size * size + " " + gameCounter);
            blue_score.setText(String.valueOf(blueCounter));
            if (gameCounter == size * size) {
                if (blueCounter == redCounter) {
                    textfield.setText("Tie game");
                }
                if (blueCounter > redCounter) {
                    textfield.setText("Blue wins");
                }
                if (blueCounter < redCounter) {
                    textfield.setText("Red wins");
                }
            }
        }
    }

    public void redWins(int row, int col) {
        buttons[row][col].setBackground(new Color(250, 128, 114));
        if (simpleGame.isSelected()) {
            redCounter++;
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    buttons[i][j].setEnabled(false);
                }
            }
            if (redCounter == 1) {
                textfield.setText("Red wins");
            } else {
                textfield.setText("Tie Game");
            }
        }
        if (generalGame.isSelected()) {
            redCounter++;
            System.out.println(size * size + " " + gameCounter);

            red_score.setText(String.valueOf(redCounter));
            if (gameCounter == size * size) {
                if (redCounter == blueCounter) {
                    textfield.setText("Tie game");
                }
                if (redCounter > blueCounter) {
                    textfield.setText("Red wins");
                }
                if (redCounter < blueCounter) {
                    textfield.setText("Blue wins");
                }

            }
        }
    }

    public Object getCell(int i, int j) {

        int row = i;
        int col = j;

        String opt = buttons[row][col].getText();
        System.out.println(opt + " " + row + " " + col);
        return opt;
    }

}
