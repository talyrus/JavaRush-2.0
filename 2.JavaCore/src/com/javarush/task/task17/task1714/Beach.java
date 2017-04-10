package com.javarush.task.task17.task1714;

/* 
Comparable
*/

public class Beach implements Comparable <Beach> {
    private String name;      //название
    private float distance;   //расстояние
    private int quality;    //качество

    @Override
    public synchronized int compareTo(Beach b) {
        int dist = (int) (distance - b.getDistance());
        int qual = quality - b.getQuality();
        if( (quality > b.getQuality() && distance <= b.getDistance()) || (quality == b.getQuality() && distance < b.getDistance()) ){
            return dist + qual;
        }

        if( quality == b.getQuality() && distance == b.getDistance() ){
            return 0;
        }
        return -(dist + qual);
    }

    public  Beach(String name, float distance, int quality) {
        this.name = name;
        this.distance = distance;
        this.quality = quality;
    }

    public synchronized String getName() {
        return name;
    }

    public synchronized void setName(String name) {
        this.name = name;
    }

    public synchronized float getDistance() {
        return distance;
    }

    public synchronized void setDistance(float distance) {
        this.distance = distance;
    }

    public synchronized int getQuality() {
        return quality;
    }

    public synchronized void setQuality(int quality) {
        this.quality = quality;
    }

    public static void main(String[] args) {
        /*Beach beach1 = new Beach("beach1", 123.6f, 7);
        //очевидно, что пляжи не одинаковые, так как же их отсортировать от лучшего к худшему
        Beach beach2 = new Beach("beach2", 124.6f, 8);
        Beach beach3 = new Beach("beach3", 124.6f, 8);
        System.out.println(" пляж 1 = " + beach1.compareTo(beach2));
        System.out.println();
        System.out.println(" пляж 2 = " + beach1.compareTo(beach3));
        System.out.println();
        System.out.println(" пляж 3 = " + beach2.compareTo(beach3));*/

    }
}
