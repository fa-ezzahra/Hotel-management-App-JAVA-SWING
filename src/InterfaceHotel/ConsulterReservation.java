package InterfaceHotel;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ConsulterReservation extends JFrame {
    private JTextField t;
    private JButton rb;
    private JTextArea resultTextArea;

    public ConsulterReservation() {
        setLayout(new BorderLayout());

        // North Panel for search bar and buttons
        JPanel northPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        add(northPanel, BorderLayout.NORTH);

        JLabel l = new JLabel("Reservation par ID ");
        northPanel.add(l);

        t = new JTextField(10);
        northPanel.add(t);

        rb = new JButton("Rechercher");
        rb.setBackground(Color.BLACK);
        rb.setForeground(Color.WHITE);
        northPanel.add(rb);

        // Add action listener for the rb button
        addActionButtonListener();

        // Center Panel for displaying the list
        resultTextArea = new JTextArea(10, 100);
        resultTextArea.setEditable(false);
        add(new JScrollPane(resultTextArea), BorderLayout.CENTER);

        // Display the initial list
        displayList("reservation.txt");

        setBounds(350, 300, 900, 300);
        setTitle("ENSAM Hotel");
        // setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setVisible(true);
    }

    public void addActionButtonListener() {
        rb.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String searchID = t.getText();
                int num = Integer.parseInt(searchID);
                String fileName = "reservation.txt";
                String line = findLineByID(fileName, num);

                // Display the result in a new frame
                JFrame resultFrame = new JFrame("Resultat");
                resultFrame.setBounds(250, 250, 1000, 300);
                JTextArea resultTextArea = new JTextArea(10, 100);
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
        return FileUtil.findLineByID(fileName, "ID reservation: " + num );
    }



    public static void main(String[] args) {
        new ConsulterReservation();
    }
}

