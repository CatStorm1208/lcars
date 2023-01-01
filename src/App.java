import Examples.*;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.Objects;

public class App
{
    JFrame f = new JFrame();
    JButton b = new JButton();
    JTextField starDateText = new JTextField();
    Image img;
    Stardate stardate = new Stardate();

    public void main()
    {
        f.setExtendedState(JFrame.MAXIMIZED_BOTH);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.getContentPane().setBackground(Color.black);
        f.setLayout(null);
        f.setVisible(true);
        sussyButton();
        stardateDisplay();
        f.add(starDateText);
        //f.add(b);
    }

    void sussyButton()
    {
        b.setBackground(Color.black);
        b.setBorder(BorderFactory.createEmptyBorder());
        b.setBounds((f.getWidth() - 180)/2,(f.getHeight() - 70)/2 ,180, 70);
        b.addActionListener(new ExampleAction());
        try
        {
            img = ImageIO.read(Objects.requireNonNull(getClass().getResource("Resources/Sussylcars.png")));
            b.setIcon(new ImageIcon(img));
        }
        catch (IOException e)
        {
            throw new RuntimeException(e);
        }
    }

    void stardateDisplay()
    {
        starDateText.setText(stardate.toString());
        starDateText.setBorder(BorderFactory.createEmptyBorder());
        starDateText.setBackground(Color.black);
        starDateText.setBounds((f.getWidth() - 180)/2,(f.getHeight() - 70)/2, 180, 70);
    }
}