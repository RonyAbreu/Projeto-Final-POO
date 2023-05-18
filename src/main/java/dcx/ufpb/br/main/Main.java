package dcx.ufpb.br.main;

import dcx.ufpb.br.banco.BancoList;
import dcx.ufpb.br.banco.Conta;
import dcx.ufpb.br.banco.GravadorDeContas;
import dcx.ufpb.br.banco.InterfaceBanco;
import dcx.ufpb.br.gui.JanelaAjuda;
import dcx.ufpb.br.gui.JanelaBanco;

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        InterfaceBanco meuBanco;
        GravadorDeContas gravador = new GravadorDeContas();
        try{
            ArrayList<Conta> contasRecuperadas = gravador.lerContas();
            JOptionPane.showMessageDialog(null, "Contas Recuperadas Com Sucesso!");
            meuBanco = new BancoList(contasRecuperadas);
        } catch (IOException e){
            meuBanco = new BancoList(new ArrayList<>());
            JOptionPane.showMessageDialog(null, "Sistema iniciado sem dados");
        }

        JanelaBanco janela = new JanelaBanco(meuBanco);
        janela.setVisible(true);
        janela.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        janela.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                int fechar = JOptionPane.showConfirmDialog(janela,"Lembre de usar o botão (Sair e Salvar), para sair do Banco com seus dados Salvos!\nDeseja Sair sem Salvar?");
                if(fechar == JOptionPane.YES_OPTION){
                    System.exit(0);
                }
            }
        });
        JanelaAjuda janelaAjuda = new JanelaAjuda();
        janelaAjuda.setVisible(true);
    }
}
