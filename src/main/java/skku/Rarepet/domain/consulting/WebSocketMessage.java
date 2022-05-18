package skku.Rarepet.domain.consulting;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Objects;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class WebSocketMessage {

    private String from;
    private String type;
    private String data;
    private Object candidate;
    private Object sdp;

    public void setCandidate(final Object candidate){
        this.candidate = candidate;
    }

    public void setSdp(final Object sdp) {
        this.sdp = sdp;
    }

    @Override
    public int hashCode() {
        return Objects.hash(getFrom(),getType(),getData(),getCandidate(),getSdp());
    }

    @Override
    public String toString() {
        return "WebSocketMessage{" +
                "from='" + from + '\'' +
                ", type='" + type + '\'' +
                ", data='" + data + '\'' +
                ", candidate=" + candidate +
                ", sdp=" + sdp +
                '}';
    }
}
