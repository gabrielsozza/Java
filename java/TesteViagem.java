public class TesteViagem {
    public static void main(String[] args) {
        // Teste 1: Viagem válida
        try {
            Viagem v1 = new Viagem(1234, "São Paulo", "Rio de Janeiro", "10/09/2025", "08:00", 40);
            System.out.println("Viagem criada com sucesso: " + v1);
        } catch (IllegalArgumentException e) {
            System.out.println("Erro: " + e.getMessage());
        }

        // Teste 2: Lugares inválidos (número negativo)
        try {
            Viagem v2 = new Viagem(1432, "Vitória", "Belo Horizonte", "12/09/2025", "09:00", 35);
            System.out.println("Viagem criada com sucesso: " + v2);
        } catch (IllegalArgumentException e) {
            System.out.println("Erro: " + e.getMessage());
        }

        // Teste 3: Campos vazios (sem origem)
        try {
            Viagem v3 = new Viagem(1234, "", "Salvador", "15/09/2025", "07:00", 30);
            System.out.println("Viagem criada com sucesso: " + v3);
        } catch (IllegalArgumentException e) {
            System.out.println("Erro: " + e.getMessage());
        }

        // Teste 4: Quantidade de número do ônibus menor que 4 dígitos
        try {
            Viagem v3 = new Viagem(123, "Espirito Santo", "Salvador", "15/09/2025", "07:00", 30);
            System.out.println("Viagem criada com sucesso: " + v3);
        } catch (IllegalArgumentException e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }
}
