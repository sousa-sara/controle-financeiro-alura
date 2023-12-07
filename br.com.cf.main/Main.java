import java.util.Scanner;

public class Main {
    private static double saldo = 0; // Variável global para armazenar o saldo

    public static void main(String[] args) {
        Scanner objScanner = new Scanner(System.in);

        System.out.println("Dados Iniciais do Cliente\n\nDigite o seu nome: ");
        String nome = objScanner.nextLine();
        System.out.println("\nQual o tipo de conta: ");
        String tipoDeConta = objScanner.nextLine();
        System.out.println("\nSaldo inicial: ");
        saldo = objScanner.nextDouble();

        exibirDadosIniciais(nome, tipoDeConta, saldo);

        exibirMenu(objScanner);
        objScanner.close(); // Fechar o Scanner após utilização
    }

    // Exibir os dados iniciais do cliente
    private static void exibirDadosIniciais(String nome, String tipoDeConta, double saldoInicial) {
        System.out.println(
                String.format("\nDados Iniciais do Cliente:\n Nome: %s \n Tipo de Conta: %s  \n Saldo Inicial: %.2f",
                        nome, tipoDeConta, saldoInicial));
    }

    // Exibir o menu de opções e direcionar para as funções adequadas
    private static void exibirMenu(Scanner scanner) {
        while (true) {
            System.out.println("\nQual opção do menu deseja consultar?\n\n[1] Consultar saldos"
                    + "\n[2] Depositar valor\n[3] Transferir valor\n[4] Sair\n");

            int opc = scanner.nextInt();

            switch (opc) {
                case 1:
                    consultarSaldos();
                    break;

                case 2:
                    receberValor(scanner);
                    break;

                case 3:
                    transferirValor(scanner);
                    break;

                case 4:
                    System.out.println("\nFinalizando a consulta.");
                    return;

                default:
                    System.out.println("Opção inválida.");
                    break;
            }
        }
    }

    // Consultar saldo atual
    private static void consultarSaldos() {
        System.out.println("\nSaldo atual: " + saldo);
    }

    // Receber valor e adicionar ao saldo
    private static void receberValor(Scanner scanner) {
        System.out.println("\nInforme o valor a depositar: ");
        double valorADepositar = scanner.nextDouble();

        if (valorADepositar <= 0) {
            System.out.println("\nValor inválido para depósito.");
        } else {
            saldo += valorADepositar;
            System.out.println("\nDepósito realizado. Saldo atual: " + saldo);
        }
    }

    // Transferir valor do saldo
    private static void transferirValor(Scanner scanner) {
        System.out.println("\nInforme o valor que deseja transferir: ");
        double valorATransferir = scanner.nextDouble();

        if (valorATransferir <= 0 || valorATransferir > saldo) {
            System.out.println("\nValor inválido ou saldo insuficiente para transferência.");
        } else {
            saldo -= valorATransferir;
            System.out.println("\nTransferência realizada. Saldo atual: " + saldo);
        }
    }
}
