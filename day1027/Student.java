package cn.itcast.day1027;

public class Student {

    private String name;
    private int score;

    @Override
    public String toString(){
        return String.format("(Student name = %s, Student score = %d)" , name, score);
    }

    public Student() {
    }

    public Student(String name, int score) {
        this.name = name;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }


    public static void main(String[] args) {
        Array<Student> stuArr = new Array<>(2);
        stuArr.add(0,new Student("Lary" ,100));
        stuArr.add(0,new Student("Jerry" ,88));
        stuArr.add(0,new Student("Ken" ,56));
        System.out.println(stuArr);

        stuArr.remove(1);
        System.out.println(stuArr);
        stuArr.remove(1);
        //stuArr.remove(0);

        System.out.println(stuArr);
    }
}
