public class Usuario {

    private static final int LIMITE_EMPRESTIMO = 2;

    private int id;
    private String nome;
    private String matricula;
    private String email;
    private int emprestimoAtivo;

    public Usuario(int id, String nome, String matricula, String email) {
        this.id = id;
        this.nome = nome;
        this.matricula = matricula;
        this.email = email;
        this.emprestimoAtivo = 0;
    }

    public boolean podePegarEmprestimo() {
        return emprestimoAtivo < LIMITE_EMPRESTIMO;
    }

    public int getId() { return id; }
    public String getNome() { return nome; }
    public String getMatricula() { return matricula; }
    public String getEmail() { return email; }
    public int getEmprestimoAtivo() { return emprestimoAtivo; }

    public void setEmprestimoAtivo(int emprestimoAtivo) {
        this.emprestimoAtivo = emprestimoAtivo;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void PodePegarEprestimo() {
        if (emprestimoAtivo == 0) {
            System.out.println("Emprestimo Disponível para uso");
        } else {
            System.out.println("Emprestimo indísponivel");
        }
    }
}