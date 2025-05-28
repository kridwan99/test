// File: ReceiptService.java
package deli.services;

import deli.models.Order;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ReceiptService {
    private static final String RECEIPT_FOLDER = "receipts";

    public static void saveReceipt(Order order) {
        try {
            File folder = new File(RECEIPT_FOLDER);
            if (!folder.exists()) {
                folder.mkdirs();
            }

            String timestamp = LocalDateTime.now()
                    .format(DateTimeFormatter.ofPattern("yyyyMMdd-HHmmss"));
            String filename = RECEIPT_FOLDER + "/" + timestamp + ".txt";

            try (FileWriter writer = new FileWriter(filename)) {
                writer.write(order.getReceiptText());
            }

            System.out.println("Receipt saved to " + filename);
        } catch (IOException e) {
            System.err.println("Error saving receipt: " + e.getMessage());
        }
    }
}