package ex03;


public class ViewableResult implements Viewable {
    @Override
    public ViewResult getView() {
        return new ViewResult();
    }
}
