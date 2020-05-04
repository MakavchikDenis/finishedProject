package main.java.by.makavchik.ClassCollection;
import java.util.ArrayList;
import java.util.List;


public class GroupClass {
    private List<ClassPerson>group=new ArrayList<>();

    public GroupClass() {
        group.add(new ClassPerson("Nikita","Voronovich","voron@gmail.com"));
        group.add(new ClassPerson("Tom","Petrov","petr@gmail.com"));
        group.add(new ClassPerson("Valentin","Sidorov","sidorov@gmail.com"));
    };

    public List<ClassPerson> getGroup() {
        return group;
    };

    public void funAdd(ClassPerson ob){
        group.add(ob);
    };

}
