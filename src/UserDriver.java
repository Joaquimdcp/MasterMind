public class UserDriver {
    public static void main(String[] args) {
        User usuario = new User("Mastermind", "1234");
        if (usuario.setUser()) {
            if (usuario.authUser()) {
                System.out.println("All good!");
            }
        }
        
    }
}