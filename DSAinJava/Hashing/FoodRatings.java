package DSAinJava.Hashing;
import java.util.*;
    public class FoodRatings {
        static class Pair{
            Integer key;
            String value;
            Pair(Integer key,String value){
                this.key=key;
                this.value=value;
            }

            public Integer getKey() {
                return key;
            }
            public String getValue(){
                return value;
            }
        }
        private final Map<String, Integer> foodRatingMap = new HashMap<>();
        private final Map<String, String> foodCuisineMap = new HashMap<>();
        private final Map<String, TreeSet<Pair>> cuisineFoodMap = new HashMap<>();

        public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
            for (int i = 0; i < foods.length; i++) {
                foodRatingMap.put(foods[i], ratings[i]);
                foodCuisineMap.put(foods[i], cuisines[i]);
                cuisineFoodMap.computeIfAbsent(cuisines[i], k -> new TreeSet<>((a, b) -> {
                            if (Objects.equals(a.getKey(), b.getKey())) {
                                // If ratings are equal, compare by food name (in ascending order).
                                return a.getValue().compareTo(b.getValue());
                            }
                            return Integer.compare(b.getKey(),a.getKey());
                        }))
                        .add(new Pair(ratings[i], foods[i]));
            }
        }

        public void changeRating(String food, int newRating) {
            String cuisineName = foodCuisineMap.get(food);
            TreeSet<Pair> cuisineSet = cuisineFoodMap.get(cuisineName);
            Pair oldElement = new Pair(foodRatingMap.get(food), food);
            cuisineSet.remove(oldElement);
            foodRatingMap.put(food, newRating);
            cuisineSet.add(new Pair(newRating, food));
        }

        public String highestRated(String cuisine) {
            Pair highestRated = cuisineFoodMap.get(cuisine).first();
            return highestRated.getValue();
        }
    }


