public class SpongeCakeBuilder extends CakeBaseBuilder{

    @Override
    public void addCakeLayer() {
        this.getCake().setCakeLayer("Sponge");
    }

    @Override
    public void addCreamLayer() {
        this.getCake().setMidLayerCream(Cream.Chocolate);
    }

    @Override
    public void addTopLayer() {
        this.getCake().setTopLayerCream(Cream.Chocolate);
    }

    @Override
    public void addTopping() {

        this.getCake().setTopping(Topping.Chocolate);

    }
}
