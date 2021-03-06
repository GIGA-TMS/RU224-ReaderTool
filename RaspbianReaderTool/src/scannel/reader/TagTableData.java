package scannel.reader;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class TagTableData {

    private StringProperty epc = new SimpleStringProperty(this, "epc");
    //	private StringProperty ascii = new SimpleStringProperty(this, "ascii");
    private IntegerProperty readCount = new SimpleIntegerProperty(this, "readCount");
    private IntegerProperty rssi = new SimpleIntegerProperty(this, "rssi");
    private StringProperty time = new SimpleStringProperty(this, "time");
    private IntegerProperty readFrequency = new SimpleIntegerProperty(this, "readFrequency");
    private StringProperty antennaId = new SimpleStringProperty(this, "antennaId");
    private StringProperty tid = new SimpleStringProperty(this, "tid");
    private StringProperty userBank = new SimpleStringProperty(this, "userBank");


    public TagTableData() {
        // TODO Auto-generated constructor stub
    }

    public void setEpc(String value) {
        epc.set(value);
    }

    public String getEpc() {
        return epc.get();
    }

    public StringProperty epcProperty() {
        return epc;
    }

//	public void setAscii(String value) {
//		ascii.set(value);
//	}
//	
//	public String getAscii() {
//		return ascii.get();
//	}
//	
//	public StringProperty asciiProperty() {
//		return ascii;
//	}

    public void setReadCount(int value) {
        readCount.set(value);
    }

    public void setRssi(int value) {
        rssi.set(value);
    }

    public int getRssi() {
        return rssi.get();
    }

    public IntegerProperty rssiProperty() {
        return rssi;
    }

    public int getReadCount() {
        return readCount.get();
    }

    public IntegerProperty readCountProperty() {
        return readCount;
    }

    public void setTime(String value) {
        time.set(value);
    }

    public String getTime() {
        return time.get();
    }

    public StringProperty timeProperty() {
        return time;
    }

    public void setReadFrequency(int value) {
        readFrequency.set(value);
    }

    public int getReadFrequency() {
        return readFrequency.get();
    }

    public IntegerProperty readFrequencyProperty() {
        return readFrequency;
    }

    public void setAntennaId(String value) {
        antennaId.set(value);
    }

    public String getAntennaId() {
        return antennaId.get();
    }

    public StringProperty antennaIdProperty() {
        return antennaId;
    }

    public void setTid(String value) {
        tid.set(value);
    }

    public String getTid() {
        return tid.get();
    }

    public StringProperty tidProperty() {
        return tid;
    }

    public void setUserBank(String value) {
        userBank.set(value);
    }

    public String getUserBank() {
        return userBank.get();
    }

    public StringProperty userBankProperty() {
        return userBank;
    }
}
