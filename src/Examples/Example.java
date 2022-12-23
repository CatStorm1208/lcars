package Examples;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.Objects;

public class Example
{
    JFrame f = new JFrame();
    JButton b = new JButton();
    Image img;

    public void main()
    {
        f.setExtendedState(JFrame.MAXIMIZED_BOTH);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setLayout(null);
        f.setVisible(true);
        b.setBounds((f.getWidth() - 200)/2,(f.getHeight() - 80)/2 ,100, 40);
        b.setText("Sussy");
        b.addActionListener(new ExampleAction());
        try
        {
            img = ImageIO.read(Objects.requireNonNull(getClass().getResource("ExampleImage.png")));
            b.setIcon(new ImageIcon(img));
        }
        catch (IOException e)
        {
            throw new RuntimeException(e);
        }
        f.add(b);
    }
}
