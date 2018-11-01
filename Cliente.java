public class Cliente {
    private String cpf, nome, endereco, telefone;
    private Conta conta;

    public Cliente(String cpf, String nome, String endereco, String telefone, int numeroDaConta, int tipoDeConta) {
        this.cpf = cpf;
        this.nome = nome;
        this.endereco = endereco;
        this.telefone = telefone;
        
        switch(tipoDeConta) {
            case 0:
                this.conta = new Conta(numeroDaConta);
                break;
            case 1:
                this.conta = new ContaEspecial(numeroDaConta);
                break;
        }
    }
    
    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
    
    public Conta getConta() {
        return conta;
    } //Conta só tem getters, para evitar sobrescrita
    
    public String imprimir() {
        return  "Nome: " + this.nome +
                "\nCPF: " + this.cpf +
                "\nEndereço: " + this.endereco +
                "\nTelefone: " + this.telefone;
    }
}