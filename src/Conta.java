public class Conta {
    private int saldo;

    public Conta(int saldoInicial) {
        this.saldo = saldoInicial;
    }

    public synchronized void depositar(int valor) {
        saldo += valor;
        System.out.println(Thread.currentThread().getName() + " depositou " + valor + "; Saldo agora é: " + saldo);
    }

    public synchronized boolean sacar(int valor) {
        if (saldo >= valor) {
            saldo -= valor;
            System.out.println(Thread.currentThread().getName() + " sacou " + valor + "; Saldo restante: " + saldo);
            return true;
        }
        return false;
    }

    public int getSaldo() {
        return saldo;
    }
}
