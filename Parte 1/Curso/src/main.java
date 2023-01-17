import model.db.DataBase;
import model.entity.Disciplina;
import model.entity.Professor;

import java.util.Scanner;

public class main {
    private static final DataBase dataBase = new DataBase();


    public static void main(String[] args) throws Exception {
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

        int op = -1;
        while (op != 0){
            op = menuInicial();
            switch (op){
                case 1:
                    int opProf = submemenuProfessor();
                    switch (opProf){
                        case 1:
                            listarTodosProfessores();
                            break;
                        case 2:
                            listarProfessor();
                            break;
                        case 3:
                            cadastrarProfessor();
                            break;
                        case 4:
                            editarProfessor();
                            break;
                        case 5:
                            deletarProfessor();
                            break;
                        default:
                            break;
                    }
                    break;
                case 2:
                    int opDisciplina = submemenuDisciplina();
                    switch (opDisciplina){
                        case 1:
                            listarTodasDisciplinas();
                            break;
                        case 2:
                            listarDisciplina();
                            break;
                        case 3:
                            cadastrarDisciplina();
                            break;
                        case 4:
                            editarDisciplina();
                            break;
                        case 5:
                            deletarDisciplina();
                            break;
                        default:
                            break;
                    }
                    break;
                default:
                    break;
            }
        }
    }

    private static void deletarDisciplina() throws Exception {
        Scanner ler = new Scanner(System.in);
        System.out.print("Sigla: ");
        String sigla = ler.next();
        if (dataBase.getDisciplinas() != null){
            dataBase.deleteDisciplina(sigla);
        }
    }

    private static void editarDisciplina() throws Exception {
        System.out.println("=======================");
        Scanner ler = new Scanner(System.in);
        System.out.print("Sigla: ");
        String sigla = ler.next();
        if (dataBase.getDisciplina(sigla) != null){
            System.out.print("Nome: ");
            String nome = ler.next();
            System.out.print("Ementa: ");
            String ementa = ler.next();
            System.out.print("Livros Bibliografia: ");
            String bibliografia = ler.next();
            System.out.print("Número de créditos: ");
            Integer nCred = ler.nextInt();
            System.out.print("Carga horária: ");
            Double ch = ler.nextDouble();
            Disciplina disciplina = new Disciplina(sigla, nome, ementa, bibliografia, nCred, ch);
            dataBase.updateDisciplina(disciplina);
        }
    }

    private static void cadastrarDisciplina() throws Exception {
        Scanner ler = new Scanner(System.in);
        System.out.println("=======================");
        System.out.println("Cadastrar Disciplina: ");
        System.out.print("Sigla ");
        String sigla = ler.next();
        System.out.print("Nome: ");
        String nome = ler.next();
        System.out.print("Ementa: ");
        String ementa = ler.next();
        System.out.print("Livros Bibliografia: ");
        String bibliografia = ler.next();
        System.out.print("Número de créditos: ");
        Integer nCred = ler.nextInt();
        System.out.print("Carga horária: ");
        Double ch = ler.nextDouble();
        Disciplina disciplina = new Disciplina(sigla, nome, ementa, bibliografia, nCred, ch);
        dataBase.createDisciplina(disciplina);
    }

    private static void listarDisciplina() throws Exception {
        Scanner ler = new Scanner(System.in);
        System.out.print("Sigla: ");
        String sigla = ler.next();
        Disciplina disciplina = dataBase.getDisciplina(sigla);
        System.out.println(disciplina.toString());
    }

    private static void listarTodasDisciplinas() {
        dataBase.getDisciplinas().forEach(disciplina -> System.out.println(disciplina.toString()));
    }

    private static void listarTodosProfessores() {
        dataBase.getProfessores().forEach(professor -> System.out.println(professor.toString()));
    }

    private static void deletarProfessor() throws Exception {
        Scanner ler = new Scanner(System.in);
        System.out.print("Registro Funcional: ");
        String rf = ler.next();
        if (dataBase.getProfessor(rf) != null){
            dataBase.deleteProfessor(rf);
        }
    }

    private static void editarProfessor() throws Exception {
        Scanner ler = new Scanner(System.in);
        System.out.print("Registro Funcional: ");
        String rf = ler.next();
        if (dataBase.getProfessor(rf) != null){
            System.out.print("Nome: ");
            String nome = ler.next();
            System.out.print("Data Nascimento: ");
            String dataNasc = ler.next();
            System.out.print("Sexo: (M) (F)");
            String sexo = ler.next();
            System.out.print("Área pesquisada: ");
            String areaPes = ler.next();
            System.out.print("Universidade de Formação: ");
            String uniForm = ler.next();
            Professor professor = new Professor(rf, nome, dataNasc, sexo, areaPes, uniForm);
            dataBase.updateProfessor(professor);
        }
    }

    private static void listarProfessor() throws Exception {
        Scanner ler = new Scanner(System.in);
        System.out.print("Registro Funcional: ");
        String rf = ler.next();
        Professor professor = dataBase.getProfessor(rf);
        System.out.println(professor.toString());
    }

    private static void cadastrarProfessor() throws Exception {
        Scanner ler = new Scanner(System.in);
        System.out.println("=======================");
        System.out.println("Cadastrar Professor: ");
        System.out.print("Registro Funcional: ");
        String rf = ler.next();
        System.out.print("Nome: ");
        String nome = ler.next();
        System.out.print("Data Nascimento: ");
        String dataNasc = ler.next();
        System.out.print("Sexo: (M) (F): ");
        String sexo = ler.next();
        System.out.print("Área pesquisada: ");
        String areaPes = ler.next();
        System.out.print("Universidade de Formação: ");
        String uniForm = ler.next();
        Professor professor = new Professor(rf, nome, dataNasc, sexo, areaPes, uniForm);
        dataBase.createProfessor(professor);
    }

    public static int menuInicial(){
        Scanner ler = new Scanner(System.in);
        System.out.println("=======================");
        System.out.println("1 - Submenu do Professor");
        System.out.println("2 - Submenu da Disciplina");
        System.out.println("0 - Sair");
        System.out.print("Escolha sua opção: ");
        return ler.nextInt();
    }

    public static int submemenuProfessor(){
        Scanner ler = new Scanner(System.in);
        System.out.println("=======================");
        System.out.println("1 - Listar Professores");
        System.out.println("2 - Listar 1 Professor");
        System.out.println("3 - Cadastrar Professor");
        System.out.println("4 - Editar Professor");
        System.out.println("5 - Excluir Professor");
        System.out.println("0 - Voltar");
        System.out.print("Escolha sua opção: ");
        return ler.nextInt();
    }

    public static int submemenuDisciplina(){
        Scanner ler = new Scanner(System.in);
        System.out.println("=======================");
        System.out.println("1 - Listar Disciplinas");
        System.out.println("2 - Listar 1 Disciplina");
        System.out.println("3 - Cadastrar Disciplina");
        System.out.println("4 - Editar Disciplina");
        System.out.println("5 - Excluir Disciplina");
        System.out.println("0 - Voltar");
        System.out.print("Escolha sua opção: ");
        return ler.nextInt();
    }

}
