package chapter1;

import java.util.stream.Stream;

public class CalculadoraDeSalarioImpl implements CalculadoraDeSalario {

    private static final String DESENVOLVEDOR = "DESENVOLVEDOR";
    private static final String DBA = "DBA";
    private static final String TESTER = "TESTER";

    @Override
    public double calcula(Funcionario funcionario) {

        if (isCargoInvalido(funcionario.cargo())) {
            throw new IllegalArgumentException("Cargo inválido");
        }

        CalculoSalario calculoSalario = funcionario.cargo().calculoSalario();

        return calculoSalario.calcula(funcionario.salarioBase());
    }

    private boolean isCargoInvalido(Cargo cargo) {
        return Stream.of(DESENVOLVEDOR, DBA, TESTER)
                .noneMatch(cargo.descricao()::equalsIgnoreCase);
    }

}
