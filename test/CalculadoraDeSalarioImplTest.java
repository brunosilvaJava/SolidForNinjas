import chapter1.CalculadoraDeSalarioImpl;
import chapter1.Funcionario;
import org.junit.jupiter.api.Test;

public class CalculadoraDeSalarioImplTest {

    @Test
    void deve_calcular_salario_de_desenvolvedor_com_salario_menor_ou_igual_a_3000() {
        var calculadora = new CalculadoraDeSalarioImpl();
        var funcionario = new Funcionario("João", "DESENVOLVEDOR", 3000.0);
        var salario = calculadora.calcula(funcionario);
        assert salario == 2700.0;
    }

    @Test
    void deve_calcular_salario_de_desenvolvedor_com_salario_maior_que_3000() {
        var calculadora = new CalculadoraDeSalarioImpl();
        var funcionario = new Funcionario("Maria", "DESENVOLVEDOR", 4000.0);
        var salario = calculadora.calcula(funcionario);
        assert salario == 3200.0;
    }

    @Test
    void deve_calcular_salario_de_dba_com_salario_menor_ou_igual_a_2000() {
        var calculadora = new CalculadoraDeSalarioImpl();
        var funcionario = new Funcionario("Carlos", "DBA", 2000.0);
        var salario = calculadora.calcula(funcionario);
        assert salario == 1700.0;
    }

    @Test
    void deve_calcular_salario_de_dba_com_salario_maior_que_2000() {
        var calculadora = new CalculadoraDeSalarioImpl();
        var funcionario = new Funcionario("Ana", "DBA", 3000.0);
        var salario = calculadora.calcula(funcionario);
        assert salario == 2250.0;
    }

    @Test
    void deve_calcular_salario_de_tester_com_salario_menor_ou_igual_a_2000() {
        var calculadora = new CalculadoraDeSalarioImpl();
        var funcionario = new Funcionario("Pedro", "TESTER", 2000.0);
        var salario = calculadora.calcula(funcionario);
        assert salario == 1700.0;
    }

    @Test
    void deve_lancar_excecao_para_cargo_invalido() {
        var calculadora = new CalculadoraDeSalarioImpl();
        var funcionario = new Funcionario("Luiza", "GERENTE", 5000.0);
        try {
            calculadora.calcula(funcionario);
            assert false;
        } catch (RuntimeException e) {
            assert e.getMessage().equals("funcionario invalido");
        }
    }

}
