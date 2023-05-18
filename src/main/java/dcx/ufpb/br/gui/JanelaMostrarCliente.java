package dcx.ufpb.br.gui;

import dcx.ufpb.br.banco.InterfaceBanco;

import javax.swing.*;

public class JanelaMostrarCliente extends JFrame{
    private JPanel painelMostrarCliente;
    private JButton botaoVoltar;
    private JButton botaoConfirmar;
    private JLabel nomeConta;
    private JLabel numCpf;
    private JLabel numSaldo;
    private JLabel numAg;
    private JLabel numConta;
    private InterfaceBanco interfaceBanco;
    private JanelaRemove janelaRemove;

    public JanelaMostrarCliente (InterfaceBanco interfaceBanco, JanelaRemove janelaRemove){
        this.interfaceBanco = interfaceBanco;
        this.janelaRemove = janelaRemove;
        setContentPane(painelMostrarCliente);
        setTitle("Abreu Bank");
        setSize(400,400);
        setLocation(700,320);
        setResizable(false);

        botaoVoltar.addActionListener(e ->{
           this.dispose();
        });

        botaoConfirmar.addActionListener(e ->{
            janelaRemove.removeConta();
            this.dispose();
        });
    }

    public void preencherDados(String nome, String cpf, String numeroConta, String numeroAg, String numeroSaldo){
        nomeConta.setText(nome);
        numCpf.setText(cpf);
        numConta.setText(numeroConta);
        numAg.setText(numeroAg);
        numSaldo.setText(numeroSaldo);
    }

}
