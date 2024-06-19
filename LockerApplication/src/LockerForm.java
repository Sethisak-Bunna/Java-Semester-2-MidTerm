import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LockerForm extends JFrame implements ActionListener {
    private JPasswordField PasswordBox;
    private JButton[] NumberButt;
    private JButton EnterButt, ClearButt;
    private JLabel LabelStatus;
    private String PasswordSaving = null;
    public LockerForm() {
        setTitle("Locker Application");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 250);
        setLayout(new BorderLayout());

        JPanel mainPanel = new JPanel(new GridLayout(3, 3));
        NumberButt = new JButton[9];
        for (int i = 0; i < 9; i++) {
            NumberButt[i] = new JButton(String.valueOf(i + 1));
            NumberButt[i].addActionListener(this);
            mainPanel.add(NumberButt[i]);
        }

        PasswordBox = new JPasswordField();
        PasswordBox.setPreferredSize(new Dimension(150, 30));
        PasswordBox.setEditable(false);

        EnterButt = new JButton("Enter");
        EnterButt.addActionListener(this);

        ClearButt = new JButton("Clear");
        ClearButt.addActionListener(this);

        LabelStatus = new JLabel("Enter Password");
        LabelStatus.setHorizontalAlignment(SwingConstants.LEFT);

        JPanel inputPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        inputPanel.add(ClearButt);
        inputPanel.add(PasswordBox);
        inputPanel.add(EnterButt);
        inputPanel.add(LabelStatus);
        add(mainPanel, BorderLayout.CENTER);
        add(inputPanel, BorderLayout.SOUTH);
        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == EnterButt) {
            String enteredPassword = new String(PasswordBox.getPassword());
            if (PasswordSaving == null) {
                PasswordSaving = enteredPassword;
                LabelStatus.setText("Password Set");
            } else {
                if (enteredPassword.equals(PasswordSaving)) {
                    LabelStatus.setText("Correct Password");
                } else {
                    LabelStatus.setText("Incorrect Password");
                }
            }
            PasswordBox.setText("");
        } else if (e.getSource() == ClearButt) {
            PasswordBox.setText("");
            LabelStatus.setText("Enter Password");
        } else {
            for (int i = 0; i < 9; i++) {
                if (e.getSource() == NumberButt[i]) {
                    PasswordBox.setText(PasswordBox.getText() + (i + 1));
                }
            }
        }
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new LockerForm());
    }
}