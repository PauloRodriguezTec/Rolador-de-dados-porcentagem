package main.Java.Apresentação;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import main.Java.model.Dice;
import main.Java.service.DiceRoller;
import main.Java.service.RollResult;

public class DiceGUI extends JFrame {
    private JTextArea resultadoArea;
    private JLabel totalAcumuladoLabel;
    private int totalAcumulado = 0;

    public DiceGUI() {
        setTitle("Rolador de Dados");
        setSize(400, 340);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Área de resultado
        resultadoArea = new JTextArea();
        resultadoArea.setEditable(false);
        add(new JScrollPane(resultadoArea), BorderLayout.CENTER);

        // Label de total acumulado
        totalAcumuladoLabel = new JLabel("Total acumulado: 0");
        totalAcumuladoLabel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        add(totalAcumuladoLabel, BorderLayout.SOUTH);

        // Painel de controles
        JPanel painel = new JPanel();
        String[] dados = {"D4", "D6", "D8", "D10", "D12", "D20", "D100"};
        JComboBox<String> comboDados = new JComboBox<>(dados);
        JTextField qtdField = new JTextField("1", 3);
        JTextField modField = new JTextField("0", 3);
        JTextField difField = new JTextField("10", 3);
        JButton rolarBtn = new JButton("Rolar");
        JButton resetBtn = new JButton("Limpar");

        painel.add(new JLabel("Dado:"));
        painel.add(comboDados);
        painel.add(new JLabel("Qtd:"));
        painel.add(qtdField);
        painel.add(new JLabel("Mod:"));
        painel.add(modField);
        painel.add(new JLabel("Dif:"));
        painel.add(difField);
        painel.add(rolarBtn);
        painel.add(resetBtn);

        add(painel, BorderLayout.NORTH);

        // Ação do botão
        rolarBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int lados;
                switch (comboDados.getSelectedIndex()) {
                    case 0:
                        lados = 4;
                        break;
                    case 1:
                        lados = 6;
                        break;
                    case 2:
                        lados = 8;
                        break;
                    case 3:
                        lados = 10;
                        break;
                    case 4:
                        lados = 12;
                        break;
                    case 5:
                        lados = 20;
                        break;
                    case 6:
                        lados = 100;
                        break;
                    default:
                        lados = 6;
                        break;
                }

                Dice dado = new Dice(lados);
                int qtd = Integer.parseInt(qtdField.getText());
                int mod = Integer.parseInt(modField.getText());
                int dif = Integer.parseInt(difField.getText());

                RollResult resultado = DiceRoller.rollDice(dado, qtd, mod, dif);
                resultadoArea.append(resultado.toString() + "\n--------------------\n");

                totalAcumulado += resultado.getSomaTotal();
                totalAcumuladoLabel.setText("Total acumulado: " + totalAcumulado);
            }
        });

        resetBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                totalAcumulado = 0;
                totalAcumuladoLabel.setText("Total acumulado: 0");
                resultadoArea.setText("");
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new DiceGUI().setVisible(true));
    }
}
