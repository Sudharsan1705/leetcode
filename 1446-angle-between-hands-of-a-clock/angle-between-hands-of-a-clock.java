class Solution {
    public double angleClock(int hour, int minutes) {
        double m = minutes/5.0;
        double h = (hour%12)+(minutes*0.5)/30;
        return Math.min(Math.abs(h-m)*30,360-(Math.abs(h-m)*30));
    }
}