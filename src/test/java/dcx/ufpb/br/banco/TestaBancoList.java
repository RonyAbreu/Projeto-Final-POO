package dcx.ufpb.br.banco;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class TestaBancoList {
    @Test
    public void testaBancoList(){
        BancoList bancoList = new BancoList(new ArrayList<>());
        Conta rony = new Conta(new Cliente("Rony","123.456"),"12","34", 200);
        try {
            bancoList.abrirConta("maria","333","333","333",0);
            bancoList.abrirConta("jose","4.4","4.4","4.4",0);
            bancoList.abrirContaEspecial("Raiany","222","222","222",100,1000);
            System.out.println("maria foi adicionada!");
            System.out.println("jose foi adicionado!");
            System.out.println("Raiany foi adicionada!");
        } catch (ContaJaExisteException e) {
            fail("Não deve lançar exceção!");
        }
        assertEquals("Rony", rony.cliente.getNome());
        assertEquals("123.456", rony.cliente.getCpfTitular());
        assertTrue(bancoList.existeContaCpf("222"));
        assertFalse(bancoList.existeContaCpf("111"));

        try {
            bancoList.depositarEmConta("333","333",200);
            System.out.println("maria depositou 200R$ em sua conta!");
        } catch (ContaInvalidaException e) {
            fail("Não deve lançar exceção!");
        }

        try {
            System.out.println("O saldo de maria é: "+ bancoList.consultarSaldoDeConta("333","333"));
        } catch (ContaInvalidaException e) {
            fail("Não deve lançar exceção!");
        }

        try {
            bancoList.depositarEmConta("4.4","4.4",200);
        } catch (ContaInvalidaException e) {
            fail("Não deve lançar exceção!");
        }

        try {
            bancoList.removerConta("4.4","4.4");
        } catch (ContaInvalidaException e) {
            fail("Não deve lançar exceção!");
        }


        assertFalse(bancoList.existeContaCpf("4.4"));
        assertTrue(bancoList.existeConta("333","333"));
        assertFalse(bancoList.existeConta("11","11"));
    }
}
