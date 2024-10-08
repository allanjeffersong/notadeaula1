public class Aluno {

    private double nota1, nota2, nota3, media;
    private String nome;

    public void setNota1(double nota1) {
        this.nota1 = nota1;
    }

    public void setNota2(double nota2) {
        this.nota2 = nota2;
    }

    public void setNota3(double nota3) {
        this.nota3 = nota3;
    }

    public double getNota1() {
        return nota1;
    }

    public double getNota2() {
        return nota2;
    }

    public double getNota3() {
        return nota3;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void calcularmedia(){
        media = (nota1+nota2+nota3)/3;
    }
    public void mostrarmedia(){
        System.out.println("Sua media foi: " + media);
    }
     public void resultadoFinal(){
         if (media >=7){
             System.out.println("Você está aprovado");
         }
         else if (media< 7 & media>= 40){
             System.out.println("Você está na recuperação!");
         }
         else {
             System.out.println("voce esta reprovado...");
         }
     }


}
