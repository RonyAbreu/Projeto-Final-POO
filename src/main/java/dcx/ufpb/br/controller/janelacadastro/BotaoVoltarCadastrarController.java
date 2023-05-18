package dcx.ufpb.br.controller.janelacadastro;

import dcx.ufpb.br.banco.InterfaceBanco;
import dcx.ufpb.br.gui.JanelaBanco;
import dcx.ufpb.br.gui.JanelaCadastro;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class BotaoVoltarCadastrarController implements ActionListener {
    private JanelaCadastro janelaCadastro;
    private InterfaceBanco interfaceBanco;

    public BotaoVoltarCadastrarController(JanelaCadastro janelaCadastro, InterfaceBanco interfaceBanco){
        this.janelaCadastro = janelaCadastro;
        this.interfaceBanco = interfaceBanco;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        janelaCadastro.dispose();
        JanelaBanco janelaBanco = new JanelaBanco(interfaceBanco);
        janelaBanco.setVisible(true);
        janelaBanco.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        janelaBanco.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                int fechar = JOptionPane.showConfirmDialog(janelaBanco,"Lembre de usar o botão (Sair e Salvar), para sair do Banco com seus dados Salvos!\nDeseja sair?");
                if(fechar==JOptionPane.YES_OPTION){
                    System.exit(0);
                }
            }
        });
    }
}
