import java.util.Scanner;

public class Emprestimo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean continuar = true;

        while (continuar) {
            // Solicitação dos dados do colaborador
            System.out.print("Nome do colaborador: ");
            String nome = scanner.nextLine();

            System.out.print("Está a quantos anos na empresa? : ");
            int anosAdmissao = scanner.nextInt();

            System.out.print("Salário atual: ");
            double salarioAtual = scanner.nextDouble();

            System.out.print("Valor de empréstimo desejado: ");
            double valorEmprestimo = scanner.nextDouble();

            // Verifica se o colaborador atende aos requisitos mínimos
            if (anosAdmissao > 5) {
                if (valorEmprestimo % 2 == 0 && valorEmprestimo <= salarioAtual * 2) {
                    escolherFormaPagamento(nome, valorEmprestimo);
                } else {
                    System.out.println("Valor de empréstimo inválido. O valor deve ser um múltiplo de 2 e não pode exceder 2 vezes o salário.");
                }
            } else {
                System.out.println("Agradecemos seu interesse, mas você não atende os requisitos mínimos do programa.");
            }

            System.out.print("Deseja continuar (S/N)? ");
            String resposta = scanner.next().trim().toLowerCase();
            continuar = resposta.equals("s");
            scanner.nextLine(); // Limpa o buffer do teclado
        }
    }
    // fazer a escolha entre os 3 métodos para forma de pagamento
    public static void escolherFormaPagamento(String nome, double valorEmprestimo) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Opções de retirada:");
        System.out.println("1. Notas de maior valor");
        System.out.println("2. Notas de menor valor");
        System.out.println("3. Notas meio a meio");
        System.out.print("Escolha a forma de pagamento (1/2/3): ");
        int escolha = scanner.nextInt();

        switch (escolha) {
            case 1:
                calcularNotasMaiorValor(nome, valorEmprestimo);
                break;
            case 2:
                calcularNotasMenorValor(nome, valorEmprestimo);
                break;
            case 3:
                calcularNotasMeioAMeio(nome, valorEmprestimo);
                break;
            default:
                System.out.println("Escolha inválida.");
        }
    }
    //Método para calcular com notas de maior valor.
    public static void calcularNotasMaiorValor(String nome, double valorEmprestimo) {
        int quantidadeNotas100 = (int) (valorEmprestimo / 100);
        int quantidadeNotas50 = (int) ((valorEmprestimo % 100) / 50);

        System.out.println("Valor empréstimo: " + valorEmprestimo + " reais");
        System.out.println("Notas de maior valor:");
        System.out.println("➢ " + quantidadeNotas100 + " x 100 reais;");
        System.out.println("➢ " + quantidadeNotas50 + " x 50 reais;");
    }
    //Método para calcular com notas de menor valor.
    public static void calcularNotasMenorValor(String nome, double valorEmprestimo) {
        int quantidadeNotas20 = (int) (valorEmprestimo / 20);
        int quantidadeNotas10 = (int) ((valorEmprestimo % 20) / 10);
        int quantidadeNotas5 = (int) ((valorEmprestimo % 20 % 10) / 5);

        System.out.println("Valor empréstimo: " + valorEmprestimo + " reais");
        System.out.println("Notas de menor valor:");
        System.out.println("➢ " + quantidadeNotas20 + " x 20 reais;");
        System.out.println("➢ " + quantidadeNotas10 + " x 10 reais;");
        System.out.println("➢ " + quantidadeNotas5 + " x 5 reais;");
    }
    //Método para calcular com notas de maior e menor valor.
    public static void calcularNotasMeioAMeio(String nome, double valorEmprestimo) {
        int metadeValor = (int) (valorEmprestimo / 2);

        int quantidadeNotas100 = (int) (metadeValor / 100);
        int quantidadeNotas50 = (int) ((metadeValor % 100) / 50);
        int quantidadeNotas20 = (int) ((metadeValor % 100 % 50) / 20);
        int quantidadeNotas10 = (int) ((metadeValor % 100 % 50 % 20) / 10);
        int quantidadeNotas5 = (int) ((metadeValor % 100 % 50 % 20 % 10) / 5);

        System.out.println("Valor empréstimo: " + valorEmprestimo + " reais");
        System.out.println(metadeValor + " reais em notas de maior valor:");
        System.out.println("➢ " + quantidadeNotas100 + " x 100 reais;");
        System.out.println("➢ " + quantidadeNotas50 + " x 50 reais;");
        System.out.println("➢ " + quantidadeNotas20 + " x 20 reais;");
        System.out.println("➢ " + quantidadeNotas10 + " x 10 reais;");
        System.out.println("➢ " + quantidadeNotas5 + " x 5 reais;");

        quantidadeNotas20 = (int) (metadeValor / 20);
        quantidadeNotas10 = (int) ((metadeValor % 20) / 10);
        quantidadeNotas5 = (int) ((metadeValor % 20 % 10) / 5);

        System.out.println(metadeValor + " reais em notas de menor valor:");
        System.out.println("➢ " + quantidadeNotas20 + " x 20 reais;");
        System.out.println("➢ " + quantidadeNotas10 + " x 10 reais;");
        System.out.println("➢ " + quantidadeNotas5 + " x 5 reais;");
    }
}

