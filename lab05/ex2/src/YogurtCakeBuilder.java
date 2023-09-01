public class YogurtCakeBuilder extends CakeBaseBuilder{

    @Override
    public void addCakeLayer() {
        this.getCake().setCakeLayer("Yogurt");
    }

    @Override
    public void addCreamLayer() {
        this.getCake().setMidLayerCream(Cream.Strawberries);
    }

    @Override
    public void addTopLayer() {
        this.getCake().setTopLayerCream(Cream.Strawberries);
    }

    @Override
    public void addTopping() {
        this.getCake().setTopping(Topping.Strawberries);
    }
}
