public class SistemaBancario {
    public static void main(String[] args) {
//        1 Banco
        Banco banco = new Banco();

//        2 Lojas
        Loja loja1 = new Loja("Loja 1", 5000);
        Loja loja2 = new Loja("Loja 2", 5000);

        Loja[] lojas = {loja1, loja2};

//        4 Funcionarios;
        Funcionario f1 = new Funcionario(banco, "Func Loja 1 - 1");
        Funcionario f2 = new Funcionario(banco, "Func Loja 1 - 2");
        Funcionario f3 = new Funcionario(banco, "Func Loja 2 - 1");
        Funcionario f4 = new Funcionario(banco, "Func Loja 2 - 2");

//        2 funcionarios por loja
        loja1.contratarFuncionario(f1);
        loja1.contratarFuncionario(f2);
        loja2.contratarFuncionario(f3);
        loja2.contratarFuncionario(f4);

//        5 Clientes
        Cliente c1 = new Cliente(banco, 1000, lojas, "Cliente 1");
        Cliente c2 = new Cliente(banco, 1000, lojas, "Cliente 2");
        Cliente c3 = new Cliente(banco, 1000, lojas, "Cliente 3");
        Cliente c4 = new Cliente(banco, 1000, lojas, "Cliente 4");
        Cliente c5 = new Cliente(banco, 1000, lojas, "Cliente 5");

        c1.start();
        c2.start();
        c3.start();
        c4.start();
        c5.start();

        f1.start();
        f2.start();
        f3.start();
        f4.start();
    }
}
