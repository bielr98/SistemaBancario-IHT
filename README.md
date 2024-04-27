# Iteração Humano Computador AT2/N1 - Atividade prática individual - Bimestre N1
# Sistema Bancário com Threads em Java
Este projeto implementa um sistema bancário simulado utilizando Java e conceitos de programação concorrente com threads. O sistema garante a sincronização de transações e a consistência de saldos através de uma implementação cuidadosa usando o objeto `Banco`.

## Entidades do Sistema

O sistema consiste nas seguintes entidades principais:

- **Banco**: Intermedia todas as transações financeiras de forma sincronizada.
- **Loja**: Mantém uma conta bancária e gerencia pagamentos para clientes e salários para funcionários.
- **Funcionário**: Cada funcionário possui duas contas, uma para salário e outra para investimentos, e opera como uma thread independente.
- **Cliente**: Cada cliente tem uma conta bancária e realiza compras em lojas, operando como uma thread.
- **Conta**: Gerencia o saldo e permite operações de depósito e saque, com métodos sincronizados para garantir a segurança em ambientes multithread.

## Fluxo de Operação

### Inicialização

- Um banco e duas lojas são criados com suas respectivas contas.
- Quatro funcionários são associados às lojas (dois em cada loja).
- Cinco clientes são criados, cada um com uma conta inicial.

### Funcionamento

1. **Clientes**
   - Cada cliente tenta fazer compras de R$100 ou R$200 alternando entre as duas lojas.
   - As transações são intermediadas pelo banco para garantir a consistência dos saldos.

2. **Lojas**
   - Verificam se possuem saldo suficiente para pagar os salários dos funcionários.
   - Utilizam o banco para transferir os salários de forma sincronizada.

3. **Funcionários**
   - Monitoram a conta do salário para detectar novos depósitos.
   - Automaticamente transferem 20% do seu salário para uma conta de investimentos.

### Sincronização

- Todas as transações são sincronizadas através do banco para evitar condições de corrida e inconsistências nos saldos.

## Logs e Monitoramento

- O sistema registra logs para cada operação significativa, permitindo o acompanhamento das atividades e a validação das operações.

## Considerações Adicionais

- **Tratamento de Exceções**: Implementação de tratamento adequado para possíveis exceções em operações de rede ou IO.
- **Testes de Concorrência**: Testes intensivos são necessários para garantir a correta manipulação da concorrência e sincronização.

## Conclusão

O sistema continua operando até que todas as transações dos clientes sejam concluídas e os saldos estejam zerados, garantindo que todos os processos sejam finalizados corretamente.

