package dcx.ufpb.br.controller.janelabanco;

import dcx.ufpb.br.banco.InterfaceBanco;
import dcx.ufpb.br.gui.JanelaBanco;
import dcx.ufpb.br.gui.JanelaCadastro;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;


public class BotaoAbrirContaController implements ActionListener {
    InterfaceBanco interfaceBanco;
    JanelaBanco janelaBanco;

    public BotaoAbrirContaController(InterfaceBanco interfaceBanco,JanelaBanco janelaBanco){
        this.interfaceBanco = interfaceBanco;
        this.janelaBanco = janelaBanco;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        janelaBanco.dispose();
        JanelaCadastro janelaCadastro = new JanelaCadastro(interfaceBanco);
        janelaCadastro.setVisible(true);
        janelaCadastro.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        janelaCadastro.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                int fechar = JOptionPane.showConfirmDialog(janelaCadastro,"Deseja sair?");
                if(fechar == JOptionPane.YES_OPTION){
                    System.exit(0);
                }
            }
        });
    }
}
