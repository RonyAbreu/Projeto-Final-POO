package dcx.ufpb.br.gui;


import dcx.ufpb.br.banco.InterfaceBanco;

import javax.swing.*;

public class JanelaCriarConta extends JFrame{
    private JPanel painelCriarConta;
    private JButton botaoContaNormal;
    private JButton botaoContaEspecial;
    private InterfaceBanco interfaceBanco;
    private JanelaCadastro janelaCadastro;

    public JanelaCriarConta(InterfaceBanco interfaceBanco, JanelaCadastro janelaCadastro){
        this.janelaCadastro = janelaCadastro;
        this.interfaceBanco = interfaceBanco;
        setContentPane(painelCriarConta);
        setTitle("Abreu Bank");
        setSize(480,400);
        setResizable(false);
        setLocation(660,320);


        botaoContaNormal.addActionListener(e -> {
            janelaCadastro.tipoContaNormal();
            this.dispose();
        });

        botaoContaEspecial.addActionListener(e ->{
            janelaCadastro.tipoContaEspecial();
            this.dispose();
        });
    }

}
