import java.net.*;
import java.util.*;

public class ExchangeRateServer {
    private static String currentRates;
    private static long lastUpdateTime;

    public static void main(String[] args) throws Exception {
        DatagramSocket serverSocket = new DatagramSocket(9876);
        byte[] receiveData = new byte[1024];
        byte[] sendData;

        // Khởi tạo tỷ giá ban đầu
        updateExchangeRates();

        while (true) {
            DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
            serverSocket.receive(receivePacket);
            InetAddress clientAddress = receivePacket.getAddress();
            int clientPort = receivePacket.getPort();

            // Kiểm tra và cập nhật tỷ giá nếu cần
            if (System.currentTimeMillis() - lastUpdateTime > 1000) { // Cập nhật mỗi giây
                updateExchangeRates();
            }

            sendData = currentRates.getBytes();
            DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, clientAddress, clientPort);
            serverSocket.send(sendPacket);
        }
    }

    private static void updateExchangeRates() {
        Random rand = new Random();
        double tokyoRate = 100 + (200 - 100) * rand.nextDouble();
        double parisRate = 100 + (200 - 100) * rand.nextDouble();
        double seoulRate = 100 + (200 - 100) * rand.nextDouble();
        Date now = new Date();
        currentRates = String.format("Tokyo: %.2f, Paris: %.2f, Seoul: %.2f, Time: %s", tokyoRate, parisRate, seoulRate, now.toString());
        lastUpdateTime = System.currentTimeMillis();
    }
}
