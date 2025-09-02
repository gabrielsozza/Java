public class TesteSistema {
    public static void main(String[] args) {
        Passageiro p1 = new Passageiro("João Silva", 30, "12345678901", "joao@email.com");
        Passageiro p2 = new Passageiro("Maria Oliveira", 25, "98765432100", "maria@email.com");
        Passageiro p3 = new Passageiro("Carlos Santos", 40, "11122233344", "carlos@email.com");
        Passageiro p4 = new Passageiro("Israel Santos", 50, "11122233344", "carlos@email.com");

        Viagem onibus1 = new Viagem(1234, "São Paulo", "Rio de Janeiro", "08:00", "12:00", 2);
        Viagem onibus2 = new Viagem(1432, "Espirito Santo", "Bahia", "22:00", "05:00", 2);

        SistemaViagem sistema = new SistemaViagem();

        System.out.println("\n--- TESTE DE RESERVAS ---");
        sistema.reservar(p1, onibus1); 
        sistema.reservar(p2, onibus1); 
        sistema.reservar(p3, onibus1);
        sistema.reservar(p4, onibus2);

        System.out.println("\n--- FILA DE RESERVAS PENDENTES ---");
        sistema.mostrarFila();

        System.out.println("\n--- CANCELAMENTO ---");
        onibus1.cancelarReserva(1);
        onibus2.cancelarReserva(2);

        System.out.println("\n--- PROCESSANDO FILA ---");
        sistema.processarFila(onibus1);
        sistema.processarFila(onibus2);

        System.out.println("\n--- FILA DE RESERVAS PENDENTES APÓS PROCESSAMENTO ---");
        sistema.mostrarFila();

        System.out.println("\n--- RESERVAS ATUAIS ---");
        onibus1.mostrarReservas();
        onibus2.mostrarReservas();
    }
}

