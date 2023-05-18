package dcx.ufpb.br.gui;

import dcx.ufpb.br.banco.ContaInvalidaException;
import dcx.ufpb.br.banco.InterfaceBanco;
import dcx.ufpb.br.banco.SaldoInvalidoException;
import dcx.ufpb.br.controller.janelatrasferir.BotaoVoltarTransferirController;

import javax.swing.*;
import java.awt.*;

public class JanelaTransferir extends JFrame {

    private JPanel painelTransferir;
    private JTextField txtNumContaOrigem;
    private JTextField txtNumAgOrigem;
    private JTextField txtNumContaDestino;
    private JTextField txtNumAgDestino;
    private JTextField txtValor;
    private JButton botaoVoltar;
    private JButton botaoConfirmar;
    private JLabel linhaDeAviso;
    private InterfaceBanco interfaceBanco;

    public JanelaTransferir(InterfaceBanco interfaceBanco){
        this.interfaceBanco = interfaceBanco;
        setContentPane(painelTransferir);
        setTitle("Abreu Bank");
        setSize(600,500);
        setLocation(600,250);
        setResizable(false);

        botaoVoltar.addActionListener(new BotaoVoltarTransferirController(interfaceBanco, this));

        botaoConfirmar.addActionListener(e -> {
            transferir();
        });
    }

    public void transferir(){
        String numContaA = txtNumContaOrigem.getText();
        String numAgenciaA = txtNumAgOrigem.getText();
        String numContaB = txtNumContaDestino.getText();
        String numAgenciaB = txtNumAgDestino.getText();
        try {
            double valor = Double.parseDouble(txtValor.getText());
            try {
                interfaceBanco.transferir(numContaA,numAgenciaA,numContaB,numAgenciaB,valor);
                linhaDeAviso.setText("Trasnferência realizada com sucesso!");
                linhaDeAviso.setForeground(new Color(6,96,17));
            } catch (ContaInvalidaException | SaldoInvalidoException ex) {
                linhaDeAviso.setText("Verifique se sua conta é válida, ou se possui saldo suficiente!");
                linhaDeAviso.setForeground(new Color(119, 27, 37));
            }
        } catch (NumberFormatException ex) {
            linhaDeAviso.setText("Verifique se preencheu os campos corretamente!");
            linhaDeAviso.setForeground(new Color(119, 27, 37));
        }
        limparInput();
    }

    public void limparInput(){
        txtNumContaOrigem.setText("");
        txtNumAgOrigem.setText("");
        txtNumContaDestino.setText("");
        txtNumAgDestino.setText("");
        txtValor.setText("");
    }
}
