package cse.minorproject.guidepath;


public class Bus {
    int _id;
    String _bus_no;
    String _city;
    String _first_stop;
    String _last_stop;
    String[] _bus_route;

    public Bus() {

    }

    public Bus(int _id, String _bus_no, String _city, String _first_stop, String _last_stop, String _bus_route) {
        this._id = _id;
        this._bus_no = _bus_no;
        this._city = _city;
        this._first_stop = _first_stop;
        this._last_stop = _last_stop;
        this._bus_route = _bus_route.split(",");
    }

    public int getID() {
        return this._id;
    }

    public void setID(int id) {
        this._id = id;
    }

    public String getBusNo() {
        return this._bus_no;
    }

    public void setBusNo(String busNo) {
        this._bus_no = busNo;
    }

    public String getCity() {
        return this._city;
    }

    public void setCity(String city) {
        this._city = city;
    }

    public String getFirstStop() {
        return this._first_stop;
    }

    public void setFirstStop(String FirstStop) {
        this._first_stop = FirstStop;
    }

    public String getLastStop() {
        return this._last_stop;
    }

    public void setLastStop(String LastStop) {
        this._last_stop = LastStop;
    }

    public String[] getRoute() {
        return _bus_route;
    }

    public void setRoute(String Route) {
        this._bus_route = Route.split(",");
    }
}
