import java.util.LinkedList;
import java.util.Queue;

public class GerenciadorReservas{
    private Queue<Reserva> filaReservas;

    public GerenciadorReservas(){
        filaReservas = new LinkedList<>();
    }

    //Adicionar reserva à fila
    public void adicionarReserva(Reserva r){
        filaReservas.add(r);
        System.out.println("Reserva adicionada à fila: " + r);
    }

    //Processar reservas (confirmar)
    public void  processarReservas(){
        while (!filaReservas.isEmpty()){
            Reserva r = filaReservas.poll(); // remove da fila
            Viagem v = r.getViagem();
            Passageiro p = r.getPassageiro();
            int numeroAssentoDesejado = r.getNumeroAssento();

        // Se não houver vaga na viagem, não dá pra confirmar
            if (!v.hasVaga()) {
                System.out.println("Viagem lotada, reserva não confirmada: " + r);
                continue; // passa para próxima reserva
            }

            boolean sucesso = false;
            int assentoConfirmado = -1;

         // Se reserva especificou um assento válido, tenta esse primeiro
            if (numeroAssentoDesejado >= 1 && numeroAssentoDesejado <= v.getCapacidade()) {
                sucesso = v.reservarAssento(p, numeroAssentoDesejado);
                if (sucesso) assentoConfirmado = numeroAssentoDesejado;
            }

        // Se não especificou assento (ex: -1) ou o assento desejado estava ocupado,
            // procura o primeiro assento livre e tenta reservar
            if (!sucesso) {
                for (int i = 1; i <= v.getCapacidade(); i++) {
                    if (v.reservarAssento(p, i)) {
                        sucesso = true;
                        assentoConfirmado = i;
                        break;
                    }
                }
            }

            if (sucesso){
                System.out.println("Reserva confirmada: " + r + " -> assento " + assentoConfirmado);
            } else {
                System.out.println("Não foi possível confirmar a reserva (assentos ocupados): " + r);
            }
        }
    }

    //Listar reservas pendentes
    public void  listarReservasPendentes(){
        if (filaReservas.isEmpty()){
            System.out.println("Nenhuma reserva pedente.");
            return;
        }
        System.out.println("==== RESERVAS PENDENTES ====");
        for (Reserva r : filaReservas) {
            System.out.println(r.getPassageiro().getNome());
        }
    }
}