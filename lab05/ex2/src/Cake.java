public class Cake {
    private Shape shape;
    private String cakeLayer;
    private int numCakeLayers;
    private Cream midLayerCream;
    private Cream topLayerCream;
    private Topping topping;
    private String message;

    public void setShape(Shape shape) {
        this.shape = shape;
    }

    public String getCakeLayer() {
        return cakeLayer;
    }

    public void setCakeLayer(String cakeLayer) {
        this.cakeLayer = cakeLayer;
    }

    public void setMessage(String m) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public Cream getMidLayerCream() {
        return this.midLayerCream;
    }

    public void setMidLayerCream(Cream midLayerCream) {
        this.midLayerCream = midLayerCream;
    }

    public int getNumCakeLayers() {
        return numCakeLayers;
    }

    public void setNumCakeLayers(int numCakeLayers) {
        this.numCakeLayers = numCakeLayers;
    }

    public Shape getShape() {
        return shape;
    }

    public Cream getTopLayerCream() {
        return topLayerCream;
    }

    public void setTopLayerCream(Cream topLayerCream) {
        this.topLayerCream = topLayerCream;
    }

    public Topping getTopping() {
        return topping;
    }

    public void setTopping(Topping topping) {
        this.topping = topping;
    }

    @Override
    public String toString() {
        return String.format("%s cake with %d layers%s, topped with %s cream and %s. Message says: \"%s\".",
                this.getCakeLayer(), this.getNumCakeLayers(),
                (this.midLayerCream != null) ? String.format(" and %s cream", this.midLayerCream) : "", this.getTopLayerCream(),
                this.getTopping(), this.getMessage());
    }

}
