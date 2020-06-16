public class Presidente extends Pessoa {
    private double previdencia, 
        adicional_whisky,
        adicional_helicoptero, 
        adicional_adicional;

    public Presidente(
        int Id,
        String nome,
        int departamento,
        double salario
    ) {
        super(Id, nome, departamento, salario);
        this.previdencia = 0.05;
        this.adicional_whisky = 0.9;
        this.adicional_helicoptero = 0.7;
        this.adicional_adicional = 3.8;
    }

    public void setAdicional(double novo_percentual) {
        adicional_whisky = 0.9 * (1+novo_percentual);
        adicional_helicoptero = 0.7 * (1+novo_percentual);
        adicional_adicional = 3.8 * (1+novo_percentual);
    }

    public double pagamento() {
        return (this.getSalario() * ((1 - this.previdencia) + this.adicional_whisky
            + this.adicional_helicoptero
            + this.adicional_adicional));
    }
    
    @Override
    public String toString() {
        return String.format("%s%14.2f |%12.2f | %15.2f | %15.2f |", super.toString(), 
            this.adicional_adicional,
            this.previdencia, 
            this.adicional_whisky, 
            this.adicional_helicoptero
        );
    }
}