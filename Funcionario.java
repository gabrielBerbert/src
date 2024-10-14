
public class Funcionario {
    private int id;
    private double salario;
    private String cargo;
    private int codigoDepartamento;

    public Funcionario(int id, double salario, String cargo, int codigoDepartamento) {
        this.id = id;
        this.salario = salario;
        this.cargo = cargo;
        this.codigoDepartamento = codigoDepartamento;
    }

    public int getId() {
        return id;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public String getCargo() {
        return cargo;
    }

    public int getCodigoDepartamento() {
        return codigoDepartamento;
    }
}
