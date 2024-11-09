package InterfaceHotel;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
public class ajouterChambre extends JFrame  {


    private JPanel contentPane;
    private JTextField t1,t2,t3;
    private JComboBox comboBox, comboBox_3;
    JButton b1,b2;
    Choice c1;

    public static void main(String[] args) {
    	
        new ajouterChambre().setVisible(true);
        
    }


    public ajouterChambre() {
        setBounds(250, 200, 1000, 450);
        setTitle("Ensam Hotel");
        ImageIcon image = new ImageIcon("channels4_profile.jpg");
        setIconImage(image.getImage());
        
	contentPane = new JPanel();
	setContentPane(contentPane);
	contentPane.setLayout(null);
	
        
       ImageIcon i1  = new ImageIcon(getClass().getResource("WhatsApp Image 2023-12-09 at 22.10.20.jpeg"));
                Image i3 = i1.getImage().getScaledInstance(500, 300,Image.SCALE_DEFAULT);
                ImageIcon i2 = new ImageIcon(i3);
                JLabel l15 = new JLabel(i2);
                l15.setBounds(400,2,500,400);
                add(l15);
        
        JLabel l10 = new JLabel("Ajouter chambre:");
        l10.setFont(new Font("arial", Font.BOLD, 18));
	l10.setBounds(100, 10, 300, 22);
	contentPane.add(l10);
        
	
        
	JLabel l1 = new JLabel("Numero:");
	l1.setForeground(Color.BLACK);
	l1.setFont(new Font("arial", Font.BOLD, 14));
	l1.setBounds(50, 70, 102, 22);
	contentPane.add(l1);
        
        
        t2 = new JTextField();
	t2.setBounds(174, 70, 156, 20);
	contentPane.add(t2);
        

	JLabel l2 = new JLabel("Disponibilite:");
	l2.setForeground(Color.BLACK);
	l2.setFont(new Font("arial", Font.BOLD, 14));
	l2.setBounds(50, 110, 102, 22);
	contentPane.add(l2);
        
        comboBox = new JComboBox(new String[] { "disponible", "Occupee" });
	comboBox.setBounds(176, 110, 154, 20);
	contentPane.add(comboBox);


	JLabel l3 = new JLabel("Nombre de lits:");
	l3.setForeground(Color.BLACK);
	l3.setFont(new Font("arial", Font.BOLD, 14));
	l3.setBounds(50, 150, 110, 22);
	contentPane.add(l3);
        
	t3 = new JTextField();
	t3.setBounds(174, 150, 156, 20);
	contentPane.add(t3);

	JLabel l4 = new JLabel("Prix:");
	l4.setForeground(Color.BLACK);
	l4.setFont(new Font("arial", Font.BOLD, 14));
	l4.setBounds(50, 190, 102, 22);
	contentPane.add(l4);
        
        t1 = new JTextField();
	t1.setBounds(174, 190, 156, 20);
	contentPane.add(t1);

        JLabel l5 = new JLabel("Type de lit:");
	l5.setForeground(Color.BLACK);
	l5.setFont(new Font("arial", Font.BOLD, 14));
	l5.setBounds(50, 230, 102, 22);
	contentPane.add(l5);


        comboBox_3 = new JComboBox(new String[] { "lit simple", "lit double"});
	comboBox_3.setBounds(176, 230, 154, 20);
	contentPane.add(comboBox_3);

	

	

	b1 = new JButton("Ajouter");
	//b1.addActionListener(this);
	b1.setBounds(64, 321, 111, 33);
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
	contentPane.add(b1);
	 b1.addActionListener(new ActionListener() {
	        
	        public void actionPerformed(ActionEvent e) {
	            
	          try {
				saveRoomData();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
	           
	        }
	    });

	b2 = new JButton("Retour");
	b2.addActionListener(new ActionListener() {
        
        public void actionPerformed(ActionEvent e) {
            
        	dispose();
			
			}
		
    });
	b2.setBounds(198, 321, 111, 33);
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
	contentPane.add(b2);

	
        contentPane.setBackground(Color.WHITE);
    
    }
    private void saveRoomData() throws IOException {
        
    	String numero = t2.getText();
        String disponible = (String)comboBox.getSelectedItem();
        String nblits = t3.getText();
        String prix  = t1.getText();
        String type = (String)comboBox_3.getSelectedItem();


        if (numero.isEmpty() || disponible.isEmpty() || nblits.isEmpty() || prix.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Veuillez remplir tous les champs", "Erreur", JOptionPane.ERROR_MESSAGE);
            return;
        }

        
        BufferedWriter bw = new BufferedWriter(new FileWriter("chambres.txt", true));

     
        bw.write("Numero: " +numero + "\tDisponibilité\t" +  disponible + "\tNombre_de_lits " + nblits + "\tPrix: " + prix + "\tType_de_lits: " + type);
        bw.newLine();

        
        bw.close();

        JOptionPane.showMessageDialog(this, "Chambre ajouté avec succès", "Succès", JOptionPane.INFORMATION_MESSAGE);
    
   
    } 
}
    

