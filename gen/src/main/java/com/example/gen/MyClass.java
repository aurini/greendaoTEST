package com.example.gen;

import org.greenrobot.greendao.generator.DaoGenerator;
import org.greenrobot.greendao.generator.Property;
import org.greenrobot.greendao.generator.Schema;
import org.greenrobot.greendao.generator.Entity;
import org.greenrobot.greendao.generator.ToMany;

public class MyClass {

    static Entity  food;
    public static void main(String[] args) {
        Schema schema = new Schema(1, "com.example.aurini.greendaotest.db"); // Your app package name and the (.db) is the folder where the DAO files will be generated into.
        schema.enableKeepSectionsByDefault();

        addTables(schema);

        try {
            new DaoGenerator().generateAll(schema, "./app/src/main/java");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

        private static void addTables ( final Schema schema){
            addUserEntities(schema);
            addArticleEntities(schema);
             addDiaryEntities(schema);
             addFoodEntities(schema);
             addFoodCatagoryEntities(schema);
         //    addMealEntities(schema);
            // addMealFoodEntities(schema);
            // addMoveEntities(schema);
            // addSyncLogEntities(schema);
            // addTaskEntities(schema);
             //addTaskTypeEntities(schema);
            // addWeightEntities(schema);
        }

   // private static Entity addMealEntities(Schema schema) {
  //  }

    private static Entity addFoodCatagoryEntities(Schema schema) {

        Entity food_cat=schema.addEntity("Food_Category");
        food_cat.addLongProperty("id");
        food_cat.addLongProperty("id_server");
        food_cat.addStringProperty("food_category_name");
        food_cat.addBooleanProperty("header_open");
       // Property addFoodEntities = food_cat.addLongProperty("category_id").notNull().getProperty();
        // set up a to-many relation to the orders entity from the customer entity
      ///  ToMany FoodToFoodCatagoryEntities =food.addToMany(food_cat,addFoodEntities );
       // FoodToFoodCatagoryEntities.setName("categoryfoods");
        return food_cat;
    }




    private static Entity addFoodEntities(Schema schema) {
        food =schema.addEntity("Food");
        food.addIdProperty();
        food.addLongProperty("id_server");
        food.addLongProperty(" category_id");
        food.addStringProperty(" desc");
        food.addStringProperty("absolute_name");
        food.addStringProperty("unit");
        food.addFloatProperty("increament_value");
        food.addFloatProperty("cal_per_unit_curb");
        food.addFloatProperty("cal_per_unit_protien");
        food.addFloatProperty("cal_per_unit_fat");
        food.addFloatProperty("cal_per_unit_total;");
        return food;
    }



    private static Entity addDiaryEntities(Schema schema) {

        Entity diary=schema.addEntity("Diary");
        diary.addIdProperty();
        diary.addLongProperty("id_server");
        diary.addStringProperty("user_id");
        diary.addStringProperty("note");
        diary.addBooleanProperty( "rg0");
        diary.addBooleanProperty( "rg1");
        diary.addBooleanProperty( "rg2");
        diary.addBooleanProperty( "rg3");
        diary.addBooleanProperty( "rg4");
        diary.addBooleanProperty( "rg5");
        diary.addBooleanProperty( "rg6");
        diary.addBooleanProperty( "rg7");
        diary.addBooleanProperty( "rg8");
        diary.addBooleanProperty( "rg9");
        diary.addStringProperty(" photoPath");
        diary.addStringProperty("photoLink");
        diary.addDateProperty("date");
        diary.addBooleanProperty("isSync");

        return diary;
    }

    private static Entity addArticleEntities(Schema schema) {

        Entity article = schema.addEntity("Article");
        article.addIdProperty();
        article.addLongProperty(" ariticle_id");
        article.addStringProperty("category");
        article.addStringProperty("text_comment");
        article.addStringProperty("img_link_server");
        article.addStringProperty("img_link_local");
        article.addIntProperty("week_id");
        article.addStringProperty("weblink");
        article.addBooleanProperty("show_enabled");
        return article;
    }



    // This is use to describe the colums of your table
        private static Entity addUserEntities( final Schema schema){

            Entity user = schema.addEntity("User");
            user.addIdProperty();
            user.addLongProperty("user_id").notNull();
            user.addStringProperty("token");
            user.addStringProperty("name");
            user.addStringProperty("email");
            user.addStringProperty("phone");
            user.addDateProperty("lmp");
            user.addStringProperty("photoPath");
            user.addStringProperty("photoLink");
            return user;
        }
    }


