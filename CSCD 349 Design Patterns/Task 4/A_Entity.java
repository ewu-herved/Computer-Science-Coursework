import java.util.*;
import java.awt.Point;

abstract class A_Entity {

    private String id;

    private A_Container parent = null;

    public A_Entity(String id) {
    
        if(id == "" || id == null)
           throw new NullPointerException("No id given\n");

        this.id = id;
    }

    public String getID() {

        return id;
    }

    public void setContainer(A_Container parent) {
    
        if(parent == null)
           throw new NullPointerException("No container given\n");

        this.parent = parent;
    }

    public void releaseContainer() {

        parent = null;
    }

    public boolean hasContainer() {

        if(parent != null)
            return true;

        return false;
    }

    public A_Container getContainer() {

        return parent;
    }

    abstract List<Point> update();

}
