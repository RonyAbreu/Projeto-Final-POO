package dcx.ufpb.br.gui;

import dcx.ufpb.br.banco.ContaInvalidaException;
import dcx.ufpb.br.banco.InterfaceBanco;
import dcx.ufpb.br.controller.janelaremove.BotaoVoltarRemoverController;

import javax.swing.*;
import java.awt.*;

public class JanelaRemove extends JFrame{
    private JPanel painelRemove;
    private JTextField txtNumConta;
    private JTextField txtNumAg;
    private JButton botaoVoltar;
    private JButton botaoConfirmar;
    private JLabel linhaDeAviso;
    private InterfaceBanco interfaceBanco;

    public JanelaRemove(InterfaceBanco interfaceBanco){
        this.interfaceBanco = interfaceBanco;
        setTitle("Abreu Bank");
        setContentPane(painelRemove);
        setSize(600,500);
        setLocation(600,250);
        setResizable(false);

        botaoVoltar.addActionListener(new BotaoVoltarRemoverController(this,interfaceBanco));

        botaoConfirmar.addActionListener(e -> {
            mostrarDadosDaConta();
        });
    }

    public void mostrarDadosDaConta(){
        String numConta = txtNumConta.getText();
        String numAg = txtNumAg.getText();
        if(interfaceBanco.pesquisaNumeroContaENumeroAgencia(numConta, numAg) == null) {
            linhaDeAviso.setText("Essa conta é inválida!");
            linhaDeAviso.setForeground(new Color(119, 27, 37));
        } else {
            linhaDeAviso.setText("");
            JanelaMostrarCliente janelaMostrarCliente = new JanelaMostrarCliente(interfaceBanco,this);
            janelaMostrarCliente.setVisible(true);
            String nome = interfaceBanco.pesquisaNumeroContaENumeroAgencia(numConta,numAg).toStringNome();
            String cpf = interfaceBanco.pesquisaNumeroContaENumeroAgencia(numConta,numAg).toStringCpf();
            String numeroConta = interfaceBanco.pesquisaNumeroContaENumeroAgencia(numConta,numAg).toStringNumC();
            String numeroAgencia = interfaceBanco.pesquisaNumeroContaENumeroAgencia(numConta,numAg).toStringNumAg();
            String saldo = interfaceBanco.pesquisaNumeroContaENumeroAgencia(numConta,numAg).toStringSaldo();
            janelaMostrarCliente.preencherDados(nome,cpf,numeroConta,numeroAgencia,saldo);
        }
    }

    public void removeConta(){
        try {
            String numConta = txtNumConta.getText();
            String numAg = txtNumAg.getText();
            interfaceBanco.removerConta(numConta,numAg);
            linhaDeAviso.setText("Conta removida com sucesso!");
            linhaDeAviso.setForeground(new Color(6,96,17));
            limparInput();
        } catch (ContaInvalidaException e) {
            linhaDeAviso.setText("Essa conta é inválida!");
            linhaDeAviso.setForeground(new Color(119, 27, 37));
        }
    }

    public void limparInput(){
        txtNumConta.setText("");
        txtNumAg.setText("");
    }


}
