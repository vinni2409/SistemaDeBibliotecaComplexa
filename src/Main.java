import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    private static Scanner scanner = new Scanner(System.in);
    private static ArrayList<Livro> livros = new ArrayList<>();
    private static ArrayList<RevistaAcademica> revistas = new ArrayList<>();
    private static ArrayList<MidiaDigital> midias = new ArrayList<>();
    private static ArrayList<Usuario> usuarios = new ArrayList<>();
    private static ArrayList<Funcionario> funcionarios = new ArrayList<>();
    private static ArrayList<Emprestimo> emprestimos = new ArrayList<>();
    private static int contadorId = 1;

    public static void main(String[] args) {
        popularDados();

        int opcao;
        do {
            System.out.println("\n===== BIBLIOTECA UNIVERSITARIA =====");
            System.out.println("1. Listar acervo");
            System.out.println("2. Realizar emprestimo");
            System.out.println("3. Listar emprestimos");
            System.out.println("4. Calcular multa");
            System.out.println("0. Sair");
            System.out.print("Escolha: ");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1 -> listarAcervo();
                case 2 -> realizarEmprestimo();
                case 3 -> listarEmprestimos();
                case 4 -> calcularMulta();
                case 0 -> System.out.println("Encerrando sistema...");
                default -> System.out.println("Opcao invalida!");
            }
        } while (opcao != 0);
    }

    private static void popularDados() {
        livros.add(new Livro(1, "Clean Code", "Robert Martin", 2008, "978-0132350884", 431, "Tecnologia"));
        livros.add(new Livro(2, "Java Efetivo", "Joshua Bloch", 2018, "978-0134685991", 412, "Tecnologia"));
        revistas.add(new RevistaAcademica(3, "Nature", "Varios Autores", 2023, "0028-0836", "Ciencias", 15));
        midias.add(new MidiaDigital(4, "Curso Java", "Vinni", 2024, "PDF", "drive.google.com/xyz", 120.5));

        usuarios.add(new Usuario(1, "Vinni", "2024001", "vinni@email.com"));
        usuarios.add(new Usuario(2, "Ana", "2024002", "ana@email.com"));

        funcionarios.add(new Funcionario(1, "Carlos", "F001", "Manha", "Atendente"));
    }

    private static void listarAcervo() {
        System.out.println("\n--- ACERVO ---");
        for (Livro l : livros) System.out.println(l.getDetalhes());
        for (RevistaAcademica r : revistas) System.out.println(r.getDetalhes());
        for (MidiaDigital m : midias) System.out.println(m.getDetalhes());
    }

    private static void realizarEmprestimo() {
        System.out.println("\n--- REALIZAR EMPRESTIMO ---");

        System.out.println("Usuarios disponíveis:");
        for (Usuario u : usuarios) {
            System.out.println(u.getId() + " - " + u.getNome());
        }
        System.out.print("ID do usuario: ");
        int idUsuario = scanner.nextInt();
        Usuario usuario = buscarUsuario(idUsuario);

        if (usuario == null) {
            System.out.println("Usuario nao encontrado!");
            return;
        }
        if (!usuario.podePegarEmprestimo()) {
            System.out.println("Usuario atingiu o limite de emprestimos!");
            return;
        }

        Emprestimo emprestimo = new Emprestimo(contadorId++, usuario, funcionarios.get(0));

        int opcao;
        do {
            System.out.println("\nAdicionar item:");
            System.out.println("1. Livro");
            System.out.println("2. Revista");
            System.out.println("3. Midia Digital");
            System.out.println("0. Finalizar");
            System.out.print("Escolha: ");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1 -> {
                    for (Livro l : livros) {
                        if (l.isDisponivel()) System.out.println(l.getId() + " - " + l.getTitulo());
                    }
                    System.out.print("ID do livro: ");
                    int idLivro = scanner.nextInt();
                    for (Livro l : livros) {
                        if (l.getId() == idLivro && l.isDisponivel()) {
                            emprestimo.adicionarItem(l);
                            System.out.println("Livro adicionado!");
                        }
                    }
                }
                case 2 -> {
                    for (RevistaAcademica r : revistas) {
                        if (r.isDisponivel()) System.out.println(r.getId() + " - " + r.getTitulo());
                    }
                    System.out.print("ID da revista: ");
                    int idRevista = scanner.nextInt();
                    for (RevistaAcademica r : revistas) {
                        if (r.getId() == idRevista && r.isDisponivel()) {
                            emprestimo.adicionarItem(r);
                            System.out.println("Revista adicionada!");
                        }
                    }
                }
                case 3 -> {
                    for (MidiaDigital m : midias) {
                        if (m.isDisponivel()) System.out.println(m.getId() + " - " + m.getTitulo());
                    }
                    System.out.print("ID da midia: ");
                    int idMidia = scanner.nextInt();
                    for (MidiaDigital m : midias) {
                        if (m.getId() == idMidia && m.isDisponivel()) {
                            emprestimo.adicionarItem(m);
                            System.out.println("Midia adicionada!");
                        }
                    }
                }
            }
        } while (opcao != 0);

        emprestimos.add(emprestimo);
        usuario.setEmprestimoAtivo(usuario.getEmprestimoAtivo() + 1);
        System.out.println("\nEmprestimo realizado com sucesso!");
        System.out.println(emprestimo.getDetalhes());
    }

    private static void listarEmprestimos() {
        System.out.println("\n--- EMPRESTIMOS ---");
        if (emprestimos.isEmpty()) {
            System.out.println("Nenhum emprestimo registrado.");
            return;
        }
        for (Emprestimo e : emprestimos) System.out.println(e.getDetalhes());
    }

    private static void calcularMulta() {
        System.out.println("\n--- CALCULAR MULTA ---");
        if (emprestimos.isEmpty()) {
            System.out.println("Nenhum emprestimo registrado.");
            return;
        }
        System.out.print("ID do emprestimo: ");
        int id = scanner.nextInt();
        for (Emprestimo e : emprestimos) {
            if (e.getId() == id) {
                int dias = CalculadoraMulta.calcularDiasAtraso(e.getDataDevolucao(), java.time.LocalDate.now());
                double multa = CalculadoraMulta.calcularValorMulta(dias);
                System.out.println("Dias de atraso: " + dias);
                System.out.println("Valor da multa: R$ " + multa);
                return;
            }
        }
        System.out.println("Emprestimo nao encontrado!");
    }

    private static Usuario buscarUsuario(int id) {
        for (Usuario u : usuarios) {
            if (u.getId() == id) return u;
        }
        return null;
    }
}