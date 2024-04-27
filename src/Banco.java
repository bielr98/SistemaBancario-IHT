public class Banco {
    public synchronized void transferir(Conta origem, Conta destino, int valor) {
        if (origem.sacar(valor)) {
            destino.depositar(valor);
            System.out.println("Transferido " + valor + " de " + origem + " para " + destino);
        }
    }
}
