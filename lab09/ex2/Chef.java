package ex2;

// handler class

public abstract class Chef {
    
    private Chef nextChef = null;

    public Chef setNextChef(Chef nextChef){
        this.nextChef = nextChef;
        return nextChef;
    }

    // recursive function on request handles
    public void handleRequest(String request){
        // if the chef can cook the request, then cook it
        if (canCook(request, this.getClass().getSimpleName())){
            this.handleRequest(request);
        }else{
            if(this.nextChef != null){
                this.nextChef.handleRequest(request);
            }
        }
    }

    protected boolean canCook(String request, String chef){
        return (request.contains(chef));
    }

    
}