import java.time.LocalDate;
import java.util.ArrayList;

public class Emprestimo {

    private int id;
    private Usuario usuario;
    private Funcionario funcionario;
    private ArrayList<ItemAcervo> itens;
    private LocalDate dataEmprestimo;
    private LocalDate dataDevolucao;

    public Emprestimo(int id, Usuario usuario, Funcionario funcionario) {
        this.id = id;
        this.usuario = usuario;
        this.funcionario = funcionario;
        this.itens = new ArrayList<>();
        this.dataEmprestimo = LocalDate.now();
        this.dataDevolucao = LocalDate.now().plusDays(7);
    }

    public void adicionarItem(ItemAcervo item) {
        item.setDisponivel(false);
        itens.add(item);
    }

    public String getDetalhes() {
        StringBuilder sb = new StringBuilder();
        sb.append("Emprestimo ID: ").append(id)
                .append(" | Usuario: ").append(usuario.getNome())
                .append(" | Funcionario: ").append(funcionario.getNome())
                .append(" | Retirada: ").append(dataEmprestimo)
                .append(" | Devolucao: ").append(dataDevolucao)
                .append("\nItens:");
        for (ItemAcervo item : itens) {
            sb.append("\n  - ").append(item.getDetalhes());
        }
        return sb.toString();
    }

    public int getId() { return id; }
    public Usuario getUsuario() { return usuario; }
    public Funcionario getFuncionario() { return funcionario; }
    public ArrayList<ItemAcervo> getItens() { return itens; }
    public LocalDate getDataEmprestimo() { return dataEmprestimo; }
    public LocalDate getDataDevolucao() { return dataDevolucao; }
}