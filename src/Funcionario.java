public class Funcionario extends Thread {
    private Conta contaSalario;
    private Conta contaInvestimento;
    private Banco banco;
    private Loja loja;  // Loja à qual o funcionário está associado

    public Funcionario(Banco banco, String nome) {
        super(nome);
        this.banco = banco;
        this.contaSalario = new Conta(0);
        this.contaInvestimento = new Conta(0);
    }

    public void setLoja(Loja loja) {
        this.loja = loja;  // Configura a loja do funcionário
    }

    public void receberSalario(int valor) {
        contaSalario.depositar(valor);
        investir();
    }

    private void investir() {
        int valorAInvestir = contaSalario.getSaldo() / 5;  // 20% do saldo
        contaSalario.sacar(valorAInvestir);
        contaInvestimento.depositar(valorAInvestir);
    }

    @Override
    public void run() {
        // Implementação para esperar receber o salário e investir
    }
}
