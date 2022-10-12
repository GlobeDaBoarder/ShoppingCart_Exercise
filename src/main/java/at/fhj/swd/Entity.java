package at.fhj.swd;

public abstract class Entity implements XmlElement{
    private static int nextId;

    protected int getNextId() {
        return nextId;
    }

    protected static void setNextId(int nextId) {
        Entity.nextId = nextId;
    }

    @Override
    public String toXml() {
        return null;
    }
}
