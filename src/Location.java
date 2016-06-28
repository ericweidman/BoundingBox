/**
 * Created by ericweidman on 6/26/16.
 */
public class Location {

    double xValue;
    double yValue;
    double data;

    public Location() {
    }

    public Location(double xValue, double yValue, double data) {
        this.xValue = xValue;
        this.yValue = yValue;
        this.data = data;
    }

    public double getxValue() {
        return xValue;
    }

    public void setxValue(double xValue) {
        this.xValue = xValue;
    }

    public double getyValue() {
        return yValue;
    }

    public void setyValue(double vValue) {
        this.yValue = vValue;
    }

    public double getData() {
        return data;
    }

    public void setData(double data) {
        this.data = data;
    }
}
