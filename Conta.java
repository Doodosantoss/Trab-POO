public class Conta {
    private int numero;
    private double saldo;

    public Conta(int numero) {
        this.numero = numero;
        this.saldo = 0;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
    
    public String imprimir(String nome, String cpf) {
        return  "Nome:" + nome + 
                "\nCPF:" + cpf + 
                "\nNumero:" + this.numero + 
                "\nSaldo:" + this.saldo;
    }
    
    public void depositar(double quantia) {
        saldo += quantia;
    }
    
    public boolean sacar(double quantia) {
        if (saldo - quantia >= 0) {
            saldo -= quantia;
            return true;
        }
        else {
            return false;
        }
    }
}
