public abstract class Pessoa {
    private int Id;   
    private String nome;
    private int departamento;
    private double salario;

    public Pessoa(int Id, String nome, int departamento, double salario) {
        this.Id = Id;    
        this.nome = nome; 
        this.departamento = departamento; 
        this.salario = salario; 
    }

    public abstract double pagamento();
    
    public double getSalario() {
        return this.salario;
    }

    public int getId() {
        return this.Id;
    }

    @Override
    public String toString() {
        return String.format("|%08d |%15s |%015d |%13.2f |", this.Id, this.nome, this.departamento, this.salario);
        // return String.format("Id: %d\nNome: %s\ndepartamento:%d\nsalario: %.2f\npagamento: %.2f",this.Id, this.nome, this.departamento, this.salario, this.getSalario());
    }
}