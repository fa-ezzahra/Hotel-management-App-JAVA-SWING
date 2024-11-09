package InterfaceHotel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.*;
public class Checkout extends JFrame {
	
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
	
	
	private void deleteoccupation() {
		String idr =getTextFieldValue("ID");
	    String id = getTextFieldValue("ID Client");
	    String chambre = getTextFieldValue("ID chambre");
	    String date = getTextFieldValue("Date");
	    String nbjours = getTextFieldValue("Nb de jours");

	    if (id.isEmpty() || chambre.isEmpty() || date.isEmpty() || nbjours.isEmpty() || idr.isEmpty() ) {
	        JOptionPane.showMessageDialog(this, "Veuillez remplir tous les champs", "Erreur", JOptionPane.ERROR_MESSAGE);
	        return;
	    }

	    try {
	        File inputFile = new File("occupation.txt");
	        File tempFile = new File("tempOccupation.txt");

	        BufferedReader reader = new BufferedReader(new FileReader(inputFile));
	        BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));

	        String lineToRemove ="ID reservation: " + idr +"\tID Client: " + id + "\tID chambre: " + chambre + "\tDate: " + date + "\tNb de jours: " + nbjours;

	        String currentLine;
	        boolean found = false;

	        while ((currentLine = reader.readLine()) != null) {
	            if (currentLine.equals(lineToRemove)) {
	                found = true;
	                continue;
	            }
	            writer.write(currentLine + System.getProperty("line.separator"));
	        }

	        writer.close();
	        reader.close();

	        if (found) {
	            if (!inputFile.delete()) {
	                JOptionPane.showMessageDialog(this, "Erreur lors de la suppression de l'occupation", "Erreur", JOptionPane.ERROR_MESSAGE);
	                return;
	            }
	            if (!tempFile.renameTo(inputFile)) {
	                JOptionPane.showMessageDialog(this, "Erreur lors de la modification de l'occupation", "Erreur", JOptionPane.ERROR_MESSAGE);
	                return;
	            }
	           
    	        //changer l'etat de le chambre
    	        File chambresFile = new File("chambres.txt");
    	        File tempChambresFile = new File("tempChambres.txt");

    	        BufferedReader lreader = new BufferedReader(new FileReader(chambresFile));
    	        BufferedWriter lwriter = new BufferedWriter(new FileWriter(tempChambresFile));

    	        String lineToUpdate = "Numero: " + chambre;

    	        String lcurrentLine;
    	        boolean founds = false;

    	        while ((lcurrentLine = lreader.readLine()) != null) {
    	            if (lcurrentLine.startsWith(lineToUpdate)) {
    	                founds = true;
    	                // Replace "occupée" with "disponible"
    	                lcurrentLine = lcurrentLine.replace("occupee", "disponible");
    	            }
    	            lwriter.write(lcurrentLine + System.getProperty("line.separator"));
    	        }

    	        lwriter.close();
    	        lreader.close();

    	        if (found) {
    	            if (!chambresFile.delete()) {
    	                JOptionPane.showMessageDialog(this, "Erreur lors de la suppression du fichier chambres.txt", "Erreur", JOptionPane.ERROR_MESSAGE);
    	                return;
    	            }
    	            if (!tempChambresFile.renameTo(chambresFile)) {
    	                JOptionPane.showMessageDialog(this, "Erreur lors de la modification du fichier chambres.txt", "Erreur", JOptionPane.ERROR_MESSAGE);
    	                return;
    	            }

    	            JOptionPane.showMessageDialog(this, "Occupation supprimée avec succès et chambre marquée comme disponible", "Succès", JOptionPane.INFORMATION_MESSAGE);
    	        } else {
    	            JOptionPane.showMessageDialog(this, "La chambre spécifiée n'a pas été trouvée dans le fichier chambres.txt", "Erreur", JOptionPane.ERROR_MESSAGE);
    	        }
	           // JOptionPane.showMessageDialog(this, "Occupation supprimée avec succès", "Succès", JOptionPane.INFORMATION_MESSAGE);
	        } else {
	            JOptionPane.showMessageDialog(this, "L'occupation spécifiée n'a pas été trouvée", "Erreur", JOptionPane.ERROR_MESSAGE);
	        }
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	}

	
	
	public  Checkout() {
		JLabel l = new JLabel("Check-out");
		l.setBounds(160,13,260,100);
		l.setFont(new Font(null, Font.BOLD,20));
		add(l);
		
		dataLabel("ID",90,100,150,30);
		dataLabel("ID Client",90,150,150, 30);
		dataLabel("ID chambre ",90,200,150, 30);
		dataLabel("Date  ",90,250,150, 30);
		dataLabel("Nb de jours ",90,300,150, 30);
		
		
		
		JButton aj = new JButton("Check-out");
		aj.setBackground(Color.BLACK);
		aj.setForeground(Color.WHITE);
		aj.setBounds(50,360,150,30);
		add(aj);
		aj.addActionListener(new ActionListener() {
            
           public void actionPerformed(ActionEvent e) {
                
              deleteoccupation();
               
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
		
		ImageIcon i = new ImageIcon("hotel-riad-maroc-dar-mounir-chambre.jpeg");
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
		new Checkout();
		
	}

}


