public class Cliente extends Thread {
    private Conta conta;
    private Banco banco;
    private Loja[] lojas;

    public Cliente(Banco banco, int saldoInicial, Loja[] lojas, String nome) {
        super(nome);
        this.banco = banco;
        this.conta = new Conta(saldoInicial);
        this.lojas = lojas;
    }

    @Override
    public void run() {
        int lojaIndex = 0;
        while (conta.getSaldo() > 0) {
            int valorCompra = Math.random() < 0.5 ? 100 : 200;
            Loja loja = lojas[lojaIndex];
            if (conta.sacar(valorCompra)) {
                banco.transferir(conta, loja.getConta(), valorCompra);
            }
            lojaIndex = (lojaIndex + 1) % lojas.length;
            try {
                Thread.sleep(2000); // Simula tempo entre compras
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}