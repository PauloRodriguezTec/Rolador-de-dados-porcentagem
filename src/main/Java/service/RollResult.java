package main.Java.service;

import main.Java.model.Dice;
import java.util.List;

public class RollResult {
    private Dice dice;
    private List<Integer> resultados;
    private int somaSemMod;
    private int somaModificadores;
    private int somaTotal;
    private int sucesso;
    private int dificuldade;

    public RollResult(Dice dice, List<Integer> resultados, int somaSemMod, int somaModificadores,
            int somaTotal, int sucesso, int dificuldade) {
        this.dice = dice;
        this.resultados = resultados;
        this.somaSemMod = somaSemMod;
        this.somaModificadores = somaModificadores;
        this.somaTotal = somaTotal;
        this.sucesso = sucesso;
        this.dificuldade = dificuldade;
    }

    public int getSomaTotal() {
        return somaTotal;
    }

    @Override
    public String toString() {
        return "Dados rolados (" + dice + "): " + resultados +
                "\nSoma sem modificadores: " + somaSemMod +
                "\nSoma dos modificadores: " + somaModificadores +
                "\nResultado final: " + somaTotal +
                "\nNúmero de dados >= dificuldade (" + dificuldade + "): " + sucesso;
    }
}