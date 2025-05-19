import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class Banco {

    private String nome;
    private List<Conta> contas;
    private List<Cliente> clientes;

    public Banco(String nome) {
        this.nome = nome;
        this.contas = new ArrayList<>();
        this.clientes = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Conta> getContas() {
        return contas;
    }

    public void setContas(List<Conta> contas) {
        this.contas = contas;
    }
    
    public List<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(List<Cliente> clientes) {
        this.clientes = clientes;
    }
    
    // Funcionalidade 1: Listar clientes em ordem alfabética
    public List<Cliente> listarClientesOrdemAlfabetica() {
        List<Cliente> clientesOrdenados = new ArrayList<>(clientes);
        Collections.sort(clientesOrdenados, Comparator.comparing(Cliente::getNome));
        return clientesOrdenados;
    }
    
    // Funcionalidade 2: Buscar conta por número
    public Optional<Conta> buscarContaPorNumero(int numeroConta) {
        return contas.stream()
                .filter(conta -> conta.getNumero() == numeroConta)
                .findFirst();
    }
    
    // Adicionar cliente
    public void adicionarCliente(Cliente cliente) {
        this.clientes.add(cliente);
    }
    
    // Adicionar conta
    public void adicionarConta(Conta conta) {
        this.contas.add(conta);
    }
    
    // Funcionalidade 4: Emitir relatório de todas as contas
    public void emitirRelatorioContas() {
        System.out.println("===================================");
        System.out.println("RELATÓRIO DE CONTAS - " + this.nome);
        System.out.println("===================================");
        System.out.println("Total de contas: " + contas.size());
        
        double saldoTotal = 0;
        System.out.println("\nCONTAS CORRENTES:");
        for (Conta conta : contas) {
            if (conta instanceof ContaCorrente) {
                System.out.println("Conta #" + conta.getNumero() + " - Titular: " + conta.cliente.getNome() + " - Saldo: R$ " + String.format("%.2f", conta.getSaldo()));
                saldoTotal += conta.getSaldo();
            }
        }
        
        System.out.println("\nCONTAS POUPANÇA:");
        for (Conta conta : contas) {
            if (conta instanceof ContaPoupanca) {
                System.out.println("Conta #" + conta.getNumero() + " - Titular: " + conta.cliente.getNome() + " - Saldo: R$ " + String.format("%.2f", conta.getSaldo()));
                saldoTotal += conta.getSaldo();
            }
        }
        
        System.out.println("\nSaldo total no banco: R$ " + String.format("%.2f", saldoTotal));
        System.out.println("===================================");
    }
}