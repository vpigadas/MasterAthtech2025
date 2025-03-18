package gr.athtech.course.network;

import com.google.gson.annotations.SerializedName;

import java.util.Objects;

public class DogJsonResponse {

    @SerializedName("message")
    private String url;

    @SerializedName("status")
    private String status;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DogJsonResponse that = (DogJsonResponse) o;
        return Objects.equals(url, that.url) && Objects.equals(status, that.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(url, status);
    }

    @Override
    public String toString() {
        return "DogJsonResponse{" +
                "url='" + url + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
