package model.db;

import model.entity.Disciplina;
import model.entity.Professor;

import java.util.Collection;
import java.util.LinkedHashMap;

public class DataBase {

    private final LinkedHashMap<String, Professor> professores = new LinkedHashMap<>();
    private final LinkedHashMap<String, Disciplina> disciplinas = new LinkedHashMap<>();

    public Collection<Professor> getProfessores() {
        return professores.values();
    }

    public Collection<Disciplina> getDisciplinas() {
        return disciplinas.values();
    }

    public Professor getProfessor(String registroFuncional) throws Exception {
            if( professores.get(registroFuncional) == null ) throw new Exception();
            return professores.get(registroFuncional);
    }

    public Disciplina getDisciplina(String sigla) throws Exception {
        if( disciplinas.get(sigla) == null ) throw new Exception();
        return disciplinas.get(sigla);
    }

    public Professor updateProfessor(Professor professor) throws Exception{
        if( professores.get(professor.getRegistroFuncional()) == null ) throw new Exception();
        return professores.replace(professor.getRegistroFuncional(), professor);
    }

    public Disciplina updateDisciplina(Disciplina disciplina) throws Exception{
        if( disciplinas.get(disciplina.getSigla()) == null ) throw new Exception();
        return disciplinas.replace(disciplina.getSigla(), disciplina);
    }

    public boolean deleteProfessor(String registroFuncional) throws Exception {
        if( professores.get(registroFuncional) == null ) throw new Exception();
        professores.remove(registroFuncional);
        return true;
    }

    public boolean deleteDisciplina(String sigla) throws Exception {
        if( disciplinas.get(sigla) == null ) throw new Exception();
        disciplinas.remove(sigla);
        return true;
    }

    public void createDisciplina(Disciplina disciplina) throws Exception{
        if (disciplinas.get(disciplina.getSigla()) == null){
            disciplinas.put(disciplina.getSigla(), disciplina);
            return;
        }
        throw new Exception();
    }

    public void createProfessor(Professor professor) throws Exception{
        if (professores.get(professor.getRegistroFuncional()) == null){
            professores.put(professor.getRegistroFuncional(), professor);
            return;
        }
        throw new Exception();
    }

}
