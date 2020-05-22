package effectiveJava.charpter02;

public class NutritionFacts {
    private  int servingSize = 0;
    private  int servings = 0;
    private  int calories = 0;
    private  int fat = 0;
    private  int sodium = 0;
    private int carbohydrate = 0;
    public NutritionFacts(int servingSize,int servings){
        this(servingSize,servings,0);
    }
    public NutritionFacts(int servingSize,int servings,int calories){
        this(servingSize,servings,calories,0,0,0);
    }
    public NutritionFacts(int servingSize,int servings,int calories,int fat,int sodium,
                          int carbohydrate){
        this.servingSize = servingSize;
        this.servings = servings;
        this.calories = calories;
        this.fat = fat;
        this.sodium = sodium;
        this.carbohydrate = carbohydrate;
    }
}
