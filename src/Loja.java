public class Loja {
    private final Conta contaLoja;
    private final Funcionario[] funcionarios;
    private final Banco banco;

    public Loja(Banco banco, Conta conta) {
        this.banco = banco;
        this.contaLoja = conta;
        this.funcionarios = new Funcionario[2]; // Supondo 2 funcionários por loja
    }

    public void adicionarFuncionario(Funcionario funcionario, int indice) {
        if (indice < funcionarios.length) {
            funcionarios[indice] = funcionario;
        }
    }

    public Conta getConta() {
        return contaLoja;
    }

    public void pagarFuncionarios() {
        for (Funcionario funcionario : funcionarios) {
            if (contaLoja.getSaldo() >= 1400) {
                banco.transferir(contaLoja, funcionario.getContaSalario(), 1400);
                funcionario.investir();
            }
        }
    }
}
