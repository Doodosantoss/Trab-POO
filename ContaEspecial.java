public class ContaEspecial extends Conta {
    private double limite;    
    
    public ContaEspecial(int numero) {
        super(numero);
        this.limite = 500;
    }

    public double getLimite() {
        return limite;
    }

    public void setLimite(double limite) {
        this.limite = limite;
    }
    
    @Override
    public String imprimir(String nome, String cpf) {
        return  "Nome:" + nome + 
                "\nCPF:" + cpf + 
                "\nNumero:" + this.getNumero() + 
                "\nSaldo:" + this.getSaldo() +
                "\nLimite:" + this.limite;
    }
    
    @Override
    public boolean sacar(double quantia) {
        if (this.getSaldo() - quantia >= -limite) {
            this.setSaldo(this.getSaldo() - quantia);
            return true;
        }
        else {
            return false;
        }
    }
}
