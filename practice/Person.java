package practice;

public class Person {
    private String name ;
    private String lastName ;
    private String gender;
    private int age ;

public Person(String name,String lastName,String gender,int age){

    this.name = name;
    this.lastName = lastName;
    this.gender = gender;
    this.age = age ;
    
}

public String setname(String name){
    return this.name;
}

public String getname(){
    return this.lastName;

}

public String setLastname(String lastName){
    return this.lastName;
}

public String getLastname(){
    return this.lastName;
}

public String setGender(String gender){
    return this.gender;
}
    

public String getGender(){
    return this.gender;
}


public int setAge(int age){
    return this.age;
}

public int getAge(){
    return this.age;
}


    @Override

public String toString(){
    return("name: " + name + "\nlastName: " + lastName + "\nGender: " + gender + "\nage: " + age


    );


}



}
