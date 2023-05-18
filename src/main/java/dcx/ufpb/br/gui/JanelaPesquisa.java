package dcx.ufpb.br.gui;

import dcx.ufpb.br.banco.ContaInvalidaException;
import dcx.ufpb.br.banco.InterfaceBanco;
import dcx.ufpb.br.controller.janelapesquisar.BotaoVoltarPesquisarController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class JanelaPesquisa extends JFrame{
    private JPanel painelPesquisa;
    private JTextField txtCpf;
    private JLabel linhaDeAviso;
    private JLabel botaoPesquisar;
    private JButton botaoVoltar;
    private JLabel nomeConta;
    private JLabel numCpf;
    private JLabel numConta;
    private JLabel numAg;
    private JLabel numSaldo;
    private InterfaceBanco interfaceBanco;

    public JanelaPesquisa(InterfaceBanco interfaceBanco){
        this.interfaceBanco = interfaceBanco;
        setContentPane(painelPesquisa);
        setTitle("Abreu Bank");
        setSize(500,460);
        setLocation(600,250);
        setResizable(false);

        botaoVoltar.addActionListener(new BotaoVoltarPesquisarController(this,interfaceBanco));
        botaoPesquisar.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                pesquisar();
                txtCpf.setText("");
            }
        });
    }

    public void pesquisar(){
        String cpfTitular = txtCpf.getText();
        try {
            nomeConta.setText(interfaceBanco.pesquisarContasDoCliente(cpfTitular).toStringNome());
            numCpf.setText(interfaceBanco.pesquisarContasDoCliente(cpfTitular).toStringCpf());
            numConta.setText(interfaceBanco.pesquisarContasDoCliente(cpfTitular).toStringNumC());
            numAg.setText(interfaceBanco.pesquisarContasDoCliente(cpfTitular).toStringNumAg());
            numSaldo.setText(interfaceBanco.pesquisarContasDoCliente(cpfTitular).toStringSaldo());
            linhaDeAviso.setText("");
        } catch (ContaInvalidaException ex) {
            limparInput();
            linhaDeAviso.setText("Este CPF é inválido! Tente novamente com um CPF válido!");
            linhaDeAviso.setForeground(new Color(119, 27, 37));
        }
    }

    public void limparInput(){
        nomeConta.setText("");
        numCpf.setText("");
        numConta.setText("Ainda não há dados");
        numAg.setText("");
        numSaldo.setText("");
    }


}
