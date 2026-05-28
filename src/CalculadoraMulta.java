import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class CalculadoraMulta {

    private static final double VALOR_MULTA_DIA = 2.50;

    public static int calcularDiasAtraso(LocalDate dataDevolucao, LocalDate dataAtual) {
        long dias = ChronoUnit.DAYS.between(dataDevolucao, dataAtual);
        return dias > 0 ? (int) dias : 0;
    }

    public static double calcularValorMulta(int diasAtraso) {
        return diasAtraso * VALOR_MULTA_DIA;
    }
}