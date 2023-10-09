package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class LivroProxyTest {

    @BeforeEach
    void setUp() {
        BancoDeDados.addLivro(new Livro(1, "O Senhor dos Anéis", "J.R.R. Tolkien", 1200, "Uma jornada épica na Terra Média."));
        BancoDeDados.addLivro(new Livro(2, "O Vilarejo", "Raphael Montes", 124, "Contos de terror de um vilarejo isolado."));
    }

    @Test
    void deveRetornarDadosBasicosLivro() {
        LivroProxy livro = new LivroProxy(1);

        assertEquals(Arrays.asList("O Senhor dos Anéis", "J.R.R. Tolkien"), livro.obterDadosBasicos());
    }

    @Test
    void deveRetornarDetalhesLivro() {
        Bibliotecario bibliotecario = new Bibliotecario("Carlos", true);
        LivroProxy livro = new LivroProxy(2);

        assertEquals(Arrays.asList("O Vilarejo", "Raphael Montes", "124", "Contos de terror de um vilarejo isolado."), livro.obterDetalhes(bibliotecario));
    }

    @Test
    void deveRetornarExcecaoBibliotecarioNaoAutorizadoConsultarDetalhesLivro() {
        try {
            Bibliotecario bibliotecario = new Bibliotecario("João", false);
            LivroProxy livro = new LivroProxy(2);

            livro.obterDetalhes(bibliotecario);
            fail();
        }
        catch (IllegalArgumentException e) {
            assertEquals("Bibliotecário não autorizado", e.getMessage());
        }
    }
}