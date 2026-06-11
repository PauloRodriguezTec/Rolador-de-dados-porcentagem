package main;

import main.Java.model.Dice;
import main.Java.service.DiceRoller;
import main.Java.service.RollResult;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<RollResult> todasRolagens = new ArrayList<>();

        System.out.println("=== Rolador de Dados ===");

        boolean continuar = true;
        while (continuar) {
            System.out.println("\nEscolha o dado:");
            System.out.println("1 - D4 | 2 - D6 | 3 - D8 | 4 - D10 | 5 - D12 | 6 - D20 | 7 - D100 | 8 - Customizado");
            int escolha = scanner.nextInt();

            Dice dado;
            switch (escolha) {
                case 1:
                    dado = DiceRoller.D4;
                    break;
                case 2:
                    dado = DiceRoller.D6;
                    break;
                case 3:
                    dado = DiceRoller.D8;
                    break;
                case 4:
                    dado = DiceRoller.D10;
                    break;
                case 5:
                    dado = DiceRoller.D12;
                    break;
                case 6:
                    dado = DiceRoller.D20;
                    break;
                case 7:
                    dado = DiceRoller.D100;
                    break;
                case 8: {
                    System.out.print("Digite o número de lados do dado: ");
                    int lados = scanner.nextInt();
                    dado = new Dice(lados);
                    break;
                }
                default: {
                    System.out.println("Opção inválida, usando D6.");
                    dado = DiceRoller.D6;
                    break;
                }
            }

            System.out.print("Digite a quantidade de dados: ");
            int quantidade = scanner.nextInt();

            System.out.print("Digite o modificador (pode ser negativo): ");
            int modificador = scanner.nextInt();

            System.out.print("Digite a dificuldade (mínimo para sucesso): ");
            int dificuldade = scanner.nextInt();

            // Faz a rolagem e guarda o resultado
            RollResult resultado = DiceRoller.rollDice(dado, quantidade, modificador, dificuldade);
            todasRolagens.add(resultado);

            // Pergunta se quer continuar
            System.out.print("\nDeseja fazer outra rolagem? (s/n): ");
            String resposta = scanner.next();
            if (!resposta.equalsIgnoreCase("s")) {
                continuar = false;
            }
        }

        System.out.println("\n=== Resumo Final ===");
        int somaTotalAcumulada = 0;
        for (RollResult r : todasRolagens) {
            System.out.println(r);
            somaTotalAcumulada += r.getSomaTotal();
            System.out.println("--------------------");
        }

        System.out.println("Soma total de todas as rolagens: " + somaTotalAcumulada);

        scanner.close();
    }
}