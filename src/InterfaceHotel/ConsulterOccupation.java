package InterfaceHotel;



import javax.swing.*;



import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ConsulterOccupation extends JFrame {
   
    private JTextArea textArea;
    private JTextField chambreField;
    private JLabel resultLabel;

    public String recupererDonnees() {
        return FileUtil.readFileContent("occupation.txt");
    }

    private void displayClientInOccupationList(int roomNumber) {
        // Obtenez la ligne correspondant à la chambre spécifiée
        String target = "ID chambre: " + roomNumber;
        String line = FileUtil.findLineByID("occupation.txt", target);

        // Si la ligne est trouvée, extrayez l'ID client et affichez les informations du client
        if (line != null) {
            String[] parts = line.split("\t");
            for (String part : parts) {
                if (part.startsWith("ID Client: ")) {
                    int clientID = Integer.parseInt(part.substring("ID Client: ".length()));
                    String clientInfo = FileUtil.findClientByID("clients.txt", clientID);

                    // Afficher les informations du client dans une nouvelle fenêtre
                    JFrame clientFrame = new JFrame("Client dans la chambre " + roomNumber);
                    JTextArea clientTextArea = new JTextArea(clientInfo);
                    clientTextArea.setEditable(false);
                    clientFrame.add(new JScrollPane(clientTextArea), BorderLayout.CENTER);

                    clientFrame.setBounds(250, 250, 400, 200);
                    clientFrame.setVisible(true);
                    return;
                }
            }
        }
        resultLabel.setText("Aucun client trouvé pour la chambre spécifiée.");
    }



    public ConsulterOccupation() {
        
        textArea = new JTextArea();
        textArea.setText(recupererDonnees());

        JScrollPane scrollPane = new JScrollPane(textArea);
        add(scrollPane, BorderLayout.CENTER);

        JPanel searchPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        chambreField = new JTextField(10);
        searchPanel.add(new JLabel("Numéro de chambre: "));
        searchPanel.add(chambreField);

        JButton searchButton = new JButton("Rechercher");
        searchButton.setBackground(Color.BLACK);
        searchButton.setForeground(Color.WHITE);
        searchPanel.add(searchButton);

        resultLabel = new JLabel();
        searchPanel.add(resultLabel);

        add(searchPanel, BorderLayout.NORTH);

        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int roomNumber = Integer.parseInt(chambreField.getText());
                    displayClientInOccupationList(roomNumber);
                } catch (NumberFormatException ex) {
                    resultLabel.setText("Veuillez entrer un numéro de chambre valide.");
                }
            }
        });

        setBounds(350, 300, 900, 500);
        setTitle("Liste des occupations");
        
        setResizable(false);
        setVisible(true);
    }

    public static void main(String[] args) {
        
        new ConsulterOccupation();
    }
}
