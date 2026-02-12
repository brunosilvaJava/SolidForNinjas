package chapter1;

import java.util.stream.Stream;

public class CalculadoraDeSalarioImpl implements CalculadoraDeSalario {

    private static final String DESENVOLVEDOR = "DESENVOLVEDOR";
    private static final String DBA = "DBA";
    private static final String TESTER = "TESTER";

    @Override
    public double executa(Funcionario funcionario) {

        if (isCargoInvalido(funcionario.cargo())) {
            throw new IllegalArgumentException("Cargo inválido");
        }

        RegraCalculoSalario calculoSalario = funcionario.cargo().calculoSalario();

        var salarioBase = funcionario.salarioBase();

        if (salarioBase > calculoSalario.valorBase()) {
            return salarioBase * calculoSalario.porcentMaior();
        }
        return salarioBase * calculoSalario.porcentMenor();
    }

    private boolean isCargoInvalido(Cargo cargo) {
        return Stream.of(DESENVOLVEDOR, DBA, TESTER)
                .noneMatch(cargo.descricao()::equalsIgnoreCase);
    }

}
