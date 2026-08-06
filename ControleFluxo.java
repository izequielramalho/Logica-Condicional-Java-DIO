package estudos.Izequiel.LogicaCondicional;

/**
 * Classe de exemplo para o exercício da Aula 3 de Operadores lógicos e relacionais,
 * Controle de fluxo e Blocos.
 */

public class ControleFluxo {

    public static void main(String[] args) {

        ifFlecha();       // ❌ EVITAR - efeito flecha (if aninhado)
        ifSemflecha();    // ✅ RECOMENDADO - else if deixa o código mais legível
        ifFerias();       // ❌ EVITAR - muitas comparações com || (prefira switch ou coleção)
        ifmenor();        // ✅ RECOMENDADO - variáveis boolean tornam a condição mais legível
        ifswitchSemana(); // ✅ RECOMENDADO - switch para valores exatos
        ifswitchNumero(); // ✅ RECOMENDADO - múltiplos cases evitam repetição
        ifswitchFerias(); // ✅ RECOMENDADO - switch agrupa casos iguais
    }

    // ❌ NÃO USAR - efeito flecha: if dentro de if dificulta leitura
    private static void ifFlecha() {
        int mes = 9;
        if (mes == 1) {
            System.out.println("Janeiro");
        } else {
            if (mes == 2) {
                System.out.println("Fevereiro");
            } else {
                // continua aninhando...
            }
        }
    }

    // ✅ USAR - else if encadeado é mais limpo e legível
    private static void ifSemflecha() {
        int mes = 9;
        if (mes == 1) {
            System.out.println("Janeiro");
        } else if (mes == 2) {
            System.out.println("Fevereiro");
        } else if (mes == 9) {
            System.out.println("Setembro");
        } else {
            System.out.println("Mês indefinido");
        }
    }

    // ✅ USAR - || agrupa condições na mesma linha
    private static void ifFerias() {
        String mes = "julho";
        if (mes == "julho" || mes == "dezembro" || mes == "janeiro") {
            System.out.println("Férias");
        }
    }

    // ✅ USAR - variáveis booleanas tornam o if mais legível
    private static void ifmenor() {
        double salarioMensal = 11893.58d;
        double mediaSalario = 10500d;
        int quantidadeDependentes = 4;
        int mediaDependentes = 2;

        // ❌ evitar → condição longa direto no if dificulta leitura
        if ((salarioMensal < mediaSalario) && (quantidadeDependentes >= mediaDependentes)) {
            System.out.println("Funcionário deve receber auxílio.");
        }

        // ✅ usar → variáveis booleanas deixam o if mais claro
        boolean salarioBaixo = salarioMensal < mediaSalario;
        boolean muitosDependentes = quantidadeDependentes >= mediaDependentes;
        boolean recebeAuxilio = salarioBaixo && muitosDependentes;

        if (recebeAuxilio) {
            System.out.println("Funcionário deve receber auxílio");
        } else {
            System.out.println("Funcionário não deve receber auxílio");
        }
    }

    // ✅ USAR - switch para valores exatos é mais organizado que if
    private static void ifswitchSemana() {
        String dia = "Terça";
        switch (dia) {
            case "Segunda": System.out.println(2); break;
            case "Terça":   System.out.println(3); break;
            case "Quarta":  System.out.println(3); break;
            case "Quinta":  System.out.println(4); break;
            case "Sexta":   System.out.println(5); break;
            case "Sábado":  System.out.println(6); break;
            case "Domingo": System.out.println(1); break;
            default: System.out.println("Dia inválido"); break;
        }
    }

    // ✅ USAR - múltiplos cases sem break compartilham o mesmo resultado
    private static void ifswitchNumero() {
        int numero = 4;
        switch (numero) {
            case 1:
            case 2:
            case 3: System.out.println("Certo");  break;
            case 4: System.out.println("Errado"); break;
            case 5: System.out.println("Talvez"); break;
            default: System.out.println("Valor Indefinido"); break;
        }
    }

    // ✅ USAR - switch agrupa cases com mesmo resultado sem repetir código
    private static void ifswitchFerias() {
        String mes = "dezembro";
        switch (mes) {
            case "dezembro":
            case "julho":
            case "janeiro":
                System.out.println("Férias");
                break;
            default:
                System.out.println("Mês Indefinido");
                break;
        }
    }
}