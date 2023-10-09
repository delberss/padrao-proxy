package org.example;

import java.util.Arrays;
import java.util.List;

public class Livro implements ILivro {

    private Integer id;
    private String titulo;
    private String autor;
    private Integer paginas;
    private String resumo;

    public Livro(int id) {
        this.id = id;
        Livro objeto = BancoDeDados.getLivro(id);
        this.titulo = objeto.titulo;
        this.autor = objeto.autor;
        this.paginas = objeto.paginas;
        this.resumo = objeto.resumo;
    }

    public Livro(Integer id, String titulo, String autor, Integer paginas, String resumo) {
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
        this.paginas = paginas;
        this.resumo = resumo;
    }

    public Integer getId() {
        return id;
    }

    @Override
    public List<String> obterDadosBasicos() {
        return Arrays.asList(this.titulo, this.autor);
    }

    @Override
    public List<String> obterDetalhes(Bibliotecario bibliotecario) {
        return Arrays.asList(this.titulo, this.autor, String.valueOf(this.paginas), this.resumo);
    }
}