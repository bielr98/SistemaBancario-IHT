public class Funcionario extends Thread {
    private final Conta contaSalario;
    private final Conta contaInvestimento;
    private final Banco banco;

    public Funcionario(Banco banco) {
        this.banco = banco;
        this.contaSalario = new Conta(0);
        this.contaInvestimento = new Conta(0);
    }

    public Conta getContaSalario() {
        return contaSalario;
    }

    @Override
    public void run() {
        // Os funcionários podem realizar outras operações se necessário
    }

    public void investir() {
        double valorInvestir = contaSalario.getSaldo() * 0.2;
        banco.transferir(contaSalario, contaInvestimento, valorInvestir);
    }
}
