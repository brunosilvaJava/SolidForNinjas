package chapter1;

public record CalculoSalario (String nome, Double valorBase, double porcentMenor, double porcentMaior) {

    public double calcula(Double salarioBase) {
        if (salarioBase > valorBase) {
            return salarioBase * porcentMaior;
        } else {
            return salarioBase * porcentMenor;
        }
    }
    
}
