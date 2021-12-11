package models;

import javax.validation.constraints.*;

public class Tiger extends Cat {

    @PositiveOrZero(message = "Must be greater than 0 or 0!")
    private int numOfEatenEmployees;

    @Override
    public String toString() {
        return super.toString() + " NumOfEatenEmployees: "+ numOfEatenEmployees;
    }

    public static class Builder{

        private Tiger newTiger;

        public Builder(){
            newTiger = new Tiger();
        }

        public Builder addName(String name){
            newTiger.name = name;
            return this;
        }

        public Builder addWeight(double weight){
            newTiger.weight = weight;
            return this;
        }

        public Builder addAge(int age){
            newTiger.age = age;
            return this;
        }

        public Builder addColor(String color){
            newTiger.color = color;
            return this;
        }

        public Builder addCategory(String CATegory){
            newTiger.CATegory = Categories.valueOf(CATegory);
            return this;
        }

        public Builder addEatenEmployees(int eatenEmployee){
            newTiger.numOfEatenEmployees = eatenEmployee;
            return this;
        }

        public Tiger Build() {
            return newTiger;
        }
    }
}