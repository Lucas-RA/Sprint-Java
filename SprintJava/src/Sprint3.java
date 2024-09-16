import java.util.Scanner;

public class Sprint3 {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        int qtdEquipes, combates;
        boolean repete;

        System.out.println("Insira a quantidade de Equipes participantes da competição: ");
        qtdEquipes = teclado.nextInt();

        int[] nmrEquipes = new int[qtdEquipes];
        int[] notaDesign = new int[qtdEquipes];
        int[] pontos = new int[qtdEquipes];

        String resposta = new String();

        System.out.println("Digite o número de cada equipe na ordem:");
        for (int i = 0; i < qtdEquipes; i++) {
            nmrEquipes[i] = teclado.nextInt();
            repete = true;
            if (nmrEquipes[i] < 11 || nmrEquipes[i] > 99) {
                System.out.println("Número de equipe inválido! Insira um número válido: ");
                i = i - 1;
                repete = false;
            }

            for (int j = 0; j < i; j++) {
                if (nmrEquipes[i] == nmrEquipes[j]) {
                    repete = false;
                    System.out.println("Número repetido, insira novamente");
                    i = i - 1;
                    break;
                }
            }
        }

        System.out.println("Quantos combates foram realizados?");
        combates = teclado.nextInt();

        for (int j = 1; j <= combates; j++) {
            System.out.println("Insira os resultados dos " + j + "º combate das equipes:");
            for (int i = 0; i < qtdEquipes; i++) {
                System.out
                        .println("Equipe número: " + nmrEquipes[i] + ": V para vitória; E para empate; D para Derrota");
                resposta = teclado.next();

                if (resposta.equalsIgnoreCase("V")) {
                    pontos[i] = pontos[i] + 5;
                } else if (resposta.equalsIgnoreCase("E")) {
                    pontos[i] = pontos[i] + 3;
                } else {
                    pontos[i] = pontos[i] + 0;
                }
            }
        }

        for (int i = 0; i < qtdEquipes; i++) {
            System.out.println("Nota de Design robô da Equipe " + nmrEquipes[i]);
            notaDesign[i] = teclado.nextInt();
        }

        int tempPontos, tempNota, tempEquipe;

        for (int i = 0; i < pontos.length; i++) {
            for (int j = i + 1; j < pontos.length; j++) {
                if (pontos[i] < pontos[j] || (pontos[i] == pontos[j] && notaDesign[i] < notaDesign[j])) {
                    tempPontos = pontos[i];
                    pontos[i] = pontos[j];
                    pontos[j] = tempPontos;

                    tempNota = notaDesign[i];
                    notaDesign[i] = notaDesign[j];
                    notaDesign[j] = tempNota;

                    tempEquipe = nmrEquipes[i];
                    nmrEquipes[i] = nmrEquipes[j];
                    nmrEquipes[j] = tempEquipe;
                }
            }
        }

        System.out.println("Após a contagem dos pontos, a classificação geral das equipes ficou: ");
        for (int i : nmrEquipes) {
            System.out.println(i + " ");
        }
        teclado.close();
    }
}