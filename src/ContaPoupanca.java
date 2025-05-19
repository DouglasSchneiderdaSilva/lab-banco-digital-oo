public class ContaPoupanca extends Conta {
    
    private static final double TAXA_RENDIMENTO_MENSAL = 0.005; // 0.5% ao mês

    public ContaPoupanca(Cliente cliente) {
        super(cliente);
    }

    @Override
    public void imprimirExtrato() {
        System.out.println("=== Extrato Conta Poupança ===");
        super.imprimirInfosComuns();
    }
    
    // Funcionalidade 3: Calcular rendimento para conta poupança
    public double calcularRendimento(int meses) {
        if (meses <= 0) {
            return 0;
        }
        
        double montante = this.saldo;
        for (int i = 0; i < meses; i++) {
            montante += montante * TAXA_RENDIMENTO_MENSAL;
        }
        
        return montante - this.saldo;
    }
    
    // Simular rendimento e mostrar na tela
    public void simularRendimento(int meses) {
        double rendimento = calcularRendimento(meses);
        double montanteFinal = this.saldo + rendimento;
        
        System.out.println("\n=== Simulação de Rendimento ===");
        System.out.println("Saldo atual: R$ " + String.format("%.2f", this.saldo));
        System.out.println("Período: " + meses + " meses");
        System.out.println("Taxa mensal: " + String.format("%.2f", TAXA_RENDIMENTO_MENSAL * 100) + "%");
        System.out.println("Rendimento: R$ " + String.format("%.2f", rendimento));
        System.out.println("Montante final: R$ " + String.format("%.2f", montanteFinal));
    }
}