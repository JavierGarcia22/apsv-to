package es.upm.dit.apsv.transportationorderserver.model;
import javax.persistence.Entity;
import javax.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import java.util.Objects;

@Entity
@Getter @Setter @NoArgsConstructor @ToString
public class TransportationOrder {  
    private String toid;
    @Id
    private String truck;
    private long originDate;
    private double originLat;
    private double originLong;
    private long dstDate;
    private double dstLat;
    private double dstLong;
    private long lastDate;
    private double lastLat;
    private double lastLong;
    private int st;

    public TransportationOrder(String toid, String truck, long originDate, double originLat, double originLong, long dstDate, double dstLat, double dstLong, long lastDate, double lastLat, double lastLong, int st) {
        this.toid = toid;
        this.truck = truck;
        this.originDate = originDate;
        this.originLat = originLat;
        this.originLong = originLong;
        this.dstDate = dstDate;
        this.dstLat = dstLat;
        this.dstLong = dstLong;
        this.lastDate = lastDate;
        this.lastLat = lastLat;
        this.lastLong = lastLong;
        this.st = st;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof TransportationOrder)) {
            return false;
        }
        TransportationOrder transportationOrder = (TransportationOrder) o;
        return Objects.equals(toid, transportationOrder.toid) && Objects.equals(truck, transportationOrder.truck) && originDate == transportationOrder.originDate && originLat == transportationOrder.originLat && originLong == transportationOrder.originLong && dstDate == transportationOrder.dstDate && dstLat == transportationOrder.dstLat && dstLong == transportationOrder.dstLong && lastDate == transportationOrder.lastDate && lastLat == transportationOrder.lastLat && lastLong == transportationOrder.lastLong && st == transportationOrder.st;
    }

    @Override
    public int hashCode() {
        return Objects.hash(toid, truck, originDate, originLat, originLong, dstDate, dstLat, dstLong, lastDate, lastLat, lastLong, st);
    }
    
    
    public double distanceToDestination() {
        return Math.sqrt(Math.pow(this.dstLat -this.lastLat, 2)
                    + Math.pow(this.dstLong - this.lastLong, 2));
    }
}