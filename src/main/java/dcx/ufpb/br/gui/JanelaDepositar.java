package dcx.ufpb.br.gui;

import dcx.ufpb.br.banco.ContaInvalidaException;
import dcx.ufpb.br.banco.InterfaceBanco;
import dcx.ufpb.br.controller.janeladepositar.BotaoVoltarDepositarController;

import javax.swing.*;
import java.awt.*;

public class JanelaDepositar extends JFrame{
    private JPanel painelDepositar;
    private JTextField txtNumConta;
    private JTextField txtNumAg;
    private JTextField txtValor;
    private JLabel linhaDeAviso;
    private JButton botaoVoltar;
    private JButton botaoConfirmar;

    private InterfaceBanco interfaceBanco;

    public JanelaDepositar(InterfaceBanco interfaceBanco){
        this.interfaceBanco = interfaceBanco;
        setTitle("Abreu Bank");
        setContentPane(painelDepositar);
        setSize(600,500);
        setLocation(600,250);
        setResizable(false);

        botaoVoltar.addActionListener(new BotaoVoltarDepositarController(interfaceBanco, this));
        botaoConfirmar.addActionListener(e -> {
            depositar();
        });
    }

    public void depositar(){
        try {
            String numConta = txtNumConta.getText();
            String numAgencia = txtNumAg.getText();
            double valor = Double.parseDouble(txtValor.getText());
            interfaceBanco.depositarEmConta(numConta, numAgencia, valor);
            linhaDeAviso.setText("Deposito efetuado com sucesso!  Seu saldo atual é de: "
                    + interfaceBanco.consultarSaldoDeConta(numConta, numAgencia)+"R$");
            linhaDeAviso.setForeground(new Color(6,96,17));
        } catch (ContaInvalidaException ex) {
            linhaDeAviso.setText("Conta inválida!");
            linhaDeAviso.setForeground(new Color(119, 27, 37));
        } catch (NumberFormatException ex) {
            linhaDeAviso.setText("Verifique se preencheu os campos corretamente!");
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
