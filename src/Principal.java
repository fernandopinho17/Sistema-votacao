import java.util.Scanner;

public class Principal {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        GerenciamentoVotacao sistema = new GerenciamentoVotacao();

        int opcao;

        while (true) {
            System.out.println("Cadastrar pessoa candidata?");
            System.out.println("1 - Sim");
            System.out.println("2 - Não");
            System.out.println("Entre com o número correspondente à opção desejada:");

            opcao = scanner.nextInt();

            if (opcao == 2) {
                break;
            }

            System.out.println("Entre com o nome da pessoa candidata:");
            String nome = scanner.next();

            System.out.println("Entre com o número da pessoa candidata:");
            int numero = scanner.nextInt();

            sistema.cadastrarPessoaCandidata(nome, numero);
        }

        while (true) {
            System.out.println("Cadastrar pessoa eleitora?");
            System.out.println("1 - Sim");
            System.out.println("2 - Não");
            System.out.println("Entre com o número correspondente à opção desejada:");

            opcao = scanner.nextInt();

            if (opcao == 2) {
                break;
            }

            System.out.println("Entre com o nome da pessoa eleitora:");
            String nome = scanner.next();

            System.out.println("Entre com o cpf da pessoa eleitora:");
            String cpf = scanner.next();

            sistema.cadastrarPessoaEleitora(nome, cpf);
        }


        while (true) {
            System.out.println("Entre com o número correspondente à opção desejada:");
            System.out.println("1 - Votar");
            System.out.println("2 - Resultado Parcial");
            System.out.println("3 - Finalizar Votação");

            opcao = scanner.nextInt();

            if (opcao == 1) {

                System.out.println("Entre com o cpf da pessoa eleitora:");
                String cpf = scanner.next();

                System.out.println("Entre com o número da pessoa candidata:");
                int numero = scanner.nextInt();

                sistema.votar(cpf, numero);

            } else if (opcao == 2) {

                sistema.mostrarResultado();

            } else if (opcao == 3) {

                sistema.mostrarResultado();
                break;
            }
        }

        scanner.close();
    }
}
