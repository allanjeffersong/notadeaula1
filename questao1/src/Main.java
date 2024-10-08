import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Aluno a = new Aluno();

        System.out.println("Olá, digite seu nome: ");
        a.setNome(sc.next());

        System.out.println("olá "+ a.getNome());

        System.out.println("digite sua primeira nota: ");
        a.setNota1(sc.nextDouble());

        System.out.println("digite sua segunda nota: ");
        a.setNota2(sc.nextDouble());

        System.out.println("digite sua terceira nota: ");
        a.setNota3(sc.nextDouble());

        System.out.println("Agora vamos calcular sua media e saber se voce foi aprovado, reprovado, ou esta na final!");

        a.calcularmedia();
        a.mostrarmedia();
        a.resultadoFinal();
    }

}