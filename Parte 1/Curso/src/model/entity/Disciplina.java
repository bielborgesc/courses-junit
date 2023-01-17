package model.entity;

import java.sql.Time;
import java.time.LocalTime;
import java.util.Objects;

public class Disciplina {
    private String sigla;
    private String nome;
    private String ementa;
    private String livros_bibliografia;
    private Integer nCredito;
    private Double cargaHoraria;

    public Disciplina(String sigla, String nome, String ementa, String livros_bibliografia, Integer nCredito, Double cargaHoraria) {
        this.sigla = sigla;
        this.nome = nome;
        this.ementa = ementa;
        this.livros_bibliografia = livros_bibliografia;
        this.nCredito = nCredito;
        this.cargaHoraria = cargaHoraria;
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmenta() {
        return ementa;
    }

    public void setEmenta(String ementa) {
        this.ementa = ementa;
    }

    public String getLivros_bibliografia() {
        return livros_bibliografia;
    }

    public void setLivros_bibliografia(String livros_bibliografia) {
        this.livros_bibliografia = livros_bibliografia;
    }

    public Integer getnCredito() {
        return nCredito;
    }

    public void setnCredito(Integer nCredito) {
        this.nCredito = nCredito;
    }

    public Double getCargaHoraria() {
        return cargaHoraria;
    }

    public void setCargaHoraria(Double cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Disciplina that = (Disciplina) o;
        return Objects.equals(sigla, that.sigla) && Objects.equals(nome, that.nome) && Objects.equals(ementa, that.ementa) && Objects.equals(livros_bibliografia, that.livros_bibliografia) && Objects.equals(nCredito, that.nCredito) && Objects.equals(cargaHoraria, that.cargaHoraria);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sigla, nome, ementa, livros_bibliografia, nCredito, cargaHoraria);
    }

    @Override
    public String toString() {
        System.out.println("=================");
        System.out.println("Disciplina: " + "\n" +
                "Sigla: " + sigla + '\n' +
                "Nome: " + nome + '\n' +
                "Ementa: " + ementa + '\n' +
                "Livros Bibliograficos: " + livros_bibliografia + '\n' +
                "Número de Crédito: " + nCredito + "\n" +
                "Carga Horaria: " + cargaHoraria);
        System.out.println("=================");
        return null;
    }
}
