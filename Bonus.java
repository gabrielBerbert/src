
import java.util.List;

public class Bonus {
    public static void aplicarBonus(List<Funcionario> funcionarios, List<Departamento> departamentos) 
        throws CodigoErro1Exception, CodigoErro2Exception {

        if (funcionarios.isEmpty() || departamentos.isEmpty()) {
            throw new CodigoErro1Exception("Erro: Tabelas de entrada estão vazias.");
        }

        // Identificar o maior valor de vendas
        double maiorVenda = departamentos.stream()
                .mapToDouble(Departamento::getValorVendas)
                .max()
                .orElseThrow(() -> new CodigoErro1Exception("Erro: Não foi possível calcular o maior valor de vendas."));

        // Filtrar os departamentos com o maior valor de vendas
        List<Integer> departamentosTop = departamentos.stream()
                .filter(d -> d.getValorVendas() == maiorVenda)
                .map(Departamento::getId)
                .toList();

        // Filtrar funcionários que pertencem aos departamentos com maior valor de vendas
        List<Funcionario> funcionariosElegiveis = funcionarios.stream()
                .filter(f -> departamentosTop.contains(f.getCodigoDepartamento()))
                .toList();

        if (funcionariosElegiveis.isEmpty()) {
            throw new CodigoErro2Exception("Erro: Não há funcionários elegíveis nos departamentos de maior venda.");
        }

        // Aplicar bônus
        for (Funcionario funcionario : funcionariosElegiveis) {
            if (funcionario.getSalario() >= 150000 || funcionario.getCargo().equalsIgnoreCase("gerente")) {
                funcionario.setSalario(funcionario.getSalario() + 1000);
            } else {
                funcionario.setSalario(funcionario.getSalario() + 2000);
            }
        }
    }
}
