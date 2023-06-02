import javax.lang.model.util.SimpleTypeVisitor14;

public class AllyAlwaysStrategy extends SimpleStrategy{
    
    public Move act() {
        return Move.ALLY;
    }

    public String toString() {
        return "AllyAlwaysStrategy";
    }
}
