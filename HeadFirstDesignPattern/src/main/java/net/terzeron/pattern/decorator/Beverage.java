package net.terzeron.pattern.decorator;

public abstract class Beverage {
    String description = "제목 없음";

    Size size;
    
    public String getDescription() {
	return description;
    }

    public Size getSize() {
	return size;
    }

    public void setSize(Size size) {
	this.size = size;
    }

    public abstract double cost();
}