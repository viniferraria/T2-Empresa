import java.util.Scanner;

public class Menu {
    private Scanner scan;
    private Empresa company;

    Menu() {
        this.scan = new Scanner(System.in);
        this.company = new Empresa();
    }

    private Pessoa criarPessoa() {
        System.out.print("Id do funcionário: ");
        int id = this.scan.nextInt();

        System.out.print("Nome: ");
        String nome = this.scan.next();

        System.out.print("Departamento:");
        int departamento = this.scan.nextInt();

        System.out.print("Salário: ");
        double salario = this.scan.nextDouble();
        
        
        Pessoa nova = null;
        int typeId;
        do {
            System.out.println("Informe o tipo do funcionário:\n0 - Estágiario\n1 - Funcionário\n2 - Presidente");
            typeId = this.scan.nextInt();
            switch (typeId) {
                case 0:
                    System.out.print("Vale Coxinha: ");
                    double valeCoxinha = this.scan.nextDouble();
                    nova = new Estagiario(id, nome, departamento, salario, valeCoxinha);
                    break;
                case 1:
                    System.out.print("Adicional: ");
                    double adicional = this.scan.nextDouble();
                    nova = new Funcionario(id, nome, departamento, salario, adicional);
                    break;
                case 2:
                    nova = new Presidente(id, nome, departamento, salario);
                    break;
                default:
                    System.out.print("Opção inválida, escolha uma opção entre 0 e 2\n");
                    break;
            }
        } while (typeId < 0 || typeId > 2);
        if (nova == null) {
            throw new NullPointerException("Pessoa não inicializada.");
        }
        System.out.println(nova);
        return nova;
    };

    private void drawMenu(String[] items) {
        System.out.println("\n====================================== T2 - Empresa ========================================");
        for (String item: items)
            System.out.println(String.format("| %1$-89s|", item));
        System.out.println("============================================================================================\n");
    }

    private void trataErro(Exception err) {
        System.out.println(String.format("Erro: %s", err));
        err.printStackTrace();
    }

    public void executarMenu() {
        int opt;
        do {
            String[] Items = {
                "0 - Adicionar um funcionário.",
                "1 - Calcular pagamento do funcionário.",
                "2 - Aumentar o adicional de todos os funcionários.",
                "3 - Relatório dos funcionários da empresa.",
                "4 - Sair."
            };
            drawMenu(Items);
            System.out.print("Digite o número da operação desejada: ");
            opt = this.scan.nextInt();
            switch(opt) {
                case 0:
                    try {
                        Pessoa nova = criarPessoa();
                        this.company.pushBack(nova);
                    } catch (IndexOutOfBoundsException err) {
                        System.out.println(err.getMessage());
                    } catch (Exception e) {
                        trataErro(e);
                    }
                    break;
                case 1:
                    try {
                        System.out.print("Informe o ID do funcionário que deseja calcular o pagamento: ");
                        int id = this.scan.nextInt();
                        System.out.println(String.format("O pagamento do funcionário com id %d é: %2.f reais", id, this.company.calcularPagamento(id)));
                    } catch (IndexOutOfBoundsException err) {
                        System.out.println(err.getMessage());
                    } catch (Exception e) {
                        trataErro(e);
                    }
                    break;
                case 2:
                    try {
                        System.out.print("Informe o valor do novo adicional: ");
                        double novoAdicional = this.scan.nextDouble();
                        this.company.aumentarAdicional(novoAdicional);
                        System.out.println(String.format("Realizado aumento de %.2f no adicional dos funcionários.", novoAdicional));
                    } catch (ArrayStoreException err) {
                        System.out.println(err.getMessage());
                    } catch (Exception e) {
                        trataErro(e);
                    }
                    break;
                case 3:
                    System.out.println(this.company);
                    break;
                case 4:
                    System.out.println("Programa encerrado.");
                    break;
                default:
                    System.out.println("Opção inválida, escolha uma opção entre 0 e 4\n");
                    break;
            }
        } while (opt != 4);
        this.scan.close();
    }
}