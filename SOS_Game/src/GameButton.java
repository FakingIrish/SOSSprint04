import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.function.Consumer;

public class GameButton extends JButton {
    private final int pos;

    public GameButton(int pos, Consumer<GameButton> onClick) {
        setFont(new Font("MV Boli",Font.BOLD,40));
        setFocusable(false);
        this.pos = pos;
        addActionListener(e -> {
            onClick.accept(this);
        });
    }

    public int getPos() {
        return pos;
    }

    public boolean isS() {
        return getText().equals("S");
    }
    public boolean isO() {
        return getText().equals("O");
    }
}
