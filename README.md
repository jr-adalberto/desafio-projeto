# Realização do TESTE PRÁTICO PROGRAMAÇÃO

Este projeto consiste na implementação de um sistema Java para gerenciar informações de funcionários de uma indústria, conforme especificado abaixo.

## Funcionalidades Implementadas

1. **Classe Pessoa**
   - Atributos: 
     - nome (String)
     - data de nascimento (LocalDate)

2. **Classe Funcionário**
   - Herda de Pessoa
   - Atributos:
     - salário (BigDecimal)
     - função (String)

3. **Classe Principal**
   - Responsável por executar as seguintes ações:

   3.1. Inserir todos os funcionários, na mesma ordem e informações da tabela abaixo.
   
   3.2. Remover o funcionário “João” da lista.
   
   3.3. Imprimir todos os funcionários com suas informações:
       - Data de nascimento no formato dd/mm/aaaa
       - Salário formatado com separador de milhar (ponto) e decimal (vírgula)
   
   3.4. Aplicar aumento de 10% no salário de todos os funcionários e atualizar a lista.
   
   3.5. Agrupar os funcionários por função em um MAP, utilizando a função como chave e uma lista de funcionários como valor.
   
   3.6. Imprimir os funcionários agrupados por função.
   
   3.7. Imprimir os funcionários que fazem aniversário nos meses 10 e 12.
   
   3.8. Imprimir o funcionário mais velho, exibindo nome e idade.
   
   3.9. Imprimir a lista de funcionários em ordem alfabética.
   
   3.10. Imprimir o total dos salários dos funcionários.
   
   3.11. Imprimir quantos salários mínimos cada funcionário ganha, considerando o salário mínimo de R$1212.00.

