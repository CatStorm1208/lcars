import Examples.*;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URL;
import java.util.Objects;

//This class contains the main frame
public class App
{
    public static JFrame f = new JFrame();
    JButton b = new JButton();
    JTextField starDateText = new JTextField();
    Stardate stardate = new Stardate();

    public void main() throws Exception
    {
        URL fontURL = new URL("https://github.com/CatStorm1208/lcars/blob/4350329c5b3c976a0fec64c79b3572582ee312a8/src/Resources/LCARSGTJ3.ttf?raw=true");
        Font lcarsFont = Font.createFont(Font.TRUETYPE_FONT, fontURL.openStream());
        f.setExtendedState(JFrame.MAXIMIZED_BOTH);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.getContentPane().setBackground(Color.black);
        f.setLayout(null);
        f.setVisible(true);
        stardateDisplay(lcarsFont);
        f.add(starDateText);
        b.setBackground(Color.black);
        b.setBorder(BorderFactory.createEmptyBorder());
        b.setBounds((f.getWidth() - 360)/2,(f.getHeight() - 130)/2 ,180, 70);
        b.addActionListener(new Transition(Menu.example));
        b.setText("Sus");
        b.setForeground(Color.WHITE);
        f.add(b);
    }

    void stardateDisplay(Font _f)
    {
        //TODO make the font actually work
        //TODO copyright symbol for used font
        //starDateText.setFont(_f);
        starDateText.setSize(300,300);
        starDateText.setText(Integer.toString(stardate.stardate()));
        starDateText.setBorder(BorderFactory.createEmptyBorder());
        starDateText.setBackground(Color.black);
        starDateText.setForeground(new Color(255, 204, 102));
        starDateText.setBounds((f.getWidth() - 180)/2,(f.getHeight() - 70)/2, 180, 70);
    }
}

class Transition implements ActionListener
{
    Menu nextMenu;
    static App app = new App();
    static Example example = new Example();

    public Transition(Menu m)
    {
        nextMenu = m;
    }

    public void actionPerformed(ActionEvent e)
    {
        App.f.setVisible(false);
        App.f.setEnabled(false);
        switch (nextMenu)
        {
            case main -> {
                try
                {
                    app.main();
                }
                catch (Exception ex)
                {
                    throw new RuntimeException(ex);
                }
            }
            case example -> example.main();
        }
    }
}