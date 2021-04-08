
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;


public class RandomPasswordGenerator{
    
    Random random;
    private int passwordLength;
    private String password;
    public RandomPasswordGenerator(int passwordLength) {
        this.passwordLength = passwordLength;
        random = ThreadLocalRandom.current();
        password = "";
    }
    
    public void generate(int lowerBound ,int upperBound , boolean isLastComponent){
        int range;
        try{
            if(isLastComponent) // if it's the last component then there is no need to calculate a random number again
                range = passwordLength;
            else
                range = 1 + random.nextInt(passwordLength - PasswordGeneratorFrame.remainingComponentNumber);// to make it sure that all the selected components appear in the password at least once           
        }catch(IllegalArgumentException e){
            return;
        }
        for (int i = 0; i < range; i++) {
            password += String.valueOf( (char)(lowerBound + random.nextInt(upperBound)) );            
        }
        passwordLength -= range;
    }

    public int getPasswordLength() {
        return passwordLength;
    }

    public String getPassword() {
        return password;
    }
    
    public void shuffleThePassword(){
        char[] characters = password.toCharArray();
        for (int i = 0; i < password.length()/2; i++) {
            int index = random.nextInt(password.length());
            char temp = characters[i];
            characters[i] = characters[index];
            characters[index] = temp;            
        }
        password = new String(characters);
    }
}