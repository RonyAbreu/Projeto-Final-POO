package dcx.ufpb.br.gui;

import dcx.ufpb.br.banco.ContaInvalidaException;
import dcx.ufpb.br.banco.InterfaceBanco;
import dcx.ufpb.br.banco.SaldoInvalidoException;
import dcx.ufpb.br.controller.janelasacar.BotaoVoltarSacarController;

import javax.swing.*;
import java.awt.*;

public class JanelaSacar extends JFrame{
    private JPanel painelSacar;
    private JTextField txtNumConta;
    private JTextField txtNumAg;
    private JButton botaoVoltar;
    private JButton botaoConfirmar;
    private JTextField txtValor;
    private JLabel linhaDeAviso;
    private InterfaceBanco interfaceBanco;

    public JanelaSacar(InterfaceBanco interfaceBanco){
        this.interfaceBanco = interfaceBanco;
        setContentPane(painelSacar);
        setTitle("Abreu Bank");
        setSize(600,500);
        setLocation(600,250);
        setResizable(false);

        botaoVoltar.addActionListener(new BotaoVoltarSacarController(interfaceBanco, this));
        botaoConfirmar.addActionListener(e -> {
            sacarDeConta();
        });
    }

    public void sacarDeConta(){
        try {
            String numConta = txtNumConta.getText();
            String numAgencia = txtNumAg.getText();
            double valor = Double.parseDouble(txtValor.getText());
            interfaceBanco.sacarDeConta(numConta, numAgencia, valor);
            linhaDeAviso.setText("Saque efetuado com sucesso!  Seu saldo atual é de: "
                    + interfaceBanco.consultarSaldoDeConta(numConta, numAgencia)+"R$");
            linhaDeAviso.setForeground(new Color(6,96,17));
        } catch (NumberFormatException ex) {
            linhaDeAviso.setText("Verifique se preencheu os campos corretamente!");
            linhaDeAviso.setForeground(new Color(119, 27, 37));
        }  catch (ContaInvalidaException | SaldoInvalidoException ex) {
            linhaDeAviso.setText("Verifique se sua conta é válida, ou se possui saldo suficiente!");
            linhaDeAviso.setForeground(new Color(119, 27, 37));
        }
        limparInput();
    }

    public void limparInput(){
        txtNumConta.setText("");
        txtNumAg.setText("");
        txtValor.setText("");
    }

}
