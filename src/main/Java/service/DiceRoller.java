package main.Java.service;

import main.Java.model.Dice;
import java.util.ArrayList;
import java.util.List;

public class DiceRoller {

    public static final Dice D4 = new Dice(4);
    public static final Dice D6 = new Dice(6);
    public static final Dice D8 = new Dice(8);
    public static final Dice D10 = new Dice(10);
    public static final Dice D12 = new Dice(12);
    public static final Dice D20 = new Dice(20);
    public static final Dice D100 = new Dice(100);

    public static RollResult rollDice(Dice dice, int quantidade, int modificador, int dificuldade) {
        List<Integer> resultados = new ArrayList<>();
        int somaSemMod = 0;
        int sucesso = 0;

        for (int i = 0; i < quantidade; i++) {
            int resultado = dice.roll();
            resultados.add(resultado);
            somaSemMod += resultado;
            if (resultado >= dificuldade) {
                sucesso++;
            }
        }

        int somaModificadores = modificador * quantidade;
        int somaTotal = somaSemMod + somaModificadores;

        System.out.println("Dados rolados (" + dice + "): " + resultados);
        System.out.println("Soma sem modificadores: " + somaSemMod);
        System.out.println("Soma dos modificadores: " + somaModificadores);
        System.out.println("Resultado final: " + somaTotal);
        System.out.println("Número de dados >= dificuldade (" + dificuldade + "): " + sucesso);

        return new RollResult(dice, resultados, somaSemMod, somaModificadores,
                somaTotal, sucesso, dificuldade);
    }
}    