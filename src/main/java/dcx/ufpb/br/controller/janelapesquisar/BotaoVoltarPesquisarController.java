package dcx.ufpb.br.controller.janelapesquisar;

import dcx.ufpb.br.banco.InterfaceBanco;
import dcx.ufpb.br.gui.JanelaBanco;
import dcx.ufpb.br.gui.JanelaPesquisa;


import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class BotaoVoltarPesquisarController implements ActionListener {
    private JanelaPesquisa janelaPesquisa;
    private InterfaceBanco interfaceBanco;

    public BotaoVoltarPesquisarController(JanelaPesquisa janelaPesquisa, InterfaceBanco interfaceBanco) {
        this.janelaPesquisa = janelaPesquisa;
        this.interfaceBanco = interfaceBanco;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        janelaPesquisa.dispose();
        JanelaBanco janelaBanco = new JanelaBanco(interfaceBanco);
        janelaBanco.setVisible(true);
        janelaBanco.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        janelaBanco.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                int fechar = JOptionPane.showConfirmDialog(janelaBanco,"Lembre de usar o botão (Sair e Salvar), para sair do Banco com seus dados Salvos!\nDeseja sair?");
                if (fechar == JOptionPane.YES_OPTION) {
                    System.exit(0);
                }
            }
        });
    }
}
