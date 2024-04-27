public class SistemaBancario {
    public static void main(String[] args) {
        // Criar o banco
        Banco banco = new Banco();

        // Criar as contas das lojas
        Conta contaLoja1 = new Conta(0);
        Conta contaLoja2 = new Conta(0);

        // Criar as lojas
        Loja loja1 = new Loja(banco, contaLoja1);
        Loja loja2 = new Loja(banco, contaLoja2);

        // Criar e adicionar funcionários às lojas
        Funcionario func1 = new Funcionario(banco);
        Funcionario func2 = new Funcionario(banco);
        Funcionario func3 = new Funcionario(banco);
        Funcionario func4 = new Funcionario(banco);

        loja1.adicionarFuncionario(func1, 0);
        loja1.adicionarFuncionario(func2, 1);
        loja2.adicionarFuncionario(func3, 0);
        loja2.adicionarFuncionario(func4, 1);

        // Criar as contas dos clientes
        Cliente[] clientes = new Cliente[5];
        for (int i = 0; i < clientes.length; i++) {
            clientes[i] = new Cliente(new Conta(1400), banco, loja1, loja2);
        }

        // Iniciar as threads dos clientes
        for (Cliente cliente : clientes) {
            cliente.start();
        }

        // Iniciar as threads dos funcionários
        func1.start();
        func2.start();
        func3.start();
        func4.start();

        // Esperar os clientes terminarem suas compras
        for (Cliente cliente : clientes) {
            try {
                cliente.join();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }

        // Realizar pagamento dos funcionários
        loja1.pagarFuncionarios();
        loja2.pagarFuncionarios();

        // Esperar os funcionários terminarem suas operações
        try {
            func1.join();
            func2.join();
            func3.join();
            func4.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        // Relatório final dos saldos
        System.out.println("Saldo final conta Loja 1: " + contaLoja1.getSaldo());
        System.out.println("Saldo final conta Loja 2: " + contaLoja2.getSaldo());
        System.out.println("Saldo final dos clientes:");
        for (int i = 0; i < clientes.length; i++) {
            System.out.println("Cliente " + (i + 1) + ": " + clientes[i].getSaldoConta());
        }
    }
}
