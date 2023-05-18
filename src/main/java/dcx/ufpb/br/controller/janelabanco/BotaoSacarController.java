package dcx.ufpb.br.controller.janelabanco;

import dcx.ufpb.br.banco.InterfaceBanco;
import dcx.ufpb.br.gui.JanelaBanco;
import dcx.ufpb.br.gui.JanelaSacar;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class BotaoSacarController implements ActionListener {
    private InterfaceBanco interfaceBanco;
    private JanelaBanco janelaBanco;
    public BotaoSacarController(InterfaceBanco interfaceBanco, JanelaBanco janelaBanco) {
        this.interfaceBanco = interfaceBanco;
        this.janelaBanco = janelaBanco;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        janelaBanco.dispose();
        JanelaSacar janelaSacar = new JanelaSacar(interfaceBanco);
        janelaSacar.setVisible(true);
        janelaSacar.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        janelaSacar.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                int fechar = JOptionPane.showConfirmDialog(janelaSacar,"Deseja sair?");
                if(fechar == JOptionPane.YES_OPTION){
                    System.exit(0);
                }
            }
        });
    }
}
