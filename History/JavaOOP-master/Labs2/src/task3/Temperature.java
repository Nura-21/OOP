package task3;

public class Temperature {
	private double value;
	private Scale scale = Scale.C;
	
	public Temperature() {
		
	}
	public Temperature(double value) {
		this.value = value;
	}
	public Temperature(Scale scale) {
		this.scale = scale;
	}
	public Temperature(double value,Scale scale) {
		this.value = value;
		this.scale = scale;
	}
	
    String getC() {
    	double ans = (this.value-32)*((double)5/9);
		if (this.scale == Scale.F)
			return String.valueOf(ans) + " C";
		return String.valueOf(this.value) + " C";     	
    }
    
    String getF() {
    	double ans = (this.value*((double)9/5))+32;
		if (this.scale == Scale.C)
			return String.valueOf(ans) + " F";
		return String.valueOf(this.value) + " F";
    }
    Scale getScale() {
    	return this.scale;
    }
    void setData(double value) {
    	this.value = value;
    }
    void setData(Scale scale) {
    	this.scale = scale;
    }
    void setData(double value,Scale scale) {
    	setData(value);
    	setData(scale);
    }
    
}	
