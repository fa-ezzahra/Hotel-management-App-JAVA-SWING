package InterfaceHotel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.*;
public class AjouterReservation extends JFrame {
	
	public void dataLabel(String s,int a,int b,int c,int d) {
		setLayout(null);
		JLabel l = new JLabel(s);
		l.setBounds(a,b,c,d);
		add(l);
		JTextField t = new JTextField();
		t.setName(s.trim());
		t.setBounds(a+70,b,c,d);
		add(t);
	}
	private String getTextFieldValue(String label) {
	    Component[] components = getContentPane().getComponents();
	    for (Component component : components) {
	        if (component instanceof JTextField && label.equals(((JTextField) component).getName())) {
	            return ((JTextField) component).getText();
	        }
	    }
	    return "";
	}
	


	 private void saveReservationData() throws IOException {
	        String idr =getTextFieldValue("ID"); 
	        String id = getTextFieldValue("ID Client");
	        String chambre = getTextFieldValue("ID chambre");
	        String date = getTextFieldValue("Date");
	        String nbjours = getTextFieldValue("Nb de jours");
	        


	        if (id.isEmpty() || chambre.isEmpty() || date.isEmpty() || nbjours.isEmpty() || idr.isEmpty() ) {
	            JOptionPane.showMessageDialog(this, "Veuillez remplir tous les champs", "Erreur", JOptionPane.ERROR_MESSAGE);
	            return;
	        }

	        
	        BufferedWriter bw = new BufferedWriter(new FileWriter("reservation.txt", true));

	     
	        bw.write("ID reservation: " + idr +"\tID Client: " + id + "\tID chambre: " + chambre + "\tDate: " + date + "\tNb de jours: " + nbjours );
	        bw.newLine();

	        
	        bw.close();

	        JOptionPane.showMessageDialog(this, "Reservatoin ajoutée avec succès", "Succès", JOptionPane.INFORMATION_MESSAGE);
	    }
	
	
	
	public  AjouterReservation() {
		JLabel l = new JLabel("Nouvelle Reservation");
		l.setBounds(160,13,260,100);
		l.setFont(new Font(null, Font.BOLD,20));
		add(l);
		dataLabel("ID",90,100,150,30);
		dataLabel("ID Client",90,150,150, 30);
		dataLabel("ID chambre ",90,200,150, 30);
		dataLabel("Date  ",90,250,150, 30);
		dataLabel("Nb de jours ",90,300,150, 30);
		
		
		
		JButton aj = new JButton("Ajouter");
		aj.setBackground(Color.BLACK);
		aj.setForeground(Color.WHITE);
		aj.setBounds(50,360,150,30);
		add(aj);
		aj.addActionListener(new ActionListener() {
            
            public void actionPerformed(ActionEvent e) {
                
              try {
				saveReservationData();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
               
            }
        });
		
		JButton rt = new JButton("Retour");
		rt.setBackground(Color.BLACK);
		rt.setForeground(Color.WHITE);
		rt.setBounds(255,360,150,30);
		add(rt);
        rt.addActionListener(new ActionListener() {
            
            public void actionPerformed(ActionEvent e) {
                
            	dispose();
				
				}
			
        });
		
		ImageIcon i = new ImageIcon("Reservation-dhotel-au-Maroc.jpg");
		Image m = i.getImage().getScaledInstance(400, 350, Image.SCALE_SMOOTH);
		ImageIcon lm =new ImageIcon(m);
		JLabel li = new JLabel(i);
		li.setIcon(lm);
		li.setBounds(500,20,400,350);
		add(li);
		
		setBounds(300,250,1000, 450);
		setTitle("ENSAM Hotel");
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setVisible(true);
		
	}

	

	public static void main(String[] args) {
		new AjouterReservation();
		
	}

}

