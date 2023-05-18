package dcx.ufpb.br.banco;

import java.io.Serializable;

public class ContaEspecial extends Conta implements Serializable {

    private double credito;

    public ContaEspecial(Cliente cliente,String numC, String numAg, double saldo, double credito){
        super(cliente,numC,numAg,saldo);
        this.credito = credito;
    }

    public ContaEspecial(){
        this(new Cliente("",""),"","",0,1000);
    }

    public String toString() {
        return "------------------------------]\nNome: "+cliente.getNome()+"\nNúmero da Conta: " + getNumeroConta() + "\nNúmero da Agência: " + getNumeroAgencia()
                + "\nCPF: " + cliente.getCpfTitular() + "\nSaldo em conta: " + getSaldo() + "R$" + "\nCrédito disponível: "+this.credito+"R$\n[------------------------------";
    }

    public String toStringCredito(){
        return "Credito: "+ getCredito();
    }

    public double getCredito() {
        return credito;
    }

    public void setCredito(double credito) {
        this.credito = credito;
    }

}
