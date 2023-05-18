package dcx.ufpb.br.controller.janelabanco;

import dcx.ufpb.br.banco.InterfaceBanco;
import dcx.ufpb.br.gui.JanelaBanco;
import dcx.ufpb.br.gui.JanelaPesquisa;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class BotaoPesqController implements ActionListener {
    private InterfaceBanco interfaceBanco;
    private JanelaBanco janelaBanco;
    public BotaoPesqController(InterfaceBanco interfaceBanco, JanelaBanco janelaBanco) {
        this.interfaceBanco = interfaceBanco;
        this.janelaBanco = janelaBanco;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        janelaBanco.dispose();
        JanelaPesquisa janelaPesquisa = new JanelaPesquisa(interfaceBanco);
        janelaPesquisa.setVisible(true);
        janelaPesquisa.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        janelaPesquisa.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                int fechar = JOptionPane.showConfirmDialog(janelaPesquisa,"Deseja sair?");
                if(fechar == JOptionPane.YES_OPTION){
                    System.exit(0);
                }
            }
        });
    }
}
