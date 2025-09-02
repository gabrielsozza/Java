import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;

public class SistemaViagem{
    private ArrayList<Viagem> viagens;
    private Queue<Reserva> fila; // fila de espera de reservas

    public SistemaViagem(){
        this.viagens = new ArrayList<>();
        this.fila = new LinkedList<>();
    }

    public void cadastrarViagem(Viagem v){
        viagens.add(v);
        System.out.println("Viagem cadastrada com sucesso: " + v);
    }

    public void listarViagens(){
        if(viagens.isEmpty()){
            System.out.println("Nenhuma viagem cadastrada.");
        } else {
            System.out.println("==== LISTAR VIAGENS ====");
            for(Viagem v : viagens){
                System.out.println(v);
            }
        }
    }

    public boolean reservar(Passageiro p, Viagem v){
        // tenta reservar o primeiro assento livre
        for(int i=1; i<=v.getCapacidade(); i++){
            if(v.reservarAssento(p, i)){
                System.out.println("Reserva feita para " + p.getNome() + " no assento " + i);
                return true;
            }
        }
        // se não conseguiu, adiciona à fila
        fila.add(new Reserva(p, v, -1));
        System.out.println("Ônibus cheio! Passageiro " + p.getNome() + " adicionado à fila.");
        return false;
    }


    // Listar viagens com assentos disponíveis
    public void listarViagensComVagas(){
        System.out.println("==== VIAGENS COM VAGAS ====");
        for(Viagem v : viagens){
            if(v.hasVaga()){
                System.out.println(v);
            }       
        }
    }

    // Listar viagens lotadas
    public void listarViagensLotadas(){
        System.out.println("==== VIAGENS LOTADAS ====");
        for(Viagem v : viagens){
            if(!v.hasVaga()){ // nota: !hasVaga() = lotada
                System.out.println(v);
            } 
        }
    }


    public void mostrarFila(){
        System.out.println("Fila de espera:");
        if(fila.isEmpty()){
            System.out.println("Fila vazia.");
        } else {
            for (Reserva r : fila) {
                System.out.println(r.getPassageiro().getNome());
            }
        }
    }

    public void processarFila(Viagem v){
        Queue<Reserva> atendidos = new LinkedList<>();
        for(Reserva r : fila){
            for(int i=1; i<=v.getCapacidade(); i++){
                if(v.reservarAssento(r.getPassageiro(), i)){
                    System.out.println("Passageiro da fila " + r.getPassageiro().getNome() + " assumiu o assento " + i);
                    atendidos.add(r);
                    break;
                }
            }
        }
        fila.removeAll(atendidos);
    }

    //Processar reservas pendentes
    public void processarReservasPendentes() {
        while (!fila.isEmpty()) {
            Reserva reserva = fila.poll(); // tira da fila
            Viagem viagem = reserva.getViagem();

            if (viagem.hasVaga()) {
                viagem.reservarAssento(reserva.getPassageiro(), reserva.getNumeroAssento());
                System.out.println("Reserva confirmada: " + reserva);
            } else {
                System.out.println("Reserva não pode ser confirmada (ônibus cheio): " + reserva);
            }
        }
    }
}
