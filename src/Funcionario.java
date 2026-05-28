public class Funcionario {

    private int id;
    private String nome;
    private String matriculaFuncional;
    private String turno;
    private String cargo;

    public Funcionario(int id, String nome, String matriculaFuncional, String turno, String cargo) {
        this.id = id;
        this.nome = nome;
        this.matriculaFuncional = matriculaFuncional;
        this.turno = turno;
        this.cargo = cargo;
    }

    public int getId() { return id; }
    public String getNome() { return nome; }
    public String getMatriculaFuncional() { return matriculaFuncional; }
    public String getTurno() { return turno; }
    public String getCargo() { return cargo; }
}