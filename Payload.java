import java.util.Date;

public class Payload {
    public int _idProcess;
    public Date _timestamp;
    public String _criticalResource;
    public String _state;

    public Payload(int idProcess, Date timestamp, String criticalResource, String state){
        this._idProcess = idProcess;
        this._timestamp = timestamp;
        this._criticalResource = criticalResource;
        this._state = state;
    }

    @Override
    public String toString()
    {
        return _idProcess + "," + _timestamp;
    }
}
