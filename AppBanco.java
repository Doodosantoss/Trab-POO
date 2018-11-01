import javax.swing.JOptionPane;

public class AppBanco {

    public static void main(String[] args) {
        String menu;
        GerenciaContas gerenciador = new GerenciaContas();
        
        do {
            menu = JOptionPane.showInputDialog("MENU\n\n"
                    + "1 - Cadastrar Conta\n"
                    + "2 - Cadastrar Conta Especial\n"
                    + "3 - Relatórios\n"
                    + "4 - Movimentação\n"
                    + "5 - Sair");
            
            switch(menu) {
                case "1":
                    String cpf = JOptionPane.showInputDialog("Insira o cpf:");
                    String nome = JOptionPane.showInputDialog("Insira o nome:");
                    String endereco = JOptionPane.showInputDialog("Insira o endereco:");
                    String telefone = JOptionPane.showInputDialog("Insira o telefone:");
                    int conta = Integer.parseInt(JOptionPane.showInputDialog("Insira o numero da conta:"));
                    
                    if(gerenciador.cadastrarConta(new Cliente(cpf, nome, endereco, telefone, conta, 0))) {
                        JOptionPane.showMessageDialog(null, "Cadastro efetuado com sucesso!");
                    }
                    else {
                        JOptionPane.showMessageDialog(null, "Já existe um cliente/conta com estes dados, o cadastro foi cancelado!");
                    }
                    break;
                case "2":
                    String cpfE = JOptionPane.showInputDialog("Insira o cpf:");
                    String nomeE = JOptionPane.showInputDialog("Insira o nome:");
                    String enderecoE = JOptionPane.showInputDialog("Insira o endereco:");
                    String telefoneE = JOptionPane.showInputDialog("Insira o telefone:");
                    int contaE = Integer.parseInt(JOptionPane.showInputDialog("Insira o numero da conta:"));
                    
                    if(gerenciador.cadastrarConta(new Cliente(cpfE, nomeE, enderecoE, telefoneE, contaE, 1))) {
                        JOptionPane.showMessageDialog(null, "Cadastro efetuado com sucesso!");
                    }
                    else {
                        JOptionPane.showMessageDialog(null, "Já existe um cliente/conta com estes dados, o cadastro foi cancelado!");
                    }
                    break;
                case "3":
                    menu += "." + JOptionPane.showInputDialog("RELATÓRIOS\n\n"
                            + "1 - Listar todas contas cadastradas\n"
                            + "2 - Buscar contas pelo número");
                    
                    switch(menu) {
                        case "3.1":
                            String todasContas = gerenciador.imprimir();
                            
                            JOptionPane.showMessageDialog(null, todasContas);                            
                            break;
                        case "3.2":
                            int numeroPesquisa = Integer.parseInt(JOptionPane.showInputDialog("Insira o numero da conta que deseja pesquisar:"));
                            Cliente cliente = gerenciador.buscar(numeroPesquisa);
                            JOptionPane.showMessageDialog(null, cliente.getConta().imprimir(cliente.getNome(), cliente.getCpf()));
                            break;
                    }
                    break;
                case "4":
                    menu += "." + JOptionPane.showInputDialog("MOVIMENTAÇÃO\n\n"
                            + "1 - Efetuar um depósito\n"
                            + "2 - Efetuar um saque");
                    
                    switch(menu) {
                        case "4.1":
                            int numeroPesquisaDeposito = Integer.parseInt(JOptionPane.showInputDialog("Insira o numero da conta que deseja efetuar a operação:"));
                            double quantiaDeposito = Double.parseDouble(JOptionPane.showInputDialog("Insira a quantia que deseja depositar:"));
                            
                            Cliente clienteDeposito = gerenciador.buscar(numeroPesquisaDeposito);
                            clienteDeposito.getConta().depositar(quantiaDeposito);
                            break;
                        case "4.2":
                            int numeroPesquisaSaque = Integer.parseInt(JOptionPane.showInputDialog("Insira o numero da conta que deseja efetuar a operação:"));
                            double quantiaSaque = Double.parseDouble(JOptionPane.showInputDialog("Insira a quantia que deseja sacar:"));
                            
                            Cliente clienteSaque = gerenciador.buscar(numeroPesquisaSaque);
                            if(clienteSaque.getConta().sacar(quantiaSaque)) {
                                JOptionPane.showMessageDialog(null, "Saque efetuado com sucesso!");
                            }
                            else {
                                JOptionPane.showMessageDialog(null, "Conta sem saldo sulficiente para saque!");
                            }
                            break;
                    }
                    break;
                case "5":
                    JOptionPane.showMessageDialog(null, "Obrigado por usar nosso sistema!");
                    break;
                
            }
        } while (!menu.equals("5"));
    }
    
}
