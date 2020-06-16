public class Estagiario extends Pessoa {
    private double valecoxinha;
    
    public Estagiario (
        int Id,
        String nome,
        int departamento,
        double salario,
        double valecoxinha
    ) {
        super(Id, nome, departamento, salario);
        this.valecoxinha = valecoxinha;
    }

    public void setValeCoxinha(double valecoxinha) {
        this.valecoxinha = valecoxinha;
    }

    public double pagamento() {
        return (this.getSalario() + this.valecoxinha);
    }

    @Override
    public String toString() {
        return String.format("%s%14.2f |", super.toString(), this.valecoxinha); 
    }
}
