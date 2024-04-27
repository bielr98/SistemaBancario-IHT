import java.util.ArrayList; // Import para ArrayList
import java.util.List;      // Import para List

public class Loja {
    private Conta conta;
    private String nome;
    private List<Funcionario> funcionarios;  // Lista para armazenar funcionários


    public Loja(String nome, int saldoInicial) {
        this.nome = nome;
        this.conta = new Conta(saldoInicial);
        this.funcionarios = new ArrayList<>();  // Inicializando a lista de funcionários
    }


    public Conta getConta() {
        return conta;  // Retorna a conta associada à loja
    }

    public void contratarFuncionario(Funcionario funcionario) {
        funcionarios.add(funcionario);  // Adiciona o funcionário à lista de funcionários da loja
        funcionario.setLoja(this);      // Configura a loja do funcionário, se necessário
    }

    public void receberPagamento(int valor) {
        conta.depositar(valor);
    }

    public boolean pagarFuncionario(Funcionario funcionario, int valor) {
        if (conta.sacar(valor)) {
            funcionario.receberSalario(valor);
            return true;
        }
        return false;
    }

    public int getSaldo() {
        return conta.getSaldo();
    }

    public String getNome() {
        return nome;
    }

    public void pagarSalarios() {
        for (Funcionario f : funcionarios) {
            if (conta.getSaldo() >= 1400) {
                conta.sacar(1400);
                f.receberSalario(1400);
            }
        }
    }
}
