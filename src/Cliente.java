public class Cliente extends Thread {
    private final Conta conta;
    private final Banco banco;
    private final Loja loja1, loja2;

    public Cliente(Conta conta, Banco banco, Loja loja1, Loja loja2) {
        this.conta = conta;
        this.banco = banco;
        this.loja1 = loja1;
        this.loja2 = loja2;
    }

    public double getSaldoConta() {
        return conta.getSaldo();
    }

    @Override
    public void run() {
        while (conta.getSaldo() > 0) {
            double valorCompra = Math.random() > 0.5 ? 100 : 200;
            Loja lojaAtual = Math.random() > 0.5 ? loja1 : loja2;
            banco.transferir(conta, lojaAtual.getConta(), valorCompra);

            try {
                Thread.sleep(1000); // Simula o tempo entre compras
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}
