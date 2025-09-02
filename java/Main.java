public class Main {
    public static void main(String[] args) {
        SistemaViagem sistema = new SistemaViagem();

        // Criar algumas viagens fictícias
        Viagem v1 = new Viagem(1234, "São Paulo", "Rio de Janeiro", "10/09/2025", "08:00", 40); 
        Viagem v2 = new Viagem(4312, "Espirito Santo", "Bahia", "23/012/2025", "10:30", 50); 
        Viagem v3 = new Viagem(1643, "São Paulo", "Rio de Janeiro", "15/11/2025", "09:00", 60); 

        // Cadastrar viagens
        sistema.cadastrarViagem(v1);
        sistema.cadastrarViagem(v2);
        sistema.cadastrarViagem(v3);

        // Listar todas
        sistema.listarViagens();

        // Listar com vagas
        sistema.listarViagensComVagas();

        // Listar lotadas
        sistema.listarViagensLotadas();
    }
}
