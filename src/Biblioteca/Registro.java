package Biblioteca;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import Biblioteca.Livro.Livro;

public class Registro {
    
    private ArrayList<Livro> listaDeLivros = new ArrayList<>();
    private HashMap<String, ArrayList<Livro>> livrosPorAutor = new HashMap<>();
    private HashMap<String, ArrayList<Livro>> livrosPorTitulo = new HashMap<>();
    private Map<Integer, Livro> livrosPorCodigo = new HashMap<>();
    
    public void adicionarLivro(Livro livro) {
        listaDeLivros.add(livro);

        // Adicionar ao índice por autor
        String autor = livro.getAutor();
        livrosPorAutor.computeIfAbsent(autor, k -> new ArrayList<>()).add(livro);

        // Adicionar ao índice por título
        String titulo = livro.getTitulo();
        livrosPorTitulo.computeIfAbsent(titulo, k -> new ArrayList<>()).add(livro);

        // Adicionar ao índice por código
        livrosPorCodigo.put(livro.getCodigo(), livro);
    }

    public void removerLivro(int codigo) {
        Livro livroRemovido = livrosPorCodigo.remove(codigo);

        if (livroRemovido != null) {
            listaDeLivros.remove(livroRemovido);
            String autor = livroRemovido.getAutor();
            livrosPorAutor.get(autor).remove(livroRemovido);
            String titulo = livroRemovido.getTitulo();
            livrosPorTitulo.get(titulo).remove(livroRemovido);
            System.out.println("Livro removido com sucesso: " + livroRemovido);
        } else {
            System.out.println("Livro não encontrado com código: " + codigo);
        }
    }

    public void alterarDadosDoLivro(int codigo, String novoAutor, String novoTitulo) {
        Livro livro = livrosPorCodigo.get(codigo);

        if (livro != null) {
            livro.setAutor(novoAutor);
            livro.setTitulo(novoTitulo);
            System.out.println("Dados do livro atualizados com sucesso: " + livro);
        } else {
            System.out.println("Livro não encontrado com código: " + codigo);
        }
    }

    public ArrayList<Livro> buscarPorAutor(String autor) {
        return livrosPorAutor.getOrDefault(autor, new ArrayList<>());
    }

    public ArrayList<Livro> buscarPorTitulo(String titulo) {
        return livrosPorTitulo.getOrDefault(titulo, new ArrayList<>());
    }

    public Livro buscarPorCodigo(int codigo) {
        return livrosPorCodigo.get(codigo);
    }

    public void listarLivros() {
        System.out.println("Lista de Livros:");
        for (Livro livro : listaDeLivros) {
            System.out.println(livro);
        }
    }

}
