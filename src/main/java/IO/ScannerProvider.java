//Yaniv Kaveh - Shtul : 206768004
//Elad Sztejnworcel : 204296495
package IO;

import java.util.Scanner;

public class ScannerProvider {
    private static Scanner SCANNER = new Scanner(System.in);

    public static Scanner getScanner() {
        return SCANNER;
    }
}

