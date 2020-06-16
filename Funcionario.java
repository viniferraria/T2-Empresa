public class Funcionario extends Pessoa {
    private double previdencia, adicional;

    public Funcionario(
        int Id,
        String nome,
        int departamento,
        double salario,
        double adicional
    ) {
        super(Id, nome, departamento, salario);
        this.previdencia = 0.05;
        this.adicional = adicional;
    }

    public void setAdicional(double novo_percentual) {
        this.adicional = this.adicional * (1 + novo_percentual);
    }

    public double pagamento() {
        return (this.getSalario() * ((1 - this.previdencia) + this.adicional));
    }

    @Override
    public String toString() {
        return String.format("%s%14.2f |%12.2f |", super.toString(),
            this.adicional,
            this.previdencia
        );
    }
}