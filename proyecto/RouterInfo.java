import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;

public class RouterInfo {
    public static void main(String[] args) {
        try {
            // Obtener todas las interfaces de red disponibles
            Enumeration<NetworkInterface> interfaces = NetworkInterface.getNetworkInterfaces();

            // Iterar sobre cada interfaz
            while (interfaces.hasMoreElements()) {
                NetworkInterface iface = interfaces.nextElement();

                // Verificar si la interfaz es una interfaz WiFi
                if (iface.isUp() && iface.getName().startsWith("w")) {
                    System.out.println("Nombre de interfaz: " + iface.getName());
                    System.out.println("Nombre de la interfaz de visualización: " + iface.getDisplayName());

                    // Obtener las direcciones IP asociadas con esta interfaz
                    Enumeration<InetAddress> addresses = iface.getInetAddresses();
                    while (addresses.hasMoreElements()) {
                        InetAddress addr = addresses.nextElement();
                        System.out.println("Dirección IP: " + addr.getHostAddress());
                    }
                }
            }
        } catch (SocketException e) {
            e.printStackTrace();
        }
    }
}

