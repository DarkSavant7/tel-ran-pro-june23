package de.telran.practice.lectures.oop;

public class Farm {

  public static void main(String[] args) {
//    Cat cat = new Cat("Barsik", "Black");
//    cat.move();
//    cat.voice();
//    Dog dog = new Dog("Bobik", "Red");
//    dog.move();
//    dog.voice();
//    Bird bird = new Bird("Chizhik", "Grey");
//    bird.move();
//    bird.voice();
    System.out.println("Creating random animals:");
    Cat someCat = new Cat("Some", "Some");
    Animal someAnimal = new Cat("Some", "Some");
    Object someObject = new Cat("Some", "Some");
//    Animal abs = new Animal("Some", "Some", "SOme");

    System.out.println();
    System.out.println("Creating array with animals");
    Animal[] animals = {
        new Cat("Barsik", "Black"),
        new Dog("Bobik", "Red"),
        new Bird("Chizhik", "Grey"),
        new Cat("Murzik", "White"),
        new Bird("Tuco", "Yellow"),
        new Snake("Kaa", "Green"),
        new Parrot("Kesha", "Blue"),
        new Animal("Anon", "Black", "Unknown") {
          private String some;
          @Override
          public void voice() {
            System.out.println("Unknown");
          }
           public void doSomething() {

           }
        },
        new Animal("Anon2", "Black", "Unknown") {
          @Override
          public void voice() {
            System.out.println("Unknown2");
          }
        }
    };

    System.out.println("\nRun loop:");
    for (int i = 0; i < animals.length; i++) {
      animals[i].move();
      animals[i].voice();
//      if (animals[i] instanceof Bird){
//        ((Bird) animals[i]).fly();
//      }
      if (animals[i] instanceof Bird bird){
        bird.fly();
      }
      if (animals[i] instanceof Parrot parrot) {
        parrot.speak();
      }
      System.out.println(animals[i].getClass().getName());
    }
  }
}
