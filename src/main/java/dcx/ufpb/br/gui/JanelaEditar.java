package dcx.ufpb.br.gui;

import dcx.ufpb.br.banco.ContaInvalidaException;
import dcx.ufpb.br.banco.InterfaceBanco;

import javax.swing.*;
import java.awt.*;


public class JanelaEditar extends JFrame{
    private JPanel painelEditar;
    private JLabel linhaDeAviso;
    private JTextField txtCpf;
    private JTextField txtNovoNome;
    private JButton botaoConfirmar;
    private InterfaceBanco interfaceBanco;

    public JanelaEditar(InterfaceBanco interfaceBanco){
        this.interfaceBanco = interfaceBanco;
        setTitle("Abreu Bank");
        setContentPane(painelEditar);
        setSize(400,400);
        setLocation(750,350);
        setResizable(false);

        botaoConfirmar.addActionListener(e -> {
            novoNome();
        });
    }

    public void novoNome(){
        try {
            String cpf = txtCpf.getText();
            String nome = txtNovoNome.getText();
            interfaceBanco.alterarNome(cpf, nome);
            linhaDeAviso.setText("Nome alterado com sucesso!");
            linhaDeAviso.setForeground(new Color(6,96,17));
        } catch (ContaInvalidaException e) {
            linhaDeAviso.setText("CPF inválido!");
            linhaDeAviso.setForeground(new Color(119, 27, 37));
        }
        limparInput();
    }

    public void limparInput(){
        txtCpf.setText("");
        txtNovoNome.setText("");
    }
}
