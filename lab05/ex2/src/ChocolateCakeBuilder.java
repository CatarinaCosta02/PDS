public class ChocolateCakeBuilder extends CakeBaseBuilder{

    @Override
    public void addCakeLayer() {
        this.getCake().setCakeLayer("Soft Chocolate");
    }

    @Override
    public void addCreamLayer() {
        this.getCake().setMidLayerCream(Cream.Vanilla);

    }

    @Override
    public void addTopLayer() {
        this.getCake().setTopLayerCream(Cream.Vanilla);

    }

    @Override
    public void addTopping() {
        this.getCake().setTopping(Topping.Chocolate);
    }
}
