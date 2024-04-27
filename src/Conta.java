import java.util.concurrent.locks.ReentrantLock;

public class Conta {
    private double saldo;
    private final ReentrantLock lock = new ReentrantLock();

    public Conta(double saldoInicial) {
        this.saldo = saldoInicial;
    }

    public void depositar(double valor) {
        lock.lock();
        try {
            saldo += valor;
            System.out.println("Depósito realizado: " + valor + ". Saldo atual: " + saldo);
        } finally {
            lock.unlock();
        }
    }

    public boolean retirar(double valor) {
        lock.lock();
        try {
            if (saldo >= valor) {
                saldo -= valor;
                System.out.println("Retirada realizada: " + valor + ". Saldo atual: " + saldo);
                return true;
            } else {
                System.out.println("Falha na retirada: Saldo insuficiente.");
                return false;
            }
        } finally {
            lock.unlock();
        }
    }

    public double getSaldo() {
        lock.lock();
        try {
            return saldo;
        } finally {
            lock.unlock();
        }
    }


}
