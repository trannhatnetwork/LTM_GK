import java.net.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;

public class ExchangeRateClient {
    private static DefaultTableModel tableModel;

    public static void main(String[] args) throws Exception {
        JFrame frame = new JFrame("Exchange Rate Client");
        String[] columnNames = {"Time", "Tokyo", "Paris", "Seoul"};
        tableModel = new DefaultTableModel(columnNames, 0);
        JTable table = new JTable(tableModel);
        table.setFont(new Font("Arial", Font.PLAIN, 14)); // Đặt cỡ chữ 14
        table.setRowHeight(30);

        frame.add(new JScrollPane(table), BorderLayout.CENTER);
        frame.setSize(600, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null); // Hiển thị ở trung tâm màn hình
        frame.setVisible(true);

        Timer timer = new Timer(1000, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    updateExchangeRates();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });
        timer.start();
    }

    private static void updateExchangeRates() throws Exception {
        DatagramSocket clientSocket = new DatagramSocket();
        InetAddress IPAddress = InetAddress.getByName("localhost");
        byte[] sendData = new byte[1024];
        byte[] receiveData = new byte[1024];

        String request = "GET_RATES";
        sendData = request.getBytes();
        DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, 9876);
        clientSocket.send(sendPacket);

        DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
        clientSocket.receive(receivePacket);
        String response = new String(receivePacket.getData(), 0, receivePacket.getLength());
        String[] data = response.split(", ");

        String time = data[3].split(": ")[1];
        String tokyo = data[0].split(": ")[1];
        String paris = data[1].split(": ")[1];
        String seoul = data[2].split(": ")[1];

        tableModel.addRow(new Object[]{time, tokyo, paris, seoul});

        clientSocket.close();
    }
}
