package Biblioteca.Livro;

import java.io.Serializable;

public class Livro implements Serializable {

    String titulo;
    String autor;
    int codigo;
    int quantidade;
    int anoPublicacao;

    public Livro(String titulo, int codigo, String autor, int quantidade, int anoPublicacao) {
        this.titulo = titulo;
        this.codigo = codigo;
        this.autor = autor;
        this.quantidade = quantidade;
        this.anoPublicacao = anoPublicacao;
    }

    public Livro(int codigo){
        this.codigo = codigo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public int getAnoPublicacao() {
        return anoPublicacao;
    }

    public void setAnoPublicacao(int anoPublicacao) {
        this.anoPublicacao = anoPublicacao;
    }

    @Override
    public String toString() {
        return "Livro [livro=" + titulo + ", codigo=" + codigo + ", autor=" + autor + ", quantidade=" + quantidade
                + ", anoPublicacao=" + anoPublicacao + "]";
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Livro) {
            Livro l = (Livro) obj;
            return this.codigo == l.codigo ? true : false;
        }
        return false;
    }

}
