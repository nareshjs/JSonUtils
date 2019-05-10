package nj.sample.json;

import com.fasterxml.jackson.annotation.JsonFilter;

public class Main {

    String a1 = "a1";
    int a2 = 2;

    public String getA1() {
        return a1;
    }

    public void setA1(String a1) {
        this.a1 = a1;
    }

    public int getA2() {
        return a2;
    }

    public void setA2(int a2) {
        this.a2 = a2;
    }

    public double getA3() {
        return a3;
    }

    public void setA3(double a3) {
        this.a3 = a3;
    }

    double a3 = 3.0;

    public Other getA4() {
        return a4;
    }

    public void setA4(Other a4) {
        this.a4 = a4;
    }

    Other a4 = new Other();
}
