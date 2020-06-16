public class Empresa {
    private Pessoa empregados[];
    private int numEmpregados = 0;


    public Empresa() {
        this.empregados = new Pessoa[100];
    }

    private boolean canInsert() {
        return (this.numEmpregados < this.empregados.length);
    }

    public void pushBack(Pessoa p) throws IndexOutOfBoundsException {
        if (this.canInsert())
            this.empregados[this.numEmpregados++] = p;
        else
            throw new IndexOutOfBoundsException("Empresa atingiu o limite de funcionários.");
    }

    public double calcularPagamento(int id) throws IndexOutOfBoundsException {
        for (int i = 0; i < this.numEmpregados; ++i) {
            if (this.empregados[i].getId() == id)
                return this.empregados[i].pagamento();
        }
        throw new IndexOutOfBoundsException("Id inválido");
    }

    public void aumentarAdicional(double aumento) throws ArrayStoreException {
        if (this.numEmpregados == 0) {
            throw new ArrayStoreException("Não existem funcionários para aumentar o adicional.");
        }
        for (int i = 0; i < this.numEmpregados; ++i) {
            if (this.empregados[i] instanceof Presidente)
                ((Presidente)this.empregados[i]).setAdicional(aumento);
            else if (this.empregados[i] instanceof Funcionario)
                ((Funcionario)this.empregados[i]).setAdicional(aumento);
        }
    }

    @Override
    public String toString() {
        String repr = String.format("|%8s |%15s |%15s |%13s |%14s |%12s |%16s |%16s |\n", "ID", "Nome", "Departamento", "Salário", "Adi/Vale", "Previdência", "Adi whiskey", "Adi helico");
        for(int i = 0; i < this.numEmpregados; ++i) {
            repr += String.format("%s\n",this.empregados[i].toString());
        }
        return repr;
    }
}