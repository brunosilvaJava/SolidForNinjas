import chapter1.CalculadoraDeSalarioImpl;
import chapter1.CalculoSalario;
import chapter1.Cargo;
import chapter1.Funcionario;
import org.junit.jupiter.api.Test;

public class CalculadoraDeSalarioImplTest {

    @Test
    void deve_calcular_salario_de_desenvolvedor_com_salario_menor_ou_igual_a_3000() {
        var calculadora = new CalculadoraDeSalarioImpl();
        var funcionario = new Funcionario(
                "João",
                buildDesenvolvedor(),
                3000.0);
        var salario = calculadora.calcula(funcionario);
        assert salario == 2700.0;
    }

    @Test
    void deve_calcular_salario_de_desenvolvedor_com_salario_maior_que_3000() {
        var calculadora = new CalculadoraDeSalarioImpl();
        var funcionario = new Funcionario(
                "Maria",
                buildDesenvolvedor(),
                4000.0);
        var salario = calculadora.calcula(funcionario);
        assert salario == 3200.0;
    }

    @Test
    void deve_calcular_salario_de_dba_com_salario_menor_ou_igual_a_2000() {
        var calculadora = new CalculadoraDeSalarioImpl();
        var funcionario = new Funcionario("Carlos",
                buildDba(),
                2000.0);
        var salario = calculadora.calcula(funcionario);
        assert salario == 1700.0;
    }

    @Test
    void deve_calcular_salario_de_dba_com_salario_maior_que_2000() {
        var calculadora = new CalculadoraDeSalarioImpl();
        var funcionario = new Funcionario("Ana",
                buildDba(),
                3000.0);
        var salario = calculadora.calcula(funcionario);
        assert salario == 2250.0;
    }

    @Test
    void deve_calcular_salario_de_tester_com_salario_menor_ou_igual_a_2000() {
        var calculadora = new CalculadoraDeSalarioImpl();
        var funcionario = new Funcionario("Pedro",
                buildTester(),
                2000.0);
        var salario = calculadora.calcula(funcionario);
        assert salario == 1700.0;
    }

    @Test
    void deve_lancar_excecao_para_cargo_invalido() {
        var calculadora = new CalculadoraDeSalarioImpl();
        var funcionario = new Funcionario("Lucas",
                buildGerente(),
                5000.0);
        try {
            calculadora.calcula(funcionario);
            assert false;
        } catch (IllegalArgumentException e) {
            assert e.getMessage().equals("Cargo inválido");
        }
    }

    private static Cargo buildDesenvolvedor() {
        return new Cargo("DESENVOLVEDOR",
                buildDezOuVintePorcento());
    }

    private static Cargo buildDba() {
        return new Cargo("DBA",
                buildQuinzeOuVinteCincoPorcento());
    }

    private static Cargo buildTester() {
        return new Cargo("TESTER",
                buildQuinzeOuVinteCincoPorcento());
    }

    private static Cargo buildGerente() {
        return new Cargo("GERENTE", null);
    }

    private static CalculoSalario buildDezOuVintePorcento() {
        return new CalculoSalario("dezOuVintePorcento", 3000.0, 0.9, 0.8);
    }

    private static CalculoSalario buildQuinzeOuVinteCincoPorcento() {
        return new CalculoSalario("quinzeOuVinteCincoPorcento", 2000.0, 0.85, 0.75);
    }

}
