package furniture;

public class GrandFurnitureFactory implements FurnitureFactory {
    @Override
    public Chair createChair() {
        return new GrandChair();
    }

    @Override
    public Sofa createSofa() {
        return new GrandSofa();
    }
}
