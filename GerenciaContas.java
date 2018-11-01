import java.util.ArrayList;

public class GerenciaContas {
    private ArrayList<Cliente> clientes = new ArrayList();
    
    public boolean cadastrarConta(Cliente cliente) {
        if (!clientes.isEmpty()) {
            for (Cliente clienteCadast : clientes) {
                if (clienteCadast.getCpf().equals(cliente.getCpf()) || clienteCadast.getConta().getNumero() == cliente.getConta().getNumero()) {
                    return false;
                }
            }           
        }
        clientes.add(cliente);
        return true;
    }
    
    public String imprimir() {
        String imprecao = "";
        
        if (!clientes.isEmpty()) {
            for (Cliente cliente : clientes) {
                imprecao += cliente.getConta().imprimir(cliente.getNome(), cliente.getCpf()) + "\n\n";
            }
        }
        
        return imprecao;
    }
    
    public Cliente buscar(int numero) {
        if (!clientes.isEmpty()) {
            for (Cliente cliente : clientes) {
                if (cliente.getConta().getNumero() == numero) {
                    return cliente;
                }
            }
        }
        
        return null;
    }
}
