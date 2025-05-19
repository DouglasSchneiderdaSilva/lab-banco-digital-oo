import java.util.List;
import java.util.Optional;

public class Main {

    public static void main(String[] args) {
        // Criando o banco
        Banco banco = new Banco("ByteBank");
        
        // Criando clientes
        Cliente venilton = new Cliente("Venilton", "123.456.789-00");
        Cliente maria = new Cliente("Maria", "987.654.321-00", "maria@email.com", "99999-8888");
        Cliente joao = new Cliente("João", "111.222.333-44");
        Cliente ana = new Cliente("Ana", "444.555.666-77");
        
        // Adicionando clientes ao banco
        banco.adicionarCliente(venilton);
        banco.adicionarCliente(maria);
        banco.adicionarCliente(joao);
        banco.adicionarCliente(ana);
        
        // Criando contas
        Conta ccVenilton = new ContaCorrente(venilton);
        Conta poupancaVenilton = new ContaPoupanca(venilton);
        Conta ccMaria = new ContaCorrente(maria);
        Conta poupancaMaria = new ContaPoupanca(maria);
        Conta ccJoao = new ContaCorrente(joao);
        Conta poupancaAna = new ContaPoupanca(ana);
        
        // Adicionando contas ao banco
        banco.adicionarConta(ccVenilton);
        banco.adicionarConta(poupancaVenilton);
        banco.adicionarConta(ccMaria);
        banco.adicionarConta(poupancaMaria);
        banco.adicionarConta(ccJoao);
        banco.adicionarConta(poupancaAna);
        
        // Realizando operações
        ccVenilton.depositar(1000);
        ccVenilton.transferir(300, poupancaVenilton);
        
        ccMaria.depositar(2500);
        ccMaria.transferir(1000, poupancaMaria);
        
        ccJoao.depositar(800);
        poupancaAna.depositar(1200);
        
        // Teste das funcionalidades
        
        // 1. Listar clientes em ordem alfabética
        System.out.println("\n===== CLIENTES EM ORDEM ALFABÉTICA =====");
        List<Cliente> clientesOrdenados = banco.listarClientesOrdemAlfabetica();
        for (Cliente cliente : clientesOrdenados) {
            System.out.println(cliente);
        }
        
        // 2. Buscar conta por número
        System.out.println("\n===== BUSCA DE CONTA =====");
        int numeroBusca = 1; // Número da primeira conta criada
        Optional<Conta> contaEncontrada = banco.buscarContaPorNumero(numeroBusca);
        if (contaEncontrada.isPresent()) {
            System.out.println("Conta encontrada:");
            contaEncontrada.get().imprimirExtrato();
        } else {
            System.out.println("Conta #" + numeroBusca + " não encontrada.");
        }
        
        // 3. Calcular rendimento para conta poupança
        System.out.println("\n===== SIMULAÇÃO DE RENDIMENTO =====");
        ContaPoupanca poupanca = (ContaPoupanca) poupancaMaria;
        poupanca.simularRendimento(12); // Simulação para 12 meses
        
        // 4. Emitir relatório de contas do banco
        System.out.println("\n===== RELATÓRIO DE CONTAS =====");
        banco.emitirRelatorioContas();
    }

}