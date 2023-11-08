import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;
import org.bouncycastle.jce.provider.BouncyCastleProvider; // Importação necessária, biblioteca Bouncy Castle instalada.
import java.security.Key;
import java.util.Base64;
import java.security.Security; // Importação necessária

public class Criptografia {
    private static final String chaveSecreta = "#modalGR#GPTW#top#maiorEmpresaTecnologia#baixadaSantista";

    public static String criptografarBlowfish(String senha) throws Exception {
        Key chave = new SecretKeySpec(chaveSecreta.getBytes(), "Blowfish");
        Cipher cipher = Cipher.getInstance("Blowfish");
        cipher.init(Cipher.ENCRYPT_MODE, chave);
        byte[] senhaCriptografada = cipher.doFinal(senha.getBytes());
        return Base64.getEncoder().encodeToString(senhaCriptografada);
    }

    public static String descriptografarBlowfish(String senhaCriptografada) throws Exception {
        Key chave = new SecretKeySpec(chaveSecreta.getBytes(), "Blowfish");
        Cipher cipher = Cipher.getInstance("Blowfish");
        cipher.init(Cipher.DECRYPT_MODE, chave);
        byte[] senhaCriptografadaBytes = Base64.getDecoder().decode(senhaCriptografada);
        byte[] senhaDescriptografadaBytes = cipher.doFinal(senhaCriptografadaBytes);
        return new String(senhaDescriptografadaBytes);
    }

    public static String criptografarRC4(String senha) throws Exception {
        Key chave = new SecretKeySpec(chaveSecreta.getBytes(), "RC4");
        Cipher cipher = Cipher.getInstance("RC4");
        cipher.init(Cipher.ENCRYPT_MODE, chave);
        byte[] senhaCriptografada = cipher.doFinal(senha.getBytes());
        return Base64.getEncoder().encodeToString(senhaCriptografada);
    }

    public static String descriptografarRC4(String senhaCriptografada) throws Exception {
        Key chave = new SecretKeySpec(chaveSecreta.getBytes(), "RC4");
        Cipher cipher = Cipher.getInstance("RC4");
        cipher.init(Cipher.DECRYPT_MODE, chave);
        byte[] senhaCriptografadaBytes = Base64.getDecoder().decode(senhaCriptografada);
        byte[] senhaDescriptografadaBytes = cipher.doFinal(senhaCriptografadaBytes);
        return new String(senhaDescriptografadaBytes);
    }

    public static String criptografarSerpent(String senha) throws Exception {
        Key chave = new SecretKeySpec(chaveSecreta.getBytes(), "Serpent");
        Cipher cipher = Cipher.getInstance("Serpent", "BC"); // Use "BC" como o provedor Bouncy Castle
        cipher.init(Cipher.ENCRYPT_MODE, chave);
        byte[] senhaCriptografada = cipher.doFinal(senha.getBytes());
        return Base64.getEncoder().encodeToString(senhaCriptografada);
    }

    public static String descriptografarSerpent(String senhaCriptografada) throws Exception {
        Key chave = new SecretKeySpec(chaveSecreta.getBytes(), "Serpent");
        Cipher cipher = Cipher.getInstance("Serpent", "BC"); // Use "BC" como o provedor Bouncy Castle
        cipher.init(Cipher.DECRYPT_MODE, chave);
        byte[] senhaCriptografadaBytes = Base64.getDecoder().decode(senhaCriptografada);
        byte[] senhaDescriptografadaBytes = cipher.doFinal(senhaCriptografadaBytes);
        return new String(senhaDescriptografadaBytes);
    }

    public static void main(String[] args) {
        // Registra o provedor de segurança Bouncy Castle para suportar Serpent
        Security.addProvider(new BouncyCastleProvider());

        try {
            String senha1 = "ModalGR";
            String senha2 = "Melhor";
            String senha3 = "daBaixada";

            String senhaCriptografadaBlowfish = criptografarBlowfish(senha1);
            String senhaCriptografadaRC4 = criptografarRC4(senha2);
            String senhaCriptografadaSerpent = criptografarSerpent(senha3);

            System.out.println("Senha 1 (Blowfish) criptografada: " + senhaCriptografadaBlowfish);
            System.out.println("Senha 2 (RC4) criptografada: " + senhaCriptografadaRC4);
            System.out.println("Senha 3 (Serpent) criptografada: " + senhaCriptografadaSerpent);

            String senhaDescriptografadaBlowfish = descriptografarBlowfish(senhaCriptografadaBlowfish);
            String senhaDescriptografadaRC4 = descriptografarRC4(senhaCriptografadaRC4);
            String senhaDescriptografadaSerpent = descriptografarSerpent(senhaCriptografadaSerpent);

            System.out.println("Senha 1 (Blowfish) descriptografada: " + senhaDescriptografadaBlowfish);
            System.out.println("Senha 2 (RC4) descriptografada: " + senhaDescriptografadaRC4);
            System.out.println("Senha 3 (Serpent) descriptografada: " + senhaDescriptografadaSerpent);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}




