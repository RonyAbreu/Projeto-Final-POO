package dcx.ufpb.br.banco;

import java.util.ArrayList;

    public interface InterfaceBanco {
        void abrirConta(String nome, String cpf, String numC, String numAg, double saldo) throws ContaJaExisteException;
        void abrirContaEspecial(String nome, String cpf, String numC, String numAg, double saldo, double credito) throws ContaJaExisteException;
        void removerConta(String numConta, String numAg) throws ContaInvalidaException;
        Conta pesquisarContasDoCliente(String cpf) throws ContaInvalidaException;
        ArrayList<Conta> getContas();
        double consultarSaldoDeConta(String numConta, String numAgencia) throws ContaInvalidaException;
        void transferir(String numContaO, String numAgO,String numContaD, String numAgenciaD, double valor) throws ContaInvalidaException, SaldoInvalidoException;
        void sacarDeConta(String numConta, String numAgencia, double valor) throws ContaInvalidaException, SaldoInvalidoException;
        void depositarEmConta(String numConta, String numAgencia, double valor) throws ContaInvalidaException;
        boolean contaNula(String nome,String cpf, String numC, String numAg);
        boolean contaVazia(String nome, String cpf, String numC, String numAg);
        boolean existeConta(String numConta, String numAg);
        boolean existeContaCpf(String cpf);
        Conta pesquisaNumeroContaENumeroAgencia(String numC, String numAg);
        boolean alterarNome(String cpf,String novoNome) throws ContaInvalidaException;
}

