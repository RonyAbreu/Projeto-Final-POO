package dcx.ufpb.br.banco;

import java.io.*;
import java.util.ArrayList;

public class GravadorDeContas {
    private String arquivoDeContas;

    public GravadorDeContas(String arquivoDeContas) {
        this.arquivoDeContas = arquivoDeContas;
    }

    public GravadorDeContas() {
        this("Conta.dat");
    }

    public void gravaContas(ArrayList<Conta> contas) throws IOException {
        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(this.arquivoDeContas))){
            oos.writeObject(contas);
        } catch (IOException e){
            throw new IOException("Arquivo não encontrado!");
        }

    }

    public ArrayList<Conta> lerContas() throws IOException {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(this.arquivoDeContas))){
            return (ArrayList<Conta>) ois.readObject();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("Ocorreu um problema, tente novamente!",e);
        } catch (IOException e){
            throw new IOException("Arquivo não encontrado!");
        }
    }
}
