import javax.swing.*;

public class Example
{
        JFrame f = new JFrame();
        JButton b = new JButton();

        void main()
        {
            b.setBounds(130, 100, 100, 40);
            f.add(b);
            f.setSize(400,500);
            f.setLayout(null);
            f.setVisible(true);
        }
}
