package at.fhj.swd;

public abstract class Entity implements XmlElement{
    private static int nextId = 0;

    protected static int getNextId() {
        return nextId++;
    }

    protected static void setNextId(int nextId) {
        Entity.nextId = nextId;
    }

    @Override
    public String toXml() {
        return null;
    }
}
