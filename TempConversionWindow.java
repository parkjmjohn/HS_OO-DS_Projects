
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TempConversionWindow extends JFrame implements ActionListener{
    private Container pane;
    private JLabel j;
    private JTextField t;

    public TempConversionWindow(){
        this.setTitle("Temperature Conversion");
        this.setSize(600,400);
        this.setLocation(100,100);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);


    pane = this.getContentPane();
    pane.setLayout(new BoxLayout(pane, BoxLayout.Y_AXIS));

    t = new JTextField(20);

    JButton b = new JButton("toC");
    b.addActionListener(this);
    b.setActionCommand("toC");
    JButton b2 = new JButton("toF");
    b2.addActionListener(this);
    b2.setActionCommand("toF");

    j = new JLabel("Converted: ");

    pane.add(t);
    pane.add(b);
    pane.add(b2);
    pane.add(j);
    }

    public void actionPerformed(ActionEvent e){
        String event = e.getActionCommand();
        try{
            int temp = Integer.parseInt(t.getText());
            if(event.equals("toC")){
                j.setText(""+ ((temp-32)*(5.0/9.0)) );
            }
            if(event.equals("toF")){
                j.setText("" + (temp*(9.0/5.0)+32));
            }
        }
        catch(NumberFormatException a){
            j.setText("Invalid Temperature Found");
        }
    }
}
