import Examples.*;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.net.URL;
import java.util.Objects;

//This class contains the main frame
public class App
{
    JFrame f = new JFrame();
    JButton b = new JButton();
    JTextField starDateText = new JTextField();
    Image img;
    Stardate stardate = new Stardate();

    public void main()throws Exception
    {
        URL fontURL = new URL("https://github.com/CatStorm1208/lcars/blob/4350329c5b3c976a0fec64c79b3572582ee312a8/src/Resources/LCARSGTJ3.ttf");
        Font lcarsFont = Font.createFont(Font.TRUETYPE_FONT, fontURL.openStream());
        f.setExtendedState(JFrame.MAXIMIZED_BOTH);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.getContentPane().setBackground(Color.black);
        f.setLayout(null);
        f.setVisible(true);
        sussyButton();
        stardateDisplay(lcarsFont);
        f.add(starDateText);
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

    void stardateDisplay(Font _f)
    {
        //TODO make the font actually work
        //TODO copyright symbol for used font
        starDateText.setFont(_f);
        starDateText.setSize(100,100);
        starDateText.setText(Integer.toString(stardate.stardate()));
        starDateText.setBorder(BorderFactory.createEmptyBorder());
        starDateText.setBackground(Color.black);
        starDateText.setForeground(new Color(255, 204, 102));
        starDateText.setBounds((f.getWidth() - 180)/2,(f.getHeight() - 70)/2, 180, 70);
    }
}