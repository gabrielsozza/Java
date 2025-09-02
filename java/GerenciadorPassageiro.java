import java.util.ArrayList;

public class GerenciadorPassageiro{
    private ArrayList<Passageiro> passageiro;

    public GerenciadorPassageiro(){
        passageiro = new ArrayList<>();
    }

    //Cadastrar passageiro
    public void cadastrarPassageiro(Passageiro p){
        passageiro.add(p);
        System.out.println("Passageiro cadastrado com sucesso: " + p);
    }

    //Listar todos os passageiros
    public void listarPassageiros(){
        if (passageiro.isEmpty()){
            System.out.println("Nenhum passageiro cadastrado.");
            return;
        }
        System.out.println("==== LISTA DE PASSAGEIROS ====");
        for(Passageiro p : passageiro){
            System.out.println(p);
        }
    }

    //Procurar passageiro pro CPF
    public Passageiro buscarPorCPF(String cpf){
        for(Passageiro p : passageiro){
            if(p.getCpf().equals(cpf)) return p;
        }
        return null; // Caso não encontre
    }
}