package InterfaceHotel;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class ChercherChambre extends JFrame {
    private JTextField t;
    private JButton rb;
    private JTextArea resultTextArea;

    public ChercherChambre() {
        setLayout(new BorderLayout());

        // North Panel for search bar and buttons
        JPanel northPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        add(northPanel, BorderLayout.NORTH);

        JLabel l = new JLabel("chambre par Numero ");
        northPanel.add(l);

        t = new JTextField(10);
        northPanel.add(t);

        rb = new JButton("Rechercher");
        rb.setBackground(Color.BLACK);
        rb.setForeground(Color.WHITE);
        northPanel.add(rb);
        
        resultTextArea = new JTextArea(800, 200);
        resultTextArea.setEditable(false);
        add(new JScrollPane(resultTextArea), BorderLayout.CENTER);
        displayList("chambres.txt");

        // Add action listener for the rb button
        addActionButtonListener();

        setBounds(350, 300, 800, 200);
        setTitle("ENSAM Hotel");
        //setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setVisible(true);
    }

    public void addActionButtonListener() {
        rb.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String searchID = t.getText();
                int num = Integer.parseInt(searchID);
                String fileName = "chambres.txt"; 
                String line = findLineByID(fileName, num);

                // Display the result in a new frame
                JFrame resultFrame = new JFrame("Resultat");
                resultFrame.setBounds(250,250,800,300);
                JTextArea resultTextArea = new JTextArea(10,100);
                resultTextArea.setText(line);
                resultTextArea.setEditable(false);

                resultFrame.add(new JScrollPane(resultTextArea), BorderLayout.CENTER);
                resultFrame.pack();
                resultFrame.setVisible(true);
            }
        });
    }
    
    public void displayList(String fileName) {
        resultTextArea.setText(FileUtil.readFileContent(fileName));
    }

    public String findLineByID(String fileName, int num) {
        return FileUtil.findLineByID(fileName, "Numero: " + num );
    }

    public static void main(String[] args) {
        new ChercherChambre();
    }
}
