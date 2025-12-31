import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.MulticastSocket;
import java.net.NetworkInterface;
import java.net.SocketAddress;

public class MulticastContext extends Thread{

    private MulticastSocket _socket;
    private static String _ipAdress = "230.0.0.0";
    private static int _port = 6000;
    private NetworkInterface _netIf;
    private SocketAddress _groupAdress;


    private void startUpMulticastSocket(int idProcess)
    {   
        try
        {

        this._socket = new MulticastSocket(null);
        this._socket.setReuseAddress(true);
        this._socket.bind(new InetSocketAddress(_port));
        
        InetAddress group = InetAddress.getByName(_ipAdress);
        this._netIf = NetworkInterface.getByInetAddress(InetAddress.getLocalHost());
        this._groupAdress = new InetSocketAddress(group,_port);
        
        this._socket.joinGroup(this._groupAdress,this._netIf);
        
        System.out.println("The process ("+ idProcess + ")entered the room");
            
        }catch(IOException error){
            System.out.println("Error to create a MulticastSocket instance");
        }
    }


    public void listenMessage()
    {
        Thread listener = new Thread( () -> 
        {
          while(true)
            {
                
            }  
        }
        );
        listener.start();
    }


    public void leaveRoom(int idProcess)
    {
        try
        {

            this._socket.leaveGroup(this._groupAdress,this._netIf);
            System.out.println("The process ("+idProcess+") left the room");
            
        }catch(IOException error)
        {
            System.out.println("Error to leave group");
        }
    }


    public void sendMessage(String message)
    {
        try
        {   

            byte[] bytes = message.getBytes();
            InetAddress address = InetAddress.getByName(_ipAdress);
            DatagramPacket packageToSend = new  DatagramPacket(bytes, bytes.length, address,_port);
            DatagramSocket multicastPool = new DatagramSocket();
            multicastPool.send(packageToSend);

        }catch(IOException error)
        {
            System.out.println("Error to send datagram package.");
        }
    }


    public MulticastContext(int idProcess)
    {
        this.startUpMulticastSocket(idProcess);
    }
}
