import java.text.NumberFormat;
import java.util.Locale;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
    
        NumberFormat currencyFormat = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));
        
        List<Funcionario> funcionarios = Arrays.asList(
            new Funcionario(1, 140000, "analista", 1),
            new Funcionario(2, 160000, "gerente", 1),
            new Funcionario(3, 120000, "analista", 2),
            new Funcionario(4, 180000, "analista", 3)
        );

        List<Departamento> departamentos = Arrays.asList(
            new Departamento(1, 500000),
            new Departamento(2, 300000),
            new Departamento(3, 800000)
        );

        try {
            Bonus.aplicarBonus(funcionarios, departamentos);
            System.out.println("Bônus aplicado com sucesso!");
            
            
            for (Funcionario f : funcionarios) {
                System.out.println("Funcionário: " + string.getCargo() + f.getId() + ", Novo Salário: " + currencyFormat.format(f.getSalario()));
            }

            
            for (Departamento departamento : departamentos) {
                System.out.println("Departamento: " + departamento.getId() + ", Total de Vendas: " + currencyFormat.format(departamento.getValorVendas()));
            }

        } catch (CodigoErro1Exception e) {
            System.out.println(e.getMessage());
        } catch (CodigoErro2Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
