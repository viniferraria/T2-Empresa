class Main {
  public static void main(String[] args) {
      try {
        Menu main = new Menu();
        main.executarMenu();
      } catch (Exception e) {
        System.out.println("Erro: " + e);
      }
  }
}