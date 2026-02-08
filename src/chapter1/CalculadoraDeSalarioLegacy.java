package chapter1;

public class CalculadoraDeSalarioLegacy {

    private static final String DESENVOLVEDOR = "DESENVOLVEDOR";
    private static final String DBA = "DBA";
    private static final String TESTER = "TESTER";

    public double calcula(Funcionario funcionario) {

        if (DESENVOLVEDOR.equals(funcionario.cargo())) {
            return dezOuVintePorcento(funcionario);
        }

        if (DBA.equals(funcionario.cargo()) || TESTER.equals(funcionario.cargo())) {
            return quinzeOuVinteCincoPorcento(funcionario);
        }
        throw new RuntimeException("funcionario invalido");
    }


    private double dezOuVintePorcento(Funcionario funcionario) {
        if (funcionario.salarioBase() > 3000.0) {
            return funcionario.salarioBase() * 0.8;
        } else {
            return funcionario.salarioBase() * 0.9;
        }
    }

    private double quinzeOuVinteCincoPorcento(Funcionario funcionario) {
        if (funcionario.salarioBase() > 2000.0) {
            return funcionario.salarioBase() * 0.75;
        } else {
            return funcionario.salarioBase() * 0.85;
        }
    }

    record Funcionario(String nome, String cargo, double salarioBase) {
    }

}
