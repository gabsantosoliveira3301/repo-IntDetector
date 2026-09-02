package intdetector;
import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class main {
    static int resposta = JOptionPane.CANCEL_OPTION;

    public static void main(String[] args) {
        JTextField t1 = new JTextField(5);
        JTextField t2 = new JTextField(5);
        JTextField t3 = new JTextField(5);
        JTextField t4 = new JTextField(5);
        JTextField t5 = new JTextField(5);
        JTextField t6 = new JTextField(5);
        JTextField t7 = new JTextField(5);
        JTextField t8 = new JTextField(5);
        JTextField t9 = new JTextField(5);
        JTextField t10 = new JTextField(5);

        JPanel painel = new JPanel(new GridLayout(10, 2, 5, 5));
        painel.add(new JLabel("Valor 1:"));  painel.add(t1);
        painel.add(new JLabel("Valor 2:"));  painel.add(t2);
        painel.add(new JLabel("Valor 3:"));  painel.add(t3);
        painel.add(new JLabel("Valor 4:"));  painel.add(t4);
        painel.add(new JLabel("Valor 5:"));  painel.add(t5);
        painel.add(new JLabel("Valor 6:"));  painel.add(t6);
        painel.add(new JLabel("Valor 7:"));  painel.add(t7);
        painel.add(new JLabel("Valor 8:"));  painel.add(t8);
        painel.add(new JLabel("Valor 9:"));  painel.add(t9);
        painel.add(new JLabel("Valor 10:")); painel.add(t10);

        //socorro deu trabalho pra pesquisar como faz a interface
        
        JDialog dialog = new JDialog((Frame) null, "IntDetector v0.1", true);
        dialog.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
        
        JPanel botoesPainel = new JPanel();
        JButton btnOk = new JButton("OK");
        JButton btnCancelar = new JButton("Cancelar");
        botoesPainel.add(btnOk);
        botoesPainel.add(btnCancelar);

        dialog.setLayout(new BorderLayout());
        dialog.add(painel, BorderLayout.CENTER);
        dialog.add(botoesPainel, BorderLayout.SOUTH);
        dialog.pack();
        dialog.setLocationRelativeTo(null);

        btnOk.addActionListener(e -> {
            resposta = JOptionPane.OK_OPTION;
            dialog.dispose();
        });

        btnCancelar.addActionListener(e -> {
            resposta = JOptionPane.CANCEL_OPTION;
            dialog.dispose();
        });
        // nao havia entendido se era pra dar o aviso no botão cancelar ou no X, então
        // decidi deixar só no X.
        dialog.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                String confirmacao = JOptionPane.showInputDialog(dialog, "Deseja realmente sair? Digite 'S' para confirmar:");
                if (confirmacao != null && confirmacao.trim().equalsIgnoreCase("S")) {
                    System.exit(0);
                }
            }
        });

        dialog.setVisible(true);

        if (resposta == JOptionPane.OK_OPTION) {
            try {
                int v1 = Integer.parseInt(t1.getText().trim());
                int v2 = Integer.parseInt(t2.getText().trim());
                int v3 = Integer.parseInt(t3.getText().trim());
                int v4 = Integer.parseInt(t4.getText().trim());
                int v5 = Integer.parseInt(t5.getText().trim());
                int v6 = Integer.parseInt(t6.getText().trim());
                int v7 = Integer.parseInt(t7.getText().trim());
                int v8 = Integer.parseInt(t8.getText().trim());
                int v9 = Integer.parseInt(t9.getText().trim());
                int v10 = Integer.parseInt(t10.getText().trim());

               
                    int maior = v1;
                    if (v2 > maior) maior = v2;
                    if (v3 > maior) maior = v3;
                    if (v4 > maior) maior = v4;
                    if (v5 > maior) maior = v5;
                    if (v6 > maior) maior = v6;
                    if (v7 > maior) maior = v7;
                    if (v8 > maior) maior = v8;
                    if (v9 > maior) maior = v9;
                    if (v10 > maior) maior = v10;

                    double media = (v1 + v2 + v3 + v4 + v5 + v6 + v7 + v8 + v9 + v10) / 10.0;

                    String pares = "";
                    String impares = "";

                    int[] vetor = {v1, v2, v3, v4, v5, v6, v7, v8, v9, v10};
                    for (int n : vetor) {
                        if (n % 2 == 0) {
                            pares += n + " ";
                        } else {
                            impares += n + " ";
                        }
                    }

                    if (pares.isEmpty()) pares = "Nenhum";
                    if (impares.isEmpty()) impares = "Nenhum";

                    String mensagemTudo = "--- RESULTADO FINAL ---\n" +
                                          "Maior valor: " + maior + "\n" +
                                          String.format("Média: %.2f\n", media) +
                                          "Números Pares: " + pares.trim() + "\n" +
                                          "Números Ímpares: " + impares.trim();
                   
         
                    JDialog dialogResultado = new JDialog((Frame) null, "Resultado", true);
                    dialogResultado.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
                    
                    JTextArea textArea = new JTextArea(mensagemTudo);
                    textArea.setEditable(false);
                    textArea.setFont(new Font("Monospaced", Font.PLAIN, 12));
                    textArea.setMargin(new Insets(10, 10, 10, 10));
                    
                    JButton btnFecharResultado = new JButton("OK");
                    btnFecharResultado.addActionListener(ev -> dialogResultado.dispose());
                    
                    JPanel painelSul = new JPanel();
                    painelSul.add(btnFecharResultado);
                    
                    dialogResultado.setLayout(new BorderLayout());
                    dialogResultado.add(new JScrollPane(textArea), BorderLayout.CENTER);
                    dialogResultado.add(painelSul, BorderLayout.SOUTH);
                    dialogResultado.pack();
                    dialogResultado.setLocationRelativeTo(null);
                    
                    dialogResultado.addWindowListener(new WindowAdapter() {
                        @Override
                        public void windowClosing(WindowEvent ev) {
                            String confirmacao = JOptionPane.showInputDialog(dialogResultado, "Deseja realmente sair? Digite 'S' para confirmar:");
                            if (confirmacao != null && confirmacao.trim().equalsIgnoreCase("S")) {
                                System.exit(0);
                            }
                        }
                    });
                    
                    dialogResultado.setVisible(true);


            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Digite apenas números inteiros em todos os campos!");
            }
        }
    }
}
