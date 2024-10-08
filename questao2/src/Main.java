import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Produto p = new Produto();

        System.out.println("Digite o código do produto:");
        p.setCodigo(sc.nextInt());

        System.out.println("Digite o nome do produto:");
        sc.nextLine();  // limpar buffer
        p.setNome(sc.nextLine());

        System.out.println("Digite o tamanho/peso do produto:");
        p.setTamanho(sc.nextDouble());

        System.out.println("Digite a cor do produto:");
        sc.nextLine();  // limpar buffer
        p.setCor(sc.nextLine());

        System.out.println("Digite o valor do produto:");
        p.setValor(sc.nextDouble());

        System.out.println("Digite a quantidade em estoque:");
        p.setQuantidadeEstoque(sc.nextInt());

        exibirDados(p);
        realizarVenda(sc, p);

        sc.close();
    }

    public static void exibirDados(Produto p) {
        System.out.println("Código: " + p.getCodigo());
        System.out.println("Nome: " + p.getNome());
        System.out.println("Tamanho/Peso: " + p.getTamanho());
        System.out.println("Cor: " + p.getCor());
        System.out.println("Valor: " + p.getValor());
        System.out.println("Quantidade em Estoque: " + p.getQuantidadeEstoque());
    }

    public static void realizarVenda(Scanner sc, Produto p) {
        if (p.getQuantidadeEstoque() <= 0) {
            System.out.println("Estoque indisponível para venda.");
            return;
        }

        System.out.println("Quantidade que deseja comprar:");
        int quantidadeVenda = sc.nextInt();

        if (quantidadeVenda > p.getQuantidadeEstoque()) {
            System.out.println("Quantidade insuficiente no estoque.");
            return;
        }

        double valorTotal = p.getValor() * quantidadeVenda;
        System.out.println("Forma de pagamento: ");
        System.out.println("1. Pix");
        System.out.println("2. Espécie");
        System.out.println("3. Transferência");
        System.out.println("4. Débito");
        System.out.println("5. Crédito");

        int opcaoPagamento = sc.nextInt();
        double valorFinal = valorTotal;

        if (opcaoPagamento >= 1 && opcaoPagamento <= 4) {
            valorFinal = valorTotal * 0.95;
            System.out.println("Desconto de 5% aplicado. Valor final: " + valorFinal);
        } else if (opcaoPagamento == 5) {
            System.out.println("Parcelamento em 3x sem juros. Valor total: " + valorFinal);
        }

        if (opcaoPagamento == 2) {
            System.out.println("Informe o valor pago em espécie:");
            double valorPago = sc.nextDouble();
            if (valorPago > valorFinal) {
                double troco = valorPago - valorFinal;
                System.out.println("Troco: " + troco);
            } else if (valorPago == valorFinal) {
                System.out.println("Pagamento exato.");
            } else {
                System.out.println("Valor insuficiente para o pagamento.");
                return;
            }
        }

        p.setQuantidadeEstoque(p.getQuantidadeEstoque() - quantidadeVenda);
        System.out.println("Venda realizada com sucesso. Estoque atualizado: " + p.getQuantidadeEstoque());
    }
}
