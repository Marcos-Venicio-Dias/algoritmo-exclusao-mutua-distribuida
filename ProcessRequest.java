import java.util.Date;

public class ProcessRequest{

    private int _idProcess;
    private String _state;


    public ProcessRequest(int idProcess)
    {
        this._idProcess = idProcess;
        _state = "RELEASED";
    }


    public void sendResourceRequest(String resourceName)
    {
        Date date = new Date();
        Payload payload = new Payload(this._idProcess,date,resourceName,_state);
        String message = payload._idProcess + ";" + payload._criticalResource + ";" + payload._timestamp;
        MulticastContext multicast = new MulticastContext(this._idProcess);
        multicast.sendMessage(message);
    }

    
    public void recieveResourceRequest()
    {
        
    }
}
