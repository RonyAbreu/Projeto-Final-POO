package dcx.ufpb.br.banco;

public class SaldoInvalidoException extends Exception{
    public SaldoInvalidoException(String msg){
        super(msg);
    }
}
