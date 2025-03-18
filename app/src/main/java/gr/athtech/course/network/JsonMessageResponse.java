package gr.athtech.course.network;

import java.util.Arrays;
import java.util.Objects;

public class JsonMessageResponse {

    private String[] australian;
    private String[] bakharwal;
    private String[] bulldog;
    private String[] bullterrier;

    public String[] getAustralian() {
        return australian;
    }

    public void setAustralian(String[] australian) {
        this.australian = australian;
    }

    public String[] getBakharwal() {
        return bakharwal;
    }

    public void setBakharwal(String[] bakharwal) {
        this.bakharwal = bakharwal;
    }

    public String[] getBulldog() {
        return bulldog;
    }

    public void setBulldog(String[] bulldog) {
        this.bulldog = bulldog;
    }

    public String[] getBullterrier() {
        return bullterrier;
    }

    public void setBullterrier(String[] bullterrier) {
        this.bullterrier = bullterrier;
    }

    @Override
    public String toString() {
        return "JsonMessageResponse{" +
                "australian=" + Arrays.toString(australian) +
                ", bakharwal=" + Arrays.toString(bakharwal) +
                ", bulldog=" + Arrays.toString(bulldog) +
                ", bullterrier=" + Arrays.toString(bullterrier) +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        JsonMessageResponse that = (JsonMessageResponse) o;
        return Objects.deepEquals(australian, that.australian) && Objects.deepEquals(bakharwal, that.bakharwal) && Objects.deepEquals(bulldog, that.bulldog) && Objects.deepEquals(bullterrier, that.bullterrier);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Arrays.hashCode(australian), Arrays.hashCode(bakharwal), Arrays.hashCode(bulldog), Arrays.hashCode(bullterrier));
    }
}
