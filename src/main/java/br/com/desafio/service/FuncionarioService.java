package br.com.desafio.service;

import br.com.desafio.model.Funcionario;
import br.com.desafio.utils.Datas;
import br.com.desafio.utils.Decimals;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class FuncionarioService {

    public List<Funcionario> getFuncionarios() {
        List<Funcionario> listaFuncionario = new ArrayList<>();
        listaFuncionario.add(new Funcionario("Maria", LocalDate.of(2000, 10, 18), new BigDecimal("2009.44"), "Operador"));
        listaFuncionario.add(new Funcionario("João", LocalDate.of(1990, 5, 12), new BigDecimal("2284.38"), "Operador"));
        listaFuncionario.add(new Funcionario("Caio", LocalDate.of(1961, 5, 2), new BigDecimal("9836.14"), "Coordenador"));
        listaFuncionario.add(new Funcionario("Miguel", LocalDate.of(1988, 10, 14), new BigDecimal("19119.88"), "Diretor"));
        listaFuncionario.add(new Funcionario("Alice", LocalDate.of(1995, 1, 5), new BigDecimal("2234.68"), "Recepcionista"));
        listaFuncionario.add(new Funcionario("Heitor", LocalDate.of(1999, 11, 19), new BigDecimal("1582.72"), "Operador"));
        listaFuncionario.add(new Funcionario("Arthur", LocalDate.of(1993, 3, 31), new BigDecimal("4071.84"), "Contador"));
        listaFuncionario.add(new Funcionario("Laura", LocalDate.of(1994, 7, 8), new BigDecimal("3017.45"), "Gerente"));
        listaFuncionario.add(new Funcionario("Heloísa", LocalDate.of(2003, 5, 24), new BigDecimal("1606.85"), "Eletricista"));
        listaFuncionario.add(new Funcionario("Helena", LocalDate.of(1996, 9, 2), new BigDecimal("2799.93"), "Gerente"));
        return listaFuncionario;
    }

    public List<Funcionario> atualizarSalario(List<Funcionario> funcionarios, Long percentual) {
        BigDecimal fatorAumento = BigDecimal.valueOf(1 + percentual / 100.0);
        return funcionarios.stream()
                .map(funcionario -> {
                    if (funcionario.getSalario().compareTo(BigDecimal.ZERO) <= 0)
                        return funcionario;

                    BigDecimal salarioAtual = funcionario.getSalario();
                    BigDecimal novoSalario = salarioAtual.multiply(fatorAumento).setScale(2, RoundingMode.HALF_UP);

                    funcionario.setSalario(novoSalario);
                    return funcionario;
                })
                .collect(Collectors.toList());
    }




}
