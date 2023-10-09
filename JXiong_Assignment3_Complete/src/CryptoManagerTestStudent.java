/*
 * Class: CMSC203 21575
 * Instructor: Grigoriy Grinberg
 * Description: CryptoManagerTestStudent Class - Student's JUnit Test
 * Due: 10/09/2023
 * Platform/compiler: IntellJ
 * I pledge that I have completed the programming  assignment independently.
 *  I have not copied the code from a student or any source.
 *  I have not given my code to any student.
 *  Print your Name here: Jordan Xiong
 */
import com.example.cmscassignment3.CryptoManager;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CryptoManagerTestStudent {

    @Test
    public void testStringInBounds() {
        assertTrue(CryptoManager.isStringInBounds("CRYPTO_MANAGER"));
        assertTrue(CryptoManager.isStringInBounds("ENCRYPT_THIS"));
        assertFalse(CryptoManager.isStringInBounds("java"));
        assertFalse(CryptoManager.isStringInBounds("{JAVA"));
        assertFalse(CryptoManager.isStringInBounds("Testing 123!"));
    }

    @Test
    public void testEncryptCaesar() {
        assertEquals("DEF", CryptoManager.caesarEncryption("ABC", 3));
        assertEquals("Z[\\", CryptoManager.caesarEncryption("XYZ", 2));
        assertEquals("QRS", CryptoManager.caesarEncryption("JKL", 7));
        assertEquals("UVWX", CryptoManager.caesarEncryption("QRST", 4));
        assertEquals("XYZ[", CryptoManager.caesarEncryption("WXYZ", 1));
    }

    @Test
    public void testDecryptCaesar() {
        assertEquals("ABC", CryptoManager.caesarDecryption("DEF", 3));
        assertEquals("XYZ", CryptoManager.caesarDecryption("Z[\\", 2));
        assertEquals("JKL", CryptoManager.caesarDecryption("QRS", 7));
        assertEquals("QRST", CryptoManager.caesarDecryption("UVWX", 4));
        assertEquals("WXYZ", CryptoManager.caesarDecryption("XYZ[", 1));
    }

    @Test
    public void testEncryptBellaso() {
        assertEquals("WW,$]]J", CryptoManager.bellasoEncryption("TESTING", "CRYPTO"));
        assertEquals("MPZJXH", CryptoManager.bellasoEncryption("CODING", "JAVA"));
        assertEquals("VRVU#WJ%", CryptoManager.bellasoEncryption("COMPUTER", "SCIENCE"));

    }

    @Test
    public void testDecryptBellaso() {
        assertEquals("TESTING", CryptoManager.bellasoDecryption("WW,$]]J", "CRYPTO"));
        assertEquals("CODING", CryptoManager.bellasoDecryption("MPZJXH", "JAVA"));
        assertEquals("COMPUTER", CryptoManager.bellasoDecryption("VRVU#WJ%", "SCIENCE"));
    }
}
