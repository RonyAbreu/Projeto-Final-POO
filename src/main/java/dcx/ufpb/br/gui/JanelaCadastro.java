package dcx.ufpb.br.gui;

import dcx.ufpb.br.banco.ContaJaExisteException;
import dcx.ufpb.br.banco.GravadorDeContas;
import dcx.ufpb.br.banco.InterfaceBanco;
import dcx.ufpb.br.controller.janelacadastro.BotaoVoltarCadastrarController;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;


public class JanelaCadastro extends JFrame {

    private JPanel painelCadastro;
    private JTextField txtNome, txtCpf, txtNumConta, txtNumAgencia;
    private JButton botaoConfirmar;
    private JButton botaoVoltar;
    private JLabel linhaDeAviso;
    private InterfaceBanco interfaceBanco;
    private GravadorDeContas gravadorDeContas;

    public JanelaCadastro (InterfaceBanco interfaceBanco){
        //inicializando a interface
        this.interfaceBanco = interfaceBanco;
        // Parâmetros da janela
        setTitle("Abreu Bank");
        setContentPane(painelCadastro);
        setSize(600,500);
        setLocation(600,250);
        setResizable(false);
        // EVENTO DO BOTÃO COM CLASSE
        botaoVoltar.addActionListener(new BotaoVoltarCadastrarController(this,interfaceBanco));

        //EVENTO DO BOTÃO COM LAMBDA
        botaoConfirmar.addActionListener(e -> {
            JanelaCriarConta janelaCriarConta = new JanelaCriarConta(interfaceBanco, this);
            janelaCriarConta.setVisible(true);
        });
    }

    public void contaSalva(){
        try {
            gravadorDeContas = new GravadorDeContas();
            gravadorDeContas.gravaContas(interfaceBanco.getContas());
        }catch (IOException ex){
            JOptionPane.showMessageDialog(this,"Não foi possível salvar seus dados!!");
        }
    }

    public void limparInput(){
        txtNome.setText("");
        txtCpf.setText("");
        txtNumConta.setText("");
        txtNumAgencia.setText("");
    }

    public void tipoContaNormal(){
        try {
            String nome = txtNome.getText();
            String cpf = txtCpf.getText();
            String numConta = txtNumConta.getText();
            String numAg = txtNumAgencia.getText();
            double saldo = 0;
            if(interfaceBanco.contaNula(nome,cpf, numConta, numAg) || interfaceBanco.contaVazia(nome, cpf, numConta, numAg)){
                linhaDeAviso.setText("Verifique se preencheu todos os campos corretamente!");
                linhaDeAviso.setForeground(new Color(119, 27, 37));
            } else {
                interfaceBanco.abrirConta(nome,cpf,numConta,numAg,saldo);
                linhaDeAviso.setText("Conta criada com sucesso!");
                linhaDeAviso.setForeground(new Color(6,96,17));
                contaSalva();
            }
        } catch (ContaJaExisteException ex) {
            linhaDeAviso.setText("Essa conta já existe!");
            linhaDeAviso.setForeground(new Color(119, 27, 37));
        }
        limparInput();
    }

    public void tipoContaEspecial(){
        try {
            String nome = txtNome.getText();
            String cpf = txtCpf.getText();
            String numConta = txtNumConta.getText();
            String numAg = txtNumAgencia.getText();
            double saldo = 0;
            double credito = 1000.0;
            if(interfaceBanco.contaNula(nome,cpf, numConta, numAg) || interfaceBanco.contaVazia(nome, cpf, numConta, numAg)){
                linhaDeAviso.setText("Verifique se preencheu todos os campos corretamente!");
                linhaDeAviso.setForeground(new Color(119, 27, 37));
            } else {
                interfaceBanco.abrirContaEspecial(nome, cpf, numConta, numAg, saldo, credito);
                linhaDeAviso.setText("Conta criada com sucesso!");
                linhaDeAviso.setForeground(new Color(6,96,17));
                contaSalva();
            }
        } catch (ContaJaExisteException ex) {
            linhaDeAviso.setText("Essa conta já existe!");
            linhaDeAviso.setForeground(new Color(119, 27, 37));

        }
        limparInput();
    }

}
