public abstract class Set {
    private Domain domain;

    public abstract Set sum(Set set);
    public abstract Set multiply(Set set);

    public Domain getComplement() {
        return null;
    }
}
