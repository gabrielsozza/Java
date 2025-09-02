public class TestePassageiro{
    public static void main(String[] args){
        // Teste 1: Passageiro válido
        try{
            Passageiro p1 = new Passageiro("João", 24, "12345678901", "joao@email.com");
            System.out.println("Passageiro criado com sucesso:" + p1);
        } catch (IllegalArgumentException e){
            System.out.println("Error:" + e.getMessage());
        }

        //Teste 2 com CPF inválido
        try{
            Passageiro p2 = new Passageiro("Maria", 20, "123456789", "joao@email.com");
            System.out.println("Passageiro criado com sucesso:" + p2);
        } catch (IllegalArgumentException e){
            System.out.println("Error:" + e.getMessage());
        }

        //Teste 3 com Email inválido
        try{
            Passageiro p3 = new Passageiro("Roberto", 22, "12345678901", "joao.emailcom");
            System.out.println("Passageiro criado com sucesso:" + p3);
        } catch (IllegalArgumentException e){
            System.out.println("Error:" + e.getMessage());
        }
    }
}