package model.entity;

import model.db.DataBase;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.text.SimpleDateFormat;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class ProfessorTest {
    private static final DataBase dataBase = new DataBase();

    @BeforeAll
    public static void inicializaObjeto() throws Exception {

        Disciplina disciplina1 = new Disciplina("MATS1", "Matemática 1", "Baseado na matemática", "Qualquer livro", 5, 5.0);
        Disciplina disciplinaTeste2 = new Disciplina("MACS2", "Matemática da computação", "Baseado na computação", "Qualquer jornal", 6, 20.5);

        dataBase.createDisciplina(disciplina1);
        dataBase.createDisciplina(disciplinaTeste2);

        Professor professor1 = new Professor("SC2455", "Everton", "20/07/2004", "M", "Informática", "UFBH");
        professor1.setDisciplina(dataBase.getDisciplina("MACS2"));
        professor1.setDisciplina(dataBase.getDisciplina("MATS1"));

        Professor professor2 = new Professor("SC2752", "Claudia", "02/04/2003", "F", "Redes", "UFMG");
        professor2.setDisciplina(dataBase.getDisciplina("MACS2"));

        dataBase.createProfessor(professor1);
        dataBase.createProfessor(professor2);
    }

    @Order(1)
    @Test
    @DisplayName("Teste de Get da Lista")
    public void testsGetESetsDaLista() throws Exception {
        System.out.println(dataBase.getProfessor("SC2455"));
        Professor professorTeste = dataBase.getProfessor("SC2455");
        assertEquals(dataBase.getProfessor("SC2455"), professorTeste);
    }

    @Order(2)
    @Test
    @DisplayName("Testar gets e sets da entidade ")
    public void testsGetESetsDaEntidade() throws Exception {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        Professor professor2 = dataBase.getProfessor("SC2455");
        professor2.setRegistroFuncional("SC5752");
        professor2.setNome("Sol");
        professor2.setDataNasc("20/04/2006");
        professor2.setSexo("F");
        professor2.setAreaPesq("IA");
        professor2.setUniversidadeForm("USP");
        assertAll(
                () -> assertEquals(professor2.getRegistroFuncional(), "SC5752"),
                () -> assertEquals(professor2.getNome(), "Sol"),
                () -> assertEquals(professor2.getDataNasc(), formatter.parse("20/04/2006")),
                () -> assertEquals(professor2.getSexo().toString(), "FEM"),
                () -> assertEquals(professor2.getAreaPesq(), "IA"),
                () -> assertEquals(professor2.getUniversidadeForm(), "USP")

        );
    }

    @Order(3)
    @Test
    @DisplayName("Adicionar professor existente")
//    Tem q dar erro
    public void adicionandoProfessorExistente() throws Exception {
        Professor professorTeste = new Professor("SC2455", "Maycon", "20/08/2005", "M", "Informática", "UFMG");
        dataBase.createProfessor(professorTeste);
    }

    @Order(4)
    @Test
    @DisplayName("Atualizar um professor existente")
    public void atualizarProfessorComIdExistente() throws Exception {
        Professor professorTeste = dataBase.getProfessor("SC2455");
        professorTeste.setNome("Maycon");
        dataBase.updateProfessor(professorTeste);
        assertEquals(dataBase.getProfessor("SC2455").getNome(), "Maycon");

    }

    @Order(5)
    @DisplayName("Testando telefone válido")
    @ParameterizedTest
    @ValueSource(strings = {"16997059417", "(18)9685-74210", "(16)99296-4877"})
    //    Tem q dar erro em 2 casos
    public void testeTelefone(String telefone) throws Exception {
        Professor professor2 = dataBase.getProfessor("SC2455");
        professor2.setTelefones(telefone);
    }

    @Order(6)
    @Test
    @DisplayName("Testando igualdade de arrays")
    public void testeIgualdadeArray() throws Exception {
        dataBase.getProfessor("SC2752").setDisciplina(dataBase.getDisciplina("MATS1"));
        assertArrayEquals(dataBase.getProfessor("SC2752").getDisciplinas().toArray(), dataBase.getProfessor("SC2455").getDisciplinas().toArray());
    }

    @Order(7)
    @Test
    @DisplayName("Removendo elemento")
    public void removendoProfessor() throws Exception {
        assertTrue(dataBase.deleteProfessor("SC2455"));
    }

}