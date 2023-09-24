import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ConversorMoneda extends JFrame implements ActionListener {
    private JTextField ValorPesos;
    private JButton convertirButton;
    private JLabel resultadoLabel;

    public ConversorMon() {
        setTitle("Conversor de Monedas");
        setSize(300, 150);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        JLabel PesosLabel = new JLabel("Cantidad a convertir:");
        ValorPesos = new JTextField(10);
        convertirButton = new JButton("Convertir");
        resultadoLabel = new JLabel("");

        convertirButton.addActionListener(this);

        add(PesosLabel);
        add(ValorPesos);
        add(convertirButton);
        add(resultadoLabel);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == convertirButton) {
            try {
                double Pesos = Double.parseDouble(ValorPesos.getText());
                double dolares = Pesos/(3.938);
                double euros   = Pesos/(4.002);
                double libras  = Pesos/(4.821);
                double yenes   = Pesos/(26.56);
                double won   = Pesos/(2.95);
                resultadoLabel.setText("Dolares: " + dolares + " Euros: " + euros + " libras esterlinas: " +libras+ " Yenes: "+yenes+ " Won: "+won);
            } catch (NumberFormatException ex) {
                resultadoLabel.setText("Ingresa los pesos a convertir en formato deciamal.");
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            ConversorMon conversor = new ConversorMon();
            conversor.setVisible(true);
        });
    }
}
