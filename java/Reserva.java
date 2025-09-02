public class Reserva{
    private Passageiro passageiro;
    private Viagem viagem;
    private int numeroAssento;

    public Reserva(Passageiro p, Viagem v, int numeroAssento){
        this.passageiro = p;
        this.viagem = v;
        this.numeroAssento = numeroAssento;
    }

    //Getters
    public Passageiro getPassageiro() { return passageiro; }
    public Viagem getViagem() { return viagem; }
    public int getNumeroAssento() { return numeroAssento; }

    @Override
    public String toString(){
        return passageiro.getNome() + " - " + viagem.getOrigem() + " -> " + viagem.getDestino() + " Assento: " + numeroAssento;
    }
}