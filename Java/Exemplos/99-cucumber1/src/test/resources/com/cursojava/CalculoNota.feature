Feature: Media Aritmetica
  Teste cenarios de media aritmetica

  Scenario: Media Simples
    Given Informo os valores <v1> e <v2>
    When Calculo a Media Aritmetica
    Then A media aritmetica deve ser <resposta>

  Examples:
    |v1|v2|resposta|
    |2|4|3|
    |1|3|2|


