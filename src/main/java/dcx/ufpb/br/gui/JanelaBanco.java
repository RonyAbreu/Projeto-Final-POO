package dcx.ufpb.br.gui;

import dcx.ufpb.br.banco.GravadorDeContas;
import dcx.ufpb.br.banco.InterfaceBanco;
import dcx.ufpb.br.controller.janelabanco.*;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;


public class JanelaBanco extends JFrame{
    private JPanel painelBanco;
    private JButton botaoDepositar,botaoSacar, botaoPesquisar,
            botaoAbrirConta,botaoRemover,botaoTransferir, botaoSair;
    private JLabel titulo1;
    private InterfaceBanco interfaceBanco;
    private JMenuBar menuBar;

    public JanelaBanco(InterfaceBanco interfaceBanco){
        //Parâmetros da janela
        this.interfaceBanco = interfaceBanco;
        setTitle("Abreu Bank");
        setLocation(600,200);
        setContentPane(painelBanco);
        setSize(700,660);
        setResizable(false);

        //BARRA DE MENU
        //TEMAS
        JMenu temas = new JMenu("Temas");
        JMenuItem darkMode = new JMenuItem("Modo Escuro");
        JMenuItem lightMode = new JMenuItem("Modo Claro");
        JMenuItem normalMode = new JMenuItem("Modo Padrão");
        temas.add(lightMode);
        temas.add(darkMode);
        temas.add(normalMode);

        //EDITAR
        JMenu editar = new JMenu("Editar");
        JMenuItem editarNome = new JMenuItem("Editar Nome");
        editar.add(editarNome);

        //AJUDA
        JMenu ajuda = new JMenu("Ajuda");
        JMenuItem ajudaItem = new JMenuItem("Informações");
        ajuda.add(ajudaItem);

        //FUNCIONALIDADE DOS ITENS DO MENU
        darkMode.addActionListener(e -> {
            modoEscuro();
        });
        lightMode.addActionListener(e -> {
            modoClaro();
        });
        normalMode.addActionListener(e ->{
            modoNormal();
        });
        editarNome.addActionListener(e-> {
            editarNome();
        });
        ajudaItem.addActionListener(e -> {
            ajudaItemInfo();
        });

        //ADICIONANDO NO MENU E ALTERANDO PARA MEU MENUBAR
        menuBar = new JMenuBar();
        menuBar.add(temas);
        menuBar.add(editar);
        menuBar.add(ajuda);
        setJMenuBar(menuBar);

        // EVENTO DOS BOTÕES COM CLASSES
        botaoAbrirConta.addActionListener(new BotaoAbrirContaController(this.interfaceBanco,this));
        botaoPesquisar.addActionListener(new BotaoPesqController(this.interfaceBanco,this));
        botaoRemover.addActionListener(new BotaoRemoveController(this.interfaceBanco,this));
        botaoDepositar.addActionListener(new BotaoDepositarController(this.interfaceBanco,this));
        botaoSacar.addActionListener(new BotaoSacarController(this.interfaceBanco,this));
        botaoTransferir.addActionListener(new BotaoTransferirController(this.interfaceBanco,this));

        //EVENTO DOS BOTÕES COM LAMBDA
        botaoSair.addActionListener(e -> {
            int fechar = JOptionPane.showConfirmDialog(getContentPane(),"Deseja sair?");
            if(fechar == JOptionPane.YES_OPTION){
                contaSalva();
                System.exit(0);
            }
        });
    }

    public void contaSalva(){
        GravadorDeContas gravadorDeContas = new GravadorDeContas();
        try {
            gravadorDeContas.gravaContas(interfaceBanco.getContas());
        }catch (IOException ex){
            JOptionPane.showMessageDialog(this,"Não foi possível salvar seus dados!!");
        }
    }

    public void modoEscuro(){
        getContentPane().setBackground(new Color(0, 0, 0));
        titulo1.setForeground(new Color(255,255,255));
    }

    public void modoClaro(){
        getContentPane().setBackground(new Color(255, 255, 255));
        titulo1.setForeground(new Color(0,0,0));
    }

    public void modoNormal(){
        getContentPane().setBackground(new Color(124,176,218));
        titulo1.setForeground(new Color(0,0,0));
    }

    public void editarNome(){
        JanelaEditar janelaEditar = new JanelaEditar(interfaceBanco);
        janelaEditar.setVisible(true);
    }

    public void ajudaItemInfo(){
        JanelaAjuda janelaAjuda = new JanelaAjuda();
        janelaAjuda.setVisible(true);

    }

}
