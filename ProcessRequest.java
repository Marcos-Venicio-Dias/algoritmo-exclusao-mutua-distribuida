import java.util.Date;

public class ProcessRequest {

    private int _idProcess;
    private String _state;
    private MulticastContext _multicastContext;

    public ProcessRequest(int idProcess, MulticastContext multicastContext)
    {
        this._idProcess = idProcess;
        _state = "RELEASED";
        this._multicastContext = multicastContext;
    }


    public void sendResourceRequest(String resourceName)
    {
        Date date = new Date();
        Payload payload = new Payload(this._idProcess,date,resourceName,_state);
        String message = payload._idProcess + ";" + payload._criticalResource + ";" + payload._timestamp;
        _multicastContext.sendMessage(message);
    }

    public void onReceiveMessage(String message)
    {
        
    }
}
