package models;

import enums.StatusUsuario;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/*
 * ===================== CAMADA MODEL =====================
 *
 * O MODEL guarda os DADOS e as REGRAS do sistema.
 * Repare: esta classe NÃO sabe que existe uma tela.
 * Não tem nenhum import de Swing aqui dentro — e isso é de propósito!
 *
 * Se um dia a gente trocar a tela por um site, estas classes continuam iguais.
 *
 * É a mesma classe Usuario da Aula 6, com um construtor a mais.
 */
public class Usuario {

    // Atributos PRIVATE: ninguém mexe direto, só pelos getters e setters (encapsulamento).
    private Long id;
    private String nome, cpf, email, senha;
    private LocalDate dataNascimento;
    private StatusUsuario status;

    // Um usuário TEM VÁRIAS tarefas -> guardamos numa lista.
    private List<Tarefa> tarefas;

    /*
     * CONSTRUTOR COMPLETO: o mesmo da Aula 6, com todos os dados do usuário.
     */
    public Usuario(Long id, String nome, String cpf, String email, String senha,
            LocalDate dataNascimento, StatusUsuario status) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.senha = senha;
        this.dataNascimento = dataNascimento;
        this.status = status;

        // A lista começa VAZIA, mas já criada.
        // Se esquecermos esta linha, dá NullPointerException ao adicionar uma tarefa!
        this.tarefas = new ArrayList<>();
    }

    /*
     * SOBRECARGA DE CONSTRUTOR (dois construtores com o mesmo nome,
     * mas com parâmetros diferentes).
     *
     * Na nossa tela de cadastro só pedimos nome, e-mail e status.
     * Então criamos um construtor curto, e ele preenche o resto
     * (cpf, senha, data de nascimento) com valores vazios.
     *
     * O this(...) chama o construtor completo lá de cima — assim não repetimos código.
     */
    public Usuario(Long id, String nome, String email, StatusUsuario status) {
        this(id, nome, "", email, "", null, status);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public StatusUsuario getStatus() {
        return status;
    }

    public void setStatus(StatusUsuario status) {
        this.status = status;
    }

    public List<Tarefa> getTarefas() {
        return tarefas;
    }

    public void setTarefas(List<Tarefa> tarefas) {
        this.tarefas = tarefas;
    }

    /*
     * toString() define como o objeto vira TEXTO.
     *
     * Sem ele, imprimir um Usuario mostraria algo feio tipo "models.Usuario@1b6d3586".
     * Com ele, mostra o nome. Isso é útil quando o objeto aparece numa tabela ou combo.
     */
    @Override
    public String toString() {
        return nome;
    }
}
