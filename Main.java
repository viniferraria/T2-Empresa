class Main {
  public static void main(String[] args) {
      try {
        Menu main = new Menu();
        main.executarMenu();
      } catch (Exception e) {
        System.out.println("Erro: " + e);
      }

    // Pessoa teste1 = new Estagiario(1, "teste1", 53, 53.0, 2.0);
    // Pessoa teste2 = new Funcionario(2, "teste2", 53, 53.0, 59.0);
    // Presidente teste3 = new Presidente(3, "teste3", 53, 53.0);
    // Empresa nova = new Empresa();

    // nova.pushBack(teste1);
    // nova.pushBack(teste2);
    // nova.pushBack(teste3);
    // System.out.println(nova);

    // try {
    //     for(int i = 0; i < 100; ++i) {
    //         nova.pushBack(teste1);
    //     }
    // } catch (Exception e) {
    //     System.out.println(e.getMessage());
    // }
    // System.out.println(nova);
  }
}