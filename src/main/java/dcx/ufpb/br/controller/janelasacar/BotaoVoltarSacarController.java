package dcx.ufpb.br.controller.janelasacar;

import dcx.ufpb.br.banco.InterfaceBanco;
import dcx.ufpb.br.gui.JanelaBanco;
import dcx.ufpb.br.gui.JanelaSacar;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class BotaoVoltarSacarController implements ActionListener {
    private InterfaceBanco interfaceBanco;
    private JanelaSacar janelaSacar;

    public BotaoVoltarSacarController(InterfaceBanco interfaceBanco, JanelaSacar janelaSacar){
        this.interfaceBanco = interfaceBanco;
        this.janelaSacar = janelaSacar;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        janelaSacar.dispose();
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
