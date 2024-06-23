package br.com.desafio;

import br.com.desafio.model.Funcionario;
import br.com.desafio.service.FuncionarioService;
import br.com.desafio.utils.Datas;
import br.com.desafio.utils.Decimals;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        Locale.setDefault(new Locale("pt", "BR"));

        FuncionarioService funcionarioService = new FuncionarioService();
        Datas datas = new Datas();
        Decimals decimals = new Decimals();

        var listaFuncionarios = funcionarioService.getFuncionarios();
        listaFuncionarios.removeIf(funcionario -> "João".equals(funcionario.getNome()));

        System.out.println("\n==========Imprimir todos os funcionários com todas suas informações==========\n");
        listaFuncionarios.forEach(funcionario -> {
            var mensagem = String.format("Nome: %s, Data Nascimento: %s, Salário: R$ %s, Função: %s", funcionario.getNome(), datas.format(funcionario.getDataNascimento()), decimals.format(funcionario.getSalario()), funcionario.getFuncao());
            System.out.println(mensagem);
        });

        var listaFuncionarioSalarioAtualizado = funcionarioService.atualizarSalario(listaFuncionarios, 10L);

        Map<String, List<Funcionario>> funcionariosPorFuncao = listaFuncionarioSalarioAtualizado.stream()
                .collect(Collectors.groupingBy(Funcionario::getFuncao));

        System.out.println("\n==========Funcionários agrupados por função==========\n");
        funcionariosPorFuncao.forEach((funcao, lista) -> {
            System.out.println("Função: " + funcao);
            lista.forEach(funcionario -> {
                var mensagem = String.format("Nome: %s, Data Nascimento: %s, Salário: R$ %s, Função: %s", funcionario.getNome(), datas.format(funcionario.getDataNascimento()), decimals.format(funcionario.getSalario()), funcionario.getFuncao());
                System.out.println(mensagem);
            });
        });

        System.out.println("\n==========Funcionários aniversário no mês 10 e 12==========\n");
        listaFuncionarioSalarioAtualizado.stream()
                .filter(funcionario -> funcionario.getDataNascimento().getMonthValue() == 10 ||
                        funcionario.getDataNascimento().getMonthValue() == 12)
                .forEach(funcionario -> {
                    var mensagem = String.format("Nome: %s, Data Nascimento: %s, Salário: R$ %s, Função: %s", funcionario.getNome(), datas.format(funcionario.getDataNascimento()), decimals.format(funcionario.getSalario()), funcionario.getFuncao());
                    System.out.println(mensagem);
                });

        System.out.println("\n==========Funcionário com a maior idade==========\n");
        Funcionario funcionarioMaisVelho = Collections.max(listaFuncionarioSalarioAtualizado, Comparator.comparing(Funcionario::getIdade));
        System.out.println("Nome: " + funcionarioMaisVelho.getNome() + ", Idade: " + funcionarioMaisVelho.getIdade());

        System.out.println("\n==========Lista funcionários por ordem alfabética==========\n");
        listaFuncionarios.stream()
                .sorted(Comparator.comparing(Funcionario::getNome))
                .forEach(funcionario -> {
                    var mensagem = String.format("Nome: %s, Data Nascimento: %s, Salário: R$ %s, Função: %s",
                            funcionario.getNome(),
                            datas.format(funcionario.getDataNascimento()),
                            decimals.format(funcionario.getSalario()),
                            funcionario.getFuncao());
                    System.out.println(mensagem);
                });

        System.out.println("\n==========Total dos salários dos funcionários==========\n");
        BigDecimal totalSalarios = listaFuncionarioSalarioAtualizado.stream().map(Funcionario::getSalario)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
        System.out.println("\nTotal dos salários dos funcionários: " + String.format("%,.2f", totalSalarios));

        System.out.println("\n==========Quantos salários mínimos ganha cada funcionário==========\n");
        BigDecimal salarioMinimo = new BigDecimal("1212.00");
        listaFuncionarios.forEach(f -> {
            BigDecimal salariosMinimos = f.getSalario().divide(salarioMinimo, 2, BigDecimal.ROUND_HALF_UP);
            System.out.println(f.getNome() + " ganha " + salariosMinimos + " salários mínimos.");
        });

    }
}