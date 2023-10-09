package org.example;

import java.util.List;

public class LivroProxy implements ILivro {

    private Livro livro;
    private Integer id;

    public LivroProxy(Integer id) {
        this.id = id;
    }

    @Override
    public List<String> obterDadosBasicos() {
        if (this.livro == null) {
            this.livro = new Livro(this.id);
        }
        return this.livro.obterDadosBasicos();
    }

    @Override
    public List<String> obterDetalhes(Bibliotecario bibliotecario) {
        if (!bibliotecario.isAutorizado()) {
            throw new IllegalArgumentException("Bibliotecário não autorizado");
        }
        if (this.livro == null) {
            this.livro = new Livro(this.id);
        }
        return this.livro.obterDetalhes(bibliotecario);
    }
}
