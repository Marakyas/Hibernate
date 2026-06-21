public class Main {
    public static void main(String[] args) {
        System.out.println("=== ЗАПУСК ПРИЛОЖЕНИЯ ===");

        try {
            ConsoleInterface cli = new ConsoleInterface();
            cli.start();
        } catch (Throwable t) {
            System.err.println("КРИТИЧЕСКИЙ СБОЙ ПРИ ВЫПОЛНЕНИИ ПРОГРАММЫ:");
            System.err.println(t.getMessage());
            t.printStackTrace();
        }
    }
}
