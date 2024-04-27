import java.util.concurrent.locks.ReentrantLock;

public class Banco {
    private final ReentrantLock lock = new ReentrantLock();

    public void transferir(Conta de, Conta para, double valor) {
        lock.lock();
        try {
            if (de.retirar(valor)) {
                para.depositar(valor);
                System.out.println("Transferência realizada: " + valor + " de " + de + " para " + para);
            } else {
                System.out.println("Transferência falhou: saldo insuficiente.");
            }
        } finally {
            lock.unlock();
        }
    }
}
