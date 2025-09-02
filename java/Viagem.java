import java.util.Arrays;

public class Viagem {
    private int numeroOnibus;
    private String origem;
    private String destino;
    private String horarioPartida;
    private String horarioChegada;
    private int capacidade;
    private Passageiro[] assentos; // null = livre, Passageiro = reservado

    public Viagem(int numeroOnibus, String origem, String destino, String horarioPartida, String horarioChegada, int capacidade){
        if(String.valueOf(numeroOnibus).length() != 4){
            throw new IllegalArgumentException("O número do ônibus deve ter 4 dígitos: ");
        }
        if (capacidade <= 0) {
            throw new IllegalArgumentException("A capacidade deve ser maior que zero.");
        }
        if (origem == null || origem.isEmpty()) {
            throw new IllegalArgumentException("Você deve selecionar pelo menos uma Origem");
        }
        if (destino == null || destino.isEmpty()) {
            throw new IllegalArgumentException("Você deve selecionar pelo menos um Destino");
        }

        this.numeroOnibus = numeroOnibus;
        this.origem = origem;
        this.destino = destino;
        this.horarioPartida = horarioPartida;
        this.horarioChegada = horarioChegada;
        this.capacidade = capacidade;
        this.assentos = new Passageiro[capacidade]; //todos começam livres
    }

    //Getters
    public int getCapacidade() {
        return capacidade;
    }

    public String getDestino() {
        return destino;
    }

    //Verificar vaga
    public boolean hasVaga(){
        for (Passageiro p : assentos) {
            if (p == null) return true;
        }
        return false;
    }

    //Reservar assento
    public boolean reservarAssento(Passageiro passageiro, int numeroAssento){
        if(numeroAssento < 1 || numeroAssento > capacidade) return false;
        if(assentos[numeroAssento - 1] != null) return false; // já ocupado
        assentos[numeroAssento - 1] = passageiro; // associa o passageiro ao assento
        return true; 
    }


    // Cancela uma reserva pelo número do assento
    public boolean cancelarReserva(int numeroAssento){
        if(numeroAssento < 1 || numeroAssento > capacidade) return false;
        if(assentos[numeroAssento - 1] == null) return false; // já está livre
        assentos[numeroAssento - 1] = null; // libera o assento
        return true;
    }


    // Mostra o estado dos assentos
    public void mostrarReservas(){
        System.out.println("Reservas do ônibus " + numeroOnibus + ":");
        for(int i = 0; i < assentos.length; i++){
            if(assentos[i] == null){
                System.out.println("Assento " + (i+1) + ": Livre");
            } else {
                System.out.println("Assento " + (i+1) + ": Ocupado por " + assentos[i].getNome());
            }
        }

    }

    @Override
    public String toString() {
        return "Número do Ônibus: " + numeroOnibus +
           ", Origem: " + origem +
           ", Destino: " + destino +
           ", Partida: " + horarioPartida +
           ", Chegada: " + horarioChegada +
           ", Capacidade: " + capacidade;
    }

    public int getNumeroOnibus() { return numeroOnibus; }
    public String getOrigem() { return origem; }
    public String getObjetivo() { return destino; }
}



