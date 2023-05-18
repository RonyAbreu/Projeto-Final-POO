package dcx.ufpb.br.controller.janelatrasferir;

import dcx.ufpb.br.banco.InterfaceBanco;
import dcx.ufpb.br.gui.JanelaBanco;
import dcx.ufpb.br.gui.JanelaTransferir;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class BotaoVoltarTransferirController implements ActionListener {
    private InterfaceBanco interfaceBanco;
    private JanelaTransferir janelaTransferir;

    public BotaoVoltarTransferirController(InterfaceBanco interfaceBanco, JanelaTransferir janelaTransferir){
        this.interfaceBanco = interfaceBanco;
        this.janelaTransferir = janelaTransferir;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        janelaTransferir.dispose();
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
