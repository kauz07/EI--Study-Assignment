package furniture;

public class FurnitureFactoryProducer {
    public static FurnitureFactory getFactory(String style) {
        if (style.equalsIgnoreCase("GRAND")) {
            return new GrandFurnitureFactory();
        } else if (style.equalsIgnoreCase("MODERN")) {
            return new ModernFurnitureFactory();
        }
        return null;
    }
}
