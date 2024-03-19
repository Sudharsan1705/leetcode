class FrequencyTracker {
   Map<Integer,Integer> map;
   Map<Integer,Integer> fre;
    public FrequencyTracker() {
        map = new HashMap<>();
        fre = new HashMap<>();
    }
    
    public void add(int number) {
        map.put(number,map.getOrDefault(number,0)+1);
        int f=map.get(number);
        fre.put(f,fre.getOrDefault(f,0)+1);
        fre.put(f-1,fre.getOrDefault(f-1,0)-1);
        if(fre.get(f-1)<=0){
            fre.remove(f-1);
        }
    }
    
    public void deleteOne(int number) {
        if(map.containsKey(number)){
        int f=map.get(number);
        fre.put(f,fre.getOrDefault(f,0)-1);
        fre.put(f-1,fre.getOrDefault(f-1,0)+1);
        if(fre.get(f)<=0){
            fre.remove(f);
        }
        }
        map.put(number,map.getOrDefault(number,0)-1);
        if(map.get(number) <= 0){
            map.remove(number);
        }
    }
    public boolean hasFrequency(int frequency) {

        return fre.containsKey(frequency);
    }
}

/**
 * Your FrequencyTracker object will be instantiated and called as such:
 * FrequencyTracker obj = new FrequencyTracker();
 * obj.add(number);
 * obj.deleteOne(number);
 * boolean param_3 = obj.hasFrequency(frequency);
 */