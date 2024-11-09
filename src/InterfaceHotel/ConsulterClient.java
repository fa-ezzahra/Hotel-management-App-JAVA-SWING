package InterfaceHotel;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class ConsulterClient extends JFrame {
    private JTextField t;
    private JButton rb;
    private JTextArea resultTextArea;

    public ConsulterClient() {
        setLayout(new BorderLayout());

        // North Panel for search bar and buttons
        JPanel northPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        add(northPanel, BorderLayout.NORTH);

        JLabel l = new JLabel("Chercher client par ID ");
        northPanel.add(l);

        t = new JTextField(10);
        northPanel.add(t);

        rb = new JButton("Rechercher");
        rb.setBackground(Color.BLACK);
        rb.setForeground(Color.WHITE);
        northPanel.add(rb);
        
        resultTextArea = new JTextArea(700, 100);
        resultTextArea.setEditable(false);
        add(new JScrollPane(resultTextArea), BorderLayout.CENTER);
        displayList("clients.txt");

        // Add action listener for the rb button
        addActionButtonListener();

        setBounds(400, 300, 700, 250);
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
                String fileName = "clients.txt"; 
                String line = findLineByID(fileName, num);

                // Display the result in a new frame
                JFrame resultFrame = new JFrame("Resultat");
                resultFrame.setBounds(250,250,700,300);
                JTextArea resultTextArea = new JTextArea(10,70);
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
        return FileUtil.findLineByID(fileName, "ID: " + num );
    }

    public static void main(String[] args) {
        new ConsulterClient();
    }
}

