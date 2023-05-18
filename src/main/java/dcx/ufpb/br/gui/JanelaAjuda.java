package dcx.ufpb.br.gui;

import javax.swing.*;

public class JanelaAjuda extends JFrame{
    private JPanel painelAjuda;
    private JTabbedPane painelInformativo;

    public JanelaAjuda(){
        setTitle("Abreu Bank");
        setContentPane(painelAjuda);
        setSize(600,500);
        setLocation(650,300);
        setResizable(false);

        painelInformativo.setTitleAt(0,"Sobre");
        painelInformativo.setTitleAt(1,"Contas");
    }
}
