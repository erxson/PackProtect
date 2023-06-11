import java.io.*;
import java.util.zip.*;

public class PackProtect {
    public static void main(String[] args) {
        try {
            String originalZipPath = args[0];
            String outputZipPath = args[1];

            FileInputStream fis = new FileInputStream(originalZipPath);
            byte[] originalData = fis.readAllBytes();
            fis.close();

            byte[] newData = new byte[originalData.length + 4];
            newData[0] = 0x50;
            newData[1] = 0x4b;
            newData[2] = 0x05;
            newData[3] = 0x06;

            System.arraycopy(originalData, 0, newData, 4, originalData.length);

            FileOutputStream fos = new FileOutputStream(outputZipPath);
            fos.write(newData);
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
