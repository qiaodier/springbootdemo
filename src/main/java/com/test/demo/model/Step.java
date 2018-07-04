package com.test.demo.model;

public class Step {
    private String timestamp;
    private String step;


    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getStep() {
        return step;
    }

    public void setStep(String step) {
        this.step = step;
    }

    @Override
    public String toString() {
        return "Step{" +
                "timestamp='" + timestamp + '\'' +
                ", step='" + step + '\'' +
                '}';
    }
}
