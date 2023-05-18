package dcx.ufpb.br.controller.janelabanco;

import dcx.ufpb.br.banco.InterfaceBanco;
import dcx.ufpb.br.gui.JanelaBanco;
import dcx.ufpb.br.gui.JanelaTransferir;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class BotaoTransferirController implements ActionListener {
    private InterfaceBanco interfaceBanco;
    private JanelaBanco janelaBanco;
    public BotaoTransferirController(InterfaceBanco interfaceBanco, JanelaBanco janelaBanco) {
        this.interfaceBanco = interfaceBanco;
        this.janelaBanco = janelaBanco;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        janelaBanco.dispose();
        JanelaTransferir janelaTransferir = new JanelaTransferir(interfaceBanco);
        janelaTransferir.setVisible(true);
        janelaTransferir.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        janelaTransferir.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                int fechar = JOptionPane.showConfirmDialog(janelaTransferir,"Deseja sair?");
                if(fechar == JOptionPane.YES_OPTION){
                    System.exit(0);
                }
            }
        });
    }
}
