package InterfaceHotel;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public   class Ensamhotel  extends JFrame implements ActionListener{

                JLabel l1;
                JButton b1;
        
                public Ensamhotel () {
		
                setSize(516,700);     
                setLayout(null);
                setLocation(500,150);

		        l1 = new JLabel("");
                b1 = new JButton("Ouvrir");
                
                b1.setBackground(Color.WHITE);
                b1.setForeground(Color.BLACK);
				
                
                
              
                ImageIcon i1  = new ImageIcon(getClass().getResource("107320.jpg"));
                Image i3 = i1.getImage().getScaledInstance(508, 700, Image.SCALE_SMOOTH);
                ImageIcon i2 = new ImageIcon(i3);
                l1 = new JLabel(i2);
 
                
                
                b1.setBounds(400,600,80,40);
		        l1.setBounds(0, 0, 500,700);
                
                l1.add(b1);
		        add(l1);
 
                b1.addActionListener(this);
                setVisible(true);
                setResizable(false);
                setTitle("HOTEL ENSAM");
                
               
	}
        
        public void actionPerformed(ActionEvent ae){
                new Login().setVisible(true);
                this.setVisible(false);}
                
        
        
        public static void main(String[] args) {
                Ensamhotel window = new Ensamhotel();
                window.setVisible(true);	
               
	}
}

