package model.entity;

import model.enums.Sexo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.Objects;

public class Professor {
    private String registroFuncional;
    private String nome;
    private Date dataNasc;
    private Sexo sexo;
    private String areaPesq;
    private String universidadeForm;
    private LinkedList<String> emails = new LinkedList<>();
    private LinkedList<String> telefones = new LinkedList<>();
    private LinkedList<Disciplina> ministrando = new LinkedList<>();

    public Professor(String registroFuncional, String nome, String dataNasc, String sexo, String areaPesq, String universidadeForm) throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        this.registroFuncional = registroFuncional;
        this.nome = nome;
        this.dataNasc = formatter.parse(dataNasc);
        this.sexo = Objects.equals(sexo, "F") ? Sexo.FEM : Sexo.MAS;
        this.areaPesq = areaPesq;
        this.universidadeForm = universidadeForm;
    }

    public String getRegistroFuncional() {
        return registroFuncional;
    }

    public void setRegistroFuncional(String registroFuncional) {
        this.registroFuncional = registroFuncional;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getDataNasc() {
        return dataNasc;
    }

    public void setDataNasc(String dataNasc) throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        this.dataNasc = formatter.parse(dataNasc);
    }

    public Sexo getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = Objects.equals(sexo, "F") ? Sexo.FEM : Sexo.MAS;
    }

    public String getAreaPesq() {
        return areaPesq;
    }

    public void setAreaPesq(String areaPesq) {
        this.areaPesq = areaPesq;
    }

    public String getUniversidadeForm() {
        return universidadeForm;
    }

    public void setUniversidadeForm(String universidadeForm) {
        this.universidadeForm = universidadeForm;
    }

    public LinkedList<String> getEmails() {
        return emails;
    }

    public void setEmails(String email) {
        this.emails.add(email);
    }

    public LinkedList<String> getTelefones() {
        return telefones;
    }

    public void setTelefones(String telefone) throws Exception {
        if (!(telefone.length() <= 14 && telefone.length() >= 13)) throw new Exception();
        if(telefone.charAt(0) != '('  || telefone.charAt(3) != ')' || telefone.charAt(9) != '-' ) throw new Exception();
        this.telefones.add(telefone);
    }

    public LinkedList<Disciplina> getDisciplinas() {
        return ministrando;
    }

    public void setDisciplina(Disciplina disciplina) {
        this.ministrando.add(disciplina);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Professor professor = (Professor) o;
        return Objects.equals(registroFuncional, professor.registroFuncional) && Objects.equals(nome, professor.nome) && Objects.equals(dataNasc, professor.dataNasc) && sexo == professor.sexo && Objects.equals(areaPesq, professor.areaPesq) && Objects.equals(universidadeForm, professor.universidadeForm) && Objects.equals(emails, professor.emails) && Objects.equals(telefones, professor.telefones);
    }

    @Override
    public int hashCode() {
        return Objects.hash(registroFuncional, nome, dataNasc, sexo, areaPesq, universidadeForm, emails, telefones);
    }

    @Override
    public String toString() {
        System.out.println("=================" + "\n" +
                "models.Professor: " + "\n" +
                "Registro Funcional: ' " + registroFuncional + '\n' +
                "Nome: '" + nome + '\n' +
                "Data de Nascimento: " + dataNasc + "\n" +
                "models.enums.Sexo: " + sexo + "\n" +
                "Área de Pesquisa: '" + areaPesq + '\n' +
                "Universidade Formação: '" + universidadeForm + '\n');
        System.out.print("Emails: ");
        emails.forEach(email -> System.out.print(email + ", \n"));
        telefones.forEach(telefone -> System.out.print(telefone + ", \n"));
        System.out.println("=================");
        return null;
    }
}
