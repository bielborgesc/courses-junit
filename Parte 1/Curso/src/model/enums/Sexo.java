package model.enums;

public enum Sexo {
    MAS("Masculino"), FEM("Feminino");

    private String sexo;

    Sexo(String valor) {
        this.sexo = valor;
    }

    public String getSexo() {
        return sexo;
    }
}
