package InterfaceHotel;
import java.awt.*;
import javax.swing.*;

import com.java.india.Hotel;

import java.awt.event.*;
public class Pageprincipale  extends JFrame implements ActionListener{
	
	private JButton[] buttons;
	JLabel l1;
    public Pageprincipale() {
    	setTitle("HOTEL ENSAM");
    	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    setSize(screenSize.width, screenSize.height);
    setExtendedState(JFrame.MAXIMIZED_BOTH);
    //setResizable(false);

    l1 = new JLabel("");
    LayoutManager box = new BoxLayout(l1, BoxLayout.Y_AXIS);
	l1.setLayout(box);
	
	ImageIcon i1  = new ImageIcon(getClass().getResource("hvdjv.jpg"));
    Image i3 = i1.getImage().getScaledInstance(1600,900,Image.SCALE_SMOOTH);
    ImageIcon i2 = new ImageIcon(i3);
    l1 = new JLabel(i2);
    
    String[] buttonNames = {
            "Ajouter client", "Consulter Client", "Ajouter chambre", "Consulter chambre",
            "Ajouter réservation", "Consulter réservation", "Consulter occupation",
            "Check-in", "Check-out"
    };

    buttons = new JButton[buttonNames.length];
    int a = 250;
    for (int i = 0; i < buttonNames.length; i++) {
        buttons[i] = new JButton(buttonNames[i]);
        buttons[i].setBackground(Color.WHITE);
        buttons[i].setForeground(Color.BLACK);
        buttons[i].setBounds(600,a,300,40);
        l1.add(buttons[i]);
        buttons[i].addActionListener(this);
        a+=50;
    }
    add(l1);
   
}
    public void actionPerformed(ActionEvent e){
    	if (((JButton) e.getSource()).getText() == "Ajouter client"){
    		this.setVisible(true);
            new AddClient().setVisible(true);}
        else if (((JButton) e.getSource()).getText() == "Consulter Client"){
    	this.setVisible(true);
    	 Hotel h = new Hotel();
    	 new ConsulterClient().setVisible(true);}
    	else if (((JButton) e.getSource()).getText() == "Ajouter chambre"){
    	this.setVisible(true);
         new ajouterChambre().setVisible(true);}
    	else if (((JButton) e.getSource()).getText() == "Consulter chambre"){
        this.setVisible(true);
         new ChercherChambre().setVisible(true);}
    	else if (((JButton) e.getSource()).getText() == "Ajouter réservation"){
    	  this.setVisible(true);
            new AjouterReservation().setVisible(true);}
    	else if (((JButton) e.getSource()).getText() == "Consulter réservation"){
    		this.setVisible(true);
            new ConsulterReservation().setVisible(true);}
    	else if (((JButton) e.getSource()).getText() == "Consulter occupation"){
    		this.setVisible(true);
            new ConsulterOccupation().setVisible(true);}
    	else if (((JButton) e.getSource()).getText() == "Check-in"){
    		this.setVisible(true);
            new Checkin().setVisible(true);}
    	else if (((JButton) e.getSource()).getText() == "Check-out"){
    		this.setVisible(true);
            new Checkout().setVisible(true);}
    	
        }
 
    


public static void main(String[] args) {
    Pageprincipale window = new Pageprincipale();
    window.setVisible(true);	
   
}
}

