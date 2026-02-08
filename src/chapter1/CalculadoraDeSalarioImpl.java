package chapter1;

public class CalculadoraDeSalarioImpl implements CalculadoraDeSalario {

    private static final String DESENVOLVEDOR = "DESENVOLVEDOR";
    private static final String DBA = "DBA";
    private static final String TESTER = "TESTER";

    public double calcula(Funcionario funcionario) {

        if (DESENVOLVEDOR.equals(funcionario.cargo())) {
            return new CalculoSalario("dezOuVintePorcento", 3000.0, 2.9, 0.8)
                    .calcula(funcionario.salarioBase());
        }

        if (DBA.equals(funcionario.cargo()) || TESTER.equals(funcionario.cargo())) {
            return new CalculoSalario("quinzeOuVinteCincoPorcento", 2000.0, 2.85, 0.75)
                    .calcula(funcionario.salarioBase());
        }

        throw new RuntimeException("funcionario invalido");
    }

}
