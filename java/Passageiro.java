public class Passageiro{
    private String nome;
    private int idade;
    private String cpf;
    private String email;

    //Construtor
    public Passageiro(String nome, int idade, String cpf, String email){
        this.nome = nome;
        this.idade = idade;

        if(!validarCPF(cpf)){
            throw new IllegalArgumentException("CPF inválido. Deve conter 11 números.");
        }
        this.cpf = cpf;

        if(!validarEmail(email)){
            throw new IllegalArgumentException("Email inválido.");
        }
        this.email = email;
    }

    //Método para validar CPF (simples: apenas verifica se tem 11 dígitos numéricos)
    private boolean validarCPF(String cpf){
        if(cpf == null || cpf.length() != 11) return false;
        for(int i = 0; i < cpf.length(); i++){
            if(!Character.isDigit(cpf.charAt(i))) return false;
        }
        return true;
    }

    //Método para validar email (Simples: verifica se contém '@' e '.')
    private boolean validarEmail(String email){
        if (email == null) return false;
        return email.contains("@") && email.contains(".");
    }

    @Override
    public String toString() {
        return " Nome: " + nome + ", CPF: " + cpf + ", Email: " + email;
    }

    //Getters
    public String getNome() { return nome; }
    public int getIdade() { return idade; }
    public String getCpf() { return cpf; }
    public String getEmail() { return email; }
}