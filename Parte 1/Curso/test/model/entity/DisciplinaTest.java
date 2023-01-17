package model.entity;

import model.db.DataBase;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class DisciplinaTest {
    private static DataBase dataBase = new DataBase();

    @BeforeAll
    public static void inicializaObjeto() throws Exception {
        Disciplina disciplina1 = new Disciplina("MATS1", "Matemática 1", "Baseado na matemática", "Qualquer livro", 5, 5.0);
        Disciplina disciplinaTeste2 = new Disciplina("MACS2", "Matemática da computação", "Baseado na computação", "Qualquer jornal", 6, 20.5);
        dataBase.createDisciplina(disciplinaTeste2);
        dataBase.createDisciplina(disciplina1);
    }

    @Order(1)
    @Test
    @DisplayName("Teste de Get da Lista")
    public void testsGetESetsDaLista() throws Exception {
        Disciplina disciplinaTeste = dataBase.getDisciplina("MATS1");
        assertEquals(dataBase.getDisciplina("MATS1"), disciplinaTeste);
    }

    @Order(2)
    @Test
    @DisplayName("Testar gets e sets da entidade ")
    public void testsGetESetsDaEntidade() throws Exception {
        Disciplina disciplinaTeste = dataBase.getDisciplina("MATS1");
        disciplinaTeste.setSigla("MACS2");
        disciplinaTeste.setNome("Matemática para computação 2");
        disciplinaTeste.setCargaHoraria(20.0);
        disciplinaTeste.setEmenta("Computação");
        disciplinaTeste.setLivros_bibliografia("Nenhum");
        disciplinaTeste.setnCredito(5);
        assertAll(
                () -> assertEquals(disciplinaTeste.getSigla(), "MACS2"),
                () -> assertEquals(disciplinaTeste.getNome(), "Matemática para computação 2"),
                () -> assertEquals(disciplinaTeste.getCargaHoraria(), 20.0),
                () -> assertEquals(disciplinaTeste.getEmenta(), "Computação"),
                () -> assertEquals(disciplinaTeste.getLivros_bibliografia(), "Nenhum"),
                () -> assertEquals(disciplinaTeste.getnCredito(), 5)
        );
    }

    @Order(3)
    @Test
    @DisplayName("Adicionar disciplina existente")
//    Tem q dar erro
    public void adicionandoDisciplinaExistente() throws Exception {
        Disciplina disciplinaTeste = new Disciplina("MATS1", "Matemática 1", "Baseado na matemática", "Qualquer livro", 5, 5.0);
        dataBase.createDisciplina(disciplinaTeste);
    }

    @Order(4)
    @Test
    @DisplayName("Atualizar uma disciplina existente")
    public void atualizarDisciplinaComIdExistente() throws Exception {
        Disciplina disciplinaTeste = dataBase.getDisciplina("MATS1");
        disciplinaTeste.setNome("Matematica nova");
        dataBase.updateDisciplina(disciplinaTeste);
        assertEquals(dataBase.getDisciplina("MATS1").getNome(), "Matematica nova");

    }



    @Order(5)
    @DisplayName("Testando chave primárias")
    @ParameterizedTest
    @ValueSource(strings = {"ENG4", "MATS12", "MACS2"})
    //    Tem q dar erro em 2 casos
    public void testeChavePrimarias(String sigla) throws Exception {
        Disciplina disciplinaTeste = new Disciplina(sigla, "Engenharia 4", "Baseado em tudo", "Engenharias da Vida", 8, 10.7);
        dataBase.createDisciplina(disciplinaTeste);
    }

    @Order(6)
    @Test
    @DisplayName("Removendo elemento")
    public void removendoDisciplina() throws Exception {
        assertTrue(dataBase.deleteDisciplina("MATS1"));
    }
}