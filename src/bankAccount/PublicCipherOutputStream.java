package bankAccount;

import javax.crypto.Cipher;
import javax.crypto.CipherOutputStream;
import java.io.OutputStream;

public class PublicCipherOutputStream extends CipherOutputStream {

    public PublicCipherOutputStream(OutputStream out, Cipher cipher) {
        super(out, cipher);
    }
}
