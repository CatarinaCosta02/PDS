public class CakeMaster {

    private CakeBuilder cakeBuilder;
    public void setCakeBuilder(CakeBuilder cakeBuilder) {
        this.cakeBuilder = cakeBuilder;
    }

    // with just the message
    public void createCake(String m) {
        cakeBuilder.createCake();
        cakeBuilder.addMessage(m);
    }

    public Cake getCake() {
        return cakeBuilder.getCake();
    }

    // with the shape, number and message
    public void createCake(Shape shape, int i, String m) {

        cakeBuilder.setCakeShape(shape);
        this.createCake(i,m);

    }

    public void createCake(int i, String m) {

        // falta fazer o set das layers
        cakeBuilder.getCake().setNumCakeLayers(i);
        cakeBuilder.addMessage(m);
        cakeBuilder.createCake();
    }
}
