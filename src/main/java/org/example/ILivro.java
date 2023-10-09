package org.example;

import java.util.List;

public interface ILivro {
    List<String> obterDadosBasicos();
    List<String> obterDetalhes(Bibliotecario bibliotecario);
}