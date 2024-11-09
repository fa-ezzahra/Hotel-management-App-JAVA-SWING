package InterfaceHotel;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;


public class AddClient extends JFrame  {
	
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
	private String getSelectedRadioButton() {
	    Component[] components = getContentPane().getComponents();
	    for (Component component : components) {
	        if (component instanceof JRadioButton && ((JRadioButton) component).isSelected()) {
	            return ((JRadioButton) component).getText();
	        }
	    }
	    return "";
	}


	 private void saveClientData() throws IOException {
	        
	        String id = getTextFieldValue("ID");
	        String nom = getTextFieldValue("Nom");
	        String ville = getTextFieldValue("Ville");
	        String pays = getTextFieldValue("Pays");
	        String sexe = getSelectedRadioButton();


	        if (id.isEmpty() || nom.isEmpty() || ville.isEmpty() || pays.isEmpty() || sexe.isEmpty()) {
	            JOptionPane.showMessageDialog(this, "Veuillez remplir tous les champs", "Erreur", JOptionPane.ERROR_MESSAGE);
	            return;
	        }

	        
	        BufferedWriter bw = new BufferedWriter(new FileWriter("clients.txt", true));

	     
	        bw.write("ID: " + id + "\tNom: " + nom + "\tVille: " + ville + "\tPays: " + pays + "\tSexe: " + sexe);
	        bw.newLine();

	        
	        bw.close();

	        JOptionPane.showMessageDialog(this, "Client ajouté avec succès", "Succès", JOptionPane.INFORMATION_MESSAGE);
	    }
	
	public void radioButton(String s,int a,int b,int c,int d) {
		JRadioButton rb = new JRadioButton(s);
		rb.setBounds(a,b,c,d);
		add(rb);
	}
	
	public AddClient() {
		JLabel l = new JLabel("Nouveau Client");
		l.setBounds(160,13,260,100);
		l.setFont(new Font(null, Font.BOLD,20));
		add(l);
		
		dataLabel("ID  ",90,100,150, 30);
		dataLabel("Nom  ",90,140,150, 30);
		dataLabel("Ville  ",90,180,150, 30);
		dataLabel("Pays ",90,220,150, 30);
		
		JLabel s = new JLabel("Sexe  ");
		s.setBounds(90,260,120,30);
		add(s);
		radioButton("Homme",150,260,70,30);
		radioButton("Femme",250,260,70,30);
		
		JButton aj = new JButton("Ajouter");
		aj.setBackground(Color.BLACK);
		aj.setForeground(Color.WHITE);
		aj.setBounds(50,320,150,30);
		add(aj);
		aj.addActionListener(new ActionListener() {
            
            public void actionPerformed(ActionEvent e) {
                
              try {
				saveClientData();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
               
            }
        });
		
		JButton rt = new JButton("Retour");
		rt.setBackground(Color.BLACK);
		rt.setForeground(Color.WHITE);
		rt.setBounds(255,320,150,30);
		add(rt);
        rt.addActionListener(new ActionListener() {
            
            public void actionPerformed(ActionEvent e) {
                
            	
            	dispose();
				
				}
			
        });
		
		ImageIcon i = new ImageIcon("ah5-morocco-5132-copy_700x467.jpg");
		Image m = i.getImage().getScaledInstance(400, 350, Image.SCALE_SMOOTH);
		ImageIcon lm =new ImageIcon(m);
		JLabel li = new JLabel(i);
		li.setIcon(lm);
		li.setBounds(500,20,400,350);
		add(li);
		
		setBounds(250,250,1000, 450);
		setTitle("ENSAM Hotel");
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setVisible(true);
		
	}

	

	public static void main(String[] args) {
		new AddClient();
		
	}

}